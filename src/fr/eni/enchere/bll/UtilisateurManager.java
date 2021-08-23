package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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


			
			
			this.utilisateurDAO.insert(utilisateur);;
		}
		else
		{
			throw businessException;
		}
		return utilisateur;
	}}