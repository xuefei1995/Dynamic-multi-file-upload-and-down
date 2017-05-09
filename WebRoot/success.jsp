<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>   
    <title>上传目录</title>   
  </head>
  
  <body>
    <table border="1">
    <tr>
    <td>编号</td>
    <td>名称</td>
    <td>大小</td>
    <td>类型</td>
    <td>日期</td>
    </tr>
	<c:forEach items="${requestScope.filelist }" var="file"  varStatus="filestr">
    <tr>
    <td>${filestr.count }</td>
    <td>${file.name }</td>
    <td>${file.size }</td>
    <td>${file.type }</td>
    <td>${file.date }</td>
    </tr>    
 </c:forEach>
    </table>
  </body>
</html>
