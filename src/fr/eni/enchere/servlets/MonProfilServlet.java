package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ProfilManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/MonProfilServlet")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page6-7.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo;
		//enlever apres test
		if (request.getSession().getAttribute("pseudo")== null){
		pseudo="";
	} else {
		
	
		 pseudo = (String)request.getSession().getAttribute("pseudo");
	}
		ProfilManager profilmanager = new ProfilManager();
		Utilisateur utilisateur;
		try {
			utilisateur = profilmanager.selectByPseudo(pseudo);
			request.setAttribute("Pseudo", utilisateur.getPseudo());
			request.setAttribute("Nom", utilisateur.getNom());
			request.setAttribute("Prenom", utilisateur.getPrenom());
			request.setAttribute("Email", utilisateur.getEmail());
			request.setAttribute("Telephone", utilisateur.getTelephone());
			request.setAttribute("Rue", utilisateur.getRue());
			request.setAttribute("codePostal", utilisateur.getCodePostal());
			request.setAttribute("Ville", utilisateur.getVille());
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page6-7.jsp");
		rd.forward(request, response);
	}

}

