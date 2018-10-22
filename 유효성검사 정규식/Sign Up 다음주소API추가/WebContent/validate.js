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