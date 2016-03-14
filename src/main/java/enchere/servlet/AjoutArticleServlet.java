/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.enumeration.StatutArticle;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "ajout_article", urlPatterns = {"/ajout_article"})
public class AjoutArticleServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        GregorianCalendar dateVente = new GregorianCalendar();
        dateVente.add((GregorianCalendar.DAY_OF_YEAR),Integer.parseInt(req.getParameter("dureeEnchere")));
        
        Article article = new Article(req.getParameter("titre"), req.getParameter("description"), Long.parseLong(req.getParameter("prixDepart")), dateVente.getTime() );
        article.setStatutArticle(StatutArticle.DISPO);
        article.setCategorie(categorieService.findByNom(req.getParameter("categorie")));
        article.setPrixActuel(article.getPrixDepart());
        article.setCreateur(utilisateurService.findByLogin((String) req.getSession().getAttribute("login")));
        articleService.save(article);
        
        resp.sendRedirect("lister_articles?log=true");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if (req.getSession().getAttribute("login") == null){
            req.setAttribute("loginError", "Vous n'etes pas connecté");
            req.getRequestDispatcher("TEMPLATE.jsp").forward(req, resp);
        }
        
        req.setAttribute("date", new Date());
        req.getRequestDispatcher("ajout_article.jsp").forward(req, resp);
    }
    
    
    
    
}
