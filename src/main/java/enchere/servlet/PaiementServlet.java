/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "paiement", urlPatterns = {"/paiement"})
public class PaiementServlet extends AutowireServlet  {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        req.setAttribute("article", articleService.findOne(Long.parseLong(req.getParameter("id"))));
        req.setAttribute("acheteur", u);
        req.getRequestDispatcher("paiement.jsp").forward(req, resp);
        
   }

    
}
