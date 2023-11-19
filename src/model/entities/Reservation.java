package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
			throw new DomainException("Reservations dates for update must be futures dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");

		}
		this.roomNumber = roomNumber;
		setCheckin(checkin);
		setCheckout(checkout);
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
		return ChronoUnit.DAYS.between(checkin, checkout);
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) {
		if (checkin.isBefore(LocalDate.now()) || checkout.isBefore(LocalDate.now())) {
			throw new DomainException("Reservations dates for update must be futures dates");
		}
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");

		}
		setCheckin(checkin);
		setCheckout(checkout);

	}

	public String toString() {
		return "Reservation: Room " + getRoomNumber() + ", check in: " + dateFormat.format(checkin) + ", checkout: "
				+ dateFormat.format(checkout) + ", " + duration() + " nights";
	}

}
