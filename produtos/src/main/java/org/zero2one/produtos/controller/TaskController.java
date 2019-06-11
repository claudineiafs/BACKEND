package org.zero2one.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zero2one.produtos.model.Task;
import org.zero2one.produtos.repository.TaskRepository;

import java.util.Collection;


@RestController
    @RequestMapping("/tasks")
    public class TaskController {

        @Autowired
        private TaskRepository repository;

        @GetMapping
        public Collection<Task> get() {
            return repository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity getById(@PathVariable("id") String id){
            Task task = repository.findById(id).orElse(null);
            if(task == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }

        @PostMapping
        public Task create(@RequestBody Task task) {
            return repository.save(task);

        }

}
