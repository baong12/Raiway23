package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.vti.entity.Department;

public class DepartmentDao {
	private static final String IO_EXC = "Lỗi IO";
	private static final String FILE_NOT_FOUND_EXC = "Lỗi không tìm thấy file";
	private static final String SQL_EXC = "Lỗi kết nối SQL";
	private static final String CLASS_NOT_FOUND_EXC = "Lỗi đăng ký driver";
	private static Connection connection;

	public static void connectDb() {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src/resource/database.properties"));

			String DB_URL = properties.getProperty("url");
			String USER_NAME = properties.getProperty("username");
			String PASSWORD = properties.getProperty("password");

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("Connect success!");
		} catch (ClassNotFoundException e) {
			System.out.println(CLASS_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(FILE_NOT_FOUND_EXC);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(IO_EXC);
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(SQL_EXC);
			e.printStackTrace();
		}
	}

//	Question 1: read data – get list departments
//		Tạo method để lấy ra danh sách tất cả các Department
//		Gợi ý:
//		Viết method getDepartments() và return ra
//		List<Department>, Nếu có lỗi sẽ throw Exception lên frontend để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này
	public static List<Department> getDepartments() throws SQLException {
		List<Department> resultList = new ArrayList<Department>();
		Statement statement = connection.createStatement();
		String sql = "SELECT department_id, department_name FROM department";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("department_id");
			String name = resultSet.getString("department_name");
			resultList.add(new Department(id, name));
		}

		return resultList;
	}

//	Question 2: read data – get department by id
//		Tạo method để lấy ra Department có id = 5
//		Gợi ý: Làm tương tự câu trên
//		Nếu không có department nào có id = 5 thì sẽ in ra là
//		"Cannot find department which has id = 5"
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này
	public static Department getDepartmentDemo() throws SQLException {
		Department result = null;
		Statement statement = connection.createStatement();
		String sql = "SELECT department_id, department_name FROM department " + "WHERE department_id = 5";
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("department_id");
			String name = resultSet.getString("department_name");
			result = new Department(id, name);
		}
		if (result == null) {
			System.out.println("Cannot find department which has id = 5");
		}

		return result;
	}

//	Question 3: Tiếp tục Question 2 (read data – get department by id)
//		Không fix cứng id nữa mà sẽ dùng scanner để yêu cầu người dùng
//		nhập vào id, sau đó trả về thông tin department có id như người dùng
//		nhập vào
//		Gợi ý:
//		Trên backend sẽ viết method getDepartmentById(int id) và
//		return ra Department
//		Nếu tìm thấy department có id = parameter thì sẽ return
//		về department đó
//		Nếu không tìm thấy thì sẽ throw ra với message
//		"Cannot find department which has id = " + id
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này
	public static Department getDepartmentById(int id) throws SQLException {
		Department result = null;
		String sql = "SELECT department_id, department_name FROM department " + "WHERE department_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("department_name");
			result = new Department(id, name);
		} else {
			System.out.println("Cannot find department which has id = " + id);
		}

		return result;
	}

//	Question 4: check data exists – check department name exists
//		Tạo method để check department name có tồn tại hay không?
//		Gợi ý:
//		Trên backend sẽ viết method
//		isDepartmentNameExists(String name) và return ra boolean
//		Nếu tìm thấy department đã có name = name parameter
//		thì sẽ return true
//		Nếu không tìm thấy thì sẽ return ra false
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này
	public static boolean isDepartmentNameExists(String name) throws SQLException {
		String query = "SELECT * FROM department WHERE department_name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

//	Question 5: create data – create department
//		Tạo method để người dùng có thể tạo được department
//		Gợi ý:
//		Trên backend sẽ viết method void createDepartment (String
//		name)
//		Check xem đã có department nào có tên như parameter
//		chưa (sử dụng method ở Question 6 để check)
//		Nếu tìm đã có department có tên như parameter
//		thì throw ra Exception "Department Name is
//		Exists!"
//		Nếu không tìm thấy thì sẽ create department
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này (dùng scanner để nhập thông tin của department muốn
//		create)
	public static void createDepartment(String name) throws SQLException, Exception {
		if (isDepartmentNameExists(name)) {
			throw new Exception("Department Name is Exists!");
		} else {
			String query = "INSERT INTO department(department_name) VALUES (?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}

//	Question 6: update data – update department
//		Tạo method để người dùng có thể update được department name
//		Gợi ý:
//		Trên backend sẽ viết method void updateDepartmentName
//		(int id, String newName)
//		Check xem đã có department nào có id như id
//		parameter chưa (Viết thêm method như Question 6 để
//		check, tên method là isDepartmentIdExists(int id))
//		Nếu không tìm thấy department có id = id
//		parameter thì sẽ throw ra Exception có message
//		"Cannot find department which has id = " + id
//		Nếu tìm thấy department có id = id parameter thì
//		sẽ check xem tên mới của department có bị
//		trùng không (sử dụng method ở Question 6 để
//		check)
//		Nếu tìm đã có department có tên như parameter
//		thì throw ra Exception "Department Name is
//		Exists!"
//		Nếu không tìm thấy thì sẽ update department
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này(dùng scanner để nhập thông tin của department muốn
//		update)
	public static void updateDepartmentName(int id, String newName) throws SQLException, Exception {
		if (!isDepartmentIdExists(id)) {
			throw new Exception("Department Name is not Exists!");
		} else {
			String query = "UPDATE department SET department_name = ? WHERE department_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}

	public static boolean isDepartmentIdExists(int id) throws SQLException {
		String query = "SELECT * FROM department WHERE department_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

//	Question 7:
//		Tạo method để người dùng có thể xóa được department theo id mà user
//		nhập vào
//		Gợi ý:
//		Trên backend sẽ viết method void deleteDepartment (int id)
//		Check xem đã có department nào có id như id
//		parameter chưa (sử dụng method ở Question 6 để
//		check)
//		Nếu không tìm thấy department có id = id
//		parameter thì sẽ throw ra Exception có message
//		"Cannot find department which has id = " + id
//		Nếu tìm thấy thì sẽ delete department đó
//		Nếu có lỗi sẽ throw Exception lên front-end để in ra
//		Trên front-end sẽ gọi class DepartmentDao và demo method
//		này (dùng scanner để nhập vào id của department muốn delete)
	public static void deleteDepartment(int id) throws SQLException, Exception {
		if (!isDepartmentIdExists(id)) {
			throw new Exception("Department Name is not Exists!");
		} else {
			String query = "DELETE FROM department WHERE department_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int affectedRecordCount = preparedStatement.executeUpdate();
			System.out.println("Số bản ghi đã bị ảnh hưởng: " + affectedRecordCount);
		}
	}

//	Question 8:
//		Làm các chức năng CRUD tương tự với table Account
//		(Chú ý: trong chức năng getListAccount, getById thì phải in ra cả
//		thông tin tên của department
}
