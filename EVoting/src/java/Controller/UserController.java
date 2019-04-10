/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDao;
import Models.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author afrin
 */
public class UserController extends HttpServlet {
    private String action;
    private UserDao userDao;
    public UserController() throws SQLException{
         super();
         userDao = new UserDao();
       }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        action = request.getParameter("action");
        
        if(action.trim().equalsIgnoreCase("register".trim())){
            
            String username = request.getParameter("username");
            String phoneNo = request.getParameter("phoneNo");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            User user = new User();
            user.setName(username);
            user.setPhoneNo(phoneNo);
            user.setEmail(email);
            user.setPassword(password);
            
            boolean success = userDao.registerUser(user);
               if (success){
                   response.sendRedirect("/login.jsp");
                   //request.setAttribute("success", true);
            }
            else {
                request.setAttribute("error", false);
                response.sendRedirect("/register.jsp");
                
           } 
        
      }
        if(action.trim().equalsIgnoreCase("login".trim())){
          boolean success = userDao.loginUser(request.getParameter("Username"), request.getParameter("Password"));
          if(success){
              HttpSession session=request.getSession();
              session.setAttribute("isLogin", "login");
              RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
              rd.include(request, response);
               
          }
          else{
              response.sendRedirect("/login.jsp");
          }
      }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
         
    }
    
    }




