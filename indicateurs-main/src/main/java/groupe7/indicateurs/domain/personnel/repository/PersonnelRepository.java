package groupe7.indicateurs.domain.personnel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import groupe7.indicateurs.domain.personnel.model.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
    
}
