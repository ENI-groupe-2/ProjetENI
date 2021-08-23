package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public interface UtilisateurDAO {

	//Insérer une nouvelle enchere
	public void insert(Utilisateur utilisateur) throws  BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<Utilisateur> selectAll() throws SQLException;

	public Utilisateur SelectByNo(int id) throws SQLException;

	public void UpdateUtilisateur(Utilisateur utilisateur) throws SQLException;

	public void delete(int id) throws SQLException;

	public Utilisateur SelectByPseudo(String pseudo) throws SQLException;

	

}

