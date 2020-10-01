<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.EmpleadoDTO" %>
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
			<form action="ServletEmpleado?tipo=registrar" id="frmagregar" method="post">
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DE EMPLEADOS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">Nombre</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo Letras de 3 a 30 caracteres"></span>
						<input  type="text" name="txt_des" class="required"
						 data-min-length="8" placeholder="Ingrese Nombre" pattern="[A-Za-z ]{3,30}" required="required">
					</span>
					<label for ="txt_ape">Apellido</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo Letras de 3 a 60 caracteres."></span>
						<input  type="text" name="txt_ape" class="required"
						 data-min-length="8" placeholder="Ingrese Apellido" pattern="[A-Za-z ]{3,60}" required="required">
					</span>
					<label for ="txt_ape">USUARIO</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo Letras de 5 a 20 caracteres."></span>
						<input  type="text" name="txt_log" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " class="required" 
						 pattern="[A-Za-z0-9]{5,20}" required="required">
					</span>
					<label for ="txt_ape">PASSWORD</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Numeros o Letras de 5 a 20 caracteres"></span>
						<input type="password" name="txt_pas" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion " class="required"
						 pattern="[A-Za-z0-9]{5,20}" required="required">
					</span>
					<label for ="txt_ape">DETALLE</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Ingrese hasta  1000 caracteres"></span>
						<input  type="text" name="txt_det" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" class="required" required="required">
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
                                                <th>CODIGO </th>
          <th> NOMBRE</th>
          <th> APELLIDO</th>
          <th>LOGIN </th>
          <th> PASSWORD</th>
          <th> DETALLES</th>
          <th colspan= "2"> ACCIONES</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <%
         ArrayList<EmpleadoDTO> lista=(ArrayList<EmpleadoDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (EmpleadoDTO xAl: lista){
        		 %>
                 <tr>
        		<td><%=xAl.getCodigo()%></td>
        		 <td><%=xAl.getNombre()%></td>
        		 <td><%=xAl.getApellido()%></td>
        		 <td><%=xAl.getLogin()%></td>
        		 <td><%=xAl.getPassword()%></td>
        		 <td><%=xAl.getDetalle()%></td>
        		 
        		  <td align="center">
        		    <a  href ='ServletEmpleado?tipo=buscar&cod=<%=xAl.getCodigo()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletEmpleado?tipo=eliminar&cod=<%=xAl.getCodigo()%>'>
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
