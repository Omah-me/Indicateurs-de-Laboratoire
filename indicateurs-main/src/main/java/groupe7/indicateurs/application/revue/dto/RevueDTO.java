package groupe7.indicateurs.application.revue.dto;

import java.time.Year;
import java.util.List;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.domain.revue.model.Revue;

public class RevueDTO {

    private Long id;
    private String titre;
    private String classement;
    private String domaine;
    private Year annee;
    private List<ArticleDTO> articles;

    public RevueDTO() {
    }

    public RevueDTO(Long id, String titre, String classement, String domaine, Year annee) {
        this.id = id;
        this.titre = titre;
        this.classement = classement;
        this.domaine = domaine;
        this.annee = annee;
    }

    public static RevueDTO toDto(Revue entity) {
        return new RevueDTO(
            entity.getId(),
            entity.getTitre(),
            entity.getClassement(),
            entity.getDomaine(),
            entity.getAnnee()
        );
    }

    public static Revue toEntity(RevueDTO dto) {
        return new Revue(
            dto.getAnnee(),
            dto.getTitre(),
            dto.getClassement(),
            dto.getDomaine()
        );
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getClassement() {
        return classement;
    }

    public String getDomaine() {
        return domaine;
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

    public void setClassement(String classement) {
        this.classement = classement;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
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
