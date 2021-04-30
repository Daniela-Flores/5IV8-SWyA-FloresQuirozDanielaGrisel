function validarn(evt){
    if(window.event){
        keynum= evt.keyCode;
    }
    else{
        keynum= evt.which;
    }

    if((keynum>64 && keynum <91 )||keynum == 32|| keynum>96 && keynum<123)
    {
        return true;
    }
    else{
        alert("Ingresar solo letras");
        return false;
    }
}



