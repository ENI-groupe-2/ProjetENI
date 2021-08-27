package fr.eni.enchere.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleVenduManager;
import fr.eni.enchere.bll.RetraitManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.encheres.BusinessException;

/**
 * Servlet implementation class NouvellVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
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
			request.setAttribute("Rue", utilisateur.getRue());
			request.setAttribute("codePostal", utilisateur.getCodePostal());
			request.setAttribute("Ville", utilisateur.getVille());
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page9.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Paramètres fournis par utilisateur
		String article = null;
		String description = null;
		int categorie=0;
		int prixOrig=0;
		LocalDate debutEnch = null;
		LocalDate finEnch = null;
		// pour retrait
		String rue = null;
		String ville = null;
		String cp = null;
		
		// Paramètres utiles pour ArticleVenduManager & Co' NON DEFINIS PAR LE FORMULAIRE HTML
		int prixVente;
		String etatVente = null;
		int noUtilisateur;
		
		request.setCharacterEncoding("UTF-8");
		
		// Lecture/affectation des parametres de l'article vendu
		article = request.getParameter("article");
		description = request.getParameter("description");
		categorie = Integer.parseInt(request.getParameter("categorie"));
		prixOrig =  Integer.parseInt(request.getParameter("prixOrig"));
		// prixVente = prixOrig à la création car personne n'a encore enchéri sur la vente
		prixVente = prixOrig;
		
		rue = request.getParameter("rue");
		ville = request.getParameter("ville");
		cp = request.getParameter("cp");
		
		
		// noUtilisateur = (int)request.getSession().getAttribute("no_utilisateur");
		HttpSession session = request.getSession();
		noUtilisateur  = (int) session.getAttribute("id");;
		System.out.println(noUtilisateur);

		// Cast de la date from String to LocalDate
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			debutEnch = LocalDate.parse(request.getParameter("debutEnch"), dtf);
			finEnch = LocalDate.parse(request.getParameter("finEnch"), dtf);
		}
		catch(DateTimeParseException e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la convertion de type pour la date (String to LocalDate)");
		}
		
		// Création de la vente
		ArticleVenduManager articleVenduManager = new ArticleVenduManager();
		try {
			articleVenduManager.insertArticle(article, description, debutEnch, finEnch, prixOrig, prixVente, noUtilisateur, categorie);
			etatVente = "En Cours";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Echec lors de la création de la vente ( peut-être param prixVente de inserArticle()? )");
		}
		
		int id = (int) session.getAttribute("id");
		
		ArticleVendu article1 = null;
		try {
			article1=articleVenduManager.SelectByNoCate(id);
			System.out.println(article1+"ID UTILISATEUR");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	// Création du point de retrait
		RetraitManager retraitManager = new RetraitManager();
		int id_article = article1.getNoArticle();
	
		try {
			System.out.println(id_article+"EEEEEEEEEEEEEEEEEEEE");
			retraitManager.retraitArticle( id_article ,rue, cp, ville);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la création du point de retrait");
		}
		
		
		// Prévoir MaJ pour redirection vers desktop_page10.jsp ou desktop_page11.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/desktop_page9.jsp");
		rd.forward(request, response);
		System.out.println("Vente bien enregistrée");
		
	}

}
