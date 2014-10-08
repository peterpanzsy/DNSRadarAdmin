$(document).ready(function(){

	backtop();


});

function logout(){
	$.ajax({
		url:'logout.action',
		type:'post',
		dataType:'json',
		success:function(data){
//			alert(data.flag);
			if(data.flag=="true"){
				
//				location.href="#";
				window.location.reload();
			}else{
				alert("登出失败！");
//				window.location.reload();
				//$('#register_modal').modal('hide');
			}
		}
	});

}
function backtop(){
    var backtop = $("<a class='backTop'>∧</a>");
    $("body").append(backtop);
      
    var fn = function(){
    $('html,body').animate({
        scrollTop: '0px'
        }, 400);
        return false;
    };
    $('.backTop').bind('click',fn);
      
    $(window).scroll(function () {
        var scrollt = $(window).scrollTop();
        if ( scrollt > 900 ){
            $(".backTop").fadeIn("slow");
        } else {
            $(".backTop").fadeOut("slow");
        }
    });
}