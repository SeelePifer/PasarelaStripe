package com.stripe.stripe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stripe.stripe.model.Articulo;
import com.stripe.stripe.repository.ArticuloRepository;

@Service
@Transactional(readOnly = true)
public class ArticuloService {

	@Autowired
	ArticuloRepository articuloRepository;
	
	public List<Articulo> listar(){
		List<Articulo> articulos = articuloRepository.findAll();
		return articulos;
	}
	public Optional<Articulo> getArticleById(long id){
		return articuloRepository.findById(id);
	}
	public boolean articleExistsById(long id) {
		return articuloRepository.existsById(id);
	}
}
