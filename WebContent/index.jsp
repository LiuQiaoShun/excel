<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>导出excel</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/exportExcelServlet" method="post">
		<span id="table">
		<table>
		  <tr>
		    <td>姓名</td>
		    <td>年龄</td>
		    <td>爱好</td>
		    <td>地址</td>
		  </tr>
		  <c:forEach var="list" items="${list}">
		    <tr>
		      <td>${list.username}</td>
		      <td>${list.age}</td>
		      <td>${list.hobby}</td>
		      <td>${list.position}</td>
		    </tr>
		  </c:forEach>
		</table>
		</span>
		<input type="submit" name="Excel" value="导出表格" onclick="test()"/>
	    <input type="hidden" id="tableInfo" name="tableInfo" value=""/>
</form>
	<script type="text/javascript">
	    function test(){
	       document.getElementById("tableInfo").value=document.getElementById("table").innerHTML;
	    }
	</script>
</body>
</html>
