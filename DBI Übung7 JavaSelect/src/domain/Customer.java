package domain;

import java.time.LocalDateTime;

public class Customer {
	private Integer	   		customerID;
	private String			email;
	private String			firstname;
	private String			lastname;
	private String			gender;
	private LocalDateTime	birthdate;
	private Double			credits;
	
	
	
	public Customer(Integer customerID, String email, String firstname, String lastname, String gender, LocalDateTime birthdate, Double credits) {
		setCustomerID(customerID);
		setEmail(email);
		setFirstname(firstname);
		setLastname(lastname);
		setGender(gender);
		setBirthdate(birthdate);
		setCredits(credits);
	}

	
	public Integer getCustomerID()
	{
		return customerID;
	}
	
	public String getEmail()
	{
		return email;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public String getGender()
	{
		return gender;
	}

	public LocalDateTime getBirthdate()
	{
		return birthdate;
	}

	public Double getCredits()
	{
		return credits;
	}

	public void setCustomerID(Integer customerID)
	{
		this.customerID = customerID;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public void setBirthdate(LocalDateTime birthdate)
	{
		this.birthdate = birthdate;
	}

	public void setCredits(Double credits)
	{
		this.credits = credits;
	}


	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", Gender=" + gender
				+ ", birthdate=" + birthdate + ", credits=" + credits  + "]\n";
	}
}
