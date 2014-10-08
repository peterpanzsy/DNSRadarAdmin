<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

<div class="modal fade" id="loading" style="margin-top:200px;"> <div class="modal-dialog" >
			<div class="modal-content">网络配置以及重启需要一定时间，请耐心等待！</div></div></div>
			<h2>网络配置</h2>
<form id="updateNetConfForm" name="updateNetConfForm" action="updateNetConf.action" method="post">				
	 				<table cellpadding="0" cellspacing="0" class="gridtable" >		      		
 						<tr>
  						<td><label >管理IP：</label></td>
          		<td><div class=all_input>						  
				    <input name=netip1 id="netip1" class=ip_input maxlength=3
				onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
	    name=netip2 id="netip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
	onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
	    name=netip3 id="netip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
	    name=netip4 id="netip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEventForIp4(ip3,ip4)>						
			</div><label></label><input name = netipvalue id="netipvalue" TYPE="hidden"><input name = netID id=netID TYPE="hidden">
		</td>
				</tr>
				<tr>
 				<td><label >管理掩码：</label></td>
         <td><div class=all_input>						  
	    <input name=maskip1 id="maskip1" class=ip_input maxlength=3
	onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
	    name=maskip2 id="maskip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
	onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
	    name=maskip3 id="maskip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
	    name=maskip4 id="maskip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEventForIp4(ip3,ip4)>						
			</div><label></label><input name = maskipvalue id="maskipvalue" TYPE="hidden">
		</td>
				</tr>
 			<tr>
 				<td><label >默认网关：</label></td>
         <td>
          <div class=all_input>						  
	    <input name=gateip1 id="gateip1" class=ip_input maxlength=3
	onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(ip1,ip1,ip2)>.<input
	    name=gateip2 id="gateip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
	onkeyup=keyUpEvent(ip1,ip2,ip3)>.<input
	    name=gateip3 id="gateip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEvent(ip2,ip3,ip4)>.<input
	    name=gateip4 id="gateip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEventForIp4(ip3,ip4)>						
	  </div><label></label>
 		<input name = gateipvalue id="gateipvalue" TYPE="hidden">
 	</td>
				</tr>
 			<tr>
 				<td><label >DNS服务器：</label></td>
         <td><div class=all_input>						  
	    <input name=dns1ip1 id="dns1ip1" class=ip_input maxlength=3
	onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(dns1ip1,dns1ip1,dns1ip2)>.<input
	    name=dns1ip2 id="dns1ip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
	onkeyup=keyUpEvent(dns1ip1,dns1ip2,dns1ip3)>.<input
	    name=dns1ip3 id="dns1ip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEvent(dns1ip2,dns1ip3,dns1ip4)>.<input
	    name=dns1ip4 id="dns1ip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEventForIp4(dns1ip3,dns1ip4)>						
	  </div><label></label><input name = dns1ipvalue id="dns1ipvalue" TYPE="hidden">
	  <div class=all_input>						  
	    <input name=dns2ip1 id="dns2ip1" class=ip_input maxlength=3
	onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(dns2ip1,dns2ip1,dns2ip2)>.<input
	    name=dns2ip2 id="dns2ip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
	onkeyup=keyUpEvent(dns2ip1,dns2ip2,dns2ip3)>.<input
	    name=dns2ip3 id="dns2ip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEvent(dns2ip2,dns2ip3,dns2ip4)>.<input
	    name=dns2ip4 id="dns2ip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
	 onkeyup=keyUpEventForIp4(dns2ip3,dns2ip4)>						
	  </div><label></label>
	  <input name = dns2ipvalue id="dns2ipvalue" TYPE="hidden">
</td>
 			</tr>
	</table>
	<div class="modal-footer">
     <button id="netsubmit" name="netsubmit" type="submit" class="btn btn-primary" >保存</button>
	</div>
</form>  
<script type="text/javascript">
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