package com.example.Gira.servise.impl;

import com.example.Gira.model.entity.Task;
import com.example.Gira.model.entity.enums.ProgressEnum;
import com.example.Gira.model.service.TaskServiceModel;
import com.example.Gira.model.view.TaskViewModel;
import com.example.Gira.repository.TaskRepository;
import com.example.Gira.sec.CurrentUser;
import com.example.Gira.servise.ClassificationService;
import com.example.Gira.servise.TaskService;
import com.example.Gira.servise.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private UserService userService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, ClassificationService classificationService, UserService userService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(classificationService.finBy(taskServiceModel.getClassification()));
        task.setProgress(ProgressEnum.OPEN);

        taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> findAll() {
        return taskRepository.findAll().stream()
                .map(task -> modelMapper.map(task, TaskViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void changeProgress(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task != null) {
            if (task.getProgress() == ProgressEnum.COMPLETED || task.getProgress() == ProgressEnum.OTHER) {
                taskRepository.delete(task);
            } else {
                if (task.getProgress() == ProgressEnum.OPEN) {
                    task.setProgress(ProgressEnum.IN_PROGRESS);
                } else if (task.getProgress() == ProgressEnum.IN_PROGRESS) {
                    task.setProgress(ProgressEnum.COMPLETED);
                }

                taskRepository.save(task);
            }

        }
    }
}
