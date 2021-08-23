package fr.eni.enchere.dal;


import java.sql.SQLException;

import fr.eni.enchere.bo.*;
import fr.eni.encheres.BusinessException;

public interface ProfilDAO {
	public Utilisateur SelectByPseudo (String pseudo) throws  SQLException;

}