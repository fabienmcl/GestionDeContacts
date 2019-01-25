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
.wwFormTable tr {
    display: inline-block;
    padding:15px;
    padding-bottom: 0;
    margin-bottom: 0px;
}body{
  padding:20px 20px;
}

.results tr[visible='false'],
.no-result{
  display:none;
}

.results tr[visible='true']{
  display:table-row;
}

.counter{
  padding:8px; 
  color:#ccc;
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

<title><bean:message key="list.page.title2"/></title>
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gestionnaire de Contact</a>
    </div>
    <ul class="nav navbar-nav">
      <li> <a href="home.do">Home</a></li>
      <li class="active" ><a HREF="creationGroup.do"><bean:message key="link.add.group"/></a></li>
     <li><a HREF="creationContact.do">Injecter base de test</a></li>
     <!-- 
     deux conatcts rempli : 2 tels, une adress, 2  group de contact
     -->
     
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="http://localhost:8080/ContactsStruts/"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </ul>
  </div>
</nav>

	<div align="center">
		<h1>Gestionnaire de contact</h1>
		
	</div>
			           <td>
		            	 <html:form action="/AddGroup">
		            	 
		            	 			<tr>
				<td align="right"><bean:message key="form.lastname" /></td>
				<td align="left"><html:text property="groupName" size="30"
						maxlength="30" value="groupe" /></td>
			</tr>
		            	 
							<html:submit styleClass="btn btn-danger btn-xs">
										Add Group
							</html:submit>
						</html:form>
					</td>

	<div>
	<div class="form-group pull-right">
    <input type="text" class="search form-control" placeholder="What you looking for?">
</div>
<span class="counter pull-right"></span>
<table  class="table table-striped table-hover table-bordered results">
  <thead > 
    <tr>
      <th>#</th>
      <th class="col-md-5 col-xs-5">Nom</th>
      <th class="col-md-5 col-xs-5">Edit</th>
      <th class="col-md-4 col-xs-4">Delete</th>
      <th></th>
      <th></th>
    </tr>
    <tr class="warning no-result">
      <td colspan="4"><i class="fa fa-warning"></i> No result</td>
    </tr>
  </thead>
  <tbody>
  <tbody>
			<logic:iterate name="listGroupsJDBC" id="itemJDBC">
		        <tr class="clickable-row">
		        	<td><bean:write name="itemJDBC" property="groupId"/></td>
		            <td><bean:write name="itemJDBC" property="groupName"/></td>
		            
		           <td>
		            	 <html:form action="/EditGroup">
							<html:hidden property="groupId" name="itemJDBC" value="${itemJDBC.groupId}" />
							<html:hidden property="groupName" name="itemJDBC" value="${itemJDBC.groupName}" />
							<html:submit styleClass="btn btn-danger btn-xs">
										Edit Group
							</html:submit>
						</html:form>
					</td>
					
					<td>
		            	 <html:form action="/DeleteGroup">
							<html:hidden property="groupId" name="itemJDBC" value="${itemJDBC.groupId}" />
							<html:hidden property="groupName" name="itemJDBC" value="${itemJDBC.groupName}" />
							<html:submit styleClass="btn btn-danger btn-xs">
										Delete Group
							</html:submit>
						</html:form>
					</td>
		     
					
		        </tr>
	        </logic:iterate>
</tbody>
</table>
	</div>	
</body>
</html>