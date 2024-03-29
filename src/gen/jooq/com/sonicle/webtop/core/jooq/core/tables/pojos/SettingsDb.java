/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SettingsDb implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String  serviceId;
    private java.lang.String  key;
    private java.lang.Boolean isSystem;
    private java.lang.Boolean isDomain;
    private java.lang.Boolean isUser;
    private java.lang.Boolean hidden;
    private java.lang.String  type;
    private java.lang.String  help;

    public SettingsDb() {}

    public SettingsDb(SettingsDb value) {
        this.serviceId = value.serviceId;
        this.key = value.key;
        this.isSystem = value.isSystem;
        this.isDomain = value.isDomain;
        this.isUser = value.isUser;
        this.hidden = value.hidden;
        this.type = value.type;
        this.help = value.help;
    }

    public SettingsDb(
        java.lang.String  serviceId,
        java.lang.String  key,
        java.lang.Boolean isSystem,
        java.lang.Boolean isDomain,
        java.lang.Boolean isUser,
        java.lang.Boolean hidden,
        java.lang.String  type,
        java.lang.String  help
    ) {
        this.serviceId = serviceId;
        this.key = key;
        this.isSystem = isSystem;
        this.isDomain = isDomain;
        this.isUser = isUser;
        this.hidden = hidden;
        this.type = type;
        this.help = help;
    }

    /**
     * Getter for <code>core.settings_db.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.settings_db.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.settings_db.key</code>.
     */
    public java.lang.String getKey() {
        return this.key;
    }

    /**
     * Setter for <code>core.settings_db.key</code>.
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }

    /**
     * Getter for <code>core.settings_db.is_system</code>.
     */
    public java.lang.Boolean getIsSystem() {
        return this.isSystem;
    }

    /**
     * Setter for <code>core.settings_db.is_system</code>.
     */
    public void setIsSystem(java.lang.Boolean isSystem) {
        this.isSystem = isSystem;
    }

    /**
     * Getter for <code>core.settings_db.is_domain</code>.
     */
    public java.lang.Boolean getIsDomain() {
        return this.isDomain;
    }

    /**
     * Setter for <code>core.settings_db.is_domain</code>.
     */
    public void setIsDomain(java.lang.Boolean isDomain) {
        this.isDomain = isDomain;
    }

    /**
     * Getter for <code>core.settings_db.is_user</code>.
     */
    public java.lang.Boolean getIsUser() {
        return this.isUser;
    }

    /**
     * Setter for <code>core.settings_db.is_user</code>.
     */
    public void setIsUser(java.lang.Boolean isUser) {
        this.isUser = isUser;
    }

    /**
     * Getter for <code>core.settings_db.hidden</code>.
     */
    public java.lang.Boolean getHidden() {
        return this.hidden;
    }

    /**
     * Setter for <code>core.settings_db.hidden</code>.
     */
    public void setHidden(java.lang.Boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Getter for <code>core.settings_db.type</code>.
     */
    public java.lang.String getType() {
        return this.type;
    }

    /**
     * Setter for <code>core.settings_db.type</code>.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     * Getter for <code>core.settings_db.help</code>.
     */
    public java.lang.String getHelp() {
        return this.help;
    }

    /**
     * Setter for <code>core.settings_db.help</code>.
     */
    public void setHelp(java.lang.String help) {
        this.help = help;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("SettingsDb (");

        sb.append(serviceId);
        sb.append(", ").append(key);
        sb.append(", ").append(isSystem);
        sb.append(", ").append(isDomain);
        sb.append(", ").append(isUser);
        sb.append(", ").append(hidden);
        sb.append(", ").append(type);
        sb.append(", ").append(help);

        sb.append(")");
        return sb.toString();
    }
}
