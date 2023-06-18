package com.pinaki.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Service
@SessionAttributes("name")
public class TodoService {
	private static List<Todo> todos=new ArrayList<>();
	private static int todoCount=0;
	
	static {
		
		todos.add(new Todo(++todoCount, "Java", "Learn generic",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Spring", "Todo App",LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Sql", "Learn Basic",LocalDate.now().plusYears(1), false));
	}
	
	
	public List<Todo> findByUserName(String username){
		return todos;
	}
	
	public void addTodo(String userName,String descriptions,LocalDate localDate,boolean isDone) {
		Todo todo = new Todo(++todoCount, userName, descriptions, localDate, isDone);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate= todo -> todo.getId() == id;
	  todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate= todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
	
		deleteById(todo.getId());
		todos.add(todo);
		
		
	}

}
