<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.ProductoDTO" %>
<%@ page import = "beans.MarcaDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    
    <!--SCRIPT-->
    
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Autocomplete - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">

  
    <!--END SCRIPT-->

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
			   <form action="ServletProducto?tipo=registrar" id="frmagregar" method="post">
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DE PRODUCTOS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_nom">Nombre</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo letras mayores a 2"></span>
						<input  type="text" name="txt_nombre" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[A-Za-z ]{3,100}" required="required">
					</span>
					<label for ="txt_marca">Marca</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Elige una opcion"></span>
						 <select name="cbn_marca" class="required" data-min-length="8">
							<c:forEach items="${requestScope.marca}" var="d">
								<option value="${d.codigo}">${d.nombre}</option>
							</c:forEach>
					    </select>
					</span>
					
	
					 <div class="ui-widget">
  <label for="tags">Tags: </label>
  <input id="tags">
</div>
					<label for ="txt_des">Precio</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo numeros hasta 6 caracteres"></span>
						<input  type="text" name="txt_pre" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[0-9\.]{1,7}" required="required">
					</span>
					<label for ="txt_stock">Stock</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo numeros hasta 4 caracteres"></span>
						<input  type="text" name="txt_stock" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[0-9]{0,4}" required="required">
					</span>
					<label for ="txt_des">Descripcion</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Ingrese Descripcion"></span>
						<input  type="text" name="txt_des" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" required="required">
					</span>
				</div>
				
				</div>
				<div class="row submit-row">
					<button type="submit" value="Consultar" class="btn btn-block submit-form">Registrar Datos</button>
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
                                    <table class="table table-borderless table-data3">
                                        <thead>   
       <tr>
          <th>CODIGO </th>
          <th>NOMBRE</th>
          <th>MARCA</th>
          <th>PRECIO UNITARIO</th>
          <th>STOCK</th>
          <th>CARACTERISTICAS</th>
          <th colspan= "2"> ACCIONES</th>
       </tr>
       </thead>
     
       <tbody>
       <%
         ArrayList<ProductoDTO> lista=(ArrayList<ProductoDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (ProductoDTO xAlu: lista){
        		 %>
                 <tr>
        		 <td><%=xAlu.getCodigo()%></td>
        		 <td><%=xAlu.getNombre()%></td>
        		 <td><%=xAlu.getMarca()%></td>
        		 <td><%=xAlu.getPrecio()%></td>
        		 <td><%=xAlu.getStock()%></td>
        		 <td><%=xAlu.getCaracteristicas()%></td>
        		 <td align="center">
        		    <a  href ='ServletProducto?tipo=buscar&cod=<%=xAlu.getCodigo()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletProducto?tipo=eliminar&cod=<%=xAlu.getCodigo()%>'>
                	  <img  src='images/delete.png' title='Eliminar' height="16px" width="16px" ></a>
                 </td>
        		
        		 </tr>
        		 <%
        	 }
         }
       %>
       
          </tbody>
        </table> 
        </div>  
       </div>
      </div>
      </div>
     </div> 
     </div>     
     <!-- CONTENIDO-->
            
     <!-- FOOTER-->
             <jsp:include page="Footer.jsp" />
     <!-- END FOOTER-->
             
           
     </div>       
     <!-- END PAGE CONTAINER-->
	  
	   
	   
	 </div>
	 <!-- END DIV PRINCIPAL-->   
	 

	   <jsp:include page="Main_Vendor.jsp" />
	   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

       <script>
  
    $( function() {
       var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
         "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
       "Scheme"
        ];
       $( "#tags" ).autocomplete({
      source: availableTags
       });
    } );
  </script>
	   

</body>
</html>

