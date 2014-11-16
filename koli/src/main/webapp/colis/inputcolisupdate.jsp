<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis � jour du colis</title>
</head>
<body>
<h3>Utiliser le formulaire pour enregistrer.</h3>

<s:if test="colis != null" >

     <s:form action="executeColisUpdate" method="post">
     
     	<s:textfield name="colis.colisid" label="Numero du colis" />
     	<s:textfield name="cois.name" label="Nom" />
     	
     	<s:hidden name="colis.colisid" value=""/>
     	
     	<s:submit />
     
     </s:form>


</s:if>

<s:else>

<p>Colis non trouv�.</p>
</s:else>

<p><a href="index.jsp">Rechercher un nouveau colis</a></p>
<p><a href="<s:url action='allColisFinder'/>">Lister les colis</a>.</p>


</body>
</html>