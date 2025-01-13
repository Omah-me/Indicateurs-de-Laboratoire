package groupe7.indicateurs.domain.revue.model;

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
public class Revue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "re_id_revue")
    private Long id;

    @Column(name = "re_annee")
    private Year annee;

    @Column(name = "re_titre")
    private String titre;

    @Column(name = "re_classement")
    private String classement;

    @Column(name = "re_domaine")
    private String domaine;

    @ManyToMany
    @JoinTable(
        name = "liaison_article_revue",
        joinColumns = @JoinColumn(name = "ar_id_revue"),
        inverseJoinColumns = @JoinColumn(name = "ar_id_article")
    )
    private List<Article> articles;

    public Revue() {
    }

    public Revue(Year annee, String titre, String classement, String domaine) {
        this.annee = annee;
        this.titre = titre;
        this.classement = classement;
        this.domaine = domaine;
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

    public String getClassement() {
        return classement;
    }

    public String getDomaine() {
        return domaine;
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

    public void setClassement(String classement) {
        this.classement = classement;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
