package br.com.rcunha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.rcunha.services.PersonServices;

@RestController
public class PersonController
{
	@Autowired
	private PersonServices service;
	
}