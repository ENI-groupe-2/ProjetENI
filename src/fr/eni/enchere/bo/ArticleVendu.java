package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class ArticleVendu {

	int  noArticle;
	String nomArticle;
	String description;
	LocalDate dateDebutEncheres;
	LocalDate dateFinEncheres;
	int miseAPrix;
	int prixVente;
	String etatVente;
	int noUtilisateur;
	int noCategorie;
	
	
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	public int getCategorie() {
		return noCategorie;
	}
	public void setCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente) {
	
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int noUtilisateur, int noCategorie ) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente) {
	

		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
	}
	
	public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int miseAPrix, int prixVente) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public ArticleVendu(int noarticle, String nomarticle, String description, LocalDate debut, LocalDate fin, int prixinit, int prixvente) {

		this.noArticle = noarticle;
		this.nomArticle = nomarticle;
		this.description = description;
		this.dateDebutEncheres = debut;
		this.dateFinEncheres = fin;
		this.miseAPrix = prixinit;
		this.prixVente = prixvente;
		
		
	}
	public ArticleVendu(int int1, String string, String string2, int int2, Date date) {
		// TODO Auto-generated constructor stub
	}
	public ArticleVendu() {
		// TODO Auto-generated constructor stub
	}
	public ArticleVendu(int int1, String string, String string2, Date date, Date date2, int int2, int int3) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
	}
	
	
	
}
