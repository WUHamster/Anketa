package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuestionServlet extends HttpServlet {

    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;
    static final int QUESTION_2_YES = 2;
    static final int QUESTION_2_NO = 3;

    static final String TEMPLATE = "<html>" +
            "<head><title>Prog.kiev.ua</title></head>" +
            "<body><h1>%s</h1></body></html>";

    final int[] results = new int[4];
    private ArrayList<Person> persons = new ArrayList<>();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String q1 = req.getParameter("question1");
        final String q2 = req.getParameter("question2");
        final String firstName = req.getParameter("firstName");
        final String lastName = req.getParameter("lastName");
        final String age = req.getParameter("age");

        try {
            persons.add(new Person(firstName, lastName, Integer.parseInt(age)));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        final int idx1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
        final int idx2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;

        results[idx1]++;
        results[idx2]++;

        String res ="<p> We currently have " + persons.size() + " peaple on our database</p>";
        res += "<p>" + results[QUESTION_1_YES] + " of them are married</p>";
        res += "<p>" + results[QUESTION_2_YES] + " of them have kids</p>";
        res += "<p> Your name is: " + firstName + " " + lastName + " and you are " + age + " years old</p>";
        res += "<p>Care to enter someone else?</p>";
        res += "<a href=\"quest.html\">Quest</a>";

        resp.getWriter().println(String.format(TEMPLATE, res));
    }
}
