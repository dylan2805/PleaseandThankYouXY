public class User
{
	private String firstName, lastName, city, country, email, password;
	
	public User (Object firstName, Object lastName, Object city, Object country, Object email, Object password)
	{
		this.firstName = (String) firstName;
		this.lastName = (String) lastName;
		this.city = (String) city;
		this.country = (String) country;
		this.email = (String) email;
		this.password = (String) password;
	}

	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}

	public void setCity (String city)
	{
		this.city = city;
	}

	public void setCountry (String country)
	{
		this.country = country;
	}

	public void setEmail (String email)
	{
		this.email = email;
	}

	public void setPassword (String password)
	{
		this.password = password;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public String getCity ()
	{
		return city;
	}

	public String getCountry ()
	{
		return country;
	}

	public String getEmail ()
	{
		return email;
	}

	public String getPassword ()
	{
		return password;
	}
}
