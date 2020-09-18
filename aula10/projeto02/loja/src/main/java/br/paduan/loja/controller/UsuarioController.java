package br.paduan.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.paduan.loja.dao.UsuarioDAO;
import br.paduan.loja.model.Usuario;

@RestController
@CrossOrigin("*") //aceita pedidos de qualquer origem
public class UsuarioController {
    
    //delega ao JPA a responsabilidade de criar a classe para esse DAO e implementar os métodos
    @Autowired
    private UsuarioDAO dao;

    //localhost:8080/usuario/1
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable int id){
        Usuario usuario = dao.findById(id).orElse(null); //busca um usuário pela chave primária

        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
