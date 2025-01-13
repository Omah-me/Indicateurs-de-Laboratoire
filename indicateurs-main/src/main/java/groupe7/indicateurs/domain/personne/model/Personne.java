package groupe7.indicateurs.domain.personne.model;

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
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pe_id_personne")
    private Long id;
    
    @Column(name = "pe_nom")
    private String nom;

    @Column(name = "pe_prenom")
    private String prenom;

    @Column(name = "pe_hdr")
    private Boolean hdr;

    @ManyToMany
    @JoinTable(
        name = "liaison_personne_article",
        joinColumns = @JoinColumn(name = "au_id_personne"),
        inverseJoinColumns = @JoinColumn(name = "au_id_article")
    )
    private List<Article> articles;

    public Personne() {
    }

    public Personne(String nom, String prenom, Boolean hdr) {
        this.nom = nom;
        this.prenom = prenom;
        this.hdr = hdr;
    }

    public Long getId() {
        return id;
    }
   
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}