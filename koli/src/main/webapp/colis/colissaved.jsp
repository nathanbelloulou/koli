<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colis enregistrer</title>
</head>
<body>
<h3>Colis enregistrer</h3>

<s:if test="colis != null" >

        
         <table>    
	<tr>
	<td><s:property value="colis.id" /></td><td><s:property value="colis.name" />
</td></tr>
</table>



</s:if>

<s:else>

<p>Colis non trouvé.</p>
</s:else>

<p><a href="index.jsp">Rechercher un colis</a></p>
<p><a href="<s:url action='allColisFinder'/>">Rechercher tous les colis</a>.</p>


</body>
</html>