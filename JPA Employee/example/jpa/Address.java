package example.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity; // Must use JPA specification
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String addressLine;
	@OneToOne (cascade = CascadeType.ALL)
	private Country country;

	public Address ()	// mandatory, setter getter also
	{
		super ();
	}

	public Address (String addressLine, Country country)
	{
		this.addressLine = addressLine;
		this.country = country;
	}

	public int getId ()
	{
		return id;
	}

	public void setId (int id)
	{
		this.id = id;
	}

	public String getAddressLine ()
	{
		return addressLine;
	}

	public void setAddressLine (String addressLine)
	{
		this.addressLine = addressLine;
	}
	
	public Country getCountry ()
	{
		return country;
	}

	public void setCountry (Country country)
	{
		this.country = country;
	}

	@Override
	public String toString ()
	{
		return "Address [id=" + id + ", addressLine=" + addressLine + ", country=" + country + "]";
	}
}
