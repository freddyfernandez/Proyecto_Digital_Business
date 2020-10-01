<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>    
<%@ page import="beans.Factura_VentaDTO"%>    
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

						<h2>
							<strong>Listado de Facturas Cobradas</strong>
						</h2>
						
					</div>

					<div class="row m-t-30">
						<div class="col-md-12">
							<!-- DATA TABLE-->
							<div class="table-responsive m-b-40">
								<table class="table table-borderless table-data3">
									<thead>
										<tr>

											<th>CODIGO DE VENTA</th>
											<th>CLIENTE</th>
											<th>MONTO COBRADO</th>
											<th>FECHA DE SALIDA</th>
											<th>ESTADO</th>

											
										</tr>
									</thead>
									<tbody>

										<%
											ArrayList<Factura_VentaDTO> lista = (ArrayList<Factura_VentaDTO>) request.getAttribute("data");
											
											if (lista != null) {
												for (Factura_VentaDTO xAlu : lista) {
										%>
										<tr>											
											<td><%=xAlu.getCodigo_venta()%></td>
											<td><%=xAlu.getNombre_contacto()%></td>
											<td><%=xAlu.getMonto_total()%></td>
											<td><%=xAlu.getFecha()%></td>
											<td><%=xAlu.getNombre_estado()%></td>
											
										

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
