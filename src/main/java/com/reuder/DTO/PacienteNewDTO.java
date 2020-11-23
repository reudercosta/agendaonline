package com.reuder.DTO;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.reuder.service.validation.PacienteInsert;

@PacienteInsert
public class PacienteNewDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	@Email(message = "Email inválido!")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	private String rgOuCpf;
	
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	private String email;
	
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	private String senha;
	
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	private String telefone;
	
	@NotEmpty(message = "Preenchimento Obrigatório!!")
	private String endereço;
	
	public PacienteNewDTO() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRgOuCpf() {
		return rgOuCpf;
	}
	public void setRgOuCpf(String rgOuCpf) {
		rgOuCpf = rgOuCpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereço() {
		return endereço;
	}
	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}
	
}
