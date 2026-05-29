package finlance_api.controller;

import finlance_api.domain.Usuario;
import finlance_api.dto.UsuarioCadastroDTO;
import finlance_api.dto.UsuarioRespostaDTO;
import finlance_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping

    public ResponseEntity<String> cadastrar(@Valid @RequestBody UsuarioCadastroDTO dto) {
        
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setSenha(dto.senha());

        usuarioService.criarUsuario(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Freelancer cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRespostaDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
}