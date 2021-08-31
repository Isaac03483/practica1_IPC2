function captura(){

    var tipoPieza = document.getElementById('selectpieza').value;
    alert(tipoPieza);

    document.getElementById().value = '<%=%>';
}

function habilitarNombre(){
    if(document.getElementById('cbox1').checked)
        document.getElementById('txtnombre').disabled= true;
    else
       
        document.getElementById('txtnombre').disabled = false;
}