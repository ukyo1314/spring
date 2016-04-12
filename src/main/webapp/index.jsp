<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
 String path = request.getContextPath();
 request.setAttribute("path",path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<body>  
<h2>START SPTING3.0! IN INDEX.JSP</h2>  
<a href="${path}/hello">"href=hello"</a>  
<a href="<%=path %>/hello">"href=hello"</a>  
</body>  
</html>  