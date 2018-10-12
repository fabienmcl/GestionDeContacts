<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>

<head>
<style>
#notDisplay {
	display: none;
}
form {
  /* Just to center the form on the page */
  margin: 0 auto;
  width: 400px;

  /* To see the limits of the form */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
}


.button {
  /* To position the buttons to the same position of the text fields */
  padding-left: 90px; /* same size as the label elements */
}

button {
  /* This extra magin represent the same space as the space between
     the labels and their text fields */
  margin-left: .5em;
}
</style>
<title><bean:message key="alter.page.title" /></title>

<html:base />

</head>

<body bgcolor="white">
<div align="center">
		<h1><bean:message key="alter.page.h" /></h1>
	
	<bean:define id="idContact" name='c' property='id'/>
	<bean:define id="firstNameContact" name='c' property='firstName'/>
	<bean:define id="lastNameContact" name='c' property='lastName'/>
	<bean:define id="emailContact" name='c' property='email'/>
	
	<html:form action="/AlterContact">
		<html:errors />
		<table>

			<tr>

				<td align="center" colspan="2"><font size="4"><bean:message key="form.title" /></font>
			</tr>
			<tr id="notDisplay">
				<!--  -->
				<td align="right"><bean:message key="form.id" /></td>
				<td align="left"><html:text property="id" size="30"
						maxlength="30" value="${idContact}"/></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="form.firstname" /></td>
				<td align="left"><html:text property="firstName" size="30"
						maxlength="30" value="${firstNameContact}" /></td>
			</tr>
			
			<tr> 
				<td align="right"><bean:message key="form.lastname" /></td>
				<td align="left"><html:text property="lastName" size="30"
						maxlength="30" value="${lastNameContact}" /></td>
				
			</tr>
			
			<tr>
				<td align="right"><bean:message key="form.email" /></td>
				<td align="left"><html:text property="email" size="30"
						maxlength="30" value="${emailContact}" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit><bean:message key="form.validate" /></html:submit></td>
			</tr>
		</table>


	</html:form>
	</div>
</body>
</html:html>