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
import khanghv.daos.accounts.AccountBean;
import khanghv.dtos.AccountDTO;
import khanghv.dtos.ErrorObj;

/**
 *
 * @author USER
 */
public class UpdateController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String INVALID = "accountupdate.jsp";
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
        boolean isValid = true;
        
        try {
            ErrorObj error = new ErrorObj();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            if (!password.matches("[A-Za-z0-9]{8,20}")) {
                isValid = false;
                error.setPasswordError("Password must be between 8-20 characters!");
            }
            String conf = request.getParameter("txtConfirm");
            if (!conf.equals(password)) {
                isValid = false;
                error.setConfError("Confirm password must match the password above!");
            }
            String role = request.getParameter("cbxRole");
            String fullname = request.getParameter("txtFullname");
            if (!fullname.matches("[A-Za-z ]{6,50}")) {
                isValid = false;
                error.setFullNameError("Invalid fullname!");
            }
            String desc = request.getParameter("txtDesc");
            if (!desc.matches("[A-Za-z0-9 ]{5,100}")) {
                isValid = false;
                error.setDesError("Invalid Description!");
            }

            String phone = request.getParameter("txtPhone");
            if (!phone.matches("[0-9]{10,11}")) {
                isValid = false;
                error.setPhoneError("Invalid phone number, it must have 10-11 digits!");
            }
            String email = request.getParameter("txtEmail") + request.getParameter("cbxTailEmail");
            if (!request.getParameter("txtEmail").matches("[A-Za-z0-9]{5,20}")) {
                isValid = false;
                error.setEmailError("Invalid Email!");
            }
            String img = request.getParameter("txtImg");
            if(img.equals(""))
            {
                img = "https://st.quantrimang.com/photos/image/072015/22/avatar.jpg";
            }
            boolean status = false;
            
            if (!isValid) {
                url = INVALID;
                request.setAttribute("USERNAME", username);
                request.setAttribute("FULLNAME", fullname);
                request.setAttribute("DES", desc);
                request.setAttribute("PHONE", phone);
                request.setAttribute("EMAIL", request.getParameter("txtEmail"));
                request.setAttribute("IMG", img);
                request.setAttribute("INVALID", error);
                

            } else {
                
                AccountDTO dto = new AccountDTO(username, fullname, role, img, desc, phone, email);
                dto.setPassword(password);
                AccountBean beans = new AccountBean();
                status = beans.update(dto);
                if (status) {
                    url = SUCCESS;
                    request.setAttribute("DONE", "Update Successfully");
                }
                if (!status) {
                    request.setAttribute("ERROR", "Update Failed!");
                }
            }
            
        } catch (Exception e) {
            log("Error at Update Controller: " + e.getMessage());
        }
        finally
        {
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
