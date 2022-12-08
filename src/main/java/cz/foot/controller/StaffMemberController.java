package cz.foot.controller;



import cz.foot.repository.StaffMemberRepository;
import cz.foot.model.StaffMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StaffMemberController {
    @Autowired
    private StaffMemberRepository staffMemberRepository;
    StaffMemberController(StaffMemberRepository staffMemberRepository){this.staffMemberRepository = staffMemberRepository;}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/staffMembers")
    Iterable<StaffMember> all()
    {

        return staffMemberRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/staffMember")
    StaffMember newStaffMember(@RequestBody StaffMember newStaffMember)
    {
        return staffMemberRepository.save(newStaffMember);
    }
}
