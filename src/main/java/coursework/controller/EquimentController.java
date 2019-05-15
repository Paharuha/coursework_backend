package coursework.controller;

import coursework.model.Equiment;
import coursework.repository.EquimentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/equiment")
public class EquimentController {
    private final EquimentRepo equimentRepo;

    public EquimentController(EquimentRepo equimentRepo) {
        this.equimentRepo = equimentRepo;
    }

    @GetMapping
    public List<Equiment> getEquiment(){
        return equimentRepo.findAll();
    }

    @GetMapping("{id}")
    public Equiment getEquiment(@PathVariable("id") Equiment equiment) {
        return equiment;
    }

    @PostMapping
    public Equiment addEquiment(@RequestBody Equiment equiment) {
        return equimentRepo.save(equiment);
    }

    @PutMapping("{id}")
    public Equiment updateEquiment(@PathVariable("id") Equiment equimentFromDB,
                                     @RequestBody Equiment newEquiment) {
        BeanUtils.copyProperties(newEquiment, equimentFromDB, "id");
        return equimentRepo.save(equimentFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteEquiment(@PathVariable("id") Equiment equiment) {
        equimentRepo.delete(equiment);
    }

    @GetMapping("/find-by-equiment")
    public Iterable<Equiment> getEquimet(@RequestParam(name = "date1") String startDate) {
        String[] date = startDate.split("-");
        LocalDate start = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));
        return equimentRepo.getEquimnet(start);
    }

    @GetMapping("/find-by-equiment-name")
    public Iterable<Equiment> getEquimnetByName(@RequestParam(name = "name") String name) {
        return equimentRepo.getEquimnetByName(name);
    }
}
