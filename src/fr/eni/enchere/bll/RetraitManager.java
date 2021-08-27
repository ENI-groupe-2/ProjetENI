package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.RetraitDAO;
import fr.eni.encheres.BusinessException;

public class RetraitManager {

	private RetraitDAO retraitDAO;
	
	public RetraitManager() {
		this.retraitDAO=DAOFactory.getRetraitDAO();
		
	}
	
	//méthode pour lieu de retrait
	public Retrait retraitArticle(int no_article, String rue, String codePostal, String ville) throws BusinessException {
		BusinessException businessException = new BusinessException();
		Retrait retrait = new Retrait(no_article, rue, codePostal, ville);
		
		
		if(!businessException.hasErreurs()) {
			try {
				this.retraitDAO.insert(retrait);
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
		}
		if(businessException.hasErreurs()) {
			throw businessException;
		}
		
		return retrait;
		
	}
	
	//méthode liste des différents retraits
	public List<Retrait> selectAll() throws BusinessException {
		List<Retrait> listeRetrait = new ArrayList<Retrait>();
		try {
			listeRetrait = this.retraitDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeRetrait;
	}
	

	
	
}