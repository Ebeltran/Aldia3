RequestB = new Class({

	Extends: Request,
	
	options: {
		/*onTimeout:$empty,*/
		timeout:false
	},

	send: function(options){
		var timeout=(this.options.timeout || (options ? options.timeout: null));
		if (timeout) {
			this.timeoutTimer=window.setTimeout(this.callTimeout.bindWithEvent(this), timeout);
			this.addEvent('onComplete', this.removeTimer);
		}
		return this.parent(options);
	},

	callTimeout: function () {
		if (!this.running) return this;
		this.running = false;
		this.xhr.abort();
		this.xhr.onreadystatechange = $empty;
		this.xhr = new Browser.Request();
		this.onFailure();
		this.fireEvent('onTimeout');
	},
 
	removeTimer: function() {
		window.clearTimeout(this.timeoutTimer);
	}
});


function select_innerHTML(objeto,innerHTML){
    objeto.innerHTML = ""
    var selTemp = document.createElement("micoxselect")
    var opt;
    selTemp.id="micoxselect1"
    document.body.appendChild(selTemp)
    selTemp = document.getElementById("micoxselect1")
    selTemp.style.display="none"
    if(innerHTML.toLowerCase().indexOf("<option")<0){
        innerHTML = "<option>" + innerHTML + "</option>"
    }
    innerHTML = innerHTML.toLowerCase().replace(/<option/g,"<span").replace(/<\/option/g,"</span")
    selTemp.innerHTML = innerHTML.toUpperCase();
      
    
    for(var i=0;i<selTemp.childNodes.length;i++){
  var spantemp = selTemp.childNodes[i];
  
        if(spantemp.tagName){     
            opt = document.createElement("OPTION")
    
   if(document.all){ //IE
    objeto.add(opt)
   }else{
    objeto.appendChild(opt)
   }       
    
   //Obteniendo atributos
   for(var j=0; j<spantemp.attributes.length ; j++){
    var attrName = spantemp.attributes[j].nodeName;
    var attrVal = spantemp.attributes[j].nodeValue;
    if(attrVal){
     try{
      opt.setAttribute(attrName,attrVal);
      opt.setAttributeNode(spantemp.attributes[j].cloneNode(true));
     }catch(e){}
    }
   }
   //Obteniendo estilos
   if(spantemp.style){
    for(var y in spantemp.style){
     try{opt.style[y] = spantemp.style[y];}catch(e){}
    }
   }
   //value and text
   opt.value = spantemp.getAttribute("value")
   opt.text = spantemp.innerHTML
   //IE
   opt.selected = spantemp.getAttribute('selected');
   opt.className = "formlista"; //spantemp.className;
  } 
 }    
 document.body.removeChild(selTemp)
 selTemp = null
}


//-------------------------------------------------------------------- overlayCargando()
function overlayCargando(txt)
{
	overlayOn();
	var dv = document.getElementById('overlay');
	dv.setAttribute('align',"center");
	dv.innerHTML = "<div class='success noticeAlert'><strong>"+txt+ "</strong><br/><img src='images/indicator.gif'><br/></ div> &nbsp;";
        
}




function obtenerMunicipiosPorDepto ()
{
   
   if(this.document.frmDireccionNotificacion.departamento.selectedIndex>=0)
   {
               overlayOn();
               overlayCargando("Un momento por favor, consultando departamentos...");
                    
               var querystring = "departamento=" + this.document.frmDireccionNotificacion.departamento.options[ this.document.frmDireccionNotificacion.departamento.selectedIndex].value
                              + "&nocache=" + encodeURIComponent(Math.random());
               var req = new Request({
                            method : "post",
                            url : "departamentosservlet",
                            onSuccess: function (response) 
                                       {
                                         
                                         if (response=="0")
                                          {
                                             alert("No se encontraron municipios en el Departamento seleccionado.");
                                             window.opener = self;
                                             self.window.close();
                                          }else{
                                          
                                               if (navigator.appName.indexOf("Explorer") != -1)
                                               {
                                                  alert("se encontraron municipios en el Departamento seleccionado por expliorer.");
                                                    select_innerHTML(document.getElementById("municipio"),response);
                                                    $('municipio').addClass('formlista');
                                               }else
                                               {
                                                   alert("se encontraron municipios en el Departamento seleccionado por otro.");
                                                    $('municipio').innerHTML = response;
                                               }
                                           }
                                          overlayOff();
                                       },
                            onFailure: function(x){
                              alert("fallo");
                            }
                           }).send(querystring);
     }                      
                           
} 



function editarDireccionNotificacion2()
{
      this.document.frmDireccionNotificacion.direccion.value=
      this.document.frmDireccionNotificacion.tipoViaPrimaria.options[ this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex].value
      if(this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex>=0)
      {
            if(this.document.frmDireccionNotificacion.tipoViaPrimaria.options[ this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex].value!= "AV")
            {
                
                if(this.document.frmDireccionNotificacion.numeroViaPrincipal.value!="")
                {
                    this.document.frmDireccionNotificacion.direccion.value+= " "+ this.document.frmDireccionNotificacion.numeroViaPrincipal.value ;
                }
                if(this.document.frmDireccionNotificacion.letraViaPrincipal.selectedIndex>=0)
                {
                
                     if(this.document.frmDireccionNotificacion.letraViaPrincipal.options[ this.document.frmDireccionNotificacion.letraViaPrincipal.selectedIndex].value!="")
                    {
                        this.document.frmDireccionNotificacion.direccion.value+=this.document.frmDireccionNotificacion.letraViaPrincipal.options[ this.document.frmDireccionNotificacion.letraViaPrincipal.selectedIndex].value ;
                    }
                 
                }
                
                
                if(this.document.frmDireccionNotificacion.bis.selectedIndex>=0)
                {
                    
                    if(this.document.frmDireccionNotificacion.bis.options[ this.document.frmDireccionNotificacion.bis.selectedIndex].value!="")
                    {
                        this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.bis.options[ this.document.frmDireccionNotificacion.bis.selectedIndex].value ;
                    }
                }

                if(this.document.frmDireccionNotificacion.letraBis.selectedIndex>=0)
                {
                
                     if(this.document.frmDireccionNotificacion.letraBis.options[ this.document.frmDireccionNotificacion.letraBis.selectedIndex].value!="")
                    {
                        this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.letraBis.options[ this.document.frmDireccionNotificacion.letraBis.selectedIndex].value ;
                    }
                 
                }
                
                
                if(this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex>=0)
                {
                  if(this.document.frmDireccionNotificacion.cuadranteViaPrincipal.options[ this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex].value!="")
                  {
                    this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.cuadranteViaPrincipal.options[ this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex].value ;
                    }
                }
                
            }
            else   {
               //  this.document.frmDireccionNotificacion.direccion.value=  this.document.frmDireccionNotificacion.tipoViaPrimaria.options[ this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex].value
               //  this.document.frmDireccionNotificacion.direccion.value+=" "+ this.document.frmDireccionNotificacion.nombreViaPrincipal.value ;
            }
               
            if(this.document.frmDireccionNotificacion.numeroViaGeneradora.value!="")
            {
            this.document.frmDireccionNotificacion.direccion.value+= " "+this.document.frmDireccionNotificacion.numeroViaGeneradora.value;
            }
         
            if(this.document.frmDireccionNotificacion.letraViaGeneradora.selectedIndex>=0)
            {
                
               if(this.document.frmDireccionNotificacion.letraViaGeneradora.options[ this.document.frmDireccionNotificacion.letraViaGeneradora.selectedIndex].value!="")
               {
                  this.document.frmDireccionNotificacion.direccion.value+=this.document.frmDireccionNotificacion.letraViaGeneradora.options[ this.document.frmDireccionNotificacion.letraViaGeneradora.selectedIndex].value ;
               }
                 
            }   
            
            if(this.document.frmDireccionNotificacion.numeroPlaca.value!="")
            {
                var cero=""
                /*if (this.document.frmDireccionNotificacion.numeroPlaca.value<10)
                {
                cero="0";
                }*/
                this.document.frmDireccionNotificacion.direccion.value+= " "+cero+this.document.frmDireccionNotificacion.numeroPlaca.value;
            }
            if(this.document.frmDireccionNotificacion.cuadranteViaGeneradora.selectedIndex>=0)
            {
                this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.cuadranteViaGeneradora.options[ this.document.frmDireccionNotificacion.cuadranteViaGeneradora.selectedIndex].value ;
            }
     }
     

     

}

function habilitarNombreAvenida()
{
    if(this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex>=0)
    {
        if(this.document.frmDireccionNotificacion.tipoViaPrimaria.options[ this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex].value== "AV")
        {
            this.document.frmDireccionNotificacion.numeroViaPrincipal.disabled=true;
            this.document.frmDireccionNotificacion.nombreViaPrincipal.disabled=false;
            
        }
        else   {
             this.document.frmDireccionNotificacion.numeroViaPrincipal.disabled=false;
            this.document.frmDireccionNotificacion.nombreViaPrincipal.disabled=true;
        }
    }
}
function validarCuadranteViaPrincipal()
{
    if(this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex>=0)
     {
         var tipoViaPrim = this.document.frmDireccionNotificacion.tipoViaPrimaria.options[ this.document.frmDireccionNotificacion.tipoViaPrimaria.selectedIndex].value;
         if( this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex>=0)
         {
                 var cuadranteViaPrim= this.document.frmDireccionNotificacion.cuadranteViaPrincipal.options[ this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex].value;
                
                 if(tipoViaPrim=="CL" || tipoViaPrim=="AC" ||tipoViaPrim=="DG")
                 {
                    if(cuadranteViaPrim=="ESTE")
                    {
                        this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex="-1";
                    }
                 }
                 if(tipoViaPrim=="KR" || tipoViaPrim=="AK" ||tipoViaPrim=="TV")
                 {
                    if(cuadranteViaPrim=="SUR")
                    {
                        this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex="-1";
                    }
                 }
         }
         if(tipoViaPrim=="AV")
         {
              this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex="-1";
         }
         
    }
         
}


function editarComplemento()
{
     if(this.document.frmDireccionNotificacion.componenteComplemento.selectedIndex>=0 && this.document.frmDireccionNotificacion.valorComplemento.value!="")
    {
        this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.componenteComplemento.options[ this.document.frmDireccionNotificacion.componenteComplemento.selectedIndex].value;
        this.document.frmDireccionNotificacion.direccion.value+=" "+this.document.frmDireccionNotificacion.valorComplemento.value;
    }


}


function validarCuadranteViaGeneradora()
{

    if(this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex>=0)
    {
          var cuadranteViaPrim= this.document.frmDireccionNotificacion.cuadranteViaPrincipal.options[ this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex].value;
          if(this.document.frmDireccionNotificacion.cuadranteViaGeneradora.selectedIndex>=0)
          {  
            var cuadranteViaGeneradora= this.document.frmDireccionNotificacion.cuadranteViaGeneradora.options[ this.document.frmDireccionNotificacion.cuadranteViaGeneradora.selectedIndex].value;
        
            if(cuadranteViaPrim==cuadranteViaGeneradora)
            {
             this.document.frmDireccionNotificacion.cuadranteViaGeneradora.selectedIndex="-1";
             this.document.frmDireccionNotificacion.cuadranteViaPrincipal.selectedIndex="-1";
            }
          }   
    
    }
    
         
}



function confirmarDireccion()
{
    if( this.document.frmDireccionNotificacion.direccion.value!="" && this.document.frmDireccionNotificacion.municipio.options[this.document.frmDireccionNotificacion.municipio.selectedIndex].value!="11001")
    {
        
        if(confirm("¿La dirección que ha registrado corresponde con  la asignada por la Unidad de Catastro de su Municipio?.  Si está de acuerdo de Aceptar; si no está de acuerdo  de Cancelar para verificar y corregir. (Recuerde que de esta se derivan todos los efectos legales en el Proceso Tributario)."))
        {
             asignarValores();
        }
    }
}
 
 function asignarValores()
 {
  if (window.opener.document.getElementById('direccion') !=null)
            {
                window.opener.document.getElementById('direccion').value=this.document.frmDireccionNotificacion.direccion.value;
            }
            if (window.opener.document.getElementById('codigoDepto') !=null)
            {
                window.opener.document.getElementById('codigoDepto').value=this.document.frmDireccionNotificacion.departamento.options[ this.document.frmDireccionNotificacion.departamento.selectedIndex].value;
            }
  
            
            if (window.opener.document.getElementById('nombreDepto') !=null)
            {
                 window.opener.document.getElementById('nombreDepto').value=this.document.frmDireccionNotificacion.departamento.options[ this.document.frmDireccionNotificacion.departamento.selectedIndex].text;
            }
            
            
            if (window.opener.document.getElementById('codigoMunicipio') !=null)
            {
                 window.opener.document.getElementById('codigoMunicipio').value=this.document.frmDireccionNotificacion.municipio.options[ this.document.frmDireccionNotificacion.municipio.selectedIndex].value;
            }
            if (window.opener.document.getElementById('nombreMunicipio') !=null)
            {
                 window.opener.document.getElementById('nombreMunicipio').value=this.document.frmDireccionNotificacion.municipio.options[ this.document.frmDireccionNotificacion.municipio.selectedIndex].text;
            }
            window.opener = self;
            self.window.close();
 }

 function conMayusculas(field) {   
            field.value = field.value.toUpperCase();   
}   

function validarDireccionConUAECD ()
{

  /* if(this.document.frmDireccionNotificacion.direccion.value!="" && this.document.frmDireccionNotificacion.municipio.options[this.document.frmDireccionNotificacion.municipio.selectedIndex].value=="11001")
    {
          overlayOn();
           overlayCargando("Un momento por favor, consultando dirección...");
                
            var querystring = "direccion=" + $('direccion').value 
                          + "&nocache=" + encodeURIComponent(Math.random());
            var req = new RequestB({
                            method : "post",
                            url : "serviciowebuaecdservlet",
                            timeout: 10000,
                            onSuccess: function (response) 
                                       {
                                         
                                         if (response=="0")
                                          {
                                             if(confirm("Su dirección no coincide con las direcciones de la  Unidad Administrativa Especial de Catastro Distrital. Para verificar y corregir de Cancelar.  Si está de acuerdo con la dirección que ha  registrado, pulse Aceptar (Recuerde que de esta se derivan todos los efectos legales del Proceso Tributario)."))
                                             {
                                                overlayOff();
                                               // confirmarDireccion();
                                                 asignarValores();
                                             }
                                             
                                          }else{
                                                                           
                                              if($('direccion').value!=response)
                                              {
                                                if(confirm("Consultando con la Unidad Administrativa Especial de Catastro Distrital se encontró la dirección "+response+ " ¿Desea tomar esta dirección como su Dirección Completa?  Pulse Aceptar si esta de acuerdo o Cancelar para no reemplazarla (Recuerde que de esta se derivan todos los efectos legales del Proceso Tributario)."))
                                                 {
                                                    $('direccion').value =response;
                                                 }
                                                 asignarValores();
                                                 
                                              }else
                                              {
                                                  alert("Su dirección se validó correctamente (Recuerde que de esta se derivan todos los efectos legales del Proceso Tributario).");
                                                  asignarValores();
                                              }
                                              
                                               
                                                overlayOff();
                                              //  confirmarDireccion();
                                              
                                            
                                          }
                                          overlayOff();
                                    
                                        
                                       },
                            onFailure: function(x){
                             
                           
                              if(confirm("Su dirección no se pudo consultar en  las bases de la direcciones de la Unidad Administrativa Especial de Catastro Distrital . Para verificar y corregir de Cancelar.  Si  está de acuerdo con la dirección que ha registrado, pulse Aceptar (Recuerde que de esta se derivan todos los efectos legales del Proceso Tributario)."))
                              {
                                   asignarValores();
                              }    
                              overlayOff();
                            
                            },
                            onTimeout:function(x){
                             
                             overlayOff();
                             //alert("No fue posible la validación de la dirección "+ $('direccion').value);                          
                           // confirmarDireccion();
                           }
                           }).send(querystring);
   */
                            
      if(this.document.frmDireccionNotificacion.municipio.options[this.document.frmDireccionNotificacion.municipio.selectedIndex].value=="2")
      {
        alert("Por favor escoja un municipio");
      }else if(this.document.frmDireccionNotificacion.direccion.value!="" )
      {
         asignarValores();
      }
} 


function cargarMunicipios(tipo)
{
	if ( tipo == 0 )
	{
		$('municipio').options[$('municipio').options.length]=new Option('BOGOTA - BOGOTA D.C','11001',false,false);
		$('municipio').options[$('municipio').options.length]=new Option('---- Otro municipio ----','2',false,false);
	}
	else
		{
		var req = new Request.JSON(
		{
								   
			url:'municipios.json',
			
			onSuccess: function(data)
			{
				data.datom.each(function(datom)
				{
					$('municipio').options[$('municipio').options.length]=new Option(datom.nombre,datom.id,false,false);
				});
			},
	
			onFailure: function()
			{
				
			}
		}).send();	
	}
}

function borrarDireccion()
{
    this.document.frmDireccionNotificacion.direccion.value="";
}

function borrarComplementoEscogido()
{
    this.document.frmDireccionNotificacion.componenteComplemento.selectedIndex=0;
    this.document.frmDireccionNotificacion.valorComplemento.value="";
}