<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/feuille_de_style_p1.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">

</head>

<body>
    <header>

        <div class="entete"> <!-- entete avec logo -->
            <a href="AccueilServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="<%=request.getContextPath()%>/MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>

        <!-- options utilisateur -->
        <div id="header-user-infos">
            <a href="ConnectionServlet" id="connexion">S'inscrire - Se connecter</a>
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

        <!-- Bouton rechercher-->
        <button id="btRechercher">Rechercher</button>
    
    </nav><!-- fin navigation = filtres -->

    <section>
        <!-- la liste de toutes les enchères en cours => A COMPLETER -->
    </section>

    <br><br>

</body>
</html>