<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Detalle_CompraDTO"%>
<%@ page import="beans.CompraDTO"%>
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
						<div class="container">
							<div class="row">

								<div class="col-md-9">

									<form action="ServletCompra?tipo=registrarDetalleCompra"
										id="frmagregar" method="post">
										<input type="hidden" name="tipo" id="metodo" >
										<div id="contact-form" class="form-container"
											data-form-container>

											<div class="form-title">
												<span>Registrar Detalle de Compra</span>
											</div>

											<div class="input-container">
												<div class="row">
													<label>CODIGO Compra</label> <span class="req-input">
														<span class="input-status" data-toggle="tooltip"
														data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_codigoCompra" class="required"
														data-min-length="8" placeholder="" 
														pattern="[0-9]{5,10}" required="required">
													</span> <label for="txt_des">NOMBRE PRODUCTO</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <select
														name="cbn_producto" class="required" data-min-length="8">
															<c:forEach items="${requestScope.producto}" var="d">
																<option value="${d.codigo}">${d.nombre}</option>
															</c:forEach>
													</select>
													</span> <label for="txt_des">PRECIO Compra</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_precio_Compra" class="required"
														data-min-length="8" placeholder="Ingrese Descripcion "
														pattern="[0-9\.]{1,10}" required="required">
													</span> <label for="txt_des">CANTIDAD</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_cantidad" class="required"
														data-min-length="8" placeholder="Ingrese Descripcion "
														pattern="[0-9]{1,10}" required="required">
													</span> <label for="txt_des">DESCUENTO</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_descuento" class="required"
														data-min-length="8" placeholder="Ingrese Descripcion"
														pattern="[0-9\.]{2,10}" required="required">
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

						<div class="main-content">

							<div class="section__content section__content--p30">
								<div class="container-fluid">

									<h2>
										<strong>Detalle de Compra</strong>
									</h2>
								</div>

								<div class="row m-t-30">
									<div class="col-md-12">
										<!-- DATA TABLE-->
										<div class="table-responsive m-b-40">
											<table class="table table-borderless table-data3">
												<thead>
													<tr>

														<th>CODIGO_COMPRA</th>
														<th>CODIGO_PRODUCTO</th>
														<th>PRECIO_COMPRA</th>
														<th>CANTIDAD</th>
														<th>DESCUENTO</th>
														<th>IMPORTE</th>

														<th colspan="2">ACCIONES</th>
													</tr>
												</thead>
												<tbody>

													<%
														ArrayList<Detalle_CompraDTO> lista = (ArrayList<Detalle_CompraDTO>) request.getAttribute("data");
														double acum = 0;
														if (lista != null) {
															for (Detalle_CompraDTO xAlu : lista) {
													%>
													<tr>

														<td><%=xAlu.getCodigo_compra()%></td>
														<td><%=xAlu.getCodigo_producto()%></td>
														<td><%=xAlu.getPrecio_compra()%></td>
														<td><%=xAlu.getCantidad()%></td>
														<td><%=xAlu.getDescuento()%></td>
														<td><%=xAlu.importeTotal()%></td>
													
														<td align="center"><a
															href='ServletCompra?tipo=buscarDetalleCompra&cod=<%=xAlu.getCodigo_detalle_compra()%>'>
																<img src='images/edit.png' title='Editar' height="16px"
																width="16px">
														</a> <a
															href='ServletCompra?tipo=eliminarDetalleCompra&cod=<%=xAlu.getCodigo_detalle_compra()%>'>
																<img src='images/delete.png' title='Eliminar'
																height="16px" width="16px">
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
								 <div class="form-container"  style="padding:0px;margin: -30px 0px 0px 0px;min-width:150px; ">
		            <input type="button" value="Facturar" onclick="addBoleta();"class="btn btn-block submit-form" style="width:18%;margin-left:41%"
		             >
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

    <script type="text/javascript">
	
	function addBoleta(){
		document.getElementById("metodo").value ='cargaRegistroFactura';
		document.getElementById("frmagregar").action = 'ServletCompra';
		document.getElementById("frmagregar").submit();
	}	   
    </script>


</body>
</html>
