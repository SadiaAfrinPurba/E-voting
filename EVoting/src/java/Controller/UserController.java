/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CandidateDao;
import DAO.ElectionDao;
import DAO.UserDao;
import Models.Candidate;
import Models.Election;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ElectionDao electionDao;
    private CandidateDao candidateDao;
    private HttpSession session;
    public UserController() throws SQLException{
         super();
         userDao = new UserDao();
         electionDao = new ElectionDao();
         candidateDao = new CandidateDao();
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
            throws ServletException, IOException, SQLException {
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
              session=request.getSession(true);
              session.setAttribute("isLogin","user");
               
            //Fetch Election info
             Election election = electionDao.getAllElectionInfo();
            request.setAttribute("setElectionInfo", election);
            
            //Fetch Candidate info
             List<Candidate> candidateList = new ArrayList<Candidate>();
             candidateList = candidateDao.getAllUsers();
             request.setAttribute("setCandidateInfo",candidateList);
            
             //response.sendRedirect("/homepage.jsp"); no info from db will be shown
//
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
              rd.forward(request, response);
               
          }
          else{
              PrintWriter out = response.getWriter();
              out.println("<h5> Username or Password is Wrong! </h5>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    }




