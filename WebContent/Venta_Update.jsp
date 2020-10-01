<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.VentaDTO" %>
<%@ page import ="beans.ProductoDTO" %>
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
    	        VentaDTO obj=(VentaDTO) request.getAttribute("registro");
   
                %>
			   <form action="ServletVenta?tipo=actualizarVenta" id="frmagregar" method="post">
			     <input type="hidden" name="txt_codigoVenta" value="<%=obj.getCodigo_venta() %>" >
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>ACTUALIZAR VENTA</span>
				</div>
			
			<div class="input-container">
				<div class="row">
								    <label >FECHA DE VENTA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 	  <input  type="date" name="txt_fecha" class="required" value="<%=obj.getFecha() %>" style="width:92.6%;height:100%;padding-left:10px"
						 data-min-length="8" required="required">
					</span>
					

					
			<label for ="txt_des">CODIGO DE EMPLEADO</label>
<span class="req-input" >
<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
<input  type="text" name="txt_codigoEmpleado" class="required" value="<%=obj.getCodigo_empleado() %>"
 data-min-length="8" placeholder="Ingrese Descripcion " pattern="[0-9]{2,5}" required="required">
</span>	
				
								<label for ="txt_des">CODIGO DE CONTACTO</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_codigoCliente" class="required" value="<%=obj.getCodigo_cliente() %>"
						 data-min-length="8" placeholder="Ingrese Descripcion " pattern="[0-9]{3,6}" required="required">
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