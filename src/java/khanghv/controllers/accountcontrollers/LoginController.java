/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.accountcontrollers;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanghv.daos.accounts.AccountBean;
import khanghv.dtos.AccountDTO;
import khanghv.dtos.ErrorObj;

/**
 *
 * @author USER
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String DIRECTOR = "director.jsp";
    private static final String ACTOR = "actor.jsp";
    private static final String INVALID = "index.jsp";
    

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
            String role = "failed";

            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            ErrorObj error = new ErrorObj();
            boolean valid = true;

            if (username.equals("")) {
                valid = false;
                error.setUsernameError("Empty Username!");
            }

            if (password.equals("")) {
                valid = false;
                request.setAttribute("USERNAME", username);
                error.setPasswordError("Empty Password!");
            }
            
            if (!valid) {
                url = INVALID;
                request.setAttribute("INVALID", error);
            } else {
                AccountBean beans = new AccountBean();
                beans.setUsername(username);
                beans.setPassword(password);
                AccountDTO dto = beans.checkLogin();
                
                HttpSession session = request.getSession();

                if (dto == null) {
                    request.setAttribute("ERROR", "Invalid Username Or Password!");
                } else {
                    role = dto.getRole();
                    switch (role) {
                        case "admin":
                            session.setAttribute("ROLE", dto.getRole());
                            session.setAttribute("FULLNAME", dto.getFullname());
                            url = ADMIN;
                            break;
                        case "actor":
                            session.setAttribute("ROLE", dto.getRole());
                            session.setAttribute("FULLNAME", dto.getFullname());
                            session.setAttribute("UN", dto.getUsername());
                            url = ACTOR;
                            break;
                        case "director":
                            session.setAttribute("ROLE", dto.getRole());
                            session.setAttribute("FULLNAME", dto.getFullname());
                            session.setAttribute("UN", dto.getUsername());
                            url = DIRECTOR;
                            break;
                    }
                }

            }

        } catch (Exception e) {
            log("Error at LoginController : " + e.getMessage());
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
