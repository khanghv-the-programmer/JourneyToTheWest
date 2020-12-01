/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.accountcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.carts.ActorCartBean;
import khanghv.daos.carts.ActorCrart;
import khanghv.dtos.ASCartDTO;
import khanghv.dtos.NotificationDTO;

/**
 *
 * @author USER
 */
public class AcceptController extends HttpServlet {

    private final static String ERROR = "error.jsp";
    private final static String SUCCESS = "requestofadmin.jsp";

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
        ServletContext context = request.getServletContext();
        try {
            Vector<NotificationDTO> notifyList =(Vector<NotificationDTO>) context.getAttribute("NOTIFICATION");
            if(notifyList == null)
            {
                notifyList = new Vector<>();
            }
            int number = Integer.parseInt(request.getParameter("number"));
            ActorCrart cart = (ActorCrart) context.getAttribute("ACART");
            cart.getCart().remove(number - 1);
            String id = request.getParameter("txtId");
            String desc = request.getParameter("txtDesc");
            String editor = request.getParameter("txtEd");
            String username = request.getParameter("txtUs");
            String scene = request.getParameter("txtSc");
            String status = "Accepted";
            String pattern = "dd/MM/yyyy HH:mm";
            String acting = request.getParameter("txtAct");
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String time = sdf.format(new Date());
            ASCartDTO dto = new ASCartDTO(id, scene, username, desc, editor, status, time, acting);
            ActorCartBean beans = new ActorCartBean();
            beans.setDto(dto);
            boolean isOk = beans.add();
            if (isOk) {
                url = SUCCESS;
                if (cart.getCart().size() == 0) {
                    context.removeAttribute("ACART");
                } else {
                    context.setAttribute("ACART", cart);
                }
                NotificationDTO notidto = new NotificationDTO(editor, username, "You have been assigned to a scene, please check your Schedule!");
                NotificationDTO editorNoti = new NotificationDTO("admin", editor, "Your " + id + " cart has been accepted");
                notifyList.add(notidto);
                notifyList.add(editorNoti);
                context.setAttribute("NOTIFICATION", notifyList);
                context.setAttribute("EDITOR", editor);
                

            } else {
                request.setAttribute("ERROR", "Add failed");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("Array index out of range: 0"))
            {
                context.removeAttribute("ACART");
            }
            else {
                log("ERROR at AcceptController " + e.getMessage());
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
