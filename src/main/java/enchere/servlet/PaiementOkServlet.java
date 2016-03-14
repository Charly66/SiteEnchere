/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.enumeration.StatutArticle;
import enchere.service.ArticleService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "paiement_ok", urlPatterns = {"/paiement_ok"})
public class PaiementOkServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("acheteur", utilisateurService.findByLogin((String) req.getSession().getAttribute("login")));
        
        Article article = articleService.findOne(Long.parseLong(req.getParameter("id")));
        article.setStatutArticle(StatutArticle.PAYE);
        articleService.save(article);
        req.setAttribute("article", article);
        
        req.getRequestDispatcher("paiement_ok.jsp").forward(req, resp);
    }

    

    
}
