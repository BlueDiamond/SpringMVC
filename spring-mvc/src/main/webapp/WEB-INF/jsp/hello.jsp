<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
	<div style="font-size: 10;">End User List in Database</div>
	<form:form>
		<div style="font-size: 5;">
			<c:forEach items="${userProfileList}" var="profile" varStatus="status">
				<br> <span style="color:brown;">User Number: ${status.count}</span><br>
				Profile ID: ${profile.profile_ID}<br>
				Name: ${profile.name}<br>
				Sex: ${profile.sex}<br>
				Relationship Status: ${profile.relationship_Status}<br>
				Lives in: ${profile.lives_in}<br>
				Email ID: ${profile.email_ID}<br>
				Languages: ${profile.languages}<br>
				Created TS: ${profile.created_TS}<br>
				<br>
			</c:forEach>
		</div>
		<input type="button" value="Back to Home" onclick="history.back();" />
	</form:form>
</body>
</html>