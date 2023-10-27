package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

/**
 * Created By dhhaval thakkar on 2023-10-26
 */
@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<ToDo> toDos = toDoService.findByUsername("in28minutes");
        model.addAttribute("toDos", toDos);

        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        ToDo toDo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("toDo", toDo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodoPage(ModelMap model, @Valid ToDo toDo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String)model.get("name");
        toDoService.addTodo(username, toDo.getDescription(),
                toDo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        toDoService.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String updateTodoPage(@RequestParam int id, ModelMap model) {
        ToDo toDo = toDoService.findById(id);
        model.addAttribute("toDo", toDo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid ToDo toDo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String)model.get("name");
        toDo.setUsername(username);
        toDoService.updateTodo(toDo);
        return "redirect:list-todos";
    }
}
