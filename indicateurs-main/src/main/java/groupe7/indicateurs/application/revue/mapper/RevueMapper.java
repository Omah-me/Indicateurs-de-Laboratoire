package groupe7.indicateurs.application.revue.mapper;

import org.springframework.stereotype.Component;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.application.revue.dto.RevueDTO;
import groupe7.indicateurs.domain.revue.model.Revue;

@Component
public class RevueMapper {

    public RevueDTO toDto(Revue revue) {
        if (revue == null) {
            return null;
        }

        RevueDTO dto = new RevueDTO();
        dto.setId(revue.getId());
        dto.setTitre(revue.getTitre());
        dto.setClassement(revue.getClassement());
        dto.setDomaine(revue.getDomaine());
        dto.setAnnee(revue.getAnnee());
        dto.setArticles(revue.getArticles().stream()
            .map(ArticleDTO::toDto)
            .toList()
        );

        return dto;
    }

    public Revue toEntity(RevueDTO dto) {
        if (dto == null) {
            return null;
        }

        Revue revue = new Revue();
        revue.setId(dto.getId());
        revue.setTitre(dto.getTitre());
        revue.setClassement(dto.getClassement());
        revue.setDomaine(dto.getDomaine());
        revue.setAnnee(dto.getAnnee());
        revue.setArticles(dto.getArticles().stream()
            .map(ArticleDTO::toEntity)
            .toList()
        );

        return revue;
    }
}
