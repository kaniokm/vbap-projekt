package cz.foot.repository;

import cz.foot.model.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CrudRepository<League,Long>{
}
