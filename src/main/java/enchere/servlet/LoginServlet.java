/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.service.ConfigService;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private ConfigService configService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        configService.finEnchere();
        
        if (utilisateurService.findByLogin(req.getParameter("login")) == null) {

            req.setAttribute("loginError", "Mauvais login");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        if (utilisateurService.findByLogin(req.getParameter("login")).getPassword().equals(req.getParameter("password"))) {
            req.getSession().setAttribute("login", req.getParameter("login"));
            req.getSession().setAttribute("password", req.getParameter("password"));
            resp.sendRedirect("panier");
        } else {
            req.setAttribute("loginError", "Mauvais password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("value").equals("false")) {
            req.getSession().invalidate();
            resp.sendRedirect("TEMPLATE.jsp");
        }

    }

}
