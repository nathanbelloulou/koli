<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../include/menu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Liste des colis</title>
<script type="text/javascript" type="text/javascript" src="./include/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").dataTable();

	});
</script>
</head>
<body>

<DIV class="content">
<s:if test="client!=null">
	<h3>Colis du client : <s:property value="client.name" /></h3>
	

<s:url action="importerClient" id="importUrl">
				<s:param name="id" value="client.id" />
			</s:url>
		<a href="<s:property value="#importUrl"/>">Importer</a>

</s:if>
<s:else>
	<h3>Liste des colis.</h3>

</s:else>
	<table id="table" class="display">
	
		<THEAD ><tr>
		<th>Id</th>
		<th>Nom</th>
		<th>Code</th>
		<th>Date d'envoi</th>
		<th>Date de reception</th>
		<th>Etat</th>
	
	</tr>	<THEAD />
	<TBODY>
	<s:iterator value="coliss">

		<s:url action="colisAnalyse" id="analyzeUrl">
			<s:param name="id" value="id" />
		</s:url>
		<s:url action="inputColisUpdate" id="editUrl">
			<s:param name="id" value="id" />
		</s:url>

		<s:url action="colisDelete" id="deleteUrl">
			<s:param name="id" value="id" />
		</s:url>
		<tr>
			<td><s:property value="id" /></td>
			<td><s:property value="name" /></td>
			<td><s:property value="code" /></td>
			<td>
			<s:date name="send_date" format="dd MMM yyyy" /></td>
			<td><s:date name="recieve_date" format="dd MMM yyyy" /></td>
			<td><s:property value="etat" /></td>
<%-- 			<td><a href="<s:property value="#analyzeUrl"/>">Analyser</a></td> --%>
<%-- 			<td><a href="<s:property value="#editUrl"/>">Modifier</a></td> --%>
<%-- 			<td><a href="<s:property value="#deleteUrl"/>">Supprimer</a></td> --%>
		</tr>
	</s:iterator>
	</TBODY>
	<tfoot>
		<tr>
		<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
	<th></th>
		</tr>
	</tfoot>	
</table>
</DIV>
</body>
</html>