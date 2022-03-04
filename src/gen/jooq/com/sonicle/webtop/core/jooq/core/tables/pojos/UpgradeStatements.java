/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UpgradeStatements implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.Integer           upgradeStatementId;
    private java.lang.String            tag;
    private java.lang.String            serviceId;
    private java.lang.Short             sequenceNo;
    private java.lang.String            scriptName;
    private java.lang.String            statementType;
    private java.lang.String            statementDataSource;
    private java.lang.String            statementBody;
    private java.lang.String            runStatus;
    private org.joda.time.LocalDateTime runTimestamp;
    private java.lang.String            runMessage;

    public UpgradeStatements() {}

    public UpgradeStatements(UpgradeStatements value) {
        this.upgradeStatementId = value.upgradeStatementId;
        this.tag = value.tag;
        this.serviceId = value.serviceId;
        this.sequenceNo = value.sequenceNo;
        this.scriptName = value.scriptName;
        this.statementType = value.statementType;
        this.statementDataSource = value.statementDataSource;
        this.statementBody = value.statementBody;
        this.runStatus = value.runStatus;
        this.runTimestamp = value.runTimestamp;
        this.runMessage = value.runMessage;
    }

    public UpgradeStatements(
        java.lang.Integer           upgradeStatementId,
        java.lang.String            tag,
        java.lang.String            serviceId,
        java.lang.Short             sequenceNo,
        java.lang.String            scriptName,
        java.lang.String            statementType,
        java.lang.String            statementDataSource,
        java.lang.String            statementBody,
        java.lang.String            runStatus,
        org.joda.time.LocalDateTime runTimestamp,
        java.lang.String            runMessage
    ) {
        this.upgradeStatementId = upgradeStatementId;
        this.tag = tag;
        this.serviceId = serviceId;
        this.sequenceNo = sequenceNo;
        this.scriptName = scriptName;
        this.statementType = statementType;
        this.statementDataSource = statementDataSource;
        this.statementBody = statementBody;
        this.runStatus = runStatus;
        this.runTimestamp = runTimestamp;
        this.runMessage = runMessage;
    }

    /**
     * Getter for <code>core.upgrade_statements.upgrade_statement_id</code>.
     */
    public java.lang.Integer getUpgradeStatementId() {
        return this.upgradeStatementId;
    }

    /**
     * Setter for <code>core.upgrade_statements.upgrade_statement_id</code>.
     */
    public void setUpgradeStatementId(java.lang.Integer upgradeStatementId) {
        this.upgradeStatementId = upgradeStatementId;
    }

    /**
     * Getter for <code>core.upgrade_statements.tag</code>.
     */
    public java.lang.String getTag() {
        return this.tag;
    }

    /**
     * Setter for <code>core.upgrade_statements.tag</code>.
     */
    public void setTag(java.lang.String tag) {
        this.tag = tag;
    }

    /**
     * Getter for <code>core.upgrade_statements.service_id</code>.
     */
    public java.lang.String getServiceId() {
        return this.serviceId;
    }

    /**
     * Setter for <code>core.upgrade_statements.service_id</code>.
     */
    public void setServiceId(java.lang.String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * Getter for <code>core.upgrade_statements.sequence_no</code>.
     */
    public java.lang.Short getSequenceNo() {
        return this.sequenceNo;
    }

    /**
     * Setter for <code>core.upgrade_statements.sequence_no</code>.
     */
    public void setSequenceNo(java.lang.Short sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    /**
     * Getter for <code>core.upgrade_statements.script_name</code>.
     */
    public java.lang.String getScriptName() {
        return this.scriptName;
    }

    /**
     * Setter for <code>core.upgrade_statements.script_name</code>.
     */
    public void setScriptName(java.lang.String scriptName) {
        this.scriptName = scriptName;
    }

    /**
     * Getter for <code>core.upgrade_statements.statement_type</code>.
     */
    public java.lang.String getStatementType() {
        return this.statementType;
    }

    /**
     * Setter for <code>core.upgrade_statements.statement_type</code>.
     */
    public void setStatementType(java.lang.String statementType) {
        this.statementType = statementType;
    }

    /**
     * Getter for <code>core.upgrade_statements.statement_data_source</code>.
     */
    public java.lang.String getStatementDataSource() {
        return this.statementDataSource;
    }

    /**
     * Setter for <code>core.upgrade_statements.statement_data_source</code>.
     */
    public void setStatementDataSource(java.lang.String statementDataSource) {
        this.statementDataSource = statementDataSource;
    }

    /**
     * Getter for <code>core.upgrade_statements.statement_body</code>.
     */
    public java.lang.String getStatementBody() {
        return this.statementBody;
    }

    /**
     * Setter for <code>core.upgrade_statements.statement_body</code>.
     */
    public void setStatementBody(java.lang.String statementBody) {
        this.statementBody = statementBody;
    }

    /**
     * Getter for <code>core.upgrade_statements.run_status</code>.
     */
    public java.lang.String getRunStatus() {
        return this.runStatus;
    }

    /**
     * Setter for <code>core.upgrade_statements.run_status</code>.
     */
    public void setRunStatus(java.lang.String runStatus) {
        this.runStatus = runStatus;
    }

    /**
     * Getter for <code>core.upgrade_statements.run_timestamp</code>.
     */
    public org.joda.time.LocalDateTime getRunTimestamp() {
        return this.runTimestamp;
    }

    /**
     * Setter for <code>core.upgrade_statements.run_timestamp</code>.
     */
    public void setRunTimestamp(org.joda.time.LocalDateTime runTimestamp) {
        this.runTimestamp = runTimestamp;
    }

    /**
     * Getter for <code>core.upgrade_statements.run_message</code>.
     */
    public java.lang.String getRunMessage() {
        return this.runMessage;
    }

    /**
     * Setter for <code>core.upgrade_statements.run_message</code>.
     */
    public void setRunMessage(java.lang.String runMessage) {
        this.runMessage = runMessage;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UpgradeStatements (");

        sb.append(upgradeStatementId);
        sb.append(", ").append(tag);
        sb.append(", ").append(serviceId);
        sb.append(", ").append(sequenceNo);
        sb.append(", ").append(scriptName);
        sb.append(", ").append(statementType);
        sb.append(", ").append(statementDataSource);
        sb.append(", ").append(statementBody);
        sb.append(", ").append(runStatus);
        sb.append(", ").append(runTimestamp);
        sb.append(", ").append(runMessage);

        sb.append(")");
        return sb.toString();
    }
}
