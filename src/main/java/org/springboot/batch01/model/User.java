package org.springboot.batch01.model;

public class User
{

	private Integer id;
    private String firstName;
    private String lastName;
    private String eMail;

    // setters & getters
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEMail() 
	{
		return eMail;
	}

	public void setEMail(String eMail) 
	{
		this.eMail = eMail;
	}	 

	@Override
	public String toString() 
	{
		return String.format("User[id=%d, firstName='%s', lastName='%s', email='%s']", id, firstName, lastName, eMail);
	}


	
}