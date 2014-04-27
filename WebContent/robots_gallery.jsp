<%@page import="com.utd.robocode.dto.AccessControl"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="includes/nocache.jsp"%>
<%@ include file="includes/logincheck.jsp"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/common_top.jsp"%>
<% 
List<AccessControl> AccDom1 = null;
List<AccessControl> AccDom2 = null;
AccDom1=(List<AccessControl>) request.getAttribute("Dom1"); 
AccDom2=(List<AccessControl>) request.getAttribute("Dom2");
%>
<div id="page-wrapper">
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">Robots Gallery</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                Cross Domain List of Robots
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
	                        <fieldset class="fieldset_custom">
	                        <% if(AccDom1!=null)
	                        	{%>
	                          <legend class="fieldset_custom">Domain-1</legend>
	                            <table class="table table-striped table-bordered table-hover" style="margin-bottom:0px;">
	                              <thead>
	                                <tr>
	                                  <th>Robot Name</th>
	                                  <th><img src="images/view.png" width="20" height="20" /></th>
	        						  <th><img src="images/edit.png" width="20" height="20" /></th>
	        						  <th><img src="images/delete.png" width="20" height="20"/></th>
	                                </tr>
	                              </thead>
	                              <tbody>
	                              <%
	                              int i;
	                              for(i=0;i<AccDom1.size();i++)
	                              {
	                            	  AccessControl a = new AccessControl();
	                            	  a=AccDom1.get(i);
	                            	  int acc = a.getaccess();
	                            	  boolean view = false;
	                            	  boolean edit=false;
	                            	  boolean delete = false;
	                            	  switch(acc)
	                            	  {	                            	  
	                            		  case 1: view= true;
	                            		  break;
	                            		  case 2: view = true;
	                            		  edit=true;
	                            		  break;
	                            		  case 3: view = true;
	                            		  edit = true;
	                            		  delete = true;
	                            		  break;
	                            	  }
	                              %>
	                                <tr>
	                                  <td><% out.println(a.getrobot_name()); %></td>
	                                  <th><%if(view){ %><img src="images/view.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	        						  <th><%if(edit){ %><img src="images/edit.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	        						  <th><%if(delete){ %><img src="images/delete.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	                                </tr>
	                               <%} %>
	                              </tbody>
	                            </table>
	                        </fieldset>
	                        <br/>
	                        <%
	                        	}
	                        if(AccDom2!=null)
	                        {
	                        	
	                        %>
	                      <fieldset class="fieldset_custom">
	                        <legend class="fieldset_custom">Domain-2</legend>
	                            <table class="table table-striped table-bordered table-hover" style="margin-bottom:0px;">
	                              <thead>
	                                <tr>
	                                  <th>Robot Name</th>
	                                  <th><img src="images/view.png" width="20" height="20" /></th>
	        						  <th><img src="images/edit.png" width="20" height="20" /></th>
	        						  <th><img src="images/delete.png" width="20" height="20"/></th>
	                                </tr>
	                              </thead>
	                              <tbody>
	                              <%
	                              int i;
	                              for(i=0;i<AccDom2.size();i++)
	                              {
	                            	  AccessControl a = new AccessControl();
	                            	  a=AccDom2.get(i);
	                            	  int acc = a.getaccess();
	                            	  boolean view = false;
	                            	  boolean edit=false;
	                            	  boolean delete = false;
	                            	  switch(acc)
	                            	  {	                            	  
	                            		  case 1: view= true;
	                            		  break;
	                            		  case 2: view = true;
	                            		  edit=true;
	                            		  break;
	                            		  case 3: view = true;
	                            		  edit = true;
	                            		  delete = true;
	                            		  break;
	                            	  }
	                              %>
	                                  <tr>
	                                  <td><% out.println(a.getrobot_name()); %></td>
	                                  <th><%if(view){ %><img src="images/view.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	        						  <th><%if(edit){ %><img src="images/edit.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	        						  <th><%if(delete){ %><img src="images/delete.png" width="20" height="20" />
	                                  <%} else { %> <img src="images/disabled.png" width="20" height="20" /><%} %> </th>
	                                </tr>
	                               <%} %>
	                              </tbody>
	                            </table>
	                            <% } %>
	                        </fieldset>
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
