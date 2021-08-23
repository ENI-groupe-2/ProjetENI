<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ENI-Enchères</title>
</head>
<header>
ENI-Enchères <br>
<div>
Nouvelle vente
</div>
</header>
<body>
<div>
<br><br>
<label for="article"> Article : </label>
           <input id="article" type="text" name="article">
</div>
<br>
<div>
    <label for="description"> Description : </label>
    
    <textarea id="description" name="description" rows="10" cols="20"></textarea>
</div>
<br>
<div>
    <label for="catégorie">Catégorie:</label>

    <select name="catégorie" id="catégorie">
        <option value="Toutes">--Toutes--</option>
        <option value="?">?</option>
        <option value="?">?</option>
        <option value="?">?</option>
        <option value="?">?</option>
        <option value="?">?</option>
        <option value="?">?</option>
    </select>
    </div>
    <br>
    <div>
    <label for="avatar">Photo de l'article:</label>

    <input type="file"
           id="avatar" name="avatar"
           accept="image/png, image/jpeg">
        </div>
        <br>
        <div>
        Mise à prix : <input type="number" name="mise à prix" size="20">
        </div>
        <br>
        <div>
        Début de l'enchère <input type="date" name="début de l'enchère">
        </div>
        <br>
        <div>
        Fin de l'enchère <input type="date" name="fin de l'enchère">
        </div>
        <div>
            <h2>Retrait</h2>
            </div>
            <!--Les informations du vendeur doivent figurer ici / par défaut le retrait est effectué à l'adresse du vendeur-->
            Rue :
            <br>
            Code postal :
            <br>
            Ville :
            <br><br>
        <div>
            <input class="favorite styled"
               type="button"
               value="Enregistrer">
        </div>
        <br>
        <div>
            <input class="favorite styled"
               type="button"
               value="Annuler">
        </div>
        <br>
        <div>
            <input class="favorite styled"
               type="button"
               value="Annuler la vente">
        </div>
</body>
</html>