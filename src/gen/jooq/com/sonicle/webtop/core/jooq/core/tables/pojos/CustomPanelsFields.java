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
public class CustomPanelsFields implements java.io.Serializable {

	private static final long serialVersionUID = 486759889;

	private java.lang.String customPanelId;
	private java.lang.String customFieldId;
	private java.lang.Short  order;

	public CustomPanelsFields() {}

	public CustomPanelsFields(
		java.lang.String customPanelId,
		java.lang.String customFieldId,
		java.lang.Short  order
	) {
		this.customPanelId = customPanelId;
		this.customFieldId = customFieldId;
		this.order = order;
	}

	public java.lang.String getCustomPanelId() {
		return this.customPanelId;
	}

	public void setCustomPanelId(java.lang.String customPanelId) {
		this.customPanelId = customPanelId;
	}

	public java.lang.String getCustomFieldId() {
		return this.customFieldId;
	}

	public void setCustomFieldId(java.lang.String customFieldId) {
		this.customFieldId = customFieldId;
	}

	public java.lang.Short getOrder() {
		return this.order;
	}

	public void setOrder(java.lang.Short order) {
		this.order = order;
	}
}
