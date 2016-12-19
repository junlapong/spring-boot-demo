package com.demo.webapp;

import com.demo.webapp.domain.Post;
import com.demo.webapp.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private PostRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        for (int i = 1; i <= 10; i++) {
            repository.save(new Post("My post number #" + (i)));
        }
    }
}
