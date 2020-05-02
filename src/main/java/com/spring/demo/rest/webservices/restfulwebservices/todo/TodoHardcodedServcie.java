package com.spring.demo.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedServcie {
	private static List<Todo> todos = new ArrayList();
	private static int idCounter =0;
	
	
	static {
		todos.add(new Todo(++idCounter,"in@28minutes","Learn to dance",new Date(),false));
		todos.add(new Todo(++idCounter,"in@28minutes","Learn about Microservices",new Date(),false));
		todos.add(new Todo(++idCounter,"in@28minutes","Learn about angular",new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo ==null)
			return null;
		
		//remove uses the equals method
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;	
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}

	public Todo addTodo(Todo todo) {
		Todo todo_add = findById(todo.getId());
		if(todo_add!=null) {
			return null;
		}
		
		todos.add(todo);
		return todo;
	}
	
}
