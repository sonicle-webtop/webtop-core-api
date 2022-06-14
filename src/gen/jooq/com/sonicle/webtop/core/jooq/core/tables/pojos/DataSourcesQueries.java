/*
 * This file is generated by jOOQ.
 */
package com.sonicle.webtop.core.jooq.core.tables.pojos;



/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DataSourcesQueries implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private java.lang.String       queryId;
    private java.lang.String       dataSourceId;
    private org.joda.time.DateTime revisionTimestamp;
    private java.lang.String       name;
    private java.lang.String       description;
    private java.lang.String       rawSql;
    private java.lang.Boolean      forcePagination;

    public DataSourcesQueries() {}

    public DataSourcesQueries(DataSourcesQueries value) {
        this.queryId = value.queryId;
        this.dataSourceId = value.dataSourceId;
        this.revisionTimestamp = value.revisionTimestamp;
        this.name = value.name;
        this.description = value.description;
        this.rawSql = value.rawSql;
        this.forcePagination = value.forcePagination;
    }

    public DataSourcesQueries(
        java.lang.String       queryId,
        java.lang.String       dataSourceId,
        org.joda.time.DateTime revisionTimestamp,
        java.lang.String       name,
        java.lang.String       description,
        java.lang.String       rawSql,
        java.lang.Boolean      forcePagination
    ) {
        this.queryId = queryId;
        this.dataSourceId = dataSourceId;
        this.revisionTimestamp = revisionTimestamp;
        this.name = name;
        this.description = description;
        this.rawSql = rawSql;
        this.forcePagination = forcePagination;
    }

    /**
     * Getter for <code>core.data_sources_queries.query_id</code>.
     */
    public java.lang.String getQueryId() {
        return this.queryId;
    }

    /**
     * Setter for <code>core.data_sources_queries.query_id</code>.
     */
    public void setQueryId(java.lang.String queryId) {
        this.queryId = queryId;
    }

    /**
     * Getter for <code>core.data_sources_queries.data_source_id</code>.
     */
    public java.lang.String getDataSourceId() {
        return this.dataSourceId;
    }

    /**
     * Setter for <code>core.data_sources_queries.data_source_id</code>.
     */
    public void setDataSourceId(java.lang.String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    /**
     * Getter for <code>core.data_sources_queries.revision_timestamp</code>.
     */
    public org.joda.time.DateTime getRevisionTimestamp() {
        return this.revisionTimestamp;
    }

    /**
     * Setter for <code>core.data_sources_queries.revision_timestamp</code>.
     */
    public void setRevisionTimestamp(org.joda.time.DateTime revisionTimestamp) {
        this.revisionTimestamp = revisionTimestamp;
    }

    /**
     * Getter for <code>core.data_sources_queries.name</code>.
     */
    public java.lang.String getName() {
        return this.name;
    }

    /**
     * Setter for <code>core.data_sources_queries.name</code>.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Getter for <code>core.data_sources_queries.description</code>.
     */
    public java.lang.String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>core.data_sources_queries.description</code>.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     * Getter for <code>core.data_sources_queries.raw_sql</code>.
     */
    public java.lang.String getRawSql() {
        return this.rawSql;
    }

    /**
     * Setter for <code>core.data_sources_queries.raw_sql</code>.
     */
    public void setRawSql(java.lang.String rawSql) {
        this.rawSql = rawSql;
    }

    /**
     * Getter for <code>core.data_sources_queries.force_pagination</code>.
     */
    public java.lang.Boolean getForcePagination() {
        return this.forcePagination;
    }

    /**
     * Setter for <code>core.data_sources_queries.force_pagination</code>.
     */
    public void setForcePagination(java.lang.Boolean forcePagination) {
        this.forcePagination = forcePagination;
    }

    @Override
    public String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("DataSourcesQueries (");

        sb.append(queryId);
        sb.append(", ").append(dataSourceId);
        sb.append(", ").append(revisionTimestamp);
        sb.append(", ").append(name);
        sb.append(", ").append(description);
        sb.append(", ").append(rawSql);
        sb.append(", ").append(forcePagination);

        sb.append(")");
        return sb.toString();
    }
}
