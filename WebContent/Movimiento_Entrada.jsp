<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.AlmacenDTO" %>

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
			<form action="ServletAlmacen?tipo=registrarEntrada" id="frmagregar" method="post">
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO ENTRADA</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_codigo_tipo">PRODUCTO</label>
					<span class="req-input" >
					 <span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						 <select name="cbn_producto" class="required" data-min-length="8">
							<c:forEach items="${requestScope.producto}" var="d">
								<option value="${d.codigo}">${d.nombre}</option>
							</c:forEach>
					    </select>
					</span>
					<label for ="txt_codigo_ruc">CANTIDAD</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<input  type="text" name="txt_cantidad" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[0-9]{1,10}" required="required">
					</span>
					<label for ="txt_dni">FECHA</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
							 <input  type="date" name="txt_fecha" class="required" style="width:92.6%;height:100%;padding-left:10px"
						      data-min-length="8" required="required">
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
                                <th>Codigo Entrada</th>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Fecha</th>
								
								<th colspan="1">ACCIONES</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <%
                                            ArrayList<AlmacenDTO> lista = (ArrayList<AlmacenDTO>) request.getAttribute("data");
                							if (lista != null) {
                								for (AlmacenDTO xAlu : lista) {
                						%>
                						<tr>
                							<td><%=xAlu.getCodigo_entrada()%></td>
                							<td><%=xAlu.getNombre_producto()%></td>
                							<td><%=xAlu.getCantidad_entrada()%></td>
                							<td><%=xAlu.getFecha_entrada()%></td>
                							


                							<td align="center">
                							 <a
                								href='ServletContacto?tipo=eliminarContacto&codigo_contacto=<%=xAlu.getCodigo_entrada()%>'>
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
