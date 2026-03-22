package com.mh.GerenciamentoDeDepartamentos.controllers;

import com.mh.GerenciamentoDeDepartamentos.models.DepartamentoModel;
import com.mh.GerenciamentoDeDepartamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.criarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> buscarTodosDepartamentos(){
        List<DepartamentoModel> request = departamentoService.buscarTodosDepartamentos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public DepartamentoModel buscarId(@PathVariable Long id) {
        return departamentoService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}