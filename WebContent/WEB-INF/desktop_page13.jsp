<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="CSS/feuille_de_style_p13.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">
</head>

<body>
    <header>

        <div class="entete"> <!-- entete avec logo -->
            <a href="AccueilConnecteServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>

            <!-- slogan -->
        <div id="titre">
            <h2> --pseudo d'utilisateur-- a remporté l'enchère</h2> <!-- Faire apparaitre le pseudo de l'acheteur-->
        </div>

    </header>
    
    <main id="frame"> <!-- Image de l'article (objet) -->
        <img src="#"> <!--Afficher la photo de l'article mis en vente-->
    </main>
   
    <form>
        <div id="infos">
            <label for="article">--Article--</label> <!--Faire apparaître le nom de l'article mis en vente -->
            <br><br>
            <label for="description">Déscription : </label> <!--Faire apparaître la description -->
            <br><br>
            <label for="topOffre">Meilleure offre : </label> <!--Faire apparaitre l'offre avec le plus de points-->
            <br><br>
            <label for="prixOrig">Mise à prix : </label> <!--Faire apparaitre la mise à prix -->
            <br><br>
            <label for="retrait">Retrait : </label> <!--Faire apparaitre l'adresse du vendeur -->
            <br><br>
            <label for="vendeur">Vendeur : </label> <!--Faire apparaitre le pseudo du vendeur-->
            <br><br>
            <input type="submit" name="btRetraitEffectue" value="Retrait effectué" class="btRetraitEffectue" title="Retrait effectué" />
        </div>
        
    </form>

</body>
</html>