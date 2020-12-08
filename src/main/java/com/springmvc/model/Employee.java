package com.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 4174508751893677765L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;
	@NotNull
	@Type(type = "uuid-char")
	private UUID uuid;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@NotNull
	private Date createdTime;
	@NotNull
	private Long createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastUpdatedDate;
	@NotNull
	private Long lastUpdatedBy;
	private String name;
	private String surname;
	private Double salary;
	private String address;
	private String gender;
}
