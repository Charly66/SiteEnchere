/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.ConfigService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "mes_articles", urlPatterns = {"/mes_articles"})
public class ListerMesArticlesServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private ConfigService configService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        configService.finEnchere();

        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));

        List<Article> articles = (List<Article>) articleService.findByCreateurId(u.getId());
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("mes_articles.jsp").forward(req, resp);

    }
}
