# Finlance API

Backend de gestão financeira e de perfil para freelancers.

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Execução local (Windows)

No terminal, na raiz deste módulo (`backend-api`):

```powershell
.\mvnw clean
.\mvnw spring-boot:run
```

A API sobe em `http://localhost:8081`.

## Endpoints

### POST `/api/usuarios`

Cadastra um novo usuário (freelancer).

**Corpo (JSON):**

| Campo   | Tipo   | Regras                          |
|---------|--------|---------------------------------|
| `nome`  | string | obrigatório                     |
| `email` | string | obrigatório, formato de e-mail  |
| `senha` | string | obrigatório, mínimo 8 caracteres |

**Resposta:** `201 Created` com mensagem de confirmação.

**Exemplo:**

```json
{
  "nome": "Pedro Lucas",
  "email": "pedro@exemplo.com",
  "senha": "SenhaForte@2026"
}
```

### GET `/api/usuarios`

Lista todos os usuários cadastrados.

**Resposta:** `200 OK` com array de objetos:

| Campo      | Tipo     |
|------------|----------|
| `id`       | UUID     |
| `nome`     | string   |
| `email`    | string   |
| `criadoEm` | datetime |

A senha não é retornada nas respostas.
