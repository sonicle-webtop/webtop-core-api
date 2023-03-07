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

import com.sonicle.webtop.core.bol.AssignedRole;
import com.sonicle.webtop.core.bol.ORoleAssociation;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_ROLES_ASSOCIATIONS;
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.RolesAssociationsRecord;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

/**
 *
 * @author malbinola
 */
public class RoleAssociationDAO extends BaseDAO {
	private final static RoleAssociationDAO INSTANCE = new RoleAssociationDAO();
	public static RoleAssociationDAO getInstance() {
		return INSTANCE;
	}
	
	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(SEQ_ROLES_ASSOCIATIONS);
		return nextID;
	}
	
	public Set<String> viewRoleSidsBySubject(Connection con, String subjectSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				ROLES_ASSOCIATIONS.ROLE_UID
			)
			.from(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.USER_UID.equal(subjectSid)
			)
			.fetchSet(ROLES_ASSOCIATIONS.ROLE_UID);
	}
	
	public Set<String> viewSubjectSidsByRole(Connection con, String roleSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				ROLES_ASSOCIATIONS.USER_UID
			)
			.from(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.ROLE_UID.equal(roleSid)
			)
			.fetchSet(ROLES_ASSOCIATIONS.USER_UID);
	}
	
	@Deprecated
	public List<AssignedRole> viewAssignedByUser(Connection con, String userSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
					ROLES_ASSOCIATIONS.ROLE_ASSOCIATION_ID,
					ROLES_ASSOCIATIONS.ROLE_UID,
					ROLES.NAME.as("role_name")
			)
			.from(ROLES_ASSOCIATIONS)
			.leftOuterJoin(ROLES).on(
					ROLES_ASSOCIATIONS.ROLE_UID.equal(ROLES.ROLE_UID)
			)
			.where(
					ROLES_ASSOCIATIONS.USER_UID.equal(userSid)
			)
			.orderBy(
				ROLES.NAME
			)
			.fetchInto(AssignedRole.class);
	}
	
	@Deprecated
	public List<AssignedRole> viewAssignedByGroup(Connection con, String groupSid) throws DAOException {
		return viewAssignedByUser(con, groupSid);
	}
	
	@Deprecated
	public int insert(Connection con, ORoleAssociation item) throws DAOException {
		DSLContext dsl = getDSL(con);
		RolesAssociationsRecord record = dsl.newRecord(ROLES_ASSOCIATIONS, item);
		return dsl
			.insertInto(ROLES_ASSOCIATIONS)
			.set(record)
			.execute();
	}
	
	public int[] batchInsert(Connection con, String subjectSid, Collection<String> roleSids) throws DAOException {
		if (roleSids.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(ROLES_ASSOCIATIONS, 
				ROLES_ASSOCIATIONS.USER_UID, ROLES_ASSOCIATIONS.ROLE_UID
			).values((String)null, null)
		);
		for (String roleSid : roleSids) {
			batch.bind(
				subjectSid,
				roleSid
			);
		}
		return batch.execute();
	}
	
	public int[] batchInsert(Connection con, Collection<String> subjectSids, String roleSid) throws DAOException {
		if (subjectSids.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(ROLES_ASSOCIATIONS, 
				ROLES_ASSOCIATIONS.USER_UID, ROLES_ASSOCIATIONS.ROLE_UID
			).values((String)null, null)
		);
		for (String subjectSid : subjectSids) {
			batch.bind(
				roleSid,
				subjectSid
			);
		}
		return batch.execute();
	}
	
	@Deprecated
	public int deleteById(Connection con, int id) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
					ROLES_ASSOCIATIONS.ROLE_ASSOCIATION_ID.equal(id)
			)
			.execute();
	}
	
	@Deprecated
	public int deleteByUser(Connection con, String userSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
					ROLES_ASSOCIATIONS.USER_UID.equal(userSid)
			)
			.execute();
	}
	
	public int deleteBySubject(Connection con, String subjectSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.USER_UID.equal(subjectSid)
			)
			.execute();
	}
	
	public int deleteBySubjectsRoleSid(Connection con, Collection<String> subjectSids, String roleSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.USER_UID.in(subjectSids)
				.and(ROLES_ASSOCIATIONS.ROLE_UID.equal(roleSid))
			)
			.execute();
	}
	
	public int deleteBySubjectRolesSids(Connection con, String subjectSid, Collection<String> roleSids) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.USER_UID.equal(subjectSid)
				.and(ROLES_ASSOCIATIONS.ROLE_UID.in(roleSids))
			)
			.execute();
	}
	
	public int deleteByRole(Connection con, String roleSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
				ROLES_ASSOCIATIONS.ROLE_UID.equal(roleSid)
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(ROLES_ASSOCIATIONS)
			.where(
					ROLES_ASSOCIATIONS.ROLE_UID.in(
							DSL.select(
								ROLES.ROLE_UID
							)
							.from(ROLES)
							.where(
									ROLES.DOMAIN_ID.equal(domainId)
							)
					)
			)
			.execute();
	}
}
