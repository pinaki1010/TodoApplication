package com.pinaki.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoJPAController {
	
	private TodoService todoService;
	
	private TodoRepository todoRepository;
	
	public TodoJPAController(TodoService todoService,TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap map) {
		
		String username = getLoggedInUserName(map);
		List<Todo> todos = todoRepository.findByName(username);
		map.addAttribute("todos", todos);	
		
		return "listTodos";
	}
	
	

	@RequestMapping(value="add-todo" ,method=RequestMethod.GET)
	public String addTodos(ModelMap map) {
		String username= (String)map.get("name");
		Todo todo = new Todo(0,username,"Default Desc", LocalDate.now().plusYears(1), false);
		map.put("todos", todo);
		
		return "Todos";
	}

	@RequestMapping(value="add-todo" ,method=RequestMethod.POST)
	public String showTodo(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "Todos";
		}else {
			String username= (String)map.get("name");
			todo.setName(username);
			todoRepository.save(todo);
//			todoService.addTodo(username, todo.getDescription(),todo.getLocalDate(), todo.isDone());
			return "redirect:list-todos";
		}
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);	
//		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String UpdateTodo(ModelMap map,@Valid Todo todo,BindingResult result) {
			
		if(result.hasErrors()) {
			return "Todos";
		}else {
			String username= (String)map.get("name");
			todo.setName(username);
			todoRepository.save(todo);
//			todoService.updateTodo(todo);
			return "redirect:list-todos";
		}
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap map) {
		
		String username= (String)map.get("name");
		
		Todo todo = todoRepository.findById(id).get(); 
		todo.setName(todo.getName());
		map.addAttribute("todos",todo);
		return "Todos";
	}
	
	   //Current Logged In user given
	    private String getLoggedInUserName(ModelMap map) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
		}

}
