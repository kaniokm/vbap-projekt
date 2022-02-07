package cz.osu.prf.kip.repository;

import cz.osu.prf.kip.model.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CrudRepository<League,Long>{
}
