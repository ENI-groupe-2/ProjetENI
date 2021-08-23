package fr.eni.enchere.servlets;

import java.io.IOException;

import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.BusinessException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class EnregistrementServlet
 */
@WebServlet("/EnregistrementServlet")
public class EnregistrementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page3.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
				int credit=0;
				boolean admin=true;
				String utilisateur=null;
				
				
				request.setCharacterEncoding("UTF-8");
			
				//lecture de l'utilisateur
				Pseudo = request.getParameter("Pseudo");
				Nom = request.getParameter("Nom");
				Prenom = request.getParameter("Prenom");
				Email = request.getParameter("Email");
				Telephone = request.getParameter("Telephone");
				Rue = request.getParameter("Rue");
				CodePostal = request.getParameter("CodePostal");
				Ville = request.getParameter("Ville");
				MotDePasse = request.getParameter("MotDePasse");
				
				//J'ajoute l'utilisateur
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				try {
					utilisateurManager.ajouterUtilisateur(Pseudo, Nom, Prenom, Email, Telephone, Rue, CodePostal, Ville, MotDePasse, credit, admin);
					//Si tout se passe bien, je vais vers la page d'accueil:
					RequestDispatcher rd = request.getRequestDispatcher("/AccueilConnecteServlet");
					rd.forward(request, response);
				} catch (BusinessException e) {
					//Sinon je retourne à la page d'enregistrement pour indiquer les problèmes:
					e.printStackTrace();
					request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page3.jsp");
					rd.forward(request, response);
				}
		
	}

}
