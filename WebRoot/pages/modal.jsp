<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

	<!-- 添加IP白名单的模态框 -->   	
		<div class="modal fade" id="add_whiteip_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加IP白名单</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addWhiteIpForm">					 
					  <table width="100%" cellpadding="0" cellspacing="0" class="post_table">		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >IP：</label></td>
				            <td>
				            <div class=all_input>						  
						    <input id="whiteip1" name=whiteip1 class=ip_input maxlength=3
							onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(whiteip1,whiteip1,whiteip2)>.<input
							     id="whiteip2" name=whiteip2 class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
							onkeyup=keyUpEvent(whiteip1,whiteip2,whiteip3)>.<input
							    id="whiteip3" name=whiteip3 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEvent(whiteip2,whiteip3,whiteip4)>.<input
							    id="whiteip4" name=whiteip4 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
							 onkeyup=keyUpEventForIp4(whiteip3,whiteip4)>
						    <input name = whiteipvalue TYPE="hidden">						
						  	</div><label></label>
				            <em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >备注：</label></td>
		      				<td><input id="whiteipremark" type="text" class="input2" name="whiteipremark"/></td>
		      			</tr>
		      		<!-- 	<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;">是否运行：</label></td>
		      				<td><input id="ifrunning" type="text" class="input2" style="width:100px" name="ifrunning" maxlength="30" /></td>
		      			</tr> -->
		      						      		
					   </table>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		<!-- 添加域名白名单的模态框 -->   	
		<div class="modal fade" id="add_whitedomain_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加域名白名单</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addWhiteDomainForm">					 
					  <table width="100%" cellpadding="0" cellspacing="0" class="post_table">		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >域名：</label></td>
				         	<td><input id="whitedomain" type="text" class="input2" name="whitedomain" /><em style="color:red">*</em></td>		      		
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >备注：</label></td>
		      				<td><input id="whitedomainremark" type="text" class="input2" name="whitedomainremark"/></td>
		      			</tr>		      			      						      		
					   </table>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
			<!-- 添加蜜罐的模态框 -->   	
		<div class="modal fade" id="add_pot_modal">
		  <div class="modal-dialog" >
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h2 class="modal-title" style="font-weight:bold;font-family:幼圆">添加蜜罐</h2>
		      </div>
		      <div class="modal-body">
				   <form id="addPotForm">
						  <div class=all_input>						  
						    <input id="potip1" name=potip1 class=ip_input maxlength=3
						onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(potip1,potip1,potip2)>.<input
						    id="potip2" name=potip2 class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						onkeyup=keyUpEvent(potip1,potip2,potip3)>.<input
						    id="potip3" name=potip3 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(potip2,potip3,potip4)>.<input
						    id="potip4" name=potip4 class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(potip3,potip4)>
						    <input id="potipvalue" name = potipvalue TYPE="hidden">
						
						  </div>
						  <label></label>
					   <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					        <button type="submit" class="btn btn-primary" >保存</button>
					   </div>
					</form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
		
		<!-- 注册模态框 -->   	
		<div class="modal fade" id="register_modal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		        <h4 class="modal-title" style="font-weight:bold;font-family:幼圆">添加用户</h4>
		      </div>
		      <div class="modal-body">
		     	 <form id="registerForm" action="register.action" method="post" style="margin-top:-10px;"> 
		     	 	<table width="100%" cellpadding="0" cellspacing="0" class="post_table" >
		      		
		      			<tr>
		      				<td><label width="30%" align="right"style="font-weight:bold;font-family:黑体;font-size:20px;" >用户名：</label></td>
				            <td><input id="username" type="text" class="input2" name="username"/><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >密码：</label></td>
		      				<td><input id="reg_password" type="password" class="input2" name="reg_password" /><em style="color:red">*</em></td>
		      			</tr>
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;" >密码确认：</label></td>
		      				<td><input id="conpassword" type="password" class="input2" name="conpassword"/><em style="color:red">*</em></td>
		      			</tr>
		      			<!--
		      			<tr>
		      				<td><label align="right" style="font-weight:bold;font-family:黑体;font-size:20px;">角色：</label></td>
		      				<td>
      							<select id="role" name="role">		                  
			                	</select>
		      					<em style="color:red">*</em>
		      				</td>
		      			</tr> 
		      			 -->		    				
				   </table>
				   <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				        <button type="submit" class="btn btn-primary"  >提交</button>
				   </div>
				 </form> 
		      </div>
		     
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
<script type="text/javascript">
$().ready(function(){
	$('#add_whitedomain_modal').on('hide.bs.modal', function () {
	    $(this).removeData("bs.modal");
	 });
	
});

</script>