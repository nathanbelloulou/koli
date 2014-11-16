<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<BR />
	<s:if test="client != null">

		<s:form action="executeClientUpdate" method="post">

			<s:textfield name="client.id" label="Id" readonly="true" />
			<s:textfield name="client.name" label="Nom" />
			<s:textfield name="client.adresse" label="Adresse" />
			<s:textfield name="client.ville" label="Ville" />
			<s:textfield name="client.codePostal" label="Code postal" />
			<s:textfield name="client.capital" label="Capital" />
			<s:textfield name="client.RCS" label="RCS" />
			<s:textfield name="client.gerant" label="Nom du gérant" />
			<s:textfield name="client.idLaPoste" label="Identifant la Poste" />
			<s:textfield name="client.idExpeditorINET" label="Id expeditor Inet" />

			<s:submit />

		</s:form>


	</s:if>

	<s:else>
		<s:form action="executeClientSave" method="post">

			<s:textfield name="client.id" label="Id" readonly="true" />
			<s:textfield name="client.name" label="Nom" />
			<s:textfield name="client.adresse" label="Adresse" />
			<s:textfield name="client.ville" label="Ville" />
			<s:textfield name="client.codePostal" label="Code postal" />
			<s:textfield name="client.capital" label="Capital" />
			<s:textfield name="client.RCS" label="RCS" />
			<s:textfield name="client.gerant" label="Nom du gérant" />
			<s:textfield name="client.idLaPoste" label="Identifant la Poste" />
			<s:textfield name="client.idExpeditorINET" label="Id expeditor Inet" />

			<s:submit label="Enregistrer" />

		</s:form>
	</s:else>


</body>
</html>