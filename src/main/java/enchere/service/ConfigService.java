/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.enumeration.StatutArticle;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {

    @Autowired
    private ArticleService articleService;

    public void finEnchere() {

        GregorianCalendar finEnchere = new GregorianCalendar();
        GregorianCalendar dateJour = new GregorianCalendar();

        for (Article article : articleService.findAll()) {
            finEnchere.setTime(article.getDateVente());
            if (article.getStatutArticle() == StatutArticle.DISPO) {
                if (dateJour.after(finEnchere) && article.getPrixDepart() < article.getPrixActuel()) {
                    article.setStatutArticle(StatutArticle.REMPORTE);
                    articleService.save(article);
                }
                if (dateJour.after(finEnchere) && article.getPrixDepart().equals(article.getPrixActuel())) {
                    article.setStatutArticle(StatutArticle.PERIME);
                    articleService.save(article);
                }
            }
        }
    }
}
