package coursework.controller;

import coursework.model.Personal;
import coursework.repository.PersonalRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personal")
public class PersonalController {
    private final PersonalRepo personalRepo;

    public PersonalController(PersonalRepo personalRepo) {
        this.personalRepo = personalRepo;
    }
    
    @GetMapping
    public List<Personal> getPersonal(){
        return personalRepo.findAll();
    }

    @GetMapping("{id}")
    public Personal getPersonal(@PathVariable("id") Personal personal) {
        return personal;
    }

    @PostMapping
    public Personal addPersonal(@RequestBody Personal personal) {
        return personalRepo.save(personal);
    }

    @PutMapping("{id}")
    public Personal updatePersonal(@PathVariable("id") Personal personalFromDB,
                                         @RequestBody Personal newPersonal) {
        BeanUtils.copyProperties(newPersonal, personalFromDB, "id");
        return personalRepo.save(personalFromDB);
    }

    @DeleteMapping("{id}")
    public void deletePersonal(@PathVariable("id") Personal personal) {
        personalRepo.delete(personal);
    }
}
