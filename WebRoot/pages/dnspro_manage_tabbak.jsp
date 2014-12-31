<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

<h2>DNS探测应用配置</h2>
<form id="updateAppConfForm" action="updateAppConf.action" method="post"> 
	<table cellpadding="0" cellspacing="0" class="gridtable">
   				<tr>
    				<td><label >数据库IP地址：</label></td>
            <td><div class=all_input>						  
			    <input name=radarDBip1 id="radarDBip1" class=ip_input maxlength=3
			onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(radarDBip1,radarDBip1,radarDBip2)>.<input
			    name=radarDBip2 id="radarDBip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
			onkeyup=keyUpEvent(radarDBip1,radarDBip2,radarDBip3)>.<input
			    name=radarDBip3 id="radarDBip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEvent(radarDBip2,radarDBip3,radarDBip4)>.<input
			    name=radarDBip4 id="radarDBip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEventForIp4(radarDBip3,radarDBip4)>						
			  </div><label></label><input name = radarDBipvalue id="radarDBipvalue" TYPE="hidden"><input name = appconfID id=appconfID TYPE="hidden">
			</td>
   				</tr>
   				<!-- 	<tr>
   				<td><label>端口：</label></td>
   				<td><input id=radarDBport type="text"  class="span3"style="width:100px"  name="radarDBport" /><em style="color:red">*</em></td>
   				</tr> -->
    			<tr>
    				<td><label >数据库名：</label></td>
    				<td><input id="radarDBname" type="text" class="span3" style="width:100px" name="radarDBname" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >用户名：</label></td>
    				<td><input id="radarDBuser" type="text" class="span3" style="width:100px" name="radarDBuser" /><em style="color:red">*</em></td>
    			</tr>	
    			<tr>
    				<td><label>密码：</label></td>
    				<td><input id="radarDBpasswd" type="password" class="span3" style="width:100px" name="radarDBpasswd"  /><em style="color:red">*</em></td>
    			</tr>	      						      			
    			<tr>
    				<td><label >proberIP：</label></td>
            <td><div class=all_input>						  
			    <input name=proberip1 id="proberip1" class=ip_input maxlength=3
				onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(proberip1,proberip1,proberip2)>.<input
				    name=proberip2 id="proberip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
				onkeyup=keyUpEvent(proberip1,proberip2,proberip3)>.<input
				    name=proberip3 id="proberip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
				 onkeyup=keyUpEvent(proberip2,proberip3,proberip4)>.<input
				    name=proberip4 id="proberip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
				 onkeyup=keyUpEventForIp4(proberip3,proberip4)>						
				  </div><label></label><input name = proberipvalue id="proberipvalue" TYPE="hidden">
			 </td>
    			</tr>	
    			<tr>
    				<td><label >defaultGw：</label></td>
            <td><div class=all_input>						  
			    <input name=defaultGwip1 id="defaultGwip1" class=ip_input maxlength=3
			onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(defaultGwip1,defaultGwip1,defaultGwip2)>.<input
			    name=defaultGwip2 id="defaultGwip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
			onkeyup=keyUpEvent(defaultGwip1,defaultGwip2,defaultGwip3)>.<input
			    name=defaultGwip3 id="defaultGwip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEvent(defaultGwip2,defaultGwip3,defaultGwip4)>.<input
			    name=defaultGwip4 id="defaultGwip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEventForIp4(defaultGwip3,defaultGwip4)>						
		  		</div><label></label><input name = defaultGwipvalue id="defaultGwipvalue" TYPE="hidden">
		  	</td>
    			</tr>	
    			<tr>
    				<td><label >权威DNS服务器IP：</label></td>
            <td><div class=all_input>						  
			    <input name=localDNSip1 id="localDNSip1" class=ip_input maxlength=3
			onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(localDNSip1,localDNSip1,localDNSip2)>.<input
			    name=localDNSip2 id="localDNSip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
			onkeyup=keyUpEvent(localDNSip1,localDNSip2,localDNSip3)>.<input
			    name=localDNSip3 id="localDNSip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEvent(localDNSip2,localDNSip3,localDNSip4)>.<input
			    name=localDNSip4 id="localDNSip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
			 onkeyup=keyUpEventForIp4(localDNSip3,localDNSip4)>						
			  </div><label></label><input name = localDNSipvalue id="localDNSipvalue" TYPE="hidden">
			</td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >fakePortBase：</label></td>
    				<td><input id="fakePortBase" type="text" class="span3" style="width:100px" name="fakePortBase" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >processNumForDig：</label></td>
    				<td><input id="processNumForDig" type="text" class="span3" style="width:100px" name="processNumForDig" /><em style="color:red">*</em></td>
    			</tr>
		<tr>
    				<td style="width:20%"><label >digIteration：</label></td>
    				<td><input id="digIteration" type="text" class="span3" style="width:100px" name="digIteration" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >maxSendRate：</label></td>
    				<td><input id="maxSendRate" type="text" class="span3" style="width:100px" name="maxSendRate" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >maxTaskNum：</label></td>
    				<td><input id="maxTaskNum" type="text" class="span3" style="width:100px" name="maxTaskNum" /><em style="color:red">*</em></td>
    			</tr>
			<tr>
    				<td style="width:20%"><label >sendThreadNumByThousand：</label></td>
    				<td><input id="sendThreadNumByThousand" type="text" class="span3" style="width:100px" name="sendThreadNumByThousand" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >EnableLog：</label></td>
    				<td><input id="EnableLog" type="text" class="span3" style="width:100px" name="EnableLog" /><em style="color:red">*</em></td>
    			</tr>
    			<tr>
    				<td style="width:20%"><label >extractThreadNum：</label></td>
    				<td><input id="extractThreadNum" type="text" class="span3" style="width:100px" name="extractThreadNum" /><em style="color:red">*</em></td>
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