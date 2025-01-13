package groupe7.indicateurs.web.conference.dto;

import java.time.Year;

import java.util.List;
import groupe7.indicateurs.web.article.dto.ArticleWebDTO;

public class ConferenceWebDTO {
    private Long id;
    private String titre;
    private String classe;
    private Year annee;
    private List<ArticleWebDTO> articles;


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
    
    public List<ArticleWebDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleWebDTO> articles) {
        this.articles = articles;
    }
}
