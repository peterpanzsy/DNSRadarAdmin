$(function(){
	$.ajax({
		type:"post",
		url:"getDNSProbeConf.action",
		dataType:"json",
		success : function(data) {
			if(data.dnsProbeConfInfo!=null){						
				dnsProbeConfInfo=data.dnsProbeConfInfo;									
				$("#probeconfID").val(dnsProbeConfInfo.id);
				var ips=dnsProbeConfInfo.localIP.split(".");
				$("#localip1").val(ips[0]);
				$("#localip2").val(ips[1]);
				$("#localip3").val(ips[2]);
				$("#localip4").val(ips[3]);
				var ips=dnsProbeConfInfo.gatewayIP.split(".");
				$("#gatewayip1").val(ips[0]);
				$("#gatewayip2").val(ips[1]);
				$("#gatewayip3").val(ips[2]);
				$("#gatewayip4").val(ips[3]);
				var ips=dnsProbeConfInfo.localDNS.split(".");
				$("#localdnsip1").val(ips[0]);
				$("#localdnsip2").val(ips[1]);
				$("#localdnsip3").val(ips[2]);
				$("#localdnsip4").val(ips[3]);
				
				var ips=dnsProbeConfInfo.dns_result_db_ip.split(".");
				$("#dnsresultip1").val(ips[0]);
				$("#dnsresultip2").val(ips[1]);
				$("#dnsresultip3").val(ips[2]);
				$("#dnsresultip4").val(ips[3]);
				$("#dnsresultDBname").val(dnsProbeConfInfo.dns_result_db_name);
				$("#dnsresultDBuser").val(dnsProbeConfInfo.dns_result_db_user);
				$("#dnsresultDBpasswd").val(dnsProbeConfInfo.dns_result_db_pass);

				var ips=dnsProbeConfInfo.probe_record_db_ip.split(".");
				$("#PRCip1").val(ips[0]);
				$("#PRCip2").val(ips[1]);
				$("#PRCip3").val(ips[2]);
				$("#PRCip4").val(ips[3]);
				$("#PRCDBname").val(dnsProbeConfInfo.probe_record_db_name);
				$("#PRCDBuser").val(dnsProbeConfInfo.probe_record_db_user);
				$("#PRCDBpasswd").val(dnsProbeConfInfo.probe_record_db_pass);

				var ips=dnsProbeConfInfo.extractAveRateParameter_db_ip.split(".");
				$("#EARPip1").val(ips[0]);
				$("#EARPip2").val(ips[1]);
				$("#EARPip3").val(ips[2]);
				$("#EARPip4").val(ips[3]);
				$("#EARPDBname").val(dnsProbeConfInfo.extractAveRateParameter_db_name);
				$("#EARPDBuser").val(dnsProbeConfInfo.extractAveRateParameter_db_user);
				$("#EARPDBpasswd").val(dnsProbeConfInfo.extractAveRateParameter_db_pass);
				
			}
		}
	});
	
	$("#updateProbeConfForm").validate({
		debug:true,
		onsubmit:true,
		onfocusout:false,
		onkeyup:true,
		rules:{
			localip1:{required:true,digits:true},
			localip2:{required:true,digits:true},
			localip3:{required:true,digits:true},
			localip4:{required:true,digits:true},
			gatewayip1:{required:true,digits:true},
			gatewayip2:{required:true,digits:true},
			gatewayip3:{required:true,digits:true},
			gatewayip4:{required:true,digits:true},
			localdnsip1:{required:true,digits:true},
			localdnsip2:{required:true,digits:true},
			localdnsip3:{required:true,digits:true},
			localdnsip4:{required:true,digits:true},
			
			dnsresultip1:{required:true,digits:true},
			dnsresultip2:{required:true,digits:true},
			dnsresultip3:{required:true,digits:true},
			dnsresultip4:{required:true,digits:true},
			dnsresultDBname:{required:true},
			dnsresultDBuser:{required:true},
			dnsresultDBpasswd:{required:true},
			
			PRCip1:{required:true,digits:true},
			PRCip2:{required:true,digits:true},
			PRCip3:{required:true,digits:true},
			PRCip4:{required:true,digits:true},
			PRCDBname:{required:true},
			PRCDBuser:{required:true},
			PRCDBpasswd:{required:true},
			
			EARPip1:{required:true,digits:true},
			EARPip2:{required:true,digits:true},
			EARPip3:{required:true,digits:true},
			EARPip4:{required:true,digits:true},
			EARPDBname:{required:true},
			EARPDBuser:{required:true},
			EARPDBpasswd:{required:true},
			
		},
		messages:{
			localip1:{required:"请补全IP!",digits:"输入不是整数！"},
			localip2:{required:"请补全IP!",digits:"输入不是整数！"},
			localip3:{required:"请补全IP!",digits:"输入不是整数！"},
			localip4:{required:"请补全IP!",digits:"输入不是整数！"},
			gatewayip1:{required:"请补全IP!",digits:"输入不是整数！"},
			gatewayip2:{required:"请补全IP!",digits:"输入不是整数！"},
			gatewayip3:{required:"请补全IP!",digits:"输入不是整数！"},
			gatewayip4:{required:"请补全IP!",digits:"输入不是整数！"},
			localdnsip1:{required:"请补全IP!",digits:"输入不是整数！"},
			localdnsip2:{required:"请补全IP!",digits:"输入不是整数！"},
			localdnsip3:{required:"请补全IP!",digits:"输入不是整数！"},
			localdnsip4:{required:"请补全IP!",digits:"输入不是整数！"},
			
			dnsresultip1:{required:"请补全IP!",digits:"输入不是整数！"},
			dnsresultip2:{required:"请补全IP!",digits:"输入不是整数！"},
			dnsresultip3:{required:"请补全IP!",digits:"输入不是整数！"},
			dnsresultip4:{required:"请补全IP!",digits:"输入不是整数！"},
			dnsresultDBname:{required:"数据库名不能为空！"},
			dnsresultDBuser:{required:"数据库用户名不能为空！"},
			dnsresultDBpasswd:{required:"数据库密码不能为空！"},
			
			PRCip1:{required:"请补全IP!",digits:"输入不是整数！"},
			PRCip2:{required:"请补全IP!",digits:"输入不是整数！"},
			PRCip3:{required:"请补全IP!",digits:"输入不是整数！"},
			PRCip4:{required:"请补全IP!",digits:"输入不是整数！"},
			PRCDBname:{required:"数据库名不能为空！"},
			PRCDBuser:{required:"数据库用户名不能为空！"},
			PRCDBpasswd:{required:"数据库密码不能为空！"},
			
			EARPip1:{required:"请补全IP!",digits:"输入不是整数！"},
			EARPip2:{required:"请补全IP!",digits:"输入不是整数！"},
			EARPip3:{required:"请补全IP!",digits:"输入不是整数！"},
			EARPip4:{required:"请补全IP!",digits:"输入不是整数！"},
			EARPDBname:{required:"数据库名不能为空！"},
			EARPDBuser:{required:"数据库用户名不能为空！"},
			EARPDBpasswd:{required:"数据库密码不能为空！"}
		},
		errorPlacement: function(error, element) {
		    error.appendTo( element.parent("div").next("label") );
		  },
		submitHandler:function(){
			var localipvalue= $("#localip1").val() + "." + $("#localip2").val() + "."+ $("#localip3").val() + "."+$("#localip4").val();
			$("#localipvalue").val(localipvalue); 
			var gatewayipvalue= $("#gatewayip1").val() + "." + $("#gatewayip2").val() + "."+ $("#gatewayip3").val() + "."+$("#gatewayip4").val();
			$("#gatewayipvalue").val(gatewayipvalue); 
			var localdnsipvalue= $("#localdnsip1").val() + "." + $("#localdnsip2").val() + "."+ $("#localdnsip3").val() + "."+$("#localdnsip4").val();
			$("#localdnsipvalue").val(localdnsipvalue); 
			
			var dnsresultipvalue= $("#dnsresultip1").val() + "." + $("#dnsresultip2").val() + "."+ $("#dnsresultip3").val() + "."+$("#dnsresultip4").val();
			$("#dnsresultipvalue").val(dnsresultipvalue); 
			var PRCipvalue= $("#PRCip1").val() + "." + $("#PRCip2").val() + "."+ $("#PRCip3").val() + "."+$("#PRCip4").val();
			$("#PRCipvalue").val(PRCipvalue); 
			var EARPipvalue= $("#EARPip1").val() + "." + $("#EARPip2").val() + "."+ $("#EARPip3").val() + "."+$("#EARPip4").val();
			$("#EARPipvalue").val(EARPipvalue); 
			
		
			$.ajax({
				type : 'POST',
				url : 'updateDNSProbeConf.action',
				data : {
					id:$("#probeconfID").val(),
					localIP:localipvalue,
					gatewayIP:gatewayipvalue,
					localDNS:localdnsipvalue,
					dns_result_db_ip:dnsresultipvalue,
					dns_result_db_name:$("#dnsresultDBname").val(),
					dns_result_db_user:$("#dnsresultDBuser").val(),
					dns_result_db_pass:$("#dnsresultDBpasswd").val(),
					probe_record_db_ip:PRCipvalue,
					probe_record_db_name:$("#PRCDBname").val(),
					probe_record_db_user:$("#PRCDBuser").val(),
					probe_record_db_pass:$("#PRCDBpasswd").val(),
					extractAveRateParameter_db_ip:EARPipvalue,
					extractAveRateParameter_db_name:$("#EARPDBname").val(),
					extractAveRateParameter_db_user:$("#EARPDBuser").val(),
					extractAveRateParameter_db_pass:$("#EARPDBpasswd").val()
				},
				dataType:'json',
				success : function(data) {
					if(data.re=="success"){
						alert("配置成功！");
					}else{
						alert("配置失败！");
					}		
				},
				error:function(msg){
					alert("通讯错误，更新失败！！");	
				
				}
			});
		}
	});
	
});