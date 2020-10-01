<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Factura_CompraDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beans.ProductoDTO"%>
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

						<h2>
							<strong>Listado de Pagos Pendientes</strong>
						</h2>
		
					</div>

					<div class="row m-t-30">
						<div class="col-md-12">
							<!-- DATA TABLE-->
							<div class="table-responsive m-b-40">
								<table class="table table-borderless table-data3">
									<thead>
										<tr>

											<th>CODIGO DE FACTURA</th>
											<th>CODIGO DE COMPRA</th>
											<th>CODIGO DE EMPLEADO</th>
											<th>ESTADO</th>
											<th>FECHA</th>

											<th colspan="2">ACCIONES</th>
										</tr>
									</thead>
									<tbody>

										<%
											ArrayList<Factura_CompraDTO> lista = (ArrayList<Factura_CompraDTO>) request.getAttribute("data");
											double acum = 0;
											if (lista != null) {
												for (Factura_CompraDTO xAlu : lista) {
										%>
										<tr>

											<td><%=xAlu.getCodigo_factura()%></td>
											<td><%=xAlu.getCodigo_compra()%></td>
											<td><%=xAlu.getCodigo_empleado()%></td>
											<td><%=xAlu.getEstado()%></td>
											<td><%=xAlu.getFecha()%></td>
											<td align="center"><a
												href='ServletCompra?tipo=buscarFacturaCompra&cod=<%=xAlu.getCodigo_factura()%>'>
													<img src='images/edit.png' title='Editar' height="16px"
													width="16px">
											</a> <a
												href='ServletCompra?tipo=eliminarFacturaCompra&cod=<%=xAlu.getCodigo_factura()%>'>
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