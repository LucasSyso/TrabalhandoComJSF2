package com.lucas.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
//import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PagesBean implements Serializable{
	private String nome;
	//Outra forma de trabalharmos com o Flash, � usando o recurso de inje��o de depend�ncias. 
	@Inject
	Flash flash;

	/*
	 
	 	Por padr�o, o JSF trabalha com o Forward, neste tipo, ao ser clicado o bot�o, 
	 	a requisi��o ainda existe, por isso este objeto tamb�m existe.
	   
	 */
	public String processar() {
		//Como na forma redirect as informa��es se perdem durante a navega��o, iremos utilizar o FLASH para recuper�-las
//		Flash flash = FacesContext.getCurrentInstance()
//					  .getExternalContext()
//					  .getFlash();
		flash.put("nomeUsuario", nome);//Aqui, o valor digitado pelo usu�rio ser� guardado em uma �rea de mem�ria chamada Flash.
		
		return "index2?faces-redirect=true";//Forma de for�ar o JSF a trabalhar com o tipo redirect
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
