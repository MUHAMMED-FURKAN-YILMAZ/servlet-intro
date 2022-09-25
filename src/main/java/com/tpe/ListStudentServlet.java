package com.tpe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tpe.domain.Student;
/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/ListStudentServlet")
public class ListStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<Student> list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        list=new ArrayList<>();
        
        Student student1=new Student();
        student1.setId(1L);
        student1.setName("John Coffee");
        student1.setGrade("10");
        
        list.add(student1);
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Set up HTML table formatting for the output
        out.println("<html><body>");
        out.println("<h3>Student Details</h3>");
        out.println("<table border=1><tr>" + "<td><b>id</b></td>" + "<td><b>Name</b></td>"
                + "<td><b>Grade</b></td></tr>");
        for (Student student : list) {
            out.println("<tr>" + "<td>" + student.getId() + "</td>" + "<td>" + student.getName() + "</td>"
                    + "<td>" + student.getGrade() + "</td></tr>");
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
    @Override
    public void destroy() {
    	System.out.println("destroying");
    	list.clear();
    }
    
    
}