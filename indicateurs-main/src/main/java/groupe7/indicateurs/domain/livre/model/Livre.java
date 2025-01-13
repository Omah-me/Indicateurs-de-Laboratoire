package groupe7.indicateurs.domain.livre.model;

import java.time.Year;
import java.util.List;

import groupe7.indicateurs.domain.article.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Livre {

    @Id
    @Column(name = "li_id_article")
    private Long id;
    
    @Column(name = "li_annee")
    private Year annee;

    @Column(name = "li_titre")
    private String titre;

    @ManyToMany
    @JoinTable(
        name = "liaison_livre_article",
        joinColumns = @JoinColumn(name = "la_id_livre"),
        inverseJoinColumns = @JoinColumn(name = "la_id_article")
    )
    private List<Article> articles;


    public Livre(){
        
    }

    public Livre(Year annee, String titre){
        this.annee = annee;
        this.titre = titre;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
