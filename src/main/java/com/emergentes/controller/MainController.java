package com.emergentes.controller;
import com.emergentes.bean.BeanEstudiante;
import com.emergentes.entidades.Estudiante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
             BeanEstudiante dao = new BeanEstudiante();
            Estudiante est = new Estudiante();
            switch (action) {
                case "add":
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmEstudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est= dao.buscar(id);
                    request.setAttribute("estudiante", est);
                    request.getRequestDispatcher("frmEstudiante.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    response.sendRedirect("MainController");
                case "view":
                    List<Estudiante> lista = dao.listarTodos();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR:" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanEstudiante dao = new BeanEstudiante();
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fecha_nac = request.getParameter("fecha_nac");
        Estudiante est = new Estudiante();
        est.setId(id);
        est.setNombre(nombre);
        est.setApellido(apellido);
        est.setEmail(email);
        est.setFechaNac(fecha_nac);
        if (id == 0) {
            
                //nuevo registro
                dao.insertar(est);
              
        } else if (id != 0) {
                dao.modificar(est);
               

           
        }
        response.sendRedirect("MainController");
      
    }
/*
    private void nuevo() {
        Estudiante est = new Estudiante();
        BeanEstudiante dao = new BeanEstudiante();
        est.setNombre("");
        est.setApellido("");
        est.setEmail("");
        est.setFechaNac(null);
        dao.Insertar(est);
    }

    private void mostrar() {
        BeanEstudiante dao = new BeanEstudiante();
        List<Estudiante> lista = dao.listarTodos();
        for (Estudiante item : lista) {
            System.out.println(item.toString());
        }
    }

    private void eliminar(int id) {
        BeanEstudiante dao = new BeanEstudiante();
        
        dao.eliminar(id);

    }

    private void editar(int id) {
        BeanEstudiante dao = new BeanEstudiante();
        Estudiante est = dao.buscar(id);
        est.setNombre("");
        est.setApellido("");
        est.setEmail("");
        est.setFechaNac(null);
        dao.modificar(est);

    }
*/
}
