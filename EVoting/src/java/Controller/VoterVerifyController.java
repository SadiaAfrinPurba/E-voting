/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VoterDao;
import Models.Voter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author afrin
 */
public class VoterVerifyController extends HttpServlet {
    
    private int nid;
    private String name;
    private Connection conn;
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private VoterDao voterDao;
    private List<String> securityQuesAns;
    private int count = 3;
    private String action;
    Voter voter;
    public VoterVerifyController() throws SQLException{
         super();
         voterDao = new VoterDao();
     }


   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            doGet(request,response);           
    }

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
       response.setContentType("text/html;charset=UTF-8");
       //PrintWriter out = response.getWriter();;
       action = request.getParameter("action");
       try (PrintWriter out = response.getWriter()){
           
       
       if(action.equalsIgnoreCase("securitycheck")){
           nid = Integer.valueOf(request.getParameter("nid"));
           name = request.getParameter("Name");
           securityQuesAns = voterDao.getSecurityQues(nid, name);
           request.setAttribute("securityQuestion", securityQuesAns.get(0));
           request.setAttribute("setSecurityAns", securityQuesAns.get(1));
           if(securityQuesAns.get(0).equals("")){
               RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");  
               rd.include(request, response);
           }
           else{
                RequestDispatcher rd=request.getRequestDispatcher("/voterVerify.jsp");  
                rd.include(request, response);
           }
        

       }
       else{
           out.println("<h1> Something went wrong </h1>");
       }

       String userAnswer = "";
       if(action.equalsIgnoreCase("verify")){
             userAnswer =  request.getParameter("securityAnswer");
            if(userAnswer.trim().equalsIgnoreCase(securityQuesAns.get(1).trim())){
                  
                   RequestDispatcher rd=request.getRequestDispatcher("/HomepageController");  
                   rd.forward(request, response);
                   
            }
          else{
             RequestDispatcher nextPage = request.getRequestDispatcher("/voterVerify.jsp"); 
             nextPage.include(request, response);
            }
        }
      }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
