package groupe7.indicateurs.application.conference.command;

import java.time.Year;
import java.util.Objects;

import java.util.List;

import groupe7.indicateurs.application.article.dto.ArticleDTO;

public class UpdateConferenceCommand extends ConferenceCommand {
    private long id;
    private String titre;
    private String classe;
    private Year annee;
    private List<ArticleDTO> articles;


    public UpdateConferenceCommand(long id, String titre, String classe, Year annee,  List<ArticleDTO> articles) {
        this.id = Objects.requireNonNull(id, "L'identifiant est obligatoire");
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire");
        this.classe = Objects.requireNonNull(classe, "La classe est obligatoire");
        this.annee = Objects.requireNonNull(annee, "L'année est obligatoire");
        this.articles=articles;
    }

    // Getters
    
    public long getId() {
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

    public List<ArticleDTO> getArticles() {
        return articles;
    }
}
