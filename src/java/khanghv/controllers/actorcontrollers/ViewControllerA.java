/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.actorcontrollers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanghv.daos.carts.ActorCartBean;
import khanghv.dtos.SceneActorDTO;

/**
 *
 * @author USER
 */
public class ViewControllerA extends HttpServlet {

    private static final String HISTORY = "viewhistory.jsp";
    private static final String UPCOMING = "viewupcoming.jsp";

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
        String url = HISTORY;
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            ActorCartBean beans = new ActorCartBean();
            String fullname = (String) session.getAttribute("FULLNAME");
            beans.setFullname(fullname);
            Vector<SceneActorDTO> list = beans.findOfActor();
            Vector<SceneActorDTO> listOfHistory = new Vector<>();
            Vector<SceneActorDTO> listOfUpcoming = new Vector<>();
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < list.size(); i++) {
                if(sdf.parse(list.get(i).getEnd()).compareTo(now) < 0)
                {
                    listOfHistory.add(list.get(i));
                }
                else
                {
                    listOfUpcoming.add(list.get(i));
                }
            }
            if (action.equals("View upcoming Scene and Schedule")) {
                url = UPCOMING;
                request.setAttribute("UPCOMING", listOfUpcoming);
                
            } else if (action.equals("View Casting history")) {
                request.setAttribute("HISTORY", listOfHistory);
            }
        } catch (Exception e) {
            log("ERROR at ViewController Actor: " + e.getMessage());
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
