package com.clara.ex07.controller;

import com.clara.ex07.models.FornecedorModel;
import com.clara.ex07.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll(){
        List<FornecedorModel> fornecedorModels = fornecedorService.findAll();
        return ResponseEntity.ok().body(fornecedorModels);
    }

        @PostMapping
        ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel fornecedor) {
        FornecedorModel requeste = fornecedorService.criarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        fornecedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarId(@PathVariable Long id) {
        return fornecedorService.findById(id);
    }
}
