/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
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
@WebServlet(name = "encherir", urlPatterns = {"/encherir"})
public class EnchereServlet extends AutowireServlet {

    @Autowired
    private EnchereService enchereService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("login") == null) {
            req.setAttribute("enchereError", "Vous devez être connecté pour enchérir");
            req.getRequestDispatcher("lister_articles").forward(req, resp);
            return;
        }

        GregorianCalendar date = new GregorianCalendar();
        GregorianCalendar dateVente = new GregorianCalendar();
        dateVente.setTime(articleService.findOne(Long.parseLong(req.getParameter("id"))).getDateVente());
        Enchere enchere = new Enchere();
        Utilisateur utilisateur = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        Article article = articleService.findOne(Long.parseLong(req.getParameter("id")));

        if (utilisateur.equals(article.getEncherisseur())) {
            req.setAttribute("erreur", "Impossible : vous etes le dernier enchérisseur");
        } else if (date.before(dateVente)) {

            enchere.setDateEnchere(new Date());
            enchere.setAcheteur(utilisateur);
            utilisateur.getEncheres().add(enchere);
            enchere.setArticle(article);
            article.getEncheres().add(enchere);
            article.setEncherisseur(utilisateur);
            article.setPrixActuel(article.getPrixActuel() + 10);

            enchereService.save(enchere);
            utilisateurService.save(utilisateur);
            articleService.save(article);
        }
        if (req.getParameter("enchere").equals("true")) {
            resp.sendRedirect("mes_encheres");
            return;
        }
        resp.sendRedirect("lister_articles");
    }

}
