package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

/**
 * Servlet implementation class ModifierServlet
 */
@WebServlet("/ModifierServlet")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo;
		
		
		 pseudo = (String)request.getSession().getAttribute("pseudo");
	
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur;
		try {
			utilisateur = utilisateurManager.selectByPseudo(pseudo);
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
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page8.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Je lis les paramètres
		
		String Pseudo=null;
		String Nom=null;
		String Prenom=null;
		String Email=null;
		String Telephone = null;
		String Rue=null;
		String CodePostal=null;
		String Ville= null;
		String MotDePasse=null;
		String NewMotDePasse=null;
		String utilisateur=null;
		
		
		request.setCharacterEncoding("UTF-8");
	
		//lecture de l'utilisateur
		Pseudo = request.getParameter("pseudo");
		Nom = request.getParameter("nom");
		Prenom = request.getParameter("prenom");
		Email = request.getParameter("email");
		Telephone = request.getParameter("telNo");
		Rue = request.getParameter("rue");
		CodePostal = request.getParameter("cp");
		Ville = request.getParameter("ville");
		MotDePasse = request.getParameter("newpassword");
		//J'ajoute l'utilisateur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		try {
			utilisateurManager.update(Pseudo, Nom, Prenom, Email, Telephone, Rue, CodePostal, Ville, MotDePasse);
			//Si tout se passe bien, je vais vers la page profil:
			System.out.println("Modif OK");
			RequestDispatcher rd = request.getRequestDispatcher("/MonProfilServlet");
			rd.forward(request, response);
		} catch (BusinessException e) {
			//Sinon je retourne à la page de modif pour indiquer les problèmes:
			System.out.println("Modif KO");
			e.printStackTrace();
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}

}

}

