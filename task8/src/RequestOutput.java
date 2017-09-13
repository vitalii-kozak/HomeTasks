import tools.FileParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;

public class RequestOutput {




    public static void generate(HttpServletResponse resp, HttpServletRequest req) {
        String nameOfWord, valueOfWord;
        Enumeration names = req.getParameterNames();
        nameOfWord = (String) names.nextElement();
        valueOfWord = req.getParameterValues(nameOfWord)[0];
        int numberOfWords = FileParser.parseFile("c:/111.log", valueOfWord);

        try {

            resp.setContentType("text/html; charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.print("<HTML><HEAD>");
            out.print("<TITLE>Результат</TITLE>");
            out.print("</HEAD><BODY>");
            out.print("<TABLE BORDER=3>");
            out.print("<TR>");
            out.print("<TD>" + "&nbsp &nbsp &nbspКоличество вхождений слова&nbsp &nbsp &nbsp" + valueOfWord + "&nbsp &nbsp &nbsp" + "</TD>");
            out.print("<TD>" + "&nbsp &nbsp &nbsp" + numberOfWords + "&nbsp &nbsp &nbsp" + "</TD>");
            out.print("</TR>");
            out.print("</TABLE></BODY></HTML>");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

