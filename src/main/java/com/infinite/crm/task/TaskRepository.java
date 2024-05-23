package com.infinite.crm.task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{

	List<Task> findAllByName(String name);

}
