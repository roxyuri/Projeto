import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-incluir-usuario',
  templateUrl: './incluir-usuario.component.html',
  styleUrls: ['./incluir-usuario.component.scss']
})
export class IncluirUsuarioComponent implements OnInit {

  public nome = '';
  public email = '';
  public cpf = '';

  constructor(private router: Router) { }

  ngOnInit() {
  }

  volter() {
    this.router.navigate(['/listar-usuario']);
  }

}
