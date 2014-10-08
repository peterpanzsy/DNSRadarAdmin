<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

<h2>License管理</h2>
<div>
   	<form id="updateLicenseForm" action="updateLicense.action" method="post"> 
  	 	<table cellpadding="0" cellspacing="0" class="gridtable">	
   			<tr>
   				<td style="width:20%"><label>上传序列号：</label></td>
   				<td align="center"><input id=licenseStr type="text"  class="span3" style="width:200px"  name="licenseStr" />
   				<input name = licenseID id="licenseID" TYPE="hidden" value="">
   				<em style="color:red">*</em></td>
   			</tr>	
   			<tr>
   				<td style="width:20%"><label>到期时间：</label></td>
   				<td align="center"><input  disabled=true id=licenseDate class="span3" style="width:200px"  name="licenseDate"/></td>
   			</tr>	
   			<tr>
   				<td style="width:20%"><label>状态：</label></td>
   				<td align="center"><input  disabled=true id=isvalid class="span3" style="width:200px"  name="isvalid"/></td>
   			</tr>	      					      		
		</table>
   		<div class="modal-footer">
       		<button type="submit" class="btn btn-primary"  >保存</button>
   		</div>
	</form> 
</div>