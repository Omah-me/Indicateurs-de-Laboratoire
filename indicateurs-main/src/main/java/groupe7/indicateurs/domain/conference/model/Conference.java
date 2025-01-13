package groupe7.indicateurs.domain.conference.model;

import java.time.Year;

import java.util.List;

import groupe7.indicateurs.domain.article.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cf_id_conf")
    private Long id;

    @Column(name = "cf_titre")
    private String titre;

    @Column(name = "cf_classe")
    private String classe;

    @Column(name = "cf_annee")
    private Year annee;

    @ManyToMany
    @JoinTable(
        name = "liaison_article_conference",
        joinColumns = @JoinColumn(name = "ac_id_conference"),
        inverseJoinColumns = @JoinColumn(name = "ac_id_article")
    )
    private List<Article> articles;


    public Conference() {
    }

    public Conference(String titre, String classe, Year annee) {
        this.titre = titre;
        this.classe = classe;
        this.annee = annee;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
