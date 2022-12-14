package com.amaro.microsservices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.microsservices.dtos.UserDTO;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private String key;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	public User() {
	}

	public User(Long id, String nome, String cpf, String endereco, String email, String telefone, String key,
			Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.key = key;
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", dataCadastro=");
		builder.append(", key=");
		builder.append(key);
		builder.append(dataCadastro);
		builder.append("]");
		return builder.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setNome(userDTO.getNome());
		user.setEndereco(userDTO.getEndereco());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setTelefone(userDTO.getTelefone());
		user.setKey(userDTO.getKey());
		user.setDataCadastro(userDTO.getDataCadastro());

		return user;
	}

}
