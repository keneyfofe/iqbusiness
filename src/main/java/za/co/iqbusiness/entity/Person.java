package za.co.iqbusiness.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.engine.jdbc.SerializableBlobProxy;

@Entity
@Table(name = "persons", catalog = "iqbusiness_db", schema = "")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private long idNumber;
	@Column(nullable = false,length = 40)
	private String fullName;
	@Column(nullable = false,length = 13)
	private long telephoneNumber;
	
	public Person() {
		
	}

	public Person(long idNumber, String fullName, long telephoneNumber) {
		super();
		this.idNumber = idNumber;
		this.fullName = fullName;
		this.telephoneNumber = telephoneNumber;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [idNumber=" + idNumber + ", fullName=" + fullName + ", telephoneNumber=" + telephoneNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (int) (idNumber ^ (idNumber >>> 32));
		result = prime * result + (int) (telephoneNumber ^ (telephoneNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (idNumber != other.idNumber)
			return false;
		if (telephoneNumber != other.telephoneNumber)
			return false;
		return true;
	}

	

}
