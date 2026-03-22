package com.mh.GerenciamentoDeDepartamentos.services;

import com.mh.GerenciamentoDeDepartamentos.models.DepartamentoModel;
import com.mh.GerenciamentoDeDepartamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public List<DepartamentoModel> buscarTodosDepartamentos(){
        return departamentoRepository.findAll();
    }

    public DepartamentoModel buscarId(Long id){
        return departamentoRepository.findById(id).get();
    }

    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }
}