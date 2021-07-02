<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 보내기 양식</title>
</head>
<body>
	<form action="/mail/sendMail.do" method="post">
		<table border="1">
			<tr>
				<td>받는사람</td>
				<td><input type="text" name="toMail"></td>
			</tr>
			<tr>
				<td>메일제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>메일내용</td>
				<td><textarea cols="21"rows="3" name="contents"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="[메일전송]">
		<input type="button" value="[내용초기화]">
	</form>
</body>
</html>