<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>STiMB Bandung</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="<c:url value='/resources/resources/css/bootstrap.css'/>" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="<c:url value='/resources/resources/css/font-awesome.css'/>" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="<c:url value='/resources/resources/js/morris/morris-0.4.3.min.css'/>" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="<c:url value='/resources/resources/css/custom.css'/>" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">STiMB Bandung</a> 
            </div>
      					<!-- 
      					<table border=0>
      						<tr>
      							<td> <font style="color: white">&nbsp;<spring:message code="home.english"/> </font></td><td colspan="1"><a href="./?language=en" class=""><img align="bottom" src="http://flags.redpixart.com/img/united_kingdom_preview.gif" alt="" style="float: left;" />&nbsp;</a> </td> 
      							<td> <font style="color: white"><spring:message code="home.indonesia"/> </font></td><td colspan="1"><a href="./?language=id" class=""><img align="bottom" src="http://flags.redpixart.com/img/indonesia_preview.gif"  alt="" style="float:left;" />&nbsp;</a></td> 
      							<td width="1000" align="right">
      								<div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;"> <spring:message code="user.logged"/> <sec:authentication property="name"/> &nbsp; <a href="logout" class="btn btn-danger square-btn-adjust"><spring:message code="user.logout"/></a> </div>
      							</td>
      						</tr>
      					</table>
      					-->
      					
      					<table border=0>
      						<tr>
      							<td> <font style="color: white"><spring:message code="home.english"/> </font></td>
      							<td>&nbsp;<font style="color: white"><spring:message code="home.indonesia"/> </font></td>
      							<td width="1000" align="right" rowspan="2">
      								<div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;"> <spring:message code="user.logged"/> <sec:authentication property="name"/> &nbsp; <a href="logout" class="btn btn-danger square-btn-adjust"><spring:message code="user.logout"/></a> </div>
      							</td>
      						</tr>
      						<tr>
      							<td align="center"><a href="./?language=en" class=""><img src="http://flags.redpixart.com/img/united_kingdom_preview.gif" alt="" style="float: left;" /></a></div></td> 
      							<td align="center"><a href="./?language=id" class=""><img src="http://flags.redpixart.com/img/indonesia_preview.gif"  alt="" style="float:left;" /></a></div></td> 
      							<td></td>
      						</tr>
      					</table>
      					
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="<c:url value='/resources/resources/img/find_user.png'/>" class="user-image img-responsive"/>
					</li>
					
					<li>
                        <a class="active-menu"  href="index.html"><i class="fa fa-dashboard fa-3x"></i><spring:message code="home.dashboard"/></a>
                    </li>
					
					<li>
                        <a href="#"><i class="fa fa-sitemap fa-3x"></i><spring:message code="home.masterdata"/><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"></a>
                            </li>
                            <li>
                                <a href="${context}/levelyear"><spring:message code="home.levelyear"/></a>
                            </li>
                            <!-- <li>
                                <a href="${context}/fieldstudy"><spring:message code="home.filedstudy"/></a>
                            </li> 
                            <li>
                                <a href="${context}/courses"><spring:message code="home.courses"/></a>
                            </li>
                            -->
                            
                            <li>
                                <a href="${context}/prodi"><spring:message code="home.prodi"/></a>
                            </li>
                            
                            <li>
                                <a href="${context}/kurikulum"><spring:message code="home.curiculum"/></a>
                            </li>
                            
                            <li>
                                <a href="${context}/mayor">MAYOR</a>
                            </li>
                            
                            <li>
                                <a href="${context}/kelompokkul">KELOMPOK MATKUL</a>
                            </li>
                            
                            <li>
                                <a href="${context}/matkul">MATA KULIAH</a>
                            </li>
                            
                            <li>
                                <a href="${context}/listmatkul">LIST MATA KULIAH</a>
                            </li>
                            
                            <li>
                                <a href="#"><spring:message code="home.peopledata"/><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="${context}/lecturer"><spring:message code="home.lecturedata"/></a>
                                    </li>
                                    <li>
                                        <a href="${context}/student"><spring:message code="home.studentdata"/></a>
                                    </li>
                                </ul>
                               
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a  href="form.html"><i class="fa fa-edit fa-3x"></i> <spring:message code="home.guardianship"/> </a>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-3x"></i></i><spring:message code="home.attendance"/><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.attendancelecture"/></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.attendancestudent"/></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.attendanceemployee"/></a>
                            </li>
                        </ul>
                    </li>
				    
				    <li>
                        <a  href="table.html"><i class="fa fa-table fa-3x"></i><spring:message code="home.roomsetting"/></a>
                    </li>
                    
				     
                    <li>
                        <a  href="ui.html"><i class="fa fa-desktop fa-3x"></i><spring:message code="home.courseschedule"/></a>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-qrcode fa-3x"></i></i><spring:message code="home.finalproject"/><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#"></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.finalprojectlecturer"/></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.finalprojectstudent"/></a>
                            </li>
                        </ul>
                    </li>
                   
                    <!--
                  	<li>
                        <a  href="blank.html"><i class="fa fa-square-o fa-3x"></i> Blank Page</a>
                  	</li>	
                  	-->
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
            
            	<div class="row">
                    <div class="col-md-12">
                     <h2><sec:authentication property="authorities"/> <spring:message code="home.dashboard"/></h2>   
                        <h5><spring:message code="home.greetings"/> <sec:authentication property="name"/></h5>
                    </div>
                </div>              
                 
                 <!-- /. ROW  -->
                 <hr />
                 
                <div class="row">
                <!-- /. BEGIN  -->
                	<div class="col-md-12">
                    	<div class="panel panel-default">
                        	<div class="panel-heading">
                            	<spring:message code="home.announcement"/>
                        	</div>
                        	<div class="panel-body">
                        		<spring:message code="home.messages"/>
                        	</div>
                    	</div>
                    </div>
                 <!-- /. END  -->
            	</div>
            </div>
        </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    
    <script src="<c:url value='/resources/resources/js/jquery-1.10.2.js'/>"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="<c:url value='/resources/resources/js/bootstrap.min.js'/>"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="<c:url value='/resources/resources/js/jquery.metisMenu.js'/>"></script>
     <!-- MORRIS CHART SCRIPTS -->
     <script src="<c:url value='/resources/resources/js/morris/raphael-2.1.0.min.js'/>"></script>
    <script src="<c:url value='/resources/resources/js/morris/morris.js'/>"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value='/resources/resources/js/custom.js'/>"></script>
    
   
</body>
</html>
