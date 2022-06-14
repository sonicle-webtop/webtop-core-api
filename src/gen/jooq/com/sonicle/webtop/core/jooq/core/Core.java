/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Core extends org.jooq.impl.SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>core</code>
     */
    public static final Core CORE = new Core();

    /**
     * The table <code>core.access_log</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.AccessLog ACCESS_LOG = com.sonicle.webtop.core.jooq.core.tables.AccessLog.ACCESS_LOG;

    /**
     * The table <code>core.activities</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Activities ACTIVITIES = com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES;

    /**
     * The table <code>core.audit_known_devices</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices AUDIT_KNOWN_DEVICES = com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES;

    /**
     * The table <code>core.audit_log</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.AuditLog AUDIT_LOG = com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG;

    /**
     * The table <code>core.autosave</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Autosave AUTOSAVE = com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE;

    /**
     * The table <code>core.causals</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Causals CAUSALS = com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS;

    /**
     * The table <code>core.custom_fields</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.CustomFields CUSTOM_FIELDS = com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS;

    /**
     * The table <code>core.custom_panels</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.CustomPanels CUSTOM_PANELS = com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS;

    /**
     * The table <code>core.custom_panels_fields</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields CUSTOM_PANELS_FIELDS = com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS;

    /**
     * The table <code>core.custom_panels_tags</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags CUSTOM_PANELS_TAGS = com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS;

    /**
     * The table <code>core.data_sources</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.DataSources DATA_SOURCES = com.sonicle.webtop.core.jooq.core.tables.DataSources.DATA_SOURCES;

    /**
     * The table <code>core.data_sources_queries</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.DataSourcesQueries DATA_SOURCES_QUERIES = com.sonicle.webtop.core.jooq.core.tables.DataSourcesQueries.DATA_SOURCES_QUERIES;

    /**
     * The table <code>core.domain_settings</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.DomainSettings DOMAIN_SETTINGS = com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS;

    /**
     * The table <code>core.domains</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Domains DOMAINS = com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS;

    /**
     * The table <code>core.file_types</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.FileTypes FILE_TYPES = com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES;

    /**
     * The table <code>core.fn_access_log_aggr</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr FN_ACCESS_LOG_AGGR = com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr.FN_ACCESS_LOG_AGGR;

    /**
     * Call <code>core.fn_access_log_aggr</code>.
     */
    public static org.jooq.Result<com.sonicle.webtop.core.jooq.core.tables.records.FnAccessLogAggrRecord> FN_ACCESS_LOG_AGGR(
          org.jooq.Configuration configuration
        , java.lang.String domainId
        , org.joda.time.DateTime fromDate
        , org.joda.time.DateTime toDate
    ) {
        return configuration.dsl().selectFrom(com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr.FN_ACCESS_LOG_AGGR.call(
              domainId
            , fromDate
            , toDate
        )).fetch();
    }

    /**
     * Get <code>core.fn_access_log_aggr</code> as a table.
     */
    public static com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr FN_ACCESS_LOG_AGGR(
          java.lang.String domainId
        , org.joda.time.DateTime fromDate
        , org.joda.time.DateTime toDate
    ) {
        return com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr.FN_ACCESS_LOG_AGGR.call(
              domainId
            , fromDate
            , toDate
        );
    }

    /**
     * Get <code>core.fn_access_log_aggr</code> as a table.
     */
    public static com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr FN_ACCESS_LOG_AGGR(
          org.jooq.Field<java.lang.String> domainId
        , org.jooq.Field<org.joda.time.DateTime> fromDate
        , org.jooq.Field<org.joda.time.DateTime> toDate
    ) {
        return com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr.FN_ACCESS_LOG_AGGR.call(
              domainId
            , fromDate
            , toDate
        );
    }

    /**
     * The table <code>core.im_chats</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.ImChats IM_CHATS = com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS;

    /**
     * The table <code>core.im_messages</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.ImMessages IM_MESSAGES = com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES;

    /**
     * The table <code>core.ip_geo_cache</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.IpGeoCache IP_GEO_CACHE = com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE;

    /**
     * The table <code>core.languages</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Languages LANGUAGES = com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES;

    /**
     * The table <code>core.licenses</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Licenses LICENSES = com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES;

    /**
     * The table <code>core.licenses_leases</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.LicensesLeases LICENSES_LEASES = com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES;

    /**
     * The table <code>core.local_vault</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.LocalVault LOCAL_VAULT = com.sonicle.webtop.core.jooq.core.tables.LocalVault.LOCAL_VAULT;

    /**
     * The table <code>core.master_data</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.MasterData MASTER_DATA = com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA;

    /**
     * The table <code>core.media_types</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.MediaTypes MEDIA_TYPES = com.sonicle.webtop.core.jooq.core.tables.MediaTypes.MEDIA_TYPES;

    /**
     * The table <code>core.messages_queue</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.MessagesQueue MESSAGES_QUEUE = com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE;

    /**
     * The table <code>core.roles</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Roles ROLES = com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES;

    /**
     * The table <code>core.roles_associations</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.RolesAssociations ROLES_ASSOCIATIONS = com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS;

    /**
     * The table <code>core.roles_permissions</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.RolesPermissions ROLES_PERMISSIONS = com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS;

    /**
     * The table <code>core.servicestore_entries</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries SERVICESTORE_ENTRIES = com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES;

    /**
     * The table <code>core.settings</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Settings SETTINGS = com.sonicle.webtop.core.jooq.core.tables.Settings.SETTINGS;

    /**
     * The table <code>core.settings_db</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.SettingsDb SETTINGS_DB = com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB;

    /**
     * The table <code>core.shares</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Shares SHARES = com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES;

    /**
     * The table <code>core.shares_data</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.SharesData SHARES_DATA = com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA;

    /**
     * The table <code>core.snoozed_reminders</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.SnoozedReminders SNOOZED_REMINDERS = com.sonicle.webtop.core.jooq.core.tables.SnoozedReminders.SNOOZED_REMINDERS;

    /**
     * The table <code>core.syslog</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Syslog SYSLOG = com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG;

    /**
     * The table <code>core.tags</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Tags TAGS = com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS;

    /**
     * The table <code>core.upgrade_statements</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements UPGRADE_STATEMENTS = com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS;

    /**
     * The table <code>core.user_settings</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.UserSettings USER_SETTINGS = com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS;

    /**
     * The table <code>core.users</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.Users USERS = com.sonicle.webtop.core.jooq.core.tables.Users.USERS;

    /**
     * The table <code>core.users_associations</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.UsersAssociations USERS_ASSOCIATIONS = com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS;

    /**
     * The table <code>core.users_info</code>.
     */
    public final com.sonicle.webtop.core.jooq.core.tables.UsersInfo USERS_INFO = com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO;

    /**
     * No further instances allowed
     */
    private Core() {
        super("core", null);
    }


    @java.lang.Override
    public org.jooq.Catalog getCatalog() {
        return com.sonicle.webtop.core.jooq.DefaultCatalog.DEFAULT_CATALOG;
    }

    @java.lang.Override
    public final java.util.List<org.jooq.Sequence<?>> getSequences() {
        return java.util.Arrays.<org.jooq.Sequence<?>>asList(
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ACCESS_LOG,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ACTIVITIES,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_AUDIT_KNOWN_DEVICES,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_AUDIT_LOG,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_CAUSALS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_IM_CHATS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_IM_MESSAGES,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_MESSAGES_QUEUE,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ROLES_ASSOCIATIONS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ROLES_PERMISSIONS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_SHARES,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_SNOOZED_REMINDERS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_SYSLOG,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_UPGRADE_STATEMENTS,
            com.sonicle.webtop.core.jooq.core.Sequences.SEQ_USERS_ASSOCIATIONS);
    }

    @java.lang.Override
    public final java.util.List<org.jooq.Table<?>> getTables() {
        return java.util.Arrays.<org.jooq.Table<?>>asList(
            com.sonicle.webtop.core.jooq.core.tables.AccessLog.ACCESS_LOG,
            com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES,
            com.sonicle.webtop.core.jooq.core.tables.AuditKnownDevices.AUDIT_KNOWN_DEVICES,
            com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG,
            com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE,
            com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS,
            com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS,
            com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS,
            com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS,
            com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS,
            com.sonicle.webtop.core.jooq.core.tables.DataSources.DATA_SOURCES,
            com.sonicle.webtop.core.jooq.core.tables.DataSourcesQueries.DATA_SOURCES_QUERIES,
            com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS,
            com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS,
            com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES,
            com.sonicle.webtop.core.jooq.core.tables.FnAccessLogAggr.FN_ACCESS_LOG_AGGR,
            com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS,
            com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES,
            com.sonicle.webtop.core.jooq.core.tables.IpGeoCache.IP_GEO_CACHE,
            com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES,
            com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES,
            com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES,
            com.sonicle.webtop.core.jooq.core.tables.LocalVault.LOCAL_VAULT,
            com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA,
            com.sonicle.webtop.core.jooq.core.tables.MediaTypes.MEDIA_TYPES,
            com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE,
            com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES,
            com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS,
            com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS,
            com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES,
            com.sonicle.webtop.core.jooq.core.tables.Settings.SETTINGS,
            com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB,
            com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES,
            com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA,
            com.sonicle.webtop.core.jooq.core.tables.SnoozedReminders.SNOOZED_REMINDERS,
            com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG,
            com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS,
            com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS,
            com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS,
            com.sonicle.webtop.core.jooq.core.tables.Users.USERS,
            com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS,
            com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO);
    }
}
