package coursework.controller;


import coursework.model.Division;
import coursework.repository.DivisionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/division")
public class DivisionController {
    private final DivisionRepo divisionRepo;

    public DivisionController(DivisionRepo divisionRepo) {
        this.divisionRepo = divisionRepo;
    }

    @GetMapping
    public List<Division> getDivision(){
        return divisionRepo.findAll();
    }

    @GetMapping("{id}")
    public Division getDivision(@PathVariable("id") Division division) {
        return division;
    }

    @PostMapping
    public Division addDivision(@RequestBody Division division) {
        return divisionRepo.save(division);
    }

    @PutMapping("{id}")
    public Division updateDivision(@PathVariable("id") Division divisionFromDB,
                                     @RequestBody Division newDivision) {
        BeanUtils.copyProperties(newDivision, divisionFromDB, "id");
        return divisionRepo.save(divisionFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteDivision(@PathVariable("id") Division division) {
        divisionRepo.delete(division);
    }
}
