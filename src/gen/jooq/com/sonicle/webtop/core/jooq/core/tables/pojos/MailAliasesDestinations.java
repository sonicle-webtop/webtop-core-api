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
public class MailAliasesDestinations implements java.io.Serializable {

	private static final long serialVersionUID = -1903992096;

	private java.lang.String domainId;
	private java.lang.String aliasAddress;
	private java.lang.String destinationAddress;

	public MailAliasesDestinations() {}

	public MailAliasesDestinations(
		java.lang.String domainId,
		java.lang.String aliasAddress,
		java.lang.String destinationAddress
	) {
		this.domainId = domainId;
		this.aliasAddress = aliasAddress;
		this.destinationAddress = destinationAddress;
	}

	public java.lang.String getDomainId() {
		return this.domainId;
	}

	public void setDomainId(java.lang.String domainId) {
		this.domainId = domainId;
	}

	public java.lang.String getAliasAddress() {
		return this.aliasAddress;
	}

	public void setAliasAddress(java.lang.String aliasAddress) {
		this.aliasAddress = aliasAddress;
	}

	public java.lang.String getDestinationAddress() {
		return this.destinationAddress;
	}

	public void setDestinationAddress(java.lang.String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
}