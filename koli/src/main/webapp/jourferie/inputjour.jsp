<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis à jour du jour férié</title>
</head>
<body>

<s:if test="jourFerie != null" >

     <s:form action="executeJourFerieUpdate" method="post">
     
     	<s:textfield name="jourFerie.id" label="Id" readonly="true"/>
     	  <sj:datepicker name="date" value="jourFerie.date" id="date" label="Selectionner un jour" displayFormat="dd/mm/yy"/>
     	
      <input class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" type="submit" name="mysubmit" value="Enregistrer" />
  
     </s:form>


</s:if>

<s:else>
  <s:form action="executeJourFerieSave" method="post">
     
     	  <sj:datepicker name="date"  id="date" label="Selectionner un jour" displayFormat="dd/mm/yy"/>
     
  <input class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" type="submit" name="mysubmit" value="Enregistrer" />
     
     </s:form>
</s:else>


</body>
</html>