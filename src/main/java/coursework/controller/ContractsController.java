package coursework.controller;

import coursework.model.Contracts;
import coursework.repository.ContractsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contracts")
public class ContractsController {
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
}
