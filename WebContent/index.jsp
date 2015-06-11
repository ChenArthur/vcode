<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/js/jquery-2.1.1.js"></script>
<link rel="stylesheet" href="jquery/css/style.css">
</head>
<script type="text/javascript">
	$(document).ready(function(){
		onmove();
	});
	
	function onmove(){
		var name = $("#name").val();
		var pwd = $("#pwd").val();
		alert("name:"+name+"--pwd:"+pwd);
	}
</script>
<body>
<div style="width:250px;height:100px;margin:300px auto">
        <form>
        	<table>
        		<tr>
        			<td><input required='' type='text' id="name" name="name" onchange="onmove()">
            		<label alt='请输入名称' placeholder='名称'></label></td>
        		</tr>
        		<tr>
        			<td><input required='' type='text' id="pwd" name="pwd" onchange="onmove()">
            		<label alt='请输入密码' placeholder='密码'></label></td>
        		</tr>
        	</table>
        </form>
    </div>
</body>
</html>