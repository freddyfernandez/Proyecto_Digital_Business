<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.Factura_CompraDTO" %>
<%@ page import ="beans.ContactoDTO" %>
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
			<form action="ServletCompra?tipo=facturasXproveedor" id="frmagregar" method="post">
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>Compras Por Proveedor</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">Nombre Proveedor</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Input Your First and Last Name."></span>
						<select name="cbn_proveedor" class="required" data-min-length="8">
							<c:forEach items="${requestScope.proveedor}" var="d">
								<option value="${d.codigo_contacto}">${d.razon_social}</option>
							</c:forEach>
					    </select>
					</span>
					
				</div>
				
				</div>
				<div class="row submit-row">
					<button type="submit" value="Consultar" class="btn btn-block submit-form">Consultar</button>
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
                                                <th>CODIGO FACTURA</th>
                                                <th>CODIGO COMPRA</th>
                                                <th>NOMBRE PROVEEDOR</th>
                                                <th>MONTO TOTAL</th>
                                                <th>FECHA</th>
                                                <th>ESTADO</th>
                                                
                                                
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <%
         ArrayList<Factura_CompraDTO> lista=(ArrayList<Factura_CompraDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (Factura_CompraDTO xAlu: lista){
        		 %>
                 <tr>
        		 <td><%=xAlu.getCodigo_factura()%></td>
        		 <td><%=xAlu.getCodigo_compra()%></td>
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
