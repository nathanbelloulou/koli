<%@ include file="include/menu.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des colis</title>
<script type="text/javascript">
$(document).ready( function() {
    $.subscribe('JsonResult', function(event,data) {
        
    	$('#content2').show();
    	$('#contract').html("<a href=\"/koli/generateContratIhm.action?id="+event.originalEvent.data.id+"\" class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\" >Importer contrat</a>");
    	$('#ficheinfo').html("<a href=\"/koli/generateFicheInfoIhm.action?id="+event.originalEvent.data.id+"\" class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\" >Importer fiche information</a>");
    	
    	$('#information').show();
        
    	
    	$('#adresse').append(event.originalEvent.data.adresse);
    	$('#capital').append(event.originalEvent.data.capital);
    	$('#codePostal').append(event.originalEvent.data.codePostal);
    	$('#gerant').append(event.originalEvent.data.gerant);
    	$('#RCS').append(event.originalEvent.data.RCS);
    	$('#idLaPoste').append(event.originalEvent.data.idLaPoste);
    	$('#idExpeditorINET').append(event.originalEvent.data.idExpeditorINET);
	$('#identifiant').append(event.originalEvent.data.id);
	$('#name').append(event.originalEvent.data.name);
	$('#ville').append(event.originalEvent.data.ville);
	$('#adresse').append(event.originalEvent.data.adresse);
	$('#capital').append(event.originalEvent.data.capital);
	$('#codePostal').append(event.originalEvent.data.codePostal);
	$('#gerant').append(event.originalEvent.data.gerant);
	$('#RCS').append(event.originalEvent.data.RCS);
	$('#idLaPoste').append(event.originalEvent.data.idLaPoste);
	$('#idExpeditorINET').append(event.originalEvent.data.idExpeditorINET);

      
    });
});    
</script>
</head>
<body>
<h3>Commercial</h3>
	<BR />

	<div class="content">
		<FIELDSET>
			<LEGEND>Recherche</LEGEND>
			<s:form id="formevent" action="executeClientIhm">
			<div class="type-select">

					<sj:autocompleter 
					id="languages" 
					list="%{clients}" 
					listValue="name"
					name="id" 
					listKey="id" 
					selectBox="true" />
				
				<sj:submit targets="content1" value="Afficher" timeout="2500"
					indicator="indicator" dataType="json" onSuccessTopics="JsonResult"
					onCompleteTopics="complete" button="true" />
</div>

			</s:form>

		</FIELDSET>
		
			<FIELDSET id='information' style="display: none"><LEGEND>Information </LEGEND>
			<div class="data"><div class="label">Identifiant:</div> <span id="identifiant" ></span></div>
			<div class="data"><div class="label">Nom du client: </div><span id="name" ></span></div>
			<div class="data"><div class="label">Adresse: </div><span id="adresse" ></span></div>
			<div class="data"><div class="label">Code postal: </div><span id="codePostal" ></span></div>
			<div class="data"><div class="label">Ville: </div><span id="ville" ></span></div>
			<div class="data"><div class="label">Nom du gérant: </div><span id="gerant" ></span></div>
			<div class="data"><div class="label">RCS: </div><span id="RCS" ></span></div>
			<div class="data"><div class="label">idExpeditorINET: </div><span id="idExpeditorINET" ></span></div>
			<div class="data"><div class="label">idLaPoste: </div><span id="idLaPoste" ></span></div>
			
			
			</FIELDSET>


		<FIELDSET id="content2" style="display: none">
			<LEGEND>Réclamations</LEGEND>
			<span id="ficheinfo"></span>
			<span id="contract"></span>
		</FIELDSET>

	</div>
	<%@ include file="include/footer.jsp"%>