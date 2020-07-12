
import DAO.AnnouncementDAO;
import models.Announcement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {
    private AnnouncementDAO announcementDAO;

    public void init() {
        announcementDAO = new AnnouncementDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/list-announcements":
                    listAnnouncements(request, response);
                    break;
                case "/showDescription":
                    showDescription(request,response);
                    break;
                default:
                    getStartPage(request,response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void getStartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("start.jsp");
        dispatcher.forward(request, response);
    }

    private void listAnnouncements(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Announcement> listStudent = announcementDAO.selectAll();
        request.setAttribute("listAnnouncement", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Announcement existingAnnouncement = announcementDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("announcement", existingAnnouncement);
        dispatcher.forward(request, response);
    }

   private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String title = request.getParameter("Title");
        String description = request.getParameter("Description");
        Announcement newAnnouncement = new Announcement(title, description);
        announcementDAO.insert(newAnnouncement);
        response.sendRedirect("list-announcements");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("Title");
        String description = request.getParameter("Description");
        Announcement book = new Announcement(id, title, description);
        announcementDAO.update(book);
        response.sendRedirect("list-announcements");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        announcementDAO.delete(id);
        response.sendRedirect("list-announcements");
    }

    private void showDescription(HttpServletRequest request, HttpServletResponse response){

    }
}
