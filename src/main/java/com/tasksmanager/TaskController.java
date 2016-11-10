package com.tasksmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    private TaskService taskService;

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @PostMapping(value = "/add-task")
    public String addTask(@ModelAttribute Task task) {
        taskService.addNewTask(task);
        return "redirect:/";
    }

    @GetMapping(value = "/delete-task{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskService.deleteTaskById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit-task{id}")
    public String editTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @PostMapping(value = "/update-task")
    public String updateTask(@ModelAttribute Task task) {
        if (task.getTaskName().length() > 0) {
            taskService.updateTask(task);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/show")
    public String show(@RequestParam("show") String value, Model model) {
        String query = "from Task where is_done = ";
        switch (value) {
            case "0":
                query += "'0'";
                break;
            case "1":
                query += "'1'";
                break;
            case "2":
                return "redirect:/";
        }
        model.addAttribute("tasks", taskService.getTasksBySpecifiedQuery(query));
        model.addAttribute("task", new Task());
        return "tasks";
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
