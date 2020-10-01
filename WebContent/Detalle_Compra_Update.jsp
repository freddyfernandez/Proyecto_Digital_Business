<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Detalle_CompraDTO"%>
<%@ page import="beans.ProductoDTO"%>
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
										Detalle_CompraDTO obj = (Detalle_CompraDTO) request.getAttribute("registro");
									%>
									<form action="ServletCompra?tipo=actualizarDetalleCompra"
										id="frmagregar" method="post">
										<input type="hidden" name="txt_codigoDetalle"
											value="<%=obj.getCodigo_detalle_compra()%>">
										<div id="contact-form" class="form-container"
											data-form-container>

											<div class="form-title">
												<span>Modificacion de Detalle Compra</span>
											</div>

											<div class="input-container">
												<div class="row">
													<label>CODIGO Compra</label> <span class="req-input">
														<span class="input-status" data-toggle="tooltip"
														data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_codigoCompra" class="required"
														value="<%=obj.getCodigo_compra()%>" data-min-length="8"
														placeholder="" pattern="[0-9]{5,10}" required="required">
													</span> <label>CODIGO PRODUCTO</label> <span class="req-input">
														<span class="input-status" data-toggle="tooltip"
														data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_codigoProducto" class="required"
														value="<%=obj.getCodigo_producto()%>" data-min-length="8"
														placeholder="" pattern="[0-9]{6,10}" required="required">
													</span>


													<!--  
					<label for ="txt_des">NOMBRE PRODUCTO</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_producto" class="required" data-min-length="8">
							<c:forEach items="${requestScope.producto}" var="d">
								<option value="${d.codigo}">${d.nombre}</option>
							</c:forEach>
					    </select>
					</span>
					
				-->
													<label for="txt_des">PRECIO Compra</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_precio_Compra" class="required"
														value="<%=obj.getPrecio_compra()%>" data-min-length="8"
														placeholder="Ingrese Descripcion " 
														pattern="[0-9\.]{1,10}" required="required">
													</span> <label for="txt_des">CANTIDAD</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_cantidad" class="required"
														value="<%=obj.getCantidad()%>" data-min-length="8"
														placeholder="Ingrese Descripcion "
														pattern="[0-9]{1,10}" required="required">
													</span> <label for="txt_des">DESCUENTO</label> <span
														class="req-input"> <span class="input-status"
														data-toggle="tooltip" data-placement="top"
														title="Input Your First and Last Name."></span> <input
														type="text" name="txt_descuento" class="required"
														value="<%=obj.getDescuento()%>" data-min-length="8"
														placeholder="Ingrese Descripcion "
														pattern="[0-9\.]{2,10}" required="required">
													</span>

												</div>

											</div>
											<div class="row submit-row">
												<button type="submit" value="Consultar"
													class="btn btn-block submit-form">Actualizar Datos</button>
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