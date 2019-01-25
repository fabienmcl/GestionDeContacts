<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gestionnaire de Contact</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="javascript:history.back()">Home</a></li>
      <li  class="active" ><a HREF="#">Modifier un contact</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </ul>
  </div>
</nav>

	<div align="center">
		<h1>Modifier un contact</h1>
		
	</div>
<div align="center">
		<h1><bean:message key="alter.page.h" /></h1>
	
	<bean:define id="idContact" name='c' property='id'/>
	<bean:define id="firstNameContact" name='c' property='firstName'/>
	<bean:define id="lastNameContact" name='c' property='lastName'/>
	<bean:define id="emailContact" name='c' property='email'/>
	<bean:define id="idAddress" name='address' property='addressId'/>
	<bean:define id="streetContact" name='address' property='street'/>
	<bean:define id="cityContact" name='address' property='city'/>
	<bean:define id="zipContact" name='address' property='zip'/>
	<bean:define id="countryContact" name='address' property='country'/>
	<bean:define id="idPhone" name='phone' property='id'/>
	<bean:define id="phonenumberContact" name='phone' property='phoneNumber'/>
	<bean:define id="phonekindContact" name='phone' property='phoneKind'/>
	
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
			
						<tr id="notDisplay">
				<!--  -->
				<td align="right"></td>
				<td align="left"><html:text property="idAddress" size="30"
						maxlength="30" value="${idAddress}"/></td>
			</tr>
			
						<tr id="notDisplay">
				<!--  -->
				<td align="right"></td>
				<td align="left"><html:text property="idPhone" size="30"
						maxlength="30" value="${idPhone}"/></td>
			</tr>
			

			
			
			    <% String s = request.getParameter("firstName"); %>
    <%=s %>
    <% if (s==null || s.isEmpty()) { %> 


   <% } else { %>
          						<tr>
						<td align="right"><bean:message key="form.firstname" /></td>
						<td align="left"><html:text property="firstName" size="30"
						maxlength="30" value="${firstNameContact}" /></td>
					</tr>
    <% } %>
			
		
			
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
			
						
          <td align="center" colspan="2">
		<p />
		<font size="4"><bean:message key="add.page.address"/></font>
 	</tr>
 	
 	     <tr>
          <td align="right">
            <bean:message key="add.page.street"/> 
          </td>
          <td align="left">
            <html:text property="street" size="30" maxlength="50" value="${streetContact}"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.city"/> 
          </td>
          <td align="left">
            <html:text property="city" size="30" maxlength="50" value="${cityContact}" />
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.zip"/> 
          </td>
          <td align="left">
            <html:text property="zip" size="30" maxlength="50" value="${zipContact}"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.country"/> 
          </td>
          <td align="left">
            <html:text property="country" size="30" maxlength="50" value="${countryContact}"/>
          </td>
        </tr>
        
     <tr>

          <td align="center" colspan="2">
		<p />
		<font size="4"><bean:message key="add.page.phone"/></font>
 	</tr>
 	
 	        <tr>
          <td align="right">
            <bean:message key="add.page.phonenumber"/> 
          </td>
          <td align="left">
            <html:text property="phonenumber" size="30" maxlength="50" value="${phonenumberContact}"/>
          </td>
        </tr>
        
         	        <tr>
          <td align="right">
            <bean:message key="add.page.phonekind"/> 
          </td>
          <td align="left">
            <html:text property="phonekind" size="30" maxlength="50" value="${phonekindContact}"/>
          </td>
        </tr>
		
			
			<tr>
				<td align="right"><html:submit><bean:message key="form.validate" /></html:submit></td>
			</tr>
		</table>


	</html:form>
	</div>
</body>
</html:html>