/*
 * Couche BLL - Traitement données envoyées par le formulaire d'inscription (from client) vers la DAO
 * 
 * TODO : eMail et Pseudo des utilisateurs doivent être unique sur toute l'application
 */

package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.encheres.BusinessException;

public class InscriptionManager {
	
// Instance fields
	private int initialCredit = 0;
	private UtilisateurDAO utilisateurDAO;
	
// Constructors	
	private InscriptionManager(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	 }
	
// Methods
	
	// Method "inscriptionUser()" 
	public Utilisateur inscriptionUser(	String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, boolean admin) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		this.validationEmail(email, businessException);
		this.validationPassword(motDePasse, businessException);
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
			user.setAdmin(admin);
			user.setCredit(initialCredit);
			this.utilisateurDAO.insert(user);
		} else {
			throw businessException;
		}
		return user;
	}
	
	// Methods "validationEmail()" >> Nécessaire pour la method "inscriptionUser()"
	private void validationEmail(String email, BusinessException businessException) {
		if(email != null) {
			if(!email.matches("^(.+)@(.+)$") ) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_EMAIL);;
			}
		} else {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_EMAIL);
		}
	}
	
	// Methods "validationPseudo()" >> Nécessaire pour la method "inscriptionUser()"
	private void validationPseudo(String pseudo, BusinessException businessException) {
		if(pseudo != null) {
			if (!pseudo.matches("^[a-zA-Z0-9]*$ ")) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_PSEUDO);
			}
		} else {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_PSEUDO);
		}
	}
	
	// Methods "validationPassword()" >> Nécessaire pour la method "inscriptionUser()"
	private void validationPassword(String motDePasse, BusinessException businessException) {
		if(motDePasse == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDATION_PASSWORD);
		}
	}
}