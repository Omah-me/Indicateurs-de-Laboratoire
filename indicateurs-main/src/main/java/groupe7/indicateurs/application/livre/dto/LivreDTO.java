package groupe7.indicateurs.application.livre.dto;

import java.time.Year;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.domain.livre.model.Livre;
import java.util.List;

public class LivreDTO {
    private Long id;
    private Year annee;
    private String titre;
    private List<ArticleDTO> articles;

    public LivreDTO(){

    }

    public LivreDTO(Long id, Year annee, String titre) {
        this.id = id;
        this.annee=annee;
        this.titre=titre;
    }

    public static LivreDTO toDto(Livre entity) {
        return new LivreDTO(
            entity.getId(),
            entity.getAnnee(),
            entity.getTitre()
        );
    }

    public static Livre toEntity(LivreDTO dto) {
        return new Livre(
            dto.getAnnee(),
            dto.getTitre()
        );
    }


    // Getters
    public Long getId() {
        return id;
    }
   
    public Year getAnnee() {
        return annee;
    }

    public String getTitre() {
        return titre;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setArticles(List<ArticleDTO> articles){
        this.articles=articles;
    }

    public List<ArticleDTO> getArticles(){
        return articles;
    }
}
