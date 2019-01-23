<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

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

<script type="text/javascript">
$(document).ready(function() {
	
	  $(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;
	    $('.counter').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	});
</script>

<title><bean:message key="add.page.title" /></title>

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
      <li  class="active" ><a HREF="#"><bean:message key="link.add.contact"/></a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="http://localhost:8080/ContactsStruts/"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </ul>
  </div>
</nav>

	<div align="center">
		<h1>Ajouter un contact</h1>
		
	</div>

<div align="center">
	
	<html:form action="/AddContact">
		<html:errors />
		<table>

			<tr>

				<td align="center" colspan="2"><font size="4"><bean:message key="form.title" /></font>
			</tr>
			<tr id="notDisplay">
				<td align="right"><bean:message key="form.id" /></td>
				<td align="left"><html:text property="id" size="30"
						maxlength="30" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="form.firstname" /></td>
				<td align="left"><html:text property="firstName" size="30"
						maxlength="30" value="root" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="form.lastname" /></td>
				<td align="left"><html:text property="lastName" size="30"
						maxlength="30" value="root" /></td>
			</tr>

			<tr>
				<td align="right"><bean:message key="form.email" /></td>
				<td align="left"><html:text property="email" size="30"
						maxlength="30" value="root@root.fr"/></td>
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
            <html:text property="street" size="30" maxlength="50"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.city"/> 
          </td>
          <td align="left">
            <html:text property="city" size="30" maxlength="50"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.zip"/> 
          </td>
          <td align="left">
            <html:text property="zip" size="30" maxlength="50"/>
          </td>
        </tr>
        
        <tr>
          <td align="right">
            <bean:message key="add.page.country"/> 
          </td>
          <td align="left">
            <html:text property="country" size="30" maxlength="50"/>
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
            <html:text property="phonenumber" size="30" maxlength="50"/>
          </td>
        </tr>
        
         	        <tr>
          <td align="right">
            <bean:message key="add.page.phonekind"/> 
          </td>
          <td align="left">
            <html:text property="phonekind" size="30" maxlength="50"/>
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
