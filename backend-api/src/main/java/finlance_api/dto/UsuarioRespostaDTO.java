package finlance_api.dto;

import finlance_api.domain.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioRespostaDTO(
        UUID id,
        String nome,
        String email,
        LocalDateTime criadoEm
) {
    public UsuarioRespostaDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCriadoEm());
    }
}
