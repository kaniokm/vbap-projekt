package cz.foot.service;

import cz.foot.model.Player;
import cz.foot.model.StaffMember;
import cz.foot.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffMemberService {

    private final StaffMemberRepository staffMemberRepository;

    @Autowired
    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }






    public Iterable<StaffMember> getAllStaffMembers()
    {
        return staffMemberRepository.findAll();
    }

    public Optional<StaffMember> newStaffMember(StaffMember newStaffMember)
    {
        if (newStaffMember.getName()!=null && newStaffMember.getSurname()!=null ) {

            return Optional.of(staffMemberRepository.save(newStaffMember));
        }
        return Optional.empty();

    }

    public StaffMember getStaffMemberById(Long id)
    {

        return staffMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Staff member does not exists with id: "+id));
    }

    public StaffMember updateStaffMember(Long id, StaffMember staffMemberDetails)
    {
        StaffMember staffMember = staffMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player does not exists with id: "+id));

        staffMember.setName(staffMemberDetails.getName());
        staffMember.setSurname(staffMemberDetails.getSurname());


        return staffMemberRepository.save(staffMember);
    }

    public void deleteStaffMember(Long id){

        StaffMember staffMember = staffMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player does not exists with id: "+id));

        staffMemberRepository.delete(staffMember);



    }

}
