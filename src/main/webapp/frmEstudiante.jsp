<%@page import="com.emergentes.entidades.Estudiante"%>
<%
    Estudiante est = (Estudiante) request.getAttribute("estudiante");
%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>GORMULARIO</title>
        <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
        <h1>FORMULARIO DE REGISTRO</h1>
        <form action="MainController" method="post">
            <div >
                <input type="hidden" name="id" value="<%= est.getId() %>">
            </div>   
            <div  >
                <label  >Nombre</label><br><br>
                <input type="text"  value="<%= est.getNombre()%>" name="nombre">

            </div>
            <div  >
                <label >Apellidos:</label><br><br>
                <input type="text" value="<%= est.getApellido()%>" name="apellido">
            </div>
            <div  >
                <label >correo electronico</label><br><br>
                <input type="email" value="<%= est.getEmail()%>" name="email">
            </div>
            <div  >
                <label >Fecha de nacimiento</label><br><br>
                <input type="date" value="<%= est.getFechaNac()%>" name="fecha_nac">
            </div><br><br>
            <button type="submit" id="btnEdit">GUARDAR</button>
        </form>



    </div>
</body>
</html>

