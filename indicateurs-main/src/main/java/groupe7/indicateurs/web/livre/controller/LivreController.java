package groupe7.indicateurs.web.livre.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe7.indicateurs.application.livre.dto.LivreDTO;
import groupe7.indicateurs.application.livre.mapper.LivreMapper;
import groupe7.indicateurs.application.livre.service.LivreService;
import groupe7.indicateurs.domain.livre.model.Livre;
import groupe7.indicateurs.domain.exception.ResourceNotFoundException;



@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final LivreService livreService;
    private final LivreMapper livreMapper;

    public LivreController(LivreService livreService, LivreMapper livreMapper) {
        this.livreService = livreService;
        this.livreMapper = livreMapper;
    }

    @PostMapping
    public ResponseEntity<LivreDTO> createLivre(@RequestBody LivreDTO livreDTO) {
        Livre livre = livreMapper.toEntity(livreDTO);
        Livre savedLivre = livreService.save(livre);
        LivreDTO savedLivreDTO = livreMapper.toDto(savedLivre);
        return ResponseEntity.ok(savedLivreDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivreDTO> getLivreById(@PathVariable Long id) {
        Livre livre = livreService.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("Personne not found"));
        LivreDTO livreDTO = livreMapper.toDto(livre);
        return ResponseEntity.ok(livreDTO); 
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable Long id) {
        livreService.deleteById(id);
    }
    
}
