<%--
  Created by IntelliJ IDEA.
  User: smith
  Date: 10/6/2020
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="../style/style.css"/>
</head>
<body>
<form method="post" action="connexion">
    <fieldset>
        <legend>Connexion</legend>
        <p>Formulaire de connexion à French Chic.</p>

        <label for="pseudo">Pseudo <span class="requis">*</span></label>
        <input type="text" id="pseudo" name="pseudo" value="<c:out value="${user.pseudo}"/>" size="20" maxlength="60" />
        <span class="erreur">${errors['email']}</span>
        <br />

        <label for="password">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
        <span class="erreur">${errors['pass']}</span>
        <br />

        <input type="submit" value="Connexion" class="sansLabel" />
        <br />

        <p class="${empty errors ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>
</body>
</html>
