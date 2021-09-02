function captura(){

    var tipoPieza = document.getElementById('selectpieza').value;
    alert(tipoPieza);

    document.getElementById().value = '<%=%>';
}

function habilitarInput(check) {
    if(check.checked){
        document.getElementById("textocontraAntigua").disabled= false;
        document.getElementById("textocontraNueva").disabled= false;
        document.getElementById("textocontraVerificacion").disabled= false;
        document.getElementById("textocontraAntigua").setAttribute("required", "");
        document.getElementById("textocontraNueva").setAttribute("required", "");
        document.getElementById("textocontraVerificacion").setAttribute("required", "");
        check.value="1";
        
    } else {
        document.getElementById("textocontraAntigua").disabled= true;
        document.getElementById("textocontraNueva").disabled= true;
        document.getElementById("textocontraVerificacion").disabled= true;
        document.getElementById("textocontraAntigua").value= "";
        document.getElementById("textocontraNueva").value= "";
        document.getElementById("textocontraVerificacion").value= "";
        document.getElementById("textocontraVerificacion").removeAttribute("required");
        document.getElementById("textocontraAntigua").removeAttribute("required");
        document.getElementById("textocontraNueva").removeAttribute("required");
        
        check.value="0";
    }
}

function habilitarSelect(check){
    if(check.checked){
        document.getElementById("area_usuario").disabled=false;
        check.value="1";
    }else {
        document.getElementById("area_usuario").disabled=true;
        check.value="0";
    }
    alert(check.value);
}