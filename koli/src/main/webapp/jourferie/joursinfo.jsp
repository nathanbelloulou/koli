
<%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ include file="../include/menu.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des jours fériés</title>
<script type="text/javascript" src="./include/jquery.tablesorter.min.js"></script> 
<script type="text/javascript">
	$(document).ready(function() {
		$("#table").tablesorter();
	});
</script>
</head>
<body>
<div class="content">
<h3>Liste des jours fériés.</h3>
<div id="content1">

<s:url id="ajax" value="inputJourFerieSave"/>
    
	<sj:a id="ajaxlink" 
		href="%{ajax}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
		
	>
Ajouter un  jour férié	</sj:a></div>
<table id="table" class="tablesorter">
<thead><tr><th>Id</th><th>Jour</th></tr></thead><tbody>
<s:iterator value="joursFeries">

     	<s:url action="inputJourFerieUpdate" id="updateUrl">
				<s:param name="id" value="id" />
			</s:url>
    <s:url action="jourFerieDelete" id="deleteUrl">
				<s:param name="id" value="id" />
			</s:url>


	<tr>
	<td><s:property value="id" /><td>
	

<s:date name="date" format="dd MMM yyyy" />
	</td>
	<td><sj:a  
		href="%{updateUrl}" 
		targets="content1" 
		indicator="indicator" 
		button="true" 
	>
	Modifier
	</sj:a></td>
	<td><a class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" href="<s:property value="#deleteUrl"/>" >
<span class="ui-button-text"> Supprimer </span>
</a></td>


</tr>


</s:iterator></tbody>
</table>


</div>
</body>
</html>