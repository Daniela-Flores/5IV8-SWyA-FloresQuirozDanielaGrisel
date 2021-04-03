/*Funcion para validar ingreso de números y puntos */

function validarn(evt){
    if(window.event){
        keynum= evt.keyCode;
    }
    else{
        keynum= evt.which;
    }

    if((keynum>47 && keynum <58 )||keynum == 8|| keynum == 13||keynum == 46)
    {
        return true;
    }
    else{
        alert("Ingresar solo numeros");
        return false;
    }

}


/*Problema 1 */

function interes(){
    var valor = parseFloat(document.getElementById('inv').value);
    var interes = valor*0.02;
    var total = valor+interes;
    document.formulario.sueldoti.value="$"+total;
}

function borrar(){
    document.formulario.sueldoti.value="";
    document.getElementById('inv').value="";
}

/*Problema 2*/


function obtsueldo(){
    if (document.getElementById('sueldoo').value == ""){
        alert("Debes indicar tu sueldo base, por lo menos.");
    }
    else{var sueldo = parseFloat(document.getElementById('sueldoo').value);
    var totall = sueldo+document.getElementById('ventass').value*.10;
    document.getElementById('sueldotot').value="$"+totall;}
}

function borrar2(){
    document.getElementById('sueldoo').value="";
    document.getElementById("ventass").value="";
    document.getElementById("sueldotot").value="";
}

/*Problema 3*/

function compratot(){
    if (document.formulario.compra.value == ""){
        alert("Debes ingresar el total de tu compra");
    }
    else{
    var compra = parseFloat(document.formulario.compra.value);
    var total= compra - compra*.15;
    document.formulario.totpagar.value="$"+total;
    }
}

//Problema 4

function promedio(){
   
    var i = validacal();
    if (i==1){
        ca11 = parseFloat(document.formulario.c11.value);
        ca12 = parseFloat(document.formulario.c12.value);
        ca13 = parseFloat(document.formulario.c13.value);
        val2 = parseFloat(document.formulario.c2.value) * .30;
        val3 = parseFloat(document.formulario.c3.value) * .15;
        prom1 =  ((ca11+ca12+ca13)/3)*.55;
        final = val2 + val3 + prom1;
        document.formulario.promedioo.value = final;
    }
}

function validacal(){
    var patron= /[0-9]{1,2}(?:\.\d*)?$/
    var prueba = document.formulario.c11.value;
    var prueba2 = document.formulario.c12.value;
    var prueba3 = document.formulario.c13.value;
    var prueba4 =  document.formulario.c2.value;
    var prueba5 =  document.formulario.c3.value;
    if (prueba == "" || prueba2 == "" || prueba3 == "" ||prueba4 == "" ||prueba5 == "" ){
        alert("Debes llenar todos los campos");
        return 0;
    }
    else if (patron.test(prueba) && patron.test(prueba2) && patron.test(prueba3) && patron.test(prueba4) && patron.test(prueba5)){
        return 1;
    }
    else{
        alert("Ingresa enteros, o números con decimales separados por punto.");
        return 0;
    }

}

function borrar4(){
    document.formulario.c11.value="";
    document.formulario.c12.value="";
    document.formulario.c13.value="";
    document.formulario.c2.value="";
    document.formulario.c3.value="";
    document.formulario.promedioo.value="";
}

//Problema 5

function porcentaje(){
    var patron= /[0-9]{1,2}/
    var prueba = document.formulario.hombres.value;
    var prueba2 = document.formulario.mujeres.value;

    if (prueba == "" || prueba2 ==""){
        alert("Llena ambos campos");
    }
    else if(patron.test(prueba) && patron.test(prueba2)){
        var hombres = parseInt(document.formulario.hombres.value);
        var mujeres = parseInt(document.formulario.mujeres.value);
        var total = hombres + mujeres;
        document.formulario.porh.value = "%"+((mujeres*100)/total).toFixed(2);
        document.formulario.porm.value = "%"+((hombres*100)/total).toFixed(2);
    }
    else{
        alert("Ingresa una cantidad válida. Sólo enteros de 1 o 2 cifras.")
    }
}

function borrar5(){
    document.formulario.mujeres.value="";
    document.formulario.hombres.value="";
    document.formulario.porh.value="";
    document.formulario.porm.value="";
}

//Problema 6
function validar6(evt){
    if(window.event){
        keynum= evt.keyCode;
    }
    else{
        keynum= evt.which;
    }
    if((keynum>46 && keynum <58 )||keynum == 8|| keynum == 13)
    {
        return true;
    }
    else{
        alert("Ingresar solo numeros y diagonales");
        return false;
    }
}

function edad(){
    var patron = /^([0-2][0-9]|3[0-1])(\/|-)(0[1-9]|1[0-2])\2(\d{4})$/
    var prueba = document.formulario.fecha.value;
    if (patron.test(prueba)){
        let fechanac = new Date(prueba);
        let actual = new Date();
        var anios = actual.getFullYear() - fechanac.getFullYear();

        fechanac.setFullYear(actual.getFullYear);

        if (actual < fechanac){
            --anios;
        }

        document.formulario.edadcalc.value = anios + "años";
    }
    else{
        alert("Ingresa tu fecha de nacimiento en el formato indicado");
    }
}

function borrar6(){
    document.formulario.fecha.value ="";
    document.formulario.edadcalc.value="";
}