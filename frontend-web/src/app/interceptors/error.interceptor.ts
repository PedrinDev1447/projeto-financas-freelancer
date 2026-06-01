import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, throwError } from 'rxjs';

import { ToastService } from '../services/toast.service';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const toastService = inject(ToastService);

  return next(req).pipe(
    catchError((err: HttpErrorResponse) => {
      console.error('Detalhes do Erro Interceptado:', err);
      let mensagem = 'Erro ao processar a requisição.';

      if (err.status === 0) {
        mensagem = 'Servidor indisponível ou erro de conexão.';
      } else if (err.error) {
        mensagem =
          typeof err.error === 'string'
            ? err.error
            : (err.error.message || JSON.stringify(err.error));
      }

      toastService.mostrarErro(mensagem);
      return throwError(() => err);
    })
  );
};
