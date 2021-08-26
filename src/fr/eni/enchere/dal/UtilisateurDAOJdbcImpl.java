package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,"
			+ " credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SELECT_ALL_UTILISATEUR = "select * from UTILISATEURS";

	private static final String SELECT_BY_NO = "select no_utilisateur, pseudo, nom, prenom, email, telephone,  rue, code_postal, ville, mot_de_passe, credit, administrateur "
			+ " from UTILISATEURS where no_utilisateur = ?";

	private static final String SELECT_BY_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone,  rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS where pseudo = ?";
	
	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?,  rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur = ? ";

	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	
	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {

		// Mise en place de la connection
		try (Connection cnx = ConnectionProvider.getConnection()) {
			if (utilisateur == null) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
				throw businessException;
			}

			try {
				cnx.setAutoCommit(false);
				PreparedStatement rqt = cnx.prepareStatement(INSERT_UTILISATEUR,
						PreparedStatement.RETURN_GENERATED_KEYS);
				rqt.setString(1, utilisateur.getPseudo());
				rqt.setString(2, utilisateur.getNom());
				rqt.setString(3, utilisateur.getPrenom());
				rqt.setString(4, utilisateur.getEmail());
				rqt.setString(5, utilisateur.getTelephone());
				rqt.setString(6, utilisateur.getRue());
				rqt.setString(7, utilisateur.getCodePostal());
				rqt.setString(8, utilisateur.getVille());
				rqt.setString(9, utilisateur.getMotDePasse());
				rqt.setInt(10, utilisateur.getCredit());
				rqt.setBoolean(11, utilisateur.isAdmin());
				rqt.executeUpdate();
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
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
	public List<Utilisateur> selectAll() throws SQLException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();

		// Mise en place de la connection
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_UTILISATEUR);
			ResultSet rs = pstmt.executeQuery();
			Utilisateur utilisateur;
			while (rs.next())

			{
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
						rs.getBoolean("administrateur"));
				listeUtilisateur.add(utilisateur);
			}

		}
		return listeUtilisateur;
	}

	@Override
	public Utilisateur SelectByNo(int id) throws SQLException {

		// Mise en place de la connection
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			Utilisateur utilisateur = null;
			while (rs.next()) {

				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));

			}

			return utilisateur;

		}

	}
	
	@Override
	public Utilisateur SelectByPseudo(String pseudo) throws SQLException {
		
		// Mise en place de la connection
				try (Connection cnx = ConnectionProvider.getConnection()) {
					PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
					pstmt.setString(1, pseudo);
					ResultSet rs = pstmt.executeQuery();
					Utilisateur utilisateur = null;
					while (rs.next()) {
						utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
								rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
								rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
								rs.getInt("credit"), rs.getBoolean("administrateur"));

					}

					return utilisateur;

				}
	}
	
	
	
	@Override
	public void UpdateUtilisateur(Utilisateur utilisateur) throws SQLException {

		// Mise en place de la connection
		try (Connection cnx = ConnectionProvider.getConnection()) {
			cnx.setAutoCommit(false);
			System.out.println("Debut update");
			PreparedStatement rqt = cnx.prepareStatement(UPDATE);
			
			rqt.setString(1, utilisateur.getPseudo());
			rqt.setString(2, utilisateur.getNom());
			rqt.setString(3, utilisateur.getPrenom());
			rqt.setString(4, utilisateur.getEmail());
			rqt.setString(5, utilisateur.getTelephone());
			rqt.setString(6, utilisateur.getRue());
			rqt.setString(7, utilisateur.getCodePostal());
			rqt.setString(8, utilisateur.getVille());
			rqt.setString(9, utilisateur.getMotDePasse());
			rqt.setInt(10, utilisateur.getNoUtilisateur());
			rqt.executeUpdate();
			cnx.commit();
			System.out.println("Fin update");
		}
	}
	
	@Override
	public void delete(int id) throws SQLException {
		// Mise en place de la connection
				try (Connection cnx = ConnectionProvider.getConnection()) {
					PreparedStatement rqt = cnx.prepareStatement(DELETE);
					rqt.setInt(1, id);
					rqt.executeUpdate();
					
					cnx.close();		
			}
			

		}
	}
		
		
	

