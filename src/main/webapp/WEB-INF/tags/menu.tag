<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="#">Artikels</a>
			<ul>
				<li><a href="<c:url value='/artikels/zoekenopnummer.htm'/>">Zoeken op nummer</a></li>
				<li><a href="<c:url value='/artikels/toevoegen.htm'/>">Toevoegen</a></li>
				<li><a href='<c:url value='/artikels/zoekenopnaam.htm'/>'>Zoeken op naam</a></li>
				<li><a href="<c:url value='/artikels/prijsverhoging.htm'/>">Prijs verhoging</a></li>
				<li><a href="<c:url value='/artikels/kortingen.htm'/>">Kortingen</a></li>
				<li><a href="<c:url value='/artikels/perartikelgroep.htm'/>">Per artikel groep</a></li>
				<li><a href="<c:url value='/artikels.htm'/>">Artikellijst</a></li>
			</ul>
		</li>
	</ul>
</nav>
