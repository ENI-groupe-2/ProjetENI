package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.encheres.BusinessException;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String INSERT_CATEGORIE= "insert into CATEGORIES (libelle) values(?)";

	private static final String SELECT_ALL_CATEGORIE = "select * from CATEGORIES";

	@Override
	public void insert(Categorie categorie) throws BusinessException {
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if (categorie == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try {
				cnx.setAutoCommit(false);
				PreparedStatement rqt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
				rqt.setString(1, categorie.getLibelle());
				rqt.executeUpdate();
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next())
				{
					categorie.setNoCategorie(rs.getInt(1));
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
	public List<Categorie> selectAll() throws SQLException {
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pstmt.executeQuery();
			Categorie categorie;
			while (rs.next()) {
				categorie = new Categorie(rs.getInt("libelle"));
				listeCategorie.add(categorie);
			}
		}
		return listeCategorie;
	}
	
}
