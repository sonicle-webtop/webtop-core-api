/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core;

/**
 * A class modelling foreign key relationships between tables of the <code>core</code> 
 * schema
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ActivitiesRecord, java.lang.Integer> IDENTITY_ACTIVITIES = Identities0.IDENTITY_ACTIVITIES;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.Long> IDENTITY_AUDIT_LOG = Identities0.IDENTITY_AUDIT_LOG;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.CausalsRecord, java.lang.Integer> IDENTITY_CAUSALS = Identities0.IDENTITY_CAUSALS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.Integer> IDENTITY_IM_CHATS = Identities0.IDENTITY_IM_CHATS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.Integer> IDENTITY_IM_MESSAGES = Identities0.IDENTITY_IM_MESSAGES;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.MessagesQueueRecord, java.lang.Integer> IDENTITY_MESSAGES_QUEUE = Identities0.IDENTITY_MESSAGES_QUEUE;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.Integer> IDENTITY_ROLES_ASSOCIATIONS = Identities0.IDENTITY_ROLES_ASSOCIATIONS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.RolesPermissionsRecord, java.lang.Integer> IDENTITY_ROLES_PERMISSIONS = Identities0.IDENTITY_ROLES_PERMISSIONS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SharesRecord, java.lang.Integer> IDENTITY_SHARES = Identities0.IDENTITY_SHARES;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SnoozedRemindersRecord, java.lang.Integer> IDENTITY_SNOOZED_REMINDERS = Identities0.IDENTITY_SNOOZED_REMINDERS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SyslogRecord, java.lang.Long> IDENTITY_SYSLOG = Identities0.IDENTITY_SYSLOG;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.UpgradeStatementsRecord, java.lang.Integer> IDENTITY_UPGRADE_STATEMENTS = Identities0.IDENTITY_UPGRADE_STATEMENTS;
	public static final org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.Integer> IDENTITY_USERS_ASSOCIATIONS = Identities0.IDENTITY_USERS_ASSOCIATIONS;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ActivitiesRecord> ACTIVITIES_PKEY = UniqueKeys0.ACTIVITIES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> AUDIT_LOG_PKEY = UniqueKeys0.AUDIT_LOG_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AutosaveRecord> AUTOSAVE_PKEY = UniqueKeys0.AUTOSAVE_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CausalsRecord> CAUSALS_PKEY = UniqueKeys0.CAUSALS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> CUSTOM_FIELDS_PKEY = UniqueKeys0.CUSTOM_FIELDS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_PKEY = UniqueKeys0.CUSTOM_PANELS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> CUSTOM_PANELS_FIELDS_PKEY = UniqueKeys0.CUSTOM_PANELS_FIELDS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord> CUSTOM_PANELS_TAGS_PKEY = UniqueKeys0.CUSTOM_PANELS_TAGS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> CUSTOMERS_PKEY = UniqueKeys0.CUSTOMERS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.DomainSettingsRecord> DOMAIN_SETTINGS_PKEY = UniqueKeys0.DOMAIN_SETTINGS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.DomainsRecord> DOMAINS_PKEY = UniqueKeys0.DOMAINS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.FileTypesRecord> FILE_TYPES_PKEY = UniqueKeys0.FILE_TYPES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> IM_HISTORY_CHATS_2_PKEY = UniqueKeys0.IM_HISTORY_CHATS_2_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> IM_HISTORY_MESSAGES_PKEY = UniqueKeys0.IM_HISTORY_MESSAGES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LanguagesRecord> LANGUAGES_PKEY = UniqueKeys0.LANGUAGES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord> LICENSES_PKEY = UniqueKeys0.LICENSES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> LICENSES_LEASES_PKEY = UniqueKeys0.LICENSES_LEASES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LocalVaultRecord> LOCAL_VAULT_PKEY = UniqueKeys0.LOCAL_VAULT_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MasterDataRecord> MASTER_DATA_PKEY = UniqueKeys0.MASTER_DATA_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MediaTypesRecord> MEDIA_TYPES_PKEY = UniqueKeys0.MEDIA_TYPES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MessagesQueueRecord> MESSAGES_QUEUE_PKEY = UniqueKeys0.MESSAGES_QUEUE_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesRecord> ROLES_PKEY = UniqueKeys0.ROLES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> ROLES_ASSOCIATIONS_PKEY = UniqueKeys0.ROLES_ASSOCIATIONS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> SERVICESTORE_ENTRIES_PKEY = UniqueKeys0.SERVICESTORE_ENTRIES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsRecord> SETTINGS_PKEY = UniqueKeys0.SETTINGS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> SETTINGS_DB_PKEY = UniqueKeys0.SETTINGS_DB_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesRecord> SHARES_PKEY = UniqueKeys0.SHARES_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> SHARES_DATA_PKEY = UniqueKeys0.SHARES_DATA_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SyslogRecord> SYSLOG_PKEY = UniqueKeys0.SYSLOG_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord> TAGS_PKEY = UniqueKeys0.TAGS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UpgradeStatementsRecord> UPGRADE_STATEMENTS_PKEY = UniqueKeys0.UPGRADE_STATEMENTS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> USER_SETTINGS_PKEY = UniqueKeys0.USER_SETTINGS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersRecord> USERS_PKEY = UniqueKeys0.USERS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> USERS_ASSOCIATIONS_PKEY = UniqueKeys0.USERS_ASSOCIATIONS_PKEY;
	public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> USERS_INFO_PKEY = UniqueKeys0.USERS_INFO_PKEY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY = ForeignKeys0.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY;
	public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY = ForeignKeys0.CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY;
	public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_CUSTOM_PANEL_ID_FKEY = ForeignKeys0.CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_CUSTOM_PANEL_ID_FKEY;
	public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord, com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord> CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_TAG_ID_FKEY = ForeignKeys0.CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_TAG_ID_FKEY;
	public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord> LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_FKEY = ForeignKeys0.LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_FKEY;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ActivitiesRecord, java.lang.Integer> IDENTITY_ACTIVITIES = createIdentity(com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES, com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.ACTIVITY_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord, java.lang.Long> IDENTITY_AUDIT_LOG = createIdentity(com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.AUDIT_LOG_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.CausalsRecord, java.lang.Integer> IDENTITY_CAUSALS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.CAUSAL_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord, java.lang.Integer> IDENTITY_IM_CHATS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord, java.lang.Integer> IDENTITY_IM_MESSAGES = createIdentity(com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.MessagesQueueRecord, java.lang.Integer> IDENTITY_MESSAGES_QUEUE = createIdentity(com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE, com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE.QUEUE_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord, java.lang.Integer> IDENTITY_ROLES_ASSOCIATIONS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS, com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS.ROLE_ASSOCIATION_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.RolesPermissionsRecord, java.lang.Integer> IDENTITY_ROLES_PERMISSIONS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS, com.sonicle.webtop.core.jooq.core.tables.RolesPermissions.ROLES_PERMISSIONS.ROLE_PERMISSION_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SharesRecord, java.lang.Integer> IDENTITY_SHARES = createIdentity(com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES, com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.SHARE_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SnoozedRemindersRecord, java.lang.Integer> IDENTITY_SNOOZED_REMINDERS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.SnoozedReminders.SNOOZED_REMINDERS, com.sonicle.webtop.core.jooq.core.tables.SnoozedReminders.SNOOZED_REMINDERS.SNOOZED_REMINDER_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.SyslogRecord, java.lang.Long> IDENTITY_SYSLOG = createIdentity(com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG, com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG.SYSLOG_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.UpgradeStatementsRecord, java.lang.Integer> IDENTITY_UPGRADE_STATEMENTS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.UPGRADE_STATEMENT_ID);
		public static org.jooq.Identity<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord, java.lang.Integer> IDENTITY_USERS_ASSOCIATIONS = createIdentity(com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS, com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.USER_ASSOCIATION_ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ActivitiesRecord> ACTIVITIES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES, com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES.ACTIVITY_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AuditLogRecord> AUDIT_LOG_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG, com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG.AUDIT_LOG_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.AutosaveRecord> AUTOSAVE_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.USER_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.WEBTOP_CLIENT_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.CONTEXT, com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CausalsRecord> CAUSALS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS, com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS.CAUSAL_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> CUSTOM_FIELDS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS, com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS.CUSTOM_FIELD_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS, com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS.CUSTOM_PANEL_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord> CUSTOM_PANELS_FIELDS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord> CUSTOM_PANELS_TAGS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS.TAG_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomersDeprecatedRecord> CUSTOMERS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.CustomersDeprecated.CUSTOMERS_DEPRECATED, com.sonicle.webtop.core.jooq.core.tables.CustomersDeprecated.CUSTOMERS_DEPRECATED.CUSTOMER_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.DomainSettingsRecord> DOMAIN_SETTINGS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS, com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.DomainsRecord> DOMAINS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS, com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS.DOMAIN_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.FileTypesRecord> FILE_TYPES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES, com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES.EXTENSION, com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES.TYPE, com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES.SUBTYPE);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImChatsRecord> IM_HISTORY_CHATS_2_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS, com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS.ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ImMessagesRecord> IM_HISTORY_MESSAGES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES, com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES.ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LanguagesRecord> LANGUAGES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES, com.sonicle.webtop.core.jooq.core.tables.Languages.LANGUAGES.LANGUAGE_TAG);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord> LICENSES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES, com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.Licenses.LICENSES.PRODUCT_CODE);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord> LICENSES_LEASES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.PRODUCT_CODE, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.USER_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.LocalVaultRecord> LOCAL_VAULT_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.LocalVault.LOCAL_VAULT, com.sonicle.webtop.core.jooq.core.tables.LocalVault.LOCAL_VAULT.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.LocalVault.LOCAL_VAULT.USER_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MasterDataRecord> MASTER_DATA_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.MasterData.MASTER_DATA.MASTER_DATA_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MediaTypesRecord> MEDIA_TYPES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.MediaTypes.MEDIA_TYPES, com.sonicle.webtop.core.jooq.core.tables.MediaTypes.MEDIA_TYPES.EXTENSION, com.sonicle.webtop.core.jooq.core.tables.MediaTypes.MEDIA_TYPES.MEDIA_TYPE);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.MessagesQueueRecord> MESSAGES_QUEUE_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE, com.sonicle.webtop.core.jooq.core.tables.MessagesQueue.MESSAGES_QUEUE.QUEUE_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesRecord> ROLES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES, com.sonicle.webtop.core.jooq.core.tables.Roles.ROLES.ROLE_UID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord> ROLES_ASSOCIATIONS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS, com.sonicle.webtop.core.jooq.core.tables.RolesAssociations.ROLES_ASSOCIATIONS.ROLE_ASSOCIATION_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.ServicestoreEntriesRecord> SERVICESTORE_ENTRIES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES, com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES.USER_ID, com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES.CONTEXT, com.sonicle.webtop.core.jooq.core.tables.ServicestoreEntries.SERVICESTORE_ENTRIES.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsRecord> SETTINGS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Settings.SETTINGS, com.sonicle.webtop.core.jooq.core.tables.Settings.SETTINGS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.Settings.SETTINGS.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SettingsDbRecord> SETTINGS_DB_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.SettingsDb.SETTINGS_DB.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesRecord> SHARES_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES, com.sonicle.webtop.core.jooq.core.tables.Shares.SHARES.SHARE_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SharesDataRecord> SHARES_DATA_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA, com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA.SHARE_ID, com.sonicle.webtop.core.jooq.core.tables.SharesData.SHARES_DATA.USER_UID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.SyslogRecord> SYSLOG_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG, com.sonicle.webtop.core.jooq.core.tables.Syslog.SYSLOG.SYSLOG_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord> TAGS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS, com.sonicle.webtop.core.jooq.core.tables.Tags.TAGS.TAG_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UpgradeStatementsRecord> UPGRADE_STATEMENTS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS, com.sonicle.webtop.core.jooq.core.tables.UpgradeStatements.UPGRADE_STATEMENTS.UPGRADE_STATEMENT_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UserSettingsRecord> USER_SETTINGS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS, com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.USER_ID, com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.UserSettings.USER_SETTINGS.KEY);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersRecord> USERS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.Users.USERS, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.USER_ID, com.sonicle.webtop.core.jooq.core.tables.Users.USERS.TYPE);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord> USERS_ASSOCIATIONS_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS, com.sonicle.webtop.core.jooq.core.tables.UsersAssociations.USERS_ASSOCIATIONS.USER_ASSOCIATION_ID);
		public static final org.jooq.UniqueKey<com.sonicle.webtop.core.jooq.core.tables.records.UsersInfoRecord> USERS_INFO_PKEY = createUniqueKey(com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO, com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO.USER_ID);
	}

	private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_PANEL_ID_FKEY = createForeignKey(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_PKEY, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_PANEL_ID);
		public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsFieldsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomFieldsRecord> CUSTOM_PANELS_FIELDS__CUSTOM_PANELS_FIELDS_CUSTOM_FIELD_ID_FKEY = createForeignKey(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_FIELDS_PKEY, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS.CUSTOM_FIELD_ID);
		public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord, com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsRecord> CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_CUSTOM_PANEL_ID_FKEY = createForeignKey(com.sonicle.webtop.core.jooq.core.Keys.CUSTOM_PANELS_PKEY, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS.CUSTOM_PANEL_ID);
		public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.CustomPanelsTagsRecord, com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord> CUSTOM_PANELS_TAGS__CUSTOM_PANELS_TAGS_TAG_ID_FKEY = createForeignKey(com.sonicle.webtop.core.jooq.core.Keys.TAGS_PKEY, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS, com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS.TAG_ID);
		public static final org.jooq.ForeignKey<com.sonicle.webtop.core.jooq.core.tables.records.LicensesLeasesRecord, com.sonicle.webtop.core.jooq.core.tables.records.LicensesRecord> LICENSES_LEASES__LICENSES_LEASES_DOMAIN_ID_FKEY = createForeignKey(com.sonicle.webtop.core.jooq.core.Keys.LICENSES_PKEY, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.DOMAIN_ID, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.SERVICE_ID, com.sonicle.webtop.core.jooq.core.tables.LicensesLeases.LICENSES_LEASES.PRODUCT_CODE);
	}
}
