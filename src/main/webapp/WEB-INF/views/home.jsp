<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home & LIST</title>
<link rel="stylesheet" type="text/css" href="/final_test/styles/style.css">
</head>
<body>

	<table class="booktable">
	<tr>
	<th colspan="10"> 本一覧</th>
	</tr>
		<tr>
			<th>番号</th>
			<th>JAN-CD</th>
			<th>ISBN-CD</th>
			<th>タイトル</th>
			<th>カナ名</th>
			<th>値段（円）</th>
			<th>発行日</th>
			<th>登録日</th>
			<th>修正日</th>
			<th>編集</th>
		</tr>
		<%
		ArrayList<HashMap<String, String>> rows = (ArrayList<HashMap<String, String>>) request.getAttribute("rows");
		int i = 0;
		for (HashMap<String, String> columns : rows) {
		i = i + 1;
		%>
		<tr>
			<td><%=i%></td>
			<td><%=columns.get("janCode")%></td>
			<td><%=columns.get("isbnCode")%></td>
			<td><%=columns.get("bookName")%></td>
			<td><%=columns.get("bookKanaName")%></td>
			<td><%=columns.get("price")%></td>
			<td><%=columns.get("issueDate")%></td>
			<td><%=columns.get("createDateTime")%></td>
			<td>
				<%if(columns.get("updateDateTime")==null){%>
				   なし
			    <%} else {%>
			    <%= columns.get("updateDateTime")%>
			    <%}%>
			</td>
			<td class="edit_btn_box">
				<form action="Home" method="post" class="edit_btn" accept-charset="UTF-8">
					<input type="hidden" name="janCode"
						value="<%=columns.get("janCode")%>"> <input type="hidden"
						name="isbnCode" value="<%=columns.get("isbnCode")%>"> <input
						type="hidden" name="bookName" value="<%=columns.get("bookName")%>">
					<input type="hidden" name="bookKanaName"
						value="<%=columns.get("bookKanaName")%>"> <input
						type="hidden" name="price" value="<%=columns.get("price")%>">
					<input type="hidden" name="issueDate"
						value="<%=columns.get("issueDate")%>"> <input
						type="hidden" name="createDateTime"
						value="<%=columns.get("createDateTime")%>"> <input
						type="hidden" name="updateDateTime"
						value="<%=columns.get("updateDateTime")%>"> <input
						type="submit" value="編集">
				</form>
			</td>
		</tr>
		<%
			}
			%>
	</table>
</body>
</html>