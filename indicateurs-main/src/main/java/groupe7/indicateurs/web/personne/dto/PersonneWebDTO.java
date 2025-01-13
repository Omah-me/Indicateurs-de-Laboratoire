package groupe7.indicateurs.web.personne.dto;

import java.util.List;

import groupe7.indicateurs.web.article.dto.ArticleWebDTO;

public class PersonneWebDTO {
    private Long id;
    private String nom;
    private String prenom;
    private List<ArticleWebDTO> articles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<ArticleWebDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleWebDTO> articles) {
        this.articles = articles;
    }
}
