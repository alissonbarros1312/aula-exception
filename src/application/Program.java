package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {

			System.out.print("Room number: ");
			Integer roomNum = sc.nextInt();
			System.out.print("Date checkin: ");
			LocalDate checkin = LocalDate.parse(sc.next(), dateFormat);
			System.out.print("Date checkout: ");
			LocalDate checkout = LocalDate.parse(sc.next(), dateFormat);

			Reservation reservation = new Reservation(roomNum, checkin, checkout);
			System.out.println(reservation.toString());

			System.out.print("Date checkin: ");
			checkin = LocalDate.parse(sc.next(), dateFormat);
			System.out.print("Date checkout: ");
			checkout = LocalDate.parse(sc.next(), dateFormat);

			reservation.updateDates(checkin, checkout);
			System.out.println(reservation.toString());

		} catch (DateTimeParseException e) { // excepction for parse
			System.out.println("Invalid Date format");
		} catch (DomainException e) { // exception personalized
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) { // generic exception 
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
