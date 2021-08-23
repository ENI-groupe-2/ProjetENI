package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.encheres.BusinessException;

public interface EnchereDAO {
	//Insérer une nouvelle enchere
	public void insert(Enchere enchere) throws BusinessException;
	
	//Sélectionner toutes les enchere 
	public List<Enchere> selectAll() throws SQLException;

	public Enchere SelectByNoArticle(int id) throws SQLException;

	public void delete(int id_enchere) throws SQLException;
	

}
