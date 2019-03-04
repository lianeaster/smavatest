package dto;

import lombok.Data;

@Data
public class User {
	private boolean isMale;
	private String firstName;
	private String surname;
	private String dateOdBirth;
	private String phoneNumber;
	private String email;

	public User(boolean isMale, String firstName, String surname, String dateOdBirth, String phoneNumber, String email) {
		this.isMale = isMale;
		this.firstName = firstName;
		this.surname = surname;
		this.dateOdBirth = dateOdBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
