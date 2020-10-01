<%@ page import ="beans.BancoDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js" ></script>
<title>Insert title here</title>
</head>
<body>
  <%
  BancoDTO obj=(BancoDTO) request.getAttribute("registro");
   
  %>
  <form action="ServletBanco?tipo=actualizarBanco" id="frmagregar" method="post">
       <input type="hidden" name="txt_codigoBanco" value="<%=obj.getCodigo_banco() %>" >
       <table>
          <tr>
              <td>Nombre de Banco:</td>
              <td><input  type="text" name="txt_nombre_banco" class="required"  value="<%=obj.getNombre_banco() %>" 
              pattern="[A-Za-z ]{5,80}" required="required"></td>
          </tr>
          
          <tr>
              <td>Siglas de Banco:</td>
              <td><input  type="text" name="txt_siglas_banco" class="required"  value="<%=obj.getSiglas_banco() %>" 
              pattern="[A-Za-z]{3,30}" required="required"></td>
          </tr>
          
            <tr>
              <td colspan=2><input type="submit" value="Actualizar" class="boton2"></td>
          </tr>
       </table>
  </form>


</body>
</html>