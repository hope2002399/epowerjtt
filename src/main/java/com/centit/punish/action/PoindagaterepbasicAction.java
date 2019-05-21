package com.centit.punish.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.extremecomponents.table.limit.Limit;

import com.centit.core.utils.ExtremeTableUtils;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.powerbase.po.PcpunishStandard;
import com.centit.powerbase.service.PcfreeumpiredegreeManager;
import com.centit.powerbase.service.PcfreeumpiretypeManager;
import com.centit.powerbase.service.PcpunishStandardManager;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.powerruntime.po.OptIdeaInfo;
import com.centit.powerruntime.po.OptProcInfo;
import com.centit.powerruntime.po.OptStuffInfo;
import com.centit.powerruntime.po.VOrgSupPower;
import com.centit.punish.po.Poindagaterepbasic;
import com.centit.punish.po.PopunishbasicId;
import com.centit.punish.po.Poradixbasic;
import com.centit.punish.po.Potranslawbasic;
import com.centit.punish.po.PotranslawbasicId;
import com.centit.punish.po.Punishobjectbasic;
import com.centit.punish.po.VFDatadicpunishbasic;
import com.centit.punish.service.PcdefManager;
import com.centit.punish.service.PctypeManager;
import com.centit.punish.service.PoindagaterepbasicManager;
import com.centit.punish.service.PopunishbasicManager;
import com.centit.punish.service.PoradixbasicManager;
import com.centit.punish.service.PotranslawbasicManager;
import com.centit.punish.service.PunishobjectbasicManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.security.FUserDetail;
import com.centit.sys.service.CodeRepositoryUtil;
import com.centit.sys.service.DictionaryManager;
import com.centit.workflow.sample.po.VNodeInstDetail;

public class PoindagaterepbasicAction extends
        PunishCommonBizAction<Poindagaterepbasic> {

    private static final Log log = LogFactory
            .getLog(PoindagaterepbasicAction.class);
    private static final long serialVersionUID = 1L;
    private PoindagaterepbasicManager poindagaterepbasicMag;
    private String punishobjectid;
    private String djId;
    private String nodename;
    private String ideacode;
    private OptIdeaInfo optideainfo;
    private List<Potranslawbasic> listtranslaw;
    private List<PcpunishStandard> listpctype;
    private List<Pcfreeumpiretype> listfreeumprie;
    private File poindagaterepreportdoc_;
    private String poindagaterepreportdoc_FileName;

    private List<Potranslawbasic> punishlist;
    private List<VFDatadicpunishbasic> punishalllist;

    // private Pcdef pcdef;
    private VOrgSupPower vorgsuppower;
    private String punishway;// 处罚方式
    private String pagedegreeno;// optpunishopinion.jsp中需要用到的一个全局变量
    private String amercecode;
    private String shutoutcode;
    private String detentioncode;
    private String selFreeUmpire;
    private String poneatencontent;
    private String discusstype;
    private String podeportationdepname;
    private String remark;
    private String[] poquashreason;
    private String otherreason;
    private String poarbitrationcontent;
    private PcfreeumpiredegreeManager pcFreeUmpireDegreeManager;
    private PcfreeumpiretypeManager pcFreeUmpireTypeManager;
    private PopunishbasicManager poPunishBasicManager;
    private PunishobjectbasicManager punishObjectBasicManager;
    private PoradixbasicManager poRadixBasicManager;
    private PctypeManager pcTypeManager;
    private PcpunishStandardManager pcpunishStandardManager;
    private DictionaryManager dictionaryManager;
    private String item_id;

    private String itemName;
    private String punishtypeid;
    private String degreeno;
    private String serial;
    private PotranslawbasicManager potranslawbasicManager;
    private PcdefManager pcdefManager;
    private String riskdesc;
    private String riskresult;
    private List<OptStuffInfo> optStuffs;
    private String teamRoles;
    private SuppowerManager suppowerManager;
    HttpServletResponse response;
    private List<VOrgSupPower> selectPowerList;
    private String itemType;

    /************************************* 流程步骤 ******************************************/
    // 调查取证页面
    public String inquireProof() {
        VNodeInstDetail o = super.getFlowManager().getVNodeInstDetailbyNode(
                curNodeInstId);
        nodename = o.getNodeName();

        String punishobjectid = object.getPunishobjectid();
        object = poindagaterepbasicMag.getObjectById(punishobjectid);

        if (object == null) {
            object = new Poindagaterepbasic();
            object.setPunishobjectid(punishobjectid);
        }
        initalOptProcInfo();
        return "inquireproof";
    }

    // 调查审核页面
    public String isProofResult() {
        VNodeInstDetail o = super.getFlowManager().getVNodeInstDetailbyNode(
                curNodeInstId);
        nodename = o.getNodeName();
        String ideacode = "";
        if (optProcInfo != null) {
            ideacode = optProcInfo.getIdeacode();
        }
        initalOptProcInfo();
        optProcInfo.setIdeacode(ideacode);

        Map<String, Object> filterMap = new HashMap<String, Object>();
        filterMap.put("punishobjectid", object.getPunishobjectid());
        listtranslaw = this.potranslawbasicManager.listObjects(filterMap);
        for (int i = 0; i < listtranslaw.size();) {
            Potranslawbasic potranslawbasic = (Potranslawbasic) listtranslaw
                    .get(i);
            FUserDetail loginInfo = (FUserDetail) getLoginUser();
            potranslawbasic.setvOrgSupPower(suppowerManager.getSupPowerInfo(
                    potranslawbasic.getItem_id(), loginInfo.getPrimaryUnit()));
            if (null != potranslawbasic.getvOrgSupPower().getVersion()) {
                Map<String, Object> filterMap2 = new HashMap<String, Object>();
                filterMap2.put("itemId", potranslawbasic.getItem_id());
                filterMap2.put("version", potranslawbasic.getvOrgSupPower()
                        .getVersion());
                potranslawbasic.setDegreelist(this.pcFreeUmpireDegreeManager
                        .listObjects(filterMap2));
                potranslawbasic.setTypelist(this.pcFreeUmpireTypeManager
                        .listObjects(filterMap2));
                potranslawbasic.setResult(this.poindagaterepbasicMag
                        .getPunishOpinion(object.getPunishobjectid(),
                                potranslawbasic.getItem_id()));
                i++;
            } else {
                listtranslaw.remove(i);
            }
        }
        if (listtranslaw != null && listtranslaw.size() >= 2) {
            // 2个或2个以上的处罚项目时，做出的最终处罚意见
            object.setPoindagaterepresult(this.poindagaterepbasicMag
                    .getIndagateRepResult(object.getPunishobjectid(),
                            "00000000"));
        }
        return "proofresult";
    }

    // 调查意见页面
    public String proofAuditing() {
        // extractFlowOptParam();
        object = poindagaterepbasicMag
                .getObjectById(object.getPunishobjectid());
        this.inquireProof();
        super.initalDocJson("违法行为调查报告", object.getPunishobjectid());
        // cftype初始化
        if (StringUtils.isNotBlank(object.getPoindagaterepstate())) {
            if ("0".equals(object.getPoindagaterepstate())) {
                optProcInfo.setCfType("1");
            } else {
                optProcInfo.setCfType("99999");
            }
        } else {
            optProcInfo.setCfType("1");
        }

        if (StringUtils.isNotBlank(super.getModuleCode())
                && !"null".equals(super.getModuleCode())) {
            // 初始化页面form对应的actionName、提交方法以及保存方法名
            super.initalGenneralOpt("poindagaterepbasic", "saveProofAuditing",
                    "saveOpt");
            super.generalOpt();
            // cftype初始化
            if (StringUtils.isNotBlank(object.getPoindagaterepstate())) {
                if ("0".equals(object.getPoindagaterepstate())) {
                    optProcInfo.setCfType("1");
                } else {
                    optProcInfo.setCfType("99999");
                }
            } else {
                optProcInfo.setCfType("1");
            }
            return "commonFrame";
        }
        return "inquireopinion";
    }

    // 调查取证提交
    public String saveInquireProof() {
        Poindagaterepbasic bean = poindagaterepbasicMag.getObjectById(object
                .getPunishobjectid());
        if (bean != null) {
            bean.copyNotNullProperty(object);
            object = bean;
        }

        object.setPoindagaterepstep(Long.parseLong("2"));
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        object.setJbr_dczj(CodeRepositoryUtil.getValue("usercode",
                loginInfo.getUsercode()));
        object.setJbrOption_dczj(optProcInfo.getTranscontent());
        object.setJbrOptiontime_dczj(new Date(System.currentTimeMillis()));

        super.setDjId(djId);
        poindagaterepbasicMag.saveObject(object);

        super.initalOptNewlyIdea((long) 0, "", (long) 6,
                "/punish/punishobjectbasic!punishBasicFrame.do?punishobjectid="
                        + object.getPunishobjectid());
        return super.submitOpt();
    }

    // 调查审核提交
    public String saveProofResult() {
        if (optProcInfo.getIdeacode().equals("T")
                && StringBaseOpt.isNvl(optProcInfo.getTransidea())) {
            optProcInfo.setTransidea("同意");
        }
        String punishobjectid = object.getPunishobjectid();
        Poindagaterepbasic bean = poindagaterepbasicMag
                .getObjectById(punishobjectid);
        if (bean != null) {
            bean.copyNotNullProperty(object);
            object = bean;
        }
        if (!StringUtils.isBlank(object.getPoindagaterepstate())
                && "T".equals(optProcInfo.getIdeacode())) {
            int state = Integer.parseInt(object.getPoindagaterepstate());
            switch (state) {
            case 0:
                optProcInfo.setTranscontent("建议处以行政处罚");
                break;
            case 1:
                optProcInfo.setTranscontent("建议处以行政整改");
                break;
            case 2:
                optProcInfo.setTranscontent("建议处以移交处理");
                break;
            case 3:
                optProcInfo.setTranscontent("建议处以撤销立案");
                break;
            }
        } else if ("B".equals(optProcInfo.getIdeacode())) {
            optProcInfo.setTranscontent("退回经办人");
        }
        if (poindagaterepreportdoc_ != null) {
            try {
                FileInputStream fis = new FileInputStream(
                        poindagaterepreportdoc_);
                if (fis != null) {
                    byte[] bbuf = null;
                    int len = fis.available();
                    bbuf = new byte[len];
                    fis.read(bbuf);
                    object.setPoindagaterepreportdoc(bbuf);
                    object.setPoindagaterepreportdocname(poindagaterepreportdoc_FileName);
                }
                fis.close();
            } catch (Exception e) {
                log.error(e, e.getCause());
                request.setAttribute("error", "调查取证文件上传出错，详见系统日志。");
                return ERROR;
            }
        }

        String result = "";
        if ("1".equals(object.getPoindagaterepstate())) {
            result = "建议将此案件退回当事人进行整改";
            object.setPoindagaterepcontent(poneatencontent);
            object.setPoindagaterepresult(result);
        } else if ("2".equals(object.getPoindagaterepstate())) {
            result = "建议将此案件移送" + podeportationdepname + "处理";
            object.setPoindagaterepcontent(remark);
            object.setPoindagaterepresult(result);
        } else if ("3".equals(object.getPoindagaterepstate())) {
            String poQuashReason = "";
            for (int i = 0; i < poquashreason.length; i++) {
                String tmp = poquashreason[i];
                String tmpName = "";
                if ("1".equals(tmp)) {
                    tmpName = "情节轻微且已改正";
                } else if ("2".equals(tmp)) {
                    tmpName = "违法事实不能成立";
                }
                if (!StringUtils.isBlank(tmpName)) {
                    if (StringUtils.isBlank(poQuashReason)) {
                        poQuashReason = tmpName;
                    } else {
                        poQuashReason = poQuashReason + "；" + tmpName;
                    }
                }
            }
            if (!StringUtils.isBlank(otherreason)) {

                if (StringUtils.isBlank(poQuashReason)) {
                    poQuashReason = otherreason;
                } else {
                    poQuashReason = poQuashReason + "；" + otherreason;
                }
            }
            result = "建议撤销立案";
            object.setPoindagaterepcontent(poQuashReason);
            object.setPoindagaterepresult(result);
        }
        // object.setPunishobjectid(djId);
        super.setDjId(djId);
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        object.setKs_dczj(CodeRepositoryUtil.getValue("usercode",
                loginInfo.getUsercode()));
        object.setKsOption_dczj(optProcInfo.getTranscontent());
        object.setKsOptiontime_dczj(new Date(System.currentTimeMillis()));
        String otherdisobeyitem = object.getDisobeyitem();
        object.setDisobeyitem(itemName + ";" + otherdisobeyitem);
        poindagaterepbasicMag.saveObject(object);

        super.initalOptNewlyIdea((long) 0, "", (long) 7,
                "/punish/poindagaterepbasic!viewInquireProof.do?punishobjectid="
                        + object.getPunishobjectid());

        return this.submitOpt();
    }

    // 调查意见
    public String saveProofAuditing() {
        String punishobjectid = object.getPunishobjectid();
        object = poindagaterepbasicMag.getObjectById(punishobjectid);

        if (object == null) {
            object = new Poindagaterepbasic();
            object.setPunishobjectid(punishobjectid);
        }
        object.setPunishobjectid(djId);
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        object.setFzr_dczj(CodeRepositoryUtil.getValue("usercode",
                loginInfo.getUsercode()));
        object.setFzrOption_dczj(optProcInfo.getTranscontent());
        object.setFzrOptiontime_dczj(new Date(System.currentTimeMillis()));
        poindagaterepbasicMag.saveObject(object);
        super.setDjId(djId);

        super.initalOptNewlyIdea((long) 1, "调查取证", (long) 8,
                "/punish/poindagaterepbasic!viewInquireProof.do?punishobjectid="
                        + object.getPunishobjectid() + "&nodeInstId="
                        + curNodeInstId);
        return this.submitOpt();
    }

    public void saveTeamRolepeople() {
        if (!StringUtils.isBlank(teamRoles)) {
            String[] teamRole = teamRoles.split(",");
            if (teamRole.length > 0) {
                for (String a : teamRole) {
                    flowEngine.assignFlowWorkTeam(super.getFlowInstId(),
                            "ajjbr", a);
                }
            }
        }
    }

    /********************************** 处罚决定步骤 ***************************************************/

    /**
     * 处罚决定步骤 - 页面选择违法程度
     * 
     * 根据自由裁量列表 获取初步处罚意见
     * 
     * @return
     */
    public String saveDegree() {
        // 第一步
        // updatePOTransLawBasic(punishObjectID,punishClassID, degreeNo);
        Punishobjectbasic checkclassnumoj = this.punishObjectBasicManager
                .getObjectById(object.getPunishobjectid());
        // 初始化punishobjectbasic中的punishclassnum的值
        if (checkclassnumoj.getPunishclassnum() == null) {
            checkclassnumoj.setPunishclassnum((long) 1);
            this.punishObjectBasicManager.saveObject(checkclassnumoj);
        }
        //
        this.potranslawbasicManager.updatePOTransLawBasic(
                object.getPunishobjectid(), item_id, degreeno);
        // 第二步
        // TranaLawSev.updatePunishObjectIsSurpass(punishObjectID);
        this.potranslawbasicManager.updatePunishObjectIsSurpass(object
                .getPunishobjectid());

        return isProofResult();
    }

    /**
     * 处罚决定步骤 - 处罚意见选择页面 -自由裁量标准 1、处罚项目名称、处罚方式说明(从处罚标准中取) 2、给出自由裁量标准 3、业务自己的实际处罚
     * 
     * @return
     */
    public String gavePunishOpinion() {
        // 和数据字典对应
        amercecode = this.poRadixBasicManager.getDataCodeFromFdic("punishType",
                "3");// 罚款datacode
        shutoutcode = this.poRadixBasicManager.getDataCodeFromFdic(
                "punishType", "6");// 停业整顿datacode
        detentioncode = this.poRadixBasicManager.getDataCodeFromFdic(
                "punishType", "7");// 行政拘留datacode
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        if (!"00000000".equals(item_id)) {
            // 根据已知关联部门获取权力信息,其中带着版本
            vorgsuppower = suppowerManager.getSupPowerInfo(item_id,
                    loginInfo.getPrimaryUnit());

            if (!StringUtils.isBlank(degreeno) && !"-2".equals(degreeno)) {
                // 自由裁量标准参考
                listfreeumprie = this.poindagaterepbasicMag
                        .getFreeUmpireBZList(item_id,
                                vorgsuppower.getVersion(), degreeno);
            }

            listpctype = pcpunishStandardManager.listPcTypeInUse(item_id,
                    vorgsuppower.getVersion());// 根据权力编码取出所有对应pcpunishStandard

            if (listfreeumprie != null && listfreeumprie.size() > 0) {
                for (Pcfreeumpiretype o : listfreeumprie) {
                    if (null != o.getIsinuse()
                            && "1".equals(o.getIsinuse().toString())) {
                        pagedegreeno = o.getDegreeno().toString();
                    }
                }
            }
            if (listpctype != null && listpctype.size() > 0) {
                for (PcpunishStandard o : listpctype) {
                    // 获取每项处罚项，如果已经设置过的话；
                    PopunishbasicId cid = new PopunishbasicId(
                            object.getPunishobjectid(), o.getPunishtypeid(),
                            item_id);
                    o.setPopunishbasic(this.poPunishBasicManager
                            .getObjectById(cid));
                    // 获取对应基数的项，如果已经设置过的话；
                    Poradixbasic poradixbasic = poRadixBasicManager
                            .getRadixBasicByPunishobjectid(object
                                    .getPunishobjectid());
                    o.setPoradixbasic(poradixbasic);
                }
            }
            // 获取处罚标准处罚方式
            punishway = pcpunishStandardManager.getpunishItemType(
                    object.getPunishobjectid(), item_id,
                    vorgsuppower.getVersion());
            return "punishinfo";
        } else {
            punishlist = this.poindagaterepbasicMag.getPunishListByID(object
                    .getPunishobjectid());
            for (Potranslawbasic o : punishlist) {
                o.setvOrgSupPower(suppowerManager.getSupPowerInfo(
                        o.getItem_id(), loginInfo.getPrimaryUnit()));
            }
            List<FDatadictionary> fdatadiclist = this.dictionaryManager
                    .findByCdtbnm("punishType");// 列出所有处罚类型

            for (FDatadictionary o : fdatadiclist) {
                PopunishbasicId cid = new PopunishbasicId(
                        object.getPunishobjectid(), o.getDatacode(), item_id);
                VFDatadicpunishbasic retobj = new VFDatadicpunishbasic();
                retobj.copyNotNullPropertyFromFDataDic(o);
                retobj.setPopunishbasic(this.poPunishBasicManager
                        .getObjectById(cid));// 将已做出处罚意见的对应punishtype塞入数据
                if (punishalllist == null) {
                    punishalllist = new ArrayList<VFDatadicpunishbasic>();
                }
                punishalllist.add(retobj);
            }
            return "allpunishinfo";
        }
    }

    /**
     * 处罚决定步骤 - 处罚意见选择页面 -自由裁量标准 用户根据业务需要确定处罚意见后，保持对应的处罚意见
     * 
     * @return
     */
    public String savepunishinfo() {
        String isSurpass = "";
        String FreeUmpire[] = selFreeUmpire.split(",");
        if (!StringUtils.isBlank(degreeno) && !"-2".equals(degreeno)) {
            isSurpass = this.potranslawbasicManager.isSurpassFreeUmpire(
                    item_id, Long.parseLong(object.getVersion()), degreeno,
                    FreeUmpire);
        } else {
            isSurpass = "0";
        }
        this.potranslawbasicManager.insertpunishBasicInfo(
                object.getPunishobjectid(), item_id, FreeUmpire, degreeno,
                isSurpass, "", "", "");
        this.potranslawbasicManager.updatePunishObjectIsSurpass(object
                .getPunishobjectid());
        return this.isProofResult();

    }

    /**
     * 添加处罚项目，选择处罚权力页面
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    public String addpunishlist() {
        if (StringUtils.isBlank(punishobjectid)) {
            punishobjectid = object.getPunishobjectid();
        }
        Map<Object, Object> paramMap = request.getParameterMap();
        resetPageParam(paramMap);
        Map<String, Object> filterMap = convertSearchColumn(paramMap);
        Limit limit = ExtremeTableUtils.getLimit(request);
        PageDesc pageDesc = ExtremeTableUtils.makePageDesc(limit);
        selectPowerList = suppowerManager.listOrgSuppower(filterMap, pageDesc);
        totalRows = pageDesc.getTotalRows();
        return "punishlist";
    }

    /**
     * 保存处罚项目类别
     * 
     * @return
     */
    public String saveTransLaw() {
        // 第一步：保存案件违法事实信息表POTRANSLAWBASIC
        Potranslawbasic saveobject = new Potranslawbasic();
        PotranslawbasicId cid = new PotranslawbasicId();
        cid.setPunishobjectid(object.getPunishobjectid());
        cid.setItem_id(item_id);
        if (degreeno != null && degreeno != "") {
            saveobject.setDegreeno(Long.parseLong(degreeno));
        }
        saveobject.setCid(cid);
        this.potranslawbasicManager.saveObject(saveobject);
        // 第二步:将punishobjectbasic表中的punishclassnum增加1;
        // 更新处罚项目种类数量
        punishObjectBasicManager.updatepunishNum(object.getPunishobjectid(),
                "add");
        // 第三步:更改PORADIXBASIC表,老系统是存储过程
        this.poRadixBasicManager.initRadixBasic(object.getPunishobjectid(),
                item_id);
        return isProofResult();
    }

    /**
     * 删除处罚类型项目
     * 
     * @return
     */
    public String deletePunishClass() {
        // 删除动作
        this.potranslawbasicManager.deletePunishClass(
                object.getPunishobjectid(), item_id);

        // 修改PUNISHOBJECTBASIC中的punishclassnum字段 -1
        this.punishObjectBasicManager.updatepunishNum(
                object.getPunishobjectid(), "del");
        return isProofResult();
    }

    public String showPunishOpinion2() {
        amercecode = this.poRadixBasicManager.getDataCodeFromFdic("punishType",
                "3");
        shutoutcode = this.poRadixBasicManager.getDataCodeFromFdic(
                "punishType", "6");
        detentioncode = this.poRadixBasicManager.getDataCodeFromFdic(
                "punishType", "7");
        FUserDetail loginInfo = (FUserDetail) getLoginUser();
        if (!"00000000".equals(item_id)) {
            // 根据已知关联部门获取权力信息,其中带着版本
            vorgsuppower = suppowerManager.getSupPowerInfo(item_id,
                    loginInfo.getPrimaryUnit());

            if (!StringUtils.isBlank(degreeno) && !"-2".equals(degreeno)) {
                // 自由裁量标准参考
                listfreeumprie = this.poindagaterepbasicMag
                        .getFreeUmpireBZList(item_id,
                                vorgsuppower.getVersion(), degreeno);
            }

            listpctype = pcpunishStandardManager.listPcTypeInUse(item_id,
                    vorgsuppower.getVersion());// 根据权力编码取出所有对应pcpunishStandard

            if (listfreeumprie != null && listfreeumprie.size() > 0) {
                for (Pcfreeumpiretype o : listfreeumprie) {
                    if (null != o.getIsinuse()
                            && "1".equals(o.getIsinuse().toString())) {
                        pagedegreeno = o.getDegreeno().toString();
                    }
                }
            }

            if (listpctype != null && listpctype.size() > 0) {
                for (PcpunishStandard o : listpctype) {
                    // 获取每项处罚项，如果已经设置过的话；
                    PopunishbasicId cid = new PopunishbasicId(
                            object.getPunishobjectid(), o.getPunishtypeid(),
                            item_id);
                    o.setPopunishbasic(this.poPunishBasicManager
                            .getObjectById(cid));
                    // 获取对应基数的项，如果已经设置过的话；
                    Poradixbasic poradixbasic = poRadixBasicManager
                            .getRadixBasicByPunishobjectid(object
                                    .getPunishobjectid());
                    o.setPoradixbasic(poradixbasic);
                }
            }
            punishway = pcpunishStandardManager.getpunishItemType(
                    object.getPunishobjectid(), item_id,
                    vorgsuppower.getVersion());

            return "punishinfo2";
        } else {
            punishlist = this.poindagaterepbasicMag.getPunishListByID(object
                    .getPunishobjectid());
            for (Potranslawbasic o : punishlist) {
                o.setvOrgSupPower(suppowerManager.getSupPowerInfo(
                        o.getItem_id(), loginInfo.getPrimaryUnit()));
            }
            List<FDatadictionary> fdatadiclist = this.dictionaryManager
                    .findByCdtbnm("punishType");// 列出所有处罚类型

            for (FDatadictionary o : fdatadiclist) {
                PopunishbasicId cid = new PopunishbasicId(
                        object.getPunishobjectid(), o.getDatacode(), item_id);
                VFDatadicpunishbasic retobj = new VFDatadicpunishbasic();
                retobj.copyNotNullPropertyFromFDataDic(o);
                retobj.setPopunishbasic(this.poPunishBasicManager
                        .getObjectById(cid));// 将已做出处罚意见的对应punishtype塞入数据
                if (punishalllist == null) {
                    punishalllist = new ArrayList<VFDatadicpunishbasic>();
                }
                punishalllist.add(retobj);
            }
            return "allpunishinfo2";
        }

    }

    public String viewInquireProof() {
        object = this.poindagaterepbasicMag.getObjectById(object
                .getPunishobjectid());
        if (curNodeInstId != null) {
            if (optProcInfo == null) {
                optProcInfo = new OptProcInfo();
            }
            optProcInfo.setDjId(object.getPunishobjectid());
            optProcInfo.setNodeInstId(curNodeInstId);
            optStuffs = super.optProcInfoManager.getStuffInfoList(optProcInfo);
        }
        return "viewinquireproof";
    }

    public String doAjax() throws IOException {
        String responseText = "";
        responseText = "[{a:1},{b:2}]";
        response.getWriter().write(responseText);
        return null;
    }

    /**
     * 处罚决定步骤 - 处罚意见选择页面 旧的
     * 
     * @return
     */
    /*
     * public String showPunishOpinion() { amercecode =
     * this.poRadixBasicManager.
     * getDataCodeFromFdic("punishType","3");//CodeRepositoryUtil
     * .getValue("punishType","3");// 罚款datacode shutoutcode =
     * this.poRadixBasicManager
     * .getDataCodeFromFdic("punishType","6");//CodeRepositoryUtil
     * .getValue("punishType","6");// 停业整顿datacode detentioncode =
     * this.poRadixBasicManager
     * .getDataCodeFromFdic("punishType","7");//CodeRepositoryUtil
     * .getValue("punishType","7");//行政拘留datacode
     * 
     * if (!"00000000".equals(item_id)) { FUserDetail loginInfo = (FUserDetail)
     * getLoginUser(); // 根据已知关联部门获取权力信息,其中带着版本
     * vorgsuppower=suppowerManager.getSupPowerInfo(item_id,
     * loginInfo.getPrimaryUnit());
     * 
     * if (!StringUtils.isBlank(degreeno) && !"-2".equals(degreeno)) {
     * //自由裁量标准参考 //listfreeumprie= listfreeumprie =
     * this.poindagaterepbasicMag.getFreeUmpireList
     * (object.getPunishobjectid(),item_id
     * ,vorgsuppower.getVersion(),Long.parseLong(degreeno)); }
     * 
     * listpctype = this.pcTypeManager.listPcTypeInUse(item_id);//
     * 根据punishclassid取出所有对应pctype
     * 
     * if(listfreeumprie!=null && listfreeumprie.size()>0){ for
     * (Pcfreeumpiretype o : listfreeumprie) { if (null != o.getIsinuse() &&
     * "1".equals(o.getIsinuse().toString())) { pagedegreeno =
     * o.getDegreeno().toString(); } } } if(listpctype!=null &&
     * listpctype.size()>0){ for (Pctype o : listpctype) { PopunishbasicId cid =
     * new PopunishbasicId(object.getPunishobjectid(),
     * o.getPunishtypeid(),item_id);
     * o.setPopunishbasic(this.poPunishBasicManager.getObjectById(cid));
     * o.setDegreeforpage(degreeno); if (null != o.getIsrate() &&
     * "1".equals(o.getIsrate().toString())) { pagedegreeno = "0"; } else if
     * (null != o.getIsrate() && !"1".equals(o.getIsrate().toString())) { if
     * (!StringUtils.isBlank(pagedegreeno)) { if
     * (this.pcFreeUmpireTypeManager.ifHavePCFreeUmpireTypeRate
     * (o.getPunishtypeid(), pagedegreeno)) { o.setFreeisrate("1"); } } } if
     * (null != o.getPopunishbasic()) { if (o.getIsrate() == 1 || (o.getIsrate()
     * != 1 && "1".equals(o .getFreeisrate()))) { if
     * ("#".equals(o.getPopunishbasic().getPunishvalue())) {
     * o.getPopunishbasic().setPunishvalue(""); }
     * o.setPoradixbasic(this.poRadixBasicManager
     * .getRadixBasic(object.getPunishobjectid(), o.getPunishtypeid(),
     * o.getPunishclassid())); }
     * 
     * }
     * o.setPunishname(this.poRadixBasicManager.getDatavalueFromFdic("punishType"
     * , o.getPunishtypeid()));// 放入处罚名称 } } punishway =
     * this.pcdefManager.getpunishItemType(object.getPunishobjectid(), item_id);
     * return "punishinfo"; } else { punishlist =
     * this.poindagaterepbasicMag.getPunishListByID(object.getPunishobjectid());
     * for (Potranslawbasic o : punishlist) {
     * //o.setPcdef(this.pcdefManager.getObjectById(o.getItem_id())); }
     * List<FDatadictionary> fdatadiclist =
     * this.dictionaryManager.findByCdtbnm("punishType");// 列出所有处罚类型
     * 
     * for (FDatadictionary o : fdatadiclist) { PopunishbasicId cid = new
     * PopunishbasicId(object.getPunishobjectid(), o.getDatacode(),item_id);
     * VFDatadicpunishbasic retobj = new VFDatadicpunishbasic();
     * retobj.copyNotNullPropertyFromFDataDic(o);
     * retobj.setPopunishbasic(this.poPunishBasicManager.getObjectById(cid));//
     * 将已做出处罚意见的对应punishtype塞入数据 if (punishalllist == null) { punishalllist =
     * new ArrayList<VFDatadicpunishbasic>(); } punishalllist.add(retobj); }
     * return "allpunishinfo"; } }
     */
    /************************ getter()\setter() ********************************************/
    public String getDiscusstype() {
        return discusstype;
    }

    public void setDiscusstype(String discusstype) {
        this.discusstype = discusstype;
    }

    public List<OptStuffInfo> getOptStuffs() {
        return optStuffs;
    }

    public void setOptStuffs(List<OptStuffInfo> optStuffs) {
        this.optStuffs = optStuffs;
    }

    public DictionaryManager getDictionaryManager() {
        return dictionaryManager;
    }

    public void setDictionaryManager(DictionaryManager dictionaryManager) {
        this.dictionaryManager = dictionaryManager;
    }

    public String getTeamRoles() {
        return teamRoles;
    }

    public void setTeamRoles(String teamRoles) {
        this.teamRoles = teamRoles;
    }

    public String getPoindagaterepreportdoc_FileName() {
        return poindagaterepreportdoc_FileName;
    }

    public void setPoindagaterepreportdoc_FileName(
            String poindagaterepreportdoc_FileName) {
        this.poindagaterepreportdoc_FileName = poindagaterepreportdoc_FileName;
    }

    public File getPoindagaterepreportdoc_() {
        return poindagaterepreportdoc_;
    }

    public void setPoindagaterepreportdoc_(File poindagaterepreportdoc_) {
        this.poindagaterepreportdoc_ = poindagaterepreportdoc_;
    }

    public List<Potranslawbasic> getPunishlist() {
        return punishlist;
    }

    public void setPunishlist(List<Potranslawbasic> punishlist) {
        this.punishlist = punishlist;
    }

    public List<VFDatadicpunishbasic> getPunishalllist() {
        return punishalllist;
    }

    public void setPunishalllist(List<VFDatadicpunishbasic> punishalllist) {
        this.punishalllist = punishalllist;
    }

    public String getPodeportationdepname() {
        return podeportationdepname;
    }

    public void setPodeportationdepname(String podeportationdepname) {
        this.podeportationdepname = podeportationdepname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String[] getPoquashreason() {
        return poquashreason;
    }

    public void setPoquashreason(String[] poquashreason) {
        this.poquashreason = poquashreason;
    }

    public String getOtherreason() {
        return otherreason;
    }

    public void setOtherreason(String otherreason) {
        this.otherreason = otherreason;
    }

    public String getPoarbitrationcontent() {
        return poarbitrationcontent;
    }

    public void setPoarbitrationcontent(String poarbitrationcontent) {
        this.poarbitrationcontent = poarbitrationcontent;
    }

    public String getPoneatencontent() {
        return poneatencontent;
    }

    public void setPoneatencontent(String poneatencontent) {
        this.poneatencontent = poneatencontent;
    }

    public String getSelFreeUmpire() {
        return selFreeUmpire;
    }

    public void setSelFreeUmpire(String selFreeUmpire) {
        this.selFreeUmpire = selFreeUmpire;
    }

    public String getAmercecode() {
        return amercecode;
    }

    public void setAmercecode(String amercecode) {
        this.amercecode = amercecode;
    }

    public String getShutoutcode() {
        return shutoutcode;
    }

    public void setShutoutcode(String shutoutcode) {
        this.shutoutcode = shutoutcode;
    }

    public String getDetentioncode() {
        return detentioncode;
    }

    public void setDetentioncode(String detentioncode) {
        this.detentioncode = detentioncode;
    }

    public String getPagedegreeno() {
        return pagedegreeno;
    }

    public void setPagedegreeno(String pagedegreeno) {
        this.pagedegreeno = pagedegreeno;
    }

    public String getPunishway() {
        return punishway;
    }

    public void setPunishway(String punishway) {
        this.punishway = punishway;
    }

    public PoradixbasicManager getPoRadixBasicManager() {
        return poRadixBasicManager;
    }

    public void setPoRadixBasicManager(PoradixbasicManager poRadixBasicManager) {
        this.poRadixBasicManager = poRadixBasicManager;
    }

    public PunishobjectbasicManager getPunishObjectBasicManager() {
        return punishObjectBasicManager;
    }

    public void setPunishObjectBasicManager(
            PunishobjectbasicManager punishObjectBasicManager) {
        this.punishObjectBasicManager = punishObjectBasicManager;
    }

    public void setPcTypeManager(PctypeManager pcTypeManager) {
        this.pcTypeManager = pcTypeManager;
    }

    public PoindagaterepbasicManager getPoindagaterepbasicMag() {
        return poindagaterepbasicMag;
    }

    public void setPoindagaterepbasicMag(
            PoindagaterepbasicManager poindagaterepbasicMag) {
        this.poindagaterepbasicMag = poindagaterepbasicMag;
    }

    public PcfreeumpiredegreeManager getPcFreeUmpireDegreeManager() {
        return pcFreeUmpireDegreeManager;
    }

    public PcfreeumpiretypeManager getPcFreeUmpireTypeManager() {
        return pcFreeUmpireTypeManager;
    }

    public PotranslawbasicManager getPotranslawbasicManager() {
        return potranslawbasicManager;
    }

    public PcdefManager getPcdefManager() {
        return pcdefManager;
    }

    public PctypeManager getPcTypeManager() {
        return pcTypeManager;
    }

    public List<Pcfreeumpiretype> getListfreeumprie() {
        return listfreeumprie;
    }

    public void setListfreeumprie(List<Pcfreeumpiretype> listfreeumprie) {
        this.listfreeumprie = listfreeumprie;
    }

    public String getDegreeno() {
        return degreeno;
    }

    public void setDegreeno(String degreeno) {
        this.degreeno = degreeno;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getDjId() {
        return djId;
    }

    public String getPunishtypeid() {
        return punishtypeid;
    }

    public void setPunishtypeid(String punishtypeid) {
        this.punishtypeid = punishtypeid;
    }

    public PopunishbasicManager getPoPunishBasicManager() {
        return poPunishBasicManager;
    }

    public void setPoPunishBasicManager(
            PopunishbasicManager poPunishBasicManager) {
        this.poPunishBasicManager = poPunishBasicManager;
    }

    public void setPcdefManager(PcdefManager pcdefManager) {
        this.pcdefManager = pcdefManager;
    }

    public void setPotranslawbasicManager(
            PotranslawbasicManager potranslawbasicManager) {
        this.potranslawbasicManager = potranslawbasicManager;
    }

    public List<Potranslawbasic> getListtranslaw() {
        return listtranslaw;
    }

    public void setListtranslaw(List<Potranslawbasic> listtranslaw) {
        this.listtranslaw = listtranslaw;
    }

    public OptIdeaInfo getOptideainfo() {
        return optideainfo;
    }

    public void setOptideainfo(OptIdeaInfo optideainfo) {
        this.optideainfo = optideainfo;
    }

    public String getRiskdesc() {
        return riskdesc;
    }

    public void setRiskdesc(String riskdesc) {
        this.riskdesc = riskdesc;
    }

    public String getRiskresult() {
        return riskresult;
    }

    public void setRiskresult(String riskresult) {
        this.riskresult = riskresult;
    }

    public String getIdeacode() {
        return ideacode;
    }

    public void setIdeacode(String ideacode) {
        this.ideacode = ideacode;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public void setDjId(String djid) {
        this.djId = djid;
    }

    public String getPunishobjectid() {
        return punishobjectid;
    }

    public void setPunishobjectid(String punishobjectid) {
        this.punishobjectid = punishobjectid;
    }

    public void setPoindagaterepbasicManager(PoindagaterepbasicManager basemgr) {
        poindagaterepbasicMag = basemgr;
        this.setBaseEntityManager(poindagaterepbasicMag);
    }

    public void setPcFreeUmpireDegreeManager(
            PcfreeumpiredegreeManager pcFreeUmpireDegreeManager) {
        this.pcFreeUmpireDegreeManager = pcFreeUmpireDegreeManager;
    }

    public void setPcFreeUmpireTypeManager(
            PcfreeumpiretypeManager pcFreeUmpireTypeManager) {
        this.pcFreeUmpireTypeManager = pcFreeUmpireTypeManager;
    }

    public void setSuppowerManager(SuppowerManager suppowerManager) {
        this.suppowerManager = suppowerManager;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public VOrgSupPower getVorgsuppower() {
        return vorgsuppower;
    }

    public void setVorgsuppower(VOrgSupPower vorgsuppower) {
        this.vorgsuppower = vorgsuppower;
    }

    public void setPcpunishStandardManager(
            PcpunishStandardManager pcpunishStandardManager) {
        this.pcpunishStandardManager = pcpunishStandardManager;
    }

    public List<PcpunishStandard> getListpctype() {
        return listpctype;
    }

    public void setListpctype(List<PcpunishStandard> listpctype) {
        this.listpctype = listpctype;
    }

    public List<VOrgSupPower> getSelectPowerList() {
        return selectPowerList;
    }

    public void setSelectPowerList(List<VOrgSupPower> selectPowerList) {
        this.selectPowerList = selectPowerList;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

}
