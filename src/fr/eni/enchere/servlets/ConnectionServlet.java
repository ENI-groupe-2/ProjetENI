package fr.eni.enchere.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ConnexionManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Je lis les paramètres
		
		String Pseudo=null;
		String MotDePasse=null;

		
	
	
		
		request.setCharacterEncoding("UTF-8");
		
		//lecture de l'utilisateur
		Pseudo = request.getParameter("identifiant");
		MotDePasse = request.getParameter("password");
		
		//J'ajoute l'utilisateur
		
		ConnexionManager connexionManager= new ConnexionManager();

		try {
			connexionManager.testerMotDePasse(Pseudo, MotDePasse);
		
			if (connexionManager.testerMotDePasse(Pseudo, MotDePasse) == true) {
			
				HttpSession session = request.getSession();
				session.setAttribute("pseudo", Pseudo);
				session.setAttribute("motdepasse", MotDePasse);

				RequestDispatcher rd = request.getRequestDispatcher("/AccueilConnecteServlet");
				rd.forward(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page2.jsp");
				rd.forward(request, response);
		}} catch (BusinessException e) {

			//Sinon je retourne à la page d'enregistrement pour indiquer les problèmes:
			e.printStackTrace();
			
		
			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());	
		}
	}

}