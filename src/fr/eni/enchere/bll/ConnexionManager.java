
 // FUCKING USELESS > les connexions ne sont pas gérées par la DLL ...

package fr.eni.enchere.bll;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.encheres.BusinessException;

public class ConnexionManager {
	
// Instance fields
    
    private UtilisateurDAO utilisateurDAO;
     
    private static ConnexionManager connectionManager;
    
// Constructors
   
    
    public ConnexionManager() {
        this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
     }
    
 // Methods
    // Method "getInstanceEnchMana()" >> check si l'instance existe déjà, création si besoin, renvoie l'instance de "EnchereManager"
    public static ConnexionManager getConnexionManager() {
        if (connectionManager == null) {
        	connectionManager = new ConnexionManager();
        }
        return connectionManager;
    }
    
	
    public Boolean testerMotDePasse(String pseudo, String motDePasse) throws BusinessException 
   	{
   		
   		BusinessException businessException = new BusinessException();
   		Boolean bool = false;
   		Utilisateur utilisateurClient = null;
   		Utilisateur utilisateurBDD = null;
   		
   		
   		
   		if(!businessException.hasErreurs())
   		{
   			//saisie utilisateur 
   			utilisateurClient = new Utilisateur();
   			utilisateurClient.setPseudo(pseudo);
   			utilisateurClient.setMotDePasse(motDePasse); 
   			System.out.println(pseudo);
   			System.out.println(motDePasse);
   		}
   		else
   		{
   			throw businessException;
   		}

   		
   		
   		//Donnée dans la BDD
	try {
   			utilisateurBDD = new Utilisateur();
   			utilisateurBDD = utilisateurDAO.SelectByPseudo(pseudo);
   			System.out.println(utilisateurBDD.getPseudo().toString());
   			System.out.println(utilisateurBDD.getMotDePasse().toString());
   			
   		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
   		if (utilisateurBDD.getMotDePasse().toString().contentEquals(utilisateurClient.getMotDePasse().toString()) && utilisateurBDD.getPseudo().toString().contentEquals(utilisateurClient.getPseudo().toString())) {
			
   			bool = true;
   			System.out.println("CONNEXION OK");
		}else {
			bool = false;
			System.out.println("CONNEXION KO");
		}return bool;											
   		
   	}		
    	
}