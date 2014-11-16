<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Colis recherché</title>
</head>
<body>
<h3>Voici les colis trouvés.</h3>

<s:if test="colis != null" >

        <s:url action="inputColisUpdate" id="editUrl">
           <s:param name="id" value="id"/>
        </s:url>
        
        <s:url action="colisDelete" id="deleteUrl">
        	<s:param name="id" value="id"/>
        </s:url>
             
	<p><s:property value="colis" /> <a href="<s:property value="#editUrl"/>">Modifier</a> &nbsp;&nbsp; 
	   <a href="<s:property value="#deleteUrl"/>">Supprimer</a> </p>



</s:if>

<s:else>

<p>le colis n'est pas trouvé.</p>
</s:else>

<p><a href="index.jsp">Recherché à nouveau</a></p>
<p><a href="<s:url action='allColisFinder'/>">Voir tous les colis</a>.</p>


</body>
</html>