/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.directorcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.carts.ActorCartBean;
import khanghv.dtos.SceneActorDTO;

/**
 *
 * @author USER
 */
public class SearchControllerD extends HttpServlet {

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
        try {
            String search = request.getParameter("txtSearch");
            if(search == null)
            {
                search = request.getParameter("Search");
            }
            if (search.equals("")) {
                request.setAttribute("EMPTY", "Please input someting to search");
            } else {
                String how = request.getParameter("cbxSearch");
                if(how == null)
                {
                    how = request.getParameter("By");
                }
                if (how.equals("Name of actor")) {
                    ActorCartBean beans = new ActorCartBean();
                    beans.setUsername(search);
                    Vector<SceneActorDTO> list = beans.findByActor();
                    request.setAttribute("ACLIST", list);

                } else if (how.equals("Name of scene")) {
                    ActorCartBean beans = new ActorCartBean();
                    beans.setUsername(search);
                    Vector<SceneActorDTO> list = beans.findByScene();
                    request.setAttribute("ACLIST", list);

                }
                
            }

        } catch (Exception e) {
            log("ERROR at SearchControllerD: " + e.getMessage());

        } finally {
            request.getRequestDispatcher("searchsceneactor.jsp").forward(request, response);
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
