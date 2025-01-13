package groupe7.indicateurs.application.conference.dto;

import java.time.Year;

import java.util.List;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.domain.conference.model.Conference;

public class ConferenceDTO {

    private Long id;
    private String titre;
    private String classe;
    private Year annee;
    private List<ArticleDTO> articles;


    public ConferenceDTO() {
    }

    public ConferenceDTO(Long id, String titre, String classe, Year annee) {
        this.id = id;
        this.titre = titre;
        this.classe = classe;
        this.annee = annee;
    }

    public static ConferenceDTO toDto(Conference entity) {
        return new ConferenceDTO(
            entity.getId(),
            entity.getTitre(),
            entity.getClasse(),
            entity.getAnnee()
        );
    }

    public static Conference toEntity(ConferenceDTO dto) {
        return new Conference(
            dto.getTitre(),
            dto.getClasse(),
            dto.getAnnee()
        );
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getClasse() {
        return classe;
    }

    public Year getAnnee() {
        return annee;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public void setArticles(List<ArticleDTO> articles){
        this.articles=articles;
    }

    public List<ArticleDTO> getArticles(){
        return articles;
    }
}
