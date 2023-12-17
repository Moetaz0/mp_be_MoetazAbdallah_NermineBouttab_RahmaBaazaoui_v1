package soa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Reglement {


	@Id
	@GeneratedValue
	private Long id;

	private String code;
	private String Type;

	private double mp;
	private String date;

	public Reglement() {
		// Default constructor
	}

	public Reglement(double mp, String date,String code , String Type) {
		this.mp = mp;
		this.date = date;
		this.Type=Type;
		this.code=code;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public double getMp() {
		return mp;
	}

	public void setMp(double mp) {
		this.mp = mp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Reglement [id=" + id + ", Montant paye=" + mp + ", date=" + date + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Reglement reglement = (Reglement) obj;
		return Double.compare(reglement.mp, mp) == 0 &&
				Objects.equals(id, reglement.id) &&
				Objects.equals(date, reglement.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mp, date);
	}
}
