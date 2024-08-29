package com.kenzi.project_management_service.service;

import com.kenzi.project_management_service.dto.ProjectDto;
import com.kenzi.project_management_service.exception.ProjectNotFoundException;
import com.kenzi.project_management_service.mapper.ProjectMapper;
import com.kenzi.project_management_service.model.Project;
import com.kenzi.project_management_service.repository.IprojectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectMapper projectMapper;
    private final IprojectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper, IprojectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toDTO) // Use the mapper to convert directly to DTO
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(projectMapper::toDTO) // Convert to DTO if present
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
    }

    @Override
    public ProjectDto AddProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto); // Use mapper to convert DTO to entity
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDTO(savedProject);
    }



    @Override
    public ProjectDto updateProject(Long id, ProjectDto projectDto) {
        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));

        // Update fields from projectDto
        updateEntityWithDto(existingProject, projectDto);

        Project updatedProject = projectRepository.save(existingProject);
        return projectMapper.toDTO(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
        projectRepository.delete(project);
    }

    // Helper method to update entity fields
    private void updateEntityWithDto(Project project, ProjectDto projectDto) {
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setBudget(projectDto.getBudget());
        // Add more fields to update as necessary
    }
}
