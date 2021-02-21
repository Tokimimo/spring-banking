package com.nico.madry.springbanking.model;

import java.time.ZonedDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AuditedEntity extends IdentifiableEntity {

	@Temporal(TemporalType.DATE)
	private ZonedDateTime creationDate;

	@Temporal(TemporalType.DATE)
	private ZonedDateTime lastUpdatedDate;

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ZonedDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(final ZonedDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
}
