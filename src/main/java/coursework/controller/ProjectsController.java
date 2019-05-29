package coursework.controller;

import coursework.model.Contracts;
import coursework.model.Projects;
import coursework.repository.ProjectsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectsController {
    private final ProjectsRepo projectsRepo;

    public ProjectsController(ProjectsRepo projectsRepo) {
        this.projectsRepo = projectsRepo;
    }

    @GetMapping
    public List<Projects> getProjects(){
        return projectsRepo.findAll();
    }

    @GetMapping("{id}")
    public Projects getProjects(@PathVariable("id") Projects projects) {
        return projects;
    }

    @PostMapping
    public Projects addProjects(@RequestBody Projects projects) {
        return projectsRepo.save(projects);
    }

    @PutMapping("{id}")
    public Projects updateProjects(@PathVariable("id") Projects projectsFromDB,
                                         @RequestBody Projects newProjects) {
        BeanUtils.copyProperties(newProjects, projectsFromDB, "id");
        return projectsRepo.save(projectsFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteProjects(@PathVariable("id") Projects projects) {
        projectsRepo.delete(projects);
    }

    @GetMapping("/find-by-nameprojects")
    public Iterable<Projects> getByNameProjects(@RequestParam(name = "name") String project) {
        return projectsRepo.getProjects(project);
    }

    @GetMapping("/find-by-equimentnum")
    public Iterable<Projects> getEquimentNum(@RequestParam(name = "number") String number) {
        return projectsRepo.getEquimentNum(Integer.valueOf(number));
    }
}
