package groupe7.indicateurs.application.livre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe7.indicateurs.domain.livre.model.Livre;
import groupe7.indicateurs.domain.livre.repository.LivreRepository;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public Optional<Livre> findById(Long id) {
        return livreRepository.findById(id);
    }
    
    public Livre save(Livre livre) {
       return livreRepository.save(livre);
    }

    public void deleteById(Long id) {
        livreRepository.deleteById(id);
    }
}
