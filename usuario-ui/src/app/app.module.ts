import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BloqueioService } from './servico/bloqueio.service';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { TableUsuarioComponent } from './table-usuario/table-usuario.component';
import { EditarUsuarioComponent } from './editar-usuario/editar-usuario.component';
import { UsuarioService } from './servico/usuario.service';
import { IncluirUsuarioComponent } from './incluir-usuario/incluir-usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    ListarUsuarioComponent,
    TableUsuarioComponent,
    EditarUsuarioComponent,
    IncluirUsuarioComponent


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,




  ],
  providers: [UsuarioService, BloqueioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
