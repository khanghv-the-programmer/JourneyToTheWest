/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.accountcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.toolscene.GetToolSceneBean;
import khanghv.dtos.NotificationDTO;
import khanghv.dtos.ToolSceneCart;
import khanghv.dtos.ToolSceneDTO;

/**
 *
 * @author USER
 */
public class AssignController extends HttpServlet {

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
        ServletContext context = getServletContext();
        try {

            ToolSceneCart cart = (ToolSceneCart) context.getAttribute("TCART");
            Vector<NotificationDTO> notifyList = (Vector<NotificationDTO>) context.getAttribute("NOTIFICATION");
            if (notifyList == null) {
                notifyList = new Vector<>();
            }
            int number = Integer.parseInt(request.getParameter("number"));
            String id = cart.getCartNum(number - 1).getcId();
            String tid = cart.getCartNum(number - 1).getTid();
            String sid = cart.getCartNum(number - 1).getSid();
            String editor = cart.getCartNum(number - 1).getEditor();
            int quantity = cart.getCartNum(number - 1).getQuantity();
            String status = "Accepted";
            String pattern = "dd/MM/yyyy HH:mm";
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String time = sdf.format(new Date());
            GetToolSceneBean beans = new GetToolSceneBean();
            Vector<ToolSceneDTO> twoIdList = beans.getTwoIds();
            boolean isFound = false;
            for (int i = 0; i < twoIdList.size(); i++) {
                if (sid.equals(twoIdList.get(i).getSid()) && tid.equals(twoIdList.get(i).getTid())) {
                    isFound = true;
                }
            }
            if (isFound) {
                beans.setIdScene(sid);
                beans.setIdTool(tid);
                beans.setOrderQuantity(beans.getQuantity() + quantity);
                beans.setTime(time);
                boolean isUpdated = beans.updateCart();
                if (isUpdated) {
                    request.setAttribute("DONE", "Updated!");

                    cart.deleteCartNum(number - 1);
                    context.setAttribute("TCART", cart);
                    NotificationDTO editorNoti = new NotificationDTO("admin", editor, "Your " + id + " cart has been accepted");
                    notifyList.add(editorNoti);
                    context.setAttribute("NOTIFICATION", notifyList);
                } else {
                    request.setAttribute("FAILED", "Can't update!");
                }
            } else {
                ToolSceneDTO dto = new ToolSceneDTO(id, editor, tid, sid, status, quantity, time);
                beans.setDto(dto);
                boolean isCreated = beans.addToolScene();
                if (isCreated) {
                    cart.deleteCartNum(number - 1);
                    context.setAttribute("TCART", cart);
                    request.setAttribute("DONE", "Added!");
                    NotificationDTO editorNoti = new NotificationDTO("admin", editor, "Your " + id + " cart has been accepted");
                    notifyList.add(editorNoti);
                    context.setAttribute("NOTIFICATION", notifyList);
                    if (cart.getCart().size() == 0) {
                        context.removeAttribute("TCART");
                    } else {
                        context.setAttribute("TCART", cart);
                    }

                } else {
                    request.setAttribute("FAILED", "Can't create!");
                }
            }

        } catch (Exception e) {
            if (e.getMessage().contains("Array index out of range: 0")) {
                context.removeAttribute("ACART");
            } else {
                log("ERROR at AssignController " + e.getMessage());
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
