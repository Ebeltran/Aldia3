/**
 * Da formato a un número para su visualización
 *
 * @param {(number|string)} numero Número que se mostrará
 * @param {number} [decimales=null] Nº de decimales (por defecto, auto); admite valores negativos
 * @param {string} [separadorDecimal=","] Separador decimal
 * @param {string} [separadorMiles=""] Separador de miles
 * @returns {string} Número formateado o cadena vacía si no es un número
 *
 * @version 2014-07-18
 */
function formatoNumero(numero, decimales ) {
	var partes, array, separadorDecimal, separadorMiles;

	if ( !isFinite(numero) || isNaN(numero = parseFloat(numero)) ) {
		return "";
	}
	if (typeof decimales==="undefined") {
           decimales= 0; 
        }
        if (typeof separadorDecimal==="undefined") {
		separadorDecimal = ".";
	}
	if (typeof separadorMiles==="undefined") {
		separadorMiles = ",";
	}

	// Redondeamos
	if ( !isNaN(parseInt(decimales)) ) {
		if (decimales >= 0) {
			numero = numero.toFixed(decimales);
		} else {
			numero = (
				Math.round(numero / Math.pow(10, Math.abs(decimales))) * Math.pow(10, Math.abs(decimales))
			).toFixed();
		}
	} else {
		numero = numero.toString();
	}

	// Damos formato
	partes = numero.split(".", 2);
	array = partes[0].split("");
	for (var i=array.length-3; i>0 && array[i-1]!=="-"; i-=3) {
		array.splice(i, 0, separadorMiles);
	}
	numero = array.join("");

	if (partes.length>1) {
		numero += separadorDecimal + partes[1];
	}

	return numero;
}
