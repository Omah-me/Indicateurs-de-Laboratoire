package groupe7.indicateurs.domain.revue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import groupe7.indicateurs.domain.revue.model.Revue;

@Repository
public interface RevueRepository extends JpaRepository<Revue, Long> {
@Query("SELECT r FROM Revue r WHERE r.titre LIKE %:titre% OR r.domaine LIKE %:domaine%")
List<Revue> findByTitreOrDomaine(@Param("titre") String titre, @Param("domaine") String domaine);

}
