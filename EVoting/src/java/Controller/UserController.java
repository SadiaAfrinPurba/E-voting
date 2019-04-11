/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CandidateDao;
import DAO.ElectionDao;
import DAO.ResultDao;
import DAO.UserDao;
import Models.Candidate;
import Models.Election;
import Models.Result;
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
    private ResultDao resultDao;
    private HttpSession session = null;
    public UserController() throws SQLException{
         super();
         userDao = new UserDao();
         electionDao = new ElectionDao();
         candidateDao = new CandidateDao();
         resultDao = new ResultDao();
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
        PrintWriter out = response.getWriter();
        
        action = request.getParameter("action");
        
        //Fetch Election info
        Election election = electionDao.getAllElectionInfo();
        request.setAttribute("setElectionInfo", election);
            
        //Fetch Candidate info
        List<Candidate> candidateList = new ArrayList<Candidate>();
        candidateList = candidateDao.getAllUsers();
        request.setAttribute("setCandidateInfo",candidateList);
        
         //Fetch Result info
          List<Result> resultList = new ArrayList<Result>();
          resultList = resultDao.getAllResult();
          request.setAttribute("setResultInfo",resultList);
       
 
       
        
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
                   
            }
            else {
                out.println("<h5> Username or Password is already taken! </h5>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
                rd.include(request, response);
                
           } 
        
      }
        if(action.trim().equalsIgnoreCase("login".trim())){
          boolean success = userDao.loginUser(request.getParameter("Username"), request.getParameter("Password"));
          if(success){
              
              //create a new user session
              session=request.getSession();
              session.setAttribute("isLogin","user");
               
             //response.sendRedirect("/homepage.jsp"); no info from db will be shown
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
              rd.forward(request, response);
               
          }
          else{
             
              out.println("<h5> Username or Password is Wrong! </h5>");
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
              rd.include(request, response);
          }
      }
      if(action.trim().equalsIgnoreCase("logout".trim())){
          session.removeAttribute("User");
          session.invalidate();
          
          //Prevent back button to login
          response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
          response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
          response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
          response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
          
          RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
          rd.forward(request, response);

          
      }
      if(action.trim().equalsIgnoreCase("vote".trim())){
          
          String values = request.getParameter("vote");
          String[] value = values.split(" "); 
          int cID = Integer.valueOf(value[1]);
          int vote = 1;
          //count new vote
          boolean success = resultDao.countVote(cID,vote,candidateList);
          if(success){
              RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
              rd.forward(request, response);
              
          }
          else{
               RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
               rd.include(request, response); 
          }
         
          
      }
      
      if(action.trim().equalsIgnoreCase("forgetPassword".trim())){
          boolean success = userDao.forgetPassword(request.getParameter("Username"), request.getParameter("Password"));
           if(success){
              out.println("<h5> Successfully password is changed ! </h5>");
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgetPassword.jsp");
              rd.include(request, response);
               
          }
          else{
             
              out.println("<h5> Invalid username </h5>");
              RequestDispatcher rd = getServletContext().getRequestDispatcher("/forgetPassword.jsp");
              rd.include(request, response);
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




