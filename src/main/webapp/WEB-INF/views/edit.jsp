<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
<link rel="stylesheet" type="text/css"
	href="/final_test/styles/style.css">
</head>
<body>

	<form action="edit" method="post">
		<table>
			<tr>
				<td colspan="2">入力</td>
			</tr>
			<tr>
				<td><label for="janCode" class="red"> JAN-Code</label></td>
				<td><input type="text" name="janCode" value="${janCode}"
					readonly class="yellow" /></td>
			</tr>
			<tr>
				<td><label for="isbnCode" class="red"> ISBN-Code</label></td>
				<td><input type="text" name="isbnCode" value="${isbnCode}"
					readonly class="yellow" /></td>
			</tr>
			<tr>
				<td><label for="bookName"> タイトル</label></td>
				<td><input type="text" name="bookName" value="${bookName}" /></td>
			</tr>
			<tr>
				<td><label for="bookKanaName"> カナ名 </label></td>
				<td><input type="text" name="bookKanaName"
					value="${bookKanaName}" /></td>
			</tr>
			<tr>
				<td><label for="price"> 値段 </label></td>
				<td><input type="number" name="price" value="${price}" />円</td>
			</tr>
			<tr>
				<td><label for="issueDate"> issueDate </label></td>
				<td><input type="date" name="issueDate" value="${issueDate}" /></td>
			</tr>
			<tr>
				<td><label for="issueDate" class="red"> createDateTime
				</label></td>
				<td><input type="datetime-local" name="createDateTime"
					value="${createDateTime}" class="yellow" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="編集" /></td>
			</tr>
			</form>
			<tr>
				<td colspan="2"><a href="Home"> 取り消し </a> </td>
			</tr>
		</table>
</body>
</html>