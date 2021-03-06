package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.encheres.BusinessException;


public class UtilisateurManager {

// Instance fields
    
    private UtilisateurDAO utilisateurDAO;
     
    private static UtilisateurManager utilisateurManager;
    
// Constructors
   
    
    public UtilisateurManager() {
        this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
     }
    
    
// Methods
    // Method "getInstanceEnchMana()" >> check si l'instance existe déjà, création si besoin, renvoie l'instance de "EnchereManager"
    public static UtilisateurManager getutilisateurManager() {
        if (utilisateurManager == null) {
        	utilisateurManager = new UtilisateurManager();
        }
        return utilisateurManager;
    }
    
    // Method "encherir()" >> Faire un check des crédits dispo avant de pouvoir utiliser cette methode
    public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, boolean admin) throws BusinessException 
	{
		
		BusinessException businessException = new BusinessException();
		
		
		Utilisateur utilisateur = null;
		
		if(!businessException.hasErreurs())
		{
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setCredit(0);
			utilisateur.isAdmin();
	
			this.utilisateurDAO.insert(utilisateur);
	
		}
		else
			
		{
			throw businessException;
		}
		return utilisateur;
	}
	// Method "selectByPeudo()"
	public Utilisateur selectByNo(int No) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		if (this.utilisateurDAO==null) {
			this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
		}
		try {
			utilisateur = this.utilisateurDAO.SelectByNo(No);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}


	public void delete(int id) throws BusinessException {
		
		if (this.utilisateurDAO==null) {
			this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
		}
		try {
			this.utilisateurDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

// Method "selectByPeudo()"
public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
	Utilisateur utilisateur = new Utilisateur();
	try {
		utilisateur = this.utilisateurDAO.SelectByPseudo(pseudo);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return utilisateur;
}    

//Method "updateUtilisateur()"
	public Utilisateur UpdateUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int no_utilisateur) throws BusinessException {
		
		BusinessException businessException = new BusinessException();
		//this.validationEmail(email, businessException);
		//this.validationPseudo(pseudo, businessException);
		
		Utilisateur utilisateur = null;
		
		if (!businessException.hasErreurs()) {
			utilisateur = new Utilisateur();
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			utilisateur.setMotDePasse(motDePasse);
			utilisateur.setNoUtilisateur(no_utilisateur);
			try {
				this.utilisateurDAO.UpdateUtilisateur(utilisateur);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw businessException;
		}
		return utilisateur;
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