package usuario.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import usuario.api.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	  Usuario findByEmail(String email);
}
