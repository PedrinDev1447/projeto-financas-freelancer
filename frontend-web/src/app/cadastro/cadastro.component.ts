import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ToastService } from '../services/toast.service';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-cadastro',
  imports: [FormsModule],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.scss'
})
export class CadastroComponent {
  usuario = {
    nome: '',
    email: '',
    senha: ''
  };

  confirmarSenha: string = '';

  get hasMinLength(): boolean {
    return this.usuario.senha.length >= 8;
  }

  get hasUpper(): boolean {
    return /[A-Z]/.test(this.usuario.senha);
  }

  get hasLower(): boolean {
    return /[a-z]/.test(this.usuario.senha);
  }

  get hasNumber(): boolean {
    return /\d/.test(this.usuario.senha);
  }

  get hasSpecial(): boolean {
    return /[!@#$%^&*]/.test(this.usuario.senha);
  }

  get passwordsMatch(): boolean {
    return (
      this.usuario.senha === this.confirmarSenha && this.usuario.senha !== ''
    );
  }

  private readonly toastService = inject(ToastService);

  constructor(private usuarioService: UsuarioService) {}

  salvar(): void {
    if (
      !this.hasMinLength ||
      !this.hasUpper ||
      !this.hasLower ||
      !this.hasNumber ||
      !this.hasSpecial ||
      !this.passwordsMatch
    ) {
      alert('Por favor, revise a senha e confirme que todos os requisitos foram atendidos.');
      return;
    }

    this.usuarioService.cadastrar(this.usuario).subscribe({
      next: () =>
        this.toastService.mostrarSucesso('Freelancer cadastrado com sucesso!')
    });
  }
}
