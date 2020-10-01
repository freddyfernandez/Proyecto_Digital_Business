<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.ContactoDTO" %>
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
             %>
			<form action="ServletContacto?tipo=actualizarContacto" id="frmagregar" method="post">
			<input type="hidden" name="txt_codigoContacto"
			value="<%=obj.getCodigo_contacto()%>" >
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>ACTUALIZACION DE CONTACTOS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">Codigo Tipo:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text"  
						 data-min-length="8" placeholder="Ingrese Descripcion "  name="txt_codigo_tipo" class="required"
					     value="<%=obj.getCodigo_tipo()%>" pattern="[1-2]{1}" required="required">
					</span>
					
					 <label for ="txt_des">Codigo RUC:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Actuailice RUC de 11 digitos"></span>
						<input  type="text"  
						 data-min-length="8" placeholder="Ingrese Descripcion "  name="txt_codigo_ruc" class="required"
					value="<%=obj.getCodigo_ruc()%>" pattern="[0-9]{11}" required="required">
					</span>
					
					<label for ="txt_des">Dni:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text"  
						 data-min-length="8" placeholder="Ingrese Descripcion "  name="txt_dni" class="required"
					value="<%=obj.getDni()%>" pattern="[0-9]{8}" required="required">
					</span>
					
					<label for ="txt_razon_social">Razon Social:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_razon_social" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " value="<%=obj.getRazon_social()%>"
						 pattern="[A-Za-z\. ]{3,100}" required="required">
					</span>
					
					<label for ="txt_direccion">Direccion:</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_direccion" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " value="<%=obj.getDireccion()%>" required="required">
					</span>
					 <label for ="txt_telefono">Telefono</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Ingrese numero de 9 a 10 digitos"></span>
						<input  type="text" name="txt_telefono" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " value="<%=obj.getTelefono()%>" pattern="[0-9\-]{9,10}" required="required">
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

                       <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                              <th>Codigo De Contacto</th>
								<th>Codigo Tipo</th>
								<th>Codigo Ruc</th>
								<th>DNI</th>
								<th>Razon Social</th>
								<th>Direccion</th>
								<th>Telefono</th>
								<th colspan="2">ACCIONES</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <%
                                            ArrayList<ContactoDTO> lista = (ArrayList<ContactoDTO>) request.getAttribute("data");
                							if (lista != null) {
                								for (ContactoDTO xAlu : lista) {
                						%>
                						<tr>
                							<td><%=xAlu.getCodigo_contacto()%></td>
                							<td><%=xAlu.getCodigo_tipo()%></td>
                							<td><%=xAlu.getCodigo_ruc()%></td>
                							<td><%=xAlu.getDni()%></td>
                							<td><%=xAlu.getRazon_social()%></td>
                							<td><%=xAlu.getDireccion()%></td>
                							<td><%=xAlu.getTelefono()%></td>


                							<td align="center"><a
                								href='ServletContacto?tipo=buscarContacto&codigo_contacto=<%=xAlu.getCodigo_contacto()%>'>
                									<img src='images/edit.png' title='Editar' height="16px"
                									width="16px">
                							</a> <a
                								href='ServletContacto?tipo=eliminarContacto&codigo_contacto=<%=xAlu.getCodigo_contacto()%>'>
                									<img src='images/delete.png' title='Eliminar' height="16px"
                									width="16px">
                							</a></td>

                						</tr>


                						<%
                							}
                							}
                						%>

                                            
                                            
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE-->
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
