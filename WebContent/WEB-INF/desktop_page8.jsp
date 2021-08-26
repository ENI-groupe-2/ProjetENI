<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/feuille_de_style_p8.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">
</head>

<body>
    <header>
    
        <div class="entete"> <!-- entete avec logo -->
        <a href="AccueilConnecteServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>
        
    </header>
    <main>
        <div id="titre">
        <h2>Mon profil</h2>
        </div>
						 <form action="<%=request.getContextPath()%>/ModifierServlet" method="post">
       
            <div id="left">
                <label for="pseudo">Pseudo : </label>
                <input name="pseudo" type="text" id="pseudo" value="<%=request.getAttribute("Pseudo") %>" required autofocus>

                <br><br>

                <label for="prenom">Prénom : </label>
                <input name="prenom" type="text" value="<%=request.getAttribute("Prenom") %>" id="prenom">

                <br><br>

                <label for="telNo">Téléphone : </label>
                <input name="telNo" type="tel" id="telephone" size="20" minlength="9" maxlength="14" value="<%=request.getAttribute("Telephone") %>" pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}">

                <br><br>

                <label for="cp">Code postal : </label>
                <input name="cp" type="text" id="cp" value="<%=request.getAttribute("codePostal") %>" value="" required>

                <br><br>

                <label for="password">Mot de passe actuel : </label>
                <input name="password" type="password" id="password" required>

                <br><br>

                <label for="password">Nouveau mot de passe : </label>
                <input name="newpassword" type="password" id="newpassword" >

                <br><br>

            </div>
                
            <div id="right">
                <label for="nom">Nom : </label>
                <input name="nom" type="text" id="nom" value="<%=request.getAttribute("Nom") %>"required>

                <br><br>

                <label for="email">E-mail : </label>
                <input name="email" type="email" id="email" value="<%=request.getAttribute("Email") %>" required>

                <br><br>

                <label for="rue">Rue : </label>
                <input name="rue" type="text" id="rue" value="<%=request.getAttribute("Rue") %>"required>

                <br><br>

                <label for="ville">Ville : </label>
                <input name="ville" type="text" id="ville" value="<%=request.getAttribute("Ville") %>" required>

                <br><br><br><br><br><br>

                <label for="repeatpassword">Confirmation : </label>
                <input name="repeatpassword" type="password" id="repeatpassword" >

            <br><br>

            </div>
        

        <div id="credit">
            Crédit ... 
        </div>

        <form>
            <div id="bouton">
                <input type="submit" value="Enregistrer" />
                <a href="SupprimerServlet"><input type="button" name="btSupprimerMonCompte" value="Supprimer mon compte" class="boutonForm" title="Supprimer mon compte" /></a>
            </div>
        </form>
        </form>
    </main>
</body>
</html>