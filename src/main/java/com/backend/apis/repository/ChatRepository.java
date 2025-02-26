package com.backend.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apis.model.Chat;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

}
