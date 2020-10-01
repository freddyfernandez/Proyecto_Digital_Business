<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.EmpleadoDTO" %>
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
    	     EmpleadoDTO obj=(EmpleadoDTO) request.getAttribute("registro");
             %>
			<form action="ServletEmpleado?tipo=actualizar" id="frmagregar" method="post">
			<input type="hidden"  name="txt_cod" value="<%=obj.getCodigo() %>" >
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>ACTUALIZACION DE EMPLEADOS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">NOMBRE</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_des" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" value="<%=obj.getNombre() %>" 
						 pattern="[A-Za-z ]{3,100}" required="required">
					</span>
					
					<label for ="txt_ape">APELLIDO</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_ape" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" value="<%=obj.getApellido() %>" 
						 pattern="[A-Za-z ]{3,100}" required="required">
					</span>
					<label for ="txt_ape">USUARIO</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_log" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" value="<%=obj.getLogin() %>" 
						  pattern="[A-Za-z0-9]{5,20}" required="required">
					</span>
					<label for ="txt_ape">PASSWORD</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_pas" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" value="<%=obj.getPassword() %>" 
						 pattern="[A-Za-z0-9]{5,20}" required="required">
					</span>
					<label for ="txt_ape">DETALLE</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_det" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" value="<%=obj.getDetalle() %>" required="required">
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
