package com.kenzi.project_management_service.repository;

import com.kenzi.project_management_service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IprojectRepository extends JpaRepository<Project,Long> {

}
