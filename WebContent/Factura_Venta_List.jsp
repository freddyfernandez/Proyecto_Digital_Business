<%@ page import = "java.util.ArrayList" %>
<%@ page import = "beans.Factura_VentaDTO" %>
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
             <div class="container-fluid">
                    
                    	<h2>
				<strong>Listado de Facturas</strong>
			</h2>
			
	</div>
             
             <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>   
                <tr>
          <th>CODIGO FACTURA</th>
          <th>CODIGO VENTA</th>
          <th>NOMBRE EMPLEADO</th>
          <th>ESTADO</th>
          <th>FECHA DE FACTURA</th>
         
          <th colspan= "2"> ACCIONES</th>
       </tr>                         
            </thead>
            <tbody>
            <%
         ArrayList<Factura_VentaDTO> lista=(ArrayList<Factura_VentaDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (Factura_VentaDTO xAlu: lista){
        		 %>
                 <tr>
        		 <td><%=xAlu.getCodigo_factura()%></td>
        		 <td><%=xAlu.getCodigo_venta()%></td>
        		 <td><%=xAlu.getNombre_empleado()%></td>
        		 <td><%=xAlu.getNombre_estado()%></td>
        		 <td><%=xAlu.getFecha()%></td>
        		
        		 <td align="center">
        		    
        		    <a  href ='ServletVenta?tipo=buscarFactura&cod=<%=xAlu.getCodigo_factura()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletVenta?tipo=eliminarFactura&cod=<%=xAlu.getCodigo_factura()%>'>
                	  <img  src='images/delete.png' title='Eliminar' height="16px" width="16px" ></a>
                 </td>
        		
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