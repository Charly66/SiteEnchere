/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import enchere.enumeration.StatutArticle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String description;
    private Long prixDepart;
    private Long prixActuel;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    @Enumerated(EnumType.STRING)
    private StatutArticle statutArticle;
    

    @ManyToOne
    @JoinColumn(name = "CREATEUR_ID")
    private Utilisateur createur;
    
    @ManyToOne
    @JoinColumn(name = "ENCHERISSEUR_ID")
    private Utilisateur encherisseur;
    
    @OneToMany(mappedBy = "article")
    private List<Enchere> encheres = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID")
    private Categorie categorie;
    
    public Article() {
    }

    public Article(String nom, String description, Long prixDepart, Date dateVente) {
        this.nom = nom;
        this.description = description;
        this.prixDepart = prixDepart;
        this.dateVente = dateVente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Article[ id=" + id + " ]";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Long prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Long getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Long prixActuel) {
        this.prixActuel = prixActuel;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public StatutArticle getStatutArticle() {
        return statutArticle;
    }

    public void setStatutArticle(StatutArticle statutArticle) {
        this.statutArticle = statutArticle;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Utilisateur getEncherisseur() {
        return encherisseur;
    }

    public void setEncherisseur(Utilisateur encherisseur) {
        this.encherisseur = encherisseur;
    }
    
}
