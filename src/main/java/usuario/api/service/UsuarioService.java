package usuario.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usuario.api.model.Usuario;
import usuario.api.repository.UsuarioRepository;


@Service
public class UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        // Aqui você pode adicionar lógica adicional antes de salvar o usuário,
        // como criptografar a senha, validar os dados do usuário, etc.
        return repository.save(usuario);
    }

    public Usuario autenticarUsuario(Usuario usuario) {
        // Aqui você pode adicionar a lógica para autenticar o usuário.
        // Isso pode envolver a busca do usuário no banco de dados pelo nome de usuário,
        // a comparação da senha fornecida com a senha armazenada (depois de descriptografá-la, se necessário), etc.
        Usuario usuarioEncontrado = repository.findByEmail(usuario.getEmail());
        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
    }
}
