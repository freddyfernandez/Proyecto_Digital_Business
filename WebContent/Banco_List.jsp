<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.BancoDTO"%>
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
									<form action="ServletBanco?tipo=registrarBanco" id="frmagregar"
										method="post">
										<div id="contact-form" class="form-container"
											data-form-container>

											<div class="form-title">
												<span>REGISTRO DE BANCO</span>
											</div>

											<div class="input-container">
												<div class="row">
													<label for="txt_nombre_banco">Nombre de Banco</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Solo letras mayor a 4 caracteres"></span> <input
														type="text" name="txt_nombre_banco" class="required"
														data-min-length="8" placeholder="Ingrese Nombre de Banco "
														pattern="[A-Za-z ]{5,80}" required="required">
													</span> 
													
													<label for="txt_siglas_banco">Siglas de Banco</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Solo letras mayor a 2 caracteres"></span> <input
														type="text" name="txt_siglas_banco" class="required"
														data-min-length="8" placeholder="Ingrese Siglas de Banco "
														pattern="[A-Za-z]{3,30}" required="required">
													</span>
												</div>

											</div>
											<div class="row submit-row">
												<button type="submit" value="Consultar"
													class="btn btn-block submit-form">Registrar Datos</button>
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
												<th>Codigo</th>
												<th>Nombre de Banco</th>
												<th>Siglas de Banco</th>
												<th>Acciones</th>
											</tr>
										</thead>

										<tbody>
											<%
												ArrayList<BancoDTO> lista = (ArrayList<BancoDTO>) request.getAttribute("data");
												if (lista != null) {
													for (BancoDTO xAlu : lista) {
											%>
											<tr>
												<td><%=xAlu.getCodigo_banco()%></td>
												<td><%=xAlu.getNombre_banco()%></td>
												<td><%=xAlu.getSiglas_banco()%></td>

												<td align="center"><a
													href='ServletBanco?tipo=buscarBanco&codigo_banco=<%=xAlu.getCodigo_banco()%>'>
														<img src='images/edit.png' title='Editar' height="16px"
														width="16px">
												</a> <a
													href='ServletBanco?tipo=eliminarBanco&codigo_banco=<%=xAlu.getCodigo_banco()%>'>
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
