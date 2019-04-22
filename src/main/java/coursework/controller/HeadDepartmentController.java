package coursework.controller;

import coursework.model.HeadDepartment;
import coursework.repository.HeadDepartmentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/head_department")
public class HeadDepartmentController {
    private final HeadDepartmentRepo headDepartmentRepo;

    public HeadDepartmentController(HeadDepartmentRepo headDepartmentRepo) {
        this.headDepartmentRepo = headDepartmentRepo;
    }

    @GetMapping
    public List<HeadDepartment> getHeadDepartment(){
        return headDepartmentRepo.findAll();
    }

    @GetMapping("{id}")
    public HeadDepartment getHeadDepartment(@PathVariable("id") HeadDepartment headDepartment) {
        return headDepartment;
    }

    @PostMapping
    public HeadDepartment addHeadDepartment(@RequestBody HeadDepartment headDepartment) {
        return headDepartmentRepo.save(headDepartment);
    }

    @PutMapping("{id}")
    public HeadDepartment updateHeadDepartment(@PathVariable("id") HeadDepartment headDepartmentFromDB,
                                         @RequestBody HeadDepartment newHeadDepartment) {
        BeanUtils.copyProperties(newHeadDepartment, headDepartmentFromDB, "id");
        return headDepartmentRepo.save(headDepartmentFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteHeadDepartment(@PathVariable("id") HeadDepartment headDepartment) {
        headDepartmentRepo.delete(headDepartment);
    }
    
}
