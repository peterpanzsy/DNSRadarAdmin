$(function(){
	$.ajax({
		type:"post",
		url:"getAppConf.action",
		dataType:"json",
		success : function(data) {
			if(data.appConfInfo!=null){						
				appConfInfo=data.appConfInfo;									
				$("#appconfID").val(appConfInfo.id);
				var ips=appConfInfo.radarDBip.split(".");
				$("#radarDBip1").val(ips[0]);
				$("#radarDBip2").val(ips[1]);
				$("#radarDBip3").val(ips[2]);
				$("#radarDBip4").val(ips[3]);
				var ips=appConfInfo.proberip.split(".");
				$("#proberip1").val(ips[0]);
				$("#proberip2").val(ips[1]);
				$("#proberip3").val(ips[2]);
				$("#proberip4").val(ips[3]);
				var ips=appConfInfo.defaultGwip.split(".");
				$("#defaultGwip1").val(ips[0]);
				$("#defaultGwip2").val(ips[1]);
				$("#defaultGwip3").val(ips[2]);
				$("#defaultGwip4").val(ips[3]);
				var ips=appConfInfo.localDNSip.split(".");
				$("#localDNSip1").val(ips[0]);
				$("#localDNSip2").val(ips[1]);
				$("#localDNSip3").val(ips[2]);
				$("#localDNSip4").val(ips[3]);
				
				//$("#radarDBport").val(appConfInfo.radarDBport);
				$("#radarDBname").val(appConfInfo.radarDBname);
				$("#radarDBuser").val(appConfInfo.radarDBuser);
				$("#radarDBpasswd").val(appConfInfo.radarDBpasswd);
				$("#fakePortBase").val(appConfInfo.fakePortBase);
				$("#processNumForDig").val(appConfInfo.processNumForDig);
				$("#digIteration").val(appConfInfo.digIteration);
				$("#maxSendRate").val(appConfInfo.maxSendRate);
				$("#maxTaskNum").val(appConfInfo.maxTaskNum);
				$("#sendThreadNumByThousand").val(appConfInfo.sendThreadNumByThousand);
				$("#EnableLog").val(appConfInfo.enableLog);
				$("#extractThreadNum").val(appConfInfo.extractThreadNum);
			}
		}
	});
	
	$("#updateAppConfForm").validate({
		debug:true,
		onsubmit:true,
		onfocusout:false,
		onkeyup:true,
		rules:{
			radarDBip1:{required:true,digits:true},
			radarDBip2:{required:true,digits:true},
			radarDBip3:{required:true,digits:true},
			radarDBip4:{required:true,digits:true},
			//radarDBport:{required:true},
			radarDBname:{required:true},
			radarDBuser:{required:true},
			radarDBpasswd:{required:true},
			proberip1:{required:true,digits:true},
			proberip2:{required:true,digits:true},
			proberip3:{required:true,digits:true},
			proberip4:{required:true,digits:true},
			defaultGwip1:{required:true,digits:true},
			defaultGwip2:{required:true,digits:true},
			defaultGwip3:{required:true,digits:true},
			defaultGwip4:{required:true,digits:true},
			localDNSip1:{required:true,digits:true},
			localDNSip2:{required:true,digits:true},
			localDNSip3:{required:true,digits:true},
			localDNSip4:{required:true,digits:true},
			fakePortBase:{required:true},
			processNumForDig:{required:true},
			digIteration:{required:true},
			maxSendRate:{required:true},
			maxTaskNum:{required:true},
			sendThreadNumByThousand:{required:true},
			EnableLog:{required:true},
			extractThreadNum:{required:true}
		},
		messages:{
			radarDBip1:{required:"请补全IP!",digits:"输入不是整数！"},
			radarDBip2:{required:"请补全IP!",digits:"输入不是整数！"},
			radarDBip3:{required:"请补全IP!",digits:"输入不是整数！"},
			radarDBip4:{required:"请补全IP!",digits:"输入不是整数！"},
			//radarDBport:{repuired:"端口不能为空！"},
			radarDBname:{required:"数据库名不能为空！"},
			radarDBuser:{required:"数据库用户名不能为空！"},
			radarDBpasswd:{required:"数据库密码不能为空！"},
			proberip1:{required:"请补全IP!",digits:"输入不是整数！"},
			proberip2:{required:"请补全IP!",digits:"输入不是整数！"},
			proberip3:{required:"请补全IP!",digits:"输入不是整数！"},
			proberip4:{required:"请补全IP!",digits:"输入不是整数！"},
			defaultGwip1:{required:"请补全IP!",digits:"输入不是整数！"},
			defaultGwip2:{required:"请补全IP!",digits:"输入不是整数！"},
			defaultGwip3:{required:"请补全IP!",digits:"输入不是整数！"},
			defaultGwip4:{required:"请补全IP!",digits:"输入不是整数！"},
			localDNSip1:{required:"请补全IP!",digits:"输入不是整数！"},
			localDNSip2:{required:"请补全IP!",digits:"输入不是整数！"},
			localDNSip3:{required:"请补全IP!",digits:"输入不是整数！"},
			localDNSip4:{required:"请补全IP!",digits:"输入不是整数！"},
			fakePortBase:{required:"fakePortBase不能为空！"},
			processNumForDig:{required:"processNumForDig不能为空！"},
			digIteration:{required:"digIteration不能为空！"},
			maxSendRate:{required:"maxSendRate不能为空！"},
			maxTaskNum:{required:"maxTaskNum不能为空！"},
			sendThreadNumByThousand:{required:"sendThreadNumByThousand不能为空！"},
			EnableLog:{required:"EnableLog不能为空！"},
			extractThreadNum:{required:"extractThreadNum不能为空！"}
		},
		errorPlacement: function(error, element) {
		    error.appendTo( element.parent("div").next("label") );
		  },
		submitHandler:function(){
			var radarDBipvalue= $("#radarDBip1").val() + "." + $("#radarDBip2").val() + "."+ $("#radarDBip3").val() + "."+$("#radarDBip4").val();
			var proberipvalue=$("#proberip1").val() + "." + $("#proberip2").val() + "."+ $("#proberip3").val() + "."+$("#proberip4").val();
			var defaultGwipvalue = $("#defaultGwip1").val() + "." + $("#defaultGwip2").val() + "."+ $("#defaultGwip3").val() + "." + $("#defaultGwip4").val();
			var localDNSipvalue = $("#localDNSip1").val() + "." + $("#localDNSip2").val() + "."+ $("#localDNSip3").val() + "." + $("#localDNSip4").val();	
			
			$("#radarDBipvalue").val(radarDBipvalue); 
			$("#proberipvalue").val(proberipvalue); 
			$("#defaultGwipvalue").val(defaultGwipvalue); 
			$("#localDNSipvalue").val(localDNSipvalue); 
			$.ajax({
				type : 'POST',
				url : 'updateAppConf.action',
				data : {
					id:$("#appconfID").val(),
					radarDBip:radarDBipvalue,
					proberip:proberipvalue,
					defaultGwip:defaultGwipvalue,
					localDNSip:localDNSipvalue,
					//radarDBport:$("#radarDBport").val(),
					radarDBname:$("#radarDBname").val(),	
					radarDBuser:$("#radarDBuser").val(),	
					radarDBpasswd:$("#radarDBpasswd").val(),
					fakePortBase:$("#fakePortBase").val(),
					processNumForDig:$("#processNumForDig").val(),
					digIteration:$("#digIteration").val(),
					maxSendRate:$("#maxSendRate").val(),
					maxTaskNum:$("#maxTaskNum").val(),
					sendThreadNumByThousand:$("#sendThreadNumByThousand").val(),
					EnableLog:$("#EnableLog").val(),
					extractThreadNum:$("#extractThreadNum").val()
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