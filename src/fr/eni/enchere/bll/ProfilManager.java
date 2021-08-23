/*
 * BLL - 
 */

package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.ProfilDAO;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.encheres.BusinessException;

public class ProfilManager {
	
// Instance fields
	
	private ProfilDAO profilDAO;
	
// Constructors
	public ProfilManager() {
		this.profilDAO = DAOFactory.getProfilDAO();
	}
	
// Methods
	
	// Method "selectByPeudo()"
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur = this.profilDAO.SelectByPseudo(pseudo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}}