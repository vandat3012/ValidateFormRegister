package com.example.validatefromregister.controller;


import com.example.validatefromregister.model.FormRegister;
import com.example.validatefromregister.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class FormRegisterController {
    @Autowired
    private IFormService iFormService;
    @GetMapping("/")
    public String show (Model model) {
        model.addAttribute("form",new FormRegister());
        return "create";
    }
    @PostMapping("/")
    public String check (@Valid @ModelAttribute("form") FormRegister formRegister , BindingResult bindingResult, Model model){
        new FormRegister().validate(formRegister,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            model.addAttribute("form",formRegister);
            iFormService.save(formRegister);
            return "inform";
        }
    }
}
