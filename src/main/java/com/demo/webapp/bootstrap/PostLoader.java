package com.demo.webapp.bootstrap;

import com.demo.webapp.domain.Post;
import com.demo.webapp.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PostLoader implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(PostLoader.class);

    private PostRepository repository;

    @Autowired
    public void setPostRepository(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (int i = 1; i <= 10; i++) {
            repository.save(new Post("My post number #" + (i)));
        }
    }
}
