<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colis enregistré</title>
</head>
<body>
<h3>Utiliser les formulaire pour ajouter un nouveau colis.</h3>


     <s:form action="executeColisSave" method="post">
     
     	<s:textfield name="colis.id" label="Numero de colis" />
     	<s:textfield name="colis.name" label="Nom" />
     	
     	
     	
     	
     	<s:submit />
     
     </s:form>



<p><a href="index.jsp">Recherche d'un autre colis</a></p>
<p><a href="<s:url action='allPersonsFinder'/>">Lister tous colis</a>.</p>


</body>
</html>