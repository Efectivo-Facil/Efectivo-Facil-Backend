package com.Backend.Inmobiliaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	@Query(value = "select * from usuario where nom_usu=?1 and pass_usu=?2", nativeQuery = true)
	Usuario verificaCuenta(String login, String passwd);
	
	@Query("SELECT u FROM Usuario u WHERE u.id_usu != :id")
	List<Usuario> findAllExcept(@Param("id") int id);
}
