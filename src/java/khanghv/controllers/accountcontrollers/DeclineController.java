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
import khanghv.dtos.NotificationDTO;
import khanghv.dtos.ToolSceneCart;

/**
 *
 * @author USER
 */
public class DeclineController extends HttpServlet {

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
            ToolSceneCart cart = (ToolSceneCart) context.getAttribute("TCART");
            int number = Integer.parseInt(request.getParameter("number"));
            String id = cart.getCartNum(number - 1).getcId();
            String editor = request.getParameter("editor");
            System.out.println("ID: " + id);
            cart.deleteCartNum(number - 1);
            String idcart = request.getParameter("idcart");
            NotificationDTO editorNoti = new NotificationDTO("admin", editor, "Your " + idcart + " cart has been declined");
            notifyList.add(editorNoti);
            context.setAttribute("NOTIFICATION", notifyList);
            if (cart.getCart().size() == 0) {
                context.removeAttribute("TCART");
            } else {
                context.setAttribute("TCART", cart);
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Array index out of range: 0")) {
                context.removeAttribute("TCART");
            } else {
                log("ERROR at DelineController " + e.getMessage());
            }
        } finally {
            request.getRequestDispatcher("viewtoolsceneorder.jsp").forward(request, response);
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
