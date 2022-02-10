package com.dexlock.SpringBootOnetoManyMapping;

import com.dexlock.SpringBootOnetoManyMapping.entity.Comment;
import com.dexlock.SpringBootOnetoManyMapping.entity.Post;
import com.dexlock.SpringBootOnetoManyMapping.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootOnetoManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootOnetoManyMappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post("one to many mapping using JPA Annotation","one to many mapping using JPA Annotation");
		Comment comment1 = new Comment("Very useful");
		Comment comment2 = new Comment("Delightful");
		Comment comment3 = new Comment("Blown away");

		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);

		this.postRepository.save(post);
	}
}
