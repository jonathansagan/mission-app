package dev.mission.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
	// Création méthode now
	@Query("SELECT m FROM Mission m WHERE date_debut >= :now")
	List<Mission> findMissionNow(@Param("now") LocalDate now);
}