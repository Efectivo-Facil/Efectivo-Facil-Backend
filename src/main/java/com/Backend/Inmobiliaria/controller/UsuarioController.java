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
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> usuarios = usuRepo.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String nombre, @RequestParam String pass) {
        try {
            Usuario usu = usuRepo.verificaCuenta(nombre, pass);
            if (usu != null) {
                return ResponseEntity.ok(usu);
            } else {
                return ResponseEntity.status(404).body(null); // Devuelve 404 si no se encuentra el usuario
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usu) {
        try {
            Usuario nuevoUsuario = usuRepo.save(usu);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/modUsuario")
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usu) {
        try {
            usu.setPass_usu(usu.getEncargado().getPersona().getCi());
            Usuario usuMod = usuRepo.save(usu);
            return ResponseEntity.ok(usuMod);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/modEstadoUsuario")
    public ResponseEntity<Usuario> modEstadoUsuario(@RequestBody Usuario usu) {
        try {
            usu.setActivo_usu(!usu.isActivo_usu());
            Usuario usuMod = usuRepo.save(usu);
            return ResponseEntity.ok(usuMod);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/modRolUsuario")
    public ResponseEntity<Usuario> modUsuarioRol(@RequestBody Usuario usu) {
        try {
            Usuario usuMod = usuRepo.save(usu);
            return ResponseEntity.ok(usuMod);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
