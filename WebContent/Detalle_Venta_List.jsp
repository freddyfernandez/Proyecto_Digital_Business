<%@ page import = "java.util.ArrayList" %>
<%@ page import = "beans.Detalle_VentaDTO" %>
<%@ page import = "beans.VentaDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "beans.ProductoDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>    
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
    	       
			   <form action="ServletVenta?tipo=registrarDetalleVenta" id="frmagregar" method="post">
			   
               <!-- este input trabaja con el boton facturar -->			   
			   <input type="hidden" name="tipo" id="metodo" >
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DETALLE VENTA list</span>
				</div>
			<%
    	      VentaDTO obj=(VentaDTO) request.getAttribute("registro");
                %>
		
			<div class="input-container">
				<div class="row">
				    <label >CODIGO VENTA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_codigoVenta" class="required"  value="<%=obj.getCodigo_venta() %>"
						 data-min-length="8" placeholder="" pattern="[0-9]{5,10}" required="required">
					</span>
					
						<label for ="txt_des">NOMBRE PRODUCTO</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_producto" class="required" data-min-length="8">
							<c:forEach items="${requestScope.producto}" var="d">
								<option value="${d.codigo}">${d.nombre}</option>
							</c:forEach>
					    </select>
					</span>
					
					<label for ="txt_des">PRECIO VENTA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_precio_Venta" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion"
						 pattern="[0-9\.]{1,10}" required="required">
					</span>
					<label for ="txt_des">CANTIDAD</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_cantidad" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion "
						 pattern="[0-9]{1,10}" required="required">
					</span>
					<label for ="txt_des">DESCUENTO</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_descuento" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion "
						 pattern="[0-9\.]{2,10}" required="required">
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
          
          <th>CODIGO_VENTA</th>
          <th>CODIGO_PRODUCTO</th>
          <th>PRECIO_VENTA</th>
          <th>CANTIDAD</th>
          <th>DESCUENTO</th>
          <th>IMPORTE</th>
          
          <th colspan= "2"> ACCIONES</th>
       </tr>                         
            </thead>
            <tbody>
            
            <%
         ArrayList<Detalle_VentaDTO> lista=(ArrayList<Detalle_VentaDTO>) request.getAttribute("data");
				
         if (lista!=null){
        	 for (Detalle_VentaDTO xAlu: lista){
        		 %>
                 <tr>
                
        		 <td><%=xAlu.getCodigo_venta()%></td>
        		 <td><%=xAlu.getNombre_producto()%></td>
        		 <td><%=xAlu.getPrecio_venta()%></td>
        		 <td><%=xAlu.getCantidad()%></td>
        		 <td><%=xAlu.getDescuento()%></td>
        		 <td><%=xAlu.importeTotal()%></td>
        	
        		 <td align="center">
        		   
        		    <a  href ='ServletVenta?tipo=buscarDetalleVenta&cod=<%=xAlu.getCodigo_detalle()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletVenta?tipo=eliminarDetalleVenta&cod=<%=xAlu.getCodigo_detalle()%>'>
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
              <div class="form-container"  style="padding:0px;margin: -30px 0px 0px 0px;min-width:150px; ">
		            <input type="button" value="Facturar" onclick="addBoleta();"class="btn btn-block submit-form" style="width:18%;margin-left:41%"
		             >
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
	   
	 	   
<script type="text/javascript">
	
	function addBoleta(){
		document.getElementById("metodo").value ='cargaregistrofactura';
		document.getElementById("frmagregar").action = 'ServletVenta';
		document.getElementById("frmagregar").submit();
	}	   
</script>  
	   

</body>
</html>
