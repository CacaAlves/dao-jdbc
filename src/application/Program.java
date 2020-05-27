package application;

import java.util.Date;
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
		
		System.out.println("=== Test number 3 : Seller findAll===");
		
		list = sellerDao.findAll();
		
		for (Seller s : list) {
			System.out.println(s.getName());
		}
		
		System.out.println("=== Test number 4 : Seller insert===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=== Test number 5 : Seller update===");
		seller = sellerDao.findById(1);
		seller.setName("José Amiutu");
		sellerDao.update(seller);
		System.out.println("Update completed");
	}

}
