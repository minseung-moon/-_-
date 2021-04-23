(()=>{
	const submit = document.getElementById("submit");
	submit.addEventListener('click', function(event){
		const check = false;
		
		const no = document.getElementById("no");
		const code = document.getElementById("code");
		const sdate = document.getElementById("sdate");
		const status = document.querySelectorAll(".status");
		const ldate = document.getElementById("ldate");
		const reulst = document.querySelectorAll(".result");
		
		if(!no.value.trim() || isNaN(no.value) || no.value.trim().length !== 4){
			alert("환자번호를 제대로 입력해주세요!");
			no.focus();
		}else if(code.value === "검사명"){
			alert("환자 검사 코드를 선택해주세요!");
			code.focus();
		}else if(!sdate.value.trim() || isNaN(sdate.value) || sdate.value.trim().length !== 8){
			alert("검사시작일자를 제대로 입력해주세요!");
			sdate.focus();
		}else if(!status[0].checked && !status[1].checked) {
			alert("검사상태를 제대로 선택해주세요!");
		}else if(!ldate.value.trim() || isNaN(ldate.value) || ldate.value.trim().length !== 8){
			alert("검사완료일자를 제대로 입력해주세요!");
			ldate.focus();
		}else if(!reulst[0].checked && !reulst[1].checked && !reulst[2].checked) {
			alert("검사결과를 제대로 선택해주세요!");
		}else{
			check = true;
		}
		if(!check)event.preventDefault();
	});
})();