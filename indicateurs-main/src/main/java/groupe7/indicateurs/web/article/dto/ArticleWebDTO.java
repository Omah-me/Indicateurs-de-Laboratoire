package groupe7.indicateurs.web.article.dto;

import java.time.LocalDate;
import java.util.List;

import groupe7.indicateurs.web.conference.dto.ConferenceWebDTO;
import groupe7.indicateurs.web.livre.dto.LivreWebDTO;
import groupe7.indicateurs.web.personne.dto.PersonneWebDTO;
import groupe7.indicateurs.web.revue.dto.RevueWebDTO;

public class ArticleWebDTO {
    private Long id;
    private String titre;
    private LocalDate date;
    private List<LivreWebDTO> livres;
    private List<PersonneWebDTO> personnes;
    private List<RevueWebDTO> revues;
    private List<ConferenceWebDTO> conferences;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<LivreWebDTO> getLivres() {
        return livres;
    }

    public void setLivres(List<LivreWebDTO> livres) {
        this.livres = livres;
    }

    public List<PersonneWebDTO> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<PersonneWebDTO> personnes) {
        this.personnes = personnes;
    }

    public List<ConferenceWebDTO> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceWebDTO> conferences) {
        this.conferences = conferences;
    }

    public List<RevueWebDTO> getRevues() {
        return revues;
    }

    public void setRevue(List<RevueWebDTO> revues) {
        this.revues = revues;
    }
}
