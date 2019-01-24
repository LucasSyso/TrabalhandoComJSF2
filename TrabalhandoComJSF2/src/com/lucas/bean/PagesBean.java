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
	//Outra forma de trabalharmos com o Flash, é usando o recurso de injeção de dependências. 
	@Inject
	Flash flash;

	/*
	 
	 	Por padrão, o JSF trabalha com o Forward, neste tipo, ao ser clicado o botão, 
	 	a requisição ainda existe, por isso este objeto também existe.
	   
	 */
	public String processar() {
		//Como na forma redirect as informações se perdem durante a navegação, iremos utilizar o FLASH para recuperá-las
//		Flash flash = FacesContext.getCurrentInstance()
//					  .getExternalContext()
//					  .getFlash();
		flash.put("nomeUsuario", nome);//Aqui, o valor digitado pelo usuário será guardado em uma área de memória chamada Flash.
		
		return "index2?faces-redirect=true";//Forma de forçar o JSF a trabalhar com o tipo redirect
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
