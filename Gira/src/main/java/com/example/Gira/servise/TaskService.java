package com.example.Gira.servise;

import com.example.Gira.model.service.TaskServiceModel;
import com.example.Gira.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel taskServiceModel);

    List<TaskViewModel> findAll();

    void changeProgress(Long id);
}

