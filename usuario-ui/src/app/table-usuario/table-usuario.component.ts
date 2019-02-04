import { FormGroup, FormControl, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario.model';
import { UsuarioService } from '../servico/usuario.service';
import { Perfil } from '../model/perfil.model';
import { Funcao } from '../model/funcao.model';






@Component({
  selector: 'app-table-usuario',
  templateUrl: './table-usuario.component.html',
  styleUrls: ['./table-usuario.component.scss']
})
export class TableUsuarioComponent implements OnInit {


  id: number;
  private usuarios: any[];
  mostrarDadosLegenda: boolean;
  public suspenderForm: FormGroup;
  public usuario = new Usuario();

  public formulario: FormGroup;

  perfils: PerfilAcesso[] = [
    {id: 'uninformed', descricao: 'Todos'},
    {id: '0', descricao: 'Aluno'},
    {id: '1', descricao: 'Gestor'}

];

situacoes: Situacao[] = [
  {label: 'uninformed', descricao: 'Todos'},
  {label: 'A', descricao: 'Ativo'},
  {label: 'I', descricao: 'Inativo'}

];


  constructor(
      private service: UsuarioService, private formBuilder: FormBuilder,
    //   private location: Location
  ) {

  }

  ngOnInit() {
    // this.form = new FormGroup({
    //   nome: new FormControl(null),
    //   email: new FormControl(null)
    // });

    this.formulario = this.formBuilder.group({
      nome: [null],
      email: [null]
    });
  this.carregarPagina();
 }

 buscar() {
  this.service.filtroUsuario(this.usuario).subscribe((dados_) => {
    this.usuarios = dados_.data.content;
  }, (error) => {
    console.log(error);
  });
   console.log(this.usuarios);
  //  this.usuario = new Usuario();
}


carregarPagina() {

  this.service.obterUsuarios().subscribe((dados_) => {
    this.usuarios = dados_.data.content;
  }, (error) => {
    console.log(error);
  });

  this.usuario.funcao = new Funcao();
  this.usuario.perfil = new Perfil();
   this.usuario.cpf = '123432112334' ;
   this.usuario.email = 'leticia@gmail.com';
   this.usuario.nome = 'Leticia';
   this.usuario.perfil.descricao = 'Gestor';
   this.usuario.perfil.id = '1';
   this.usuario.situacao = 'A';
   this.usuario.telefone = '30124587';
   this.usuario.funcao.funcao = 1;
   this.usuario.funcao.nome = 'Gestor';

  // this.incluirUsuario(this.usuario);


}

incluirUsuario(usuario: Usuario) {
  this.service.incluiUsuario(usuario).subscribe(a => {
  console.log('salvou!');
  this.carregarPagina(); });
}

deletarUsuario(cpf: String) {
  const decisao = confirm('Tem certeza que deseja excluir esse funcionário?');
  if (decisao) {
  this.service.deletarUsuario(cpf).subscribe(a => {
    console.log('Excluiu!');
    this.carregarPagina(); });
  }
}

}

export interface PerfilAcesso {
  id: string;
  descricao: string;
}

export interface Situacao {
  label: string;
  descricao: string;
}
