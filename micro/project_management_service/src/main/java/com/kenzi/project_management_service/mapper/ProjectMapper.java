package com.kenzi.project_management_service.mapper;

import com.kenzi.project_management_service.dto.ProjectDto;
import com.kenzi.project_management_service.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {


    ProjectDto toDTO(Project project);


    Project toEntity(ProjectDto projectDto);

    void updateProjectFromDTO(ProjectDto projectDto, @MappingTarget Project project);
}
