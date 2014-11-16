<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colis mis à jour</title>
</head>
<body>
<h3>Détail du client.</h3>

<s:if test="colis != null" >

        
             
	<p><s:property value="colis" />  </p>



</s:if>

<s:else>

<p>Pas de mise à jour.</p>
</s:else>

<p><a href="index.jsp">Rechercher un autre colis</a></p>
<p><a href="<s:url action='allColisFinder'/>">Voir tous les colis</a>.</p>


</body>
</html>