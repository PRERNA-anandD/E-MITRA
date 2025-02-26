package com.backend.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.backend.apis.model.Notification;

@EnableJpaRepositories
@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
	List<Notification> findByUserIdAndIsRead(int userId, boolean isRead);

}
