/*
 * Copyright (C) 2022 Sonicle S.r.l.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License version 3 as published by
 * the Free Software Foundation of the addition of the following permission
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
 * along of this program; if not, see http://www.gnu.org/licenses or write to
 * the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301 USA.
 *
 * You can contact Sonicle S.r.l. at email address sonicle[at]sonicle[dot]com
 *
 * The interactive user interfaces in modified source and object code versions
 * of this program must display Appropriate Legal Notices, as required under
 * Section 5 of the GNU Affero General Public License version 3.
 *
 * In accordance of Section 7(b) of the GNU Affero General Public License
 * version 3, these Appropriate Legal Notices must retain the display of the
 * Sonicle logo and Sonicle copyright notice. If the display of the logo is not
 * reasonably feasible for technical reasons, the Appropriate Legal Notices must
 * display the words "Copyright (C) 2022 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.model;

import com.sonicle.commons.EnumUtils;
import com.sonicle.commons.flags.BaseBitFlags;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.sonicle.commons.flags.BitFlagsEnum;
import com.sonicle.commons.flags.BitFlagsUtils;

/**
 *
 * @author malbinola
 */
public class FolderShare {
	
	public static Set<String> toRightNames(FolderPermissions perms) {
		Set<String> set = new LinkedHashSet();
		if (perms != null) {
			for (FolderRight right : EnumUtils.allTypesOf(FolderRight.class)) {
				if (perms.has(right)) set.add(right.name());
			}
		}
		return set;
	}
	
	public static Set<String> toRightNames(ItemsPermissions perms) {
		Set<String> set = new LinkedHashSet();
		if (perms != null) {
			for (ItemsRight right : EnumUtils.allTypesOf(ItemsRight.class)) {
				if (perms.has(right)) set.add(right.name());
			}
		}
		return set;
	}
	
	public static String buildFolderPermissionKey(String context) {
		return context + "_FOLDER@SHARE";
	}
	
	public static String buildItemsPermissionKey(String context) {
		return context + "_FOLDERITEMS@SHARE";
	}
	
	public static enum EvalTarget {
		FOLDER, FOLDER_ITEMS;
	}
	
	public static class Permissions {
		protected final FolderShare.FolderPermissions folderPermissions;
		protected final FolderShare.ItemsPermissions itemsPermissions;
		
		public Permissions(FolderShare.FolderPermissions folderPerms, FolderShare.ItemsPermissions itemsPermissions) {
			this.folderPermissions = folderPerms;
			this.itemsPermissions = itemsPermissions;
		}
		
		public Permissions(FolderShare.FolderPermissions folderPerms) {
			this.folderPermissions = folderPerms;
			this.itemsPermissions = FolderShare.ItemsPermissions.withNone();
		}

		public FolderShare.FolderPermissions getFolderPermissions() {
			return folderPermissions;
		}

		public FolderShare.ItemsPermissions getItemsPermissions() {
			return itemsPermissions;
		}
		
		public static Permissions none() {
			return new Permissions(FolderShare.FolderPermissions.withNone(), FolderShare.ItemsPermissions.withNone());
		}
		
		public static Permissions full() {
			return new Permissions(FolderShare.FolderPermissions.withAll(), FolderShare.ItemsPermissions.withAll());
		}
		
		public static Permissions fullFolderOnly() {
			return new Permissions(FolderShare.FolderPermissions.withAll());
		}
		
		public static Permissions withFolderPermissionsOnly(Permissions source) {
			return new Permissions(source.getFolderPermissions());
		}
	}
	
	public static class FolderPermissions extends BaseBitFlags<FolderRight> {
		public FolderPermissions() { super((Class<FolderRight>)null); }
		public FolderPermissions(int value) { super((Class<FolderRight>)null, value); }
		public FolderPermissions(FolderRight... flags) { super((Class<FolderRight>)null, flags); }
		public FolderPermissions(BaseBitFlags<FolderRight> from) { super(from); }
		
		@Override
		public String toString() {
			return toString(false);
		}
		
		public String toString(boolean wildcardReservedOnly) {
			StringBuilder sb = new StringBuilder();
			for (FolderRight right : allAvailableFlags()) {
				if ((!wildcardReservedOnly || FolderRight.isReservedForWildcard(right)) && has(right)) sb.append(StringUtils.left(StringUtils.lowerCase(right.name()), 1));
			}
			return sb.toString();
		}
		
		public static FolderPermissions withAll() {
			return BitFlagsUtils.allOf(FolderPermissions.class);
		}
		
		public static FolderPermissions withNone() {
			return BitFlagsUtils.noneOf(FolderPermissions.class);
		}
		
		public static FolderPermissions with(final FolderRight right, final FolderRight... moreRights) {
			return BitFlagsUtils.with(FolderPermissions.class, right, moreRights);
		}
	}
	
	public static enum FolderRight implements BitFlagsEnum<FolderRight> {
		READ(1<<0), UPDATE(1<<2), DELETE(1<<3), MANAGE(1<<4);
		
		private long mask = 0;
		private FolderRight(long mask) { this.mask = mask; }
		@Override
		public long mask() { return this.mask; }
		
		public boolean isReservedForWildcard() {
			return isReservedForWildcard(this);
		}
		
		public static boolean isReservedForWildcard(String name) {
			return isReservedForWildcard(EnumUtils.forName(name, FolderRight.class));
		}
		
		public static boolean isReservedForWildcard(FolderRight permission) {
			// Some rights are reserved for wildcard instances only, in the  
			// meaning that they are only suitable for share origin.
			return FolderRight.MANAGE.equals(permission);
		}
	}
	
	public static class ItemsPermissions extends BaseBitFlags<ItemsRight> {
		public ItemsPermissions() { super((Class<ItemsRight>)null); }
		public ItemsPermissions(int value) { super((Class<ItemsRight>)null, value); }
		public ItemsPermissions(ItemsRight... flags) { super((Class<ItemsRight>)null, flags); }
		public ItemsPermissions(BaseBitFlags<ItemsRight> from) { super(from); }
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (ItemsRight right : allAvailableFlags()) {
				if (has(right)) sb.append(StringUtils.left(StringUtils.lowerCase(right.name()), 1));
			}
			return sb.toString();
		}
		
		public static ItemsPermissions withAll() {
			return BitFlagsUtils.allOf(ItemsPermissions.class);
		}
		
		public static ItemsPermissions withNone() {
			return BitFlagsUtils.noneOf(ItemsPermissions.class);
		}
		
		public static ItemsPermissions with(final ItemsRight right, final ItemsRight... moreRights) {
			return BitFlagsUtils.with(ItemsPermissions.class, right, moreRights);
		}
	}
	
	public static enum ItemsRight implements BitFlagsEnum<ItemsRight> {
		CREATE(1<<1), UPDATE(1<<2), DELETE(1<<3);
		
		private long mask = 0;
		private ItemsRight(long mask) { this.mask = mask; }
		@Override
		public long mask() { return this.mask; }
	}
	
	
	/*
	public static Set<String> toRightNames(FolderPermissions perms) {
		Set<String> set = new LinkedHashSet();
		if (perms != null) {
			for (FolderRight perm : BitFlagEnum.allFlagsOf(FolderRight.class).values()) {
				if (perms.has(perm)) set.add(perm.name());
			}
		}
		return set;
	}
	
	public static Set<String> toRightNames(ElementsPermissions perms) {
		Set<String> set = new LinkedHashSet();
		if (perms != null) {
			for (ElementsRight perm : BitFlagEnum.allFlagsOf(ElementsRight.class).values()) {
				if (perms.has(perm)) set.add(perm.name());
			}
		}
		return set;
	}
	
	public static class Permissions {
		public final FolderShare.FolderPermissions folderPerms;
		public final FolderShare.ElementsPermissions elementsPerms;
		
		public Permissions(FolderShare.FolderPermissions folderPerms, FolderShare.ElementsPermissions elementsPerms) {
			this.folderPerms = folderPerms;
			this.elementsPerms = elementsPerms;
		}

		public FolderShare.FolderPermissions getFolderPerms() {
			return folderPerms;
		}

		public FolderShare.ElementsPermissions getElementsPerms() {
			return elementsPerms;
		}
		
		public static Permissions full() {
			return new Permissions(FolderShare.FolderPermissions.all(), FolderShare.ElementsPermissions.all());
		}
	}
	
	public static class FolderPermissions extends BitFlag<FolderRight> {
		public FolderPermissions() { super(); }
		public FolderPermissions(int value) { super(value); }
		
		public static FolderPermissions all() {
			return new FolderPermissions(FolderRight.all());
		}
		
		public static FolderPermissions none() {
			return new FolderPermissions(0);
		}
		
		@Override
		public String toString() {
			return toString(false);
		}
		
		public String toString(boolean strictForOrigin) {
			StringBuilder sb = new StringBuilder();
			if ((!strictForOrigin || FolderRight.isStrictForOrigin(FolderRight.READ)) && has(FolderRight.READ)) sb.append("r");
			if ((!strictForOrigin || FolderRight.isStrictForOrigin(FolderRight.UPDATE)) && has(FolderRight.UPDATE)) sb.append("u");
			if ((!strictForOrigin || FolderRight.isStrictForOrigin(FolderRight.DELETE)) && has(FolderRight.DELETE)) sb.append("d");
			if ((!strictForOrigin || FolderRight.isStrictForOrigin(FolderRight.MANAGE)) && has(FolderRight.MANAGE)) sb.append("m");
			return sb.toString();
		}
	}
	
	public static enum FolderRight implements BitFlagEnum {
		READ(2), UPDATE(4), DELETE(8), MANAGE(16);
		
		private int value = 0;
		private FolderRight(int value) { this.value = value; }
		@Override
		public int value() { return this.value; }
		
		public boolean isStrictForOrigin() {
			return isStrictForOrigin(this);
		}
		
		public static boolean isStrictForOrigin(String name) {
			return isStrictForOrigin(EnumUtils.forName(name, FolderRight.class));
		}
		
		public static boolean isStrictForOrigin(FolderRight permission) {
			return FolderRight.MANAGE.equals(permission);
		}
		
		public static int all() {
			//EnumUtils.allTypesOf(FolderRight.class)
			return BitFlag.of(READ, UPDATE, DELETE, MANAGE).getValue();
		}
	}
	
	public static class ElementsPermissions extends BitFlag<ElementsRight> {
		public ElementsPermissions() { super(); }
		public ElementsPermissions(int value) { super(value); }
		
		public static ElementsPermissions all() {
			return new ElementsPermissions(ElementsRight.all());
		}
		
		public static ElementsPermissions none() {
			return new ElementsPermissions();
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (has(ElementsRight.CREATE)) sb.append("c");
			if (has(ElementsRight.UPDATE)) sb.append("u");
			if (has(ElementsRight.DELETE)) sb.append("d");
			return sb.toString();
		}
	}
	public static enum ElementsRight implements BitFlagEnum {
		CREATE(1), UPDATE(4), DELETE(8);
		
		private int value = 0;
		private ElementsRight(int value) { this.value = value; }
		@Override
		public int value() { return this.value; }
		
		public static int all() {
			//EnumUtils.allTypesOf(FolderRight.class)
			return BitFlag.of(CREATE, UPDATE, DELETE).getValue();
		}
	}
	*/
}
