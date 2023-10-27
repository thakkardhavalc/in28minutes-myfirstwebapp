package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created By dhhaval thakkar on 2023-10-26
 */
@Service
public class ToDoService {

    private static List<ToDo> toDos = new ArrayList<>();

    private static int todosCount = 0;

    static {
       toDos.add(new ToDo(++todosCount, "in28minutes", "Learn AWS",
               LocalDate.now().plusYears(1), false));
        toDos.add(new ToDo(++todosCount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        toDos.add(new ToDo(++todosCount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username) {
        return toDos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        ToDo toDo = new ToDo(++todosCount, username, description, targetDate, done);
        toDos.add(toDo);
    }

    public void deleteById(int id) {
        Predicate<? super ToDo> predicate = toDos -> toDos.getId() == id;
        toDos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDos -> toDos.getId() == id;
        return toDos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(ToDo toDo) {
        deleteById(toDo.getId());
        toDos.add(toDo);
    }
}
