<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard 2</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
   
</head>

<body>
        <jsp:include page="Main_Vendor.jsp" />
        
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar2">
            <div class="logo">
                <a href="index.jsp">
                    <img src="images/icon/logo-white.png" alt="Digital Business" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="images/icon/avatar.jpg" alt="USUARIO" />
                    </div>
                    <h4 class="name">Usuario</h4>
                    <a href="Login.jsp">Cerrar Sesion</a>
                </div>
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                        <li>
                          <a class="js-arrow" href="#">
                              <i class="zmdi zmdi-settings"></i>Configuracion
                              <span class="arrow">
                                  <i class="fas fa-angle-down"></i>
                              </span>
                          </a>
                          <ul class="list-unstyled navbar__sub-list js-sub-list">
                              <li>
                                  <a href="Index.jsp">
                                      <i class="fas fa-building"></i>Empresa</a>
                              </li>
                              
                              <li>
                               <a class="js-arrow" href="ServletEmpleado?tipo=listar">
                                <i class="fas fa-copyright"></i>Usuario
                           
                               </a>
                               
                                  
                              
                                  
                              </li>
                              <li>
                                  <a href="Index.jsp">
                                      <i class="fas fa-dollar-sign"></i>Cuentas contable</a>
                              </li>
                              <li>
                                  <a href="ServletPago?tipo=listarPago">
                                      <i class="far fa-credit-card"></i>Forma de pago</a>
                              </li>
                              <li>
                                  <a href="ServletBanco?tipo=listarBanco">
                                      <i class="fas fa-university"></i>Banco</a>
                              </li>
                              
                              <li>
                               <a class="js-arrow" href="ServletMarca?tipo=listar">
                                <i class="fas fa-copyright"></i>Marcas
                               
                               </a>
                               
                                  
                                  
                              </li>
                          </ul>

                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-box"></i>Articulo
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ServletProducto?tipo=combomarca">
                                        <i class="fas fa-plus-square"></i>Crear</a>
                                </li>
                                <li>
                                    <a href="ServletProducto?tipo=listar">
                                        <i class="fab fa-searchengin"></i>Consultar</a>
                                </li>
                            </ul>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="far fa-address-book"></i>Contacto
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ServletContacto?tipo=cargarcontacto">
                                        <i class="fas fa-plus-square"></i>Crear</a>
                                </li>
                                <li>
                                    <a href="ServletContacto?tipo=listarContacto">
                                        <i class="fab fa-searchengin"></i>Consultar</a>
                                </li>
                            </ul>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-clipboard-check"></i></i>Ventas
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ServletVenta?tipo=comboempleado">
                                        <i class="fas fa-plus-square"></i>Orden de Venta</a>
                                </li>
                                <li>
                                    <a href="ServletVenta?tipo=listarVenta">
                                        <i class="fab fa-searchengin"></i>Consultar Ventas</a>
                                </li>
                              
                                
                                <li>
                                    <a href="ServletVenta?tipo=cargaregistrofactura">
                                        <i class="fas fa-plus-square"></i>Factura Venta</a>
                                </li>
                                <li>
                                    <a href="ServletVenta?tipo=listarFactura">
                                        <i class="fab fa-searchengin"></i>Consultar Factura Venta</a>
                                </li>
                                
                            </ul>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-shopping-bag"></i>Compras
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
							<li><a href="ServletCompra?tipo=comboempleado"> <i
									class="fas fa-plus-square"></i>Añadir Compra
							</a></li>
							<li><a href="ServletCompra?tipo=listarCompra"> <i
									class="fab fa-searchengin"></i>Consultar Compra
							</a></li>

							<li><a href="ServletCompra?tipo=cargaRegistroFactura"> <i
									class="fas fa-plus-square"></i>Añadir Factura Compra
							</a></li>


							<li><a href="ServletCompra?tipo=listarFacturaCompra"> <i
									class="fab fa-searchengin"></i>Consultar Factura Compra
							</a></li>

							
						</ul></li>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-warehouse"></i>Almacen
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="ServletAlmacen?tipo=cargar&cod=1">
                                        <i class="fas fa-plus-square"></i>Movimiento Entrada</a>
                                </li>
                                <li>
                                    <a href="ServletAlmacen?tipo=cargar&cod=2">
                                        <i class="fab fa-searchengin"></i>Movimiento Salida</a>
                                </li>
                            </ul>
                        </li>
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-dollar-sign"></i>Cartera
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                
                                <li>
                                    <a href='ServletVenta?tipo=listarXestado&cod=1'>
                                        <i class="fab fa-searchengin"></i>Cobros Pendientes</a>
                                </li>
                                <li>
                                    <a href='ServletVenta?tipo=listarXestado&cod=2'>
                                        <i class="fas fa-plus-square"></i>Cobrados</a>
                                </li>
                                <li>
                                    <a href="Pagos_Pendientes.jsp">
                                        <i class="fab fa-searchengin"></i>Pagos Pendientes</a>
                                </li>
                                <li>
                                    <a href="Pagados.jsp">
                                        <i class="fas fa-plus-square"></i>Pagados</a>
                                </li>
                            </ul>
                        </li>


                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-flag-checkered"></i>Informes
                                <span class="arrow">
                                    <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="Ventas_XFecha.jsp">
                                        <i class="fab fa-searchengin"></i>Ventas por Fecha</a>
                                </li>
                                <li>
                                    
                                    <a href="ServletCompra?tipo=cargaproveedor">
                                        <i class="fab fa-searchengin"></i>Compras por Proveedor</a>    
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        
    
      

</body>

</html>
<!-- end document-->