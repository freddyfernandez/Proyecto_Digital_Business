<%@ page import = "java.util.ArrayList" %>
<%@ page import = "beans.ProductoDTO" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
  
    <!--SCRIPT-->
    
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
             
             <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40" >
                                    <table class="table table-borderless table-data3" id="mydatatable">
                                        <thead>   
                <tr>
          <th>CODIGO </th>
          <th>NOMBRE</th>
          <th>MARCA</th>
          <th>PRECIO UNITARIO</th>
          <th>STOCK</th>
          <th>CARACTERISTICAS</th>
          <th>ACCIONES</th>         
       </tr>                         
            </thead>
            
             <tfoot>
            <tr>
               
                
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
               
           
             
           
               
            </tr>
        </tfoot>
            <tbody>
            <%
         ArrayList<ProductoDTO> lista=(ArrayList<ProductoDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (ProductoDTO xAlu: lista){
        		 %>
                 <tr>
        		 <td><%=xAlu.getCodigo()%></td>
        		 <td><%=xAlu.getNombre()%></td>
        		 <td><%=xAlu.getMarca()%></td>
        		 <td><%=xAlu.getPrecio()%></td>
        		 <td><%=xAlu.getStock()%></td>
        		 <td><%=xAlu.getCaracteristicas()%></td>
        	     <td align="center">
        		    <a  href ='ServletProducto?tipo=buscar&cod=<%=xAlu.getCodigo()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletProducto?tipo=eliminar&cod=<%=xAlu.getCodigo()%>'>
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
