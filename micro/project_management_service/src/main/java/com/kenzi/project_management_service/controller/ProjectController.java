package com.kenzi.project_management_service.controller;

import com.kenzi.project_management_service.dto.ProjectDto;
import com.kenzi.project_management_service.service.IProjectService;
import com.kenzi.project_management_service.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {


    private ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }


    // Récupérer tous les projets
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {

        List<ProjectDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // Récupérer un projet par ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        ProjectDto project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    // Créer un nouveau projet
    @PostMapping("/add")
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDTO) {
        ProjectDto createdProject = projectService.AddProject(projectDTO);
        return ResponseEntity.status(201).body(createdProject);
    }

    // Mettre à jour un projet existant
    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long id, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProjectDto = projectService.updateProject(id, projectDto);
        return new ResponseEntity<>(updatedProjectDto, HttpStatus.OK);
    }


    // Supprimer un projet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
