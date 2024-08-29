package com.kenzi.project_management_service.service;

import com.kenzi.project_management_service.dto.ProjectDto;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface IProjectService {
    public List<ProjectDto> getAllProjects();
    public ProjectDto getProjectById(Long id);
    public ProjectDto AddProject(ProjectDto projectDto);
    public ProjectDto updateProject(Long id, ProjectDto projectDTO);
    public void deleteProject(Long id);





}
