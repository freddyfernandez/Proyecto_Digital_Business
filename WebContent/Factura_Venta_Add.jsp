<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "beans.VentaDTO" %>
<%@ page import = "beans.EmpleadoDTO" %>
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
			   <form action="ServletVenta?tipo=registrarFactura" id="frmagregar" method="post">
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DE FACTURAS</span>
				</div>
			<%
    	      VentaDTO obj=(VentaDTO) request.getAttribute("buscarventa");
			 
   
                %>
			<div class="input-container">
				<div class="row">
				  <label >CODIGO VENTA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_codigoVenta" class="required"  value="<%=obj.getCodigo_venta() %>"
						 data-min-length="8" placeholder="" pattern="[0-9]{5,10}" required="required">
					</span>
				    
					<label for ="txt_marca">CODIGO EMPLEADO</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_empleado" class="required" data-min-length="8">
							<c:forEach items="${requestScope.empleado}" var="d">
								<option value="${d.codigo}">${d.nombre}</option>
							</c:forEach>
					    </select>
					</span>
					<label for ="txt_marca">ESTADO</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_estado" class="required" data-min-length="8">
							<c:forEach items="${requestScope.estado}" var="d">
								<option value="${d.estado}">${d.nombre_estado}</option>
							</c:forEach>
					    </select>
					</span>
					
					<label >FECHA DE FACTURA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <input  type="date" name="txt_fecha" class="required" style="width:92.6%;height:100%;padding-left:10px"
						 data-min-length="8" required="required">
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
