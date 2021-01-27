/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.core;

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
public class Core extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -867040409;

	/**
	 * The reference instance of <code>core</code>
	 */
	public static final Core CORE = new Core();

	/**
	 * No further instances allowed
	 */
	private Core() {
		super("core");
	}

	@Override
	public final java.util.List<org.jooq.Sequence<?>> getSequences() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final java.util.List<org.jooq.Sequence<?>> getSequences0() {
		return java.util.Arrays.<org.jooq.Sequence<?>>asList(
			com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ACTIVITIES,
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

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.sonicle.webtop.core.jooq.core.tables.Activities.ACTIVITIES,
			com.sonicle.webtop.core.jooq.core.tables.AuditLog.AUDIT_LOG,
			com.sonicle.webtop.core.jooq.core.tables.Autosave.AUTOSAVE,
			com.sonicle.webtop.core.jooq.core.tables.Causals.CAUSALS,
			com.sonicle.webtop.core.jooq.core.tables.CustomFields.CUSTOM_FIELDS,
			com.sonicle.webtop.core.jooq.core.tables.CustomPanels.CUSTOM_PANELS,
			com.sonicle.webtop.core.jooq.core.tables.CustomPanelsFields.CUSTOM_PANELS_FIELDS,
			com.sonicle.webtop.core.jooq.core.tables.CustomPanelsTags.CUSTOM_PANELS_TAGS,
			com.sonicle.webtop.core.jooq.core.tables.DomainSettings.DOMAIN_SETTINGS,
			com.sonicle.webtop.core.jooq.core.tables.Domains.DOMAINS,
			com.sonicle.webtop.core.jooq.core.tables.FileTypes.FILE_TYPES,
			com.sonicle.webtop.core.jooq.core.tables.ImChats.IM_CHATS,
			com.sonicle.webtop.core.jooq.core.tables.ImMessages.IM_MESSAGES,
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
			com.sonicle.webtop.core.jooq.core.tables.UsersInfo.USERS_INFO,
			com.sonicle.webtop.core.jooq.core.tables.VwAccessLog.VW_ACCESS_LOG,
			com.sonicle.webtop.core.jooq.core.tables.VwAuthDetails.VW_AUTH_DETAILS);
	}
}
