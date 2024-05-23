package com.infinite.crm.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class TaskController {

	@Autowired
	private TaskRepository repo;

	@PostMapping("/post")
	public void addTask(@RequestBody Task task) {
		repo.save(task);
	}

	@GetMapping("/getall")
	public List<Task> getalltasks() {
		return repo.findAll();
	}
	
	@GetMapping("/getall/{name}")
	public List<Task> getalltasksbyname(@PathVariable String name){
		return repo.findAllByName(name);
	}
	
	@GetMapping("get/{id}")
	public Task getTask(@PathVariable Integer id){
		return repo.findById(id).get();
	}
	
	@PutMapping("/put/{id}")
	public Task updateTask(@RequestBody Task task,@PathVariable Integer id) {
		return repo.findById(id).map(t -> {
			t.setNumber(task.getNumber());
			t.setName(task.getName());
			return repo.save(t);
		}).get();
	}
}
