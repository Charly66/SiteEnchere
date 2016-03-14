/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.test;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.enumeration.StatutArticle;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.SpringConfig;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author admin
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(SpringConfig.class)
//public class EnchereTest {
//    
//    @Autowired
//    private ArticleService articleService;
//    @Autowired
//    private CategorieService categorieService;
//    @Autowired
//    private EnchereService enchereService;
//    @Autowired
//    private UtilisateurService utilisateurService;
//    
//    
//  //  @Test
//    public void testEntity(){
//        Article a1 = new Article("nom", "description", 10L, new Date(2016, 3, 13));
//        a1.setStatutArticle(StatutArticle.DISPO);
//        a1.setId(1L);
//        a1.setPrixActuel(a1.getPrixDepart());
//        
//        Categorie c1 = new Categorie("nom");
//        Enchere e1 = new Enchere();
//        Utilisateur u1 = new Utilisateur("login", "password");
//        
//        a1.setCreateur(u1);
//        a1.setCategorie(c1);
//        a1.getEncheres().add(e1);
//        
//        articleService.save(a1);
//        categorieService.save(c1);
//        enchereService.save(e1);
//        utilisateurService.save(u1);
//        
//        u1.getArticles().add(a1);
//        u1.getEncheres().add(e1);
//        
//        c1.getArticles().add(a1);
//        e1.setAcheteur(u1);
//        e1.setArticle(a1);
//        
//        articleService.save(a1);
//        categorieService.save(c1);
//        enchereService.save(e1);
//        utilisateurService.save(u1);
//        
//    }
//    
//}
