package com.centit.powerruntime.po;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * TODO Class description should be added
 * 
 * @author CJW
 * @create 2014-2-13
 * @version
 */
public class VOptStuffInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String stuffid;
    private String djId; // 流程id
    private String stuffname;
    private String iszhi;
    private String filename;
    private Long nodeInstId; // 节点id
    private Date uploadtime;
    private String uploadusercode;
    private String nodename;
    private String netId;
    /**
     * 文件类别：<br>
     * ************************************************<br>
     * 1：格式文书<br>
     * 2：申请附件<br>
     * 3：办理附件 <br>
     * 4：证据（处罚平台用） <br>
     * ************************************************ <br>
     */
    private String filetype;

    /**
     * 格式文书类别archiveType：<br>
     * ************************************************<br>
     * 登记—— 01: 申请表<br>
     * 受理—— 02: 受理通知书、 03: 补正通知书、04:不受理通知书(保留)<br>
     * 审核（第二步）—— 05: 审核意见书、 06: 审核意见书附表 <br>
     * 审查（上报后的第一步）—— 07: 审查意见书<br>
     * 发证—— 08: 许可决定书<br>
     * ************************************************ <br>
     */
    private String archivetype;
    private String groupid;
    private String sortId;
    private String isuse;

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
    
    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    // Constructors
    /** default constructor */
    public VOptStuffInfo() {
    }

    /** minimal constructor */
    public VOptStuffInfo(String stuffid, String djId) {

        this.stuffid = stuffid;

        this.djId = djId;
    }

    /** full constructor */
    public VOptStuffInfo(String stuffid, String djId, String stuffname,
            String isuse, String iszhi, String filename, Long nodeInstId,
            Date uploadtime, String uploadusercode, String nodename,
            String filetype, String sortId, String archivetype, String groupid) {

        this.stuffid = stuffid;

        this.djId = djId;
        this.stuffname = stuffname;
        this.iszhi = iszhi;
        this.filename = filename;
        this.nodeInstId = nodeInstId;
        this.uploadtime = uploadtime;
        this.uploadusercode = uploadusercode;
        this.nodename = nodename;
        this.filetype = filetype;
        this.archivetype = archivetype;
        this.groupid = groupid;
        this.sortId = sortId;
        this.isuse = isuse;
    }

    public VOptStuffInfo(String stuffid, String djId, String stuffname,
            String iszhi, String filename, Long nodeInstId, Date uploadtime,
            String uploadusercode, String nodename, String filetype,
            String archivetype, String groupid, String sortId, String isuse) {
        super();
        this.stuffid = stuffid;
        this.djId = djId;
        this.stuffname = stuffname;
        this.iszhi = iszhi;
        this.filename = filename;
        this.nodeInstId = nodeInstId;
        this.uploadtime = uploadtime;
        this.uploadusercode = uploadusercode;
        this.nodename = nodename;
        this.filetype = filetype;
        this.archivetype = archivetype;
        this.groupid = groupid;
        this.sortId = sortId;
        this.isuse = isuse;
    }

    public String getStuffid() {
        return this.stuffid;
    }

    public void setStuffid(String stuffid) {
        this.stuffid = stuffid;
    }

    // Property accessors

    public String getDjId() {
        return this.djId;
    }

    public void setDjId(String djId) {
        this.djId = djId;
    }

    public String getStuffname() {
        return this.stuffname;
    }

    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    public String getIszhi() {
        return this.iszhi;
    }

    public void setIszhi(String iszhi) {
        this.iszhi = iszhi;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getNodeInstId() {
        return this.nodeInstId;
    }

    public void setNodeInstId(Long nodeInstId) {
        this.nodeInstId = nodeInstId;
    }

    public Date getUploadtime() {
        return this.uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUploadusercode() {
        return this.uploadusercode;
    }

    public void setUploadusercode(String uploadusercode) {
        this.uploadusercode = uploadusercode;
    }

    public String getNodename() {
        return this.nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getFiletype() {
        if (StringUtils.isBlank(filetype)) {
            this.filetype = "0";
        }
        return this.filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getArchivetype() {
        return this.archivetype;
    }

    public void setArchivetype(String archivetype) {
        this.archivetype = archivetype;
    }

    public void copy(VOptStuffInfo other) {

        this.setStuffid(other.getStuffid());
        this.djId = other.getDjId();
        this.stuffname = other.getStuffname();
        this.iszhi = other.getIszhi();
        this.filename = other.getFilename();
        this.nodeInstId = other.getNodeInstId();
        this.uploadtime = other.getUploadtime();
        this.uploadusercode = other.getUploadusercode();
        this.nodename = other.getNodename();
        this.filetype = other.getFiletype();
        this.archivetype = other.getArchivetype();
        this.groupid = other.groupid;
        this.sortId = other.sortId;
        this.isuse = other.isuse;
    }

    public void copyNotNullProperty(VOptStuffInfo other) {

        if (other.getStuffid() != null)
            this.setStuffid(other.getStuffid());

        if (other.getDjId() != null)
            this.djId = other.getDjId();
        if (other.getStuffname() != null)
            this.stuffname = other.getStuffname();
        if (other.getIszhi() != null)
            this.iszhi = other.getIszhi();
        if (other.getFilename() != null)
            this.filename = other.getFilename();
        if (other.getNodeInstId() != null)
            this.nodeInstId = other.getNodeInstId();
        if (other.getUploadtime() != null)
            this.uploadtime = other.getUploadtime();
        if (other.getUploadusercode() != null)
            this.uploadusercode = other.getUploadusercode();
        if (other.getNodename() != null)
            this.nodename = other.getNodename();
        if (other.getFiletype() != null)
            this.filetype = other.getFiletype();
        if (other.getArchivetype() != null)
            this.archivetype = other.getArchivetype();
        if (other.getGroupid() != null)
            this.groupid = other.getGroupid();
        if (other.getSortId() != null)
            this.sortId = other.getSortId();
        if (other.getIsuse() != null)
            this.isuse = other.getIsuse();
    }

    public void clearProperties() {

        this.djId = null;
        this.stuffname = null;
        this.iszhi = null;
        this.filename = null;
        this.nodeInstId = null;
        this.uploadtime = null;
        this.uploadusercode = null;
        this.nodename = null;
        this.filetype = null;
        this.archivetype = null;
        this.groupid = null;
        this.sortId = null;
        this.isuse = null;
    }
}
