<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript"
	src="./include/jquery-latest.js"></script>
	<script type="text/javascript" src="./include/jquery.tablesorter.min.js"></script> 

<script type="text/javascript"> 
$(document).ready(function(){   
	
	$("ul.topnav li span").hover(function() { 
		
		//Following events are applied to the subnav itself (moving subnav up and down)
		$(this).parent().find("ul.subnav").slideDown('fast').show(); //Drop down the subnav on click
 
		$(this).parent().hover(function() {
		}, function(){	
			$(this).parent().find("ul.subnav").slideUp('slow'); //When the mouse hovers out of the subnav, move it back up
		});
 
		//Following events are applied to the trigger (Hover events for the trigger)
		}).hover(function() { 
			$(this).addClass("subhover"); //On hover over, add class "subhover"
		}, function(){	//On Hover Out
			$(this).removeClass("subhover"); //On hover out, remove class "subhover"
	});
 
});
</script>
<sj:head jqueryui="true" />

<link href="./include/style.css" rel="stylesheet" type="text/css" />
<link href="./include/css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="./include/css/demo_page.css" rel="stylesheet" type="text/css" />

<title>Gestion des colis</title>
</head>
<body>
	<div class="menu">
		<h2>Domotyk:Koli</h2>
		<ul class="topnav">
			<li><a href="index.jsp">accueil</a>
			</li>
			<li><a href="<s:url action='resultClientIhm'/>">Commercial</a></li>
			
			<li><a href="<s:url action='allClients'/>">Clients</a>
					</li>
<%-- 					<li><a href="<s:url action='allReclamationFinder'/>">Réclamations</a> --%>
<!-- 					</li> -->
					<li><a href="<s:url action='allColisFinder'/>">Colis</a>
					</li>
			<li><SPAN> <a href="#">Paramétrage</a>
			</SPAN>
				<ul class="subnav">
					
					
					<li><a href="<s:url action='allMessagesFinder'/>">Messages</a>
					</li>
					<li><a href="<s:url action='allJoursFeriesFinder'/>">Jours
							fériés</a>
					</li>
				</ul></li>
		</ul>
		<br /> <br />
	</div>