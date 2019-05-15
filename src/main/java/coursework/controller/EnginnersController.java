package coursework.controller;

import coursework.model.Division;
import coursework.model.Enginners;
import coursework.repository.EnginnersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/find-by-divsion")
    public Iterable<Enginners> getByDivision(@RequestBody Division division) {
        return enginnersRepo.findByDivision(division);
    }

    @GetMapping("/find-by-enginners")
    public Iterable<Enginners> getLabAsistant(@RequestParam(name = "surname") String name,
                                            @RequestParam(name = "date1") String localDate) {
        String[] date = localDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return enginnersRepo.getEnginners(name, start);
    }
}
