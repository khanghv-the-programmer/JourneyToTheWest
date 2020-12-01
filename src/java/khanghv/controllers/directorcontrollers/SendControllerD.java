/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.directorcontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanghv.daos.carts.ActorCartBean;
import khanghv.daos.carts.ActorCrart;
import khanghv.dtos.ASCartDTO;

/**
 *
 * @author USER
 */
public class SendControllerD extends HttpServlet {

    private static final String INVALID = "AddControllerD";
    private static final String SENDING = "requestofadmin.jsp";
    private static final String ERROR = "erroradd.jsp";

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
            boolean isValid = true;
            HttpSession session = request.getSession();
            ServletContext context = request.getServletContext();
            ActorCrart cart = (ActorCrart) context.getAttribute("ACART");
            if (cart == null) {
                cart = new ActorCrart();
            }
            if (cart.getCart().size() == 0) {
                String[] actors = request.getParameter("cbxActor").split("-");
                String username = actors[0].trim();
                String[] scenes = request.getParameter("cbxScene").split("-");
                String scene = scenes[0].trim();
                String cast = request.getParameter("txtCast");
                if(cast.equals(""))
                {
                    isValid = false;
                    request.setAttribute("CAST", "Please input a role for this actor!!!");
                }
                ActorCartBean beans = new ActorCartBean();
                
                
                Vector<ASCartDTO> usllist = beans.getUsernameScene();
                for (ASCartDTO aSCartDTO : usllist) {
                    if (username.equals(aSCartDTO.getUsername()) && scene.equals(aSCartDTO.getIdScene())) {
                        isValid = false;
                        request.setAttribute("INVALID", "1 actor only acts 1 play in 1 scene! Request Failed!");
                    }

                }
                String desc = request.getParameter("txtDesc");
                Vector<String> idList = beans.getIdList();
                String id = "SA0000";
                if (idList.size() == 0) {
                    id = "SA0001";
                } else {
                    String lastId[] = idList.get(idList.size() - 1).split("SA");
                    int idToNum = Integer.parseInt(lastId[1].trim());
                    id = "SA" + String.format("%04d", idToNum + 1);
                }

                if (desc.equals("")) {
                    desc = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&t=43s";
                }
                String editor = (String) session.getAttribute("FULLNAME");
                String status = "Pending";

                if (!isValid) {
                    url = INVALID;
                } else {
                    url = INVALID;
                    ASCartDTO dto = new ASCartDTO(id, scene, username, desc, editor, status, cast);
                    cart.addtoCart(dto);
                    request.setAttribute("DONE", "Added!");
                    context.setAttribute("ACART", cart);
                }
            } else {
                String[] actors = request.getParameter("cbxActor").split("-");
                String username = actors[0].trim();
                String[] scenes = request.getParameter("cbxScene").split("-");
                String scene = scenes[0].trim();
                ActorCartBean beans = new ActorCartBean();
                String cast = request.getParameter("txtCast");
                if(cast.equals(""))
                {
                    isValid = false;
                    request.setAttribute("CAST", "Please input a role for this actor!!!");
                }
                Vector<ASCartDTO> usllist = beans.getUsernameScene();
                for (ASCartDTO aSCartDTO : usllist) {
                    if (username.equals(aSCartDTO.getUsername()) && scene.equals(aSCartDTO.getIdScene())) {
                        isValid = false;
                        request.setAttribute("INVALID", "1 actor only acts 1 play in 1 scene! Request Failed!");
                    }

                }
                for(int i = 0; i < cart.getCart().size(); i++)
                {
                    if(username.equals(cart.getCart().get(i).getUsername()) && scene.equals(cart.getCart().get(i).getIdScene()))
                    {
                        isValid = false;
                        request.setAttribute("INVALID", "1 actor only acts 1 play in 1 scene! Request Failed! Please check your cart!");
                    }
                }
                String desc = request.getParameter("txtDesc");
                String id = "SA0000";
                String lastId[] = cart.getCart().get(cart.getCart().size() - 1).getId().split("SA");
                int idToNum = Integer.parseInt(lastId[1].trim());
                id = "SA" + String.format("%04d", idToNum + 1);

                if (desc.equals("")) {
                    desc = "https://www.youtube.com/watch?v=dQw4w9WgXcQ&t=43s";
                }
                String editor = (String) session.getAttribute("FULLNAME");
                String status = "Pending";
                if (!isValid) {
                    url = INVALID;
                } else {
                    url = INVALID;
                    ASCartDTO dto = new ASCartDTO(id, scene, username, desc, editor, status, cast);
                    cart.addtoCart(dto);
                    request.setAttribute("DONE", "Added!");
                    context.setAttribute("ACART", cart);
                }
            }

//            beans.setDto(new ASCartDTO(id, scene, username, desc, editor));
        } catch (Exception e) {
            log("ERROR at SendControllerD: " + e.getMessage());

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
