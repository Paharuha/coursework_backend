package coursework.controller;

import coursework.model.Contracts;
import coursework.repository.ContractsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/contracts")
public class ContractsController {
    @Autowired

    private final ContractsRepo contractsRepo;

    public ContractsController(ContractsRepo contractsRepo) {
        this.contractsRepo = contractsRepo;
    }

    @GetMapping
    public Iterable<Contracts> getContracts(){
        return contractsRepo.findAll();
    }

    @GetMapping("{id}")
    public Contracts getContract(@PathVariable("id") Contracts contract) {
        return contract;
    }

    @PostMapping
    public Contracts addContracts(@RequestBody Contracts contract) {
        return contractsRepo.save(contract);
    }

    @PutMapping("{id}")
    public Contracts updateContracts(@PathVariable("id") Contracts contractFromDB,
                           @RequestBody Contracts newContracts) {
        BeanUtils.copyProperties(newContracts, contractFromDB, "id");
        return contractsRepo.save(contractFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteContracts(@PathVariable("id") Contracts contract) {
        contractsRepo.delete(contract);
    }

    @GetMapping("/find-by-date")
    public Iterable<Contracts> getByDate(@RequestParam(name = "start_date") String startDate,
                                         @RequestParam(name = "end_date") String endDate) {
        String[] date = startDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        date = endDate.split("-");
        LocalDate end = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return contractsRepo.getContracts(start, end);
    }

    @GetMapping("/find-by-namecontract")
    public Iterable<Contracts> getByNameContract(@RequestParam(name = "name_contract") String project) {
        return contractsRepo.getProjects(project);
    }

    @GetMapping("/find-by-value")
    public Iterable<Contracts> getValue(@RequestParam(name = "start_date") String startDate,
                                         @RequestParam(name = "end_date") String endDate) {
        String[] date = startDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        date = endDate.split("-");
        LocalDate end = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return contractsRepo.getContractsValue(start, end);
    }

    @GetMapping("/find-by-subconracting")
    public Iterable<Contracts> getSubcontracting(@RequestParam(name = "name") String name) {
        return contractsRepo.getSubcontracting(name);
    }

    @GetMapping("/find-by-peopleproject")
    public Iterable<Contracts> getPeopleProject(@RequestParam(name = "name") String name) {
        return contractsRepo.getPeopleProject(name);
    }

    @GetMapping("/find-by-peopledate")
    public Iterable<Contracts> getPeopleDate(@RequestParam(name = "date") String startDate,
                                             @RequestParam(name = "end_date") String endDate) {
        String[] date = startDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        date = endDate.split("-");
        LocalDate end = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return contractsRepo.getPeopleDate(start ,end);
    }

    @GetMapping("/find-by-rahun")
    public Iterable<Double> getRah(@RequestParam(name = "id") int id){
        return  contractsRepo.getRah(id);
    }
}
