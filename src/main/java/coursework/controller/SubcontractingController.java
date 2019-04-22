package coursework.controller;

import coursework.model.Subcontracting;
import coursework.repository.SubcontractingRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subcontracting")
public class SubcontractingController {
    private final SubcontractingRepo subcontractingRepo;

    public SubcontractingController(SubcontractingRepo subcontractingRepo) {
        this.subcontractingRepo = subcontractingRepo;
    }


    @GetMapping
    public List<Subcontracting> getSubcontracting(){
        return subcontractingRepo.findAll();
    }

    @GetMapping("{id}")
    public Subcontracting getSubcontracting(@PathVariable("id") Subcontracting subcontracting) {
        return subcontracting;
    }

    @PostMapping
    public Subcontracting addSubcontracting(@RequestBody Subcontracting subcontracting) {
        return subcontractingRepo.save(subcontracting);
    }

    @PutMapping("{id}")
    public Subcontracting updateSubcontracting(@PathVariable("id") Subcontracting subcontractingFromDB,
                                   @RequestBody Subcontracting newSubcontracting) {
        BeanUtils.copyProperties(newSubcontracting, subcontractingFromDB, "id");
        return subcontractingRepo.save(subcontractingFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteSubcontracting(@PathVariable("id") Subcontracting subcontracting) {
        subcontractingRepo.delete(subcontracting);
    }
}
