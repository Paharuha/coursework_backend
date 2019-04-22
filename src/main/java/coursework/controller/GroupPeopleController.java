package coursework.controller;

import coursework.model.GroupPeople;
import coursework.repository.GroupPeopleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/group_people")
public class GroupPeopleController {
    private final GroupPeopleRepo groupPeopleRepo;

    public GroupPeopleController(GroupPeopleRepo groupPeopleRepo) {
        this.groupPeopleRepo = groupPeopleRepo;
    }

    @GetMapping
    public List<GroupPeople> getGroupPeople(){
        return groupPeopleRepo.findAll();
    }

    @GetMapping("{id}")
    public GroupPeople getGroupPeople(@PathVariable("id") GroupPeople groupPeople) {
        return groupPeople;
    }

    @PostMapping
    public GroupPeople addGroupPeople(@RequestBody GroupPeople groupPeople) {
        return groupPeopleRepo.save(groupPeople);
    }

    @PutMapping("{id}")
    public GroupPeople updateGroupPeople(@PathVariable("id") GroupPeople groupPeopleFromDB,
                                   @RequestBody GroupPeople newGroupPeople) {
        BeanUtils.copyProperties(newGroupPeople, groupPeopleFromDB, "id");
        return groupPeopleRepo.save(groupPeopleFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteGroupPeople(@PathVariable("id") GroupPeople groupPeople) {
        groupPeopleRepo.delete(groupPeople);
    }
}
