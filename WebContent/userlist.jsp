<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>

<script type="text/javascript">
	//文档就绪函数
	$(function() {
		
		$.getJSON("userListServlet",function(data){
			for (var i = 0; i < data.userArray.length; i++) {
				$("#table").append(
					"<tr>"+
					"<td>"+data.userArray[i].user_id+"</td>"+
					"<td>"+data.userArray[i].user_name+"</td>"+
					"<td>"+data.userArray[i].user_phone+"</td>"+
					"<td>"+data.userArray[i].user_email+"</td>"+
					"<td><a href='#'>查看详情</a></td>"+
					"</tr>"
				);
			}
			alert(data.userArray[0].user_name);
		});
		
		
	});
	
</script>

<table id="table">
	<tr>
		<td>ID</td>
		<td>用户名</td>
		<td>手机</td>
		<td>邮箱</td>
		<td>操作</td>
	</tr>
</table>

</body>
</html>