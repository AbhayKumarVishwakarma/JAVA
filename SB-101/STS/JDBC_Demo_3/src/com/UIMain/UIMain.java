package com.UIMain;

import java.util.List;
import java.util.Scanner;

import com.dao.RoomDao;
import com.dao.RoomDaoImp;
import com.dto.CustomerDto;
import com.dto.CustomerDtoImp;
import com.dto.RoomDto;
import com.dto.RoomDtoImp;
import com.exception.RoomException;

public class UIMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("1. Add new room");
			System.out.println("2. Get room by room-type");
			System.out.println("3. Get empty room");
			System.out.println("4. Add Customer To Room");
			System.out.println("5. Remove Customer from room");
			System.out.println("6. Get Customer From Particular Room");
			System.out.println("7. Get All Room Details");
			System.out.println("0. Exit");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			     case 1:
			    	 addNewRoomUI(sc);
			    	 break;
			     case 2:
			    	 getRoomByRoomTypeUI(sc);
			    	 break;
			     case 3:
			    	 getEmptyRoomUI();
			    	 break;
			     case 4:
			    	 addCustomerToRoomUI(sc);
			    	 break;
			     case 5:
			    	 removeCustomerFromRoomUI(sc);
			    	 break;
			     case 6:
			    	 getCustomerFromParticularRoomUI(sc);
			    	 break;
			     case 7:
			    	 getAllRoomDetailsUI(sc);
			    	 break;
			     case 0:
			    	 System.out.println("Thanks for using our service");
			    	 break;
			     default:
			         System.out.println("Bye Bye");
			         break;
			}
			
		}while(choice != 0);
		sc.close();
	}

	static void addNewRoomUI(Scanner sc) {
		System.out.print("Enter room number ");
		int rNum = sc.nextInt();
		System.out.print("Enter room type ");
		String rType = sc.next();
		System.out.print("Enter room price per night ");
		double rPrice = sc.nextDouble();
		System.out.print("Enter maximum person ");
		int maxP = sc.nextInt();
		System.out.print("Enter room is empty ");
		boolean isEmpty = sc.nextBoolean();
		
		RoomDto rDTO = new RoomDtoImp(rNum, rType, rPrice, maxP, isEmpty);
		RoomDao rDAO = new RoomDaoImp();
		
		try {
			String msg = rDAO.addRoom(rDTO);
			System.out.println(msg);
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getRoomByRoomTypeUI(Scanner sc) {
		System.out.print("Enter room type ");
		String rType = sc.next();
		
		RoomDao rDAO = new RoomDaoImp();
		
		try {
			RoomDto room = rDAO.getRoomByRoomType(rType);
			System.out.println(room);
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getEmptyRoomUI() {
        RoomDao rDAO = new RoomDaoImp();
		
		try {
			List<RoomDto> list = rDAO.getEmptyRoom();
			list.forEach(t -> System.out.println(t));
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void addCustomerToRoomUI(Scanner sc) {
		System.out.print("Enter customer Id ");
		int cId = sc.nextInt();
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		System.out.print("Enter room number ");
		int rNum = sc.nextInt();
		
		CustomerDto cDTO = new CustomerDtoImp(cId, name, address, rNum);
		RoomDao rDAO = new RoomDaoImp();
		
		try {
			String msg = rDAO.addCustomerToRoom(cDTO, rNum);
			System.out.println(msg);
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void removeCustomerFromRoomUI(Scanner sc) {
		System.out.print("Enter customer Id ");
		int cId = sc.nextInt();
		System.out.print("Enter room number ");
		int rNum = sc.nextInt();
		
		RoomDao rDAO = new RoomDaoImp();
		
		try {
			String msg = rDAO.removeCustomerFromRoom(cId, rNum);
			System.out.println(msg);
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getCustomerFromParticularRoomUI(Scanner sc) {
		System.out.print("Enter room number ");
		int rNum = sc.nextInt();
		
        RoomDao rDAO = new RoomDaoImp();
		
		try {
			List<CustomerDto> list = rDAO.getCustomerFromParticularRoom(rNum);
			list.forEach(t -> System.out.println(t));
		} catch (RoomException e) {
			System.out.println(e.getMessage());
		}
	}

	static void getAllRoomDetailsUI(Scanner sc) {
        RoomDao rDAO = new RoomDaoImp();
		
		try {
			List<RoomDto> list = rDAO.getAllRoomDetails();
			list.forEach(t -> System.out.println(t));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
