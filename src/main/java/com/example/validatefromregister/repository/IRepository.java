package com.example.validatefromregister.repository;

import com.example.validatefromregister.model.FormRegister;
import org.springframework.data.repository.CrudRepository;

public interface IRepository extends CrudRepository<FormRegister,Long> {
}
