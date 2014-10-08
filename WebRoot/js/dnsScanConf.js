$(function(){
	$.ajax({
		type:"post",
		url:"getDNSScanConf.action",
		dataType:"json",
		success : function(data) {
			if(data.dnsScanConfInfo!=null){						
				dnsScanConfInfo=data.dnsScanConfInfo;									
				$("#dnsScanConfID").val(dnsScanConfInfo.id);
				var ips=dnsScanConfInfo.DNSScanDBip.split(".");
				$("#DNSScanDBip1").val(ips[0]);
				$("#DNSScanDBip2").val(ips[1]);
				$("#DNSScanDBip3").val(ips[2]);
				$("#DNSScanDBip4").val(ips[3]);
				var ips=dnsScanConfInfo.scannerIP.split(".");
				$("#scannerIP1").val(ips[0]);
				$("#scannerIP2").val(ips[1]);
				$("#scannerIP3").val(ips[2]);
				$("#scannerIP4").val(ips[3]);
				var ips=dnsScanConfInfo.scanDefaultGwip.split(".");
				$("#scanDefaultGwip1").val(ips[0]);
				$("#scanDefaultGwip2").val(ips[1]);
				$("#scanDefaultGwip3").val(ips[2]);
				$("#scanDefaultGwip4").val(ips[3]);
				var ips=dnsScanConfInfo.testDomainIp.split(".");
				$("#testDomainIp1").val(ips[0]);
				$("#testDomainIp2").val(ips[1]);
				$("#testDomainIp3").val(ips[2]);
				$("#testDomainIp4").val(ips[3]);
				
				//$("#radarDBport").val(appConfInfo.radarDBport);
				$("#DNSScanDBname").val(dnsScanConfInfo.DNSScanDBname);
				$("#DNSScanDBuser").val(dnsScanConfInfo.DNSScanDBuser);
				$("#DNSScanDBpasswd").val(dnsScanConfInfo.DNSScanDBpasswd);
				$("#testDomain").val(dnsScanConfInfo.testDomain);
				$("#packetRate").val(dnsScanConfInfo.packetRate);
				$("#packetNum").val(dnsScanConfInfo.packetNum);
				$("#outputDir").val(dnsScanConfInfo.outputDir);
				$("#probeNum").val(dnsScanConfInfo.probeNum);
				$("#extractNum").val(dnsScanConfInfo.extractNum);
				$("#fakePort").val(dnsScanConfInfo.fakePort);
				$("#ttl").val(dnsScanConfInfo.ttl);
				$("#maxIteration").val(dnsScanConfInfo.maxIteration);
				$("#resolverUpdate").val(dnsScanConfInfo.resolverUpdate);
				$("#resolverInterval").val(dnsScanConfInfo.resolverInterval);
			}
		}
	});
	
	$("#updateDNSScanConfForm").validate({
		debug:true,
		onsubmit:true,
		onfocusout:false,
		onkeyup:true,
		rules:{
			DNSScanDBip1:{required:true,digits:true},
			DNSScanDBip2:{required:true,digits:true},
			DNSScanDBip3:{required:true,digits:true},
			DNSScanDBip4:{required:true,digits:true},
			//radarDBport:{required:true},
			DNSScanDBname:{required:true},
			DNSScanDBuser:{required:true},
			DNSScanDBpasswd:{required:true},
			scannerIP1:{required:true,digits:true},
			scannerIP2:{required:true,digits:true},
			scannerIP3:{required:true,digits:true},
			scannerIP4:{required:true,digits:true},
			scanDefaultGwip1:{required:true,digits:true},
			scanDefaultGwip2:{required:true,digits:true},
			scanDefaultGwip3:{required:true,digits:true},
			scanDefaultGwip4:{required:true,digits:true},
			testDomainIp1:{required:true,digits:true},
			testDomainIp2:{required:true,digits:true},
			testDomainIp3:{required:true,digits:true},
			testDomainIp4:{required:true,digits:true},
			testDomain:{required:true},
			packetRate:{required:true},
			packetNum:{required:true},
			outputDir:{required:true},
			probeNum:{required:true},
			extractNum:{required:true},
			fakePort:{required:true},
			ttl:{required:true},
			maxIteration:{required:true},
			resolverUpdate:{required:true},
			resolverInterval:{required:true}
		},
		messages:{
			DNSScanDBip1:{required:"请补全IP!",digits:"输入不是整数！"},
			DNSScanDBip2:{required:"请补全IP!",digits:"输入不是整数！"},
			DNSScanDBip3:{required:"请补全IP!",digits:"输入不是整数！"},
			DNSScanDBip4:{required:"请补全IP!",digits:"输入不是整数！"},
			//radarDBport:{repuired:"端口不能为空！"},
			DNSScanDBname:{required:"数据库名不能为空！"},
			DNSScanDBuser:{required:"数据库用户名不能为空！"},
			DNSScanDBpasswd:{required:"数据库密码不能为空！"},
			scannerIP1:{required:"请补全IP!",digits:"输入不是整数！"},
			scannerIP2:{required:"请补全IP!",digits:"输入不是整数！"},
			scannerIP3:{required:"请补全IP!",digits:"输入不是整数！"},
			scannerIP4:{required:"请补全IP!",digits:"输入不是整数！"},
			scanDefaultGwip1:{required:"请补全IP!",digits:"输入不是整数！"},
			scanDefaultGwip2:{required:"请补全IP!",digits:"输入不是整数！"},
			scanDefaultGwip3:{required:"请补全IP!",digits:"输入不是整数！"},
			scanDefaultGwip4:{required:"请补全IP!",digits:"输入不是整数！"},
			testDomainIp1:{required:"请补全IP!",digits:"输入不是整数！"},
			testDomainIp2:{required:"请补全IP!",digits:"输入不是整数！"},
			testDomainIp3:{required:"请补全IP!",digits:"输入不是整数！"},
			testDomainIp4:{required:"请补全IP!",digits:"输入不是整数！"},
			testDomain:{required:"testDomain不能为空！"},
			packetRate:{required:"packetRate不能为空！"},
			packetNum:{required:"packetNum不能为空！"},
			outputDir:{required:"outputDir不能为空！"},
			probeNum:{required:"probeNum不能为空！"},
			extractNum:{required:"extractNum不能为空！"},
			fakePort:{required:"fakePort不能为空！"},
			ttl:{required:"ttl不能为空！"},
			maxIteration:{required:"maxIteration不能为空！"},
			resolverUpdate:{required:"resolverUpdate不能为空！"},
			resolverInterval:{required:"resolverInterval不能为空！"}
		},
		errorPlacement: function(error, element) {
		    error.appendTo( element.parent("div").next("label") );
		  },
		submitHandler:function(){
			var DNSScanDBipvalue= $("#DNSScanDBip1").val() + "." + $("#DNSScanDBip2").val() + "."+ $("#DNSScanDBip3").val() + "."+$("#DNSScanDBip4").val();
			var scannerIPvalue=$("#scannerIP1").val() + "." + $("#scannerIP2").val() + "."+ $("#scannerIP3").val() + "."+$("#scannerIP4").val();
			var scanDefaultGwipvalue = $("#scanDefaultGwip1").val() + "." + $("#scanDefaultGwip2").val() + "."+ $("#scanDefaultGwip3").val() + "." + $("#scanDefaultGwip4").val();
			var testDomainIpvalue = $("#testDomainIp1").val() + "." + $("#testDomainIp2").val() + "."+ $("#testDomainIp3").val() + "." + $("#testDomainIp4").val();	
			
			$("#DNSScanDBipvalue").val(DNSScanDBipvalue); 
			$("#scannerIPvalue").val(scannerIPvalue); 
			$("#scanDefaultGwipvalue").val(scanDefaultGwipvalue); 
			$("#testDomainIpvalue").val(testDomainIpvalue); 
			$.ajax({
				type : 'POST',
				url : 'updateDNSScanConf.action',
				data : {
					id:$("#dnsScanConfID").val(),
					DNSScanDBip:DNSScanDBipvalue,
					scannerIP:scannerIPvalue,
					scanDefaultGwip:scanDefaultGwipvalue,
					testDomainIp:testDomainIpvalue,
					//radarDBport:$("#radarDBport").val(),
					DNSScanDBname:$("#DNSScanDBname").val(),	
					DNSScanDBuser:$("#DNSScanDBuser").val(),	
					DNSScanDBpasswd:$("#DNSScanDBpasswd").val(),
					testDomain:$("#testDomain").val(),
					packetRate:$("#packetRate").val(),
					packetNum:$("#packetNum").val(),
					outputDir:$("#outputDir").val(),
					probeNum:$("#probeNum").val(),
					extractNum:$("#extractNum").val(),
					fakePort:$("#fakePort").val(),
					ttl:$("#ttl").val(),
					maxIteration:$("#maxIteration").val(),
					resolverUpdate:$("#resolverUpdate").val(),
					resolverInterval:$("#resolverInterval").val()
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