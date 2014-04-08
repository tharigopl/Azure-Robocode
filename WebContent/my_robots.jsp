<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="includes/nocache.jsp"%>
<%@ include file="includes/logincheck.jsp"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/common_top.jsp"%>
<div id="page-wrapper">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">My Robots</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	        	<div class="panel-heading">
	                
	            </div>
	            <div class="panel-body">
	                <div class="row">
	                	<div id="msgdiv">
	                    <p>
		                <% if(msg_error.length() >0){ %>
		                <div align="center" class="errorMsg"><strong><%=msg_error%></strong></div>
		                <% } else if(msg_success_sess.length() >0) { %>
		                <div align="center" class="successMsg"><strong><%=msg_success_sess%></strong></div>
		                <% } %>
		                </p>
	                    </div>
	                    <div class="col-lg-12">
	                            <table class="table table-striped table-bordered table-hover" style="margin-bottom:0px;">
	                            <thead>
	                                <tr>
	                                <th>Robot Name</th>
	                                <th>Description</th>
	                                <th>Ranking</th>
	                                <th>Last Modified Date</th>
	                                <th>Last Modifed By</th>
	                                <th><img src="images/edit.png" width="20" height="20" /></th>
	        						<th><img src="images/delete.png" width="20" height="20" /></th>                                
	                              	</tr>
	                            </thead>
	                            <tbody>
	                              <tr>
	                                <td>Robo1</td>
	                                <td>my 1st robo</td>
	                                <td>3</td>
	                                <td>3/28/2014</td>
	                                <td>userabc</td>
	                                <th><img src="images/edit.png" width="20" height="20" /></th>
	        						<th><img src="images/delete.png" width="20" height="20" /></th>                                  
	                              </tr>
	                              <tr>
	                                <td>Robo2</td>
	                                <td>my 2nd robo</td>
	                                <td>2</td>
	                                <td>3/28/2014</td>
	                                <td><strong>&lt;me&gt;</strong></td>
	                                <th><img src="images/edit.png" width="20" height="20" /></th>
	        						<th><img src="images/delete.png" width="20" height="20" /></th>                                  
	                              </tr>
	                              <tr>
	                                <td>Robo3</td>
	                                <td>my 3rd robo</td>
	                                <td>1</td>
	                                <td>3/28/2014</td>
	                                <td>userxyz</td>
	                                <th><img src="images/edit.png" width="20" height="20" /></th>
	        						<th><img src="images/delete.png" width="20" height="20" /></th>                                  
	                              </tr>
	                              </tbody>
	                          </table> 
	                    </div>
	                    <!-- /.col-lg-12 (nested) -->
	                    
	                </div>
	                <!-- /.row (nested) -->
	            </div>
	            <!-- /.panel-body -->
	        </div>
	        <!-- /.panel -->
	    </div>
	    <!-- /.col-lg-12 -->
	</div>	
</div>
  <!-- /#page-wrapper -->
<%@ include file="includes/common_bottom.jsp"%>
<%@ include file="includes/footer.jsp"%>
