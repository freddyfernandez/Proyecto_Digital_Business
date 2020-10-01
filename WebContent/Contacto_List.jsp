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
             
             

               
                    
                    	<h2>
				        <strong>Listado de Contacto</strong>
			            </h2>
			            <p>Listado de contactos registradas a la fecha</p>
	
		
                      

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
								<th colspan="3">ACCIONES</th>
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


                							<td align="center">
                							<a
                								href='ServletContactoAdicional?tipo=cargar_registro&cod=<%=xAlu.getCodigo_contacto()%>'>
                									<img src='images/img-01.png' title='Datos adicionales' height="16px"
                									width="16px">
                							</a>
                							<a
                								href='ServletContacto?tipo=buscarContacto&codigo_contacto=<%=xAlu.getCodigo_contacto()%>'>
                									<img src='images/edit.png' title='Editar' height="16px"
                									width="16px">
                							</a>
                							 <a
                								href='ServletContacto?tipo=eliminarContacto&codigo_contacto=<%=xAlu.getCodigo_contacto()%>'>
                									<img src='images/delete.png' title='Eliminar' height="16px"
                									width="16px">
                							</a>
                							
                							</td>

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
