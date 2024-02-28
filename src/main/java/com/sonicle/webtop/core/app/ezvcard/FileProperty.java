/*
 * Copyright (C) 2024 Sonicle S.r.l.
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
 * display the words "Copyright (C) 2024 Sonicle S.r.l.".
 */
package com.sonicle.webtop.core.app.ezvcard;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ezvcard.VCard;
import ezvcard.VCardVersion;
import ezvcard.ValidationWarning;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.Pid;
import ezvcard.property.HasAltId;
import ezvcard.property.VCardProperty;
import ezvcard.util.Gobble;
import java.io.File;
import java.io.FileInputStream;

/*
 Copyright (c) 2012-2023, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies, 
 either expressed or implied, of the FreeBSD Project.
 */

/**
 * Represents a property whose value contains binary data.
 * @author Michael Angstadt
 * @param <T> the class used for representing the content type of the resource
 */
public abstract class FileProperty<T extends MediaTypeParameter> extends VCardProperty implements HasAltId {
	
	public static final String PARAM_FILENAME = "FILENAME";
	/**
	 * The decoded data.
	 */
	protected byte[] data;

	/**
	 * The URL to the resource.
	 */
	protected String url;

	/**
	 * The content type of the resource (for example, a JPEG image).
	 */
	protected T contentType;
	
	/**
	 * The file name.
	 */
	protected String fileName;

	protected FileProperty() {
		//empty
	}

	/**
	 * Creates a binary property.
	 * @param url the URL to the resource
	 * @param type the content type
	 * @param fileName the file name
	 */
	protected FileProperty(String url, T type, String fileName) {
		setUrl(url, type);
		addParameter(PARAM_FILENAME, fileName);
	}

	/**
	 * Creates a binary property.
	 * @param data the binary data
	 * @param type the content type
	 */
	protected FileProperty(byte[] data, T type, String fileName) {
		setData(data, type);
		addParameter(PARAM_FILENAME, fileName);
	}

	/**
	 * Creates a binary property.
	 * @param in an input stream to the binary data (will be closed)
	 * @param type the content type
	 * @throws IOException if there is a problem reading from the input stream
	 */
	protected FileProperty(InputStream in, T type, String fileName) throws IOException {
		this(new Gobble(in).asByteArray(), type, fileName);
	}

	/**
	 * Creates a binary property.
	 * @param file the file containing the binary data
	 * @param type the content type
	 * @throws IOException if there is a problem reading from the file
	 */
	protected FileProperty(Path file, T type, String fileName) throws IOException {
		this(new BufferedInputStream(Files.newInputStream(file)), type, fileName);
	}

	protected FileProperty(File file, T type, String fileName) throws IOException {
		this(new FileInputStream(file), type, fileName);
	}
	/**
	 * Copy constructor.
	 * @param original the property to make a copy of
	 */
	protected FileProperty(FileProperty<T> original) {
		super(original);
		data = (original.data == null) ? null : original.data.clone();
		url = original.url;
		contentType = original.contentType;
		fileName = original.fileName;
	}

	/**
	 * Gets the binary data of the resource.
	 * @return the binary data or null if there is none
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * Sets the binary data of the resource.
	 * @param data the binary data
	 * @param type the content type (e.g. "JPEG image")
	 */
	public void setData(byte[] data, T type) {
		this.url = null;
		this.data = data;
		setContentType(type);
	}

	/**
	 * Gets the URL to the resource
	 * @return the URL or null if there is none
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL to the resource.
	 * @param url the URL
	 * @param type the content type (e.g. "JPEG image")
	 */
	public void setUrl(String url, T type) {
		this.url = url;
		this.data = null;
		setContentType(type);
	}

	/**
	 * Gets the content type of the resource.
	 * @return the content type (e.g. "JPEG image")
	 */
	public T getContentType() {
		return contentType;
	}

	/**
	 * Sets the content type of the resource.
	 * @param contentType the content type (e.g. "JPEG image")
	 */
	public void setContentType(T contentType) {
		this.contentType = contentType;
	}
	
	public String getFileName() {
		List<String> fileNames = parameters.get(PARAM_FILENAME);
		String fileName = "(unknown)";
		if (fileNames != null && fileNames.size()>0) fileName = fileNames.get(0);
		return fileName;
	}
	
	/**
	 * Gets the vCard 4.0 TYPE parameter. This should NOT be used to get the
	 * TYPE parameter for 2.1/3.0 vCards. Use {@link #getContentType} instead.
	 * <p>
	 * <b>Supported versions:</b> {@code 4.0}
	 * </p>
	 * @return the TYPE value (typically, this will be either "work" or "home")
	 * or null if it doesn't exist
	 */
	public String getType() {
		return parameters.getType();
	}

	/**
	 * Sets the vCard 4.0 TYPE parameter. This should NOT be used to set the
	 * TYPE parameter for 2.1/3.0 vCards. Use {@link #setContentType} instead.
	 * <p>
	 * <b>Supported versions:</b> {@code 4.0}
	 * </p>
	 * @param type the TYPE value (should be either "work" or "home") or null to
	 * remove
	 */
	public void setType(String type) {
		parameters.setType(type);
	}
/*
	@Override
	public List<Pid> getPids() {
		return super.getPids();
	}

	@Override
	public Integer getPref() {
		return super.getPref();
	}

	@Override
	public void setPref(Integer pref) {
		super.setPref(pref);
	}*/

	//@Override
	public String getAltId() {
		return parameters.getAltId();
	}

	//@Override
	public void setAltId(String altId) {
		parameters.setAltId(altId);
	}

	@Override
	protected void _validate(List<ValidationWarning> warnings, VCardVersion version, VCard vcard) {
		if (url == null && data == null) {
			warnings.add(new ValidationWarning(8));
		}
	}

	@Override
	protected Map<String, Object> toStringValues() {
		Map<String, Object> values = new LinkedHashMap<>();
		values.put("data", (data == null) ? "null" : "length: " + data.length);
		values.put("url", url);
		values.put("contentType", contentType);
		values.put("fileName", fileName);
		return values;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		FileProperty<?> other = (FileProperty<?>) obj;
		if (fileName == null) {
			if (other.fileName != null) return false;
		} else if (!fileName.equals(other.fileName)) return false;
		if (contentType == null) {
			if (other.contentType != null) return false;
		} else if (!contentType.equals(other.contentType)) return false;
		if (!Arrays.equals(data, other.data)) return false;
		if (url == null) {
			if (other.url != null) return false;
		} else if (!url.equals(other.url)) return false;
		return true;
	}
}