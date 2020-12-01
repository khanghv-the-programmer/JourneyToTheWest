/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.controllers.actorcontrollers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class DownloadControllerA extends HttpServlet {

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
        String fileName = "cast.rar";
        String path = "D:/PRJ321/SE140097-SE1406-HuaVinhKhang-Presentation/SE140097-SE1406-HuaVinhKhang-Presentation/Presentation/";
        File fileDownload = new File(path + fileName);

        FileInputStream fis = new FileInputStream(fileDownload);
        ServletContext context = request.getServletContext();
        String relativePath = request.getServletContext().getRealPath("");
        System.out.println("Relative " + relativePath);
        String mimeType = context.getMimeType(path + fileName);
        System.out.println("Mime type: " + mimeType);
        if (mimeType == null) {
            mimeType = "APPLICATION/OCTET-STREAM";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) (fileDownload).length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileDownload.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[4096];

        int byteRead = -1;

        while ((byteRead = fis.read(buffer)) != -1) {
            os.write(buffer, 0, byteRead);
        }

        fis.close();
        os.close();
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
