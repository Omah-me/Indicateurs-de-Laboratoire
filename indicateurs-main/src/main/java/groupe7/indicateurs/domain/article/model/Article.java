package groupe7.indicateurs.domain.article.model;

import java.time.LocalDate;
import java.util.List;

import groupe7.indicateurs.domain.conference.model.Conference;
import groupe7.indicateurs.domain.livre.model.Livre;
import groupe7.indicateurs.domain.personne.model.Personne;
import groupe7.indicateurs.domain.revue.model.Revue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "at_id_article")
    private Long id;
    
    @Column(name = "at_titre")
    private String titre;

    @Column(name = "at_date")
    private LocalDate date;


    @ManyToMany
    @JoinTable(
        name = "liaison_livre_article",
        joinColumns = @JoinColumn(name = "la_id_article"),
        inverseJoinColumns = @JoinColumn(name = "la_id_livre")
    )
    private List<Livre> livres;

    @ManyToMany
    @JoinTable(
        name = "liaison_personne_article",
        joinColumns = @JoinColumn(name = "au_id_personne"),
        inverseJoinColumns = @JoinColumn(name = "au_id_article")
    )
    private List<Personne> personnes;

    @ManyToMany
    @JoinTable(
        name = "liaison_article_conference",
        joinColumns = @JoinColumn(name = "ac_id_article"),
        inverseJoinColumns = @JoinColumn(name = "ac_id_conference")
    )
    private List<Conference> conferences;

    @ManyToMany
    @JoinTable(
        name = "liaison_article_revue",
        joinColumns = @JoinColumn(name = "ar_id_article"),
        inverseJoinColumns = @JoinColumn(name = "ar_id_revue")
    )
    private List<Revue> revues;


    public Article(){
        
    }

    public Article(String titre, LocalDate date){
        this.titre=titre;
        this.date = date;
    }

    public Long getId() {
        return id;
    }
   
    public String getTitre() {
        return titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public List<Revue> getRevues() {
        return revues;
    }

    public void setRevue(List<Revue> revues) {
        this.revues = revues;
    }
}
