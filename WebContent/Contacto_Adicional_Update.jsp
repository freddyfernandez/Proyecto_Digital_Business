<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.Contacto_AdicionalDTO" %>
<%@ page import ="beans.ContactoDTO" %>
<%@ page import ="beans.PagoDTO"%>
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
    	     ContactoDTO obj=(ContactoDTO) request.getAttribute("registro");
    	     Contacto_AdicionalDTO obj1=(Contacto_AdicionalDTO) request.getAttribute("registroA");
             %>
             
			<form action="ServletContactoAdicional?tipo=registra_adicional" id="frmagregar" method="post">
			<input type="hidden" name="txt_codigoContacto"
			value="<%=obj.getCodigo_contacto()%>" >
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>DATOS ADICIONALES</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">Codigo Contacto</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text"  
						 data-min-length="8" placeholder="Ingrese Descripcion "  name="txt_codigo_tipo" class="required"
					     value="<%=obj.getCodigo_contacto()%>" pattern="[0-9]{3,5}" required="required">
					</span>
					
					 <label for ="txt_des">Forma Pago</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_pago" class="required" data-min-length="8">
							<c:forEach items="${requestScope.pago}" var="d">
								<option value="${d.codigo_pago}">${d.forma_pago}</option>
							</c:forEach>
					    </select>
					</span>
					
					<label for ="txt_des">Dni:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text"  
						 data-min-length="8" placeholder="Ingrese Descripcion" name="txt_dni" class="required"
						 pattern="[0-9]{8}" required="required">
					</span>
					
					<label for ="txt_razon_social">Razon Social:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_razon_social" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " 
						 pattern="[A-Za-z\. ]{3,100}" required="required">
					</span>
					
					<label for ="txt_direccion">Direccion:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_direccion" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" required="required">
					</span>
					 <label for ="txt_telefono">Telefono</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_telefono" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " 
						  pattern="[0-9\-]{9,10}" required="required">
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
