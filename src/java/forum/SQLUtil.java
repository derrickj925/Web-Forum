/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum;

import java.util.*;
import java.sql.*;

/**
 *
 * @author derrick
 */
public class SQLUtil {
    
    public static String getHtmlTable(ResultSet results)
            throws SQLException
    {
        StringBuffer htmlRows = new StringBuffer();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        htmlRows.append("<table cellpadding=\"5\" border=\"1\">");
        htmlRows.append("<tr>");
        for(int i=1; i <= columnCount; i++)
            htmlRows.append("<td><b>" + metaData.getColumnName(i) +
                    "</b></td>");
        htmlRows.append("</tr>");
        
        while (results.next())
        {
            htmlRows.append("<tr>");
            for (int i =1; i <=columnCount; i++)
                htmlRows.append("<td>"+ results.getString(i) + "</td>");
            
        }
        htmlRows.append("</tr>");
        htmlRows.append("</table>");
        return htmlRows.toString();
        
    }
    
}
