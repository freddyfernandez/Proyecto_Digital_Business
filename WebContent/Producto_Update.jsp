<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.ProductoDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    
    <!--SCRIPT-->
    <jsp:include page="Main_Vendor.jsp" />
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
    	        <%
                ProductoDTO obj=(ProductoDTO) request.getAttribute("registro");
   
                %>
			   <form action="ServletProducto?tipo=actualizar" id="frmagregar" method="post">
			     <input type="hidden" name="txt_cod" value="<%=obj.getCodigo() %>" >
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>ACTUALIZACION DE PRODUCTOS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_nom">Nombre</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" data-min-length="8" placeholder="Ingrese Descripcion" 
						 name="txt_nom" class="required"  value="<%=obj.getNombre() %>"
						  pattern="[A-Za-z0-9 ]{3,100}" required="required">
					</span>
					<label for ="txt_marca">Marca</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_marca" class="required"  value="<%=obj.getMarca() %>" 
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[0-9]{1,20}" required="required">
					</span>
					<label for ="txt_des">Precio</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo numeros"></span>
						<input  type="text" name="txt_pre" class="required"  value="<%=obj.getPrecio() %>"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[0-9\.]{1,10}" required="required">
					</span>
					<label for ="txt_stock">Stock</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo numeros"></span>
						<input  type="text" name="txt_stock" class="required"  value="<%=obj.getStock() %>"
						 data-min-length="8" placeholder="Ingrese Descripcion " pattern="[0-9]{1,10}" required="required">
					</span>
					<label for ="txt_des">Descripcion</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo Letras"></span>
						<input  type="text" name="txt_des" class="required" value="<%=obj.getCaracteristicas() %>"
						 data-min-length="8" placeholder="Ingrese Descripcion" required="required">
					</span>
				</div>
				
				</div>
				<div class="row submit-row">
					<button type="submit" value="Consultar" class="btn btn-block submit-form">Actualizar Datos</button>
				</div>
			</div>
			</form>
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
	   
	   
	   

</body>
</html>