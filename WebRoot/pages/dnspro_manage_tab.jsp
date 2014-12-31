<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

<h2>DNS探测应用配置</h2>
<form id="updateProbeConfForm"  method="post"> 
	<table cellpadding="0" cellspacing="0" class="gridtable">
   				<tr>
    				<td><label >本机IP：</label></td>
		            <td><div class=all_input>						  
					    <input name=localip1 id="localip1" class=ip_input maxlength=3 
					     onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(localip1,localip1,localip2)>.<input 
					     name=localip2 id="localip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						 onkeyup=keyUpEvent(localip1,localip2,localip3)>.<input name=localip3 id="localip3" class=ip_input maxlength=3 
						 onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(localip2,localip3,localip4)>.<input 
						 name=localip4 id="localip4" class=ip_input maxlength=3 
						 onkeydown=keyDownEvent(this) onkeyup=keyUpEventForIp4(localip3,localip4)>						
					  </div><input name = localipvalue id="localipvalue" TYPE="hidden"><input name = probeconfID id=probeconfID TYPE="hidden">
					</td>
   				</tr>
   				<tr>
    				<td><label >网关：</label></td>
		            <td><div class=all_input>						  
					    <input name=gatewayip1 id="gatewayip1" class=ip_input maxlength=3 
					    onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(gatewayip1,gatewayip1,gatewayip2)>.<input 
					    name=gatewayip2 id="gatewayip2" class=ip_input maxlength=3 
					    onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(gatewayip1,gatewayip2,gatewayip3)>.<input 
					    name=gatewayip3 id="gatewayip3" class=ip_input maxlength=3 
					    onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(gatewayip2,gatewayip3,gatewayip4)>.<input 
					    name=gatewayip4 id="gatewayip4" class=ip_input maxlength=3 
					    onkeydown=keyDownEvent(this) onkeyup=keyUpEventForIp4(gatewayip3,gatewayip4)>						
					  </div><input name = gatewayipvalue id="gatewayipvalue" TYPE="hidden">
					</td>
   				</tr>
   				<tr>
    				<td><label >权威DNS服务器：</label></td>
		            <td><div class=all_input>						  
					    <input name=localdnsip1 id="localdnsip1" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
					     onkeyup=keyUpEvent(localdnsip1,localdnsip1,localdnsip2)>.<input 
					     name=localdnsip2 id="localdnsip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						 onkeyup=keyUpEvent(localdnsip1,localdnsip2,localdnsip3)>.<input 
						 name=localdnsip3 id="localdnsip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(localdnsip2,localdnsip3,localdnsip4)>.<input 
						 name=localdnsip4 id="localdnsip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(localdnsip3,localdnsip4)>						
					  </div><input name = localdnsipvalue id="localdnsipvalue" TYPE="hidden">
					</td>
   				</tr>
   				<tr><th style="height:30px;">主数据库连接字</th></tr>
    			<tr>
	    			<td><label >数据库IP：</label></td>
		            <td><div class=all_input>						  
					    <input name=dnsresultip1 id="dnsresultip1" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
					     onkeyup=keyUpEvent(dnsresultip1,dnsresultip1,dnsresultip2)>.<input 
					     name=dnsresultip2 id="dnsresultip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						 onkeyup=keyUpEvent(dnsresultip1,dnsresultip2,dnsresultip3)>.<input 
						 name=dnsresultip3 id="dnsresultip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(dnsresultip2,dnsresultip3,dnsresultip4)>.<input 
						 name=dnsresultip4 id="dnsresultip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(dnsresultip3,dnsresultip4)>						
					  </div><input name = dnsresultipvalue id="dnsresultipvalue" TYPE="hidden">
					</td>
				</tr>
				<tr>
   					<td><label >数据库名：</label></td>
   					<td><input id="dnsresultDBname" type="text" class="span3" style="width:100px" name="dnsresultDBname" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td style="width:20%"><label >用户名：</label></td>
   					<td><input id="dnsresultDBuser" type="text" class="span3" style="width:100px" name="dnsresultDBuser" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td><label>密码：</label></td>
   					<td><input id="dnsresultDBpasswd" type="password" class="span3" style="width:100px" name="dnsresultDBpasswd"  /><em style="color:red">*</em></td>
   				</tr>	
	      		
	      		<tr><th style="height:30px;">缓冲数据库连接字</th></tr>
    			<tr>
	    			<td><label >数据库IP：</label></td>
		            <td><div class=all_input>						  
					    <input name=PRCip1 id="PRCip1" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
					     onkeyup=keyUpEvent(PRCip1,PRCip1,PRCip2)>.<input 
					     name=PRCip2 id="PRCip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						 onkeyup=keyUpEvent(PRCip1,PRCip2,PRCip3)>.<input 
						 name=PRCip3 id="PRCip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(PRCip2,PRCip3,PRCip4)>.<input 
						 name=PRCip4 id="PRCip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(PRCip3,PRCip4)>						
					  </div><input name = PRCipvalue id="PRCipvalue" TYPE="hidden">
					</td>
				</tr>
				<tr>
   					<td><label >数据库名：</label></td>
   					<td><input id="PRCDBname" type="text" class="span3" style="width:100px" name="PRCDBname" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td style="width:20%"><label >用户名：</label></td>
   					<td><input id="PRCDBuser" type="text" class="span3" style="width:100px" name="PRCDBuser" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td><label>密码：</label></td>
   					<td><input id="PRCDBpasswd" type="password" class="span3" style="width:100px" name="PRCDBpasswd"  /><em style="color:red">*</em></td>
   				</tr>				      			
    			
    			<tr><th style="height:30px;">PCAP频率估计数据库连接字</th></tr>
    			<tr>
	    			<td><label >数据库IP：</label></td>
		            <td><div class=all_input>						  
					    <input name=EARPip1 id="EARPip1" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
					     onkeyup=keyUpEvent(EARPip1,EARPip1,EARPip2)>.<input 
					     name=EARPip2 id="EARPip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
						 onkeyup=keyUpEvent(EARPip1,EARPip2,EARPip3)>.<input 
						 name=EARPip3 id="EARPip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEvent(EARPip2,EARPip3,EARPip4)>.<input 
						 name=EARPip4 id="EARPip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
						 onkeyup=keyUpEventForIp4(EARPip3,EARPip4)>						
					  </div><input name = EARPipvalue id="EARPipvalue" TYPE="hidden">
					</td>
				</tr>
				<tr>
   					<td><label >数据库名：</label></td>
   					<td><input id="EARPDBname" type="text" class="span3" style="width:100px" name="EARPDBname" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td style="width:20%"><label >用户名：</label></td>
   					<td><input id="EARPDBuser" type="text" class="span3" style="width:100px" name="EARPDBuser" /><em style="color:red">*</em></td>
   				</tr>
   				<tr>
   					<td><label>密码：</label></td>
   					<td><input id="EARPDBpasswd" type="password" class="span3" style="width:100px" name="EARPDBpasswd"  /><em style="color:red">*</em></td>
   				</tr>	  			
   </table>
   <div class="modal-footer">
        <button type="submit" class="btn btn-primary"  >保存</button>
   </div>
  </form> 
  <script>
  function keyDownEvent(obj)
	{
	    code=event.keyCode;
	    if(!((code>=48&&code<=57)||(code>=96&&code<=105)||code==190||code==110||
	code==13||code==9||code==39||code==8||code==46||code==99||code==37))
	        event.returnValue=false;
	    if(code==13)
	        event.keyCode=9;
	    if(code==110||code==190)
	        if(obj.value)
	            event.keyCode=9;
	        else
	            event.returnValue=false;
	}
	
	function keyUpEvent(obj0,obj1,obj2)
	{
	    if (obj1.value > 255)
	    {
	        alert("填写范围必须在 0 - 255间");
	        obj1.value = obj1.value.substring(0, obj1.value.length - 1);
	        return;
	    }
	    code=event.keyCode
	
	    if(obj1.value.length>=3&&code!=37&&code!=
	39&&code!=16&&code!=9&&code!=13)
	        obj2.focus();
	
	    if(code == 32)
	        obj2.focus();
	
	    if(code == 8 && obj1.value.length == 0)
	    {
	        obj0.focus();
	        setCursor(obj0,obj0.value.length);
	    }
	
	    if (code == 37 && (getPos(obj1) == 0))
	    {
	        obj0.focus();
	        setCursor(obj0,obj0.value.length);
	    }
	    if (code == 39 && (getPos(obj1) == obj1.value.length))
	    {
	        obj2.focus();
	    }
	}
	function keyUpEventForIp4(obj0,obj)
	{
	    if (obj.value > 255)
	    {
	        alert("填写范围必须在 0 - 255间");
	        obj.value = obj.value.substring(0, obj.value.length - 1);
	        return;
	    }
	    if(code == 8 && obj.value.length == 0)
	    {
	        obj0.focus();
	        setCursor(obj0,obj0.value.length);
	    }
	    if (code == 37 && (getPos(obj) == 0))
	    {
	        obj0.focus();
	        setCursor(obj0,obj0.value.length);
	    }
	
	}
	function getipvalue(obj1,obj2,obj3,obj4,obj)
	{
	  obj.value = obj1.value + "." + obj2.value + "."
	+ obj3.value + "." + obj4.value;		    
	    $.ajax({
			type : 'POST',
			url : 'addHoneyPot.action',
			data : {
				ip:obj.value
			},
			dataType:'json',
			success : function(msg) {
				alert("添加成功！");
				$('#add_pot_modal').modal('hide');
				$("#HoneyHostList").trigger("reloadGrid");
			},
			error:function(msg){
				alter(msg);
				$('#add_pot_modal').modal('hide');
				$("#HoneyHostList").trigger("reloadGrid");
			}
		});
	
	}
  </script>