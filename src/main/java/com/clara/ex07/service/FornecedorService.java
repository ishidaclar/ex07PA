package com.clara.ex07.service;

import com.clara.ex07.models.FornecedorModel;
import com.clara.ex07.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<FornecedorModel> findAll(){
        return fornecedorRepository.findAll();
    }

    public Optional<FornecedorModel> findById(Long id){
        return fornecedorRepository.findById(id);
    }

    public FornecedorModel criarFornecedor(FornecedorModel fornecedorModel){
        return fornecedorRepository.save(fornecedorModel);
    }

    public void deletar(Long id){
        fornecedorRepository.findById(id);
    }

    public FornecedorModel atualizar(Long id, FornecedorModel fornecedorModel){
        FornecedorModel model = fornecedorRepository.findById(id).get();
        model.setContato(fornecedorModel.getContato());
        return fornecedorRepository.save(model);
    }

}
