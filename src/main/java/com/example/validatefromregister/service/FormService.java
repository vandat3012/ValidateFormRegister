package com.example.validatefromregister.service;

import com.example.validatefromregister.model.FormRegister;
import com.example.validatefromregister.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService{
    @Autowired
    private IRepository iRepository;
    @Override
    public Iterable<FormRegister> findAll() {
        return null;
    }

    @Override
    public void save(FormRegister formRegister) {
        iRepository.save(formRegister);
    }
}
