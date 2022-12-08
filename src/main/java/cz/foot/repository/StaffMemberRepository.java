package cz.foot.repository;



import cz.foot.model.StaffMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMemberRepository extends CrudRepository<StaffMember,Long>{
}
