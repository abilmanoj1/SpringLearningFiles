package com.dexlock.SpringRestMongoDBDemo.service;
import com.dexlock.SpringRestMongoDBDemo.model.TodoDTO;
import org.springframework.http.ResponseEntity;



public interface TodoCollectionService {
    public ResponseEntity getAllTodos();
    public ResponseEntity createTodo(TodoDTO todo);
    public ResponseEntity getSingleTodo(String id);
    public ResponseEntity updateTodoId(String id,TodoDTO todo);
    public ResponseEntity deleteToDoById(String id);
}
