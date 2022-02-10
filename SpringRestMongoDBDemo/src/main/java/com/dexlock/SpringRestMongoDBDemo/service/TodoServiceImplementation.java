package com.dexlock.SpringRestMongoDBDemo.service;
import com.dexlock.SpringRestMongoDBDemo.exceptions.FileStorageException;
import com.dexlock.SpringRestMongoDBDemo.model.TodoDTO;
import com.dexlock.SpringRestMongoDBDemo.property.FileStorageProperties;
import com.dexlock.SpringRestMongoDBDemo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImplementation implements TodoCollectionService {

    private TodoRepository todoRepo;

    @Autowired
    public TodoServiceImplementation(TodoRepository todoRepo){
        this.todoRepo = todoRepo;
    }

    @Override
    public ResponseEntity getAllTodos() {
        List<TodoDTO> todos = todoRepo.findAll();
        if(todos.size()>0){
            return new ResponseEntity<List<TodoDTO>>(todos, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No todos available",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity createTodo(TodoDTO todo) {

        try{
            String taskHeading = todo.getTodo();
            List<TodoDTO> todos = todoRepo.findAll();

            for(TodoDTO singleTodo:todos){

                if(singleTodo.getTodo().equals(taskHeading)){
                        throw new ItemDuplicationException("Item already exists");
                }
            }
            todo.setCreatedAt(new Date(System.currentTimeMillis()));

            todoRepo.save(todo);
            return new ResponseEntity<TodoDTO>(todo,HttpStatus.OK);
        }
        catch (ItemDuplicationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity getSingleTodo(String id) {
        Optional<TodoDTO> todoDTOOptional = todoRepo.findById(id);
        if(todoDTOOptional.isPresent()){
            return new ResponseEntity<>(todoDTOOptional.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Todo not found with ID"+id,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity updateTodoId(String id, TodoDTO todo) {
        Optional<TodoDTO> todoDTOOptional = todoRepo.findById(id);

        if(todoDTOOptional.isPresent()){
            TodoDTO todoToSave =  todoDTOOptional.get();
            todoToSave.setCompleted(todo.getCompleted() != null?todo.getCompleted():todoToSave.getCompleted());
            todoToSave.setTodo(todo.getTodo() != null?todo.getTodo():todoToSave.getTodo());
            todoToSave.setDescription(todo.getDescription() != null?todo.getDescription():todoToSave.getDescription());
            todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
            todoRepo.save(todoToSave);
            return new ResponseEntity<>(todoToSave,HttpStatus.OK);
        }
        else{
            return new ResponseEntity("Todo not found with ID"+id,HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity deleteToDoById(String id) {
        try{
            todoRepo.deleteById(id);
            return new ResponseEntity<>("Successfully deleted with id"+id,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
