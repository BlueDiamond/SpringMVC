<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<style type="text/css">
.textfieldClass {
	height: 5px;
	font-size: 5px;
	width:100;
}
</style>
</head>

<body>
	<div style="font-size: 10; height:20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add User to Database</div>

	<form:form method="post" action="addUserProfile">

		<table style="font-size: 5px; ">

			<tr>
				<td style="width:20%">Profile ID</td>
				<td ><input name="Profile_ID" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="name" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td><input name="sex" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Relationship Status</td>
				<td><input name="relationship_Status" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Lives in</td>
				<td><input name="lives_in" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Email ID</td>
				<td><input name="email_ID" class="textfieldClass" /></td>
			</tr>
			<tr>
				<td>Languages</td>
				<td><input name="languages" class="textfieldClass" /></td>
			</tr>

		</table>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="align: center; height:5px;">

	</form:form>

</body>

</html>