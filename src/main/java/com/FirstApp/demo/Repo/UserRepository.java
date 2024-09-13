package com.FirstApp.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.FirstApp.demo.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByuusername(String username);

}
