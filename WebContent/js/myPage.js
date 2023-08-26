
var temp = "${paging}";


$(".btn_refund_order").click(function refundOrder(){

    if(confirm("해당 주문을 환불하시겠습니까?")){

        let imp_uid = $(this).data("imp-uid");
        let total_price= $(this).data("total-price");

        let reqUrl = "/kgCoffee/order/api/refund.do";

     
        
       

        $.ajax({
            type : "POST",
            url : reqUrl,
            data : {
                // 저장할 pay 정보 넣어서 서버 보내서 DB 테이블 저장
                imp_uid : imp_uid,
                total_price: total_price,


            },
            success:function(res_data) {

                
                var res = JSON.parse(res_data);
                
               
                
                var msg = res.msg;
         
                if(!(msg===null)){

                    if(msg==="refund-success"){
                        alert("환불이 완료되었습니다.");
                        location.reload(true);

                    }else if(msg==="delete-faild"){

                        alert("결제 실패.");

                    }else if(msg==="refund-faild"){
                        alert("refund-faild");

                    }

                }

            }
        })

        


    }
    
    

})

//아코디언 메뉴 클릭 이벤트
function arccodionMenu(orderId){
    $("#content"+orderId).toggleClass("show");
}


//회원 수정 후 메세지

const update_msg = '${update_msg}';

if (update_msg === 'update-success') {
    alert('${loginUser.user_name}' + '님 수정 되었습니다.');
} else if (update_msg === 'update-failed') {
    alert('${loginUser.user_name}' + '님 수정을 실패했습니다. 다시 입력해주세요.');
    history.back();
}