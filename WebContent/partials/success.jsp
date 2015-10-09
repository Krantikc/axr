<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script src="libs/jquery-1.11.2.min.js"></script>
<script>
$(document).ready(function(){
	var url = window.location.href;
	//url = url.substr(0, url.lastIndexOf('/') + 1) + '#/products';
	//var rurl = "${redirectUrl}";
	var redirectUrl = url.substr(0, url.lastIndexOf('/') + 1) + '#' + "${redirectUrl}";
	window.location.replace(redirectUrl);
});
</script>
<div>
	<div id="about-description">
	<div id="redirect-url" style="display:none">${redirectUrl}</div>
Success
	</div>
</div>
