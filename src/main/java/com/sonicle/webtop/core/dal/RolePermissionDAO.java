/*
 * webtop-core-db is a library developed by Sonicle S.r.l.
 * Copyright (C) 2014 Sonicle S.r.l.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License version 3 as published by
 * the Free Software Foundation with the addition of the following permission
 * added to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED
 * WORK IN WHICH THE COPYRIGHT IS OWNED BY SONICLE, SONICLE DISCLAIMS THE
 * WARRANTY OF NON INFRINGEMENT OF THIRD PARTY RIGHTS.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle@sonicle.com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2014 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.webtop.core.app.model.ServicePermissionString;
import com.sonicle.webtop.core.bol.ORolePermission;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ROLES_PERMISSIONS;
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.RolesPermissionsRecord;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jooq.BatchBindStep;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class RolePermissionDAO extends BaseDAO {
	private final static RolePermissionDAO INSTANCE = new RolePermissionDAO();
	public static RolePermissionDAO getInstance() {
		return INSTANCE;
	}
	
	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(SEQ_ROLES_PERMISSIONS);
		return nextID;
	}
	
	public List<ORolePermission> selectByRoleSid(Connection con, String roleSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.equal(roleSid)
			)
			.orderBy(
					ROLES_PERMISSIONS.SERVICE_ID,
					ROLES_PERMISSIONS.KEY,
					ROLES_PERMISSIONS.ACTION,
					ROLES_PERMISSIONS.INSTANCE
			)
			.fetchInto(ORolePermission.class);
	}
	
	public static Condition createServicePermissionAndKeysExcludeCondition(Collection<String> likeKeys) {
		Condition notLikeCond = DSL.noCondition();
		for (String like : likeKeys) {
			notLikeCond = notLikeCond.or(ROLES_PERMISSIONS.KEY.like(like));
		}
		return DSL.not(
			DSL.or(
				ROLES_PERMISSIONS.SERVICE_ID.equal(ServicePermissionString.SERVICE)
				.and(ROLES_PERMISSIONS.KEY.equal(ServicePermissionString.CONTEXT)),
				notLikeCond
			)
		);	
	}
	
	public static Condition createServicePermissionAndShareExcludeCondition(String folderPermissionKeyLike, String itemsPermissionKeyLike) {
		return DSL.not(
			DSL.or(
				ROLES_PERMISSIONS.SERVICE_ID.equal(ServicePermissionString.SERVICE)
				.and(ROLES_PERMISSIONS.KEY.equal(ServicePermissionString.CONTEXT)),
				ROLES_PERMISSIONS.KEY.notLike(folderPermissionKeyLike)
				.and(ROLES_PERMISSIONS.KEY.notLike(itemsPermissionKeyLike))
			)
		);
	}
	
	public static Condition createServicePermissionOnlyCondition() {
		return DSL.and(
			ROLES_PERMISSIONS.SERVICE_ID.equal(ServicePermissionString.SERVICE),
			ROLES_PERMISSIONS.KEY.equal(ServicePermissionString.CONTEXT),
			ROLES_PERMISSIONS.ACTION.equal(ServicePermissionString.ACTION_ACCESS)
		);
	}
	
	public Map<Integer, ORolePermission> viewSubjectEntriesBySubjectCondition(Connection con, String subjectSid, Condition condition) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				ROLES_PERMISSIONS.ROLE_PERMISSION_ID,
				ROLES_PERMISSIONS.SERVICE_ID,
				ROLES_PERMISSIONS.KEY,
				ROLES_PERMISSIONS.ACTION,
				ROLES_PERMISSIONS.INSTANCE
			)
			.from(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.ROLE_UID.equal(subjectSid)
				.and(condition)
			)
			.orderBy(
				ROLES_PERMISSIONS.SERVICE_ID,
				ROLES_PERMISSIONS.KEY,
				ROLES_PERMISSIONS.ACTION,
				ROLES_PERMISSIONS.INSTANCE
			)
			.fetchMap(ROLES_PERMISSIONS.ROLE_PERMISSION_ID, ORolePermission.class);
	}
	
	public List<ORolePermission> selectByRoleIn(Connection con, Collection<String> roleSids) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.in(roleSids)
			)
			.orderBy(
					ROLES_PERMISSIONS.SERVICE_ID,
					ROLES_PERMISSIONS.KEY,
					ROLES_PERMISSIONS.ACTION,
					ROLES_PERMISSIONS.INSTANCE
			)
			.fetchInto(ORolePermission.class);
	}
	
	public List<ORolePermission> selectByRoleServiceKeyInstance(Connection con, String roleSid, String serviceId, String key, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.equal(roleSid)
					.and(ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId))
					.and(ROLES_PERMISSIONS.KEY.equal(key))
					.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.fetchInto(ORolePermission.class);
	}
	
	public Map<String, List<ORolePermission>> mapByServiceKeysInstanceRoles(Connection con, String serviceId, Collection<String> keys, String instance, Collection<String> roleSids) throws DAOException {
		DSLContext dsl = getDSL(con);
		
		Condition rolesInCndt = DSL.trueCondition();
		if (roleSids != null) {
			rolesInCndt = ROLES_PERMISSIONS.ROLE_UID.in(roleSids);
		}
		
		return dsl
			.select()
			.from(ROLES_PERMISSIONS)
			.where(
				rolesInCndt
				.and(ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId))
				.and(ROLES_PERMISSIONS.KEY.in(keys))
				.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.fetchGroups(ROLES_PERMISSIONS.ROLE_UID, ORolePermission.class);
	}
	
	public Set<String> selectSubjectsByServiceKeysInstance(Connection con, String serviceId, Collection<String> keys, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectDistinct(
				ROLES_PERMISSIONS.ROLE_UID
			)
			.from(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId)
				.and(ROLES_PERMISSIONS.KEY.in(keys))
				.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.fetchSet(ROLES_PERMISSIONS.ROLE_UID);
	}
	
	@Deprecated
	public List<String> selectRolesByServiceKeyInstance(Connection con, String serviceId, String key, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.selectDistinct(
					ROLES_PERMISSIONS.ROLE_UID
			)
			.from(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId)
					.and(ROLES_PERMISSIONS.KEY.equal(key))
					.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.fetchInto(String.class);
	}
	
	public int[] batchInsertOfSubject(Connection con, String subjectId, Collection<SubjectEntry> entries) throws DAOException {
		if (entries.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(ROLES_PERMISSIONS, 
				ROLES_PERMISSIONS.ROLE_UID, 
				ROLES_PERMISSIONS.SERVICE_ID,
				ROLES_PERMISSIONS.KEY,
				ROLES_PERMISSIONS.ACTION,
				ROLES_PERMISSIONS.INSTANCE
			)
			.values((String)null, null, null, null, null)
		);
		for (SubjectEntry entry : entries) {
			batch.bind(
				subjectId,
				entry.serviceId,
				entry.context,
				entry.action,
				entry.instance
			);
		}
		return batch.execute();
	}
	
	public int[] batchInsertOfService(Connection con, String serviceId, Collection<ServiceEntry> entries) throws DAOException {
		if (entries.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(ROLES_PERMISSIONS, 
				ROLES_PERMISSIONS.ROLE_UID, 
				ROLES_PERMISSIONS.SERVICE_ID,
				ROLES_PERMISSIONS.KEY,
				ROLES_PERMISSIONS.ACTION,
				ROLES_PERMISSIONS.INSTANCE
			)
			.values((String)null, null, null, null, null)
		);
		for (ServiceEntry entry : entries) {
			batch.bind(
				entry.subjectSid,
				serviceId,
				entry.context,
				entry.action,
				entry.instance
			);
		}
		return batch.execute();
	}
	
	public int insert(Connection con, ORolePermission item) throws DAOException {
		DSLContext dsl = getDSL(con);
		RolesPermissionsRecord record = dsl.newRecord(ROLES_PERMISSIONS, item);
		return dsl
			.insertInto(ROLES_PERMISSIONS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, ORolePermission item) throws DAOException {
		DSLContext dsl = getDSL(con);
		RolesPermissionsRecord record = dsl.newRecord(ROLES_PERMISSIONS, item);
		return dsl
			.update(ROLES_PERMISSIONS)
			.set(record)
			.where(
					ROLES_PERMISSIONS.ROLE_PERMISSION_ID.equal(item.getRolePermissionId())
			)
			.execute();
	}
	
	public int deleteByIds(Connection con, Collection<Integer> ids) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.ROLE_PERMISSION_ID.in(ids)
			)
			.execute();
	}
	
	public int deleteBySubject(Connection con, String subjectSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.ROLE_UID.equal(subjectSid)
			)
			.execute();
	}
	
	@Deprecated
	public int deleteById(Connection con, int id) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_PERMISSION_ID.equal(id)
			)
			.execute();
	}
	
	@Deprecated
	public int deleteByRole(Connection con, String roleSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.equal(roleSid)
			)
			.execute();
	}
	
	public int deleteByServiceKeyInstance(Connection con, String serviceId, String key, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId)
					.and(ROLES_PERMISSIONS.KEY.equal(key))
					.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.execute();
	}
	
	public int deleteByServiceKeysInstance(Connection con, String serviceId, Collection<String> keys, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId)
				.and(ROLES_PERMISSIONS.KEY.in(keys))
				.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.execute();
	}
	
	public int deleteByServiceKeysInstances(Connection con, String serviceId, Collection<String> keys, Collection<String> instances) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
				ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId)
				.and(ROLES_PERMISSIONS.KEY.in(keys))
				.and(ROLES_PERMISSIONS.INSTANCE.in(instances))
			)
			.execute();
	}
	
	public int deleteByRoleServiceKeyActionInstance(Connection con, String roleSid, String serviceId, String key, String action, String instance) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.equal(roleSid)
					.and(ROLES_PERMISSIONS.SERVICE_ID.equal(serviceId))
					.and(ROLES_PERMISSIONS.KEY.equal(key))
					.and(ROLES_PERMISSIONS.ACTION.equal(action))
					.and(ROLES_PERMISSIONS.INSTANCE.equal(instance))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_PERMISSIONS)
			.where(
					ROLES_PERMISSIONS.ROLE_UID.in(
							DSL.select(
								ROLES.ROLE_UID
							)
							.from(ROLES)
							.where(
									ROLES.DOMAIN_ID.equal(domainId)
							)
					).or(ROLES_PERMISSIONS.ROLE_UID.in(
							DSL.select(
								USERS.USER_UID
							)
							.from(USERS)
							.where(
									USERS.DOMAIN_ID.equal(domainId)
							)
					))
			)
			.execute();
	}
	
	public static class SubjectEntry {
		public String serviceId;
		public String context;
		public String action;
		public String instance;
		
		public SubjectEntry() {}
		
		public SubjectEntry(String serviceId, String context, String action, String instance) {
			this.serviceId = serviceId;
			this.context = context;
			this.action = action;
			this.instance = instance;
		}
		
		public void setServiceId(String serviceId) {
			this.serviceId = serviceId;
		}

		public void setKey(String key) {
			this.context = key;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public void setInstance(String instance) {
			this.instance = instance;
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(serviceId)
				.append(context)
				.append(action)
				.append(instance)
				.toHashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SubjectEntry == false) return false;
			if (this == obj) return true;
			final SubjectEntry otherObject = (SubjectEntry)obj;
			return new EqualsBuilder()
				.append(serviceId, otherObject.serviceId)
				.append(context, otherObject.context)
				.append(action, otherObject.action)
				.append(instance, otherObject.instance)
				.isEquals();
		}
	}
	
	public static class ServiceEntry {
		public final String subjectSid;
		public final String context;
		public final String action;
		public final String instance;
		
		public ServiceEntry(String subjectSid, String context, String action, String instance) {
			this.subjectSid = subjectSid;
			this.context = context;
			this.action = action;
			this.instance = instance;
		}
		
		@Override
		public int hashCode() {
			return new HashCodeBuilder()
				.append(subjectSid)
				.append(context)
				.append(action)
				.append(instance)
				.toHashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ServiceEntry == false) return false;
			if (this == obj) return true;
			final ServiceEntry otherObject = (ServiceEntry)obj;
			return new EqualsBuilder()
				.append(subjectSid, otherObject.subjectSid)
				.append(context, otherObject.context)
				.append(action, otherObject.action)
				.append(instance, otherObject.instance)
				.isEquals();
		}
	}
}
