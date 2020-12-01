/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.toolscenecontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanghv.daos.tools.ToolBeans;
import khanghv.daos.toolscene.GetToolSceneBean;
import khanghv.dtos.ToolSceneCart;
import khanghv.dtos.ToolSceneDTO;

/**
 *
 * @author USER
 */
public class AssignControllerTS extends HttpServlet {

    private static final String ASSIGN = "AddControllerTS";
    private static final String ERROR = "errortoolscene.jsp";

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
            HttpSession session = request.getSession();
            ServletContext context = request.getServletContext();
            ToolSceneCart cart = (ToolSceneCart) context.getAttribute("TCART");
            if (cart == null) {
                cart = new ToolSceneCart();
            }
            boolean isUpdate = false;
            String[] tools = request.getParameter("cbxTool").split("-");
            String toolId = tools[0].trim();
            String[] scene = request.getParameter("cbxScene").split("-");
            String sceneId = scene[0].trim();
            int quantityHad = Integer.parseInt(tools[2].trim());
            boolean isValid = true;
            String quantityString = request.getParameter("txtQuantity").trim();
            if (!quantityString.matches("[0-9]{1,10}")) {
                isValid = false;
                request.setAttribute("QUAN", "Invalid Quantity!");
            }
            GetToolSceneBean beans = new GetToolSceneBean();
            Vector<ToolSceneDTO> twoIdsList = beans.getTwoIds();
            Vector<String> idList = beans.getIdList();
            String id = "TS0000";
            int quantity = Integer.parseInt(quantityString);
            String editor = (String) session.getAttribute("FULLNAME");
            String status = "Pending";
            if (cart.getCart().isEmpty()) {
                if (idList != null) {
                    if (idList.size() == 0) {
                        id = "TS0001";
                    } else {
                        String[] lastId = idList.get(idList.size() - 1).split("TS");
                        int numId = Integer.parseInt(lastId[1].trim());
                        id = "TS" + String.format("%04d", numId + 1);
                    }
                    for (int i = 0; i < twoIdsList.size(); i++) {
                        if (sceneId.equals(twoIdsList.get(i).getSid()) && toolId.equals(twoIdsList.get(i).getTid())) {
                            beans.setIdScene(sceneId);
                            beans.setIdTool(toolId);
                            if (quantity + beans.getQuantity() > quantityHad) {
                                isValid = false;
                                request.setAttribute("QUAN", "Your order had been cancelled because there are not enough tools you need!");
                            }
                        } else {
                            if (quantity > quantityHad) {
                                isValid = false;
                                request.setAttribute("QUAN", "Your order had been cancelled because there are not enough tools you need!");
                            }
                        }
                    }

                }
            } else {
                System.out.println(cart.getCart().size());
                String[] lastId = cart.getLastId().split("TS");
                int numId = Integer.parseInt(lastId[1].trim());
                id = "TS" + String.format("%04d", numId + 1);

                for (int i = 0; i < cart.getCart().size(); i++) {
                    if (sceneId.equals(cart.getCartNum(i).getSid()) && toolId.equals(cart.getCartNum(i).getTid())) {
                        beans.setIdScene(sceneId);
                        beans.setIdTool(toolId);
                        System.out.println(quantity + beans.getQuantity() + cart.getCartNum(i).getQuantity());
                        System.out.println(quantity + beans.getQuantity() + cart.getCartNum(i).getQuantity() > quantityHad);
                        if (quantity + beans.getQuantity() + cart.getCartNum(i).getQuantity() > quantityHad) {
                            isValid = false;
                            request.setAttribute("QUAN", "Your order had been cancelled because there are not enough tools you need!");
                        } else {
                            cart.getCartNum(i).setQuantity(cart.getCartNum(i).getQuantity() + quantity);
                            isUpdate = true;
                        }
                    } else {
                        if (quantity > quantityHad) {
                            isValid = false;
                            request.setAttribute("QUAN", "Your order had been cancelled because there are not enough tools you need!");
                        }
                    }
                }

            }
            if (!isValid) {
                url = ASSIGN;

            } else {
                ToolSceneDTO dto = new ToolSceneDTO(id, editor, toolId, sceneId, status, quantity);

                url = ASSIGN;
                if (isUpdate) {
                    request.setAttribute("DONE", "Updated!");
                    context.setAttribute("TCART", cart);
                } else {
                    cart.addToCart(dto);
                    request.setAttribute("DONE", "Added!");
                    context.setAttribute("TCART", cart);
                }

            }
        } catch (Exception e) {
            if(e.getMessage().contains("input string"))
            {   
                url = ASSIGN;
                request.setAttribute("QUAN", "Invalid Quantity!");
            }
            else
            {
                log("Error at AssignControllerTS: " + e.getMessage());
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
