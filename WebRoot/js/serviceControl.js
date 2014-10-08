function restartWindows(){
		if (window.confirm("您真的确定要重启服务器吗? 请确认！")) {
			$.ajax({
				type:"post",
				url:"restartWindows.action",
				dataType:"json",
				success : function(data) {
					if(data.re=="success"){
						alert("服务已重启！");
					}else{
						alert("服务重启失败！");
					}
					
				}
			});
		}else{
		}
	}