package com.dexlock.SpringMongoRestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private static StudentRepository repository;
    public static MongoTemplate mongoTemplate;
    public static Query query;
    @Autowired
    public void StudentService(StudentRepository repository,MongoTemplate mongoTemplate){
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
        this.query = new Query();
    }
    public Student addStudent() {
            String email = "abilmanoj1@gmail.com";
            Address address = new Address(
                    "India",
                    "Ernakulam",
                    "682020"
            );

            Student student = new Student(
                    "Abil",
                    "Manoj",
                    email,
                    Gender.FEMALE,
                    address,
                    "Maths",
                    BigDecimal.TEN,
                    LocalDateTime.now()

            );
            query.addCriteria(Criteria.where("email").is(email));
            List<Student> s = mongoTemplate.find(query,Student.class);

//            if(s.size()>1){
//                throw new IllegalStateException(
//                        "Email already exists!!"
//                );
//            }
//
//            if(s.isEmpty()){
//                repository.insert(student);
//            }
        repository.insert(student);
        return student;
    }

    public List getStudents(){


        List<Student> s = mongoTemplate.find(query,Student.class);
        return s;
    }

}


