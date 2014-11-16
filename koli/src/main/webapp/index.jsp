<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include/menu.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT type="text/javascript"> 
$(document).ready( function() {
$.subscribe('completediv2', function(event,data) {
    if(event.originalEvent.status == "success")
    {
    	
    	setTimeout( function() {
			$.publish('reloaddiv2');	
		}, 2000);
    }
});
    
   });</SCRIPT>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">




<title>Accueil</title>
</head>
<body>
	<DIV class="content">
		<h3>Accueil</h3>
		
		
		<s:url id="ajax" value="switchOnOff"/>		
		<s:url id="ajax2" value="now" />
	 	<s:url id="ajax3" value="getNbThread"/>
   	 	<s:url id="ajax4" value="setNbThread"/>

	<fieldset>
		<legend>Etat de l'ordonnanceur:</legend>
			<sj:div id="div2" href="%{ajax2}" reloadTopics="reloaddiv2"
				onCompleteTopics="completediv2" effect="highlight">
			</sj:div>

<!-- bouton -->
			<sj:a id="ajaxlink" href="%{ajax}" targets="div2" button="true"
				buttonIcon="ui-icon-refresh">Switch ordonnanceur</sj:a>
		</fieldset>
	<BR />
	
	<s:form id="sliderForm" action="%{ajax4}" theme="simple" cssClass="yform">
	<fieldset>
		<legend>Nombre de thread:</legend>

				<sj:div id="div3" href="%{ajax3}" effect="highlight">
				</sj:div>

				<sj:slider 
				id="setNbThread" 
				name="nbThread" 
				value="25" 
				displayValueElement="div3" 
				min="1" 
				max="100" 
				animate="true" 
				step="1" 
				cssStyle="margin: 10px;"
			/>
		<div class="type-button">
			<sj:a 
				id="submitSliderForm"
				formIds="sliderForm" 
				button="true" 
				buttonIcon="ui-icon-gear" 
				targets="result" 
			>
			MAJ
			</sj:a> 
			
		</div>
	</fieldset>
</s:form>
	</DIV>
</body>
</html>