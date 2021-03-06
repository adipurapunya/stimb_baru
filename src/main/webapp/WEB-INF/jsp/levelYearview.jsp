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
    <link href="<c:url value='/resources/resources/css/bootstrap.min.css'/>" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="<c:url value='/resources/resources/css/font-awesome.css'/>" rel="stylesheet" />
     <!-- DATE TIME LIB-->
    <link href="<c:url value='/resources/resources/css/bootstrap-datetimepicker.min.css'/>" rel="stylesheet" media="screen" />
        <!-- CUSTOM STYLES-->
    <link href="<c:url value='/resources/resources/css/custom.css'/>" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <!-- TABLE STYLES-->
   <link href="<c:url value='/resources/resources/js/dataTables/dataTables.bootstrap.css'/>" rel="stylesheet" />
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
                                <a href="#"><spring:message code="home.masterdatafieldstudy"/></a>
                            </li>
                            <li>
                                <a href="${context}/levelyear"><spring:message code="home.levelyear"/></a>
                            </li>
                            <li>
                                <a href="/levelyear"><spring:message code="home.levelyear"/></a>
                            </li>
                            <li>
                                <a href="#"><spring:message code="home.peopledata"/><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#"><spring:message code="home.lecturedata"/></a>
                                    </li>
                                    <li>
                                        <a href="#"><spring:message code="home.studentdata"/></a>
                                    </li>
                                    <li>
                                        <a href="#"><spring:message code="home.employeedata"/></a>
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
                     <h2><spring:message code="student.title"/></h2>   
                        <!-- <h5><spring:message code="home.greetings"/> <sec:authentication property="name"/></h5> -->
                    </div>
                </div>              
                 
                 <!-- /. ROW  -->
                 <hr />
                 
                <div class="row">
                <!-- /. BEGIN  -->
                
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Level Year Config
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">Level Year List</a>
                                </li>
                                <li class=""><a href="#profile" data-toggle="tab">Add Level Year</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                
                                <div class="tab-pane fade active in" id="home">
                                	<div class="panel-body">	
                                		<div class="table-responsive">
                                			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    		<thead>
                                        	<tr>
	                                            <th><spring:message code="levelyear.id"/></th>
	                                            <th><spring:message code="levelyear.year"/></th>
	                                            <th><spring:message code="levelyear.description"/></th>
	                                            <th><spring:message code="levelyear.action"/></th>
                                        	</tr>
                                    		</thead>
                                    		<tbody>
                                    		<c:forEach items="${levelacademicyearList}" var="levelacademicyear">
												<tr class="odd gradeA">
													<td>${levelacademicyear.id}</td>
													<td>${levelacademicyear.levelAcademic}</td>
													<td>${levelacademicyear.description}</td>
													<td>
														<!-- <a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a> -->
										  				<a href="updatelevelyear.do?id=${levelacademicyear.id}" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
										  				<a href="javascript:deleteContact('deleteLevelYear.do?id=${levelacademicyear.id}');" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
									  				</td>	
												</tr>
											</c:forEach>
                                    		</tbody>
                                			</table>
                            			</div>
                            		</div>	
                           		</div>
                                
                                <div class="tab-pane fade" id="profile">
                                <sec:authorize access="hasRole('Admin')">
						        <form:form class="form-horizontal" action="levelyear.do" method="POST" commandName="levelacademicyear">
                                	
						        		<div class="">
                    						<div class="panel panel-default">
                        						
                        						<div class="panel-body">
						                            <ul class="nav nav-tabs">
						                                <li class="active"><a href="#basic" data-toggle="tab">Basic</a></li>
						                            </ul>

                            						<div class="tab-content">
                            						
                                						<div class="tab-pane fade active in" id="basic">
                                							<div class="panel-body">	
                                									
                                									<div class="col-md-12">
                    													<div class="panel panel-info">
                        													<div class="panel-heading">
                            													Basic Info
                        													</div>
                        													<div class="panel-body">
							                            					<table class="col-md-12">	
							                            	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="nim">ID</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="id" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="levelAcademic">Tahun Angkatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="levelAcademic" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="description">Deskripsi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="description" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																			</table>
                            												</div>
                    													</div>
                    												</div>
                                							</div>
                                						</div>
                                						
                                						
                                						
                                					</div>
                                				</div>
                                			
                                		</div>
                                	</div>
                                	<div class="modal-footer">
						        			<input type="submit" name="action" value="Add" class="btn btn-success"/>
						        			<button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Batal</button>
											<!--<button id="simpan-mahasiswa" class="btn btn-success">Simpan</button>-->
						      		</div>
						      	</form:form>
						      	</sec:authorize>
                                </div>
                     		</div>
						</div>      
                    </div>
                </div>
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
    
    <!-- DATA TABLE SCRIPTS -->
    <script src="<c:url value='/resources/resources/js/dataTables/jquery.dataTables.js'/>"></script>
    <script src="<c:url value='/resources/resources/js/dataTables/dataTables.bootstrap.js'/>"></script>
    
    <script src="<c:url value='/resources/resources/js/locales/bootstrap-datetimepicker.id.js'/>"></script>
    <script src="<c:url value='/resources/resources/js/bootstrap-datetimepicker.js'/>"></script>
    
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script> 
    
    <script type="text/javascript">
	 		$('.form_date').datetimepicker({
	        language:  'id',
	        weekStart: 1,
	        todayBtn:  1,
		  autoclose: 1,
		  todayHighlight: 1,
		  startView: 2,
		  minView: 2,
		  forceParse: 0
		    });
	</script>
    
    <script type="text/javascript">
    function go(url)
    {
    	window.location = url;
    }

    function newContact()
    {
    	window.location = "saveContact.do";
    }

    function deleteContact(url)
    {
    	var isOK = confirm("Are you sure to delete?");
    	if(isOK)
    	{
    		go(url);
    	}
    }
    </script>
      <!-- CUSTOM SCRIPTS -->
    <script src="<c:url value='/resources/resources/js/custom.js'/>"></script>
</body>
</html>
