<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="../include/menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des reclamations</title>
<script type="text/javascript" src="./include/jquery.tablesorter.min.js"></script> 
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").tablesorter();
	});
</script>
</head>
<body><DIV class="content">
<h3>Liste des Reclamations.</h3>
<div id="content1">

<s:url id="ajax" value="inputReclamationSave"/>
    
	<sj:a id="ajaxlink" 
		href="%{ajax}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
		
	>
Ajouter un reclamation	</sj:a></div><table id="table" class="tablesorter">
<THEAD>
<tr><th>Id</th><th>Status</th></tr></THEAD>
<s:iterator value="reclamations">

     	<s:url action="inputReclamationUpdate" id="updateUrl">
				<s:param name="id" value="id" />
			</s:url>
    <s:url action="reclamationDelete" id="deleteUrl">
				<s:param name="id" value="id" />
			</s:url>
	<tr>
	<td><s:property value="id" /><td><s:property value="status" /></td>
	<td><a href="<s:property value="#updateUrl"/>">Modifier</a></td>
	<td><a href="<s:property value="#deleteUrl"/>">Supprimer</a></td>
</tr>
</s:iterator><TBODY>
</table>
</DIV>
</body>
</html>