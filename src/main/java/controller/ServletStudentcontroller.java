package controller;

import model.Classroom;
import model.Student;
import sevice.ClassroomSevice;
import sevice.StudentSevice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Studentcontroller", value = "/Studentcontroller")
public class ServletStudentcontroller extends HttpServlet {
    StudentSevice staffSevice = new StudentSevice();
    ClassroomSevice departmentSevice = new ClassroomSevice();
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "findAll":
                try {
                    showHome(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    showHome(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
//            case "delete":
//                try {
//                    deletestudent(request, response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
            case "create":
                try {
                    showFormCreate(request , response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                response.sendRedirect(request.getContextPath() + "/5");
                break;
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Classroom> classroom = departmentSevice.findAll();
        request.setAttribute("departments", classroom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = staffSevice.findById(id);
        if (student != null) {
            request.setAttribute("student", student);
            List<Classroom> departments = departmentSevice.findAll();
            request.setAttribute("departments", departments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/staffs?action=findAll");
        }
    }
// delete
    private void showHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String action = request.getParameter("action");
        List<Student> studentList = null;
        if(action.equals("findAll")){
            studentList = StudentSevice.findAll();
        } else if (action.equals("search")) {
            String name = request.getParameter("nameSearch");
            studentList = StudentSevice.findByName(name);
        }
        request.setAttribute("staffList", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "edit":
                try {
                    editStudent(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    createStudent(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
    private void editStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String classroom = request.getParameter("classroom");

        Student student = new Student(id, name, email, birth,address, phone, classroom);
        StudentSevice.edit(id, Student);
        response.sendRedirect(request.getContextPath() + "/ staff?action=findAll");
    }
    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
//        String classroom = request.getParameter("classroom");
        Classroom classroom = new classroom();
        Student student = new Student(id,name, email, birth,address, phone, classroom);
        StudenSevice.add(student);
        response.sendRedirect(request.getContextPath() + "/staffs?action=findAll");
    }
}
