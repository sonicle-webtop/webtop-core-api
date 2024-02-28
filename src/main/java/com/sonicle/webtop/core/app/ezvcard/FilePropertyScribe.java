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

import com.github.mangstadt.vinnie.io.VObjectPropertyValues;

import ezvcard.VCard;
import ezvcard.VCardDataType;
import ezvcard.VCardVersion;
import ezvcard.io.CannotParseException;
import ezvcard.io.ParseContext;
import ezvcard.io.html.HCardElement;
import ezvcard.io.json.JCardValue;
import ezvcard.io.scribe.VCardPropertyScribe;
import ezvcard.io.text.WriteContext;
import ezvcard.io.xml.XCardElement;
import ezvcard.parameter.Encoding;
import ezvcard.parameter.MediaTypeParameter;
import ezvcard.parameter.VCardParameters;
import ezvcard.util.DataUri;
import ezvcard.util.org.apache.commons.codec.binary.Base64;
import java.util.List;

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
 */

/**
 * Marshals properties that have binary data.
 * @author Michael Angstadt
 * @param <T> the property class
 * @param <U> the media type class
 */
public abstract class FilePropertyScribe<T extends FileProperty<U>, U extends MediaTypeParameter> extends VCardPropertyScribe<T> {
	public FilePropertyScribe(Class<T> clazz, String propertyName) {
		super(clazz, propertyName);
	}

	@Override
	protected VCardDataType _defaultDataType(VCardVersion version) {
		switch (version) {
		case V2_1:
		case V3_0:
			return null;
		case V4_0:
			return VCardDataType.URI;
		}
		return null;
	}

	@Override
	protected VCardDataType _dataType(T property, VCardVersion version) {
		if (property.getUrl() != null) {
			switch (version) {
			case V2_1:
				return VCardDataType.URL;
			case V3_0:
			case V4_0:
				return VCardDataType.URI;
			}
		}

		if (property.getData() != null) {
			switch (version) {
			case V2_1:
			case V3_0:
				return null;
			case V4_0:
				return VCardDataType.URI;
			}
		}

		return _defaultDataType(version);
	}

	@Override
	protected void _prepareParameters(T property, VCardParameters copy, VCardVersion version, VCard vcard) {
		String fileName = property.getFileName();
		if (fileName != null) copy.put(FileProperty.PARAM_FILENAME, fileName);
		
		MediaTypeParameter contentType = property.getContentType();
		if (contentType == null) {
			contentType = new MediaTypeParameter(null, null, null);
		}

		if (property.getUrl() != null) {
			copy.setEncoding(null);

			switch (version) {
			case V2_1:
				copy.setType(contentType.getValue());
				copy.setMediaType(null);
				break;
			case V3_0:
				copy.setType(contentType.getValue());
				copy.setMediaType(null);
				break;
			case V4_0:
				copy.setMediaType(contentType.getMediaType());
				break;
			}

			return;
		}

		if (property.getData() != null) {
			copy.setMediaType(null);

			switch (version) {
			case V2_1:
				copy.setEncoding(Encoding.BASE64);
				copy.setType(contentType.getValue());
				break;
			case V3_0:
				copy.setEncoding(Encoding.B);
				copy.setType(contentType.getValue());
				break;
			case V4_0:
				copy.setEncoding(null);
				//don't null out TYPE, it could be set to "home", "work", etc
				break;
			}

			return;
		}
	}

	@Override
	protected String _writeText(T property, WriteContext context) {
		return write(property, context.getVersion());
	}

	@Override
	protected T _parseText(String value, VCardDataType dataType, VCardParameters parameters, ParseContext context) {
		value = VObjectPropertyValues.unescape(value);
		return parse(value, dataType, parameters, context.getVersion());
	}

	@Override
	protected void _writeXml(T property, XCardElement parent) {
		parent.append(VCardDataType.URI, write(property, parent.version()));
	}

	@Override
	protected T _parseXml(XCardElement element, VCardParameters parameters, ParseContext context) {
		String value = element.first(VCardDataType.URI);
		if (value != null) {
			return parse(value, VCardDataType.URI, parameters, element.version());
		}

		throw missingXmlElements(VCardDataType.URI);
	}

	@Override
	protected T _parseHtml(HCardElement element, ParseContext context) {
		String elementName = element.tagName();
		if (!"object".equals(elementName)) {
			throw new CannotParseException(1, elementName);
		}
		
		String fileName = element.attr(FileProperty.PARAM_FILENAME);

		String data = element.absUrl("data");
		if (data.isEmpty()) {
			throw new CannotParseException(2);
		}

		try {
			DataUri uri = DataUri.parse(data);
			U mediaType = _mediaTypeFromMediaTypeParameter(uri.getContentType());

			return _newInstance(uri.getData(), mediaType, fileName);
		} catch (IllegalArgumentException e) {
			//not a data URI
			U mediaType;
			String type = element.attr("type");
			if (type.length() > 0) {
				mediaType = _mediaTypeFromMediaTypeParameter(type);
			} else {
				String extension = getFileExtension(data);
				mediaType = (extension == null) ? null : _mediaTypeFromFileExtension(extension);
			}

			return _newInstance(data, mediaType, fileName);
		}
	}

	@Override
	protected JCardValue _writeJson(T property) {
		return JCardValue.single(write(property, VCardVersion.V4_0));
	}

	@Override
	protected T _parseJson(JCardValue value, VCardDataType dataType, VCardParameters parameters, ParseContext context) {
		String valueStr = value.asSingle();
		return parse(valueStr, dataType, parameters, VCardVersion.V4_0);
	}

	/**
	 * Called if the unmarshalling code cannot determine how to unmarshal the
	 * value.
	 * @param value the value
	 * @param version the version of the vCard
	 * @param contentType the content type of the resource of null if unknown
	 * @return the unmarshalled property object or null if it cannot be
	 * unmarshalled
	 */
	protected T cannotUnmarshalValue(String value, VCardVersion version, U contentType, String fileName) {
		switch (version) {
		case V2_1:
		case V3_0:
			if (value.startsWith("http")) {
				return _newInstance(value, contentType, fileName);
			}
			return _newInstance(Base64.decodeBase64(value), contentType, fileName);
		case V4_0:
			return _newInstance(value, contentType, fileName);
		}
		return null;
	}

	/**
	 * Builds a {@link MediaTypeParameter} object based on the value of the
	 * MEDIATYPE parameter or data URI of 4.0 vCards.
	 * @param mediaType the media type string (e.g. "image/jpeg")
	 * @return the media type object
	 */
	protected abstract U _mediaTypeFromMediaTypeParameter(String mediaType);

	/**
	 * Builds a {@link MediaTypeParameter} object based on the value of the TYPE
	 * parameter in 2.1/3.0 vCards.
	 * @param type the TYPE value (e.g. "JPEG")
	 * @return the media type object
	 */
	protected abstract U _mediaTypeFromTypeParameter(String type);

	/**
	 * Searches for a {@link MediaTypeParameter} object, given a file extension.
	 * @param extension the file extension (e.g. "jpg")
	 * @return the media type object or null if not found
	 */
	protected abstract U _mediaTypeFromFileExtension(String extension);

	/**
	 * Creates a new instance of the property object from a URI.
	 * @param uri the URI
	 * @param contentType the content type or null if unknown
	 * @param fileName the file name
	 * @return the property object
	 */
	protected abstract T _newInstance(String uri, U contentType, String fileName);

	/**
	 * Creates a new instance of the property object from binary data.
	 * @param data the data
	 * @param contentType the content type or null if unknown
	 * @param fileName the file name
	 * @return the property object
	 */
	protected abstract T _newInstance(byte[] data, U contentType, String fileName);

	/**
	 * Tries to determine a property value's content type by looking at the
	 * property's parameters.
	 * @param parameters the parameters
	 * @param version the vCard version
	 * @return the content type or null if it can't be found
	 */
	protected U parseContentTypeFromParameters(VCardParameters parameters, VCardVersion version) {
		switch (version) {
		case V2_1:
		case V3_0:
			//get the TYPE parameter
			String type = parameters.getType();
			if (type != null) {
				return _mediaTypeFromTypeParameter(type);
			}
			break;
		case V4_0:
			//get the MEDIATYPE parameter
			String mediaType = parameters.getMediaType();
			if (mediaType != null) {
				return _mediaTypeFromMediaTypeParameter(mediaType);
			}
			break;
		}

		return null;
	}

	/**
	 * Tries to determine a property value's content type by looking at the
	 * property's parameters and value.
	 * @param value the property value
	 * @param parameters the property parameters
	 * @param version the vCard version
	 * @return the content type or null if it can't be found
	 */
	protected U parseContentTypeFromValueAndParameters(String value, VCardParameters parameters, VCardVersion version) {
		U contentType = parseContentTypeFromParameters(parameters, version);
		if (contentType != null) {
			return contentType;
		}

		//look for a file extension in the property value
		String extension = getFileExtension(value);
		return (extension == null) ? null : _mediaTypeFromFileExtension(extension);
	}

	/**
	 * Parses the property.
	 * @param value the property value
	 * @param dataType the data type
	 * @param parameters the property parameters
	 * @param version the vCard version
	 * @return the parsed property
	 */
	protected T parse(String value, VCardDataType dataType, VCardParameters parameters, VCardVersion version) {
		U contentType = parseContentTypeFromValueAndParameters(value, parameters, version);
		List<String> fileNames = parameters.get(FileProperty.PARAM_FILENAME);
		String fileName = "(unknown)";
		if (fileNames != null && fileNames.size()>0) fileName = parameters.get(FileProperty.PARAM_FILENAME).get(0);

		switch (version) {
		case V2_1:
		case V3_0:
			//parse as URL
			if (dataType == VCardDataType.URL || dataType == VCardDataType.URI) {
				return _newInstance(value, contentType, fileName);
			}

			//parse as binary
			Encoding encodingSubType = parameters.getEncoding();
			if (encodingSubType == Encoding.BASE64 || encodingSubType == Encoding.B) {
				return _newInstance(Base64.decodeBase64(value), contentType, fileName);
			}

			break;
		case V4_0:
			try {
				//parse as data URI
				DataUri uri = DataUri.parse(value);
				contentType = _mediaTypeFromMediaTypeParameter(uri.getContentType());
				return _newInstance(uri.getData(), contentType, fileName);
			} catch (IllegalArgumentException e) {
				//not a data URI
			}
			break;
		}

		return cannotUnmarshalValue(value, version, contentType, fileName);
	}

	private String write(T property, VCardVersion version) {
		String url = property.getUrl();
		if (url != null) {
			return url;
		}

		byte[] data = property.getData();
		if (data != null) {
			switch (version) {
			case V2_1:
			case V3_0:
				return Base64.encodeBase64String(data);
			case V4_0:
				U contentType = property.getContentType();
				String mediaType = (contentType == null || contentType.getMediaType() == null) ? "application/octet-stream" : contentType.getMediaType();
				return new DataUri(mediaType, data).toString();
			}
		}

		return "";
	}

	/**
	 * Gets the file extension from a URL.
	 * @param url the URL
	 * @return the file extension (e.g. "jpg") or null if not found
	 */
	protected static String getFileExtension(String url) {
		int dotPos = url.lastIndexOf('.');
		if (dotPos < 0 || dotPos == url.length() - 1) {
			return null;
		}

		int slashPos = url.lastIndexOf('/');
		if (slashPos > dotPos) {
			return null;
		}

		return url.substring(dotPos + 1);
	}
}