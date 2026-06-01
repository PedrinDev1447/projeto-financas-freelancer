import { Injectable, signal } from '@angular/core';

export type ToastTipo = 'sucesso' | 'erro';

@Injectable({
  providedIn: 'root'
})
export class ToastService {
  readonly mensagem = signal('');
  readonly tipo = signal<ToastTipo>('sucesso');
  readonly visivel = signal(false);

  private timerId: ReturnType<typeof setTimeout> | null = null;
  private readonly duracaoMs = 4000;

  mostrarSucesso(mensagem: string): void {
    this.exibir(mensagem, 'sucesso');
  }

  mostrarErro(mensagem: string): void {
    this.exibir(mensagem, 'erro');
  }

  fechar(): void {
    this.visivel.set(false);
    this.limparTimer();
  }

  private exibir(mensagem: string, tipo: ToastTipo): void {
    this.limparTimer();
    this.mensagem.set(mensagem);
    this.tipo.set(tipo);
    this.visivel.set(true);
    this.timerId = setTimeout(() => this.fechar(), this.duracaoMs);
  }

  private limparTimer(): void {
    if (this.timerId !== null) {
      clearTimeout(this.timerId);
      this.timerId = null;
    }
  }
}
