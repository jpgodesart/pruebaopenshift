<%@page import="net.daw.bean.UsuarioBean"%>
<%UsuarioBean user = (UsuarioBean) request.getSession().getAttribute("usuarioBean");%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Gestion de Tareas</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/main.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
        <script src="./js/vendor/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="css/gestordetareas.css">

    </head>
    <body>
        <!--[if lt IE 7]>
        <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->


        <div class="navbar navbar-inverse navbar-fixed-top">
            <div id="barra" class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span> 
                        <span class="icon-bar"></span>
                    </a> 
                    <a class="brand" href="jsp"><img id="imglogo" src="img/LOGO.jpg"/></a>                   
                    <div class="nav-collapse collapse">
                        <%if (user != null) {%>
                        <jsp:include page="jsp/menuSuperior.jsp" />   
                        <% }%>
                        <jsp:include page="jsp/usuario/infologin.jsp" />                        
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <%
                    //if (user != null) {
                     //   out.print("<div class=\"span2\">");
                %>
               <!-- <//jsp:include page="jsp/menuLateral.jsp" /> -->
                <%
                      //  out.print("</div>");
                   // }
                %>
                <%
                    if (user != null) {
                        out.print("<div class=\"span12\">");
                        out.print("<div id=\"indexContenido\"></div>");
                    } else {
                        out.print("<div class=\"span12\">");
                    }
                %>
                <div id="indexContenidoJsp">
                    <jsp:include page='<%=(String) request.getAttribute("contenido")%>' />                
                </div>
                <%
                    out.print("</div>");
                %>    
                <div class="row-fluid">
                    <div class="span12"><hr><footer><p>&copy; Juan Pérez (2014)</p></footer></div>   
                </div>
            </div>
        </div>                    

        <!-- carga de javascript -->

        <script src="js/vendor/bootstrap.min.js"></script>

        <script src="js/vendor/bootstrap-transition.js"></script>
        <script src="js/vendor/bootstrap-alert.js"></script>
        <script src="js/vendor/bootstrap-modal.js"></script>
        <script src="js/vendor/bootstrap-dropdown.js"></script>
        <script src="js/vendor/bootstrap-scrollspy.js"></script>
        <script src="js/vendor/bootstrap-tab.js"></script>
        <script src="js/vendor/bootstrap-tooltip.js"></script>
        <script src="js/vendor/bootstrap-popover.js"></script>
        <script src="js/vendor/bootstrap-button.js"></script>
        <script src="js/vendor/bootstrap-collapse.js"></script>
        <script src="js/vendor/bootstrap-carousel.js"></script>
        <script src="js/vendor/bootstrap-typeahead.js"></script>    

        <script src="js/util.js" charset="UTF-8"></script>
        <script src="js/main.js" charset="UTF-8"></script>

        <script src="js/control/alumno.js" charset="UTF-8"></script>
        <script src="js/control/usuario.js" charset="UTF-8"></script>
        <script src="js/control/estado.js" charset="UTF-8"></script>
        <script src="js/control/profesor.js" charset="UTF-8"></script>
        <script src="js/control/proyecto.js" charset="UTF-8"></script>
        <script src="js/control/tarea.js" charset="UTF-8"></script>
        <script src="js/control/usupro.js" charset="UTF-8"></script>
        <script src="js/control/usutarea.js" charset="UTF-8"></script>
        <script src="js/control/usuproyec.js" charset="UTF-8"></script>

        <script>

            $(document).ready(function() {
                inicializacion();
                $('#lnkAlumno').unbind('click');
                $('#lnkAlumno').click(function() {
                    var alumno = objeto('alumno', '<%=request.getContextPath()%>');
                    var alumnoView = vista(alumno, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(alumnoView.getEmptyList());

                    var alumnoControl = control_alumno_list('<%=request.getContextPath()%>');
                    alumnoControl.inicia(alumnoView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                $('#lnkEstado').unbind('click');
                $('#lnkEstado').click(function() {
                    var estado = objeto('estado', '<%=request.getContextPath()%>');
                    var estadoView = vista(estado, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(estadoView.getEmptyList());

                    var estadoControl = control_estado_list('<%=request.getContextPath()%>');
                    estadoControl.inicia(estadoView, 1, null, null, 10, null, null, null, null);
                    return false;
                });


                $('#lnkUsuario').unbind('click');
                $('#lnkUsuario').click(function() {
                    var usuario = objeto('usuario', '<%=request.getContextPath()%>');
                    var usuarioView = vista(usuario, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(usuarioView.getEmptyList());

                    var usuarioControl = control_usuario_list('<%=request.getContextPath()%>');
                    usuarioControl.inicia(usuarioView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkProfesor').unbind('click');
                $('#lnkProfesor').click(function() {
                    var profesor = objeto('profesor', '<%=request.getContextPath()%>');
                    var profesorView = vista(profesor, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(profesorView.getEmptyList());

                    var profesorControl = control_profesor_list('<%=request.getContextPath()%>');
                    profesorControl.inicia(profesorView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkProyecto').unbind('click');
                $('#lnkProyecto').click(function() {
                    var proyecto = objeto('proyecto', '<%=request.getContextPath()%>');
                    var proyectoView = vista(proyecto, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(proyectoView.getEmptyList());

                    var proyectoControl = control_proyecto_list('<%=request.getContextPath()%>');
                    proyectoControl.inicia(proyectoView, 1, null, null, 10, null, null, null, null);
                    return false;
                });

                $('#lnkTarea').unbind('click');
                $('#lnkTarea').click(function() {
                    var tarea = objeto('tarea', '<%=request.getContextPath()%>');
                    var tareaView = vista(tarea, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(tareaView.getEmptyList());

                    var tareaControl = control_tarea_list('<%=request.getContextPath()%>');
                    tareaControl.inicia(tareaView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                $('#lnkUsupro').unbind('click');
                $('#lnkUsupro').click(function() {
                    var usupro = objeto('usupro', '<%=request.getContextPath()%>');
                    var usuproView = vista(usupro, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(usuproView.getEmptyList());

                    var usuproControl = control_usupro_list('<%=request.getContextPath()%>');
                    usuproControl.inicia(usuproView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                 $('#lnkUsutarea').unbind('click');
                $('#lnkUsutarea').click(function() {
                    var usutarea = objeto('usutarea', '<%=request.getContextPath()%>');
                    var usutareaView = vista(usutarea, '<%=request.getContextPath()%>');

                    $('#indexContenidoJsp').empty();
                    $('#indexContenido').empty().append(usutareaView.getEmptyList());

                    var usutareaControl = control_usutarea_list('<%=request.getContextPath()%>');
                    usutareaControl.inicia(usutareaView, 1, null, null, 10, null, null, null, null);
                    return false;
                });
                
                
            });

        </script>
    </body>
</html>

