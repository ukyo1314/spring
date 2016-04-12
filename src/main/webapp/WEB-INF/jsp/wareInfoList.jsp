<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<script type="text/javascript">
	function deleterWares() {
		//提交form
		document.itemsForm.action = "${pageContext.request.contextPath }/deleterWares";
		document.itemsForm.submit();
	}
	function wareInfoList() {
		//提交form
		document.itemsForm.action = "${pageContext.request.contextPath }/wareInfoList";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
	<form name="itemsForm" method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>商品名称：<input name="name" value="${name} " /> <%-- 商品类型：
<select name="itemtype">
	<c:forEach items="${itemtypes }" var="itemtype">
		<option value="${itemtype.key }">${itemtype.value }</option>		
	</c:forEach>
</select> --%>
				</td>
				<td><input type="button" value="查询" onclick="wareInfoList()" />
					<input type="button" value="批量删除" onclick="deleterWares()" /></td>
			</tr>
		</table>
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>选择</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${wareExtends }" var="ware">
				<tr>
					<td><input type="checkbox" name="ids" value="${ware.id}" /></td>
					<td>${ware.name }</td>
					<td>${ware.price }</td>
					<td><fmt:formatDate value="${ware.creationdate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${ware.detail }</td>
					<td><a
						href="${pageContext.request.contextPath }/editWareInfo/${ware.id}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>

</html>