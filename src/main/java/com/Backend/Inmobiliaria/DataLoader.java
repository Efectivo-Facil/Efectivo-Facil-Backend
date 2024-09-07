package com.Backend.Inmobiliaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Backend.Inmobiliaria.Repository.EncargadoRepo;
import com.Backend.Inmobiliaria.Repository.MenuRepository;
import com.Backend.Inmobiliaria.Repository.PersonaRepo;
import com.Backend.Inmobiliaria.Repository.RolRepository;
import com.Backend.Inmobiliaria.Repository.UsuarioRepo;
import com.Backend.Inmobiliaria.model.Encargado;
import com.Backend.Inmobiliaria.model.Menu;
import com.Backend.Inmobiliaria.model.Persona;
import com.Backend.Inmobiliaria.model.Rol;
import com.Backend.Inmobiliaria.model.Usuario;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private RolRepository rolRepo;
    
    @Autowired
    private MenuRepository meRepo;
    
    @Autowired
    private UsuarioRepo usuRepo;
    
    @Autowired
    private EncargadoRepo encRepo;

    @Autowired
    private PersonaRepo perRepo;
    
    @PostConstruct
    public void loadData() {
    	
    	/*
    	List<Menu> menus = new ArrayList<Menu>();
    	List<Menu> menus2 = new ArrayList<Menu>();
    	Menu menu1 = new Menu();
    	menu1.setId_me(1);
    	menu1.setNombre_me("Inicio");
    	menu1.setUrl_me("/inicio");
    	menu1.setActivo_me(true);
    	meRepo.save(menu1);
    	menus.add(menu1);
    	menus2.add(menu1);
    	
    	Menu menu2 = new Menu();
    	menu2.setId_me(2);
    	menu2.setNombre_me("Empeños");
    	menu2.setUrl_me("/empenios");
    	menu2.setActivo_me(true);
    	meRepo.save(menu2);
    	menus.add(menu2);
    	menus2.add(menu2);
    	
    	Menu menu3 = new Menu();
    	menu3.setId_me(3);
    	menu3.setNombre_me("Desempeños");
    	menu3.setUrl_me("/desempenios");
    	menu3.setActivo_me(true);
    	meRepo.save(menu3);
    	menus.add(menu3);
    	menus2.add(menu3);
    	
    	Menu menu4 = new Menu();
    	menu4.setId_me(4);
    	menu4.setNombre_me("Configuraciones");
    	menu4.setUrl_me("/configuraciones");
    	menu4.setActivo_me(true);
    	meRepo.save(menu4);
    	menus.add(menu4);
    	
    	Menu menu5 = new Menu();
    	menu5.setId_me(5);
    	menu5.setNombre_me("Compras");
    	menu5.setUrl_me("/compras");
    	menu5.setActivo_me(true);
    	meRepo.save(menu5);
    	menus.add(menu5);
    	menus2.add(menu5);
    	
    	Menu menu6 = new Menu();
    	menu6.setId_me(6);
    	menu6.setNombre_me("Ventas");
    	menu6.setUrl_me("/ventas");
    	menu6.setActivo_me(true);
    	meRepo.save(menu6);
    	menus.add(menu6);
    	menus2.add(menu6);
    	
    	Menu menu7= new Menu();
    	menu7.setId_me(7);
    	menu7.setNombre_me("Recargas");
    	menu7.setUrl_me("/recargas");
    	menu7.setActivo_me(true);
    	meRepo.save(menu7);
    	menus.add(menu7);
    	menus2.add(menu7);
    	
    	Menu menu8= new Menu();
    	menu8.setId_me(8);
    	menu8.setNombre_me("Remates");
    	menu8.setUrl_me("/remates");
    	menu8.setActivo_me(true);
    	meRepo.save(menu8);
    	menus.add(menu8);
    	menus2.add(menu8);

    	Menu menu9= new Menu();
    	menu9.setId_me(9);
    	menu9.setNombre_me("Aportes y gastos");
    	menu9.setUrl_me("/aportesygastos");
    	menu9.setActivo_me(true);
    	meRepo.save(menu9);
    	menus.add(menu9);
    	
    	Menu menu10= new Menu();
    	menu10.setId_me(10);
    	menu10.setNombre_me("Clientes");
    	menu10.setUrl_me("/clientes");
    	menu10.setActivo_me(true);
    	meRepo.save(menu10);
    	menus.add(menu10);
    	menus2.add(menu10);
    	
    	Menu menu11= new Menu();
    	menu11.setId_me(11);
    	menu11.setNombre_me("Calendario");
    	menu11.setUrl_me("/calendario");
    	menu11.setActivo_me(true);
    	meRepo.save(menu11);
    	menus.add(menu11);
    	menus2.add(menu11);
    	
    	Menu menu12 = new Menu();
    	menu12.setId_me(12);
    	menu12.setNombre_me("Configuraciones");
    	menu12.setUrl_me("/configuracionesUsuario");
    	menu12.setActivo_me(true);
    	meRepo.save(menu12);
    	menus2.add(menu12);
    	
    	Rol rol1 = new Rol();
    	rol1.setId_rol(1);
    	rol1.setNombre_rol("Administrador");
    	rol1.setActivo_rol(true);
    	rol1.setMenus(menus);
    	rolRepo.save(rol1);
    	
    	Rol rol2 = new Rol();
    	rol2.setId_rol(2);
    	rol2.setNombre_rol("Usuario");
    	rol2.setActivo_rol(true);
    	rol2.setMenus(menus2);
    	rolRepo.save(rol2);
    	
    	Usuario usuario = new Usuario();
    	Encargado enc = new Encargado();
    	Persona per = new Persona();
    	
        per.setId_per(10);
        per.setNombres_per("ADMINISTRADOR");
        per.setPrimer_ap("-");
        per.setSegundo_ap("");
        per.setCi("0000");
        per.setCi_expedido("TJA");
        per.setCelular_per(0000);
        
        // Persistir Persona
        perRepo.save(per);
        
        
        // Configuración de Encargado
        enc.setId_enc(10);
        enc.setFecha_ing(new Date());
        enc.setPersona(per);
        
        // Persistir Encargado
        encRepo.save(enc);
        
        // Configuración de Usuario
        usuario.setId_usu(9);
        usuario.setNom_usu("ADMIN");
        usuario.setPass_usu("ADMIN");
        usuario.setActivo_usu(true);
        usuario.setEncargado(enc); // Aquí utilizamos la entidad ya gestionada
        usuario.setRol(rol1);
        
        // Persistir Usuario
        usuRepo.save(usuario);
        
        Persona per2 = new Persona();
    	*/
    }
}