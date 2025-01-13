package groupe7.indicateurs.application.revue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe7.indicateurs.domain.revue.repository.RevueRepository;
import groupe7.indicateurs.domain.revue.model.Revue;

@Service
public class RevueService {

    private final RevueRepository revueRepository;

    public RevueService(RevueRepository revueRepository) {
        this.revueRepository = revueRepository;
    }

    public List<Revue> findAll() {
        return revueRepository.findAll();
    }

    public Optional<Revue> findById(Long id) {
        return revueRepository.findById(id);
    }

    public Revue save(Revue revue) {
        return revueRepository.save(revue);
    }

    public void deleteById(Long id) {
        revueRepository.deleteById(id);
    }

    public List<Revue> getRevuesByTitreOrDomaine(String titre, String domaine) {
        return revueRepository.findByTitreOrDomaine(titre, domaine);
    }
    
}
