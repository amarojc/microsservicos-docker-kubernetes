package com.amaro.microsservices.exception.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microsservices.dtos.ErrorDTO;
import br.com.microsservices.exception.UserNotFoundException;

//Classe será executada sempre que uma exceção for lançada, identificando o retorno em todos os controllers.
@ControllerAdvice(basePackages = "com.amaro.microsservices.controller")
public class UserControllerAdvice {

	@ResponseBody //Retorna o erro no corpo da resposta
	@ResponseStatus(HttpStatus.NOT_FOUND) // Return 404...
	@ExceptionHandler(UserNotFoundException.class) //Capturando o tipo da exceção
	public ErrorDTO handlerUserNotFound(UserNotFoundException exception) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Usuário informado não localizado!");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
}
