package cz.osu.prf.kip.controller;



import cz.osu.prf.kip.model.StaffMember;
import cz.osu.prf.kip.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StaffMemberController {
    @Autowired
    StaffMemberRepository staffMemberRepository;
    StaffMemberController(StaffMemberRepository staffMemberRepository){this.staffMemberRepository = staffMemberRepository;}

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/staffMembers")
    List<StaffMember> all()
    {

        return (List<StaffMember>) staffMemberRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/staffMember")
    StaffMember newStaffMember(@RequestBody StaffMember newStaffMember)
    {
        return staffMemberRepository.save(newStaffMember);
    }
}
