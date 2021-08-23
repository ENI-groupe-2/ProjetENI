<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
</head>
<header>
ENI-Enchères
</header>
<body>
    <br><br><br>
    
    <form action="<%=request.getContextPath()%>/ConnectionServlet" method="post">
    
 <label for="identifiant"> Identifiant : </label>
           <input id="identifiant" type="text" name="identifiant" placeholder="Indiquer Login">
           <br> <br>
           
           <div>
            <label for="password">Password:</label>
            <input type="password" id="pass" name="password">
                   
        </div>
        <br> <br> <br>
   <a href="AccueilConnecteServlet"><input type="submit" value="Connexion"></a>
        <input type="checkbox" value="se souvenir de moi" > se souvenir de moi
<br><br>
<u>Mot de passe oublié</u>
<br><br>
<a href="EnregistrementServlet"> <input type="button"  value="Créer un compte"> </a>
</form>
</body>
</html>