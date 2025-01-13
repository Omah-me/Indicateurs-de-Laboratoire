package groupe7.indicateurs.application.article.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe7.indicateurs.domain.article.model.Article;
import groupe7.indicateurs.domain.article.repository.ArticleRepository;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }
    
    public Article save(Article article) {
       return articleRepository.save(article);
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    public List<Article> getArticlesByTitre(String titre) {
        return articleRepository.findByTitre(titre);
    }
    
}
