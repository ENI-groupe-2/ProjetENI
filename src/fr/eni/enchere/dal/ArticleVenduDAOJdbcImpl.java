package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;


import fr.eni.encheres.BusinessException;


public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLEVENDU = "insert into ARTICLES_VENDUS ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?)";

	private static final String SELECT_ALL_ARTICLEVENDU = "select * from ARTICLES_VENDUS";

	private static final String INSERT_CATEGORIE= "insert into CATEGORIES (libelle) values(?)";
	
	private static final String SELECT_BY_NO_ARTICLE = "select * from ARTICLES_VENDUS where no_article = ?";
	
	private static final String SELECT_BY_NO_CATEGORIE = "select * from ARTICLES_VENDUS where no_categorie= ?";
	
	private static int cate=0;
	
	@Override
	public void insert(ArticleVendu ArticleVendu) throws BusinessException {
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if (ArticleVendu == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try {
				cnx.setAutoCommit(false);
				
				PreparedStatement rqt2 = cnx.prepareStatement(INSERT_CATEGORIE,PreparedStatement.RETURN_GENERATED_KEYS);
				int Cate = ArticleVendu.getCategorie();
				String libelle= null;
				switch (Cate) {
				case 1 : libelle = "Informatique";break;
				case 2 : libelle="Ameublement";break;
				case 3 : libelle="Vetement";break;
				case 4 : libelle="Sport&Loisirs";
				}
									
				rqt2.setString(1, libelle);
				rqt2.executeUpdate();
				ResultSet rs2 = rqt2.getGeneratedKeys();
				if(rs2.next())
				{
					ArticleVendu.setCategorie(rs2.getInt(1));
				}
				cate=ArticleVendu.getCategorie();
				
				PreparedStatement rqt = cnx.prepareStatement(INSERT_ARTICLEVENDU, PreparedStatement.RETURN_GENERATED_KEYS);
				rqt.setString(1, ArticleVendu.getNomArticle());
				rqt.setString(2, ArticleVendu.getDescription());
				rqt.setDate(3, java.sql.Date.valueOf(ArticleVendu.getDateDebutEncheres()));
				rqt.setDate(4, java.sql.Date.valueOf(ArticleVendu.getDateFinEncheres()));
				rqt.setInt(5, ArticleVendu.getMiseAPrix());
				rqt.setInt(6, ArticleVendu.getPrixVente());
				rqt.setInt(7, ArticleVendu.getNoUtilisateur());
				rqt.setInt(8, ArticleVendu.getCategorie());
				rqt.executeUpdate();
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next())
				{
					ArticleVendu.setNoArticle(rs.getInt(1));
				}
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ArticleVendu> selectAll() throws SQLException {
		List<ArticleVendu> listeArticleVendu = new ArrayList<ArticleVendu>();
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLEVENDU);
			ResultSet rs = pstmt.executeQuery();
			ArticleVendu articleVendu;
			while (rs.next()) {
				articleVendu = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"));
				listeArticleVendu.add(articleVendu);
			}
		}
		return listeArticleVendu;
	}

	@Override
    public ArticleVendu SelectByNoArticle (int noArticle) throws SQLException{


        // Mise en place de la connection
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
            pstmt.setInt(1, noArticle);
            ResultSet rs = pstmt.executeQuery();
            //ArticleVendu articleVendu =new ArticleVendu();
            ArticleVendu article = null;
            while (rs.next()) {
                article = new ArticleVendu(rs.getInt("noArticle"), rs.getString("nomArticle"), rs.getString("description"), rs.getInt("miseAPrix"), rs.getDate("dateFinEncheres"));




            }

           return article;

        }

}

	@Override
	public ArticleVendu SelectByNoCate(int noCate) throws SQLException {

        // Mise en place de la connection
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO_CATEGORIE);
            noCate =cate;
           
            pstmt.setInt(1, cate);
            
            ResultSet rs = pstmt.executeQuery();
            //ArticleVendu articleVendu =new ArticleVendu();
       
            ArticleVendu noarticle = new ArticleVendu();
            while (rs.next()) {
            	noarticle.setNoArticle(rs.getInt("no_article"));
            	System.out.println(noarticle+"NO noCate RECUP");
            	
            	


            }

           return noarticle;

        }

}
}