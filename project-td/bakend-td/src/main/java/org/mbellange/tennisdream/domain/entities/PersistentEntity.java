package org.mbellange.tennisdream.domain.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class PersistentEntity implements Serializable {

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();
		
}
