<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v' %>
<!doctype html>
<html lang='nl'>
<head>
 	<v:head title='Artikels per artikel groep'/>
</head>
<body>
	<v:menu/>
	<h1>Artikels per artikel groep</h1>
	<ul class='zonderbolletjes'>
		<c:forEach items="${artikelgroepen}" var="artikelgroep">
			<c:url value='' var='artikelgroepURL'>
				<c:param name="id" value="${artikelgroep.id}"/>
			</c:url>
			<li><a href="${artikelgroepURL}">${artikelgroep.naam}</a></li>
		</c:forEach>
	</ul>
	<c:if test="${not empty artikelgroepen}">
		<h2>${artikelgroep.naam}</h2>
		<c:forEach items="${artikelgroep.artikel}" var="artikel">
			<dt>${artikel.id}</dt>
			<dd>${artikel.naam}</dd>
			<dd>&euro; <fmt:formatNumber value="${artikel.verkoopprijs}"
				maxFractionDigits="2" minFractionDigits="2"/></dd>
		</c:forEach>
	</c:if>
</body>
</html>