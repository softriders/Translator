<Doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/test.js"/>"></script>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<!-- You can add  resources to page like above, .css and .js should be in resources folder -->
</head>
<title>PERA TRNSLATOR</title>
	<body>
	<center>
        <div id="header">
        <div id="header_left">
            <input type="button" id="menu" value="Menu"/>
            <input type="button" id="help" value="Help" />
            <input type="button" id="login" value="Login" />
            <input type="button" id="signup" value="Signup free" />
        </div>
        <div id="trns_title">Translator</div>
        
            
        		
	</center>
	<div id="content">
		
		
		<h3>${message}</h3>
		<div id="english">
			<h4>Enter English Sentence Here</h4>
			<textarea id="in" rows="5" cols="100"></textarea>
		</div>
			<br>
		<div id="sinhala">
			<h4>Sinhala Meaning</h4>
			<textarea id="out" rows="5" cols="100"></textarea>
		</div>
	
		<br><br>
		<button id="clear"> Clear</button> &nbsp;&nbsp;<button id="submit"> Convert</button>	
	</div>
	</body>
</html>
