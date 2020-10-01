<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.CompraDTO"%>
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

						<h2>
							<strong>Listado de Compras</strong>
						</h2>
						<p>Listado de compras efectuadas a la fecha</p>
					</div>

					<div class="row m-t-30">
						<div class="col-md-12">
							<!-- DATA TABLE-->
							<div class="table-responsive m-b-40">
								<table class="table table-borderless table-data3">
									<thead>
										<tr>
											<th>CODIGO</th>
											<th>FECHA</th>
											<th>EMPLEADO</th>
											<th>CLIENTE</th>
											<th colspan="3">ACCIONES</th>
										</tr>
									</thead>
									<tbody>
										<%
											ArrayList<CompraDTO> lista = (ArrayList<CompraDTO>) request.getAttribute("data");
											if (lista != null) {
												for (CompraDTO xAlu : lista) {
										%>
										<tr>

											<td><%=xAlu.getCodigo_compra()%></td>
											<td><%=xAlu.getFecha()%></td>
											<td><%=xAlu.getCodigo_empleado()%></td>
											<td><%=xAlu.getCodigo_cliente()%></td>

											<td align="center"><a
												href='ServletCompra?tipo=listarDetalleCompra&cod=<%=xAlu.getCodigo_compra()%>'>
													<img src='images/img-01.png' title='Detalles' height="16px"
													width="16px">
											</a> <a
												href='ServletCompra?tipo=buscarCompra&cod=<%=xAlu.getCodigo_compra()%>'>
													<img src='images/edit.png' title='Editar' height="16px"
													width="16px">
											</a> <a
												href='ServletCompra?tipo=eliminarCompra&cod=<%=xAlu.getCodigo_compra()%>'>
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