package com.example.validatefromregister.service;

public interface IGenerateService <T>{
    Iterable<T> findAll();
    void save (T t);
}
