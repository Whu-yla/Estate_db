package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getHouseBySchool_Servlet")
public class getHouseBySchool_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SchoolID="";
        try {
            SchoolID = request.getParameter("SchoolID");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String serverLog = "";
        response.setHeader("Content-type", "text/html;charset=UTF-8");
            try {

                getHouseBySchool get = new getHouseBySchool();
                String resultjson = get.GetHouseBySchool(SchoolID);
                response.getWriter().write(resultjson);
                if (resultjson == null || resultjson.length() <= 0)
                    serverLog += "getHouseBySchool_dataerror";
                else
                    serverLog += "getHouseBySchool get " + SchoolID;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                serverLog += "getcomment_error";
            }
        System.out.println(serverLog);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
