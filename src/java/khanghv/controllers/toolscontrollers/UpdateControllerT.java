/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.toolscontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.tools.ToolBeans;
import khanghv.dtos.ErrorToolObj;
import khanghv.dtos.ToolDTO;

/**
 *
 * @author USER
 */
public class UpdateControllerT extends HttpServlet {

    private static final String SUCCESS = "SearchControllerT";
    private static final String ERROR = "toolerror.jsp";
    private static final String INVALID = "updatetool.jsp";

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
            boolean valid = true;
            ErrorToolObj error = new ErrorToolObj();
            String id = request.getParameter("txtIdT");
            String name = request.getParameter("txtName");
            if (!name.matches("[A-Za-z ]{2,50}")) {
                valid = false;
                error.setNameError("Invalid name!");
            }
            String desc = request.getParameter("txtDesc");
            if (!desc.matches("[A-Za-z0-9, ]{2,50}")) {
                valid = false;
                error.setDescError("Invalid description!");
            }
            String quant = request.getParameter("txtQuantity");
            if (!quant.matches("[0-9]{1,5}")) {
                valid = false;
                error.setQuanError("Invalid quantity! Please input a number");
            }
            String status = "unvailable";
            String img = request.getParameter("txtImg");
            if (img.equals("")) {
                img = "https://i.ya-webdesign.com/images/tool-clip-animation-3.png";
            }
            if (!valid) {
                url = INVALID;
                request.setAttribute("ID", id);
                request.setAttribute("NAME", name);
                request.setAttribute("DESC", desc);
                request.setAttribute("QUAN", quant);
                request.setAttribute("IMG", img);
                request.setAttribute("INVALID", error);
            } else {
                int quantity = Integer.parseInt(quant);
                if(quantity > 0)
                {
                    status = "available";
                }
                else
                {
                    status = "unavailabe";
                }
                ToolDTO dto = new ToolDTO(id, name, desc, img, status, quantity);
                ToolBeans beans = new ToolBeans();
                boolean check = beans.update(dto);
                if (check) {
                    url = SUCCESS;
                    request.setAttribute("DONE", "Update Successfully");
                } else {
                    request.setAttribute("ERROR", "Failed to update!");
                }
            }

        } catch (Exception e) {
            log("ERROR at UpdateControllerT: " + e.getMessage());
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
