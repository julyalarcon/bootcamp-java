let horas = 0;
let minutos = 0;
let segundos = 0;
let centecimas = 0;
let crono = new Audio();

function iniciar() {
    control = setInterval(cronometro, 10);
    document.getElementById("iniciar").disabled = true;
    document.getElementById("parar").disabled = false;
    document.getElementById("continuar").disabled = true;
    document.getElementById("reiniciar").disabled = false;

}

function parar() {
    clearInterval(control);
    document.getElementById("parar").disabled = true;
    document.getElementById("continuar").disabled = false;
}

function reiniciar() {
    clearInterval(control);
    centecimas = 0;
    segundos = 0;
    minutos = 0;
    horas = 0;
    Centecimas.innerHTML = ":00";
    Segundos.innerHTML = ":00";
    Minutos.innerHTML = ":00";
    Horas.innerHTML = "00";
    document.getElementById("iniciar").disabled = false;
    document.getElementById("parar").disabled = true;
    document.getElementById("continuar").disabled = true;
    document.getElementById("reiniciar").disabled = true;
}

function cronometro() {
    if (centecimas < 99) {
        centecimas++;
        if (centecimas < 10) { centecimas = "0" + centecimas }
        Centecimas.innerHTML = ":" + centecimas;
    }

    if (centecimas == 99) {
        centecimas = -1;
    }

    if (centecimas == 0) {
        segundos++;
        crono.src="./crono.mp3"
        crono.play()
        if (segundos < 10) { segundos = "0" + segundos; }
        Segundos.innerHTML = ":" + segundos;
        
    }

    if (segundos == 59) {
        segundos = -1;

    }

    if ((centecimas == 0) && (segundos == 0)) {
        minutos++;
        if (minutos < 10) { minutos = "0" + minutos }
        Minutos.innerHTML = ":" + minutos;
    }

    if (minutos == 59) {
        minutos = -1;
    }

    if ((centecimas == 0) && (segundos == 0) && (minutos == 0)) {
        horas++;
        if (horas < 10) { horas = "0" + horas }
        Horas.innerHTML = horas;
    }

}