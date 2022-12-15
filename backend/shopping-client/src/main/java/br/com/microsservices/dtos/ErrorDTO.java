package br.com.microsservices.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
//Classe será utilizada para enviar as menssagens de erros personalizadas, nos serviços.
public class ErrorDTO {

	private Integer status;
	private String message;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
	private Date timestamp;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}