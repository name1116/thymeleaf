package com.example.thymeleaf2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymeleaf2.model.User;


@Repository // 컴포넌트 스캔 시 등록을 위해서 포함이 필요함
public interface UserRepository extends JpaRepository<User, Long>{
	
}
