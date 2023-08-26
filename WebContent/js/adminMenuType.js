/**
 * 
 */



	/*메뉴리스트 비동기처리*/

$(".text > input").change(searchEvent);
	
	
	function searchEvent(n,menuName){
		if(!(n>0)){
			n=1;
		}
		
		console.log(menuName)
	if(!menuName){
		menuName=""
	}



		var url= "/kgCoffee/admin/admingetSerchmenu.do?";
		
		var param = "page="+n+"&menuName="+menuName;
		
		$("input:checkbox").each(function(index) {
			if ($(this).is(":checked") == true) {

				
				
				
			
				 param += "&"+$(this).data("type") + "=" + $(this).data("value");
				 
				 
				
			}
			
	

		})
		
			var reqUrl = url+ param;
		
		

				console.log(reqUrl);
				$.ajax({
					url : reqUrl,
					type : "GET",
					data : 'JSON',
					success : function(data) {
						
						
						
						
						
						
						var newEl = data;
						
						
						
						$("div.page_wrap").html(data.toString());
							
						$(".active-li").removeClass("active-li");
						$(".page"+n).addClass("active-li");

						addModal();
						
						history.pushState('','',"/kgCoffee/admin/adminMenu.do?"+param);
					
						

			}})


	} 
	
	function activeLi(n){
	
	}