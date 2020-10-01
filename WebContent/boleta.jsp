<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="displaySession" %>    
<!DOCTYPE html>
<html>
<link href="css/displaytagex.css" rel="stylesheet" media="all">
<head>
    <meta charset="ISO-8859-1">
    <title>Facturacion</title>
    
    
    <!--SCRIPT-->
    <jsp:include page="Main_Vendor.jsp" />
    
    <script type="text/javascript">
	function validaPrecio(value, e){
		var texto = String.fromCharCode(e.keyCode);
		var rpta= validarNumerosReales(e);
		
		//No se puede empezar con punto
		if(texto =="." && value ==""){
			return false;
		}
		//Es numero o punto
		if(rpta){
			if(texto == "."){
					if(value.indexOf(".") == -1){
						return true;
					}else{
						return false;
					}
				}else{
					return true;
				}
		//No es numero ni punto	
		}else{
			return false;	
		}
	}


	function validaEdad(value, e){
		var texto = String.fromCharCode(e.keyCode);
		var rpta= validarSoloNumerosEnteros(e);
		
		//revisar si esta entre 1 y 110
		if(rpta){
			var x ;
			if(value== ""){		x = parseInt(texto);  }
			else{	x = parseInt(value)*10 +parseInt(texto); }
			
			if(x>=1 && x<=100){		return true;	}
			else{					return false;	}
		//no viene numero lo cancelo	
		}else{
			return false;	
		}
	}

	function validarNumerosReales(e) { // 1
	    tecla = (document.all) ? e.keyCode : e.which; // 2
	    if (tecla==8) return true; // 3
	    patron = /[0123456789.]/; // Solo acepta números
	    te = String.fromCharCode(tecla); // 5
	    return patron.test(te); // 6
	}	
	function validarSoloNumerosEnteros(e) { // 1
		 tecla = (document.all) ? e.keyCode : e.which; // 2
	    if (tecla==8) return true; // 3
	    patron = /[0-9]/;// Solo acepta números
	    te = String.fromCharCode(tecla); // 5
	    return patron.test(te); // 6
	}

</script>
    <!--END SCRIPT-->
    
    <style>

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	padding: 16px;
	border: 3px solid blue;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
</style>

</head>

<body class="animsition">
     
     <!-- DIV PRINCIPAL--> 
     <div class="page-wrapper">
     
        <!-- MENU LATERAL-->
           <jsp:include page="Aside_Bar.jsp" />
	    <!-- MENU LATERAL-->
	   
	    <!-- PAGE CONTAINER-->
           <div class="page-container2">
           
             <!-- MENU PANEL-->
             <jsp:include page="Header.jsp" />
             <!-- END MENU PANEL-->
          
             <!-- CONTENIDO-->
             <div class="main-content">

                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                      <div class="container">
                      <div class="row">
		
    	               <div class="col-md-9">
             

    <form id="frmBoleta" >
	<input type="hidden" name="tipo" id="metodo" >
	<div id="contact-form" class="form-container" data-form-container>
	<div class="form-title">
	<span>Registro de Boleta</span>
	</div>
	
	<div class="input-container" style="display:flex">
	   
	   
	   
	    <div class="row" style="width:80%">
	    <label>Seleccione Cliente</label>&nbsp;&nbsp;
        <span class="req-input" >
        <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your Last Name."></span>
		<input type="text" name="nombre" id="idNomCli" value="${sessionScope.datoCliente}">
	    </span>
	    </div>
	    <div class="row" style="width:24%;margin:20px 0px 10px -36px;" >
	    
	    <input type="button" value="......." onclick="verCliente();" class="btn btn-block submit-form" style="background-color:#999999;
	    border-radius:10%;text-align:center;" >
	
	    </div>
	   
	    
	   
	</div>
	<div class="input-container" style="display:flex">
	    <div class="row" style="width: 80%">
		<label>Seleccione Producto</label>	
		<span class="req-input" >
		<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your Last Name."></span>
		 <input type="text" name="producto" id="idNomCli" value="${sessionScope.datoProducto}"> &nbsp;&nbsp;
		</span>
		</div>
		
		<div class="row" style="width:24%;margin:20px 0px 10px -36px;" >
	    
	    <input type="button" value="......." onclick="verProducto();" class="btn btn-block submit-form" style="background-color:#999999;
	    border-radius:10%;text-align:center;" >
	
	    </div>
	 </div>
	 <div class="input-container" style="display:flex">
	    <div class="row" style="width: 30%">
	    <label>Cantidad </label>
		<span class="req-input" >
		<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your Last Name."></span>
		<input type="text" name="cantidad" required="required" onkeypress="return validarSoloNumerosEnteros(event);" >&nbsp;&nbsp;
		</span>
		</div>
	
	    <div class="row" style="width:40%;margin:20px 40px 10px -20px;" >
		<input type="button" value="agregar" onclick="addProducto();" class="btn btn-block submit-form" style="width:48%">
		</div>
		<div class="row" style="width:40%;margin:20px 30px 10px 20px;" >
		<input type="button" value="registrar" onclick="addBoleta();"class="btn btn-block submit-form" style="width:48%">
	    </div>
	</div> 
	</div>
	</form>
	</div>
			
        
	</div>
	
	</div>	
	
	   <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                 
	 <displaySession:table name="${sessionScope.boleta}"  
	 					   class="table table-borderless table-data3"
	 					   
	 					   id="bean">
		<displaySession:column property="codigo" title="CODIGO" sortable="true"/>
		<displaySession:column property="nombre" title="NOMBRE" sortable="true"/>
		<displaySession:column property="stock" title="CANTIDAD" sortable="true"/>
		<displaySession:column property="precio" title="PRECIO" sortable="true"/>
	
		
		<display:column >
			<a href="ServletVenta?tipo=elimina&id=${bean.codigo}">Eliminar</a>
		</display:column>  
	</displaySession:table>
	
	
                                </div>
                                <!-- END DATA TABLE-->
                            </div>
                        </div>

                    </div>
                </div>
            </div>



<script type="text/javascript">
	function addProducto(){
		document.getElementById("metodo").value ='ingresa';
		document.getElementById("frmBoleta").action = 'ServletVenta';
		document.getElementById("frmBoleta").submit();
	}
	function addBoleta(){
		document.getElementById("metodo").value ='registra';
		document.getElementById("frmBoleta").action = 'ServletVenta';
		document.getElementById("frmBoleta").submit();
	}


	function verCliente(){
		document.getElementById("fondo").style.display ='block';
		document.getElementById("divCliente").style.display ='block';
	}
	function verProducto(){
		document.getElementById("fondo").style.display ='block';
		document.getElementById("divProducto").style.display ='block';
	}
	function ocultaCliente(){
		document.getElementById("fondo").style.display ='none';
		document.getElementById("divCliente").style.display ='none';
	}
	function ocultaProducto(){
		document.getElementById("fondo").style.display ='none';
		document.getElementById("divProducto").style.display ='none';
	}	
	function buscaCliente(){
		document.getElementById("idFormCliente").submit();
	}
	function buscaProducto(){
		document.getElementById("idFormProducto").submit();
	}
	function buscaProducto(){
		document.getElementById("idFormProducto").submit();
	}
</script>



<div id="fondo" class="black_overlay">

</div>

<div id="divCliente" class="white_content" >

	<h1 style="font-size:50px;background-color:blue;border-radius:10px;color:aqua;text-align:center;">Buscar Cliente</h1>

	<form action="ServletContacto" id="idFormCliente">
		<input type="hidden" name="tipo" value="busca">
		Cliente: 
		<input type="text" name="filtro" style="border:1px solid;border-radius:5px;">
		<input type="button" value="Enviar" onclick="buscaCliente();" style="width:65px;height:35px;border-radius:5px;
		font-size:17px;background-color:green;color:white;"><br>
	 </form>
	 
	 <display:table name="clientes" 
				   requestURI="ServletContacto?tipo=busca" 
				   id="bean" size="500" class="dataTable" >
			     
		<display:column property="codigo_contacto" title="ID" sortable="true"/>
		<display:column property="dni" title="DNI" sortable="true"/>
		<display:column property="razon_social" title="NOMBRE" sortable="true"/>
		<display:column property="telefono" title="TELEFONO" sortable="true"/>
		<display:column >
			<a href="ServletContacto?tipo=seleccione&id=${bean.codigo_contacto}&dni=${bean.dni}&nom=${bean.razon_social}&tel=${bean.telefono}">Seleccione</a>
		</display:column>
		
	</display:table>
</div>

<div id="divProducto" class="white_content">

<h1 style="font-size:50px;background-color:blue;border-radius:10px;color:aqua;text-align:center;">Buscar Producto</h1>

<form action="ServletProducto" id="idFormProducto">
	<input type="hidden" name="tipo" value="busca">
	Producto: 
	<input type="text" name="filtro" style="border:1px solid;border-radius:5px;">
 	<input type="button" value="Enviar" onclick="buscaProducto();" 
 	style="width:65px;height:35px;border-radius:5px;font-size:17px;background-color:green;color:white;"><br>
 </form>

 <display:table name="productos" 
			   requestURI="ServletProducto?tipo=busca" 
			   id="bean"  class="dataTable" >
		   
	<display:column property="codigo" title="ID" sortable="true"/>
	<display:column property="nombre" title="NOMBRE" sortable="true"/>
	<display:column property="precio" title="PRECIO" sortable="true"/>
	<display:column property="stock" title="STOCK" sortable="true"/>
	<display:column >
			<a href="ServletProducto?tipo=seleccione&id=${bean.codigo}&nom=${bean.nombre}&pre=${bean.precio}">Seleccione</a>
	</display:column>
</display:table>

</div>  

<script type="text/javascript">
<%	if(request.getAttribute("clientes")!= null){  %>
	document.getElementById("fondo").style.display ='block';
	document.getElementById("divCliente").style.display ='block';
<%}	%>
</script>

<script type="text/javascript">
<%	if(request.getAttribute("productos")!= null){  %>
	document.getElementById("fondo").style.display ='block';
	document.getElementById("divProducto").style.display ='block';
<%}	%>
</script>
              
           
             <!-- CONTENIDO-->
            
             <!-- FOOTER-->
             <jsp:include page="Footer.jsp" />
             <!-- END FOOTER-->
             
           </div>
	    <!-- END PAGE CONTAINER-->
	  
	   
	   
	 </div>
	 <!-- END DIV PRINCIPAL-->   
	 
     <jsp:include page="Main_Vendor.jsp" />
     
     
	   
	   
	   

</body>
</html>
