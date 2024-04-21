package usuario.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usuario.api.model.Usuario;
import usuario.api.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository repository;

    
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
       
        return repository.save(usuario);
    }

    public Usuario autenticarUsuario(Usuario usuario) {
       
        Usuario usuarioEncontrado = repository.findByEmail(usuario.getEmail());
        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
    }
}
