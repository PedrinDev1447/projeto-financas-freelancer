# Projeto Finanças Freelancer

Plataforma **Full Stack** para gestão financeira e de perfil voltada a **freelancers**. O monorepo reúne uma API REST robusta e uma interface web moderna, integradas para cadastro e gerenciamento de usuários.

---

## 🧱 Stack Tecnológica

| Camada        | Tecnologia                          |
|---------------|-------------------------------------|
| **Frontend**  | Angular 19 + Tailwind CSS           |
| **Backend**   | Spring Boot 4.0.6 (Java 17)         |
| **Estilo**    | Tailwind CSS com Design Tokens (Dark Mode) |
| **Banco**     | H2 (desenvolvimento) / PostgreSQL (produção) |

---

## 📁 Estrutura do Repositório

```
projeto-financas-freelancer/
├── backend-api/     → API REST (Spring Boot)
└── frontend-web/    → Aplicação web (Angular)
```

Documentação detalhada de cada módulo:

- 📘 [Backend — API REST](./backend-api/README.md)
- 🎨 [Frontend — Aplicação Web](./frontend-web/README.md)

---

## 🚀 Como Rodar Backend e Frontend Simultaneamente

Para desenvolvimento local, abra **dois terminais** e execute cada aplicação em paralelo.

### Terminal 1 — Backend (porta `8081`)

```bash
cd backend-api
./mvnw spring-boot:run
```

> 💡 **Windows (PowerShell):** use `.\mvnw.cmd spring-boot:run`

Aguarde a mensagem de que a aplicação subiu. A API ficará disponível em:

```
http://localhost:8081
```

📖 Documentação interativa (Swagger): [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

### Terminal 2 — Frontend (porta `4200`)

```bash
cd frontend-web
npm install
ng serve
```

Acesse no navegador:

```
http://localhost:4200
```

---

## ✅ Checklist Rápido

1. ☑️ Backend rodando em `http://localhost:8081`
2. ☑️ Frontend rodando em `http://localhost:4200`
3. ☑️ Swagger acessível para testar os endpoints
4. ☑️ Formulário de cadastro no frontend comunicando com a API

---

## 🔗 Links Úteis

| Recurso              | URL                                              |
|----------------------|--------------------------------------------------|
| Frontend             | http://localhost:4200                            |
| API REST             | http://localhost:8081                            |
| Swagger UI           | http://localhost:8081/swagger-ui/index.html    |
| Console H2 (dev)     | http://localhost:8081/h2-console                 |
