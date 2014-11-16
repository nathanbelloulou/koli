<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="../include/menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des messages</title>
<script type="text/javascript" type="text/javascript" src="./include/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").dataTable();

	});
</script>
</head>
<body><DIV class="content">
<h3>Liste des Messages.</h3>
<div id="content1">

<s:url id="ajax" value="inputMessageSave"/>
    
	<sj:a id="ajaxlink" 
		href="%{ajax}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
		
	>
Ajouter un message	</sj:a></div><table id="table" class="display">
<THEAD>
<tr><th>Id</th><th>Status</th><th>Actions</th></tr></THEAD>
<s:iterator value="messages">

     	<s:url action="inputMessageUpdate" id="updateUrl">
				<s:param name="id" value="id" />
			</s:url>
    <s:url action="messageDelete" id="deleteUrl">
				<s:param name="id" value="id" />
			</s:url>
	<tr>
	<td><s:property value="id" /><td><s:property value="status" /></td>
	<td><a href="<s:property value="#updateUrl"/>">Modifier</a>
	<a class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" href="<s:property value="#deleteUrl"/>" >
<span class="ui-button-text"> Supprimer </span>
</a>
</td>
</tr>
</s:iterator><TBODY><tfoot>
		<tr>
		
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</tfoot>
</table>
</DIV>
</body>
</html>