package groupe7.indicateurs.application.livre.command;

import java.time.Year;
import java.util.Objects;

import groupe7.indicateurs.application.article.dto.ArticleDTO;

import java.util.List;
 

public class CreateLivreCommand extends LivreCommand {
    
    private Year annee;
    private String titre;
    private List<ArticleDTO> articles;
    

    public CreateLivreCommand(Year annee, String titre, List<ArticleDTO> articles) {
        this.annee = Objects.requireNonNull(annee, "L'année est obligatoire");
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire");
        this.articles=articles;
    }

    public Year getAnnee() {
        return annee;
    }
    public String getTitre() {
        return titre;
    }
    public List<ArticleDTO> getArticles() {
        return articles;
    }
    
}
