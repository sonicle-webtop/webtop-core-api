/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomPanels implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String customPanelId;
    private java.lang.String domainId;
    private java.lang.String serviceId;
    private java.lang.Short  order;
    private java.lang.String name;
    private java.lang.String description;
    private java.lang.String titleI18n;
    private java.lang.String properties;

    public CustomPanels() {}

    public CustomPanels(CustomPanels value) {
        this.customPanelId = value.customPanelId;
        this.domainId = value.domainId;
        this.serviceId = value.serviceId;
        this.order = value.order;
        this.name = value.name;
        this.description = value.description;
        this.titleI18n = value.titleI18n;
        this.properties = value.properties;
    }

    public CustomPanels(
        java.lang.String customPanelId,
        java.lang.String domainId,
        java.lang.String serviceId,
        java.lang.Short  order,
        java.lang.String name,
        java.lang.String description,
        java.lang.String titleI18n,
        java.lang.String properties
    ) {
        this.customPanelId = customPanelId;
        this.domainId = domainId;
        this.serviceId = serviceId;
        this.order = order;
        this.name = name;
        this.description = description;
        this.titleI18n = titleI18n;
        this.properties = properties;
    }

    /**
     * Getter for <code>core.custom_panels.custom_panel_id</code>.
     */
    public java.lang.String getCustomPanelId() {
        return this.customPanelId;
    }

    /**
     * Setter for <code>core.custom_panels.custom_panel_id</code>.
     */
    public void setCustomPanelId(java.lang.String customPanelId) {
        this.customPanelId = customPanelId;
    }

    /**
     * Getter for <code>core.custom_panels.domain_id</code>.
     */
    public java.lang.String getDomainId() {
        return this.domainId;
    }

    /**
     * Setter for <code>core.custom_panels.domain_id</code>.
     */
    public void setDomainId(java.lang.String domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter for <code>core.custom_panels.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.custom_panels.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.custom_panels.order</code>.
     */
    public java.lang.Short getOrder() {
        return this.order;
    }

    /**
     * Setter for <code>core.custom_panels.order</code>.
     */
    public void setOrder(java.lang.Short order) {
        this.order = order;
    }

    /**
     * Getter for <code>core.custom_panels.name</code>.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Setter for <code>core.custom_panels.name</code>.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Getter for <code>core.custom_panels.description</code>.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>core.custom_panels.description</code>.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     * Getter for <code>core.custom_panels.title_i18n</code>.
     */
    public java.lang.String getTitleI18n() {
        return this.titleI18n;
    }

    /**
     * Setter for <code>core.custom_panels.title_i18n</code>.
     */
    public void setTitleI18n(java.lang.String titleI18n) {
        this.titleI18n = titleI18n;
    }

    /**
     * Getter for <code>core.custom_panels.properties</code>.
     */
    public java.lang.String getProperties() {
        return this.properties;
    }

    /**
     * Setter for <code>core.custom_panels.properties</code>.
     */
    public void setProperties(java.lang.String properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CustomPanels (");

        sb.append(customPanelId);
        sb.append(", ").append(domainId);
        sb.append(", ").append(serviceId);
        sb.append(", ").append(order);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(titleI18n);
        sb.append(", ").append(properties);

        sb.append(")");
        return sb.toString();
    }
}
