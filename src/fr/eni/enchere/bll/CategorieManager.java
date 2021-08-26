package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.encheres.BusinessException;

public class CategorieManager {
private CategorieDAO categorieDAO;

public CategorieManager() {
this.categorieDAO=DAOFactory.getCategorieDAO();
}

//méthode pour ajouter categorie
	public Categorie ajouterCategorie(int noCategorie, String libelle) throws BusinessException {
		BusinessException businessException = new BusinessException();
		Categorie categorie = new Categorie(noCategorie, libelle);


		if(!businessException.hasErreurs()) {
			try {
				this.categorieDAO.insert(categorie);;
			} catch (BusinessException e) {

				e.printStackTrace();
			}
		}
		if(businessException.hasErreurs()) {
			throw businessException;
		}

		return categorie;
	}


	//méthode liste des différents retraits
		public List<Categorie> selectAll() throws BusinessException {
			List<Categorie> listeCategorie = new ArrayList<Categorie>();
			try {
				listeCategorie = this.categorieDAO.selectAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listeCategorie;
		}







}