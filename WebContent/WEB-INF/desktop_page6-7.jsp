<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>ENI-Encheres</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
   <meta name="description" content="ENI-Enchères : Le site des ventes aux enchères des objets d'informatique, meubles, vêtement et encore plus! Participez aux enchères en direct ..."/>
    <link rel="stylesheet" href="CSS/feuille_de_style_p6-7.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Style+Script&display=swap" rel="stylesheet">
</head>

<body>
    <header>

        <div class="entete"> <!-- entete avec logo -->
            <a href="AcceuilConnecteServlet" title="Accueil"><h1>ENI-Enchères</h1><img src="MEDIA/auction-white2.png" alt="logo auction"></a>
        </div>

    </header>
   
    <form>
            
        <div id="infos">
            <br><br>
            <label for="pseudo">Pseudo : <%=request.getAttribute("Pseudo") %> </label>
            <br><br>
            <label for="nom">Nom : <%=request.getAttribute("Nom") %> </label> 
            <br><br>
            <label for="prenom">Prénom : <%=request.getAttribute("Prenom") %> </label>
            <br><br>
            <label for="email">Email : <%=request.getAttribute("Email") %> </label>
            <br><br>
            <label for="tel">Teléphone : <%=request.getAttribute("Telephone") %> </label>
            <br><br>
            <label for="rue">Rue : <%=request.getAttribute("Rue") %> </label> 
            <br><br>
            <label for="cpo">Code postal : <%=request.getAttribute("codePostal") %> </label>
            <br><br>
            <label for="ville">Ville : <%=request.getAttribute("Ville") %> </label>
            <br><br><br>
            
            <a href="ModifierServlet"><input type="button" name="modifier" value="Modifier" class="btModif" title="Modifier"/></a>
         
        </div>
        
    </form>

    

</body>
</html>