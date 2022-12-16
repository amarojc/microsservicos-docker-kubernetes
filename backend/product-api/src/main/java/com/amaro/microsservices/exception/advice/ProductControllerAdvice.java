package com.amaro.microsservices.exception.advice;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.microsservices.dtos.ErrorDTO;
import br.com.microsservices.exception.CategoryNotFoundException;
import br.com.microsservices.exception.ProductNotFoundException;

@ControllerAdvice(basePackages = "com.amaro.microsservices.controller")
public class ProductControllerAdvice {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handlerProductNotFound(ProductNotFoundException exception) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Produto informado não localizado!");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CategoryNotFoundException.class)
	public ErrorDTO handlerCategoryNotFound(CategoryNotFoundException exception) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Categoria não localizada");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDTO.setMessage(messageError(ex).toString());
		errorDTO.setTimestamp(new Date());
		
		return errorDTO;
	}
	
	private StringBuilder messageError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		StringBuilder sb = new StringBuilder();
		
		int cont = 0;
		
		if(fieldErrors.size() > 1) {
			sb.append("Valores inválidos para os campos: ");
			sb.append("");
		}else {
			sb.append("Valor inválido para o campo: ");
			cont = -1;
		}
		
		sb.append(validationErros(fieldErrors, cont));
		
		return sb;
	}
	
	private StringBuilder validationErros(List<FieldError> fieldErrors, int cont) {
		int sizeList = fieldErrors.size();
		StringBuilder sb = new StringBuilder();
		
		for (FieldError fieldError : fieldErrors) {
			cont ++;
			if(cont > 1 && sizeList != cont) {
					sb.append(",  "); 
			}
			if(cont == sizeList) {
				sb.append(" e ");
				sb.append(fieldError.getField());
			}else {
				sb.append(fieldError.getField());
			}
		}
		return sb;
	}
}
