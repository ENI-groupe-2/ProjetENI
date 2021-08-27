<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="fr.eni.enchere.bo.ArticleVendu"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="CSS/feuille_de_style_p4-5.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">

</head>

<body>
    <header>

        <div class="entete"> <!-- entete avec logo -->
            <a href="AccueilConnecteServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>

        <!-- options utilisateur -->
        <div id="header-user-infos">
            <a href="NouvelleVenteServlet">Enchères</a>            
            <a href="NouvelleVenteServlet">Vendre un article</a>           
            <a href="MonProfilServlet" id="connexion">Mon profil</a>
            <a href="ConnectionServlet" id="connexion">Déconnexion</a>
        </div>

            <!-- slogan -->
        <div id="titre">
            <h2>Liste des enchères</h2>
        </div>

        

    </header>
   
    <nav> <!-- navigation = filtres -->

        <h2>Filtres : </h2>

         <!-- Barre de recherche -->
        <label for="site-search"></label>
        <input type="search" id="site-search" name="q" placeholder="Le nom de l'article contient" title="Barre de recherche" >
        
        <br><br>

         <!--Liste de catégories-->
        <label for="categorie">Catégorie : </label>
        <select name="categorie" id="categorie">
            <option>Toutes</option>
            <option>Informatique</option>
            <option>Ameublement</option>
            <option>Vêtement</option>
            <option>Sport&Loisir</option>
        </select>

        <br><br>

        <!-- Option ACHAT-->
        <div id="left">
            <ul>
                <input type="radio" id="achat" value="Achats" name="choix" checked> 
                <label for="achat">Achats</label>
                    <li><input type="checkbox">enchères ouvertes</li>
                    <li><input type="checkbox">mes enchères en cours</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>

        <!-- Option MES VENTES-->
        <div id="right">
            <ul>
                <input type="radio" id="vente" value="mes ventes" name="choix"> 
                <label for="vente">Mes ventes</label>
                    <li><input type="checkbox">mes ventes en cours</li>
                    <li><input type="checkbox">ventes non débutées</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>

        <!-- Bouton rechercher-->
        <button id="btRechercher" type="submit" value="Rechercher">Rechercher</button>
    
    </nav><!-- fin navigation = filtres -->
    <br>
    
    <%
					List<ArticleVendu> ListeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
					
						for(ArticleVendu ArticleInsertion : ListeArticle)
						{
					
				%>
	 <section> <!-- AFFICHER LES ACHATS OU LES VENTES  -->
            <article class="obj">
                <main class="frame"> <!-- Image de l'article (objet) -->
                    <img class="image" src="#"> <!--Afficher la photo de l'article mis en vente-->
                </main>
                
                
                <form>
                    <div class="infos">
                        <label for="article" class="nomArticle"><b><%=ArticleInsertion.getNomArticle() %></b></label>
                        <br>
                        <label for="prix">Prix : <%=ArticleInsertion.getPrixVente() %> </label> <!--Faire apparaitre le prix -->
                        <br>
                        <label for="finEnch">Fin de l'enchère : <%=ArticleInsertion.getDateDebutEncheres() %></label> <!--faire apparaitre la date de fin d'enchère-->
                        <br>
                        <label for="vendeur">Vendeur : <%=ArticleInsertion.getNoUtilisateur() %>  </label> <!--Faire apparaitre le nom du vendeur-->
                        <br>
                    </div>
                </form>
            </article>

           
			<% }%>
    </section>

    <br><br>
    <section>
        <!-- aperçue de la liste des enchères => A COMPLETER -->
    </section>

    <br><br>

</body>
</html>