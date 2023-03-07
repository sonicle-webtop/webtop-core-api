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

import com.sonicle.webtop.core.bol.OUserAssociation;
import com.sonicle.webtop.core.bol.AssignedGroup;
import com.sonicle.webtop.core.bol.AssignedUser;
import com.sonicle.webtop.core.bol.OUser;
import static com.sonicle.webtop.core.jooq.core.Sequences.SEQ_USERS_ASSOCIATIONS;
import static com.sonicle.webtop.core.jooq.core.Tables.*;
import com.sonicle.webtop.core.jooq.core.tables.records.UsersAssociationsRecord;
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
public class UserAssociationDAO extends BaseDAO {
	private final static UserAssociationDAO INSTANCE = new UserAssociationDAO();
	public static UserAssociationDAO getInstance() {
		return INSTANCE;
	}
	
	public Long getSequence(Connection con) throws DAOException {
		DSLContext dsl = getDSL(con);
		Long nextID = dsl.nextval(SEQ_USERS_ASSOCIATIONS);
		return nextID;
	}
	
	public Set<String> viewGroupSidsByUser(Connection con, String userSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				USERS_ASSOCIATIONS.GROUP_UID
			)
			.from(USERS_ASSOCIATIONS)
			.where(
				USERS_ASSOCIATIONS.USER_UID.equal(userSid)
			)
			.fetchSet(USERS_ASSOCIATIONS.GROUP_UID);
	}
	
	public Set<String> viewUserSidsByGroup(Connection con, String groupSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				USERS_ASSOCIATIONS.USER_UID
			)
			.from(USERS_ASSOCIATIONS)
			.where(
				USERS_ASSOCIATIONS.GROUP_UID.equal(groupSid)
			)
			.fetchSet(USERS_ASSOCIATIONS.USER_UID);
	}
	
	@Deprecated
	public List<AssignedGroup> viewAssignedByUser(Connection con, String userSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
					USERS_ASSOCIATIONS.USER_ASSOCIATION_ID,
					USERS_ASSOCIATIONS.GROUP_UID,
					USERS.USER_ID.as("group_id")
			)
			.from(USERS_ASSOCIATIONS)
			.leftOuterJoin(USERS).on(
					USERS_ASSOCIATIONS.GROUP_UID.equal(USERS.USER_UID)
			)
			.where(
					USERS_ASSOCIATIONS.USER_UID.equal(userSid)
			)
			.orderBy(
				USERS.USER_ID
			)
			.fetchInto(AssignedGroup.class);
	}
	
	@Deprecated
	public List<AssignedUser> viewAssignedByGroup(Connection con, String groupSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
					USERS_ASSOCIATIONS.USER_ASSOCIATION_ID,
					USERS_ASSOCIATIONS.USER_UID,
					USERS.USER_ID.as("user_id")
			)
			.from(USERS_ASSOCIATIONS)
			.leftOuterJoin(USERS).on(
					USERS_ASSOCIATIONS.USER_UID.equal(USERS.USER_UID)
			)
			.where(
					USERS_ASSOCIATIONS.GROUP_UID.equal(groupSid)
			)
			.orderBy(
				USERS.USER_ID
			)
			.fetchInto(AssignedUser.class);
	}
	
	@Deprecated
	public int insert(Connection con, OUserAssociation item) throws DAOException {
		DSLContext dsl = getDSL(con);
		UsersAssociationsRecord record = dsl.newRecord(USERS_ASSOCIATIONS, item);
		return dsl
			.insertInto(USERS_ASSOCIATIONS)
			.set(record)
			.execute();
	}
	
	public int[] batchInsert(Connection con, String userSid, Collection<String> groupSids) throws DAOException {
		if (groupSids.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(USERS_ASSOCIATIONS, 
				USERS_ASSOCIATIONS.USER_UID, USERS_ASSOCIATIONS.GROUP_UID
			).values((String)null, null)
		);
		for (String groupSid : groupSids) {
			batch.bind(
				userSid,
				groupSid
			);
		}
		return batch.execute();
	}
	
	public int[] batchInsert(Connection con, Collection<String> userSids, String groupSid) throws DAOException {
		if (userSids.isEmpty()) return new int[0];
		DSLContext dsl = getDSL(con);
		BatchBindStep batch = dsl.batch(
			dsl.insertInto(USERS_ASSOCIATIONS, 
				USERS_ASSOCIATIONS.USER_UID, USERS_ASSOCIATIONS.GROUP_UID
			).values((String)null, null)
		);
		for (String userSid : userSids) {
			batch.bind(
				userSid,
				groupSid
			);
		}
		return batch.execute();
	}
	
	@Deprecated
	public int deleteById(Connection con, int id) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
					USERS_ASSOCIATIONS.USER_ASSOCIATION_ID.equal(id)
			)
			.execute();
	}
	
	public int deleteByUserGroups(Connection con, String userSid, Collection<String> groupSids) throws DAOException {
		if (groupSids.isEmpty()) return -1;
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
				USERS_ASSOCIATIONS.USER_UID.equal(userSid)
				.and(USERS_ASSOCIATIONS.GROUP_UID.in(groupSids))
			)
			.execute();
	}
	
	public int deleteByGroupUsers(Connection con, String groupSid, Collection<String> userSids) throws DAOException {
		if (userSids.isEmpty()) return -1;
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
				USERS_ASSOCIATIONS.GROUP_UID.equal(groupSid)
				.and(USERS_ASSOCIATIONS.USER_UID.in(userSids))
			)
			.execute();
	}
	
	public int deleteByUser(Connection con, String userSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
				USERS_ASSOCIATIONS.USER_UID.equal(userSid)
			)
			.execute();
	}
	
	public int deleteByGroup(Connection con, String groupSid) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
					USERS_ASSOCIATIONS.GROUP_UID.equal(groupSid)
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(USERS_ASSOCIATIONS)
			.where(
					USERS_ASSOCIATIONS.USER_UID.in(
							DSL.select(
								USERS.USER_UID
							)
							.from(USERS)
							.where(
									USERS.DOMAIN_ID.equal(domainId)
									.and(USERS.TYPE.equal(OUser.TYPE_USER))
							)
					)
			)
			.execute();
	}
}
