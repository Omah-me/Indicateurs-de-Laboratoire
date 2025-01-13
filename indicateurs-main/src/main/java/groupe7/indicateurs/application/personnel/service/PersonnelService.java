package groupe7.indicateurs.application.personnel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe7.indicateurs.domain.personnel.model.Personnel;
import groupe7.indicateurs.domain.personnel.repository.PersonnelRepository;

@Service
public class PersonnelService {

    private final PersonnelRepository personnelRepository;

    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public List<Personnel> findAll() {
        return personnelRepository.findAll();
    }

    public Optional<Personnel> findById(Long id) {
        return personnelRepository.findById(id);
    }

    public Personnel save(Personnel personnel) {
        return personnelRepository.save(personnel);
    }

    public void deleteById(Long id) {
        personnelRepository.deleteById(id);
    }
}
