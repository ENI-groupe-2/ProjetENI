package fr.eni.enchere.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

public class ProfilDAOJdbcImpl implements ProfilDAO{
	private static final String SELECT_BY_PSEUDO = "select pseudo, nom, prenom, email, telephone,  rue, code_postal, ville from UTILISATEURS where pseudo = ?";

	
	@Override
	public Utilisateur SelectByPseudo(String pseudo) throws SQLException {

		// Mise en place de la connection
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			Utilisateur utilisateur = null;
			while (rs.next()) {

				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"));

			}

			return utilisateur;
        }
	}}


