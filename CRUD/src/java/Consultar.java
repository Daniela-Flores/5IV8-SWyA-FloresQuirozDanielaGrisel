

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



public class Consultar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar</title>");      
             out.println("<link rel='stylesheet' type='text/css' href='CSS/login.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='tabla'>");
            out.println("<h1>Tabla General de Usuarios</h1>");
            out.println("<table border='2' class='container'>"
                    + "<thead>"
                        + "<tr><th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Email</th></tr>"
                    + "</thead>");
                out.println("<div>");
            try{
                //codigo java para la consulta
                String nom, appat, apmat, correo;
                int edad, id;
                
                //tenemos que crear la querry
                
                String q = "select * from Mregistro";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                
                while(rs.next()){
                //mientras exista un registro hay que obtener los datos de la consulta
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("correo_usu");
                    
                    out.println("<tbody>"
                            + "<tr><td>"+id+"</td>"
                            + "<td>"+nom+" "+appat+" "+apmat+" </td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+correo+"</td></tr>"
                            + "</tbody>");
                }
                //hay que cerrar los hilos
                rs.close();
                set.close();
                
                System.out.println("Consulta Exitosa");
            
            
            }catch(Exception e){
                System.out.println("Error al realizar la consulta");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            out.println("</table>");
            
            
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    );
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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