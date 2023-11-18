package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		super();
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	private void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	private void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}
	
	public long duration() {
		Duration diff = Duration.between(checkin, checkout); // calculo para obter a diferença das datas
		return diff.toDays(); // retorna a diferenca de datas em dias
	}
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		setCheckin(checkin);
		setCheckout(checkout);
	}

	public String toString() {
		return "Reservation: Room "
				+ getRoomNumber()
				+ ", check in: "
				+ dateFormat.format(checkin)
				+ ", checkout: "
				+ dateFormat.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}

}
