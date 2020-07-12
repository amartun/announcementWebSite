package DAO;

import models.Announcement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnnouncementDAO implements IUser<Announcement> {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Students";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String INSERT_ANNOUNCEMENT_SQL = "INSERT INTO announcement" + "  (Title, Description) VALUES "
            + " (?, ?);";

    private static final String SELECT_ANNOUNCEMENT_BY_ID = "select id,Title,Description from announcement where id =?";
    private static final String SELECT_ALL_ANNOUNCEMENTS = "select * from announcement";
    private static final String DELETE_ANNOUNCEMENTS_SQL = "delete from announcement where id = ?;";
    private static final String UPDATE_ANNOUNCEMENTS_SQL = "update announcement set Title = ?,Description= ? where id = ?;";

    public AnnouncementDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Announcement announcement) throws SQLException {
        System.out.println(INSERT_ANNOUNCEMENT_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANNOUNCEMENT_SQL)) {
            preparedStatement.setString(1, announcement.getAnnouncement_title());
            preparedStatement.setString(2, announcement.getAnnouncemnt_description());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public Announcement select(int id) {
        Announcement announcement = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANNOUNCEMENT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                announcement = new Announcement(id, title, description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return announcement;
    }

    @Override
    public List<Announcement> selectAll() {
        List<Announcement> announcements = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ANNOUNCEMENTS);
            {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("Title");
                    String description = rs.getString("Description");
                    announcements.add(new Announcement(id, title, description));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return announcements;
    }
    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ANNOUNCEMENTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Announcement announcement) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ANNOUNCEMENTS_SQL);) {
            statement.setString(1, announcement.getAnnouncement_title());
            statement.setString(2, announcement.getAnnouncemnt_description());
            statement.setInt(3, announcement.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}

