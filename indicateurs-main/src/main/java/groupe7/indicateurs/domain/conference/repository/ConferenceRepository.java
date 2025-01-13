package groupe7.indicateurs.domain.conference.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import groupe7.indicateurs.domain.conference.model.Conference;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    @Query("SELECT c FROM Conference c WHERE c.titre LIKE %:titre% OR c.classe LIKE %:classe%")
List<Conference> findByTitreOrClasse(@Param("titre") String titre, @Param("classe") String classe);

}
