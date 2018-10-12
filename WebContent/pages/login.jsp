<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<html>
<head>
<style>
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
<title><bean:message key="login.page.title"/></title>

</head>
<body bgcolor="white">
	<div align="center">
		<h1><bean:message key="login.page.h"/></h1>
		<b><bean:message key="login.page.desc"/></b>
		<fieldset>
			<legend><bean:message key="form.login.legend"/> </legend>
			<html:form action="/CheckLogin">
				<html:errors />
				<table>

					<tr>

						<td align="center" colspan="2"><font size="4">
						<bean:message key="form.title"/></font>
					</tr>
					<tr>
						<td align="right"><bean:message key="form.login"/></td>
						<td align="left"><html:text property="firstName" size="30"
								maxlength="30" value="root" /></td>
					</tr>
					<tr>
						<td align="right"><bean:message key="form.password"/></td>
						<td align="left"><html:text property="lastName" size="30"
								maxlength="30" value="root" /></td>
					</tr>

					<tr>
						<td align="right"><html:submit><bean:message key="form.validate"/></html:submit></td>
					</tr>
				</table>


			</html:form>
		</fieldset>
	</div>
</body>
</html:html>