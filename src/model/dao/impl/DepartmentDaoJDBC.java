package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department department) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("INSERT INTO department "
			+ "(Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, department.getName());
			
			int rowsAffected = pst.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					department.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
	}

	@Override
	public void update(Department department) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(
					"UPDATE department "
					+"SET Name = ? "
					+"WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, department.getName());
			pst.setInt(2, department.getId());
			
			pst.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Deleted");
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn
					.prepareStatement("SELECT department.* " + "FROM department " + "WHERE Id = ? " + "ORDER BY Name");
			pst.setInt(1, id);

			rs = pst.executeQuery();

			if (rs.next()) {
				Department dep = new Department();
				dep.setId(id);
				dep.setName(rs.getString("Name"));
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = pst.executeQuery();

			List<Department> list = new ArrayList<>();
			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("Id"));
				department.setName(rs.getString("Name"));
				list.add(department);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
	}

}
