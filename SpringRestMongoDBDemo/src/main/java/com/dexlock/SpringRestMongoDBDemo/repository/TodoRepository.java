package com.dexlock.SpringRestMongoDBDemo.repository;

import com.dexlock.SpringRestMongoDBDemo.model.TodoDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {
}
