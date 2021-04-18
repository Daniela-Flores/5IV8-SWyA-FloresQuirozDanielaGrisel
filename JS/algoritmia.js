function problema1(){

    var p1_input = document.querySelector('#p1-input').value;
    //identificar como dividir el texto escrito por espacios
    var p1_array = p1_input.split('').reverse();
    //habia   aibah

    //construir la nueva cadena invertida
    var p1_res = ' ';

    p1_array.forEach(function (palabra, i){
        //si es el principio o es el final de la cadena
        //y no agregamos espacios en blanco
        if(i != 0 || i != p1_array.length) p1_res += ' ';
        p1_res += palabra; 
    });
    //imprimir el resultado
    document.querySelector('#p1-output').textContent = p1_res;
}


//si es el principio o es el final de la cadena
//sieselprincipiooeselfinaldelacadena
//invertir
//si es elprincipiooeselfinaldelacadena


function problema2(){

    var p2_x1 = document.querySelector('#p2-x1').value;
    var p2_x2 = document.querySelector('#p2-x2').value;
    var p2_x3 = document.querySelector('#p2-x3').value;
    var p2_x4 = document.querySelector('#p2-x4').value;
    var p2_x5 = document.querySelector('#p2-x5').value;

    var p2_y1 = document.querySelector('#p2-y1').value;
    var p2_y2 = document.querySelector('#p2-y2').value;
    var p2_y3 = document.querySelector('#p2-y3').value;
    var p2_y4 = document.querySelector('#p2-y4').value;
    var p2_y5 = document.querySelector('#p2-y5').value;

    //construir los vectores

    var v1 = [p2_x1, p2_x2, p2_x3, p2_x4, p2_x5];
    var v2 = [p2_y1, p2_y2, p2_y3, p2_y4, p2_y5];

    //ordenar los vectores

    v1 = v1.sort(function (a, b){
        return b-a;
    });

    v2 = v2.sort(function (a, b){
        return b-a;
    });

    //invertir el segundo vector

    v2 = v2.reverse();

    //producto escalar
    var p2_producto = 0;

    for(var i = 0; i < v1.length; i++){
        p2_producto += v1[i] * v2[i];
    }

    document.querySelector('#p2-output').textContent =
    'Producto Escalar Minimo : '+ p2_producto;

}

function validarn(evt){
    if(window.event){
        keynum= evt.keyCode;
    }
    else{
        keynum= evt.which;
    }

    if(keynum == 44 ||keynum<91 && keynum>64)
    {
        return true;
    }
    else{
        alert("Divide las palabras con coma, y utiliza [A-Z] ");
        return false;
    }

}

function problema3(){

    var p3_input = document.querySelector('#p3-input').value;
    //dividir por comas
    var p3_array = p3_input.split(',');
    var palabram = '';
    var lmayor = 0;
    
    p3_array.forEach(function (palabra, i){
    var contador = 0;
    var cont2 = 0;
    var repetidas = [palabra.length];
    var caracteres_palabra = [palabra.length];
    //arreglo con caracteres
      for(var i=0; i<palabra.length;i++){
        caracteres_palabra[i] = palabra.charAt(i);
      }
    //contar caracteres repetidos
    for (var k=0; k<palabra.length; k++){
        for(var j=0; j<palabra.length; j++){
            if(k!=j){
                if(caracteres_palabra[k] == caracteres_palabra[j]){
                    var agrega = true;
                    for(var h=0; h<palabra.length; h++){
                        if (repetidas[h]==caracteres_palabra[k]){
                            agrega = false;
                        }
                    }
                    if(agrega){
                        contador += 1;
                        repetidas[contador] = caracteres_palabra[k];
                    }
                }
            }
        }
    }
    for (var k=0; k<palabra.length; k++){
        var contar = 0;
        for(var j=0; j<palabra.length; j++){
            if(k!=j){
                if(caracteres_palabra[k] != caracteres_palabra[j]){
                    contar += 1;
                }
            }
        }
        if (contar==palabra.length-1){
            cont2 += 1;
        }
    }

    if (cont2+contar>lmayor){
        lmayor = cont2+contar;
        palabram = palabra;
    }
    else if (cont2+contar==lmayor){
        palabram += ", " + palabra;
    }

    });

    document.querySelector('#p3-output').textContent =
    'Palabra/s con más caracteres únicos : ' + palabram;
    
    
}