package com.doniff.tasktrackerapi.store.api.controllers;

import com.doniff.tasktrackerapi.store.api.dto.ProjectDTO;
import com.doniff.tasktrackerapi.store.api.exceptions.BadRequestException;
import com.doniff.tasktrackerapi.store.api.exceptions.NotFoundException;
import com.doniff.tasktrackerapi.store.api.factories.ProjectDTOFactory;
import com.doniff.tasktrackerapi.store.entities.ProjectEntity;
import com.doniff.tasktrackerapi.store.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor()
@Transactional
@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectDTOFactory projectDTOFactory;

    public static final String FETCH_PROJECTS = "/api/projects";
    public static final String CREATE_PROJECT = "/api/projects";
    public static final String EDIT_PROJECT = "/api/projects/{project_id}";
    public static final String DELETE_PROJECT = "/api/projects/{project_id}";

    @GetMapping(FETCH_PROJECTS)
    public List<ProjectDTO> fetchProjects(
            @RequestParam(value = "prefix_name", required = false) Optional<String> optionalPrefixName)
    {
        optionalPrefixName = optionalPrefixName.filter(prefixName -> !prefixName.trim().isEmpty());

        Stream<ProjectEntity> projectEntityStream = optionalPrefixName
                .map(projectRepository::streamAllByNameStartsWithIgnoreCase)
                .orElseGet(projectRepository::streamAllBy);

        return projectEntityStream
                .map(ProjectDTOFactory::makeProjectDTO)
                .collect(Collectors.toList());
    }

    @PostMapping(CREATE_PROJECT)
    public ProjectDTO createProject(@RequestParam String name)
    {
        if(projectRepository.findByName(name).isPresent()) throw new BadRequestException("Project already exists");

        ProjectEntity project = projectRepository.saveAndFlush(
                ProjectEntity.builder()
                        .name(name)
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .build()
        );
        return projectDTOFactory.makeProjectDTO(project);
    }

    @PatchMapping(EDIT_PROJECT)
    public ProjectDTO editeProject(@PathVariable("project_id") Long projectId, @RequestParam String name) throws NotFoundException
    {
        if(name.trim().isEmpty())
        {
            throw new BadRequestException("Name cannot be empty");
        }
        ProjectEntity project = projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                    new NotFoundException(String.format("Project with \"%s\" doesn't exist", projectId))
                );

        project.setName(name);
        project.setUpdatedAt(Instant.now());
        return projectDTOFactory.makeProjectDTO(projectRepository.saveAndFlush(project));
    }

    @DeleteMapping(EDIT_PROJECT)
    public HttpStatus editeProject(@PathVariable("project_id") Long projectId) throws NotFoundException
    {
        ProjectEntity project = projectRepository
                .findById(projectId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Project with \"%s\" doesn't exist", projectId))
                );

        projectRepository.delete(project);
        return HttpStatus.OK;
    }
}
