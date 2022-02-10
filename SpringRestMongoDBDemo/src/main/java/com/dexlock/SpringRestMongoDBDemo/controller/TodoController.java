package com.dexlock.SpringRestMongoDBDemo.controller;
import com.dexlock.SpringRestMongoDBDemo.exceptions.FileStorageException;
//import com.dexlock.SpringRestMongoDBDemo.model.FileInfo;
import com.dexlock.SpringRestMongoDBDemo.model.TodoDTO;
//import com.dexlock.SpringRestMongoDBDemo.service.FileServiceImplementor;
import com.dexlock.SpringRestMongoDBDemo.service.TodoServiceImplementation;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class TodoController {

    private TodoServiceImplementation todoServiceObject;

    @Autowired
    public TodoController(TodoServiceImplementation todoServiceObject) {
        this.todoServiceObject = todoServiceObject;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoDTO>> getAllTodos(){
       return todoServiceObject.getAllTodos();
    }

    @PostMapping(value = "/todos")
    public ResponseEntity createTodo(@RequestBody TodoDTO todo) {
            return todoServiceObject.createTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id){
        return todoServiceObject.getSingleTodo(id);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id,@Valid @RequestBody TodoDTO todo){
        return todoServiceObject.updateTodoId(id,todo);
    }
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){
       return todoServiceObject.deleteToDoById(id);
    }
}
