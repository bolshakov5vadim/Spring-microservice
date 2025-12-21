package com.example.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.MyEntity;//название файла. подключили сущность 
import com.example.repository.MyRepository;//название файла. подключили репозиторий

@RestController//аннотация, что делает код контроллером
@RequestMapping("/employees")//путь для всех методов. здесь пойдет микросервис
public class Controller {
    @Autowired//ищет класс с названием Repository
    private MyRepository repository;

    @GetMapping
    public List<MyEntity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public MyEntity addEntity(@RequestBody MyEntity entity) {
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void removeEntity(@PathVariable int id) {
        repository.deleteById(id);
    }
}
