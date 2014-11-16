<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis à jour du message</title>
</head>
<body>

<s:if test="message != null" >

     <s:form action="executeMessageUpdate" method="post">
     
     	<s:textfield name="message.id" label="Id" />
     	<s:textfield name="message.status" label="Status" />
     	
     	
     	<s:submit />
     
     </s:form>


</s:if>

<s:else>
  <s:form action="executeMessageSave" method="post">
     
     	<s:textfield name="message.id" label="Id" />
     	<s:textfield name="message.status" label="Status" />
     	
     	
     	<s:submit />
     
     </s:form>
</s:else>


</body>
</html>