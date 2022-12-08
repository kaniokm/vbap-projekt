package cz.foot.service;


import cz.foot.repository.LeagueRepository;
import cz.foot.repository.PlayerRepository;
import cz.foot.repository.StaffMemberRepository;
import cz.foot.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(LeagueRepository.class);
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final StaffMemberRepository staffMemberRepository;

    @Autowired
    public DatabaseLoader(LeagueRepository leagueRepository, TeamRepository teamRepository, PlayerRepository playerRepository, StaffMemberRepository staffMemberRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.staffMemberRepository = staffMemberRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("Loaded leagues: " + this.leagueRepository.count());
        log.info("Loaded teams: " + this.teamRepository.count());
        log.info("Loaded players: " + this.playerRepository.count());
        log.info("Loaded staff members: " + this.staffMemberRepository.count());
    }

}
