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
@WebServlet(name = "mes_encheres", urlPatterns = {"/mes_encheres"})
public class ListerMesEncheresServlet extends AutowireServlet {

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

        List<Article> articles = (List<Article>) articleService.findDistinctArticleByEncheresAcheteurId(u.getId());
        req.setAttribute("articles", articles);
        req.setAttribute("erreur", req.getParameter("erreur"));
        req.getRequestDispatcher("mes_encheres.jsp").forward(req, resp);

    }
}
