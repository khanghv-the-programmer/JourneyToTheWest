/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.scenecontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.scenes.SceneBean;
import khanghv.dtos.SceneDTO;

/**
 *
 * @author USER
 */
public class EditControllerS extends HttpServlet {

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
            String name = request.getParameter("name");
            String search = request.getParameter("searchh");
            SceneBean beans = new SceneBean();
            beans.setName(name);
            SceneDTO dto = beans.getInfo();
            String time [] = dto.getStart().trim().split("/");
            String time1 [] = dto.getEnd().trim().split("/");
            request.setAttribute("DATES", time[0]);
            request.setAttribute("MONTHS", time[1]);
            request.setAttribute("YEARS", time[2]);
            request.setAttribute("DATEE", time1[0]);
            request.setAttribute("MONTHE", time1[1]);
            request.setAttribute("YEARE", time1[2]);
            request.setAttribute("SEARCHH", search);
            request.setAttribute("DTO", dto);
        } catch (Exception e) {
            log("ERROR at Edit Controller: " + e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher("updatescene.jsp").forward(request, response);
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
