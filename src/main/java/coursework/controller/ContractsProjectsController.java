package coursework.controller;
import coursework.model.ContractsProjects;
import coursework.repository.ContractsProjectsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contracts_projects")
public class ContractsProjectsController {
    private final ContractsProjectsRepo contractsProjectsRepo;

    public ContractsProjectsController(ContractsProjectsRepo contractsProjectsRepo) {
        this.contractsProjectsRepo = contractsProjectsRepo;
    }

    @GetMapping
    public Iterable<ContractsProjects> getContractsProjects(){
        return contractsProjectsRepo.findAll();
    }

    @GetMapping("{id}")
    public ContractsProjects getContractsProjects(@PathVariable("id") ContractsProjects contractsProjects) {
        return contractsProjects;
    }

    @PostMapping
    public ContractsProjects addContractsProjects(@RequestBody ContractsProjects contractsProjects) {
        return contractsProjectsRepo.save(contractsProjects);
    }

    @PutMapping("{id}")
    public ContractsProjects updateContractsProjects(@PathVariable("id") ContractsProjects contractsProjectsFromDB,
                                     @RequestBody ContractsProjects newContractsProjectsProjects) {
        BeanUtils.copyProperties(newContractsProjectsProjects, contractsProjectsFromDB, "id");
        return contractsProjectsRepo.save(contractsProjectsFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteContractsProjects(@PathVariable("id") ContractsProjects contractsProjects) {
        contractsProjectsRepo.delete(contractsProjects);
    }
}
