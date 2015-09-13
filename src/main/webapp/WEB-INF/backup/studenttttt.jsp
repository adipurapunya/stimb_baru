<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<link href="jsp/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
	<div class="page-header">
  		<h1>Sistem Informasi Akademik <small>STMB Bandung</small></h1>
	</div>
	
	<nav class="navbar navbar-default" role="navigation">
  	<!-- Collect the nav links, forms, and other content for toggling -->
  	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    	<ul class="nav navbar-nav">
      <li class="active"><a href="#">Dashboard</a></li>
      <li><a href="#">Update</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Data <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Kecamatan</a></li>
          <li><a href="#">Kabupaten</a></li>
          <li><a href="#">Provinsi</a></li>
          <li class="divider"></li>
          <li><a href="#">Negara</a></li>
          <li class="divider"></li>
          <li><a href="#">Benua</a></li>
        </ul>
      </li>
    </ul>
	
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"> <span class="glyphicon glyphicon-user"></span> Username</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="glyphicon glyphicon-asterisk"></span><b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">Akun</a></li>
          <li><a href="#">Setting</a></li>
          <li><a href="#">Profil</a></li>
          <li class="divider"></li>
          <li><a href="#">Logout</a></li>
        </ul>
      </li>
    	</ul>
		
  	</div><!-- /.navbar-collapse -->
	</nav>
	

Language: <a href="./?language=en">English</a> | <a href="./?language=tl">Filipino</a> 
| <a href="./?language=fr">French</a> | <a href="./?language=id">Indonesia</a> 
<br/><br />
<spring:message code="user.logged"/>: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
<br />
<a href="logout"><spring:message code="user.logout"/></a>

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
					<input type="submit" name="action" value="Add" />
					<input type="submit" name="action" value="Edit" />
					<input type="submit" name="action" value="Delete" />
					<input type="submit" name="action" value="Search" />
				</td>
			</tr>
		</table>
	</form:form>
</sec:authorize>

<br>
<table border="1">
	<th><spring:message code="student.id"/></th>
	<th><spring:message code="student.firstname"/></th>
	<th><spring:message code="student.lastname"/></th>
	<th><spring:message code="student.yearLevel"/></th>
	<c:forEach items="${studentList}" var="student">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.firstname}</td>
			<td>${student.lastname}</td>
			<td>${student.yearLevel}</td>
		</tr>
	</c:forEach>
</table>


<p>
<button type="button" class="btn btn-default">Tambah Data</button>
</p>
<table class="table table-bordered">
  <tr>
  	<th>ID</th>
  	<th>Nama</th>
  	<th>Tanggal Lahir</th>
  	<th>Jenis Kelamin</th>
  	<th>Alamat</th>
  	<th>Aksi</th>
  </tr>
  <tr>
  	<td>001</td>
  	<td>Ghazali</td>
  	<td>1992-10-11</td>
  	<td>Laki-laki</td>
  	<td>Desa Baroh</td>
  	<td>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
  	</td>
  </tr>
  <tr>
  	<td>001</td>
  	<td>Ghazali</td>
  	<td>1992-10-11</td>
  	<td>Laki-laki</td>
  	<td>Desa Baroh</td>
  	<td>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
  	</td>
  </tr>
  <tr>
  	<td>001</td>
  	<td>Ghazali</td>
  	<td>1992-10-11</td>
  	<td>Laki-laki</td>
  	<td>Desa Baroh</td>
  	<td>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
  	</td>
  </tr>
  <tr>
  	<td>001</td>
  	<td>Ghazali</td>
  	<td>1992-10-11</td>
  	<td>Laki-laki</td>
  	<td>Desa Baroh</td>
  	<td>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
  		<a href="#" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
  	</td>
  </tr>
</table>

<footer>
<p>&copy Ghazali 2014</p>
</footer>
</div>

	<script type="text/javascript" src="jsp/js/bootstrap.js"></script>
	<script type="text/javascript" src="jsp/js/jquery.js"></script>
	<script type="text/javascript" src="jsp/js/dropdown.js"></script>
	<script type="text/javascript" src="jsp/js/tab.js"></script>
</body>
</html>
