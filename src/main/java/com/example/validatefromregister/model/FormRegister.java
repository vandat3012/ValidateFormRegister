package com.example.validatefromregister.model;




import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "form")
public class FormRegister implements Validator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5,max = 45)
    private String lastName;
    private String phoneNumber;
    @Min(21)
    private int age;
    private String email;

    public FormRegister() {
    }

    public FormRegister(Long id,@NotEmpty @Size(min = 5,max = 45) String firstName, @NotEmpty @Size(min = 5,max = 45) String lastName, @Min(21) String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public FormRegister(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FormRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormRegister formRegister = (FormRegister) target;
        String phoneNumber = formRegister.getPhoneNumber();
        String email = formRegister.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");

        if (phoneNumber.length()>11 || phoneNumber.length()<10) {
            errors.rejectValue("phoneNumber","phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber","phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber","phoneNumber.matches");
        }
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if (!email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            errors.rejectValue("email","email.matches");
        }
    }
}

