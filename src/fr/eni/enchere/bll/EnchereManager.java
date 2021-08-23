/*
 * Couche BLL - Traitements nécessaires pour gérer les enchères via la DAL/DAO
 */

package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.encheres.BusinessException;

public class EnchereManager {

// Instance fields
	private EnchereDAO enchereDAO;
	
// Constructors
	private EnchereManager(EnchereDAO enchereDAO) {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	 }
	
// Methods
	
	// Method "encherir()" >> Faire un check des crédits dispo avant de pouvoir utiliser cette methode
	public Enchere encherir (LocalDate dateEnchere, int montant_enchere, int noUtilisateur, int noArticle) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		this.validationMontant(montant_enchere, businessException);
		
		Enchere enchere = new Enchere();
		if (!businessException.hasErreurs()) {
			enchere.setMontant_enchere(montant_enchere);
			enchere.setDateEnchere(dateEnchere);
			enchere.setNoUtilisateur(noUtilisateur);
			enchere.setNoArticle(noArticle);
			try {
				this.enchereDAO.insert(enchere);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		} else {
			throw businessException;
		}
		return enchere;
	}
	
	// Method "selectAll()"
	public List<Enchere> selectAll() throws BusinessException {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		try {
			listeEncheres = this.enchereDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeEncheres;
	}
	
	// Method "selectByNoArticle()"
	public Enchere selectByNoArticle(int noArticle) throws BusinessException {
		Enchere enchere = new Enchere();
		try {
			enchere = this.enchereDAO.SelectByNoArticle(noArticle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enchere;
	}
	
	// Method "delete()"
	public void delete (int noEnchere) throws BusinessException {
		try {
			this.enchereDAO.delete(noEnchere);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Method "validationMontant()" 
	private void validationMontant(int montant_enchere, BusinessException businessException) {
		if (montant_enchere != 0) {
			if (montant_enchere <= 0) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_MONTANT_ENCHERE);
			} 
		} else {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_MONTANT_ENCHERE);
		}
	}
	
}