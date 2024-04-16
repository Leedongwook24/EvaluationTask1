<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
</head>
<body>

	<form action="edit" method="post">
		<table>
			<tr>
				<td><label for="janCode" style="color:red;"> JanCode</label></td>
				<td><input type="text" name="janCode" value="${janCode}" readonly  style="background-color:yellow;"/></td>
			</tr> 
			<tr>
				<td><label for="isbnCode" style="color:red;"> isbnCode</label></td>
				<td><input type="text" name="isbnCode" value="${isbnCode}" readonly style="background-color:yellow;" /></td>
			</tr>
			<tr>
				<td><label for="bookName"> bookName</label></td>
				<td><input type="text" name="bookName" value="${bookName}" /></td>
			</tr>
			<tr>
				<td><label for="bookKanaName"> bookKanaName </label></td>
				<td><input type="text" name="bookKanaName" value="${bookKanaName}"/></td>
			</tr>
			<tr>
				<td><label for="price"> price </label></td>
				<td><input type="number" name="price" value="${price}"/></td>
			</tr>
			<tr>
				<td><label for="issueDate"> issueDate </label></td>
				<td><input type="date" name="issueDate" value="${issueDate}"/></td>
			</tr>
			<tr>
				<td><label for="issueDate" style="color:red;"> createDateTime </label></td>
				<td><input type="datetime-local" name="createDateTime" value="${createDateTime}" readonly style="background-color:yellow;"/></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="編集"/></td>
			</tr>
		</table>
	</form>


</body>
</html>