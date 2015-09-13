<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<link href="<c:url value='/resources/resources/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css"/>
	
	<!-- <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/> -->
	
</head>
<body>
<div class="container">
	<div class="page-header">
  		<h1><spring:message code="student.titleUp"/><small> STMB Bandung</small></h1>
	</div>
	Language: <a href="./?language=en">English</a> | <a href="./?language=id">Indonesia</a> 
	<br/>
	
	<nav class="navbar navbar-default" role="navigation">
  	<!-- Collect the nav links, forms, and other content for toggling -->
  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    	<ul class="nav navbar-nav">
      <li class="active"><a href="#">Dashboard</a></li>
      <li><a href="#">Update</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Data <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Data Mahasiswa</a></li>
          <li class="divider"></li>
          <li><a href="#">Data Dosen</a></li>
          <li class="divider"></li>
          <li><a href="#">Daftar Mata Kuliah</a></li>
          <li class="divider"></li>
          <li><a href="#">Jadwal Kuliah</a></li>
          <li class="divider"></li>
          <li><a href="#">Daftar Ruangan</a></li>
        </ul>
      </li>
    </ul>
	
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"> <span class="glyphicon glyphicon-user"></span> <sec:authentication property="name"/></a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="glyphicon glyphicon-asterisk"></span><b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Akun</a></li>
          <li><a href="#">Setting</a></li>
          <li><a href="#">Profil</a></li>
          <li class="divider"></li>
          <li><a href="logout"><spring:message code="user.logout"/></a></li>
        </ul>
      </li>
    	</ul>
		
  	</div><!-- /.navbar-collapse -->
	</nav>
	


<!-- 
<spring:message code="user.logged"/>: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
<br />
<a href="logout"><spring:message code="user.logout"/></a>
-->

<h1><spring:message code="student.title"/></h1>
<sec:authorize access="hasRole('Admin')">
	<form:form action="student.do" method="POST" commandName="student">
		<table>
			<tr>
				<td><spring:message code="student.id"/></td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.firstname"/></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.lastname"/></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><spring:message code="student.yearLevel"/></td>
				<td><form:input path="yearLevel" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="btn btn-default" name="action" value="<spring:message code='student.add'/>" />
					<input type="submit" class="btn btn-default" name="action" value="<spring:message code='student.edit'/>" />
					<input type="submit" class="btn btn-default" name="action" value="<spring:message code='student.delete'/>" />
					<input type="submit" class="btn btn-default" name="action" value="<spring:message code='student.search'/>" />
				</td>
			</tr>
		</table>
	</form:form>
</sec:authorize>

<br>
<table class="table table-bordered">
	<th><spring:message code="student.id"/></th>
	<th><spring:message code="student.firstname"/></th>
	<th><spring:message code="student.lastname"/></th>
	<th><spring:message code="student.yearLevel"/></th>
	<th><spring:message code="student.action"/></th>
	<c:forEach items="${studentList}" var="student">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.yearLevel}</td>
			<td><a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-remove"></span></a></td>	
		</tr>
	</c:forEach>
</table>

<footer>
<p>&copy Sofa Team 2015</p>
</footer>
</div>

	<script type="text/javascript" src="<c:url value='/resources/resources/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/resources/js/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/resources/js/dropdown.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/resources/js/tab.js'/>"></script>
</body>
</html>
