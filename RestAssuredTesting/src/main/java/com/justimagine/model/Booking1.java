package com.justimagine.model;



public class Booking1 {

	private String firstName;
	private String lastName;
	private String checkin;
	private String checkout;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Booking1 [firstName=" + firstName + ", lastName=" + lastName + ", checkin=" + checkin + ", checkout="
				+ checkout + "]";
	}
	
	
}
