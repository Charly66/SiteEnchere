/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
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
@WebServlet(name = "ajout_categorie", urlPatterns = {"/ajout_categorie"})
public class AjoutCategorieServlet extends AutowireServlet {

    @Autowired
    private CategorieService categorieService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (categorieService.findByNom(req.getParameter("nom")) == null) {
            categorieService.save(new Categorie(req.getParameter("nom")));
            req.setAttribute("retour", "Catégorie ajoutée avec succès");
            resp.sendRedirect("ajout_categorie?combobox=false");
        } else {
            req.setAttribute("retour", "La catégorie spécifiée existe déjà");
            req.getRequestDispatcher("ajout_categorie.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> categories = (List<Categorie>) categorieService.findAll();
        req.setAttribute("categories", categories);

        if (req.getParameter("combobox").equals("false")) {
            req.getRequestDispatcher("ajout_categorie.jsp").forward(req, resp);
        }
    }
}
