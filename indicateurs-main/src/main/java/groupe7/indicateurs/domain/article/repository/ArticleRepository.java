package groupe7.indicateurs.domain.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import groupe7.indicateurs.domain.article.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    @Query("SELECT a FROM Article a WHERE a.titre LIKE %:titre%")
List<Article> findByTitre(@Param("titre") String titre);

}
