/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.accountcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private final static String UPDATE = "UpdateController";
    private final static String EDIT = "EditController";
    private final static String CREATE = "RegisterController";
    private final static String ACCEPT = "AcceptController";
    private final static String LOGOUT = "LogoutController";
    private final static String ASSIGN = "AssignController";
    private final static String DECLINE = "DeclineController";
    private final static String DENIED = "DeniedController";
    private final static String LOOKFOR = "LookUpController";
    
    
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
        String url = ERROR;
        try {
            String action = (String) request.getParameter("action");
            switch (action) {
                case "Login":
                    url = LOGIN;
                    break;
                case "Search":
                    url = SEARCH;
                    break; 
                case "Delete":
                    url = DELETE;
                    break;
                case "Create Account":
                    url = CREATE;
                    break;
                case "Edit":
                    url = EDIT;
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "Accept":
                    url = ACCEPT;
                    break;
                case "Log out":
                    url = LOGOUT;
                    break;
                case "Assign Tool":
                    url = ASSIGN;
                    break;
                case "Decline Tool":
                    url = DECLINE;
                    break;
                case "Denied":
                    url = DENIED;
                    break;
                case "Look Up":
                    url = LOOKFOR;
                    break;
                default:
                    request.setAttribute("ERROR", "Your action is invalid!");
                    break;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
