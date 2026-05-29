package finlance_api.service;

import finlance_api.domain.Usuario;
import finlance_api.dto.UsuarioRespostaDTO;
import finlance_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario novoUsuario) {
        if(usuarioRepository.existsByEmail(novoUsuario.getEmail())) {
            throw  new RuntimeException("Email já está em uso por outro freelancer");
        }

        novoUsuario.setEmail(novoUsuario.getEmail().toLowerCase());

        return usuarioRepository.save(novoUsuario);
}
private void validarForcaDaSenha(String senha) {
        if (senha == null || senha.length() < 8) {
            throw new RuntimeException("A senha deve ter pelo menos 8 caracteres.");
        }
        
        // Verifica se tem pelo menos uma letra maiúscula [A-Z]
        if (!senha.matches(".*[A-Z].*")) {
            throw new RuntimeException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        
        // Verifica se tem pelo menos uma letra minúscula [a-z]
        if (!senha.matches(".*[a-z].*")) {
            throw new RuntimeException("A senha deve conter pelo menos uma letra minúscula.");
        }
        
        // Verifica se tem pelo menos um número [0-9]
        if (!senha.matches(".*[0-9].*")) {
            throw new RuntimeException("A senha deve conter pelo menos um número.");
        }
        
        // Verifica se tem pelo menos um caractere especial
        if (!senha.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new RuntimeException("A senha deve conter pelo menos um caractere especial (ex: @, #, $).");
        }
    }
    public List<UsuarioRespostaDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioRespostaDTO::new)
                .collect(Collectors.toList());
    }
}
