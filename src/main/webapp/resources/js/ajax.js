oReq = null;

window.onload = function() {
    document.getElementById('btnEnviar').onclick = enviar;
    //console.log(enviar);
    // Evita a digitação de ponto/vírgula
	const intRx = /\d/,
	    integerChange = (event) => {
	      if ((event.key.length > 1) || ((event.key === "-") && (!event.currentTarget.value.length)) || intRx.test(event.key))
	          return;
	      event.preventDefault();
	    };

	for (let input of document.querySelectorAll('input[type="number"][step="1"]'))
	     input.addEventListener("keydown", integerChange);
}

function enviar() {
	
	var mtdOperation = document.getElementsByName('mtdCalc');
	
	for (var i = 0; i < mtdOperation.length; i++) {
		if (mtdOperation[i].checked) {
//			console.log("Operacao escolhida: " + mtdOperation[i].value);
			var sltOperation = mtdOperation[i].value;
		}
	}
	
//	console.log(sltOperation);
	
    oReq = new XMLHttpRequest();
	oReq.onreadystatechange = callback;
	oReq.open("POST", "processa", true);
	oReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	oReq.send("txtnum1=" + document.getElementById("idnum1").value +
			  "&txtnum2=" + document.getElementById("idnum2").value +
			  "&metodoCalculo=" + sltOperation); 
}

function callback() {
	if (oReq.readyState == 4) {
		if (oReq.status == 200) {
			document.getElementById("idresp").value = oReq.responseText;
		} else {
			alert("Erro: " + oReq.status + " - " + oReq.statusText);
		}
	}
}
