<%@ page language="java" import="java.util.*,cn.edu.xjtu.manage.business.*" pageEncoding="UTF-8"%>

<h2>DNS扫描应用配置</h2>
<form id="updateDNSScanConfForm" action="updateDNSScanConf.action" method="post"> 
	 	<table cellpadding="0" cellspacing="0" class="gridtable">				      		
 			<tr>
 				<td><label >数据库IP地址：</label></td>
         <td><div class=all_input>						  
    <input name=DNSScanDBip1 id="DNSScanDBip1" class=ip_input maxlength=3
onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(DNSScanDBip1,DNSScanDBip1,DNSScanDBip2)>.<input
    name=DNSScanDBip2 id="DNSScanDBip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
onkeyup=keyUpEvent(DNSScanDBip1,DNSScanDBip2,DNSScanDBip3)>.<input
    name=DNSScanDBip3 id="DNSScanDBip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEvent(DNSScanDBip2,DNSScanDBip3,DNSScanDBip4)>.<input
    name=DNSScanDBip4 id="DNSScanDBip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEventForIp4(DNSScanDBip3,DNSScanDBip4)>						
  </div><label></label><input name = DNSScanDBipvalue id="DNSScanDBipvalue" TYPE="hidden"><input name = dnsScanConfID id=dnsScanConfID TYPE="hidden"></td>
 			</tr>
 			<tr>
 				<td><label >数据库名：</label></td>
 				<td><input id="DNSScanDBname" type="text" class="span3" style="width:100px" name="DNSScanDBname" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >用户名：</label></td>
 				<td><input id="DNSScanDBuser" type="text" class="span3" style="width:100px" name="DNSScanDBuser" /><em style="color:red">*</em></td>
 			</tr>	
 			<tr>
 				<td><label>密码：</label></td>
 				<td><input id="DNSScanDBpasswd" type="password" class="span3" style="width:100px" name="DNSScanDBpasswd"  /><em style="color:red">*</em></td>
 			</tr>	      							      			
 			<tr>
 				<td><label >scannerIP：</label></td>
         <td><div class=all_input>						  
    <input name=scannerIP1 id="scannerIP1" class=ip_input maxlength=3
onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(scannerIP1,scannerIP1,scannerIP2)>.<input
    name=scannerIP2 id="scannerIP2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
onkeyup=keyUpEvent(scannerIP1,scannerIP2,scannerIP3)>.<input
    name=scannerIP3 id="scannerIP3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEvent(scannerIP2,scannerIP3,scannerIP4)>.<input
    name=scannerIP4 id="scannerIP4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEventForIp4(scannerIP3,scannerIP4)>						
  </div><label></label><input name = scannerIPvalue id="scannerIPvalue" TYPE="hidden"></td>
 			</tr>	
 			<tr>
 				<td><label >defaultGw：</label></td>
         <td><div class=all_input>						  
    <input name=scanDefaultGwip1 id="scanDefaultGwip1" class=ip_input maxlength=3
onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(scanDefaultGwip1,scanDefaultGwip1,scanDefaultGwip2)>.<input
    name=scanDefaultGwip2 id="scanDefaultGwip2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
onkeyup=keyUpEvent(scanDefaultGwip1,scanDefaultGwip2,scanDefaultGwip3)>.<input
    name=scanDefaultGwip3 id="scanDefaultGwip3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEvent(scanDefaultGwip2,scanDefaultGwip3,scanDefaultGwip4)>.<input
    name=scanDefaultGwip4 id="scanDefaultGwip4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEventForIp4(scanDefaultGwip3,scanDefaultGwip4)>						
  </div><label></label><input name = scanDefaultGwipvalue id="scanDefaultGwipvalue" TYPE="hidden"></td>
 			</tr>	
 			<tr>
 				<td><label>testDomain:</label></td>
 				<td><input id="testDomain" type="text" class="span3" style="width:100px" name="testDomain" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td><label >testDomainIp：</label></td>
         <td><div class=all_input>						  
    <input name=testDomainIp1 id="testDomainIp1" class=ip_input maxlength=3
onkeydown=keyDownEvent(this) onkeyup=keyUpEvent(testDomainIp1,testDomainIp1,testDomainIp2)>.<input
    name=testDomainIp2 id="testDomainIp2" class=ip_input maxlength=3 onkeydown=keyDownEvent(this) 
onkeyup=keyUpEvent(testDomainIp1,testDomainIp2,testDomainIp3)>.<input
    name=testDomainIp3 id="testDomainIp3" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEvent(testDomainIp2,testDomainIp3,testDomainIp4)>.<input
    name=testDomainIp4 id="testDomainIp4" class=ip_input maxlength=3 onkeydown=keyDownEvent(this)
 onkeyup=keyUpEventForIp4(testDomainIp3,testDomainIp4)>						
  </div><label></label><input name = testDomainIpvalue id="testDomainIpvalue" TYPE="hidden"></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >packetRate：</label></td>
 				<td><input id="packetRate" type="text" class="span3" style="width:100px" name="packetRate" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >packetNum：</label></td>
 				<td><input id="packetNum" type="text" class="span3" style="width:100px" name="processNumForDig" /><em style="color:red">*</em></td>
  			</tr>
<tr>
  				<td style="width:20%"><label >outputDir：</label></td>
 				<td><input id="outputDir" type="text" class="span3" style="width:100px" name="digIteration" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >probeNum：</label></td>
 				<td><input id="probeNum" type="text" class="span3" style="width:100px" name="probeNum" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >extractNum：</label></td>
 				<td><input id="extractNum" type="text" class="span3" style="width:100px" name="extractNum" /><em style="color:red">*</em></td>
 			</tr>
<tr>
 				<td style="width:20%"><label >fakePort：</label></td>
 				<td><input id="fakePort" type="text" class="span3" style="width:100px" name="fakePort" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >ttl：</label></td>
 				<td><input id="ttl" type="text" class="span3" style="width:100px" name="ttl" /><em style="color:red">*</em></td>
 			</tr>
 			<tr>
 				<td style="width:20%"><label >maxIteration：</label></td>
 				<td><input id="maxIteration" type="text" class="span3" style="width:100px" name="maxIteration" /><em style="color:red">*</em></td>
 			</tr> 
 			<tr>
 				<td style="width:20%"><label >resolverUpdate：</label></td>
 				<td><input id="resolverUpdate" type="text" class="span3" style="width:100px" name="resolverUpdate" /><em style="color:red">*</em></td>
 			</tr> 
 			<tr>
 				<td style="width:20%"><label >resolverInterval：</label></td>
 				<td><input id="resolverInterval" type="text" class="span3" style="width:100px" name="resolverInterval" /><em style="color:red">*</em></td>
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