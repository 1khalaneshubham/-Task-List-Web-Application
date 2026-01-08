package com.app.demo.app.controller;

import com.app.demo.app.models.Task;
import com.app.demo.app.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    // HOME PAGE
    @GetMapping("/")
    public String home(Model model) {
        List<Task> tasks = taskServices.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    // ADD TASK
    @PostMapping("/tasks")
    public String createTask(@RequestParam String title) {
        taskServices.createTask(title);
        return "redirect:/";
    }

    // TOGGLE TASK
    @GetMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable long id) {
        taskServices.toggleTask(id);
        return "redirect:/";
    }

    // DELETE TASK
    @GetMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable long id) {
        taskServices.deleteTask(id);
        return "redirect:/";
    }
}
