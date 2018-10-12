<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<style>
#notDisplay {
	display: none;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	font: 200 20px/1.5 Helvetica, Verdana, sans-serif;
	border-bottom: 1px solid #ccc;
}

ul div {
	text-decoration: none;
	color: #000;
	display: inline-block;
	width: 200px;
}

li {
	/* Just to center the form on the page */
	margin: 0 auto;
	width: 400px;
	/* To see the limits of the form */
	padding: 1em;
	border: 1px solid #CCC;
	border-radius: 1em;
}

li form {
	/* Just to center the form on the page */
	margin: 0 auto;
	display: inline-block;
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
<title><bean:message key="list.page.title"/></title>
</head>
<body>
	<div align="center">
		<h1><bean:message key="list.page.h"/></h1>
		
		<a HREF="creationContact.do"><bean:message key="link.add.contact"/></a>
		<fieldset>
			<legend><bean:message key="form.search.legend"/> </legend>
			<html:form action="/SearchContact">
				<html:errors />
				<table>

					<tr>

						<td align="center" colspan="2"><font size="4"><bean:message key="form.title"/></font>
					</tr>
					<tr>
						<td align="right"><bean:message key="form.element"/></td>
						<td align="left"><html:text property="element" size="30"
								maxlength="30" value="" /></td>
					</tr>
					

					<tr>
						<td align="right"><html:submit><bean:message key="form.validate"/></html:submit></td>
					</tr>
				</table>


			</html:form>
		</fieldset>
		<ul>
			<logic:iterate name="listContactsJDBC" id="itemJDBC">
				<li>
					<p id="notDisplay">
						<bean:write name="itemJDBC" property="id" />
					</p> 
					<b><bean:message key="form.firstname"/></b><bean:write name="itemJDBC" property="firstName" /> , 
					<b><bean:message key="form.lastname"/></b><bean:write name="itemJDBC" property="lastName" /> , 
					<b><bean:message key="form.email"/></b><bean:write name="itemJDBC" property="email" /> 
					<br> 
					<html:form action="/RemoveContact">
						<html:errors />
						<table id="notDisplay">
							<tr>
								<td><html:text name="itemJDBC" property="id" size="30"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><html:text name="itemJDBC" property="email" size="30"
										maxlength="30" /></td>
							</tr>

						</table>
						<tr>
							<td align="right"><html:submit><bean:message key="form.validate.remove"/></html:submit></td>
						</tr>

					</html:form> <html:form action="/AlterContact2">
						<html:errors />
						<table id="notDisplay">

							<tr>

								<td align="center" colspan="2"><font size="4"><bean:message key="form.title"/></font>
							</tr>
							<tr>
								<td><html:text name="itemJDBC" property="id" size="30"
										maxlength="30" /></td>
							</tr>
							<tr>
								<td><html:text name="itemJDBC" property="firstName"
										size="30" maxlength="30" /></td>
							</tr>
							<tr>
								<td><html:text name="itemJDBC" property="lastName"
										size="30" maxlength="30" /></td>
							</tr>

							<tr>
								<td><html:text name="itemJDBC" property="email" size="30"
										maxlength="30" /></td>
							</tr>

						</table>
						<tr>
							<td align="right"><html:submit><bean:message key="form.validate.alter"/></html:submit></td>
						</tr>
					</html:form>

				</li>
			</logic:iterate>
		</ul>
	</div>
	
</body>
</html>