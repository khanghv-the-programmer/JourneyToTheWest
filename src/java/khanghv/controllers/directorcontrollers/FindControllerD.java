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
import khanghv.daos.toolscene.ToolSceneSearchBean;
import khanghv.daos.toolscene.ToolSceneSearchDAO;
import khanghv.dtos.ToolSceneSearchDTO;

/**
 *
 * @author USER
 */
public class FindControllerD extends HttpServlet {

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
                request.setAttribute("EMPTY", "Please input something to continue!");
            } else {
                String how = request.getParameter("cbxHow");
                if(how == null)
                {
                    how = request.getParameter("By");
                }
                ToolSceneSearchBean beans = new ToolSceneSearchBean();
                Vector<ToolSceneSearchDTO> list = new Vector<>();
                if (how.equals("Search By Scene")) {
                    beans.setSearch(search);
                    list = beans.searchByScene();
                } else if (how.equals("Search By Tool")) {
                    beans.setSearch(search);
                    list = beans.searchByTool();
                }
                request.setAttribute("TOOLSCENE", list);
            }
        } catch (Exception e) {
            log("ERROR at FindControllerD: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("searchscenetool.jsp").forward(request, response);
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
