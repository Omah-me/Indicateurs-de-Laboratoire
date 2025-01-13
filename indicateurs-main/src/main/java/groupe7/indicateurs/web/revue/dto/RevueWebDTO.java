package groupe7.indicateurs.web.revue.dto;

import java.time.Year;

import java.util.List;
import groupe7.indicateurs.web.article.dto.ArticleWebDTO;

public class RevueWebDTO {
    private Long id;
    private String titre;
    private String classement;
    private String domaine;
    private Year annee;
    private List<ArticleWebDTO> articles;


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

    public List<ArticleWebDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleWebDTO> articles) {
        this.articles = articles;
    }
}
