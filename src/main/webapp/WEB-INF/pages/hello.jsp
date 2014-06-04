<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/resources/js/test.js"/>"></script>
<!-- You can add  resources to page like above, .css and .js should be in resources folder -->
</head>
<body>
	<h1>Translator</h1>

	<input type="text" name="txtEnglishSentence" value="" Type English
		Sentence Here"" style="width: 455px;" />
	<br>
	<br>
	<input type="submit" value="Submit" name="btnSubmit" />
	<br>
	<br>
	<input type="text" name="txtOutPut" value="" style=" width : 785px;" />

</body>
</html>
