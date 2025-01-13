package groupe7.indicateurs.web.conference.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe7.indicateurs.application.conference.dto.ConferenceDTO;
import groupe7.indicateurs.application.conference.mapper.ConferenceMapper;
import groupe7.indicateurs.application.conference.service.ConferenceService;
import groupe7.indicateurs.domain.conference.model.Conference;
import groupe7.indicateurs.domain.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {
    private final ConferenceService conferenceService;
    private final ConferenceMapper conferenceMapper;

    public ConferenceController(ConferenceService conferenceService, ConferenceMapper conferenceMapper) {
        this.conferenceService = conferenceService;
        this.conferenceMapper = conferenceMapper;
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> createConference(@RequestBody ConferenceDTO conferenceDTO) {
        Conference conference = conferenceMapper.toEntity(conferenceDTO);
        Conference savedConference = conferenceService.save(conference);
        ConferenceDTO savedConferenceDTO = conferenceMapper.toDto(savedConference);
        return ResponseEntity.ok(savedConferenceDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getConferenceById(@PathVariable Long id) {
        Conference conference = conferenceService.findById(id)
                                     .orElseThrow(() -> new ResourceNotFoundException("Conference not found"));
        ConferenceDTO conferenceDTO = conferenceMapper.toDto(conference);
        return ResponseEntity.ok(conferenceDTO); 
    }

    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id) {
        conferenceService.deleteById(id);
    }

    @GetMapping
public ResponseEntity<List<ConferenceDTO>> getConferencesByTitreOrClasse(
        @RequestParam(name = "titre", required = false) String titre,
        @RequestParam(name = "classe", required = false) String classe) {
    List<Conference> conferences = conferenceService.getConferencesByTitreOrClasse(titre, classe);
    List<ConferenceDTO> conferenceDTOs = conferences.stream()
                                                    .map(conferenceMapper::toDto)
                                                    .toList();
    return ResponseEntity.ok(conferenceDTOs);
}

}
