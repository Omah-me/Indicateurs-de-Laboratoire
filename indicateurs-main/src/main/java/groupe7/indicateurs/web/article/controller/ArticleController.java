package groupe7.indicateurs.web.article.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe7.indicateurs.application.article.dto.ArticleDTO;
import groupe7.indicateurs.application.article.mapper.ArticleMapper;
import groupe7.indicateurs.application.article.service.ArticleService;
import groupe7.indicateurs.domain.article.model.Article;
import groupe7.indicateurs.domain.exception.ResourceNotFoundException;



@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        Article savedArticle = articleService.save(article);
        ArticleDTO savedArticleDTO = articleMapper.toDto(savedArticle);
        return ResponseEntity.ok(savedArticleDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        Article article = articleService.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException("Personne not found"));
        ArticleDTO articleDTO = articleMapper.toDto(article);
        return ResponseEntity.ok(articleDTO); 
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteById(id);
    }
    
    @GetMapping
public ResponseEntity<List<ArticleDTO>> getArticlesByTitre(@RequestParam(name = "titre", required = false) String titre) {
    List<Article> articles = articleService.getArticlesByTitre(titre);
    List<ArticleDTO> articleDTOs = articles.stream()
                                           .map(articleMapper::toDto)
                                           .toList();
    return ResponseEntity.ok(articleDTOs);
}

}
