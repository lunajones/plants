package br.com.esndev.plants.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.esndev.plants.entity.base.BaseEntity;
import br.com.esndev.plants.enumerator.LightType;
import br.com.esndev.plants.enumerator.Stage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOG")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Log extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6864138719762232499L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false, length = 255)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	@Column(name = "LIGHT_TYPE")
	@Enumerated(EnumType.STRING)
	private LightType lightType;

	@Column(name = "LIGHT_IN_WATTS")
	private int lightInWatts;

	@ManyToOne
	@JoinColumn(name = "ID_SOIL_MIX")
	private SoilMix soilMix;

	@Column(name = "WATERING_IN_LITERS", nullable = true)
	private int wateringInLiters;

	@Column(name = "WATERING_FREQUENCY", nullable = true)
	private int wateringFrequency;

	@Column(name = "STAGE")
	@Enumerated(EnumType.STRING)
	private Stage stage;

	@ManyToOne
	@JoinColumn(name = "ID_PLANT")
	private Plant plant;

}