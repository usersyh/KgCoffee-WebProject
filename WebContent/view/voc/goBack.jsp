<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	target = localStorage.getItem('history');
	localStorage.removeItem('history');

	let msg = "${msg}";

	if (msg) {

		if (msg === "update-success") {

			alert("글이 수정되었습니다.");
			history.pushState('', '', target);
			target = localStorage.getItem('history2');
			localStorage.removeItem('history2');

		} else if (msg === "update-failed") {

			alert("글 수정 실패\n관리자에게 문의하세요.");

		} else if (msg === "delete-success") {

			alert("글이 삭제되었습니다.");

		} else if (msg === "delete-failed") {

			alert("글 삭제 실패\n관리자에게 문의하세요.");

		} else if (msg === "insert-success") {

			alert("글이 작성되었습니다.");

		} else if (msg === "insert-failed") {

			alert("글 작성 실패\n관리자에게 문의하세요.");

		} else if (msg === "reInsert-success") {

			alert("답글이 작성되었습니다.");
			let bunho = "${bunho}";

		
			target=target.replace(/bunho=\d*/g, "bunho=" + bunho);
			

		} else if (msg === "reInsert-failed") {

			alert("답글 작성 실패\n관리자에게 문의하세요.");

		}

	}

	location.href = target;
</script>