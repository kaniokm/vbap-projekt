package cz.osu.prf.kip.repository;



import cz.osu.prf.kip.model.StaffMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMemberRepository extends CrudRepository<StaffMember,Long>{
}
