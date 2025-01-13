package groupe7.indicateurs.domain.livre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import groupe7.indicateurs.domain.livre.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre,Long> {
    
}
