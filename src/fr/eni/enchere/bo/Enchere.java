package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


public class Enchere   {
	int NoUtilisateur;
	int NoArticle;
	LocalDate dateEnchere;
	int montant_enchere;
	
	
	
	public int getNoUtilisateur() {
		return NoUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		NoUtilisateur = noUtilisateur;
	}
	public int getNoArticle() {
		return NoArticle;
	}
	public void setNoArticle(int noArticle) {
		NoArticle = noArticle;
	}
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + "]";
	}
	public Enchere(LocalDate date, int montant_enchere) {

		this.dateEnchere = date;
		this.montant_enchere = montant_enchere;
	}
	
	public Enchere() {
		
	}
	public Enchere(java.util.Date date, int montant_enchere2) {
		// TODO Auto-generated constructor stub
	}
	public Enchere(int no_utilisateur, int no_article, Date date, int montant_article) {
		// TODO Auto-generated constructor stub
	}
	
	
}

