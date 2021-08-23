<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères  des objets d'art, meubles, véhicules, matériel et encore plus! Participez aux enchères en direct ..."/>
    <meta author="Veronika"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/feuille_de_style_p3.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">
</head>

<body>
    <header>
        <div class="entete"> <!-- entete avec logo -->
        <a href="Liste_des_encheres_p1.html" title="Accueil"><h1>ENI-Enchères </h1><img src="../MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>
    </header>

    <main> <!-- Titre => Mon profil -->
        <div id="titre">
            <h2>Mon profil</h2>
        </div>

        <form action="<%=request.getContextPath()%>/EnregistrementServlet" method="post">
            <div id="left"> <!-- Formulaire côté gauche -->
                <label for="Pseudo">Pseudo : </label>
                <input name="Pseudo" type="text" id="pseudo"  required="required">

                <br><br>

                <label for="Prenom">Prénom : </label>
                <input name="Prenom" type="text" id="prenom" required="required">

                <br><br>

                <label for="Telephone">Téléphone : </label>
                <input name="Telephone" type="tel" id="telephone" size="20" minlength="9" maxlength="14" pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}" required="required">

                <br><br>

                <label for="CodePostal">Code postal : </label>
                <input name="CodePostal" type="text" id="cp" required="required">

                <br><br>

                <label for="MotDePasse">Mot de passe : </label>
                <input name="MotDePasse" type="password" id="password" required="required">

                <br><br>

            </div>
                
            <div id="right"> <!-- Formulaire côté droit-->
                <label for="Nom">Nom : </label>
                <input name="Nom" type="text" id="nom" required="required">

                <br><br>

                <label for="Email">E-mail : </label>
                <input name="Email" type="email" id="email"  required="required">

                <br><br>

                <label for="Rue">Rue : </label>
                <input name="Rue" type="text" id="rue" required="required">

                <br><br>

                <label for="Ville">Ville : </label>
                <input name="Ville" type="text" id="ville" required="required">

                <br><br>

                <label for="repeatpassword">Confirmation : </label>
                <input name="repeatpassword" type="password" id="repeatpassword" required="required">

            <br><br>

            </div>

            <div id="bouton"> <!--les boutons créer et annuler-->
              	<a href="AccueilConnecteServlet"><input type="submit"  value="Créer" "/></a>
                <a href="AccueilServlet"> <input type="button" name="btAnnuler" value="Annuler" class="boutonForm" title="Annuler" /> </a>
            </div>
        </form>
    </main>
</body>
</html>