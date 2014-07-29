<Doctype html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/test.js"/>"></script>
<!-- You can add  resources to page like above, .css and .js should be in resources folder -->
</head>
	<body>
		
		<h1>Translator</h1>
		
		<h3>Message is  : ${message}</h3>
		<h4>Input</h4>
		<textarea id="in" rows="5" cols="100"></textarea>
		<br>
		<h4>Output</h4>
		<textarea id="out" rows="5" cols="100"></textarea>
		<br><br>
		<button id="clear"> Clear</button> &nbsp;&nbsp;<button id="submit"> Convert</button>	
	</body>
</html>
