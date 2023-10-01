package com.example.springboot3todoapplication.services;


import com.example.springboot3todoapplication.models.TodoItem;
import com.example.springboot3todoapplication.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> findById(Long id){
        return todoItemRepository.findById(id);
    }


    public TodoItem save(TodoItem todoItem) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(LocalDateTime.now().format(myFormatObj));
        }
        todoItem.setUpdatedAt(LocalDateTime.now().format(myFormatObj));

        return todoItemRepository.save(todoItem);
    }


    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }






}
