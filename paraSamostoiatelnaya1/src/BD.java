import java.sql.*;

public class BD {
    public static String url = "jdbc:mysql://localhost/ITCompany";
    public static String user = "root";
    public static String password = "";

    // открыть соединение
    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //закрыть соединение
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void tasksOfProject(String project_name){
        Connection connection=null;
        try {
            connection=openConnection();
            String query = "SELECT tasks.task_name FROM `tasks`,`projects` WHERE tasks.project_id=projects.id_project AND projects.project_name=?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,project_name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String task=resultSet.getString("task_name");
                System.out.println(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }
    public void employeeProjects(String employee_surname){
        Connection connection=null;
        try {
            connection=openConnection();
            String query = "SELECT projects.project_name FROM `projects`,`employees` WHERE projects.employee_id=employees.id_employee AND employees.employee_surname=?";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1,employee_surname);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String task=resultSet.getString("project_name");
                System.out.println(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }
    public void finishedProjects(){
        Connection connection=null;
        try {
            connection=openConnection();
            String query = "SELECT projects.project_name FROM `projects` WHERE projects.project_finished=1";
            PreparedStatement statement= connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String task=resultSet.getString("project_name");
                System.out.println(task);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }
}
