package groupe7.indicateurs.application.revue.command;

import java.time.Year;
import java.util.Objects;
import java.util.List;
import groupe7.indicateurs.application.article.dto.ArticleDTO;


public class UpdateRevueCommand extends RevueCommand {
    private long id;
    private String titre;
    private String classement;
    private String domaine;
    private Year annee;
    private List<ArticleDTO> articles;

    public UpdateRevueCommand(long id, String titre, String classement, String domaine, Year annee, List<ArticleDTO> articles) {
        this.id = Objects.requireNonNull(id, "L'identifiant est obligatoire");
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire");
        this.classement = Objects.requireNonNull(classement, "Le classement est obligatoire");
        this.domaine = Objects.requireNonNull(domaine, "Le domaine est obligatoire");
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

    public String getClassement() {
        return classement;
    }

    public String getDomaine() {
        return domaine;
    }

    public Year getAnnee() {
        return annee;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }
}
