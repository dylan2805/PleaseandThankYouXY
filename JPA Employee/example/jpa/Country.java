package example.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String country;
	@OneToOne (cascade = CascadeType.ALL)
	private City city;
	
	public Country ()
	{
		super ();
	}

	public Country (String country, City city)
	{
		super ();
		this.country = country;
		this.city = city;
	}

	public int getId ()
	{
		return id;
	}

	public void setId (int id)
	{
		this.id = id;
	}

	public String getCountry ()
	{
		return country;
	}

	public void setCountry (String country)
	{
		this.country = country;
	}
	
	public City getCity ()
	{
		return city;
	}

	public void setCity (City city)
	{
		this.city = city;
	}

	@Override
	public String toString ()
	{
		return "Country [id=" + id + ", country=" + country + ", city=" + city
		    + "]";
	}
}
