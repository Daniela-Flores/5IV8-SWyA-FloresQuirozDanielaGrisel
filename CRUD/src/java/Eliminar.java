

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import java.sql.ResultSet;
import javax.servlet.ServletConfig;


public class Eliminar extends HttpServlet {


    //variables globales
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //el constructor del servlet
    //nos va a ayudar a inicializar la conexion con la bd
    
    public void init(ServletConfig cfg) throws ServletException{
        
        //lo primero que necesitamos es trazar la ruta al servidor DB
        String URL = "jdbc:mysql:3306//localhost/registro";
        //driver:gestor:puerto//IP/nombreBD
        
        String userName = "root";
        String password = "dfloresq";
        
        try{
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            
            /*
            en algunas ocaciones enviar error al conectarse con la bd
            y eso se debe a que ya estegrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8";
            */
            URL = "jdbc:mysql://localhost/registro";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //para eliminar necesitamos obtener el id
            
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            
            //preparo mi sentencia
            //delete from tabla where atributo = valor
            
            String q = "delete from Mregistro where id_usu = "+id;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>");   
              
         out.println("<link rel='stylesheet' type='text/css' href='CSS/login.css'>");

            out.println("</head>");
            out.println("<body>");
            try{
                
            set.executeUpdate(q);
            
             out.println("<div class='container'>");
            out.println("<h1>Usuario Eliminado</h1>");
            out.println("</div'>");
       
             set.close();
            }catch(Exception e){
                 out.println("<h1>"+"Usuario No Eliminado</h1>");
                out.println("No se pudo eliminar el usuario");
                out.println(e.getMessage());
               out.println(e.getStackTrace());
             
            }
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public void destroy(){
        try{
            con.close();
  
        
        }catch(Exception e){
            super.destroy();
        
        }
    }    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}