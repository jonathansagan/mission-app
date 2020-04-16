package dev.mission.exec;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		LocalDate now = LocalDate.now();
		List<Mission> missions = missionRepository.findMissionNow(now);

		for (Mission mission : missions)
			System.out.println("Les missions d'aujourd'hui sont les suivantes" + missions);
	}

}
