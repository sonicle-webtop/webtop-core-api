/**
 * This class is generated by jOOQ
 */
package com.sonicle.webtop.core.jooq.config.tables.pojos;

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
public class FetchmailPolls implements java.io.Serializable {

	private static final long serialVersionUID = -511781250;

	private java.lang.Integer pollId;
	private java.lang.String  context;
	private java.lang.String  host;
	private java.lang.Short   port;
	private java.lang.String  protocol;
	private java.lang.Boolean ssl;
	private java.lang.String  remoteUser;
	private java.lang.String  remotePassword;
	private java.lang.String  localUser;

	public FetchmailPolls() {}

	public FetchmailPolls(
		java.lang.Integer pollId,
		java.lang.String  context,
		java.lang.String  host,
		java.lang.Short   port,
		java.lang.String  protocol,
		java.lang.Boolean ssl,
		java.lang.String  remoteUser,
		java.lang.String  remotePassword,
		java.lang.String  localUser
	) {
		this.pollId = pollId;
		this.context = context;
		this.host = host;
		this.port = port;
		this.protocol = protocol;
		this.ssl = ssl;
		this.remoteUser = remoteUser;
		this.remotePassword = remotePassword;
		this.localUser = localUser;
	}

	public java.lang.Integer getPollId() {
		return this.pollId;
	}

	public void setPollId(java.lang.Integer pollId) {
		this.pollId = pollId;
	}

	public java.lang.String getContext() {
		return this.context;
	}

	public void setContext(java.lang.String context) {
		this.context = context;
	}

	public java.lang.String getHost() {
		return this.host;
	}

	public void setHost(java.lang.String host) {
		this.host = host;
	}

	public java.lang.Short getPort() {
		return this.port;
	}

	public void setPort(java.lang.Short port) {
		this.port = port;
	}

	public java.lang.String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(java.lang.String protocol) {
		this.protocol = protocol;
	}

	public java.lang.Boolean getSsl() {
		return this.ssl;
	}

	public void setSsl(java.lang.Boolean ssl) {
		this.ssl = ssl;
	}

	public java.lang.String getRemoteUser() {
		return this.remoteUser;
	}

	public void setRemoteUser(java.lang.String remoteUser) {
		this.remoteUser = remoteUser;
	}

	public java.lang.String getRemotePassword() {
		return this.remotePassword;
	}

	public void setRemotePassword(java.lang.String remotePassword) {
		this.remotePassword = remotePassword;
	}

	public java.lang.String getLocalUser() {
		return this.localUser;
	}

	public void setLocalUser(java.lang.String localUser) {
		this.localUser = localUser;
	}
}