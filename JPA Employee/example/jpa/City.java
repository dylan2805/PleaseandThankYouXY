package example.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String city;
	
	public City ()
	{
		super ();
	}
	
	public City (String city)
	{
		super ();
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

	public String getCity ()
	{
		return city;
	}

	public void setCity (String city)
	{
		this.city = city;
	}

	@Override
	public String toString ()
	{
		return "City [id=" + id + ", city=" + city + "]";
	}
}
