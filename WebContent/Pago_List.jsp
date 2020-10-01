<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.PagoDTO"%>
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
          
              <form action="ServletPago?tipo=registrarPago" id="frmagregar" method="post">
			     <input type="hidden" name="txt_codigoPago"  >
			    <div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DE FORMAS DE PAGOS</span>
				</div>
				<div class="input-container">
				<div class="row">
				    <label for ="txt_nom">Nombre</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo letras mayor a 4 caracteres"></span>
						<input  type="text" data-min-length="8" placeholder="Ingrese Descripcion" 
						 name="txt_forma_pago" class="required" pattern="[A-Za-z]{5,30}" required="required">
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
								<th>Codigo De Pago</th>
								<th>Forma de Pago</th>

								<th colspan="2">ACCIONES</th>
							</tr>
						</thead>
						<tbody>
						<%
							ArrayList<PagoDTO> lista = (ArrayList<PagoDTO>) request.getAttribute("data");
							if (lista != null) {
								for (PagoDTO xAlu : lista) {
						%>
						<tr>
							<td><%=xAlu.getCodigo_pago()%></td>
							<td><%=xAlu.getForma_pago()%></td>


							<td align="center"><a
								href='ServletPago?tipo=buscarPago&codigo_pago=<%=xAlu.getCodigo_pago()%>'>
									<img src='images/edit.png' title='Editar' height="16px"
									width="16px">
							</a> <a
								href='ServletPago?tipo=eliminarPago&codigo_pago=<%=xAlu.getCodigo_pago()%>'>
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
