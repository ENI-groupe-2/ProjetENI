<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="CSS/feuille_de_style_p2.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">
</head>

<body>
    <header>

        <div class="entete"> <!-- Entete avec logo -->
            <a href="AccueilServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>

    </header>
   
    <form action="<%=request.getContextPath()%>/ConnectionServlet" method="post">
        
        <div> <!-- Identifiant et mot de passe-->
            <label for="identifiant"> Identifiant : </label>
            <input id="identifiant" type="text" name="identifiant" placeholder="Votre identifiant ici...">

            <br> <br>

            <label for="password">Mot de passe :</label>
            <input type="password" id="pass" name="password">
            
            <br> <br> <br>
        </div>

        <div id="btConnex"> <!-- Bouton de connexion-->
            <a href="AccueilConnecteServlet"><input type="submit" class="boutonForm" value="Connexion"></a>
        </div>

        <div id="check"> <!-- Se souvenir de moi et/ou mot de passe oublié-->
            <input type="checkbox" value="se souvenir de moi" > Se souvenir de moi

            <br><br>

            <a href="#">Mot de passe oublié</a>
        </div>

       <br><br>

       <div id="bouton"> <!-- Bouton pour créer un compte-->
            <a href="EnregistrementServlet"> <input type="button" class="boutonForm" value="Créer un compte"> </a>
       </div>

    </form>

</body>
</html>