<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="CSS/feuille_de_style_p9.css">
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
            <h2>Nouvelle vente</h2>
        </div>
    </header>

    <main id="frame"> <!-- Image de l'article (objet) -->
        <img src="#"> <!--Afficher la photo de l'article mis en vente-->
    </main>
   
    <form>
            
        <div id="infos"> <!-- Informations de l'article -->
            <label for="article">Article : </label>
            <input name="pseudo" type="text" id="pseudo" required autofocus>

            <br><br>

            <label for="description">Déscription : </label> 
            <textarea id="description" name="description"></textarea>

            <br><br>

            <label for="categorie">Catégorie : </label>
            <select name="categorie" id="categorie">
                <option>Toutes</option>
                <option>Informatique</option>
                <option>Ameublement</option>
                <option>Vêtement</option>
                <option>Sport&Loisir</option>
            </select>

            <br><br>

            <label for="photoArticle">Photo de l'article : </label> 
            <input type="file" name="phohoArticle" accept="image/png, image/jpeg">

            <br><br>

            <label for="prixOrig">Mise à prix : </label>
            <input name="prixOrig" type="number" min="5" step="5" placeholder="5"> 

            <br><br>

            <label for="debutEnch">Début de l'enchère : </label>
            <input type="date" name="debutEnch">

            <br><br>

            <label for="finEnch">Fin de l'enchère : </label>
            <input type="date" name="finEnch">
            
            <br><br>
        </div>

        <fieldset id="retrait"> <!-- Infos RETRAIT-->
            <legend>Retrait</legend>

                <label for="rue">Rue : </label>
                <input name="rue" type="text" id="rue" required>

                <br><br>

                <label for="ville">Ville : </label>
                <input name="ville" type="text" id="ville" required>

                <br><br>

                <label for="cp">Code postal : </label>
                <input name="cp" type="text" id="cp" required>
        </fieldset>

        <br><br>

        <div id="bouton"> <!-- Boutons : ENREGISTRER et ANNULER-->
            <input type="submit" name="btEnregistrer" value="Enregistrer" class="boutonForm" title="Enregistrer"/>
            <input type="reset" name="annuler" value="Annuler" class="boutonForm" title="annuler" />
        </div>
        
    </form>

    

</body>
</html>