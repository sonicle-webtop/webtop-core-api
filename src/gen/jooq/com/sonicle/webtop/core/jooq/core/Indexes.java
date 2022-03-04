/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core;



/**
 * A class modelling indexes of tables in core.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final org.jooq.Index ACTIVITIES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("activities_ak1"), com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.REVISION_STATUS }, false);
    public static final org.jooq.Index ACTIVITIES_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("activities_ak2"), com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.EXTERNAL_ID, com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.DOMAIN_ID }, false);
    public static final org.jooq.Index AUDIT_KNOWN_DEVICES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("audit_known_devices_ak1"), com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES.DEVICE_ID }, false);
    public static final org.jooq.Index AUDIT_LOG_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("audit_log_ak1"), com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.CONTEXT, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.ACTION, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.REFERENCE_ID }, false);
    public static final org.jooq.Index AUTOSAVE_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("autosave_ak1"), com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.USER_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.CONTEXT, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.KEY }, false);
    public static final org.jooq.Index CAUSALS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("causals_ak1"), com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.USER_ID, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.MASTER_DATA_ID, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.REVISION_STATUS }, false);
    public static final org.jooq.Index CAUSALS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("causals_ak2"), com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.EXTERNAL_ID, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.DOMAIN_ID }, false);
    public static final org.jooq.Index CUSTOM_FIELDS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_fields_ak1"), com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.REVISION_STATUS, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.NAME }, false);
    public static final org.jooq.Index CUSTOM_FIELDS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_fields_ak2"), com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.NAME }, true);
    public static final org.jooq.Index CUSTOM_FIELDS_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_fields_ak3"), com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.REVISION_STATUS, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SEARCHABLE }, false);
    public static final org.jooq.Index CUSTOM_FIELDS_AK4 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_fields_ak4"), com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.REVISION_STATUS, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.PREVIEWABLE }, false);
    public static final org.jooq.Index CUSTOM_PANELS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_panels_ak1"), com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.ORDER, com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.NAME }, false);
    public static final org.jooq.Index CUSTOM_PANELS_FIELDS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_panels_fields_ak1"), com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.ORDER }, false);
    public static final org.jooq.Index CUSTOM_PANELS_FIELDS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("custom_panels_fields_ak2"), com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID }, false);
    public static final org.jooq.Index DOMAINS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("domains_ak1"), com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS.ENABLED }, false);
    public static final org.jooq.Index DOMAINS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("domains_ak2"), com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS.INTERNET_NAME, com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS.ENABLED }, false);
    public static final org.jooq.Index IM_CHATS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("im_chats_ak1"), com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.REVISION_STATUS }, false);
    public static final org.jooq.Index IM_CHATS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("im_chats_ak2"), com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.CHAT_JID }, false);
    public static final org.jooq.Index IM_MESSAGES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("im_messages_ak1"), com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.CHAT_JID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.TIMESTAMP }, false);
    public static final org.jooq.Index IM_MESSAGES_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("im_messages_ak2"), com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.CHAT_JID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.DELIVERY_TIMESTAMP }, false);
    public static final org.jooq.Index IM_MESSAGES_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("im_messages_ak3"), com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.CHAT_JID, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.TEXT }, false);
    public static final org.jooq.Index IP_GEO_CACHE_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("ip_geo_cache_ak1"), com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE.TIMESTAMP }, false);
    public static final org.jooq.Index LICENSES_LEASES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("licenses_leases_ak1"), com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.USER_ID }, false);
    public static final org.jooq.Index MASTER_DATA_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("master_data_ak1"), com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.PARENT_MASTER_DATA_ID, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.TYPE, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.REVISION_STATUS, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DESCRIPTION }, false);
    public static final org.jooq.Index MASTER_DATA_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("master_data_ak2"), com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.TYPE, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.REVISION_STATUS, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DESCRIPTION }, false);
    public static final org.jooq.Index MASTER_DATA_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("master_data_ak3"), com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.EXTERNAL_ID, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DOMAIN_ID }, false);
    public static final org.jooq.Index MESSAGES_QUEUE_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("messages_queue_ak1"), com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE.USER_ID }, false);
    public static final org.jooq.Index MESSAGES_QUEUE_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("messages_queue_ak2"), com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE.PID }, false);
    public static final org.jooq.Index ROLES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_ak1"), com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES.DOMAIN_ID }, false);
    public static final org.jooq.Index ROLES_ASSOCIATIONS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_associations_ak1"), com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS.USER_UID, com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS.ROLE_UID }, true);
    public static final org.jooq.Index ROLES_ASSOCIATIONS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_associations_ak2"), com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS.ROLE_UID }, false);
    public static final org.jooq.Index ROLES_PERMISSIONS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_permissions_ak1"), com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.ROLE_UID, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.KEY, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.ACTION, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.INSTANCE }, true);
    public static final org.jooq.Index ROLES_PERMISSIONS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_permissions_ak2"), com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.ROLE_UID, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.KEY, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.INSTANCE }, false);
    public static final org.jooq.Index ROLES_PERMISSIONS_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("roles_permissions_ak3"), com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.KEY, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.INSTANCE }, false);
    public static final org.jooq.Index SETTINGS_DB_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("settings_db_ak1"), com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.KEY, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.IS_SYSTEM, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.HIDDEN }, false);
    public static final org.jooq.Index SETTINGS_DB_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("settings_db_ak2"), com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.KEY, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.IS_DOMAIN, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.HIDDEN }, false);
    public static final org.jooq.Index SETTINGS_DB_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("settings_db_ak3"), com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.KEY, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.IS_USER, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.HIDDEN }, false);
    public static final org.jooq.Index SHARES_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("shares_ak1"), com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.USER_UID, com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.KEY, com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.INSTANCE }, true);
    public static final org.jooq.Index TAGS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("tags_ak1"), com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.USER_ID }, false);
    public static final org.jooq.Index TAGS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("tags_ak2"), com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.BUILT_IN, com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.NAME }, false);
    public static final org.jooq.Index UPGRADE_STATEMENTS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("upgrade_statements_ak1"), com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.TAG, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.SEQUENCE_NO }, false);
    public static final org.jooq.Index UPGRADE_STATEMENTS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("upgrade_statements_ak2"), com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.TAG, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.STATEMENT_TYPE, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.RUN_STATUS }, false);
    public static final org.jooq.Index USERS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("users_ak1"), com.sonicle.webtop.core.jooq.core.tables.Users.USERS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Users.USERS.USER_UID }, true);
    public static final org.jooq.Index USERS_AK3 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("users_ak3"), com.sonicle.webtop.core.jooq.core.tables.Users.USERS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Users.USERS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.TYPE, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.ENABLED }, false);
    public static final org.jooq.Index USERS_AK4 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("users_ak4"), com.sonicle.webtop.core.jooq.core.tables.Users.USERS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.Users.USERS.TYPE, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.USER_UID }, false);
    public static final org.jooq.Index USERS_ASSOCIATIONS_AK1 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("users_associations_ak1"), com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.USER_UID, com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.GROUP_UID }, true);
    public static final org.jooq.Index USERS_ASSOCIATIONS_AK2 = org.jooq.impl.Internal.createIndex(org.jooq.impl.DSL.name("users_associations_ak2"), com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS, new org.jooq.OrderField[] { com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.GROUP_UID }, false);
}
