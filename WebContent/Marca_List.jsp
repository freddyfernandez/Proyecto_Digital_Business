<%@ page import ="java.util.ArrayList" %>
<%@ page import ="beans.MarcaDTO" %>
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
			<form action="ServletMarca?tipo=registrar" id="frmagregar" method="post">
			<div id="contact-form" class="form-container" data-form-container>
			
				<div class="form-title">
					<span>REGISTRO DE MARCAS</span>
				</div>
			
			<div class="input-container">
				<div class="row">
				    <label for ="txt_des">Descripcion</label>
					<span class="req-input" >
						<span class="input-status" data-toggle="tooltip" data-placement="top" title="Solo letras mayor a un caracter"></span>
						<input  type="text" name="txt_des" class="required"
						 data-min-length="8" placeholder="Ingrese Descripcion" pattern="[A-Za-z ]{2,20}" required="required">
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
                                                <th>Codigo</th>
                                                <th>Descripcion</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        
                                        <tbody>
                                            <%
         ArrayList<MarcaDTO> lista=(ArrayList<MarcaDTO>) request.getAttribute("data");
         if (lista!=null){
        	 for (MarcaDTO xAlu: lista){
        		 %>
                 <tr>
        		<td><%=xAlu.getCodigo()%></td>
        		 <td><%=xAlu.getNombre()%></td>
        		  <td align="center">
        		    <a  href ='ServletMarca?tipo=buscar&cod=<%=xAlu.getCodigo()%>'>
        		      <img  src='images/edit.png' title='Editar' height="16px" width="16px" ></a>
        		    <a  href ='ServletMarca?tipo=eliminar&cod=<%=xAlu.getCodigo()%>'>
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
