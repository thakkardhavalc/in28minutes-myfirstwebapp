package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created By dhhaval thakkar on 2023-10-26
 */
@Getter
@Setter
public class ToDo {

    private int id;
    private String username;

    @Size(min = 10, message = "Enter at-least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

    public ToDo(int id, String username, String description, LocalDate targetDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
