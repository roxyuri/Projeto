import { AbstractService } from './abstract.service';
import { Router } from '@angular/router';
import { Usuario } from './../model/usuario.model';
import { Injectable } from '@angular/core';
// import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { BloqueioService } from './bloqueio.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UsuarioService extends AbstractService  {

  private relativePath: String = 'api/usuario/';

  constructor(http: HttpClient) {
      super(http);
  }

  obterUsuarios(): Observable<any> {
   // const url = `http://localhost:8080/api/datainfo/${0}/${10}`;
   return this.getMethod(this.relativePath + `${0}/${10}`);  }

   filtroUsuario(usuario: Usuario) {
       return this.getMethod(this.relativePath + `${0}/${10}/${usuario.nome}/${usuario.situacao}/${usuario.perfil.id}` );
   }

   exluiUsuario(id: String) {
    return this.deleteMethod(this.relativePath, id);
   }

   incluiUsuario(usuario: Usuario) {
    return this.http.post('http://localhost:8080/api/usuario' , usuario);
   }

   deletarUsuario(cpf: String) {
    return this.http.delete('http://localhost:8080/api/usuario/' + cpf);
   }
}



