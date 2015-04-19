package org.lu.wrapper;

public class EntityWrapper<T> {
	private T entity;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	private long totalNumberOfElement;

	public EntityWrapper() {
	}

	public long getTotalNumberOfElement() {
		return totalNumberOfElement;
	}

	public void setTotalNumberOfElement(long totalNumberOfElement) {
		this.totalNumberOfElement = totalNumberOfElement;
	}
}
