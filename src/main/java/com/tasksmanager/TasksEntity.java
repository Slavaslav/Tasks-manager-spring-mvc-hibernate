package com.tasksmanager;

import javax.persistence.*;

@Entity
@Table(name = "tasks", schema = "test", catalog = "")
public class TasksEntity {
    private int id;
    private boolean isDone;
    private String taskName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_done", columnDefinition = "TINYINT", length = 1)
    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Basic
    @Column(name = "task_name")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksEntity that = (TasksEntity) o;

        if (id != that.id) return false;
        if (isDone != that.isDone) return false;
        return taskName != null ? taskName.equals(that.taskName) : that.taskName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isDone ? 1 : 0);
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        return result;
    }
}
