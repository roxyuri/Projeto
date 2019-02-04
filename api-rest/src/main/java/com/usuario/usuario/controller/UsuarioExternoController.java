package com.usuario.usuario.controller;

import com.usuario.usuario.Response.Response;
import com.usuario.usuario.model.UsuarioExterno;
import com.usuario.usuario.service.UsuarioExternoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioExternoController {


    @Autowired
    @Qualifier("usuarioExternoServiceImpl")
    private UsuarioExternoService service;


    @GetMapping(value = "{page}/{count}/{nome}/{situacao}/{perfilId}")
    public  ResponseEntity<?> findByParams( @PathVariable("page") int page,
                                            @PathVariable("count") int count,
                                            @PathVariable("nome") String nome,
                                            @PathVariable("situacao") String situacao,
                                            @PathVariable("perfilId") String perfilId) {

        nome = nome.equals("uninformed") ? "" : nome;
        situacao = situacao.equals("uninformed") ? "" : situacao;
        perfilId = perfilId.equals("uninformed")? "" : perfilId;

        Response<Page<UsuarioExterno>> response = new Response<>();
        Page<UsuarioExterno> usuarios = null;
        usuarios = service.findByFiltros(page, count, nome, situacao,perfilId);

        response.setData(usuarios);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{page}/{count}")
    public  ResponseEntity<?> findAll(@PathVariable int page, @PathVariable int count) {

        Response<Page<UsuarioExterno>> response = new Response<>();
        Page<UsuarioExterno> usuarios = null;

        usuarios = service.listarUsuarios(page, count);

        response.setData(usuarios);
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "{cpf}")
    public ResponseEntity<?> findById(@PathVariable("cpf") String cpf) {
        Response<UsuarioExterno> response = new Response<>();
        Optional<UsuarioExterno> usuarioOptional = service.findByCpf(cpf);
        UsuarioExterno usuario = usuarioOptional.get();
        if (usuario == null) {
            response.getErros().add("Registro não encontrado:" + cpf);
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(usuario);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<?> deletar(@PathVariable("cpf") String cpf) {
        Optional<UsuarioExterno> usuarioOptional = service.findByCpf(cpf);
        UsuarioExterno usuario = usuarioOptional.get();
        if (usuario == null) {
            return ResponseEntity.badRequest().body(Response.builder().response("Cpf não localizado").build());
        }
        service.delete(cpf);
        return ResponseEntity.ok(new Response<>());
    }

    @PostMapping()
    public ResponseEntity<?> salvar(@RequestBody UsuarioExterno usuarioExterno,BindingResult result) {

        Response<UsuarioExterno> response = new Response<>();
        try {
            validaCriarUsuario(usuarioExterno, result);
            if (result.hasErrors()) {
                return ResponseEntity.ok(Response.builder()
                                                .data(result.getAllErrors())
                                                .build());
            }
            service.salvarOuAtualizar(usuarioExterno);
        } catch (Exception e) {
            response.getErros().add(e.getMessage());
            return ResponseEntity.badRequest().body(response.getErros().add(e.getMessage()));

        }
        return ResponseEntity.ok(Response.builder().response("Registro salvo com sucesso").build());
    }

    @GetMapping(value = "/findByCpf/{cpf}")
    public ResponseEntity<?> getByCpf( @PathVariable("cpf") String cpf) {

        try {
            Optional<UsuarioExterno> usuarioOptional =  service.findByCpf(cpf);
            UsuarioExterno usuario = usuarioOptional.get();

            if (usuario != null) {
                return ResponseEntity.badRequest().body(Response.builder().response("Cpf já cadastrado!").build());
            }
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    private void validaCriarUsuario(UsuarioExterno usuarioExterno,BindingResult result){
          if(usuarioExterno.getCpf().equals("")){
            result.addError(new ObjectError("UsuarioExterno","Cpf não informado"));
          }
    }

}
