/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
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
@WebServlet(name = "AjoutUtilisateurServlet", urlPatterns = {"/ajout_utilisateur"})
public class AjoutUtilisateurServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        for( Utilisateur u : utilisateurService.findAll()){
            if (u.getLogin().equals(req.getParameter("login"))){
                req.setAttribute("loginError", "Login deja existant");
            req.getRequestDispatcher("ajout_utilisateur.jsp").forward(req, resp);
            }
        }
        
        utilisateurService.save(new Utilisateur(req.getParameter("login"), req.getParameter("password")));
        req.getRequestDispatcher("login").forward(req, resp);
    }

    
    
}
