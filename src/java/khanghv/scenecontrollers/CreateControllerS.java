/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanghv.scenecontrollers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanghv.daos.scenes.SceneBean;
import khanghv.dtos.ErrorSceneObj;
import khanghv.dtos.SceneDTO;

/**
 *
 * @author USER
 */
public class CreateControllerS extends HttpServlet {

    private static final String ERROR = "errorscene.jsp";
    private static final String SUCCESS = "SearchControllerS";
    private static final String INVALID = "createscene.jsp";

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
        String search = request.getParameter("txtSearch");
        String name = request.getParameter("txtSName");
        ErrorSceneObj error = new ErrorSceneObj();
        String desc = request.getParameter("txtSDesc");
        String loc = request.getParameter("txtSLoc");
        String yearEStr = request.getParameter("txtYearE");
        String monthEStr = request.getParameter("txtMonthE");
        String dateEStr = request.getParameter("txtDateE");
        String yearSStr = request.getParameter("txtYear");
        String monthSStr = request.getParameter("txtMonth");
        String dateSStr = request.getParameter("txtDate");
        String take = request.getParameter("txtTake");
        try {
            boolean valid = true;

            if (!name.matches("[A-Za-z 0-9:]{2,50}")) {
                valid = false;
                error.setNameError("Invalid name");
            }

            if (!desc.matches("[A-Za-z 0-9,.#]{2,200}")) {
                valid = false;
                error.setDescError("Invalid Description");
            }

            if (!loc.matches("[A-Za-z0-9 ]{2,100}")) {
                valid = false;
                error.setLocError("Invalid Location!");
            }

            int yearE = Integer.parseInt(yearEStr);
            int monthE = Integer.parseInt(monthEStr);
            int dateE = Integer.parseInt(dateEStr);
            int yearS = Integer.parseInt(yearSStr);
            int monthS = Integer.parseInt(monthSStr);
            int dateS = Integer.parseInt(dateSStr);

            boolean checkDate = checkDate(dateS, monthS, yearS);
            if (!checkDate) {
                valid = false;
                error.setStartError("Invalid date!");
            }
            boolean checkDateE = checkDate(dateE, monthE, yearE);
            if (!checkDateE) {
                valid = false;
                error.setDateError("Invalid date!");
            }

            if (yearE < yearS) {
                valid = false;
                error.setEndError("Invalid End Year, it must be later than the Start Year ");
            } else if (yearE == yearS) {
                if (monthE < monthS) {
                    valid = false;
                    error.setEndError("Invalid End Month, it must be later than the Start Month ");
                } else if (monthE == monthS) {
                    if (dateE < dateS) {
                        valid = false;
                        error.setEndError("Invalid End Date, it must be later than the Start Date ");
                    }
                }

            }

            if (!take.matches("[0-9]{1,10}")) {
                valid = false;
                error.setTakeError("Invalid take, it must be a number!");
            }

            if (!valid) {
                url = INVALID;
                request.setAttribute("INVALID", error);
                request.setAttribute("NAME", name);
                request.setAttribute("DESC", desc);
                request.setAttribute("LOC", loc);
                request.setAttribute("DATES", request.getParameter("txtDate"));
                request.setAttribute("MONTHS", request.getParameter("txtMonth"));
                request.setAttribute("YEARS", request.getParameter("txtYear"));
                request.setAttribute("DATEE", request.getParameter("txtDateE"));
                request.setAttribute("MONTHE", request.getParameter("txtMonthE"));
                request.setAttribute("YEARE", request.getParameter("txtYearE"));
                request.setAttribute("TAKE", request.getParameter("txtTake"));
                request.setAttribute("SEARCHH", search);
            } else {
                SceneBean beans = new SceneBean();
                Vector<String> list = beans.getIdList();
                String[] fullId = list.get(list.size() - 1).split("S");
                int numId = Integer.parseInt(fullId[1].trim());
                String id = "S" + String.format("%04d", numId + 1);
                int takes = Integer.parseInt(take);
                String startDate = String.format("%02d", Integer.parseInt(request.getParameter("txtDate"))) + "/" + String.format("%02d", Integer.parseInt(request.getParameter("txtMonth"))) + "/" + String.format("%04d", Integer.parseInt(request.getParameter("txtYear")));
                String endDate = String.format("%02d", Integer.parseInt(request.getParameter("txtDateE"))) + "/" + String.format("%02d", Integer.parseInt(request.getParameter("txtMonthE"))) + "/" + String.format("%04d", Integer.parseInt(request.getParameter("txtYearE")));
                SceneDTO dto = new SceneDTO(id, name, desc, loc, startDate, endDate, takes);        
                beans.setDto(dto);
                beans.addScene();
                boolean isSuccess = beans.update();
                if (isSuccess) {
                    url = SUCCESS;

                } else {
                    request.setAttribute("ERROR", "Update failed");
                }
            }
        } catch (Exception e) {
            if (e.getMessage().contains("string")) {
                url = INVALID;
                request.setAttribute("INVALID", error);
                request.setAttribute("NAME", name);
                request.setAttribute("DESC", desc);
                request.setAttribute("LOC", loc);
                request.setAttribute("DATES", request.getParameter("txtDate"));
                request.setAttribute("MONTHS", request.getParameter("txtMonth"));
                request.setAttribute("YEARS", request.getParameter("txtYear"));
                request.setAttribute("DATEE", request.getParameter("txtDateE"));
                request.setAttribute("MONTHE", request.getParameter("txtMonthE"));
                request.setAttribute("YEARE", request.getParameter("txtYearE"));
                request.setAttribute("TAKE", request.getParameter("txtTake"));
                request.setAttribute("SEARCHH", search);
                request.setAttribute("DATEERR", "Invalid Date/Month/Year!");
                request.setAttribute("ERR", "Invalid Date/Month/Year!");
            } else {
                log("ERROR at CreateControllerS: " + e.getMessage());
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private boolean checkDate(int date, int month, int year) {
        boolean check = false;
        if (year > 1982 && year < 2100) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (date >= 1 && date <= 31) {
                        check = true;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (date >= 1 && date <= 30) {
                        check = true;
                    }
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        if (date >= 1 && date <= 29) {
                            check = true;
                        }
                    } else {
                        if (date >= 1 && date <= 28) {
                            check = true;
                        }
                    }
                    break;
                default:
                    check = false;
                    break;

            }
        }
        return check;
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
