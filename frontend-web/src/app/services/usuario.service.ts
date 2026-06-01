import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private readonly apiUrl = 'http://localhost:8081/api/usuarios';

  constructor(private http: HttpClient) {}

  cadastrar(usuario: Usuario): Observable<string> {
    return this.http.post(this.apiUrl, usuario, { responseType: 'text' });
  }
}
