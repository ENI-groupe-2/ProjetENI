package fr.eni.enchere.dal;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.CodesResultatDAL;
import fr.eni.encheres.BusinessException;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT_ENCHERE = "insert into ENCHERES (date_enchere, montant_enchere) values(?,?)";

	private static final String SELECT_ALL_ENCHERE = "select * from ENCHERES";
	
	private static final String SELECT_BY_NO = "select no_utilisateur, no_article, date_enchere, , montant_enchere+  from ENCHERES where no_article = ?";
	
	private static final String DELETE = "DELETE FROM ENCHERES WHERE no_article = ?";
	
	@Override
	public void insert(Enchere enchere) throws BusinessException {
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if(enchere==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}
			
			try {
				cnx.setAutoCommit(false);
				LocalDate date = null;
				date.getDayOfWeek();
	
				 PreparedStatement rqt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
				rqt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
				rqt.setInt(2, enchere.getMontant_enchere());
				rqt.executeUpdate();
				ResultSet rs = rqt.getGeneratedKeys();
				if(rs.next())
				{
					enchere.setNoUtilisateur(rs.getInt(1));
					enchere.setNoArticle(rs.getInt(2));
				}
			} finally {
				cnx.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Enchere> selectAll() throws SQLException {
		List<Enchere> liste = new ArrayList<Enchere>();
		
		//Mise en place de la connection 
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ENCHERE);
			
			ResultSet rs = pstmt.executeQuery();
			Enchere enchere;
			while(rs.next()) {
					enchere = new Enchere( rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
					liste.add(enchere);
				}
				
		}
		return liste;
	}
	
	@Override
	public Enchere SelectByNoArticle(int id) throws SQLException {
		
				//Mise en place de la connection 
				try(Connection cnx = ConnectionProvider.getConnection())
				{
					PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					Enchere enchere = null;
					while(rs.next())
					{
						
						enchere = new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getInt("montant_enchere"));
					}
				
						return enchere ;
				
				}	
	}
	

	@Override
	public void delete(int id_enchere) throws SQLException {
		// Mise en place de la connection
				try (Connection cnx = ConnectionProvider.getConnection()) {
					PreparedStatement rqt = cnx.prepareStatement(DELETE);
					rqt.setInt(1, id_enchere);
					rqt.executeUpdate();
					
					cnx.close();		
			}
			

		}
	}