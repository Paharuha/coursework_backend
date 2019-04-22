package coursework.controller;

import coursework.model.Designers;
import coursework.repository.DesignersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
