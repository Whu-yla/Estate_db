package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getHouseBySchool {
    public String GetHouseBySchool(String SchoolID){
        String GetHouseBySchool = "";
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url = "jdbc:postgresql://202.114.118.190:5432/history_db";
            Connection connection = DriverManager.getConnection(url, "lw", "123");
            Statement st = connection.createStatement();

            String sql;
            sql = "SELECT * FROM \"HOUSE_SCHOOL_INFO\" WHERE \"SCHOOLID\" = "+ "'" + SchoolID + "'";
            ResultSet rs = st.executeQuery(sql);
            String jsonStr = "[";

            int i = 0;
            while (rs.next()) {
                String newjson = "{\"HOUSEID\":\"" + rs.getString("HOUSEID") + "\",\"DISTANCE\":\""
                        + rs.getString("DISTANCE") + "\"},";
                jsonStr += newjson;
                i++;
            }
            if (i > 0)
                jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
            jsonStr += "]";
            GetHouseBySchool = jsonStr;

            rs.close();
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GetHouseBySchool;
    }
}
