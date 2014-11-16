<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload</title>
</head>
<body>
Identifiant client :<s:property value="id" />

<s:form action="executeClient" method="POST" enctype="multipart/form-data">


		<s:file name="upload" label="File" />


		<s:submit value="envoi" />
	<input type="hidden" name="id" value="<s:property value="id"/>">
	</s:form>
</body>
</html>