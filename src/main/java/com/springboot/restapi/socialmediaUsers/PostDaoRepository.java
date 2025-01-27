package com.springboot.restapi.socialmediaUsers;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public interface PostDaoRepository extends JpaRepository<Post,Integer> {
}
