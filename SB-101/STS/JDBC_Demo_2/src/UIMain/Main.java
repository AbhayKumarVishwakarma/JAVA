package UIMain;

import java.util.List;
import java.util.Scanner;

import com.dao.ProductDAO;
import com.dao.ProductDAOimp;
import com.dto.Product;
import com.exception.ProductException;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			System.out.println("1. Add product \n2. Show all product \n3. Show product less than quantity \n4. Add product quantity \n5. Delete product by Name \n6. Show product by name \n7. Delete product whose name start");
			System.out.println("0. Exit");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			    case 1:
			    	addProductUI(sc);
			    	break;
			    case 2:
			    	getAllProductsUI();
			    	break;
			    case 3:
			    	getAllProductQuantityLessThanUI(sc);
			    	break;
			    case 4:
			    	addProductQuantityUI(sc);
			    	break;
			    case 5:
			    	deleteProductByProductNameUI(sc);
			    	break;
			    case 6:
			    	getProductByProductNameUI(sc);
			    	break;
			    case 7:
			    	deleteProductWhoseNameStartUI(sc);
			    	break;
			    case 0:
			    	System.out.println("Thanks for using our services");
			    	break;
			    default:
			    	System.out.println("Bye Bye");
			}
			
		}while(choice!=0);
		sc.close();
	}

	private static void addProductUI(Scanner sc) {
		System.out.print("Enter product Id ");
		int id = sc.nextInt();
		System.out.print("Enter product name ");
		String name = sc.next();
		System.out.print("Enter product price ");
		int price = sc.nextInt();
		System.out.print("Enter product quantity ");
		int quantity = sc.nextInt();
		
		Product pro = new Product(id, name, price, quantity);
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			String msg = proDAO.addProduct(pro);
			System.out.println(msg);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getAllProductsUI() {
        ProductDAO proDAO = new ProductDAOimp();
		try {
			List<Product> list = proDAO.getAllProducts();
			list.forEach(t -> System.out.println(t));
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getAllProductQuantityLessThanUI(Scanner sc) {
		System.out.print("Enter product quantity ");
		int quantity = sc.nextInt();
		
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			List<Product> list = proDAO.getAllProductQuantityLessThan(quantity);
			list.forEach(t -> System.out.println(t));
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	static void addProductQuantityUI(Scanner sc) {
		System.out.print("Enter product Id ");
		int id = sc.nextInt();
		System.out.print("Enter product quantity ");
		int quantity = sc.nextInt();
		
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			String msg = proDAO.addProductQuantity(id, quantity);
			System.out.println(msg);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deleteProductByProductNameUI(Scanner sc) {
		System.out.print("Enter product name ");
		String name = sc.next();
		
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			String msg = proDAO.deleteProductByProductName(name);
			System.out.println(msg);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getProductByProductNameUI(Scanner sc) {
		System.out.print("Enter product name ");
		String name = sc.next();
		
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			Product pro = proDAO.getProductByProductName(name);
			if(pro == null) System.out.println("Not find any product");
			else System.out.println(pro);
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deleteProductWhoseNameStartUI(Scanner sc) {
		System.out.print("Enter product name ");
		String name = sc.next();
		
		ProductDAO proDAO = new ProductDAOimp();
		
		try {
			proDAO.deleteProductWhoseNameStart(name);
			System.out.println("Product deleted successfully");
		} catch (ProductException e) {
			System.out.println(e.getMessage());
		}
	}
}
