package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		SellerDao sellerDao = DaoFactory.createSellerDao();
//		
//		System.out.println("=== Test number 1 : Seller findById===");
//		
//		Seller seller = sellerDao.findById(2);
//		
//		System.out.println(seller);
//		
//		System.out.println("=== Test number 2 : Seller findByDepartment===");
//		
//		Department department = new Department();
//		department.setId(1);
//		
//		List<Seller> list = sellerDao.findByDepartment(department);
//		
//		for (Seller s : list) {
//			System.out.println(s.getName());
//		}
//		
//		System.out.println("=== Test number 3 : Seller findAll===");
//		
//		list = sellerDao.findAll();
//		
//		for (Seller s : list) {
//			System.out.println(s.getName());
//		}
//		
//		System.out.println("=== Test number 4 : Seller insert===");
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
//		sellerDao.insert(newSeller);
//		System.out.println("Inserted! New id = " + newSeller.getId());
//		
//		System.out.println("=== Test number 5 : Seller update===");
//		seller = sellerDao.findById(1);
//		seller.setName("José Amiutu");
//		sellerDao.update(seller);
//		System.out.println("Update completed");
//		
//		System.out.println("=== Test number 5 : Seller deleteById===");
//		System.out.print("Input a seller id to be deleted : ");
//		int idToBeDeleted = sc.nextInt();
//		sellerDao.deleteById(idToBeDeleted);
//		System.out.println("Deleted!");
//		
//		sc.close();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test number 1 : Department findById===");
		
		Department department = departmentDao.findById(2);
		
		System.out.println(department);
		
		System.out.println("=== Test number 2 : Department findAll===");
		
		List<Department> departments = departmentDao.findAll();
		
		for (Department d : departments) {
			System.out.println(d);
		}
		
//		System.out.println("=== Test number 3 : Department deleteById===");
//		departmentDao.deleteById(10);
		
//		System.out.println("=== Test number 4 : Department insert===");
//		department = new Department();
//		department.setName("Meal");
//		departmentDao.insert(department);
//		System.out.println(department);
		
		System.out.println("=== Test number 5 : Department update===");
		department = departmentDao.findById(13);
		department.setName("Spaceships");
		departmentDao.update(department);
	}

}
