package groupe7.indicateurs.application.revue.command;

import java.time.Year;
import java.util.Objects;
import java.util.List;
import groupe7.indicateurs.application.article.dto.ArticleDTO;


public class CreateRevueCommand extends RevueCommand {
    private String titre;
    private String classement;
    private String domaine;
    private Year annee;
    private List<ArticleDTO> articles;


    public CreateRevueCommand(String titre, String classement, String domaine, Year annee, List<ArticleDTO> articles) {
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire");
        this.classement = Objects.requireNonNull(classement, "Le classement est obligatoire");
        this.domaine = Objects.requireNonNull(domaine, "Le domaine est obligatoire");
        this.annee = Objects.requireNonNull(annee, "L'année est obligatoire");
        this.articles=articles;
    }

    // Getters
    
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
