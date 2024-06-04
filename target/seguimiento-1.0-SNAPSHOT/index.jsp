<%@page import="com.emergentes.entidades.Estudiante"%>
<%@page import="java.util.List"%>
<%
    List<Estudiante> estudiantes = (List<Estudiante>) request.getAttribute("estudiantes");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="mystyle.css"/>
        <title>SEGUIMIENTO ACADEMICO</title>
        </head>
    <body>
        <br><br><br><br><br><br>
        <div>
            <h1>SEGUIMIENTO DE INFORMACION DE ESTUDIANTES</h1>
            <a href="MainController?action=add" id="btnAdd">  Nuevo registro</a><br>
            <table border="1" >
                <br>
                <tr id="cabecera">
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Email</th>
                    <th>Fecha de Nacimiento</th>
                    <th colspan="2">OPCIONES</th>
                </tr>
                <%
                for (Estudiante item: estudiantes){
                %>
                    <tr>
                        <td><%= item.getId()%></td>
                        <td><%= item.getNombre()%></td>
                        <td><%= item.getApellido()%></td>
                        <td><%= item.getEmail()%></td>
                        <td><%= item.getFechaNac()%></td>
                        <td><a id="btnEdit" href="MainController?action=edit&id=<%= item.getId()%>">EDITAR</a></td>
                        <td><a id="btnDelete" href="MainController?action=delete&id=<%= item.getId()%>" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                    </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>

