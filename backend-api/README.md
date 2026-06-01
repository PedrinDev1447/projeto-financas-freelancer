# 🔧 Finlance API — Backend REST

Backend da plataforma **Finanças Freelancer**, responsável pela lógica de negócio, persistência de dados e exposição de endpoints REST para o frontend Angular.

---

## 🧱 Stack

- ☕ **Java 17**
- 🍃 **Spring Boot 4.0.6**
- 🗄️ **Spring Data JPA**
- 🔐 **Spring Security**
- ✅ **Bean Validation**
- 🐘 **PostgreSQL** (dependência disponível para produção)
- 💾 **H2 Database** (banco em memória — ambiente de desenvolvimento)
- 📦 **Maven** (wrapper incluso)

---

## 🌐 Servidor

A API sobe na porta **`8081`** por padrão.

```
http://localhost:8081
```

Configuração em `src/main/resources/application.properties`:

```properties
server.port=8081
```

---

## ▶️ Como Iniciar

Na raiz deste módulo (`backend-api`):

### Linux / macOS

```bash
./mvnw spring-boot:run
```

### Windows (PowerShell)

```powershell
.\mvnw.cmd spring-boot:run
```

> 💡 Opcional: execute `.\mvnw clean` (ou `./mvnw clean`) antes do primeiro run para garantir um build limpo.

---

## 📖 Documentação Interativa — Swagger UI

> ⭐ **Destaque principal:** toda a API está documentada de forma interativa via **Swagger (OpenAPI 3)**.

Após iniciar o servidor, acesse:

### 👉 [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

No Swagger você pode:

- 📋 Visualizar todos os endpoints disponíveis
- 📝 Consultar schemas de request e response
- 🧪 Executar requisições **Try it out** diretamente no navegador
- 🔍 Validar respostas sem precisar de ferramentas externas

A documentação é gerada automaticamente com **springdoc-openapi** e anotações como `@Tag` e `@Operation` nos controllers.

---

## 📡 Endpoints REST

Base URL: `http://localhost:8081/api`

### 👤 Usuários — `/api/usuarios`

| Método | Rota              | Descrição                          | Status |
|--------|-------------------|------------------------------------|--------|
| `POST` | `/api/usuarios`   | Cadastra um novo freelancer        | `201 Created` |
| `GET`  | `/api/usuarios`   | Lista todos os usuários cadastrados | `200 OK` |

#### `POST /api/usuarios`

Cadastra um novo usuário (freelancer).

**Corpo (JSON):**

| Campo   | Tipo   | Regras                          |
|---------|--------|---------------------------------|
| `nome`  | string | obrigatório                     |
| `email` | string | obrigatório, formato de e-mail  |
| `senha` | string | obrigatório, mínimo 8 caracteres |

**Exemplo:**

```json
{
  "nome": "Pedro Lucas",
  "email": "pedro@exemplo.com",
  "senha": "SenhaForte@2026"
}
```

**Resposta:** `201 Created` — `"Freelancer cadastrado com sucesso!"`

---

#### `GET /api/usuarios`

Lista todos os usuários cadastrados.

**Resposta:** `200 OK` — array de objetos:

| Campo      | Tipo     |
|------------|----------|
| `id`       | UUID     |
| `nome`     | string   |
| `email`    | string   |
| `criadoEm` | datetime |

> 🔒 A senha **nunca** é retornada nas respostas.

---

## 💾 Banco de Dados (Desenvolvimento)

Em ambiente local, a aplicação utiliza **H2 em memória**:

| Configuração | Valor                          |
|--------------|--------------------------------|
| URL JDBC     | `jdbc:h2:mem:finlance_db`      |
| Console H2   | http://localhost:8081/h2-console |

Para **produção**, a dependência **PostgreSQL** já está configurada no `pom.xml` — basta ajustar as propriedades de conexão no `application.properties` (ou via variáveis de ambiente).

---

## 🔗 CORS

A API aceita requisições do frontend Angular em:

```
http://localhost:4200
```

---

## 🧪 Testes Manuais

Arquivo de exemplos HTTP disponível em:

```
api-testes/usuarios.http
```

Ou utilize o **Swagger UI** — forma recomendada para explorar e testar a API durante o desenvolvimento.
