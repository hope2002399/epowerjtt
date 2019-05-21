package com.centit.sys.util;

import java.util.Vector;

public class InFlowInfo {
    private String seq_id;
    private String type;
    private String title;
    private String next_seq_id;
    private String top;
    private String left;

    private String heigth;
    private String width;
    private String accept_name;
    private String station_function;
    private String is_risk;
    private String risk_desc;
    private String anticipate_day;
    private String anticipate_type;
    private String flow_id;
    private String flow_code;
    private String flow_title;
    @SuppressWarnings("rawtypes")
    private Vector nextSeq_id = new Vector();
    private String nextSeqName;
    private String document;
    private String document_id;
    private String document_name;
    private String file_name;
    private String file_content;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String documentId) {
        document_id = documentId;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String documentName) {
        document_name = documentName;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String fileName) {
        file_name = fileName;
    }

    public String getFile_content() {
        return file_content;
    }

    public void setFile_content(String fileContent) {
        file_content = fileContent;
    }

    public String getNextSeqName() {
        return nextSeqName;
    }

    public void setNextSeqName(String nextSeqName) {
        this.nextSeqName = nextSeqName;
    }

    public String getFlow_id() {
        return flow_id;
    }

    public void setFlow_id(String flow_id) {
        this.flow_id = flow_id;
    }

    public String getFlow_code() {
        return flow_code;
    }

    public void setFlow_code(String flow_code) {
        this.flow_code = flow_code;
    }

    public String getFlow_title() {
        return flow_title;
    }

    public void setFlow_title(String flow_title) {
        this.flow_title = flow_title;
    }

    public String getSeq_id() {
        return seq_id;
    }

    public void setSeq_id(String seq_id) {
        this.seq_id = seq_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNext_seq_id() {
        return next_seq_id;
    }

    public void setNext_seq_id(String next_seq_id) {
        this.next_seq_id = next_seq_id;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAccept_name() {
        return accept_name;
    }

    public void setAccept_name(String accept_name) {
        this.accept_name = accept_name;
    }

    public String getStation_function() {
        return station_function;
    }

    public void setStation_function(String station_function) {
        this.station_function = station_function;
    }

    public String getIs_risk() {
        return is_risk;
    }

    public void setIs_risk(String is_risk) {
        this.is_risk = is_risk;
    }

    public String getRisk_desc() {
        return risk_desc;
    }

    public void setRisk_desc(String risk_desc) {
        this.risk_desc = risk_desc;
    }

    public String getAnticipate_day() {
        return anticipate_day;
    }

    public void setAnticipate_day(String anticipate_day) {
        this.anticipate_day = anticipate_day;
    }

    public String getAnticipate_type() {
        return anticipate_type;
    }

    public void setAnticipate_type(String anticipate_type) {
        this.anticipate_type = anticipate_type;
    }

    @SuppressWarnings("rawtypes")
    public Vector getNextSeq_id() {
        return nextSeq_id;
    }

    @SuppressWarnings("rawtypes")
    public void setNextSeq_id(Vector nextSeq_id) {
        this.nextSeq_id = nextSeq_id;
    }

}
