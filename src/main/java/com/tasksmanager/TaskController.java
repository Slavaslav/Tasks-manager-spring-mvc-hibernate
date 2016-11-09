package com.tasksmanager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }
}
