package groupe7.indicateurs.application.article.command;

import java.time.LocalDate;
import java.util.Objects;
import java.util.List;

import groupe7.indicateurs.application.conference.dto.ConferenceDTO;
import groupe7.indicateurs.application.livre.dto.LivreDTO;
import groupe7.indicateurs.application.personne.dto.PersonneDTO;
import groupe7.indicateurs.application.revue.dto.RevueDTO;

public class CreateArticleCommand extends ArticleCommand {
    private String titre;
    private LocalDate date;
    private List<LivreDTO> livres;
    private List<PersonneDTO> personnes;
    private List<RevueDTO> revues;
    private List<ConferenceDTO> conferences;

    public CreateArticleCommand(String titre, LocalDate date, List<LivreDTO> livres, List<PersonneDTO> personnes,List<ConferenceDTO> conferences,List<RevueDTO> revues) {
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire");
        this.date = Objects.requireNonNull(date, "La date est obligatoire");   
        this.livres=livres;
        this.personnes=personnes;
        this.revues=revues;
        this.conferences=conferences;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<LivreDTO> getLivres() {
        return livres;
    }

    public List<PersonneDTO> getPersonnes(){
        return personnes;
    }

    public List<ConferenceDTO> getConferences(){
        return conferences;
    }

    public List<RevueDTO> getRevues(){
        return revues;
    }
    
}
