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
<!--Utiliser Expression Language EL + balises JSTL-->


<div>
Pseudo : <%=request.getAttribute("Pseudo") %> <br>
Nom : <%=request.getAttribute("Nom") %><br>
Prénom :<%=request.getAttribute("Prenom") %> <br>
Email : <%=request.getAttribute("Email") %><br>
Téléphone : <%=request.getAttribute("Telephone") %><br>
Rue :<%=request.getAttribute("Rue") %> <br>
Code postal :<%=request.getAttribute("codePostal") %> <br>
Ville :<%=request.getAttribute("Ville") %> <br>
</div>
<br>
<br>
<input type="submit" value="Modifier">
    
</body>
</html>