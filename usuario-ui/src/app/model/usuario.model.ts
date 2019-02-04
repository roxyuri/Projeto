import { Perfil } from './perfil.model';
import { Funcao } from './funcao.model';

export class Usuario {
    cpf: String;
    email: String;
    nome: String;
    telefone: String;
    situacao: String;
    funcao: Funcao;
    perfil: Perfil;
}


