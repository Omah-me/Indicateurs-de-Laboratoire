package groupe7.indicateurs.application.article.dto;

import java.time.LocalDate;
import java.util.List;

import groupe7.indicateurs.application.conference.dto.ConferenceDTO;
import groupe7.indicateurs.application.livre.dto.LivreDTO;
import groupe7.indicateurs.application.personne.dto.PersonneDTO;
import groupe7.indicateurs.application.revue.dto.RevueDTO;
import groupe7.indicateurs.domain.article.model.Article;

public class ArticleDTO {
    private Long id;
    private LocalDate date;
    private String titre;
    private List<LivreDTO> livres;
    private List<PersonneDTO> personnes;
    private List<RevueDTO> revues;
    private List<ConferenceDTO> conferences;


    public ArticleDTO(){

    }

    public ArticleDTO(Long id,LocalDate date,String titre){
        this.id=id;
        this.date=date;
        this.titre=titre;
    }

    public static ArticleDTO toDto(Article entity) {
        return new ArticleDTO(
            entity.getId(),
            entity.getDate(),
            entity.getTitre()
        );
    }

    public static Article toEntity(ArticleDTO dto) {
        return new Article(
            dto.getTitre(),
            dto.getDate()
        );
    }

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

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public List<LivreDTO> getLivres() {
        return livres;
    }

    public void setLivres(List<LivreDTO> livres) {
        this.livres = livres;
    }

    public List<PersonneDTO> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<PersonneDTO> personnes) {
        this.personnes = personnes;
    }

    public List<ConferenceDTO> getConferences(){
        return conferences;
    }

    public void setConferences(List<ConferenceDTO> conferences) {
        this.conferences = conferences;
    }

    public List<RevueDTO> getRevues(){
        return revues;
    }

    public void setRevues(List<RevueDTO> revues) {
        this.revues = revues;
    }
}
