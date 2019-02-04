import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarUsuarioComponent } from './listar-usuario/listar-usuario.component';
import { IncluirUsuarioComponent } from './incluir-usuario/incluir-usuario.component';
import { ModuleWithProviders } from '@angular/compiler/src/core';
import { TableUsuarioComponent } from './table-usuario/table-usuario.component';

const routes: Routes = [
  { path: 'listar-usuario',  component: ListarUsuarioComponent},
  { path: 'incluir-usuario', component: IncluirUsuarioComponent, data: {title: 'Incluir Usuário' }},
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

@NgModule({
  imports: [routing],
  exports: [RouterModule]
})
export class AppRoutingModule { }
