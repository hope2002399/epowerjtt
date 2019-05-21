package com.centit.sys.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.action.BaseEntityExtremeAction;
import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserPwd;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserrole;
import com.centit.sys.po.FUserroleId;
import com.centit.sys.po.FUserunit;
import com.centit.sys.po.FUserunitId;
import com.centit.sys.security.CaptchaImageUtil;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryManager;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.SysUnitManager;
import com.centit.sys.service.SysUserManager;
import com.centit.sys.util.ISysOptLog;
import com.centit.sys.util.SysOptLogFactoryImpl;

public class UserDefAction extends BaseEntityExtremeAction<FUserinfo> implements
        ServletResponseAware {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(UserDefAction.class);
    private static final ISysOptLog SYS_OPT_LOG = SysOptLogFactoryImpl
            .getSysOptLog("USERMAG");
    private SysUserManager sysUserMgr;
    private SysUnitManager sysUnitManager;

    public void setSysUnitManager(SysUnitManager sysUnitManager) {
        this.sysUnitManager = sysUnitManager;
    }

    private CodeRepositoryManager codeRepositoryManager;

    private FUserPwd userPwd;

    private List<FUserrole> userroles;
    private List<FUserunit> userunits;
    private String unitsJson;

    public List<FUserrole> getUserroles() {
        return userroles;
    }

    public void setUserroles(List<FUserrole> userroles) {
        this.userroles = userroles;
    }

    public SysUserManager getSysUserMgr() {
        return sysUserMgr;
    }

    public void setUserunits(List<FUserunit> userunits) {
        this.userunits = userunits;
    }

    public List<FUserunit> getUserunits() {
        return userunits;
    }

    public void setSysUserMgr(SysUserManager sysUserMgr) {
        this.sysUserMgr = sysUserMgr;
        this.setBaseEntityManager(sysUserMgr);
    }

    public FUserPwd getUserPwd() {
        if (userPwd == null)
            userPwd = new FUserPwd();
        return userPwd;
    }

    public void setUserPwd(FUserPwd userPwd) {
        this.userPwd = userPwd;
    }

    public void setCodeRepositoryManager(
            CodeRepositoryManager codeRepositoryManager) {
        this.codeRepositoryManager = codeRepositoryManager;
    }

    public void setSysuserMgr(SysUserManager sysuserMagr) {
        this.sysUserMgr = sysuserMagr;
        setBaseEntityManager(sysuserMagr);
    }

    /**
     * 返回AJAX数据
     * 
     * @return
     */
    public String getUsers() {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out;
        try {
            out = response.getWriter();
            out.print(sysUserMgr.getJSONUsers());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
     * 管理员重置用户密码
     */
    private String norejsp;

    public String getNorejsp() {
        return norejsp;
    }

    public void setNorejsp(String norejsp) {
        this.norejsp = norejsp;
    }

    public String resetpwd() {
        try {
            sysUserMgr.resetPwd(object.getUsercode());
            savedMessage();
            if ("1".equals(norejsp))
                return pwdlist();
            return EDIT;
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    public String pwdlist() {
        try {
            Map<Object, Object> paramMap = request.getParameterMap();
            resetPageParam(paramMap);

            Map<String, Object> filterMap = convertSearchColumn(paramMap);
            Limit limit = ExtremeTableUtils.getLimit(request);
            PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
            objList = baseEntityManager.listObjects(filterMap, pageDesc);
            totalRows = pageDesc.getTotalRows();
            return "pwdlist";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private String resetUsers;

    public String getResetUsers() {
        return resetUsers;
    }

    public void setResetUsers(String resetUsers) {
        this.resetUsers = resetUsers;
    }

    public String resetpwds() {
        if (!resetUsers.isEmpty()) {
            String ar[] = resetUsers.split(",");
            for (String a : ar) {
                sysUserMgr.resetPwd(a);
            }
        }
        return pwdlist();
    }

    public Integer uu_totalRows;
    public Integer ur_totalRows;

    public Integer getUr_totalRows() {
        return ur_totalRows;
    }

    public void setUr_totalRows(Integer ur_totalRows) {
        this.ur_totalRows = ur_totalRows;
    }

    public Integer getUu_totalRows() {
        return uu_totalRows;
    }

    public void setUu_totalRows(Integer uu_totalRows) {
        this.uu_totalRows = uu_totalRows;
    }

    public String view() {

        try {
            // FUserDetail user =
            // ((FUserDetail)getLoginUser());//.getUserinfo（）;
            // FUserunit dept =
            // sysUserMgr.getUserPrimaryUnit(user.getUsercode());
            FUserinfo ri = sysUserMgr.getObjectById(object.getUsercode());
            if (ri != null)
                object.copyNotNullProperty(ri);
            userunits = sysUserMgr.getSysUnitsByUserId(object.getUsercode());
            uu_totalRows = userunits.size();
            userroles = sysUserMgr.getAllUserRoles(object.getUsercode(), "G-");
            List<FUserrole> list = sysUserMgr.getAllUserRoles(
                    object.getUsercode(), "P-");
            if (list != null)
                userroles.addAll(list);
            ur_totalRows = userroles.size();
            return VIEW;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String viewUnderUnit() {

        try {
            FUserDetail user = ((FUserDetail) getLoginUser());// .getUserinfo（）;
            FUserunit dept = sysUserMgr.getUserPrimaryUnit(user.getUsercode());
            FUserinfo ri = sysUserMgr.getObjectById(object.getUsercode());
            if (ri != null)
                object.copyNotNullProperty(ri);

            userunits = sysUserMgr.getSysUnitsByUserId(object.getUsercode());

            uu_totalRows = userunits.size();
            userroles = sysUserMgr.getAllUserRoles(object.getUsercode(),
                    dept.getUnitcode() + "-");
            List<FUserrole> list = sysUserMgr.getAllUserRoles(
                    object.getUsercode(), "P-");
            if (list != null)
                userroles.addAll(list);
            ur_totalRows = userroles.size();
            return "viewUnderUnit";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // 设置用户角色
    public FUserrole userrole;
    private Date obtaindate;

    public FUserrole getUserrole() {
        return userrole;
    }

    public void setUserrole(FUserrole userrole) {
        this.userrole = userrole;
    }

    public Date getObtaindate() {
        return obtaindate;
    }

    public void setObtaindate(Date obtaindate) {
        this.obtaindate = obtaindate;
    }

    public String bulitUserRole() {
        try {
            FUserroleId id = new FUserroleId();
            id.setUsercode(object.getUsercode());
            id.setObtaindateToToday();
            userrole = new FUserrole();
            userrole.setId(id);

            return "editUserRole";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String editUserRole() {
        try {
            FUserroleId id = new FUserroleId();
            id.setUsercode(object.getUsercode());
            id.setRolecode(userrole.getRolecode());
            id.setObtaindate(obtaindate);
            // userrole=sysUserMgr.getFUserroleByID(id);
            userrole = sysUserMgr.getValidUserrole(id.getUsercode(),
                    id.getRolecode());

            if (userrole == null) {
                userrole = new FUserrole();
                id.setObtaindateToToday(); // setObtaindate(new Date());
                userrole.setId(id);
            }

            return "editUserRole";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String saveUserRole() {
        try {
            String oldValue = null;
            FUserrole desobj = sysUserMgr.getValidUserrole(
                    userrole.getUsercode(), userrole.getRolecode());
            userrole.setObtaindateToToday();
            if (desobj != null) {
                oldValue = desobj.display();
                desobj.copyNotNullProperty(userrole);
                userrole = desobj;
            }
            try {
                sysUserMgr.saveUserrole(userrole);
                savedMessage();

                SYS_OPT_LOG.log(
                        ((FUserinfo) this.getLoginUser()).getUsercode(),
                        userrole.getId().toString(), userrole.display(),
                        oldValue);

            } catch (Exception e) {
                log.error(e.getMessage(), e);

                return "editUserRole";
            }

            return "saveUserRole";

        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    public String deleteUserRole() {
        try {
            FUserroleId id = new FUserroleId();
            id.setUsercode(userrole.getUsercode());
            id.setRolecode(userrole.getRolecode());
            id.setObtaindate(obtaindate);
            log.debug(userrole.getRolecode());
            id.setRolecode(userrole.getRolecode());

            sysUserMgr.deleteUserrole(id.getUsercode(), id.getRolecode());
            deletedMessage();

            String optContent = "删除用户 ["
                    + CodeRepositoryUtil.getValue("usercode",
                            userrole.getUsercode())
                    + " ] 角色 ["
                    + CodeRepositoryUtil.getValue("rolecode",
                            userrole.getRolecode()) + " ]";
            SYS_OPT_LOG.log(((FUserinfo) this.getLoginUser()).getUsercode(),
                    id.toString(), optContent, userrole.display());
            return "saveUserRole";
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    // 设置用户单位
    private FUserunit userUnit;

    /*
     * private String userrank; private String userstation; private String
     * unitcode;
     */

    public String addUserUnit() {
        userUnit = new FUserunit();
        userUnit.setUsercode(object.getUsercode());
        unitsJson = sysUnitManager.getAllUnitsJSON();
        return "editUserUnit";
    }

    public String addUserUnderUnit() {
        FUserDetail user = ((FUserDetail) getLoginUser());
        FUserunit dept = sysUserMgr.getUserPrimaryUnit(user.getUsercode());
        userUnit = new FUserunit();
        userUnit.setUsercode(object.getUsercode());
        if (dept != null) {
            unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
            userUnit.setUnitcode(dept.getUnitcode());
        }
        unitsJson = sysUnitManager.getAllUnitsJSON();
        return "editUserUnit";
    }

    public String editUserUnit() {

        try {
            FUserunitId id = new FUserunitId();
            id.setUsercode(userUnit.getUsercode());
            id.setUnitcode(userUnit.getUnitcode());
            id.setUserrank(userUnit.getUserrank());
            id.setUserstation(userUnit.getUserstation());

            userUnit = sysUserMgr.findUserUnitById(id);

            if (userUnit == null) {
                userUnit = new FUserunit();
                userUnit.setId(id);
            }
            unitsJson = sysUnitManager.getAllUnitsJSON();
            return "editUserUnit";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String saveUserUnit() {

        try {
            FUserunitId id = new FUserunitId();
            id.setUsercode(userUnit.getUsercode());
            id.setUnitcode(userUnit.getUnitcode());
            id.setUserrank(userUnit.getUserrank());
            id.setUserstation(userUnit.getUserstation());
            FUserunit dbobject = sysUserMgr.findUserUnitById(id);

            if (dbobject != null) {
                dbobject.copyNotNullProperty(userUnit);
                userUnit = dbobject;
            }
            try {
                String oldValue = userUnit.display();
                sysUserMgr.saveUserUnit(userUnit);
                savedMessage();

                SYS_OPT_LOG.log(
                        ((FUserinfo) this.getLoginUser()).getUsercode(),
                        id.toString(),
                        "岗位角色定义删除 ["
                                + CodeRepositoryUtil.getValue("usercode",
                                        userUnit.getUsercode()) + "] ",
                        oldValue);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return "editUserUnit";
            }
            codeRepositoryManager.refresh("userunit");
            return "saveUserUnit";

        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    public String deleteUserUnit() {
        try {
            FUserunitId id = new FUserunitId();
            id.setUsercode(userUnit.getUsercode());
            id.setUnitcode(userUnit.getUnitcode());
            id.setUserrank(userUnit.getUserrank());
            id.setUserstation(userUnit.getUserstation());
            sysUserMgr.deleteUserUnit(id);
            codeRepositoryManager.refresh("userunit");
            deletedMessage();
            return "saveUserUnit";
        } catch (Exception ee) {
            ee.printStackTrace();
            return ERROR;
        }
    }

    public String delete() {
        try {
            try {
                object = sysUserMgr.getObjectById(object.getUsercode());
                sysUserMgr.disableObject(object);
                codeRepositoryManager.refresh("usercode");
                deletedMessage();
                String underUnit = (String) request.getParameter("underUnit");
                deletedMessage();

                SYS_OPT_LOG.log(
                        ((FUserinfo) this.getLoginUser()).getUsercode(),
                        object.getUsercode(), "禁用用户 [" + object.getUsername()
                                + " ]");
                if (underUnit == null)
                    return SUCCESS;
                else
                    return "underUnit";
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return EDIT;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String built() {
        try {
            object = new FUserinfo();
            object.setUsercode(sysUserMgr.getNextUserCode('S'));
            userUnit = new FUserunit();
            unitsJson = sysUnitManager.getAllUnitsJSON();
            return EDIT;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    public String listUserInfo() {
        try {
            FUserDetail user = ((FUserDetail) getLoginUser());// .getUserinfo（）;
            FUserunit dept = sysUserMgr.getUserPrimaryUnit(user.getUsercode());
            if (dept != null) {
                Map<Object, Object> paramMap = request.getParameterMap();
                resetPageParam(paramMap);
                Map<String, Object> filterMap = convertSearchColumn(paramMap);
                // filterMap.put("queryUnderUnit", dept.getUnitcode());
                if ("thisunit".equals(filterMap.get("byUnderUnit"))) {
                    filterMap.put("byUnderUnit", dept.getUnitcode());
                    filterMap.remove("queryUnderUnit");
                }
                if ("true".equals(filterMap.get("queryUnderUnit"))) {
                    filterMap.put("queryUnderUnit", dept.getUnitcode());
                    filterMap.remove("byUnderUnit");
                }
                filterMap.put("order", "");
                Limit limit = ExtremeTableUtils.getLimit(request);
                PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
                objList = sysUserMgr.listUnderUnit(filterMap, pageDesc);

                totalRows = pageDesc.getTotalRows();
                unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
                userUnit = new FUserunit();
                userUnit.setUnitcode(dept.getUnitcode());
            }
            return "listUserInfo";
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    private List<FUnitinfo> unitList;

    public List<FUnitinfo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<FUnitinfo> unitList) {
        this.unitList = unitList;
    }

    public String builtUnderUnit() {
        FUserDetail user = ((FUserDetail) getLoginUser());// .getUserinfo（）;
        FUserunit dept = sysUserMgr.getUserPrimaryUnit(user.getUsercode());
        object.setUsercode(sysUserMgr.getNextUserCode('S'));
        if (dept != null) {
            unitList = sysUnitManager.getAllSubUnits(dept.getUnitcode());
            userUnit = new FUserunit();
            userUnit.setUnitcode(dept.getUnitcode());
        }
        return EDIT;

    }

    /**
     * 用户查询列表
     */
    public String list() {
        unitsJson = sysUnitManager.getAllUnitsJSON();
        return super.list();
    }

    public String edit() {

        try {
            if (object != null) {
                FUserinfo dbobject = sysUserMgr.getObjectById(object
                        .getUsercode());
                if (dbobject != null) {
                    sysUserMgr.copyObjectNotNullProperty(object, dbobject);
                    userUnit = sysUserMgr.getUserPrimaryUnit(object
                            .getUsercode());
                }
            }
            unitsJson = sysUnitManager.getAllUnitsJSON();
            return EDIT;
        }

        catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String editUnderUnit() {
        try {
            if (object != null) {
                FUserinfo dbobject = sysUserMgr.getObjectById(object
                        .getUsercode());
                if (dbobject != null) {
                    sysUserMgr.copyObjectNotNullProperty(object, dbobject);
                    userUnit = sysUserMgr.getUserPrimaryUnit(object
                            .getUsercode());
                    request.setAttribute("underUnit", "T");
                }
            }
            return EDIT;
        }

        catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String saveUnderUnit() {
        try {
            FUserinfo dbobject = sysUserMgr.getObjectById(object.getUsercode());
            if (dbobject != null) {
                sysUserMgr.copyObjectNotNullProperty(dbobject, object);
                object = dbobject;
            }
            userUnit.setUsercode(object.getUsercode());
            userUnit.setIsprimary("T");
            FUserunit dbuserunit = sysUserMgr
                    .findUserUnitById(userUnit.getId());
            if (dbuserunit != null) {
                dbuserunit.copyNotNullProperty(userUnit);
                userUnit = dbuserunit;
            }
            sysUserMgr.saveObject(object);
            sysUserMgr.saveUserUnit(userUnit);
            return "underUnit";

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }

    }

    public String save() {
        String optContent = null;
        String oldValue = null;
        try {
            FUserinfo dbobject = sysUserMgr.getObjectById(object.getUsercode());
            if (dbobject != null) {
                sysUserMgr.copyObjectNotNullProperty(dbobject, object);
                object = dbobject;
            }
            userUnit.setUsercode(object.getUsercode());
            userUnit.setIsprimary("T");
            FUserunit dbuserunit = sysUserMgr
                    .findUserUnitById(userUnit.getId());
            if (dbuserunit != null) {
                oldValue = dbuserunit.display();

                dbuserunit.copyNotNullProperty(userUnit);
                userUnit = dbuserunit;
            }
            sysUserMgr.saveObject(object);
            sysUserMgr.saveUserUnit(userUnit);

            optContent = object.display() + "  " + userUnit.display();

            codeRepositoryManager.refresh("usercode");
            codeRepositoryManager.refresh("userunit");

            SYS_OPT_LOG.log(((FUserinfo) this.getLoginUser()).getUsercode(),
                    object.getUsercode(), optContent, oldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        savedMessage();
        String underUnit = (String) request.getParameter("underUnit");
        if (underUnit == null)
            return SUCCESS;
        else
            return "underUnit";

    }

    /*
     * 用户修改自己的登录密码，1.0版本在mainframeAction中
     */
    public String modifyPwdPage() {
        getUserPwd();
        FUserinfo ui = ((FUserDetail) getLoginUser());
        userPwd.setLoginname(ui.getLoginname());
        return "modifyPwdPage";
    }

    public String modifypwd() {
        try {

            FUserinfo ui = ((FUserDetail) getLoginUser());
            if (!userPwd.getNewPassword().equals(userPwd.getConfirmPassword())) {
                saveMessage("两次输入的密码不一致，请重新输入。");
                return DIVERROR;
            }

            sysUserMgr.setNewPassword(ui.getUsercode(),
                    userPwd.getOldPassword(), userPwd.getNewPassword());
            this.postAlertMessage("密码修改成功！");
            return null;
        } catch (Exception ee) {
            ee.printStackTrace();
            this.saveMessage(ee.getMessage());
            return DIVERROR;
        }
        // return "modifypwd";
    }

    /*
     * 网页用户注册
     */

    public String registerpage() {
        getUserPwd();
        // 将用户登录名设置为空
        sysUserMgr.clearObjectProperties(object);
        // FUserinfo ui = ((FUserDetail)getLoginUser());
        userPwd.setLoginname("");// ui.getLoginname());
        // userPwd.setCaptchaKey(captchaImage.generateCaptchaKey());
        return "registerPage";
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String captchaimage() {
        try {
            String checkcode = CaptchaImageUtil.getRandomString();
            request.getSession().setAttribute(
                    CaptchaImageUtil.SESSIONCHECKCODE, checkcode);

            BufferedImage img = CaptchaImageUtil
                    .generateCaptchaImage(checkcode);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(img, "gif", out);
            byte[] bbuf = out.toByteArray();
            this.setInputStream(new ByteArrayInputStream(bbuf));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "captchaimage";
    }

    // private JSONObject result;

    public String register() {

        String session_checkcode = request.getSession()
                .getAttribute(CaptchaImageUtil.SESSIONCHECKCODE).toString();
        String request_checkcode = request.getParameter(
                CaptchaImageUtil.REQUESTCHECKCODE).toString();
        boolean validCaptcha = session_checkcode != null
                && session_checkcode.equalsIgnoreCase(request_checkcode);

        if (!validCaptcha) {
            this.saveError("输入的验证码不正确！");
            return DIVERROR;// "registerPage";
        }
        if (!userPwd.getNewPassword().equals(userPwd.getConfirmPassword())) {
            saveMessage("两次输入的密码不一致，请重新输入。");
            return DIVERROR;
        }

        userPwd.setLoginname(object.getLoginname());
        String pwd = userPwd.getNewPassword();// request.getParameter("password");

        String sUC = sysUserMgr.getNextUserCode('W');
        object.setUsercode(sUC);
        object.setUserpin(sysUserMgr.encodePassword(pwd, sUC));
        object.setIsvalid("T");
        try {
            sysUserMgr.saveObject(object);
        } catch (Exception e) {
            this.saveError("您输入登录名或者email已被别人使用！");
            return DIVERROR;
        }

        FDatadictionary dItem = CodeRepositoryUtil.getDataPiece("SYSPARAM",
                "EnableWebUsr");

        FUserrole userrole = new FUserrole();
        String sRC = dItem.getDatavalue();
        userrole.setUsercode(sUC);
        userrole.setRolecode(sRC);
        userrole.setObtaindateToToday();
        userrole.setSecededate(null);
        userrole.setChangedesc("网络注册用户自动赋予的权限");
        sysUserMgr.saveUserrole(userrole);

        FUserunit uu = new FUserunit();
        String sUintC = dItem.getExtracode2();
        uu.setUnitcode(sUintC);
        uu.setUsercode(sUC);
        uu.setUserstation("WEB");
        uu.setIsprimary("T");
        sysUserMgr.saveUserUnit(uu);
        return "registerSuccess";
    }

    public String renew() {
        try {

            sysUserMgr.renewObject(object);
            String underUnit = (String) request.getParameter("underUnit");
            SYS_OPT_LOG.log(
                    ((FUserinfo) this.getLoginUser()).getUsercode(),
                    object.getUsercode(),
                    "启用用户 ["
                            + CodeRepositoryUtil.getValue("usercode",
                                    object.getUsercode()) + " ]");
            if (underUnit == null)
                return SUCCESS;
            else
                return "underUnit";
        } catch (Exception e) {
            log.error(e.getMessage());
            this.saveError(e.getMessage());
            return EDIT;
        }

    }

    /*
     * private AddressBookManager addressBookManager; private AddressBook
     * addressBook;
     * 
     * public AddressBook getAddressBook() { return addressBook; }
     * 
     * public void setAddressBook(AddressBook addressBook) { this.addressBook =
     * addressBook; }
     * 
     * public void setAddressBookManager(AddressBookManager addressBookManager)
     * { this.addressBookManager = addressBookManager; }
     * 
     * public String editAddressBook() {
     * 
     * 
     * if (object.getAddrbookid()==null||object.getAddrbookid().equals(0L)) {
     * long id=addressBookManager.getNextAddressId(); addressBook=new
     * AddressBook(); addressBook.setAddrbookid(id);
     * addressBook.setBodycode(object.getUsercode());
     * addressBook.setBodytype("U");
     * addressBook.setRepresentation(object.getUsername());
     * object.setAddrbookid(id); sysUserMgr.saveObject(object);
     * addressBookManager.saveObject(addressBook); //关联的保存？？有问题了 }
     * 
     * FUserinfo dbobject = sysUserMgr.getObjectById(object.getUsercode());
     * object = dbobject; return "editAddressBook"; }
     */
    public FUserunit getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(FUserunit userUnit) {
        this.userUnit = userUnit;
    }

    public String getUnitsJson() {
        return unitsJson;
    }

    public void setUnitsJson(String unitsJson) {
        this.unitsJson = unitsJson;
    }

    protected HttpServletResponse response;

    @Override
    public void setServletResponse(HttpServletResponse response) {
        
        this.response = response;
    }

    /**
     * 弹出提示信息
     * 
     * @param msg
     * @param response
     */
    protected String postAlertMessage(String msg) throws IOException {

        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String str = "<script>" + "javascript:alert('" + msg
                + "');history.back(-1);" + " </script>";
        out.print(str);
        out.flush();
        out.close();
        return null;

    }
}
