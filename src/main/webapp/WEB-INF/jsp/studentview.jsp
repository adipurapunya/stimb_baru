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
                            Student Config
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">Student List</a>
                                </li>
                                <li class=""><a href="#profile" data-toggle="tab">Add New Student</a>
                                </li>
                                <li class=""><a href="#messages" data-toggle="tab">Photo Student</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                
                                <div class="tab-pane fade active in" id="home">
                                	<div class="panel-body">	
                                		<div class="table-responsive">
                                			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    		<thead>
                                        	<tr>
	                                            <th><spring:message code="student.nim"/></th>
	                                            <th><spring:message code="student.prodi"/></th>
	                                            <th><spring:message code="student.fullname"/></th>
	                                            <th><spring:message code="student.mayor"/></th>
	                                            <th><spring:message code="student.yearLevelLabel"/></th>
	                                            <th><spring:message code="student.action"/></th>
                                        	</tr>
                                    		</thead>
                                    		<tbody>
                                    		<c:forEach items="${studentList}" var="student">
												<tr class="odd gradeA">
													<td>${student.nim}</td>
													<td>${student.prodiName}</td>
													<td>${student.studentDetail.firstname} ${student.studentDetail.midlename} ${student.studentDetail.lastname}</td>
													<td class="center">${student.fieldOfStudy.nameField}</td>
													<td class="center">${student.yearLevel}</td>
													<td class="center">
														<!-- <a href="#" style="color:black"><span class="glyphicon glyphicon-open"></span></a> -->
										  				<a href="updateStudent.do?id=${student.id}" style="color:black"><span class="glyphicon glyphicon-edit"></span></a>
										  				<a href="javascript:deleteContact('deleteContact.do?id=${student.id}');" style="color:black"><span class="glyphicon glyphicon-remove"></span></a>
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
						        <form:form class="form-horizontal" action="student.do" method="POST" commandName="student">
                                	
						        		<div class="">
                    						<div class="panel panel-default">
                        						
                        						<div class="panel-body">
						                            <ul class="nav nav-tabs">
						                                <li class="active"><a href="#basic" data-toggle="tab">Basic</a></li>
						                                <li class=""><a href="#detail" data-toggle="tab">Detail Student</a></li>
						                                <li class=""><a href="#address" data-toggle="tab">Address KTP</a></li>
						                                <li class=""><a href="#currentaddress" data-toggle="tab">Current Address</a></li>
						                                <li class=""><a href="#parents" data-toggle="tab">Parents</a></li>
						                                <li class=""><a href="#stepparents" data-toggle="tab">Step Parents</a></li>
						                                <li class=""><a href="#education" data-toggle="tab">Education</a></li>
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
							                            						
							                            						<form:hidden path="user.username" />
																				<form:hidden path="user.password" /> 
																				<form:hidden path="user.status" />
							                            						
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="nim">NPM</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="nim" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="jurusan">Mayor</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> 
																						<form:select path="fieldStudy" class="form-control"> 	
																							<c:forEach items="${fieldStudyList}" var="field">
																								<form:option value="${field.id}">${field.nameField}</form:option>
																							</c:forEach>
																						</form:select></div>
																						</div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="jurusan">Mayor 2</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> 
																						<form:select path="fieldOfStudy.id" class="form-control"> 	
																							<c:forEach items="${fieldStudyList}" var="field">
																								<form:option value="${field.id}">${field.nameField}</form:option>
																							</c:forEach>
																						</form:select></div>
																						</div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearLevel">Tahun Angkatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> 
																						<form:select path="yearLevel" class="form-control"> 	
																							<c:forEach items="${academicYearList}" var="year">
																								<form:option value="${year.levelAcademic}" />
																							</c:forEach>
																						</form:select></div>
																						</div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="btsstudi">Batas Studi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="limitStudy" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="prodi">Prodi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="prodiName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="statusmasuk">Status Masuk</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="statusEntry" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			</table>
                            												</div>
                    													</div>
                    												</div>
                                							</div>
                                						</div>
                                						
                                						<!-- next one -->
                                						
                                						<div class="tab-pane fade" id="detail">
                                							<div class="panel-body">	
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Detail Student</div> -->
                        												<div class="panel-body">
                        													<table class="col-md-12">	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="noktp">No KTP/e-KTP</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.ktpNumber" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="namadepan">Nama Depan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.firstname" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="namaawal">Nama Tengah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.midlename" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="namaakhir">Nama Akhir</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.lastname" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="namapanggilan">Nama Panggilan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.nickname" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																	
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="tempatlahir">Tempat Lahir</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.placeBirth" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="tanggallahir">Tanggal Lahir</label></td><td>&nbsp;&nbsp;</td>
																						<td>
																						<div class="input-group date form_date col-md-12" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="dd-mm-yyyy">
																							<form:input path="studentDetail.dateBirth" class="form-control"/>
																							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																						</div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Detail Student</div> -->
                        												<div class="panel-body">
                        													<table class="col-md-12">
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="jeniskelamin">Jenis Kelamin</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:select path="studentDetail.sex" class="form-control"> <form:option value="Laki-Laki"></form:option><form:option value="Perempuan"></form:option></form:select></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="agama">Agama</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> 
																						<form:select path="studentDetail.religion" class="form-control"> 
																							<form:option value="Kristen" />
																							<form:option value="Katholik" />
																							<form:option value="Protestan" />
																							<form:option value="Islam" />
																							<form:option value="Hindu" />
																							<form:option value="Budha" />
																							<form:option value="Atheis" />
																							<form:option value="Konghunchu" />
																							<form:option value="Tidak Jelas" />
																						</form:select></div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="nationality">Kewarganegaraan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.nationality" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="statusnikah">Status Nikah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls">
																						<form:select path="studentDetail.maritalstatus" class="form-control"> 
																							<form:option value="Single" />
																							<form:option value="Married" />
																							<form:option value="Widow" />
																							<form:option value="Widower" />
																							<form:option value="Divorce" />
																							<form:option value="In Relationship" />
																							<form:option value="Complicated" />
																						</form:select></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="email">E-Mail</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.email" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="telepon">No Telepon</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="studentDetail.mobilePhone" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											
                                							</div>
                                						</div>
                                						
                                						<!-- next two -->
                                						
                                						<div class="tab-pane fade" id="address">
                                							<div class="panel-body">	
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Address KTP</div>-->
                        												<div class="panel-body">
							                            					<table class="col-md-12">	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="alamat">Alamat</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.street" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="rt">RT</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.rt" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="rw">RW</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.rw" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="kelurahan">Kelurahan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.subdistrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="kecamatan">Kecamatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.disctrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Address KTP</div>-->
                        												<div class="panel-body">
							                            					<table class="col-md-12">
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="kotakab">Kota/Kab</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.city" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="propinsi">Propinsi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.province" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="kodepos">Kode Pos</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.postalcode" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="teleponrumah">Telepon Rumah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="cardAddress.homephone" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            					</table>
                            											</div>
                    												</div>
                    											</div>
                                							</div>
                                						</div>
                                						
                                						<!-- next three -->
                                						
                                						<div class="tab-pane fade" id="currentaddress">
                                							<div class="panel-body">	
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading"> Current Address </div> -->
                        												<div class="panel-body">
							                            					<table class="col-md-12">	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="calamat">Alamat</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.street" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="crt">RT</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.rt" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
													
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="crw">RW</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.rw" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ckelurahan">Kelurahan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.subdistrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ckecamatan">Kecamatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.disctrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading"> Current Address </div> -->
                        												<div class="panel-body">
                        													<table class="col-md-12">
                        														<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ckotakab">Kota/Kab</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.city" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="cpropinsi">Propinsi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.province" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ckodepos">Kode Pos</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.postalcode" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="cteleponrumah">Telepon Rumah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="currentAddress.homephone" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
                        													</table>
                        												</div>
                        											</div>
                        										</div>
                        										
                                							</div>
                                						</div>
                                						
                                						<!-- next four -->
                                						
                                						<div class="tab-pane fade" id="education">
                                							<div class="panel-body">
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<div class="panel-body">
							                            					<table class="col-md-12">			
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="kindergarten">Kindergarten</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.kindergarten" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            						
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="addressKindergarten">City Kindergarten</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.addressKindergarten" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearGraduatedKindergarten">Year Certificate Kindergarten</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.yearGraduatedKindergarten" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="elementaryschool">Elementary School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.elementarySchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="addressElementarySchool">City Elementary School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.addressElementarySchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearGraduatedElementarySchool">Year Certificate Elementary School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.yearGraduatedElementarySchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="juniorHighSchool">Junior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.juniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="addressJuniorHighSchool">City Junior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.addressJuniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearGraduatedJuniorHighSchool">Year Certificate Junior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.yearGraduatedJuniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			</table>	
                            											</div>
                    												</div>
                    											</div>
                    											
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<div class="panel-body">
							                            					<table class="col-md-12">
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="seniorHighSchool">Senior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.seniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="FieldStudySeniorHighSchool">Field Study Senior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.FieldStudySeniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="addressSeniorHighSchool">City Senior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.addressSeniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearGraduatedSeniorHighSchool">Year Certificate Graduated Senior High School</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.yearGraduatedSeniorHighSchool" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="universityName">University</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.universityName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="FieldStudyUniversity">Field Study in University</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.FieldStudyUniversity" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="addressUniversity">City of University</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.addressUniversity" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="yearGraduatedUniversity">Year Certificate Graduated University</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="historyEducation.yearGraduatedUniversity" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            					</table>
                            											</div>
                    												</div>
                    											</div>
                                							</div>
                                						</div>
                                						
                                						<!-- next five -->
                                						
                                						<div class="tab-pane fade" id="parents">
                                							<div class="panel-body">	
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Parents</div> -->
                        												<div class="panel-body">
							                            					<table class="col-md-12">	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="fatherName">Nama Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.fatherName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="fatherStatus">Status Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.fatherStatus" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            						
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="motherName">Nama Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.motherName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="motherStatus">Status Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.motherStatus" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																																		
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="placeBirthFather">Tempat Lahir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.placeBirthFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="dateBirthFather">Tanggal Lahir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td>
																						<div class="input-group date form_date col-md-12" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="dd-mm-yyyy">
																							<form:input path="parentStudent.dateBirthFather" class="form-control"/>
																							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																						</div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="placeBirthMother">Tempat Lahir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.placeBirthMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="dateBirthMother">Tanggal Lahir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td>
																						<div class="input-group date form_date col-md-12" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="dd-mm-yyyy">
																							<form:input path="parentStudent.dateBirthMother" class="form-control"/>
																							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																						</div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="occupacyFather">Pekerjaan Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.occupacyFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="salaryFather">Penghasilan Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.salaryFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="occupacyMother">Pekerjaan Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.occupacyMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="salaryMother">Penghasilan Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.salaryMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="lastEducationFather">Pendidikan Terakhir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.lastEducationFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="lastEducationMother">Pendidikan Terakhir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.lastEducationMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Parents</div> -->
                        												<div class="panel-body">
							                            					<table class="col-md-12">
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="address">Alamat</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.address" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="rt">RT</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.rt" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="rw">RW</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.rw" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="subdisctrict">Kelurahan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.subdistrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="disctrict">Kecamatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.disctrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="city">Kota/Kab</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.city" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="province">Propinsi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.province" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="postalcode">Kode Pos</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.postalcode" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="religion">Agama</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.religion" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="mobilePhone1">Telepon Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.mobilePhone1" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="mobilePhone2">Telepon Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.mobilePhone2" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="email">E-Mail Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.email" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="email2">E-Mail Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="parentStudent.email2" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            					</table>
                            											</div>
                    												</div>
                    											</div>
                                							</div>
                                						</div>
                                						
                                						<!-- next six -->
                                						
                                						
                                						<div class="tab-pane fade" id="stepparents">
                                							<div class="panel-body">	
                                								<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Parents</div> -->
                        												<div class="panel-body">
							                            					<table class="col-md-12">	
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sfatherName">Nama Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.fatherName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sfatherStatus">Status Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.fatherStatus" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
							                            						
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="smotherName">Nama Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.motherName" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="smotherStatus">Status Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.motherStatus" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																																		
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="splaceBirthFather">Tempat Lahir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.placeBirthFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sdateBirthFather">Tanggal Lahir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td>
																						<div class="input-group date form_date col-md-12" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="dd-mm-yyyy">
																							<form:input path="stepParentStudent.dateBirthFather" class="form-control"/>
																							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																						</div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="splaceBirthMother">Tempat Lahir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.placeBirthMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sdateBirthMother">Tanggal Lahir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td>
																						<div class="input-group date form_date col-md-12" data-date="" data-date-format="dd-mm-yyyy" data-link-field="dtp_input2" data-link-format="dd-mm-yyyy">
																							<form:input path="stepParentStudent.dateBirthMother" class="form-control"/>
																							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
																						</div>
																						</td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="soccupacyFather">Pekerjaan Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.occupacyFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ssalaryFather">Penghasilan Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.salaryFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="soccupacyMother">Pekerjaan Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.occupacyMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ssalaryMother">Penghasilan Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.salaryMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="slastEducationFather">Pendidikan Terakhir Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.lastEducationFather" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="slastEducationMother">Pendidikan Terakhir Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.lastEducationMother" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																			
																			</table>
                            											</div>
                    												</div>
                    											</div>
                    											
                    											<div class="col-md-6 col-sm-6">
                    												<div class="panel panel-info">
                        												<!-- <div class="panel-heading">Parents</div> -->
                        												<div class="panel-body">
							                            					<table class="col-md-12">
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="saddress">Alamat</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.address" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="srt">RT</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.rt" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="srw">RW</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.rw" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="ssubdisctrict">Kelurahan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.subdistrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sdisctrict">Kecamatan</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.disctrict" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="scity">Kota/Kab</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.city" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sprovince">Propinsi</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.province" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="spostalcode">Kode Pos</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.postalcode" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
							                            						<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="sreligion">Agama</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.religion" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="smobilePhone1">Telepon Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.mobilePhone1" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="smobilePhone2">Telepon Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.mobilePhone2" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="semail">E-Mail Ayah</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.email" class="form-control"/></div></td>
																					</tr><tr><td>&nbsp;&nbsp;</td></tr>
																				</div>
																				
																				<div class="control-group">
																					<tr>
																						<td align="right"><label class="control-label" for="semail2">E-Mail Ibu</label></td><td>&nbsp;&nbsp;</td>
																						<td><div class="controls"> <form:input path="stepParentStudent.email2" class="form-control"/></div></td>
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
                                
                                <div class="tab-pane fade" id="messages">
                                    <h4>Messages Tab</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
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
