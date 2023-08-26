<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

target =localStorage.getItem('admin-user');

localStorage.removeItem('admin-user');


let msg = "${msg}";

if (msg) {

	if (msg === "delete-success") {

		alert("삭제 되었습니다.")
	}else if ( msg==="delete-failed"){
		alert("삭제를 실패하였습니다.")
	}else if ( msg==="update-success"){
		alert("수정되었습니다.")
	}else if ( msg==="update-failed"){
		alert("수정이 실패하였습니다.")
	}

	
}

if(target){
	
location.href = target;
}else{
	
	location.href= document.referrer;
}

</script>