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
<div>
<a href="NouvelleVenteServlet">Enchères</a>
<a href="NouvelleVenteServlet">Vendre un article</a>
<a href="MonProfilServlet" id="connexion">Mon profil</a>
<a href="ConnectionServlet" id="connexion">Déconnecxion</a>



</div>
</header>
<body>
    <h1>Liste des enchères</h1>
    <br><br>
    Filtres :
    <br>
    <label for="site-search"></label>
    <input type="search" id="site-search" name="q" placeholder="Le nom de l'article">
    <br><br>
    <br>
    <div>

      <label for="catégorie">Catégorie:</label>

      <select name="catégorie" id="catégorie">
          <option value="Toutes">Toutes</option>
          <option value="?">?</option>
          <option value="?">?</option>
          <option value="?">?</option>
          <option value="?">?</option>
          <option value="?">?</option>
          <option value="?">?</option>
      </select>
         </div>
       <br>
<br>
       <div>
       <input type="radio" id="achat" value="Achats" name="choix" checked> 
       <label for="achat">Achats</label>
       <select name="choix">
        <option value="enchères ouvertes">enchères ouvertes</option>
        <option value="mes enchères en cours">mes enchères en cours</option>
        <option value="mes enchères remportées">mes enchères remportées</option>
       </select>
       </div>
        <br>
         
        

            

             <div>
              <input type="radio" id="vente" value="mes ventes" name="choix"> 
              <label for="vente">Mes ventes</label>
              <select name="choix">
                <option value="mes ventes en cours">mes ventes en cours</option>
                <option value="ventes non débutées">ventes non débutées</option>
                <option value="mes enchères remportées">mes enchères remportées</option>
                </select>

            </div>
            <br>

            <div>
            <input type="submit" value="Rechercher">
            </div>
            
</body>
</html>