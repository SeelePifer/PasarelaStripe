package com.stripe.stripe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stripe.stripe.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
	
}
