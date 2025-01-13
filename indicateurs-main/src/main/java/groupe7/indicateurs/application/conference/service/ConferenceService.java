package groupe7.indicateurs.application.conference.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe7.indicateurs.domain.conference.model.Conference;
import groupe7.indicateurs.domain.conference.repository.ConferenceRepository;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> findById(Long id) {
        return conferenceRepository.findById(id);
    }

    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public void deleteById(Long id) {
        conferenceRepository.deleteById(id);
    }

    public List<Conference> getConferencesByTitreOrClasse(String titre, String classe) {
        return conferenceRepository.findByTitreOrClasse(titre, classe);
    }
    
}
