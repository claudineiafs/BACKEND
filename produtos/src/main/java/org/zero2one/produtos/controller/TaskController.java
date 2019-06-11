package org.zero2one.produtos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zero2one.produtos.model.Task;
import org.zero2one.produtos.repository.TaskRepository;


@RestController
    @RequestMapping("/task")
    public class TaskController {

        private TaskRepository repository;

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
