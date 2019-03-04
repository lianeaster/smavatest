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
}
