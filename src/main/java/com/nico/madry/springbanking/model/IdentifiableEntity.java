package com.nico.madry.springbanking.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

@MappedSuperclass
public abstract class IdentifiableEntity implements Identifiable {

	/**
	 * the serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "ID", precision = 9, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getName());
		sb.append("[ id=");
		sb.append(id);

		return sb.toString();
	}

}
