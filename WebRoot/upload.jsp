<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>   
    <title>文件上传</title>   
  </head> 
  <body>
    <form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <table border="1" width="310px">
    	<tr><th colspan="2">选择上传的文件</th></tr>
    	<tbody>
    	<tr><td><input type="file" name="img"><input type="button" value="删除" onclick="delitem(this)"></td></tr>
    	</tbody>
    	<tr><td><input type="button" value="添加" onclick="additem()"></td></tr>
    	<tr><td><input type="submit" value="上传"></td></tr>
    </table> 
    </form>
  </body>
  
  <script type="text/javascript">
  
  	function additem(){
  		var tr=document.createElement("tr");
  		var td=document.createElement("td");
  		var file=document.createElement("input");
  		var but=document.createElement("input");
  		file.setAttribute("type", "file");
  		file.setAttribute("name", "img");
  		but.type="button";
  		but.setAttribute("value", "删除");
  		but.setAttribute("onclick", "delitem(this)");
  		td.appendChild(file);
  		td.appendChild(but);
  		tr.appendChild(td);
  		var tbody=document.getElementsByTagName("tbody")[1];
  		tbody.appendChild(tr);
  	} 
  	function delitem(del){
  		var tr=del.parentNode.parentNode;
  		var tbody=document.getElementsByTagName("tbody")[1];
  		tbody.removeChild(tr);
  	}
  	function check(){
  		var list=document.getElementsByName("img");
  		for(var i=0;i<list.length;i++){
  			if(list[i].value==null||list[i].value==""){
  			 	alert("第"+(i+1)+"号位置没有选择文件");
  			 	return false;
  			} 		
  		}
  		return true;	
  	}
  	
  </script>
</html>
