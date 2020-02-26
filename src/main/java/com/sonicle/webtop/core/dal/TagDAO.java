/*
 * Copyright (C) 2020 Sonicle S.r.l.
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
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle[at]sonicle[dot]com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance with Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2020 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.dal;

import com.sonicle.commons.IdentifierUtils;
import com.sonicle.webtop.core.bol.OTag;
import static com.sonicle.webtop.core.jooq.core.Tables.TAGS;
import com.sonicle.webtop.core.jooq.core.tables.records.TagsRecord;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jooq.DSLContext;

/**
 *
 * @author malbinola
 */
public class TagDAO extends BaseDAO {
	private final static TagDAO INSTANCE = new TagDAO();
	public static TagDAO getInstance() {
		return INSTANCE;
	}
	
	public String generateTagId() {
		return IdentifierUtils.getTimeBasedShortID();
	}
	
	public Set<String> selectIdsByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				TAGS.TAG_ID
			)
			.from(TAGS)
			.where(
				TAGS.DOMAIN_ID.equal(domainId)
			)
			.orderBy(
				TAGS.BUILT_IN.desc(),
				TAGS.NAME.asc()
			)
			.fetchSet(TAGS.TAG_ID);
	}
	
	public Set<String> selectIdsByDomainName(Connection con, String domainId, String name) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				TAGS.NAME,
				TAGS.TAG_ID
			)
			.from(TAGS)
			.where(
				TAGS.DOMAIN_ID.equal(domainId)
				.and(TAGS.NAME.equal(name))
			)
			.fetchSet(TAGS.TAG_ID);
	}
	
	public Map<String, List<String>> groupIdsByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select(
				TAGS.NAME,
				TAGS.TAG_ID
			)
			.from(TAGS)
			.where(
				TAGS.DOMAIN_ID.equal(domainId)
			)
			.orderBy(
				TAGS.TAG_ID
			)
			.fetchGroups(TAGS.NAME, TAGS.TAG_ID);
	}
	
	public Map<String, OTag> selectByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(TAGS)
			.where(
				TAGS.DOMAIN_ID.equal(domainId)
			)
			.orderBy(
				TAGS.BUILT_IN.desc(),
				TAGS.NAME.asc()
			)
			.fetchMap(TAGS.TAG_ID, OTag.class);
	}
	
	public OTag selectByDomain(Connection con, String domainId, String tagId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.select()
			.from(TAGS)
			.where(
				TAGS.TAG_ID.equal(tagId)
				.and(TAGS.DOMAIN_ID.equal(domainId))
			)
			.fetchOneInto(OTag.class);
	}
	
	public int insert(Connection con, OTag item) throws DAOException {
		DSLContext dsl = getDSL(con);
		TagsRecord record = dsl.newRecord(TAGS, item);
		return dsl
			.insertInto(TAGS)
			.set(record)
			.execute();
	}
	
	public int update(Connection con, OTag item) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.update(TAGS)
			.set(TAGS.NAME, item.getName())
			.set(TAGS.COLOR, item.getColor())
			.where(
				TAGS.TAG_ID.equal(item.getTagId())
				.and(TAGS.DOMAIN_ID.equal(item.getDomainId()))
			)
			.execute();
	}
	
	public int deleteByDomainId(Connection con, String domainId, String tagId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(TAGS)
			.where(
				TAGS.TAG_ID.equal(tagId)
				.and(TAGS.DOMAIN_ID.equal(domainId))
			)
			.execute();
	}
	
	public int deleteByDomain(Connection con, String domainId) throws DAOException {
		DSLContext dsl = getDSL(con);
		return dsl
			.delete(TAGS)
			.where(
				TAGS.DOMAIN_ID.equal(domainId)
			)
			.execute();
	}
}
