<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script type="text/javascript">
	function doRegUserCheck() {
		const option = {
		  method: 'POST',
		  url: 'https://jsonplaceholder.typicode.com/posts',
		  headers: {
		    'Content-type': 'application/json; charset=UTF-8',
		  },
		  data: JSON.stringify({
		    title: 'foo',
		    body: 'bar',
		    userId: 1,
		  }),
		}
		axios(option)
		.then((response) => console.log(response.data))
		.catch((error) => console.log(error));
	}
</script>
</head>
<body>
		<h1>회원가입 화면</h1>
		<br />
		<br />
		<form name="f" method="post">
				<table border="1">
						<col width="150px">
						<col width="150px">
						<col width="150px">
						<col width="150px">
						<tr>
								<td>아이디</td>
								<td><input type="text" name="name"></td>
								<td>이름</td>
								<td><input type="text" name="age" style="width: 150px;" /></td>
						</tr>
						<tr>
								<td>주소</td>
								<td colspan="3"><input type="text" name="address" style="width: 450px" /></td>
						</tr>
				</table>
				<input type="button" onclick="doRegUserCheck()" value="회원가입" />
		</form>
		<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</body>
</html>