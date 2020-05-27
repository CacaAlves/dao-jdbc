package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test number 1 : Seller findById===");
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println(seller);
		
		System.out.println("=== Test number 2 : Seller findByDepartment===");
		
		Department department = new Department();
		department.setId(1);
		
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller s : list) {
			System.out.println(s.getName());
		}
		
	}

}
