package com.Backend.Inmobiliaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Backend.Inmobiliaria.Repository.UsuarioRepo;
import com.Backend.Inmobiliaria.model.Usuario;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepo usuRepo;
	
	@GetMapping("/listaUsuarios")
	public List<Usuario> listarUsuarios(){
		return usuRepo.findAll();
	}
	
	@GetMapping({"/login"})
	public Usuario login(@RequestParam String nombre, @RequestParam String pass) {
		Usuario usu = usuRepo.verificaCuenta(nombre, pass);
		return usu;
	}
	
	@PostMapping("/crearUsuario")
	public Usuario crearUsuario (@RequestBody Usuario usu) {
	    return usuRepo.save(usu);
	}
	
	@PutMapping("/modUsuario")
	public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usu){
		usu.setNom_usu(usu.getNom_usu());
		usu.setPass_usu(usu.getPass_usu());
		
		Usuario usuMod = usuRepo.save(usu);
		return ResponseEntity.ok(usuMod);	
	}
	
	@PutMapping("/modEstadoUsuario")
	public ResponseEntity<Usuario> modEstadoUsuario(@RequestBody Usuario usu){
		usu.setActivo_usu(!usu.isActivo_usu());
		
		Usuario usuMod = usuRepo.save(usu);
		return ResponseEntity.ok(usuMod);	
	}
	
	@PutMapping("/modRolUsuario")
	public ResponseEntity<Usuario> modUsuarioRol(@RequestBody Usuario usu){
		usu.setRol(usu.getRol());
		
		Usuario usuMod = usuRepo.save(usu);
		return ResponseEntity.ok(usuMod);	
	}
}
