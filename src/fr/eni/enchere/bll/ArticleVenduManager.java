package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleVenduDAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.encheres.BusinessException;

public class ArticleVenduManager {
	
// Instance fields
	private ArticleVenduDAO articleVenduDAO;
	
// Constructors
	public ArticleVenduManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}
	
// Methods
	
	// Method "insertArticle()"
	public ArticleVendu insertArticle(String nomArticle, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere, int prixInitial, int prixVente, int numUtil, int categorie) throws BusinessException {
		BusinessException businessException = new BusinessException();
		this.validationDate(dateDebutEnchere, dateFinEnchere, businessException);
		
		ArticleVendu articleVendu= null;
		
		if (!businessException.hasErreurs()) {
			 articleVendu = new ArticleVendu();
			 articleVendu.setNomArticle(nomArticle);
			 articleVendu.setDescription(description);
			 articleVendu.setDateDebutEncheres(dateDebutEnchere);
			 articleVendu.setDateFinEncheres(dateFinEnchere);
			 articleVendu.setMiseAPrix(prixInitial);
			 articleVendu.setPrixVente(prixVente);
			 articleVendu.setNoUtilisateur(numUtil);
			 articleVendu.setCategorie(categorie);
			this.articleVenduDAO.insert(articleVendu);
		} else {
			throw businessException;
		}
		return articleVendu;
	}
	
	// Method "selectAllArticles()"
	public List<ArticleVendu> selectAllArticles() throws BusinessException {
		List<ArticleVendu> listeArticlesVendus = new ArrayList<ArticleVendu>();
		try {
			listeArticlesVendus = this.articleVenduDAO.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticlesVendus;
	}
	
	
	// Method "validationDate" >> Nécessaire à la méthode "insertArticle()"
	private void validationDate(LocalDate dateDebutEnchere, LocalDate dateFinEnchere, BusinessException businessException) {
		if(dateDebutEnchere == null || dateFinEnchere == null || 
				dateDebutEnchere.isAfter(dateFinEnchere) ||
				dateFinEnchere.isEqual(LocalDate.now()))
			{
				businessException.ajouterErreur(CodesResultatBLL.REGLE_DATE);
			}
			
		}
	public ArticleVendu SelectByNoArticle (int noArticle) throws SQLException {
		ArticleVendu articleVendu= null;
        try {
        	articleVendu = this.articleVenduDAO.SelectByNoArticle(noArticle);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleVendu;

    }


		
	
	public ArticleVendu SelectByNoCate(int id) throws SQLException {
		ArticleVendu article = null;
		
		try {
			
			article = this.articleVenduDAO.SelectByNoCate(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
		
	}