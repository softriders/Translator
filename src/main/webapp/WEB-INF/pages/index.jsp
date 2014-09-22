<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>English to Sinhala</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
    <center>
        <div id="header">
        <div id="header_left">
            <input type="button" id="menu" value="Menu"/>
            <input type="button" id="help" value="Help" />
        </div>
        Translator
        <div style="float: right;" id="header_right" >
            <input type="button" id="login" value="Login" />
            <input type="button" id="signup" value="Signup free" />
        </div>
    </div>
    </center>
    <div id="content">
        <div id="english">
            <form >
            <br />
            <label for="english_part">English Sentence</label><br /><br />
            <textarea id="english_part"></textarea><br />
            <input type="reset" value="reset" id="reset"><br />
            <input type="button" value="Translate" id="translate" /><br />
        </form>
        </div>
        <br />
        <div id="sinhala">
            <label for="sinhala_part">Sinhala Meaning</label><br /><br />
            <textarea id="sinhala_part"></textarea><br />
            <input type="button" value="Copy" id="copy"/>
        </div>
    </div>
    
    <div id="footer">
        
    </div>
</body>
</html>
