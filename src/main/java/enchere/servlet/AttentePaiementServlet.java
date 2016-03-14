/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

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
@WebServlet(name = "attente_paiement", urlPatterns = {"/attente_paiement"})
public class AttentePaiementServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u = utilisateurService.findByLogin((String) req.getSession().getAttribute("login"));
        u.setNom(req.getParameter("nom"));
        u.setPrenom(req.getParameter("prenom"));
        u.setAdresse(req.getParameter("adresse"));
        u.setCodePostal(Long.parseLong(req.getParameter("codePostal")));
        u.setVille(req.getParameter("ville"));
        utilisateurService.save(u);
        req.setAttribute("acheteur", u);
        req.setAttribute("article", articleService.findOne(Long.parseLong(req.getParameter("id"))));
        
        if(req.getParameter("modePaiement").equals("Paypal")){
            req.getRequestDispatcher("attente_paiement.jsp").forward(req, resp);
        }
        
        if(req.getParameter("modePaiement").equals("Visa")){
            req.getRequestDispatcher("attente_paiement.jsp").forward(req, resp);
        }
    }

    

    
}
