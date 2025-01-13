package groupe7.indicateurs.application.article.mapper;

import org.springframework.stereotype.Component;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.application.livre.dto.LivreDTO;
import groupe7.indicateurs.application.personne.dto.PersonneDTO;
import groupe7.indicateurs.application.conference.dto.ConferenceDTO;
import groupe7.indicateurs.application.revue.dto.RevueDTO;
import groupe7.indicateurs.domain.article.model.Article;

@Component
public class ArticleMapper {
    
    public ArticleDTO toDto(Article article) {
        if (article == null) {
            return null;
        }

        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitre(article.getTitre());
        dto.setDate(article.getDate());
        dto.setLivres(article.getLivres().stream()
            .map(LivreDTO::toDto)
            .toList()
        );

        dto.setPersonnes(article.getPersonnes().stream()
            .map(PersonneDTO::toDto)
            .toList()
        );
        dto.setConferences(article.getConferences().stream()
            .map(ConferenceDTO::toDto)
            .toList()
        );
        dto.setRevues(article.getRevues().stream()
            .map(RevueDTO::toDto)
            .toList()
        );
                
        return dto;
    }

    public Article toEntity(ArticleDTO dto) {
        if (dto == null) {
            return null;
        }

        Article article = new Article();
        article.setId(dto.getId());
        article.setTitre(dto.getTitre());
        article.setDate(dto.getDate());
        article.setLivres(dto.getLivres().stream()
            .map(LivreDTO::toEntity)
            .toList()
        );
        article.setPersonnes(dto.getPersonnes().stream()
            .map(PersonneDTO::toEntity)
            .toList()
        );
        article.setConferences(dto.getConferences().stream()
            .map(ConferenceDTO::toEntity)
            .toList()
        );
        article.setRevue(dto.getRevues().stream()
            .map(RevueDTO::toEntity)
            .toList()
        );

        return article;
    }
}
