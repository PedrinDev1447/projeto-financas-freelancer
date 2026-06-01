# 🎨 Finlance Web — Frontend Angular

Aplicação web da plataforma **Finanças Freelancer**, construída com **Angular 19** e estilizada com **Tailwind CSS**. Oferece interface moderna em Dark Mode, integração com a API REST e feedback visual robusto para o usuário.

---

## 🧱 Stack

| Tecnologia        | Versão / Detalhe              |
|-------------------|-------------------------------|
| **Angular**       | 19.2                          |
| **Angular CLI**   | 19.2.26                       |
| **Tailwind CSS**  | 3.4                           |
| **TypeScript**    | 5.7                           |
| **RxJS**          | 7.8                           |

---

## 📦 Pré-requisitos

- **Node.js** (LTS recomendado)
- **npm**
- Backend rodando em `http://localhost:8081` (veja [backend-api/README.md](../backend-api/README.md))

---

## ▶️ Comandos Básicos

### 1. Instalar dependências

Na raiz deste módulo (`frontend-web`):

```bash
npm install
```

### 2. Iniciar o servidor de desenvolvimento

```bash
ng serve
```

Ou, via script npm:

```bash
npm start
```

A aplicação ficará disponível em:

```
http://localhost:4200
```

O servidor recarrega automaticamente ao salvar alterações nos arquivos fonte.

---

## 🎨 UI com Tailwind CSS — Dark Mode Tokenizado

A interface utiliza **Tailwind CSS** integrado ao Angular, com uma camada de **Design Tokens** centralizada para garantir consistência visual e facilitar manutenção do tema escuro.

### Tokens CSS (`src/styles/tokens.css`)

As cores são definidas como variáveis CSS em `:root`:

```css
:root {
  --color-bg-base: #202020;       /* Fundo geral */
  --color-surface: #404040;       /* Cards */
  --color-surface-dark: #000000;  /* Inputs */
  --color-border: #606060;        /* Bordas */
  --color-primary: #606060;       /* Botões */
  --color-primary-hover: #808080; /* Hover */
  --color-text-main: #ffffff;     /* Texto principal */
  --color-text-muted: #808080;    /* Texto secundário */
}
```

### Integração com Tailwind (`tailwind.config.js`)

Os tokens são mapeados para classes utilitárias do Tailwind:

```javascript
colors: {
  base: 'var(--color-bg-base)',
  surface: 'var(--color-surface)',
  primary: { DEFAULT: 'var(--color-primary)', hover: 'var(--color-primary-hover)' },
  textMain: 'var(--color-text-main)',
  // ...
}
```

> ✨ **Benefício:** alterar o tema exige mudanças apenas nos tokens — toda a UI se adapta automaticamente.

---

## 🏗️ Arquitetura Frontend

### 🛡️ Interceptor Global de Erros

Todas as requisições HTTP passam pelo **`errorInterceptor`**, registrado globalmente em `app.config.ts`:

```typescript
provideHttpClient(withInterceptors([errorInterceptor]))
```

O interceptor:

- 🔍 Captura erros HTTP de forma centralizada
- 📡 Trata falhas de conexão (`status === 0`)
- 📝 Extrai mensagens de erro da API (string ou JSON)
- 🔔 Dispara **Toast Notifications** automaticamente via `ToastService`
- 🪵 Registra detalhes no console para debug

> Nenhum componente precisa tratar erros HTTP manualmente — a camada de infraestrutura cuida disso.

---

### 🔔 Toast Notifications Personalizadas

Sistema de feedback visual composto por:

| Arquivo | Responsabilidade |
|---------|------------------|
| `services/toast.service.ts` | Estado reativo (Angular Signals), tipos `sucesso` / `erro`, auto-dismiss em 4s |
| `components/toast/toast.component.ts` | Componente standalone que exibe a notificação |

**Uso nos componentes:**

```typescript
// Sucesso (ex.: cadastro concluído)
this.toastService.mostrarSucesso('Freelancer cadastrado!');

// Erro (disparado automaticamente pelo interceptor)
this.toastService.mostrarErro('Mensagem de erro');
```

---

## 🔗 Integração com a API

O `UsuarioService` consome a API REST do backend:

```
POST http://localhost:8081/api/usuarios
```

Rota principal da aplicação:

| Rota | Componente           | Função              |
|------|----------------------|---------------------|
| `/`  | `CadastroComponent`  | Formulário de cadastro de freelancer |

---

## 🛠️ Outros Comandos Úteis

```bash
# Build de produção
ng build

# Testes unitários (Karma + Jasmine)
ng test

# Gerar novo componente
ng generate component nome-do-componente
```

Artefatos de build ficam em `dist/`.

---

## 📁 Estrutura Relevante

```
src/
├── app/
│   ├── cadastro/              → Tela de cadastro
│   ├── components/toast/      → Toast Notifications
│   ├── interceptors/          → Interceptor global de erros
│   ├── services/              → UsuarioService, ToastService
│   ├── models/                → Tipos e interfaces
│   └── app.config.ts          → Providers globais
└── styles/
    └── tokens.css             → Design Tokens (Dark Mode)
```

---

## 🔗 Links Relacionados

- 📘 [README principal do monorepo](../README.md)
- 🔧 [Documentação do Backend](../backend-api/README.md)
- 📖 [Swagger UI — API](http://localhost:8081/swagger-ui/index.html)
