<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
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
<title>STRUTS : Projet contact</title>
</head>
<body bgcolor="white">
	<div align="center">
		<h1>STRUTS : recherche contact</h1>
		<b>Ceci est la Page recherche.</b>
		<fieldset>
			<legend>Struts recherche </legend>
			<html:form action="/SearchContact">
				<html:errors />
				<table>

					<tr>

						<td align="center" colspan="2"><font size="4">Please
								Enter the Following Details</font>
					</tr>
					<tr>
						<td align="right">source :</td>
						<td align="left"><html:text property="element" size="30"
								maxlength="30" value="last" /></td>
					</tr>
					

					<tr>
						<td align="right"><html:submit>Save</html:submit></td>
					</tr>
				</table>


			</html:form>
		</fieldset>
	</div>
</body>
</html:html>