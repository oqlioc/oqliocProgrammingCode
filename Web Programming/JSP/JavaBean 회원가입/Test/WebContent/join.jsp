<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
   request.setCharacterEncoding("UTF-8"); 
%>
<title>회원가입 TEST1</title>
</head>
<!-- <script language="javascript">
	function validate() {
		var test1 = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 비번을 검사할 유효성검사식
		var test2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 이메일이 적합한지 검사할 유효성검사식
		var test3 = /^[가-힣]{2,}$/;      //이름의 유효성 검사

		var id = document.getElementById("uid");  // 아이디
		var pw = document.getElementById("upw");  // 비번
		var email = document.getElementById("uemail"); // 이메일
		var name = document.getElementById("uname"); // 이름
		var num1 = document.getElementById("unum1"); // 주민등록번호 앞자리
		var num2 = document.getElementById("unum2"); // 주민등록번호 뒷자리
		var postcode = document.getElementById("sample4_postcode"); // 우편번호
		var roadAddress = document.getElementById("sample4_roadAddress"); // 도로명주소
		var jibunAddress = document.getElementById("sample4_jibunAddress"); // 지번주소

		var arrNum1 = new Array(); // 주민등록번호 앞자리
		var arrNum2 = new Array(); // 주민등록번호 뒷자리

		//====================================================이후 비교

		if (!check(test1, id, "아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
			return false;
		} // 아이디 비교

		if (!check(test1, pw, "패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
			return false;
		} // 비번 비교

		if (join.upw.value != join.checkupw.value) {
			alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
			join.checkupw.value = "";
			join.checkupw.focus();
			return false;
		} // 비번 확인

		if (email.value == "") {
			alert("이메일을 입력해 주세요");
			email.focus();
			return false;
		} // 이메일 입력 유무

		if (!check(test2, email, "적합하지 않은 이메일 형식입니다.")) {
			return false;
		} // 이메일 유효성검사식
	
		if (!check(test3, name, "이름을 제대로 입력하세요")) {
	    	return false;
	    }  // 이름 유효성검사식
		
		for (var i = 0; i < num1.value.length; i++) {
			arrNum1[i] = num1.value.charAt(i);
		} // 주민등록번호 앞자리를 num1의 문자열 길이 만큼

		for (var i = 0; i < num2.value.length; i++) {
			arrNum2[i] = num2.value.charAt(i);
		} // 주민등록번호 뒷자리를 num1의 문자열 길이 만큼

		var tempSum = 0;

		for (var i = 0; i < num1.value.length; i++) {
			tempSum += arrNum1[i] * (2 + i);
		} // 주민등록번호의 공식을 적용하여 앞자리를 모두 계산하여 더함

		for (var i = 0; i < num2.value.length - 1; i++) {
			if (i >= 2) {
				tempSum += arrNum2[i] * i;
			} else {
				tempSum += arrNum2[i] * (8 + i);
			}
		} // 주민등록번호의 공식을 적용하여 뒷자리를 모두 계산하여 더함

		if ((11 - (tempSum % 11)) % 10 != arrNum2[6]) {
			alert("올바른 주민번호가 아닙니다.");
			num1.value = "";
			num2.value = "";
			num1.focus();
			return false;
		} // 주민등록번호 비교

		//=========================주민등록번호를 이용하여 생일 입력
		if (arrNum2[0] == 1 || arrNum2[0] == 2) { // 2000년 이전
			var y = parseInt(num1.value.substring(0, 2)); // 2자리씩
			var m = parseInt(num1.value.substring(2, 4));
			var d = parseInt(num1.value.substring(4, 6));
			join.year.value = 1900 + y; // 년
			join.month.value = m; // 월
			join.day.value = d; // 일
		} else if (arrNum2[0] == 3 || arrNum2[0] == 4) { // 2000년 이후
			var y = parseInt(num1.value.substring(0, 2));
			var m = parseInt(num1.value.substring(2, 4));
			var d = parseInt(num1.value.substring(4, 6));
			join.year.value == 2000 + y;
			join.month.value = m;
			join.day.value = d;
		}

		if (join.inter[0].checked == false && join.inter[1].checked == false
				&& join.inter[2].checked == false
				&& join.inter[3].checked == false
				&& join.inter[4].checked == false) {
			alert("관심분야를 골라주세요");
			return false;
		} // 체크박스 미 체크 비교

		if (join.self.value == "") {
			alert("자기소개를 적어주세요");
			join.self.focus();
			return false;
		} // 자기소개창 미입력 시
		
		if (postcode.value == "") {
			alert("우편번호을 입력해 주세요");
			postcode.focus();
			return false;
		} // 우편번호 입력 유무
		
		if (roadAddress.value == "") {
			alert("도로명주소을 입력해 주세요");
			roadAddress.focus();
			return false;
		} // 도로명주소 입력 유무
		
		if (jibunAddress.value == "") {
			alert("지번주소을 입력해 주세요");
			jibunAddress.focus();
			return false;
		} // 지번주소 입력 유무
	}
	//==================아이디, 비번, 이메일 비교
	function check(test1, what, message) {
		if (test1.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
		//return false;
	}
</script> -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<style>
.btnhover {
	color: #116688;
}

.btnhover:hover {
	color: #000000;
}

.qwer th {
	padding: 10px;
	color: #116688;
	border-bottom: 3px solid #116688;
	text-align: left;
}

.qwer td {
	color: #666699;
	padding: 10px;
	border-bottom: 1px solid #DDDDDD;
}

.qwer tr:hover td {
	color: #000000;
}
</style>
<body>
	<form method="post"	action="JavaBean.jsp">
		<table class="qwer" align="center" style="border-collapse: collapse;"
			width="800" ehight="250" border="1">
			<tr>
				<th align="center" colspan="2">회원 기본 정보</th>
			</tr>
			<tr>
				<td id="qwer" width="30%" align="center">아이디:</td>
				<td width="70%"><input type="text" name="uid" id="uid"
					maxlength="12">4~12자의영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td width="30%" align="center">비밀번호:</td>
				<td width="70%"><input type="password" name="upw" id="upw"
					maxlength="12">4~12자의영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td width="30%" align="center">비밀번호 확인:</td>
				<td width="70%"><input type="password" name="checkupw"
					id="checkupw" maxlength="12"></td>
			</tr>
			<tr>
				<td width="30%" align="center">메일 주소:</td>
				<td width="70%"><input type="text" name="uemail" id="uemail"
					size="30"> 예)id@domain.com</td>
			</tr>
			<tr>
				<td width="30%" align="center">이름:</td>
				<td width="70%"><input type="text" name="uname" id="uname"
					size="30"></td>
			</tr>
		</table>
		<table class="qwer" align="center" style="border-collapse: collapse;"
			width="800" ehight="250" border="1">
			<tr>
				<th align="center" colspan="2">개인 신상 정보</th>
			</tr>
			<tr>
				<td width="30%" align="center">주민등록번호:</td>
				<td width="70%"><input type="text" name="unum1" id="unum1"
					size="10" maxlength="6">-</input><input type="password"
					name="unum2" id="unum2" size="10" maxlength="7"></input> 예)
					123456-1234567
			</tr>
			<tr>
				<td width="30%" align="center">생일:</td>
				<td width="70%"><input type="text" name="year" id="year"
					size="15">년 <select name="month" id="month">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select>월 <select name="day" id="day">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select>일</td>
			</tr>
			<tr>
				<td width="30%" align="center">관심분야:</td>
				<td width="70%" class="checks">
					<input type="checkbox" name="inter"> <label for="q">컴퓨터</label>
					<input type="checkbox" name="inter"> <label for="w">인터넷</label>
					<input type="checkbox" name="inter"> <label for="e">여행</label>
					<input type="checkbox" name="inter"> <label for="r">영화감상</label>
					<input type="checkbox" name="inter"> <label for="t">음악감상</label>
				</td>
			</tr>
			<tr >
				<td width="30%" align="center"
					>자기소개:</td>
				<td width="70%"><textarea
						rows="5" cols="70" name="self"></textarea>
			</tr>
			<tr>
				<td width="30%" align="center"
					style="border-bottom: 1px solid #000000">주소:</td>
				<td width="70%"  style="border-bottom: 1px solid #000000">
				<input type="text" id="sample4_postcode" placeholder="우편번호" size="50%" disabled >
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btnhover"><br>
					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" size="50%" disabled >
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" size="50%" disabled >
					<span id="guide" style="color: #999"></span>
					</td>
			</tr>
		</table>
		<table align="center"
			style="border-collapse: collapse; margin-top: 5px;" width="800"
			height="250">
			<tr>
				<td style="background-color: white" align="center" colspan="2">
				<input class="btnhover" type="submit" name="submit" value="회원가입">
					<input class="btnhover" type="reset" name="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>