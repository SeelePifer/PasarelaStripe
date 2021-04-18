package com.stripe.stripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.stripe.http.Mensaje;
import com.stripe.stripe.model.Articulo;
import com.stripe.stripe.service.ArticuloService;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticuloController {

	@Autowired
	ArticuloService articuloService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Articulo>> list(){
		List<Articulo> lista = articuloService.listar();
		return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Articulo> detail(@PathVariable("id") long id){
		if(!articuloService.articleExistsById(id))
			return new ResponseEntity<Articulo>((MultiValueMap<String, String>) new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Articulo articulo = articuloService.getArticleById(id).get();
		return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}
	
}
