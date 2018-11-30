<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
#notDisplay {
	display: none;
}
input{width:100px;} /* needed only to fit in the "Run code snippet" box */

.wwFormTable tr {
    display: inline-block;
    padding:15px;
    padding-bottom: 0;
    margin-bottom: 0px;
}
</style>
<!-- 
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
-->
<title><bean:message key="list.page.title"/></title>
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gestionnaire de Contact</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Ajouter<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a HREF="creationContact.do"><bean:message key="link.add.contact"/></a></li>
          <li><a href="#">Entreprise</a></li>
        </ul>
      </li>
      <li><a href="#">Liste des contactsGroups</a></li>
    </ul>
     <!--  
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    -->
    <fieldset>
			<html:form action="/SearchContact">
				<html:errors />
				<table class="wwFormTable" >
					<tr>
						<td align="left"><html:text property="element" size="10"
								maxlength="30" value="" /></td>
					</tr>
					

					<tr>
						<td align="right"><html:submit><bean:message key="form.validate"/></html:submit></td>
					</tr>
				</table>


			</html:form>
		</fieldset>
    	
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </ul>
  </div>
</nav>

	<div align="center">
		<h1><bean:message key="list.page.h"/></h1>
		<!--  
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
		-->
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