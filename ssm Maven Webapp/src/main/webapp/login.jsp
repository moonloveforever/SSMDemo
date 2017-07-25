<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="登录页面">
	
	<jsp:include page="/head.jsp"></jsp:include>
  </head>
  
  <body>
	<div  align="center" style="margin: 100px 0;">
		<div class="easyui-panel" title="欢迎登录" style="width:100%;max-width:400px;padding:30px 60px; ">
			<form id="loginForm" method="post" action="user/login.do">
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="userId" id="userId" style="width:100%" data-options="label:'用户名:',required:true" />
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="password" id="password" type="password" style="width:100%" data-options="label:'密码:',required:true" />
				</div>
			</form>
			<div style="text-align:center;padding:5px 0">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="AddHandlingFeeToRefund()" style="width:80px">登录</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
			</div>
		</div>
	</div>
	<script>

	function AddHandlingFeeToRefund()
	        {
				var userId = $.trim($("#userId").val());
				var password = $.trim($("#password").val());
				if('' == userId ||null == userId) {
					alert("用户名不能为空！");
					return false;
				}
				if('' == password ||null == password) {
					alert("密码不能为空！");
					return false;
				}
	            var AjaxURL= "<%=basePath%>";    
	            $.post(AjaxURL+'user/login.do',{
	            	userId:userId,
	            	password:password
	            },function(data,status){
	            	if('success' == data.type) {
	            		window.location.href = AjaxURL + 'user/success'
	            	} else {
	            		alert("用户名密码错误！");
	            	}
	            })
	        }

		function submitForm(){
			$('#loginForm').form('submit');
		}
		function clearForm(){
			$('#loginForm').form('clear');
		}
	</script>
</body>
</html>
