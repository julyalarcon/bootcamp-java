/**
 * 
 */
 
 var string = document.getElementById("hiddenText").innerHTML;
 
 var busquedaTexto = document.getElementById("busquedaTexto").innerText;
 
 const regex1 = RegExp(busquedaTexto, 'ig');
 const str1 = string;
 let array;
 
 let counter = 0;
 
 while((array = regex1,exec(str1)) !== null){
	counter++ ;
}

document.getElementById("coincidencia").innerText = " " + counter + " ";
document.getElementById("hiddenText").innerHTML = " ";
document.getElementById("hiddenText").innerText = " ";