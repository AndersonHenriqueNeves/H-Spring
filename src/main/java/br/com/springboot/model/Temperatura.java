package br.com.springboot.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "temperaturas")
public class Temperatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long id_galpao;
	
	private float temp;
	
	private float umid;
	
	@Basic(optional = false)
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_galpao() {
		return id_galpao;
	}

	public void setId_galpao(Long id_galpao) {
		this.id_galpao = id_galpao;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getUmid() {
		return umid;
	}

	public void setUmid(float umid) {
		this.umid = umid;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
	}
	
	
	
	
	
}