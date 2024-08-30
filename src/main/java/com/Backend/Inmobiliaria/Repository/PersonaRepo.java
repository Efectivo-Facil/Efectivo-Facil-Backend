package com.Backend.Inmobiliaria.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Persona;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long> {

	 List<Persona> findByCi(String ci);
	 
}
