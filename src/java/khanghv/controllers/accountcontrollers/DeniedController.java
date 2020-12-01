/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.accountcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.carts.ActorCrart;
import khanghv.dtos.NotificationDTO;

/**
 *
 * @author USER
 */
public class DeniedController extends HttpServlet {

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
        ServletContext context = request.getServletContext();
        try {
            Vector<NotificationDTO> notifyList = (Vector<NotificationDTO>) context.getAttribute("NOTIFICATION");
            if (notifyList == null) {
                notifyList = new Vector<>();
            }
            ActorCrart cart = (ActorCrart) context.getAttribute("ACART");
            int number = Integer.parseInt(request.getParameter("number"));
            String id = request.getParameter("txtId");
            cart.getCart().remove(number - 1);
            System.out.println("Cart size: " + cart.getCart().size());
            String editor = request.getParameter("txtEd");
            NotificationDTO editorNoti = new NotificationDTO("admin", editor, "Your " + id + " cart has been declined");
            notifyList.add(editorNoti);
            context.setAttribute("NOTIFICATION", notifyList);
            if (cart.getCart().size() == 0) {
                context.removeAttribute("ACART");
            } else {
                context.setAttribute("ACART", cart);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("Array index out of range: 0")) {
                context.removeAttribute("ACART");
            } else {
                log("ERROR at DeniedController " + e.getMessage());
            }
        } finally {
            request.getRequestDispatcher("requestofadmin.jsp").forward(request, response);
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
