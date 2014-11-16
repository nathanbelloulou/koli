<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/menu.jsp"%>
<html>
<head>


<title>Liste des clients</title>

	<script type="text/javascript" type="text/javascript" src="./include/js/jquery.dataTables.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").dataTable();

	});
</script>
</head>
<body>
	<h3>Clients</h3>
<DIV class="content">
	
<DIV id="content1">
<s:url id="ajax" value="inputClientSave"/>
    
	<sj:a id="ajaxlink" 
		href="%{ajax}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
		
	>
	  	Ajouter un client
	</sj:a></DIV>
	<BR />
	

		
	<table id="table"  class="display"  >
		<thead>
<tr >
<th>Identifiant</th>
<th ></th>
<th >Nom</th>
<th >Actions</th>
</tr>
</thead>
<tbody>
<s:iterator value="clients">
			<s:url action="colisAffiche" id="afficheUrl">
				<s:param name="id" value="id" />
			</s:url>
			<s:url action="inputClientUpdate" id="editUrl">
				<s:param name="id" value="id" />
			</s:url>
			<s:url action="importerClient" id="importUrl">
				<s:param name="id" value="id" />
			</s:url>
		<tr >
			<td><s:property value="id" />
			</td>
			<td><s:property value="name" />
			</td>
			<td><s:property value="name" />
			</td>
<%-- 			<td><a href="<s:property value="#afficheUrl"/>">Afficher</a> --%>
<!-- 			</td> -->
			<td><sj:a  
		href="%{editUrl}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
	>
	Modifier
	</sj:a>
			
	<sj:a  
		href="%{importUrl}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
	>
	 Importer
	</sj:a>
			</td>
		</tr>
		</s:iterator>
</tbody>
	<tfoot>
		<tr>
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