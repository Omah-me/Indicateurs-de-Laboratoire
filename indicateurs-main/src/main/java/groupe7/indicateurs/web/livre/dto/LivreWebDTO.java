package groupe7.indicateurs.web.livre.dto;

import java.time.Year;
import java.util.List;

import groupe7.indicateurs.web.article.dto.ArticleWebDTO;

public class LivreWebDTO {
    private Long id;
    private Year annee;
    private String titre;
    private List<ArticleWebDTO> articles;

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

    public List<ArticleWebDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleWebDTO> articles) {
        this.articles = articles;
    }
}
