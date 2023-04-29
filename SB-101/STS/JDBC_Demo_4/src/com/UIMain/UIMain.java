package com.UIMain;

import java.util.Scanner;

import com.dao.CarDAO;
import com.dao.CarDAOimp;
import com.dto.CarDTO;
import com.dto.CarDTOimp;
import com.exception.NoRecordFound;
import com.exception.SomeThingWentWrongException;

public class UIMain {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("1. Add car \n2. Show all car \n3. Update car \n4. Delete car \n5. Show Company And Model");
			System.out.println("0. Exit");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			    case 1:
			    	addCarUI(sc);
			        break;
			    case 2:
			    	showAllInfromationAboutCarUI();
			        break;
			    case 3:
			    	updateCarUI(sc);
			        break;
			    case 4:
			    	deleteCarUI(sc);
			        break;
			    case 5:
			    	showCompNameModelUI(sc);
			        break;
			    case 0:
			    	System.out.println("Thanks for using our service");
			        break;
			    default:
			    	System.out.println("BYE BYE");
			}
			
		}while(choice != 0);
	}

	static void addCarUI(Scanner sc) {
		System.out.print("Enter car id ");
		String cId = sc.next();
		System.out.print("Enter car model ");
		String model = sc.next();
		System.out.print("Enter car price ");
		int price = sc.nextInt();
		System.out.print("Enter car total seat ");
		int seat = sc.nextInt();
		System.out.print("Enter car company id ");
		String comId = sc.next();
		
		CarDTO car = new CarDTOimp(cId, model, price, seat, comId);
		CarDAO cDAO = new CarDAOimp();
		try {
			cDAO.addCar(car);
		} catch (SomeThingWentWrongException e) {
			System.out.println("Some thing went wrong");
		}
	}

	static void showAllInfromationAboutCarUI() {
		CarDAO cDAO = new CarDAOimp();
		try {
			cDAO.showAllInfromationAboutCar();
		} catch (SomeThingWentWrongException| NoRecordFound e) {
			System.out.println("Some thing went wrong");
		}
	}

	static void updateCarUI(Scanner sc) {
		System.out.print("Enter car id ");
		String cId = sc.next();
		System.out.print("Enter car model ");
		String model = sc.next();
		System.out.print("Enter car price ");
		int price = sc.nextInt();
		System.out.print("Enter car total seat ");
		int seat = sc.nextInt();
		System.out.print("Enter car company id ");
		String comId = sc.next();
		
		CarDTO car = new CarDTOimp(cId,model, price, seat, comId);
		CarDAO cDAO = new CarDAOimp();
		try {
			cDAO.updateCar(car);
		} catch (SomeThingWentWrongException e) {
			System.out.println("Some thing went wrong");
		}
	}

	static void deleteCarUI(Scanner sc) {
		System.out.print("Enter car id ");
		String cId = sc.next();
		
		CarDAO cDAO = new CarDAOimp();
		try {
			cDAO.deleteCar(cId);
		} catch (SomeThingWentWrongException | NoRecordFound e) {
			System.out.println("Some thing went wrong");
		}
	}

	static void showCompNameModelUI(Scanner sc) {
		CarDAO cDAO = new CarDAOimp();
		try {
			cDAO.showCompNameModel();
		} catch (SomeThingWentWrongException | NoRecordFound e) {
			System.out.println("Some thing went wrong");
		}
	}
}
