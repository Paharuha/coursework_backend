package coursework.controller;

import coursework.model.Division;
import coursework.model.LabAsistant;
import coursework.repository.LabAsistantRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/lab_asistant")
public class LabAsistantController {
    private final LabAsistantRepo labAsistantRepo;

    public LabAsistantController(LabAsistantRepo labAsistantRepo) {
        this.labAsistantRepo = labAsistantRepo;
    }

    @GetMapping
    public List<LabAsistant> getLabAsistant(){
        return labAsistantRepo.findAll();
    }

    @GetMapping("{id}")
    public LabAsistant getLabAsistant(@PathVariable("id") LabAsistant labAsistant) {
        return labAsistant;
    }

    @PostMapping
    public LabAsistant addLabAsistant(@RequestBody LabAsistant labAsistant) {
        return labAsistantRepo.save(labAsistant);
    }

    @PutMapping("{id}")
    public LabAsistant updateLabAsistant(@PathVariable("id") LabAsistant labAsistantFromDB,
                                               @RequestBody LabAsistant newLabAsistant) {
        BeanUtils.copyProperties(newLabAsistant, labAsistantFromDB, "id");
        return labAsistantRepo.save(labAsistantFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteLabAsistant(@PathVariable("id") LabAsistant labAsistant) {
        labAsistantRepo.delete(labAsistant);
    }

    @GetMapping("/find-by-divsion")
    public Iterable<LabAsistant> getByDivision(@RequestBody Division division) {
        return labAsistantRepo.findByDivision(division);
    }

    @GetMapping("/find-by-lab_asistant")
    public Iterable<LabAsistant> getLabAsistant(@RequestParam(name = "surname") String name,
                                            @RequestParam(name = "date1") String localDate) {
        String[] date = localDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return labAsistantRepo.getLabAsistant(name, start);
    }
}
