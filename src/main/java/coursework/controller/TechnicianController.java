package coursework.controller;

import coursework.model.Division;
import coursework.model.Technician;
import coursework.repository.TechnicianRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/technician")
public class TechnicianController {
    private final TechnicianRepo technicianRepo;

    public TechnicianController(TechnicianRepo technicianRepo) {
        this.technicianRepo = technicianRepo;
    }

    @GetMapping
    public List<Technician> getTechnician(){
        return technicianRepo.findAll();
    }

    @GetMapping("{id}")
    public Technician getTechnician(@PathVariable("id") Technician technician) {
        return technician;
    }

    @PostMapping
    public Technician addTechnician(@RequestBody Technician technician) {
        return technicianRepo.save(technician);
    }

    @PutMapping("{id}")
    public Technician updateTechnician(@PathVariable("id") Technician technicianFromDB,
                                         @RequestBody Technician newTechnician) {
        BeanUtils.copyProperties(newTechnician, technicianFromDB, "id");
        return technicianRepo.save(technicianFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteTechnician(@PathVariable("id") Technician technician) {
        technicianRepo.delete(technician);
    }

    @GetMapping("/find-by-divsion")
    public Iterable<Technician> getByDivision(@RequestBody Division division) {
        return technicianRepo.findByDivision(division);
    }

    @GetMapping("/find-by-technician")
    public Iterable<Technician> getTechnician(@RequestParam(name = "surname") String name,
                                            @RequestParam(name = "date1") String localDate) {
        String[] date = localDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return technicianRepo.getTechnician(name, start);
    }
}
