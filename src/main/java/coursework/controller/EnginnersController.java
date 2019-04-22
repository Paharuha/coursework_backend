package coursework.controller;

import coursework.model.Enginners;
import coursework.repository.EnginnersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enginners")
public class EnginnersController {
    private final EnginnersRepo enginnersRepo;

    public EnginnersController(EnginnersRepo enginnersRepo) {
        this.enginnersRepo = enginnersRepo;
    }
    @GetMapping
    public List<Enginners> getEnginners(){
        return enginnersRepo.findAll();
    }

    @GetMapping("{id}")
    public Enginners getEnginners(@PathVariable("id") Enginners enginners) {
        return enginners;
    }

    @PostMapping
    public Enginners addEnginners(@RequestBody Enginners enginners) {
        return enginnersRepo.save(enginners);
    }

    @PutMapping("{id}")
    public Enginners updateEnginners(@PathVariable("id") Enginners enginnersFromDB,
                                   @RequestBody Enginners newEnginners) {
        BeanUtils.copyProperties(newEnginners, enginnersFromDB, "id");
        return enginnersRepo.save(enginnersFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteEnginners(@PathVariable("id") Enginners enginners) {
        enginnersRepo.delete(enginners);
    }
}
