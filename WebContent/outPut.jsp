<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="estimate.rJava"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rJava</title>
</head>
<body>
	<%
	Double test = new rJava().test();
	//double output = 99;
	%>
	<div id="container">
		<div id="header">
			<h1>rJavaのテスト</h1>
		</div>
		<hr />
		<div id="contens">
			<div id="main">
				<!-- InstanceBeginEditable name="area" -->
				<%= test%><%--全ての項目を出題--%>
				<br></br>
				<!-- InstanceEndEditable -->
			</div>


		</div>
	</div>
</body>
</html>