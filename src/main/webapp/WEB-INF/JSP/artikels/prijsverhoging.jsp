<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
	<v:head title='Prijsverhoging'/>
</head>
<body>
	<v:menu/>
	<h1>Prijsverhoging</h1>
	<form method="post" id="prijsverhogingform">
		<label>
			Percentage:<span>${fouten.percentage}</span>
			<input name="percentage" value="${param.percentage}" type="number"
				min='0.01' step='0.01' autofocus>
		</label>
		<input type="submit" value="Prijsverhoging" id="prijsverhogingknop">
	</form>
	<script type="text/javascript">
		document.getElementById('prijsverhogingform').onsubmit = function() {
			document.getElementById('prijdverhogingknop').disabled = true;
		};
	</script>
</body>
</html>