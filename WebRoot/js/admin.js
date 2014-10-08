
function getLicense(){
	$.ajax({
		type:"post",
		url:"getLicense.action",
		dataType:"json",
		success : function(data) {
			if(data.license!=null){						
				license=data.license;						
				$("#licenseStr").val(license.license);				
				$("#licenseID").val(license.id);
				if(license.isvalid==0){
					$("#isvalid").val("不合法");
				}else if(license.isvalid==1){
					$("#isvalid").val("合法但过期");
				}else if(license.isvalid==2){
					$("#isvalid").val("有效");
				}else{
					$("#isvalid").val("状态未知");
				}
				if(license.expires!=null){
					var newExpires=license.expires.replace("T"," ");
					$("#licenseDate").val(newExpires);
				}
				
			}
		}
	});
}
$(
	
	function() {
		
		
		getLicense();
		$("#updateLicenseForm").validate({
			debug:true,
			onsubmit:true,
			onfocusout:false,
			onkeyup:true,
			rules:{
				licenseStr:{
					required:true
				}	
			},
			messages:{
				licenseStr:{
					required:"请填写序列号!"
				}
			},
			submitHandler:function(){				
				$.ajax({
					type : 'POST',
					url : 'updateLicense.action',
					data : {
						licensestr:$("#licenseStr").val(),	
						id:$("#licenseID").val(),
						expires:'',
						isvalid:-1
					},
					dataType:'json',
					success : function(data) {
						if(data.re=="success"){
							alert("更新成功！");
							getLicense();
						}else{
							getLicense();
							alert("更新失败！");
						}							
					},
					error:function(msg){
						alert("通讯错误，更新失败！！");						
					}
				});
			}
		});
		
		
		$.ajax({
			type:"post",
			url:"getNetConf.action",
			dataType:"json",
			success : function(data) {
				if(data.netConfInfo!=null){
					netConfInfo=data.netConfInfo;
					$("#netID").val(netConfInfo.id);
					var ips=netConfInfo.netip.split(".");
					$("#netip1").val(ips[0]);
					$("#netip2").val(ips[1]);
					$("#netip3").val(ips[2]);
					$("#netip4").val(ips[3]);
					var ips=netConfInfo.maskip.split(".");
					$("#maskip1").val(ips[0]);
					$("#maskip2").val(ips[1]);
					$("#maskip3").val(ips[2]);
					$("#maskip4").val(ips[3]);
					var ips=netConfInfo.gateip.split(".");
					$("#gateip1").val(ips[0]);
					$("#gateip2").val(ips[1]);
					$("#gateip3").val(ips[2]);
					$("#gateip4").val(ips[3]);
					var ips=netConfInfo.dns1ip.split(".");
					$("#dns1ip1").val(ips[0]);
					$("#dns1ip2").val(ips[1]);
					$("#dns1ip3").val(ips[2]);
					$("#dns1ip4").val(ips[3]);
					var ips=netConfInfo.dns2ip.split(".");
					$("#dns2ip1").val(ips[0]);
					$("#dns2ip2").val(ips[1]);
					$("#dns2ip3").val(ips[2]);
					$("#dns2ip4").val(ips[3]);
					
				}
			}
		});
		
		$("#updateNetConfForm").validate({
			debug:true,
			onsubmit:true,
			onfocusout:false,
			onkeyup:true,
			rules:{
				netip1:{required:true,digits:true},
				netip2:{required:true,digits:true},
				netip3:{required:true,digits:true},
				netip4:{required:true,digits:true},
				maskip1:{required:true,digits:true},
				maskip2:{required:true,digits:true},
				maskip3:{required:true,digits:true},
				maskip4:{required:true,digits:true},
				gateip1:{required:true,digits:true},
				gateip2:{required:true,digits:true},
				gateip3:{required:true,digits:true},
				gateip4:{required:true,digits:true},
				dns1ip1:{required:true,digits:true},
				dns1ip2:{required:true,digits:true},
				dns1ip3:{required:true,digits:true},
				dns1ip4:{required:true,digits:true},
				dns2ip1:{required:true,digits:true},
				dns2ip2:{required:true,digits:true},
				dns2ip3:{required:true,digits:true},
				dns2ip4:{required:true,digits:true},
				
			},
			messages:{
				netip1:{required:"请补全IP!",digits:"输入不是整数！"},
				netip2:{required:"请补全IP!",digits:"输入不是整数！"},
				netip3:{required:"请补全IP!",digits:"输入不是整数！"},
				netip4:{required:"请补全IP!",digits:"输入不是整数！"},
				maskip1:{required:"请补全IP!",digits:"输入不是整数！"},
				maskip2:{required:"请补全IP!",digits:"输入不是整数！"},
				maskip3:{required:"请补全IP!",digits:"输入不是整数！"},
				maskip4:{required:"请补全IP!",digits:"输入不是整数！"},
				gateip1:{required:"请补全IP!",digits:"输入不是整数！"},
				gateip2:{required:"请补全IP!",digits:"输入不是整数！"},
				gateip3:{required:"请补全IP!",digits:"输入不是整数！"},
				gateip4:{required:"请补全IP!",digits:"输入不是整数！"},
				dns1ip1:{required:"请补全IP!",digits:"输入不是整数！"},
				dns1ip2:{required:"请补全IP!",digits:"输入不是整数！"},
				dns1ip3:{required:"请补全IP!",digits:"输入不是整数！"},
				dns1ip4:{required:"请补全IP!",digits:"输入不是整数！"},
				dns2ip1:{required:"请补全IP!",digits:"输入不是整数！"},
				dns2ip2:{required:"请补全IP!",digits:"输入不是整数！"},
				dns2ip3:{required:"请补全IP!",digits:"输入不是整数！"},
				dns2ip4:{required:"请补全IP!",digits:"输入不是整数！"},
			},
			errorPlacement: function(error, element) {
			    error.appendTo( element.parent("div").next("label") );
			  },
			submitHandler:function(){
				var networkip= $("#netip1").val() + "." + $("#netip2").val() + "."+ $("#netip3").val() + ".0";
				var broadcastip=$("#netip1").val() + "." + $("#netip2").val() + "."+ $("#netip3").val() + ".255";
				var netipvalue = $("#netip1").val() + "." + $("#netip2").val() + "."+ $("#netip3").val() + "." + $("#netip4").val();	
				$("#netipvalue").val(netipvalue); 
				var maskipvalue = $("#maskip1").val() + "." + $("#maskip2").val() + "."+ $("#maskip3").val() + "." + $("#maskip4").val();	
				$("#maskipvalue").val(maskipvalue); 
				var gateipvalue = $("#gateip1").val() + "." + $("#gateip2").val() + "."+ $("#gateip3").val() + "." + $("#gateip4").val();	
				$("#gateipvalue").val(gateipvalue); 
				var dns1ipvalue = $("#dns1ip1").val() + "." + $("#dns1ip2").val() + "."+ $("#dns1ip3").val() + "." + $("#dns1ip4").val();	
				$("#dns1ipvalue").val(dns1ipvalue); 
				var dns2ipvalue = $("#dns2ip1").val() + "." + $("#dns2ip2").val() + "."+ $("#dns2ip3").val() + "." + $("#dns2ip4").val();	
				$("#dns2ipvalue").val(dns2ipvalue); 	
				$("#netsubmit").attr("disabled",true);
				$('#loading').modal();
				$.ajax({
					type : 'POST',
					url : 'updateNetConf.action',
					data : {
						id:$("#netID").val(),
						netip:netipvalue,
						maskip:maskipvalue,
						gateip:gateipvalue,
						dns1ip:dns1ipvalue,
						dns2ip:dns2ipvalue,
						networkip:networkip,
						broadcastip:broadcastip
					},
					dataType:'json',
					success : function(data) {
						$('#loading').modal("hide");
						if(data.re=="success"){
							alert("网络配置已生效！");
						}else{
							alert("网络配置失败！");
						}		
						$("#netsubmit").attr("disabled",false);
						
						//$("#netsubmit").removeAttr("disabled");  //移除属性
					},
					error:function(msg){
						$('#loading').modal("hide");
						alert("通讯错误，更新失败！！");	
						$("#netsubmit").attr("disabled",false);
						
						//$("#netsubmit").removeAttr("disabled");  //移除属性
					}
				});
			}
		});
		
		$.ajax({
			type:"post",
			url:"getDB.action",
			dataType:"json",
			success : function(data) {
				if(data.dbinfo!=null){
					dbinfo=data.dbinfo;
					var ips=dbinfo.ip.split(".");
					$("#ip1").val(ips[0]),
					$("#ip2").val(ips[1]),
					$("#ip3").val(ips[2]),
					$("#ip4").val(ips[3]),
					$("#dbport").val(dbinfo.dbport),
					$("#dbname").val(dbinfo.dbname),
					$("#dbuser").val(dbinfo.dbuser),
					$("#dbpasswd").val(dbinfo.dbpasswd),
					$("#dbID").val(dbinfo.id);
				}
			}
		});
		
		$("#updateDBForm").validate({
				debug:true,
				onsubmit:true,
				onfocusout:false,
				onkeyup:true,
				rules:{
					ip1:{
						required:true,digits:true
					},
					ip2:{
						required:true,digits:true
					},
					ip3:{
						required:true,digits:true
					},
					ip4:{
						required:true,digits:true
					},
					dbport:{
						required:true
					},
					dbname:{
						required:true
					},
					dbuser:{
						required:true
					},
					dbpasswd:{
						required:true
					}	
				},
				messages:{
					ip1:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ip2:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ip3:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ip4:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					dbport:{
						required:"请填写端口!"
					},
					dbname:{
						required:"请填写数据库名!"
					},
					dbuser:{
						required:"请填写用户名!"
					},
					dbpasswd:{
						required:"请填写密码!"
					}
				},
				errorPlacement: function(error, element) {
				    error.appendTo( element.parent("div").next("label") );
				  },
				submitHandler:function(){
					
					var ipvalue = $("#ip1").val() + "." + $("#ip2").val() + "."+ $("#ip3").val() + "." + $("#ip4").val();	
					$("#ipvalue").val(ipvalue); 
					$.ajax({
						type : 'POST',
						url : 'updateDB.action',
						data : {
							id:$("#dbID").val(),
							ip:ipvalue,
							dbport:$("#dbport").val(),
							dbname:$("#dbname").val(),
							dbuser:$("#dbuser").val(),
							dbpasswd:$("#dbpasswd").val()
						},
						dataType:'json',
						success : function(msg) {
							alert("更新成功！");							
						},
						error:function(msg){
							alert("通讯错误，更新失败！！");						
						}
					});
				}
			});
			
		$.ajax({
			type:"post",
			url:"getFTP.action",
			dataType:"json",
			success : function(data) {
				if(data.ftpinfo!=null){
					ftpinfo=data.ftpinfo;
					var ips=ftpinfo.ip.split(".");
					$("#ftpip1").val(ips[0]),
					$("#ftpip2").val(ips[1]),
					$("#ftpip3").val(ips[2]),
					$("#ftpip4").val(ips[3]),
					$("#ftpport").val(ftpinfo.port),						
					$("#ftpuser").val(ftpinfo.user),
					$("#ftppasswd").val(ftpinfo.passwd),
					$("#ftpID").val(ftpinfo.id);
				}
			}
		});
		
		$("#updateFTPForm").validate({
				debug:true,
				onsubmit:true,
				onfocusout:false,
				onkeyup:true,
				rules:{
					ftpip1:{
						required:true,digits:true
					},
					ftpip2:{
						required:true,digits:true
					},
					ftpip3:{
						required:true,digits:true
					},
					ftpip4:{
						required:true,digits:true
					},
					ftpport:{
						required:true
					},
					ftpuser:{
						required:true
					},
					ftppasswd:{
						required:true
					}	
				},
				messages:{
					ftpip1:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ftpip2:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ftpip3:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ftpip4:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					ftpport:{
						required:"请填写端口!"
					},
					ftpuser:{
						required:"请填写用户名!"
					},
					ftppasswd:{
						required:"请填写密码!"
					}
				},
				errorPlacement: function(error, element) {
				    error.appendTo( element.parent("div").next("label") );
				  },
				submitHandler:function(){
					
					var ftpipvalue = $("#ftpip1").val() + "." + $("#ftpip2").val() + "."+ $("#ftpip3").val() + "." + $("#ftpip4").val();	
					$("#ftpipvalue").val(ftpipvalue); 
					$.ajax({
						type : 'POST',
						url : 'updateFTP.action',
						data : {
							id:$("#ftpID").val(),
							ftpip:ftpipvalue,
							ftpport:$("#ftpport").val(),
							ftpuser:$("#ftpuser").val(),
							ftppasswd:$("#ftppasswd").val()
						},
						dataType:'json',
						success : function(msg) {
							alert("更新成功！");							
						},
						error:function(msg){
							alert("通讯错误，更新失败！！");						
						}
					});
				}
			});
			
			$.ajax({
				type:"post",
				url:"getClusterParameter.action",
				dataType:"json",
				success : function(data) {
					if(data.clusterParameter!=null){						
						clusterParameter=data.clusterParameter;						
						$("#interval").val(clusterParameter.interval),
						$("#clusterID").val(clusterParameter.id);
					}
				}
			});
			$("#updateClusterForm").validate({
				debug:true,
				onsubmit:true,
				onfocusout:false,
				onkeyup:true,
				rules:{
					interval:{
						required:true
					}	
				},
				messages:{
					interval:{
						required:"请填写聚类窗口!"
					}
				},
				submitHandler:function(){				
					$.ajax({
						type : 'POST',
						url : 'updateClusterParameter.action',
						data : {
							interval:$("#interval").val(),	
							id:$("#clusterID").val()					
						},
						dataType:'json',
						success : function(msg) {
							alert("更新成功！");							
						},
						error:function(msg){
							alert("通讯错误，更新失败！！");						
						}
					});
				}
			});
			
			$("#addPotForm").validate({
				debug:true,
				onsubmit:true,
				onfocusout:false,
				onkeyup:true,
				rules:{
					potip1:{
						required:true,digits:true
					},
					potip2:{
						required:true,digits:true
					},
					potip3:{
						required:true,digits:true
					},
					potip4:{
						required:true,digits:true
					}
				},
				messages:{
					potip1:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					potip2:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					potip3:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					potip4:{
						required:"请补全IP!",digits:"输入不是整数！"
					}		
				},
				errorPlacement: function(error, element) {
				    error.appendTo( element.parent("div").next("label") );
				  },
				submitHandler:function(){
					
					var potipvalue = $("#potip1").val() + "." + $("#potip2").val() + "."+ $("#potip3").val() + "." + $("#potip4").val();	
					$("#potipvalue").val(potipvalue); 
				    $.ajax({
						type : 'POST',
						url : 'addHoneyPot.action',
						data : {
							ip:potipvalue
						},
						dataType:'json',
						success : function(msg) {
							alert("添加成功！");
							$('#add_pot_modal').modal('hide');
							$("#HoneyHostList").trigger("reloadGrid");
						},
						error:function(msg){
							alter("添加失败");
							$('#add_pot_modal').modal('hide');
							$("#HoneyHostList").trigger("reloadGrid");
						}
					});
				}/*,
				  invalidHandler: function(event, validator) {
					    // 'this' refers to the form
					    var errors = validator.numberOfInvalids();
					    if (errors) {
					      var message = errors == 1
					        ? 'You missed 1 field. It has been highlighted'
					        : 'You missed ' + errors + ' fields. They have been highlighted';
					      
					      alert("请输入正确的IP格式！");
					    } else {
					      
					    }
					  }*/
			});		
			
		$("#addWhiteIpForm").validate({
				debug:true,
				onsubmit:true,
				onfocusout:false,
				onkeyup:true,
				rules:{
					whiteip1:{
						required:true,digits:true
					},
					whiteip2:{
						required:true,digits:true
					},
					whiteip3:{
						required:true,digits:true
					},
					whiteip4:{
						required:true,digits:true
					}
				},
				messages:{
					whiteip1:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					whiteip2:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					whiteip3:{
						required:"请补全IP!",digits:"输入不是整数！"
					},
					whiteip4:{
						required:"请补全IP!",digits:"输入不是整数！"
					}		
				},
				errorPlacement: function(error, element) {
				    error.appendTo( element.parent("div").next("label") );
				  },
				submitHandler:function(){
					
					var whiteipvalue = $("#whiteip1").val() + "." + $("#whiteip2").val() + "."+ $("#whiteip3").val() + "." + $("#whiteip4").val();	
					$("#whiteipvalue").val(whiteipvalue); 
					$.ajax({
						type : 'POST',
						url : 'addWhiteIp.action',
						data : {
							ip:whiteipvalue,
							remark:$("#whiteipremark").val(),
							//ifrunning:$("#ifrunning").val()
						},
						dataType:'json',
						success : function(msg) {	
							alert("更新成功！");	
							$("#add_whiteip_modal").modal('hide');
							$("#WhiteIpList").trigger("reloadGrid");
						},
						error:function(msg){
							alert("通讯错误，更新失败！！");						
						}
					});
				}
			});		
	
		$("#addWhiteDomainForm").validate({
			debug:true,
			onsubmit:true,
			onfocusout:false,
			onkeyup:true,
			rules:{
				whitedomain:{
					required:true
				}
			},
			messages:{
				whitedomain:{
					required:"请填写域名!"
				}
			},
			submitHandler:function(){
				$.ajax({
					type : 'POST',
					url : 'addWhiteDomain.action',
					data : {
						domain:$("#whitedomain").val(),
						remark:$("#whitedomainremark").val()			
					},
					dataType:'json',
					success : function(msg) {
						alert("更新成功！");	
						$("#add_whitedomain_modal").modal("hide");
						$("#WhiteDomainList").trigger("reloadGrid");
					},
					error:function(msg){
						alert("通讯错误，更新失败！！");						
					}
				});
			}
		});		
	
		var datagrid = jQuery("#UserList")
		.jqGrid(
				{
					url : "listUser.action",// 后端的数据交互程序，改为你的
					datatype : "json",// 前后交互的格式是json数据
					mtype : 'POST',// 交互的方式是发送httpget请求						
					colNames : [ '用户名','用户ID'],// 表格的列名
					colModel : [
							{
								name : 'username',
								index : 'username',
								width : 50,
								align : "center",
								sortable:true,
							},
							{
								name : 'userid',
								index : 'userid',
								width : 200,
								align : "center",
								sortable:true,
								hidden:true
							}
							],
//					autowidth:true,
//					editurl:"editData.action",
					rowNum:10,//每一页的行数
					height: 'auto',
					width:800,
					rowList:[10,20,30],
					pager: '#UserPager',
					sortname: 'id',
					viewrecords: true,
					sortorder: "desc",
					multiselect: true,  //可多选，出现多选框 
				    multiselectWidth: 35, //设置多选列宽度 
					jsonReader: {//读取后端json数据的格式
					root: "dataList",//保存详细记录的名称
					total: "total",//总共有页
					page: "page",//当前是哪一页
					records: "records",//总共记录数
					repeatitems: false
					},
					caption: "管理员列表",//表格名称,
					jsonReader : {// 读取后端json数据的格式
						root : "dataList",// 保存详细记录的名称
						// total: "total",//总共有页
						// page: "page",//当前是哪一页
						records : "records",// 总共记录数
						repeatitems : false
					}
				}
				
				
		);

	//datagrid.jqGrid('filterToolbar',{searchOperators:true});			
	datagrid.jqGrid('navGrid','#UserPager',{
			edit : false,
			add : false,
			search:false,
			del : false}).jqGrid('navButtonAdd',"#UserPager",{
					title:'添加',
					caption:"添加",
					id:"add_UserList",
					onClickButton : function addModal(){
						// 配置对话框
							$('#register_modal').modal();								
					},
					position:"first"
				}).jqGrid('navButtonAdd',"#UserPager",{
					title:'删除',
					caption:"删除",	
					id:"delete_user",
					onClickButton:deleteUser,
					position:"first"
				});
	
	function deleteUser() {
	
	        var sels = $("#UserList").jqGrid('getGridParam','selarrrow'); 
	        if(sels==""){
	           alert("请选择要删除的项!");
	        }else{ 
	        	var selectedIDs={};
	        	$.each(sels,function(i,n){ 
	              if(sels[i]!=""){ 
	            	  var rowData = $("#UserList").jqGrid("getRowData", sels[i]);
	            	  if(rowData.username!="_imiss_botnet"){
	            		  selectedIDs["ids[" + i + "]"]=rowData.userid;
	            	  }
	              } 
	        	}); 
	
	           if(confirm("您是否确认删除？")){ 
	            $.ajax({ 
	              type: "POST", 
	              url: "deleteUser.action", 
	              data: selectedIDs, 
	              success: function(msg){ 
	            	alert("删除成功！");
					$("#UserList").trigger("reloadGrid");
	                   if(msg!=0){ 
	                       var arr = msg.split(','); 
	                       $.each(arr,function(i,n){ 
	                             if(arr[i]!=""){ 
	                                 $("#UserList").jqGrid('delRowData',n);  
	                             } 
	                       }); 
	                       $().message("已成功删除!"); 
	                   }else{ 
	                       $().message("操作失败！"); 
	                   } 
	              } 
	            }); 
	           } 
	        } 
	}

		
	var datagrid = jQuery("#HoneyHostList")
			.jqGrid(
					{
						url : "listHoneyPot.action",// 后端的数据交互程序，改为你的
						datatype : "json",// 前后交互的格式是json数据
						mtype : 'POST',// 交互的方式是发送httpget请求						
						colNames : [ '序号', 'IP','编号'],// 表格的列名
						colModel : [
								{
									name : 'order',
									index : 'order',
									width : 50,
									align : "center",
									sortable:true,
								},// 每一列的具体信息，index是索引名，当需要排序时，会传这个参数给后端
								{
									name : 'ip',
									index : 'ip',
									width : 150,
									align : "center",
									sortable:true
								},
								{
									name : 'id',
									index : 'id',
									width : 200,
									align : "center",
									sortable:true,
									hidden:true
								}
								],
//						autowidth:true,
						editurl:"editData.action",
						rowNum:10,//每一页的行数
						height: 'auto',
						width:800,
						rowList:[10,20,30],
						pager: '#HoneyHostPager',
						sortname: 'id',
						viewrecords: true,
						sortorder: "desc",
						multiselect: true,  //可多选，出现多选框 
					    multiselectWidth: 35, //设置多选列宽度 
						jsonReader: {//读取后端json数据的格式
						root: "dataList",//保存详细记录的名称
						total: "total",//总共有页
						page: "page",//当前是哪一页
						records: "records",//总共记录数
						repeatitems: false
						},
						caption: "蜜罐主机列表",//表格名称,
						jsonReader : {// 读取后端json数据的格式
							root : "dataList",// 保存详细记录的名称
							// total: "total",//总共有页
							// page: "page",//当前是哪一页
							records : "records",// 总共记录数
							repeatitems : false
						}
					}
					
					
			);

	//datagrid.jqGrid('filterToolbar',{searchOperators:true});			
	datagrid.jqGrid('navGrid','#HoneyHostPager',{
			edit : false,
			add : false,
			search:false,
			del : false}).jqGrid('navButtonAdd',"#HoneyHostPager",{
					title:'添加',
					caption:"添加",
					id:"add_HoneyPotList",
					onClickButton : function addModal(){
						// 配置对话框
							$('#add_pot_modal').modal();								
					},
					position:"first"
				
			
				}).jqGrid('navButtonAdd',"#HoneyHostPager",{
					title:'删除',
					caption:"删除",	
					id:"delete_pot",
					onClickButton:deletePot,
					position:"first"
				});
	
	function deletePot() {

	        var sels = $("#HoneyHostList").jqGrid('getGridParam','selarrrow'); 
	        if(sels==""){
	           alert("请选择要删除的项!");
	        }else{ 
	        	var selectedIDs={};
	        	$.each(sels,function(i,n){ 
                  if(sels[i]!=""){ 
                	  var rowData = $("#HoneyHostList").jqGrid("getRowData", sels[i]);
                	  selectedIDs["ids[" + i + "]"]=rowData.id;
                  } 
	        	}); 

	           if(confirm("您是否确认删除？")){ 
	            $.ajax({ 
	              type: "POST", 
	              url: "delHoneyPot.action", 
	              data: selectedIDs, 
	              success: function(msg){ 
	            	alert("删除成功！");
					$("#HoneyHostList").trigger("reloadGrid");
	                   if(msg!=0){ 
	                       var arr = msg.split(','); 
	                       $.each(arr,function(i,n){ 
	                             if(arr[i]!=""){ 
	                                 $("#HoneyHostList").jqGrid('delRowData',n);  
	                             } 
	                       }); 
	                       $().message("已成功删除!"); 
	                   }else{ 
	                       $().message("操作失败！"); 
	                   } 
	              } 
	            }); 
	           } 
	        } 
	}
	
	var datagrid = jQuery("#WhiteIpList")
	.jqGrid(
			{
				url : "listWhiteIp.action",// 后端的数据交互程序，改为你的
				datatype : "json",// 前后交互的格式是json数据
				mtype : 'POST',// 交互的方式是发送httpget请求						
				colNames : [ '序号', 'IP','备注','编号'],// 表格的列名
				colModel : [
						{
							name : 'order',
							index : 'order',
							width : 50,
							align : "center",
							sortable:true,
						},// 每一列的具体信息，index是索引名，当需要排序时，会传这个参数给后端
						{
							name : 'ip',
							index : 'ip',
							width : 150,
							align : "center",
							sortable:true
						},
						{
							name:'remark',
							index:'remark',
							width:150,
							align:'center'
						},
						{
							name : 'id',
							index : 'id',
							width : 200,
							align : "center",
							sortable:true,
							hidden:true
						}
						],
//				autowidth:true,
				editurl:"editData.action",
				rowNum:10,//每一页的行数
				height: 'auto',
				width:800,
				rowList:[10,20,30],
				pager: '#WhiteIpPager',
				sortname: 'id',
				viewrecords: true,
				sortorder: "desc",
				multiselect: true,  //可多选，出现多选框 
			    multiselectWidth: 35, //设置多选列宽度 
				jsonReader: {//读取后端json数据的格式
				root: "dataList",//保存详细记录的名称
				total: "total",//总共有页
				page: "page",//当前是哪一页
				records: "records",//总共记录数
				repeatitems: false
				},
				caption: "IP白名单列表",//表格名称,
				jsonReader : {// 读取后端json数据的格式
					root : "dataList",// 保存详细记录的名称
					// total: "total",//总共有页
					// page: "page",//当前是哪一页
					records : "records",// 总共记录数
					repeatitems : false
				}
			}
			
			
	);

	//datagrid.jqGrid('filterToolbar',{searchOperators:true});			
	datagrid.jqGrid('navGrid','#WhiteIpPager',{
		edit : false,
		add : false,
		search:false,
		del : false}).jqGrid('navButtonAdd',"#WhiteIpPager",{
				title:'添加',
				caption:"添加",
				id:"add_WhiteIpList",
				onClickButton : function addModal(){
					// 配置对话框
						$('#add_whiteip_modal').modal();								
				},
				position:"first"
			
		
			}).jqGrid('navButtonAdd',"#WhiteIpPager",{
				title:'删除',
				caption:"删除",	
				id:"delete_white_ip",
				onClickButton:deleteWhiteIP,
				position:"first"
			});
	
	function deleteWhiteIP() {
		
		    var sels = $("#WhiteIpList").jqGrid('getGridParam','selarrrow'); 
		    if(sels==""){
		       alert("请选择要删除的项!");
		    }else{ 
		    	var selectedIDs={};
		    	$.each(sels,function(i,n){ 
		          if(sels[i]!=""){ 
		        	  var rowData = $("#WhiteIpList").jqGrid("getRowData", sels[i]);
		        	  selectedIDs["ids[" + i + "]"]=rowData.id;
		          } 
		    	}); 
		
		       if(confirm("您是否确认删除？")){ 
		        $.ajax({ 
		          type: "POST", 
		          url: "delWhiteIp.action", 
		          data: selectedIDs, 
		          success: function(msg){ 
		        	alert("删除成功！");
					$("#WhiteIpList").trigger("reloadGrid");
		               if(msg!=0){ 
		                   var arr = msg.split(','); 
		                   $.each(arr,function(i,n){ 
		                         if(arr[i]!=""){ 
		                             $("#WhiteIpList").jqGrid('delRowData',n);  
		                         } 
		                   }); 
		                   $().message("已成功删除!"); 
		               }else{ 
		                   $().message("操作失败！"); 
		               } 
		          } 
		        }); 
		       } 
		    } 
		}
	
	var datagrid = jQuery("#WhiteDomainList")
	.jqGrid(
			{
				url : "listWhiteDomain.action",// 后端的数据交互程序，改为你的
				datatype : "json",// 前后交互的格式是json数据
				mtype : 'POST',// 交互的方式是发送httpget请求						
				colNames : [ '序号', '域名','备注','编号'],// 表格的列名
				colModel : [
						{
							name : 'order',
							index : 'order',
							width : 50,
							align : "center",
							sortable:true,
						},// 每一列的具体信息，index是索引名，当需要排序时，会传这个参数给后端
						{
							name : 'domain',
							index : 'domain',
							width : 150,
							align : "center",
							sortable:true
						},
						{
							name : 'remark',
							index : 'remark',
							width : 150,
							align : "center",
							sortable:true
						},
						{
							name : 'id',
							index : 'id',
							width : 200,
							align : "center",
							sortable:true,
							hidden:true
						}
						],
//				autowidth:true,
				editurl:"editData.action",
				rowNum:10,//每一页的行数
				height: 'auto',
				width:800,
				rowList:[10,20,30],
				pager: '#WhiteDomainPager',
				sortname: 'id',
				viewrecords: true,
				sortorder: "desc",
				multiselect: true,  //可多选，出现多选框 
			    multiselectWidth: 35, //设置多选列宽度 
				jsonReader: {//读取后端json数据的格式
				root: "dataList",//保存详细记录的名称
				total: "total",//总共有页
				page: "page",//当前是哪一页
				records: "records",//总共记录数
				repeatitems: false
				},
				caption: "域名白名单列表",//表格名称,
				jsonReader : {// 读取后端json数据的格式
					root : "dataList",// 保存详细记录的名称
					// total: "total",//总共有页
					// page: "page",//当前是哪一页
					records : "records",// 总共记录数
					repeatitems : false
				}
			}
			
			
	);

	//datagrid.jqGrid('filterToolbar',{searchOperators:true});			
	datagrid.jqGrid('navGrid','#WhiteDomainPager',{
		edit : false,
		add : false,
		search:false,
		del : false}).jqGrid('navButtonAdd',"#WhiteDomainPager",{
				title:'添加',
				caption:"添加",
				id:"add_WhiteDomainList",
				onClickButton : function addModal(){
					// 配置对话框
						$('#add_whitedomain_modal').modal();								
				},
				position:"first"
			
		
			}).jqGrid('navButtonAdd',"#WhiteDomainPager",{
				title:'删除',
				caption:"删除",	
				id:"delete_white_domain",
				onClickButton:deleteWhiteDomain,
				position:"first"
			});
	
	function deleteWhiteDomain() {
		
		    var sels = $("#WhiteDomainList").jqGrid('getGridParam','selarrrow'); 
		    if(sels==""){
		       alert("请选择要删除的项!");
		    }else{ 
		    	var selectedIDs={};
		    	$.each(sels,function(i,n){ 
		          if(sels[i]!=""){ 
		        	  var rowData = $("#WhiteDomainList").jqGrid("getRowData", sels[i]);
		        	  selectedIDs["ids[" + i + "]"]=rowData.id;
		          } 
		    	}); 
		
		       if(confirm("您是否确认删除？")){ 
		        $.ajax({ 
		          type: "POST", 
		          url: "delWhiteDomain.action", 
		          data: selectedIDs, 
		          success: function(msg){ 
		        	alert("删除成功！");
					$("#WhiteDomainList").trigger("reloadGrid");
		               if(msg!=0){ 
		                   var arr = msg.split(','); 
		                   $.each(arr,function(i,n){ 
		                         if(arr[i]!=""){ 
		                             $("#WhiteDomainList").jqGrid('delRowData',n);  
		                         } 
		                   }); 
		                   $().message("已成功删除!"); 
		               }else{ 
		                   $().message("操作失败！"); 
		               } 
		          } 
		        }); 
		       } 
		    } 
		}

	
	
}//function结束
);//$()结束



