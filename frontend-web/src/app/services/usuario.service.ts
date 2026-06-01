import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private readonly apiUrl = 'http://localhost:8081/api/usuarios';

  constructor(private http: HttpClient) {}

  cadastrar(usuario: any) {
    return this.http.post(this.apiUrl, usuario, { responseType: 'text' });
  }
}
