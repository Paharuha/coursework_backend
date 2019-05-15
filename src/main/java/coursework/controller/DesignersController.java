package coursework.controller;

import coursework.model.Contracts;
import coursework.model.Designers;
import coursework.model.Division;
import coursework.repository.DesignersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api/designers")
public class DesignersController {
    private final DesignersRepo designersRepo;

    public DesignersController(DesignersRepo designersRepo) {
        this.designersRepo = designersRepo;
    }
    @GetMapping
    public Iterable<Designers> getDesigners(){
        return designersRepo.findAll();
    }

    @GetMapping("{id}")
    public Designers getDesigners(@PathVariable("id") Designers designers) {
        return designers;
    }

    @PostMapping
    public Designers addDesigners(@RequestBody Designers designers) {
        return designersRepo.save(designers);
    }

    @PutMapping("{id}")
    public Designers updateDesigners(@PathVariable("id") Designers designersFromDB,
                                     @RequestBody Designers newDesigners) {
        BeanUtils.copyProperties(newDesigners, designersFromDB, "id");
        return designersRepo.save(designersFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteContracts(@PathVariable("id") Designers designers) {
        designersRepo.delete(designers);
    }

    @GetMapping("/find-by-divsion")
    public Iterable<Designers> getByDivision(@RequestBody Division division) {
        return designersRepo.findByDivision(division);
    }


    @GetMapping("/find-by-designers")
    public Iterable<Designers> getDesigners(@RequestParam(name = "surname") String name,
                                        @RequestParam(name = "date1") String localDate) {
        String[] date = localDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return designersRepo.getDesigners(name, start);
    }
}
