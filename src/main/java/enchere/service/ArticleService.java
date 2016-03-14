/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.enumeration.StatutArticle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public List<Article> findByStatutArticle(StatutArticle statut);
    public List<Article> findByCreateurIdNotAndStatutArticle(Long id, StatutArticle statut);
    public List<Article> findByCreateurId(Long id);
    public List<Article> findDistinctArticleByEncheresAcheteurId(Long id);
    public List<Article> findDistinctArticleByEncheresAcheteurIdAndStatutArticle(Long id, StatutArticle statut);
    
}
