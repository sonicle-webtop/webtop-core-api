/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Settings implements java.io.Serializable {

	private static final long serialVersionUID = 1181664597;

	private java.lang.String serviceId;
	private java.lang.String key;
	private java.lang.String value;

	public Settings() {}

	public Settings(
		java.lang.String serviceId,
		java.lang.String key,
		java.lang.String value
	) {
		this.serviceId = serviceId;
		this.key = key;
		this.value = value;
	}

	public java.lang.String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(java.lang.String serviceId) {
		this.serviceId = serviceId;
	}

	public java.lang.String getKey() {
		return this.key;
	}

	public void setKey(java.lang.String key) {
		this.key = key;
	}

	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}
}