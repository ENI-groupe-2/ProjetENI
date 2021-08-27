package fr.eni.enchere.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.encheres.BusinessException;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no_utilisateur=0;
		
		HttpSession session = request.getSession();
		no_utilisateur = (int) session.getAttribute("id");		
		
		//J'ajoute l'utilisateur
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		try {
			utilisateurManager.delete(no_utilisateur);
			System.out.println("Delete : OK");
			//Message d'erreur
			request.setAttribute("ErreurSupp", "Votre compte a était supprimé");
			RequestDispatcher rd = request.getRequestDispatcher("/ConnectionServlet");
			rd.forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Delete : KO");
		}
	}

}
