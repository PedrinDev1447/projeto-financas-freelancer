package finlance_api.controller;

import finlance_api.domain.Usuario;
import finlance_api.dto.UsuarioCadastroDTO;
import finlance_api.dto.UsuarioRespostaDTO;
import finlance_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários e freelancers")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Cadastrar novo freelancer", description = "Recebe os dados do formulário e salva um novo freelancer no banco de dados")
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

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> tratarErroDeNegocio(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}