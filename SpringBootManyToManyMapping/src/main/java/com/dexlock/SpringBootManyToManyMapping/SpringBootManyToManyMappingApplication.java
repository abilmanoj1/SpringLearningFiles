package com.dexlock.SpringBootManyToManyMapping;

import com.dexlock.SpringBootManyToManyMapping.entity.Post;
import com.dexlock.SpringBootManyToManyMapping.entity.Tag;
import com.dexlock.SpringBootManyToManyMapping.respositories.PostRepository;
import com.dexlock.SpringBootManyToManyMapping.respositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootManyToManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootManyToManyMappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private TagRepository tagRepository;


	@Override
	public void run(String... args) throws Exception {
//		Post post = new Post("Hibernate many to many mapping","description","content haha");
		Post post1 = new Post("Hibernate one to many mapping","description 12","content haha 12");

		Tag tag1 = new Tag("Spring boot");
//		Tag tag2 = new Tag("Spring boot");
//		Tag tag3 = new Tag("Spring boot");

//		post.getTags().add(tag1);
//		post.getTags().add(tag2);
//		post.getTags().add(tag3);

//		tag1.getPosts().add(post);
//		tag2.getPosts().add(post);
//		tag3.getPosts().add(post);

		tag1.getPosts().add(post1);
		post1.getTags().add(tag1);

//		postRepository.save(post);
		postRepository.save(post1);

	}
}
