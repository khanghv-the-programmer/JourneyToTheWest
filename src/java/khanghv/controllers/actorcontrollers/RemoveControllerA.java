/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.actorcontrollers;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanghv.dtos.NotificationDTO;

/**
 *
 * @author USER
 */
public class RemoveControllerA extends HttpServlet {

    private final static String ACTOR = "actor.jsp";
    private final static String DIRECTOR = "director.jsp";
    private final static String ERROR = "error.jsp";

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
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String username = (String) session.getAttribute("UN");
            String role = (String) session.getAttribute("ROLE");
            String fullname = (String) session.getAttribute("FULLNAME");
            Vector<NotificationDTO> list = (Vector<NotificationDTO>) context.getAttribute("NOTIFICATION");
            if (role.equals("director")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getReceiver().equals(fullname)) {
                        list.remove(i);
                    }
                }
                url = DIRECTOR;
                context.setAttribute("NOTIFICATION", list);
            } else if (role.equals("actor")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getReceiver().equals(username)) {
                        list.remove(i);
                    }
                }
                url = ACTOR;
                context.setAttribute("NOTIFICATION", list);
            } else {
                request.setAttribute("ERROR", "Error with Login");
            }

        } catch (Exception e) {
            if (e.getMessage().contains("Array index out of range: 0")) {
                context.removeAttribute("NOTIFICATION");
            }
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
