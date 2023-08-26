<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>

<link rel="stylesheet" href="/kgCoffee/css/header_style.css"
	type="text/css">
<link rel="stylesheet" href="/kgCoffee/css/userModify.css?after"
	type="text/css">

<script src="/kgCoffee/js/jquery-3.7.0.min.js"></script>
<!-- jquery -->

</head>
<body>

	<%@include file="../../include/header.jsp"%>

	<section class="modify" id="modify">

		<div class="modify-mg">

			<ul class="modifyList">
				<li class="modify_name">
					<h3>회원 정보 수정</h3>
				</li>
			</ul>


			<ul class="modifyList">

				<li class="modifyView">

					<div class="modify-form">
						<form id="f1"
							action="/kgCoffee/mypage/userUpdate.do?user_id=${vo.user_id}"
							method="post">

							<table class="modify-table">

								<tr>
									<th>아이디</th>
									<td>${loginUser.user_id}</td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td><input type="password" id="pw" name="user_pw"
										class="user_pw" placeholder="영문, 숫자, 특수문자 중 2가지를 혼합해주세요."
										required></td>
								</tr>
								<tr>
									<th>이름</th>
									<td><input type="text" id="name" name="user_name"
										value="${vo.user_name}" required></td>
								</tr>
								<tr>
									<th>생년월일</th>
									<td><input type="date" name="birthday"
										value="${vo.birthday}" required></td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td><input type="text" id="tel" name="tel"
										value="${vo.tel}" required></td>
								</tr>

							</table>

							<div class="modify-button">
								<button type="submit" class="btn_design"
									onClick="return check();">확인</button>
								&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn_design" id="go-back">취소</button>
							</div>

						</form>
					</div>


				</li>
				<!-- modifyView end -->

			</ul>
			<!-- modifyList end -->

		</div>
		<!-- modify-mg div end -->

	</section>

	<%@include file="../../include/footer.jsp"%>

	<script>
		
		console.log('${msg}');
		
		const msg = '${msg}';
		
		if (msg === 'pw_success') {
		    
		} else if (msg === 'pw_fail') {
			alert('비밀번호가 틀렸습니다 다시 입력해주세요.');
			history.back();
		}
		
		
		document.getElementById('go-back').addEventListener('click', () => {
			window.history.back();
		});
		
		function check() {
			
				var pw = $("#pw").val();
			
				var name = $("#name").val();
				var tel = $("#tel").val();
				
			 	var num = pw.search(/[0-9]/g);
				var eng = pw.search(/[a-z]/ig);
				var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
				
	
				
				var nameReg = /^[ㄱ-ㅎ|가-힣]+$/;
				
				var telReg = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/;
				
		
		
				
				/* 비밀번호 */
				/* 영문,숫자,특수문자 중 2가지 혼합 (영문,숫자 = 통과) (특문,숫자 = 통과) */
				if(pw.length < 5 || pw.length > 10) {
					alert("비밀번호를 5자리 ~ 10자리 이내로 입력해주세요.");
					return false;
				}else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
					alert("비밀번호에 영문, 숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
					return false;
				}
				
				
				/* 이름 */
				if(!nameReg.test(name)) {
					alert("이름은 한글로 입력해주세요.");
					return false;
				}
				
				
				/* 전화번호 */
				if(!telReg.test(tel)) {
					alert("전화번호 형식으로 입력해주세요.");
					return false;
				} else {
					return true;
				}
		}
		
		
	</script>



</body>
</html>