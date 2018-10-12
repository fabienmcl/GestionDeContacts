<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html:html>
	<head>
		<title><bean:message key="error.page.title"/></title>
	</head>
	<body>
		<h1><bean:message key="error.page.h"/></h1>
		<html:errors/><br/> 
		<a href="listeContact.do"><bean:message key="link.list.contact"/></a>
	</body>
</html:html>
