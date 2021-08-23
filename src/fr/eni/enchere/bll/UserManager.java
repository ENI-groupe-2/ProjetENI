/*
 * BLL - Traitement des données/actions sur les utilisateurs en lien avec la DAL et DB
 */

package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.encheres.BusinessException;

public class UserManager {
	
// Instance fields
	private UtilisateurDAO utilisateurDAO;
	
// Constructors
	public UserManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
// Methods
	
	// Method "selectAll()"
	public List<Utilisateur> selectAll() throws BusinessException {
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		try {
			listeUtilisateurs = this.utilisateurDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}
	
	// Method "selectByNo()"
	public Utilisateur selectByNo(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur = this.utilisateurDAO.SelectByNo(noUtilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	// Method "updateUtilisateur()"
	public Utilisateur updateUtilisateur(	String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, boolean admin, int noUtilisateur) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		this.validationEmail(email, businessException);
		this.validationPseudo(pseudo, businessException);
		
		Utilisateur user = null;
		
		if (!businessException.hasErreurs()) {
			user = new Utilisateur();
			user.setPseudo(pseudo);
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setRue(rue);
			user.setCodePostal(codePostal);
			user.setVille(ville);
			user.setMotDePasse(motDePasse);
			user.setCredit(credit);
			user.setAdmin(admin);
			user.setNoUtilisateur(noUtilisateur);
			try {
				this.utilisateurDAO.UpdateUtilisateur(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw businessException;
		}
		return user;
	}
	
	// Method "delete"
	public void delete (int noUtilisateur) throws BusinessException {
		try {
			this.utilisateurDAO.delete(noUtilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Methods "validationEmail()" >> Nécessaire pour la method "updateUser()"
	private void validationEmail(String email, BusinessException businessException) {
		if(email != null) {
			if(!email.matches("^(.+)@(.+)$") ) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_EMAIL);;
			}
		} 
	}
	
	// Methods "validationPseudo()" >> Nécessaire pour la method "updateUser()"
	private void validationPseudo(String pseudo, BusinessException businessException) {
		if(pseudo != null) {
			if (!pseudo.matches("^[a-zA-Z0-9]*$ ")) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_PSEUDO);
			}
		} 
	}
	
}