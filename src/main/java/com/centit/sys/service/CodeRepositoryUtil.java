package com.centit.sys.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.centit.core.utils.LabelValueBean;
import com.centit.powerbase.po.Suppower;
import com.centit.powerbase.po.Zf_power;
import com.centit.support.compiler.Lexer;
import com.centit.support.utils.Algorithm;
import com.centit.support.utils.Algorithm.ParentChild;
import com.centit.sys.po.FDatadictionary;
import com.centit.sys.po.FOptdef;
import com.centit.sys.po.FOptinfo;
import com.centit.sys.po.FRoleinfo;
import com.centit.sys.po.FUnitinfo;
import com.centit.sys.po.FUserinfo;
import com.centit.sys.po.FUserunit;
import com.centit.sys.security.FUserDetail;

public class CodeRepositoryUtil {
    public static final Integer MAXXZRANK = 100000;
    private static WebApplicationContext ctx = ContextLoaderListener
            .getCurrentWebApplicationContext();

    public static final String getValue(String sCatalog, String sKey) {
        try {

            if (sCatalog.equalsIgnoreCase("usercode"))
                return CodeRepositoryManager.USERREPO.get(sKey).getUsername();
            if (sCatalog.equalsIgnoreCase("loginName"))
                return CodeRepositoryManager.LOGINEPO.get(sKey).getUsername();
            if (sCatalog.equalsIgnoreCase("unitcode"))
                return CodeRepositoryManager.UNITREPO.get(sKey).getUnitname();

            if (sCatalog.equalsIgnoreCase("depno"))
                return CodeRepositoryManager.DEPNO.get(sKey).getUnitname();
            if (sCatalog.equalsIgnoreCase("suppowerId"))
                return CodeRepositoryManager.SUPPOWERREPO.get(sKey)
                        .getItemName();
            if (sCatalog.equalsIgnoreCase("Zf_powerid"))
                return CodeRepositoryManager.ZFPOWERREPO.get(sKey)
                        .getItemName();
            if (sCatalog.equalsIgnoreCase("rolecode"))
                return CodeRepositoryManager.ROLEREPO.get(sKey).getRolename();

            if (sCatalog.equalsIgnoreCase("optid"))
                return CodeRepositoryManager.OPTREPO.get(sKey).getOptname();

            if (sCatalog.equalsIgnoreCase("optcode"))
                return CodeRepositoryManager.POWERREPO.get(sKey).getOptname();

            if (sCatalog.equalsIgnoreCase("optdesc")) {
                FOptdef optdef = CodeRepositoryManager.POWERREPO.get(sKey);
                return CodeRepositoryManager.OPTREPO.get(optdef.getOptid())
                        .getOptname() + "-" + optdef.getOptname();
            }
            /*
             * if(sCatalog.equalsIgnoreCase("YES_NO")) return
             * CodeRepositoryManager.YES_NO.get(sKey);
             * if(sCatalog.equalsIgnoreCase("USE_STATE")) return
             * CodeRepositoryManager.USE_STATE.get(sKey);
             */

            FDatadictionary dictPiece = getDataPiece(sCatalog, sKey);
            if (dictPiece == null)
                return sKey;

            return dictPiece.toString();
        } catch (Exception e) {
            return sKey;
        }
    }

    public static Map<String, FUnitinfo> getUnitRepo() {
        return ctx.getBean("sysUnitManagerImpl", SysUnitManager.class)
                .listObjectToUnitRepo();
    }

    public static final String getCode(String sCatalog, String sValue) {
        if (sValue == null || "".equals(sValue))
            return "";
        try {

            if (sCatalog.equalsIgnoreCase("usercode")) {
                for (Map.Entry<String, FUserinfo> ent : CodeRepositoryManager.USERREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getUsername()))
                        return ent.getKey();
                }
                return sValue;
            }
            if (sCatalog.equalsIgnoreCase("loginName")) {
                for (Map.Entry<String, FUserinfo> ent : CodeRepositoryManager.LOGINEPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getUsername()))
                        return ent.getKey();
                }
                return sValue;
            }

            if (sCatalog.equalsIgnoreCase("unitcode")) {
                for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getUnitname()))
                        return ent.getKey();
                }
                return sValue;
            }

            if (sCatalog.equalsIgnoreCase("depno")) {
                for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getUnitname()))
                        return ent.getValue().getDepno();
                }
                return sValue;
            }
            // return CodeRepositoryManager.DEPNO.get(sKey).getUnitname();

            if (sCatalog.equalsIgnoreCase("rolecode")) {
                for (Map.Entry<String, FRoleinfo> ent : CodeRepositoryManager.ROLEREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getRolename()))
                        return ent.getKey();
                }
                return sValue;
            }

            if (sCatalog.equalsIgnoreCase("optid")) {
                for (Map.Entry<String, FOptinfo> ent : CodeRepositoryManager.OPTREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getOptname()))
                        return ent.getKey();
                }
                return sValue;
            }

            if (sCatalog.equalsIgnoreCase("optcode")) {
                for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                        .entrySet()) {
                    if (sValue.equals(ent.getValue().getOptname()))
                        return ent.getKey();
                }
                return sValue;
            }

            /*
             * if(sCatalog.equalsIgnoreCase("YES_NO")) return
             * CodeRepositoryManager.YES_NO.get(sKey);
             * if(sCatalog.equalsIgnoreCase("USE_STATE")) return
             * CodeRepositoryManager.USE_STATE.get(sKey);
             */

            FDatadictionary dictPiece = getDataPieceByValue(sCatalog, sValue);
            if (dictPiece == null)
                return sValue;

            return dictPiece.getDatacode();

        } catch (Exception e) {
            return sValue;
        }
    }

    public static final String transExpression(String sCatalog,
            String sExpression) {
        StringBuilder sb = new StringBuilder();
        Lexer lex = new Lexer();
        lex.setFormula(sExpression);

        while (true) {
            String aWord = lex.getAWord();
            if (aWord == null || "".equals(aWord))
                break;
            aWord = getValue(sCatalog, aWord);
            sb.append(aWord);
        }

        return sb.toString();
    }

    public static final String getItemState(String sCatalog, String sKey) {
        try {
            if (sCatalog.equalsIgnoreCase("usercode"))
                return CodeRepositoryManager.USERREPO.get(sKey).getIsvalid();
            if (sCatalog.equalsIgnoreCase("loginName"))
                return CodeRepositoryManager.LOGINEPO.get(sKey).getIsvalid();
            if (sCatalog.equalsIgnoreCase("unitcode"))
                return CodeRepositoryManager.UNITREPO.get(sKey).getIsvalid();

            if (sCatalog.equalsIgnoreCase("rolecode"))
                return CodeRepositoryManager.ROLEREPO.get(sKey).getIsvalid();

            FDatadictionary dictPiece = getDataPiece(sCatalog, sKey);
            if (dictPiece == null)
                return "";

            return dictPiece.getState();
        } catch (Exception e) {
            return sKey;
        }
    }

    public static final List<FOptinfo> getOptinfoList(String sOptType) {
        List<FOptinfo> optList = new ArrayList<FOptinfo>();
        for (Map.Entry<String, FOptinfo> ent : CodeRepositoryManager.OPTREPO
                .entrySet()) {
            FOptinfo value = ent.getValue();
            if (sOptType.equals("P")) {
                if ((!"W".equals(value.getOpttype()))
                        && getOptDefByOptID(value.getOptid()).size() > 0)
                    optList.add(value);
            } else if (sOptType.equals("R")) {
                if (!"W".equals(value.getOpttype()))
                    optList.add(value);
            } else if (sOptType.equals("A")
                    || sOptType.equals(value.getOpttype()))
                optList.add(value);
        }

        Collections.sort(optList, new Comparator<FOptinfo>() {
            public int compare(FOptinfo o1, FOptinfo o2) {
                if (o2.getOrderind() == null)
                    return 1;
                if (o1.getOrderind() == null)
                    return 0;
                if (o1.getOrderind() > o2.getOrderind())
                    return 1;
                return 0;
            }
        });

        return optList;
    }

    public static final List<FOptdef> getOptdefList() {
        List<FOptdef> optdefList = new ArrayList<FOptdef>();
        for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                .entrySet()) {
            FOptdef value = ent.getValue();
            optdefList.add(value);
        }
        return optdefList;
    }

    public static final List<FOptdef> getOptDefByOptID(String sOptID) {
        List<FOptdef> optList = new ArrayList<FOptdef>();
        for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                .entrySet()) {
            FOptdef value = ent.getValue();
            if (sOptID.equals(value.getOptid()))
                optList.add(value);
        }
        return optList;
    }

    public static final List<FOptdef> getOptDefByIsFlow(String isInFlow) {
        List<FOptdef> optList = new ArrayList<FOptdef>();
        for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                .entrySet()) {
            FOptdef value = ent.getValue();
            if (isInFlow.equals(value.getIsinworkflow()))
                optList.add(value);
        }
        return optList;
    }

    public static final List<FRoleinfo> getRoleinfoList(String sPrefix) {
        List<FRoleinfo> roleList = new ArrayList<FRoleinfo>();
        for (Map.Entry<String, FRoleinfo> ent : CodeRepositoryManager.ROLEREPO
                .entrySet()) {
            FRoleinfo value = ent.getValue();
            if (value.getRolecode().startsWith(sPrefix)
                    && "T".equals(value.getIsvalid())) {
                roleList.add(value);
            }
        }
        return roleList;
    }

    public static final List<FUserinfo> getAllUsers(String sState) {
        List<FUserinfo> users = new ArrayList<FUserinfo>();

        for (Map.Entry<String, FUserinfo> ent : CodeRepositoryManager.USERREPO
                .entrySet()) {
            FUserinfo value = ent.getValue();
            if ("A".equals(sState) || sState.equals(value.getIsvalid()))
                users.add(value);
        }
        return users;
    }

    public static final List<FUserinfo> getSortedPrimaryUnitUsers(
            String unitCode) {
        List<FUserinfo> users = new ArrayList<FUserinfo>();

        FUnitinfo ui = CodeRepositoryManager.UNITREPO.get(unitCode);
        for (FUserunit uu : ui.getSubUserUnits()) {
            if (!"T".equals(uu.getIsprimary()))
                continue;
            FUserinfo user = CodeRepositoryManager.USERREPO.get(uu
                    .getUsercode());
            if (user != null) {
                if ("T".equals(user.getIsvalid())) {
                    if (!users.contains(user))
                        users.add(user);
                }
            }
        }

        Collections.sort(users, new Comparator<FUserinfo>() {
            public int compare(FUserinfo o1, FUserinfo o2) {
                if (o1.getUserorder() > o2.getUserorder())
                    return 1;
                return 0;
            }
        });

        return users;
    }

    public static final List<FUserinfo> getSortedUnitUsers(String unitCode) {
        List<FUserinfo> users = new ArrayList<FUserinfo>();

        FUnitinfo ui = CodeRepositoryManager.UNITREPO.get(unitCode);
        for (FUserunit uu : ui.getSubUserUnits()) {
            FUserinfo user = CodeRepositoryManager.USERREPO.get(uu
                    .getUsercode());
            if (user != null) {
                if ("T".equals(user.getIsvalid())) {
                    if (!users.contains(user))
                        users.add(user);
                }
            }
        }

        Collections.sort(users, new Comparator<FUserinfo>() {
            public int compare(FUserinfo o1, FUserinfo o2) {
                if (o1.getUserorder() > o2.getUserorder())
                    return 1;
                return 0;
            }
        });

        return users;
    }

    public static final List<FUnitinfo> getSortedSubUnits(String unitCode,
            String unitType) {
        List<FUnitinfo> units = new ArrayList<FUnitinfo>();

        FUnitinfo ui = CodeRepositoryManager.UNITREPO.get(unitCode);
        for (String uu : ui.getSubUnits()) {
            FUnitinfo unit = CodeRepositoryManager.UNITREPO.get(uu);
            if (unit != null) {
                if ("T".equals(unit.getIsvalid())
                        && (unitType == null || "A".equals(unitType) || unitType
                                .indexOf(unit.getUnittype()) >= 0)) {
                    units.add(unit);
                }
            }
        }

        Collections.sort(units, new Comparator<FUnitinfo>() {
            public int compare(FUnitinfo o1, FUnitinfo o2) {
                if (o1.getUnitorder() > o2.getUnitorder())
                    return 1;
                return 0;
            }
        });
        return units;
    }

    public static final Set<FUserinfo> getUnitUsers(String unitCode) {
        Set<FUserinfo> users = new HashSet<FUserinfo>();

        FUnitinfo ui = CodeRepositoryManager.UNITREPO.get(unitCode);
        for (FUserunit uu : ui.getSubUserUnits()) {
            FUserinfo user = CodeRepositoryManager.USERREPO.get(uu
                    .getUsercode());
            if (user != null) {
                if ("T".equals(user.getIsvalid()))
                    users.add(user);
            }
        }
        return users;
    }

    public static final FUserinfo getUserInfoByCode(String userCode) {
        return CodeRepositoryManager.USERREPO.get(userCode);
    }

    public static final Integer getUserUnitXzRank(String userCode,
            String unitCode) {
        if (userCode == null)
            return MAXXZRANK;
        FUserinfo ui = CodeRepositoryManager.USERREPO.get(userCode);
        if (ui == null)
            return MAXXZRANK;
        String rankUnitCode = (unitCode == null) ? ui.getPrimaryUnit()
                : unitCode;
        if (rankUnitCode == null || "".equals(rankUnitCode))
            return MAXXZRANK;
        FUnitinfo unit = CodeRepositoryManager.UNITREPO.get(rankUnitCode);
        if (unit == null)
            return MAXXZRANK;
        int nRank = MAXXZRANK;
        for (FUserunit uu : unit.getSubUserUnits()) {
            if (userCode.equals(uu.getUsercode()) && uu.getXzRank() < nRank)
                nRank = uu.getXzRank();
        }
        return nRank;
    }

    public static final List<FUserinfo> searchUser(String sPinyin) {
        String sPY = sPinyin.toLowerCase().trim();

        List<FUserinfo> users = new ArrayList<FUserinfo>();
        for (Map.Entry<String, FUserinfo> ent : CodeRepositoryManager.USERREPO
                .entrySet()) {
            FUserinfo value = ent.getValue();
            String sUserPY = value.getUsernamepinyin();
            if (value.getIsvalid().equals("T")
                    && ((sUserPY != null && sUserPY.startsWith(sPY))
                            || value.getLoginname().startsWith(sPY) || value
                            .getUsercode().startsWith(sPY)))
                users.add(value);
        }
        return users;
    }

    public static final Map<String, FUnitinfo> getUnitMapByParaent(
            String sParentUnit) {
        Map<String, FUnitinfo> units = new HashMap<String, FUnitinfo>();

        for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                .entrySet()) {
            FUnitinfo value = ent.getValue();
            if (value.getIsvalid().equals("T")
                    && sParentUnit.equals(value.getParentunit()))
                units.put(ent.getKey(), value);
        }
        return units;
    }

    public static final FUnitinfo getUnitInfoByCode(String sUnit) {
        return CodeRepositoryManager.UNITREPO.get(sUnit);
    }

    public static final List<FUnitinfo> getAllUnits(String sState) {
        List<FUnitinfo> units = new ArrayList<FUnitinfo>();

        for (Entry<String, FUnitinfo> entry : CodeRepositoryManager.UNITREPO
                .entrySet()) {
            FUnitinfo unit = entry.getValue();

            if ("A".equals(sState) || sState.equals(unit.getIsvalid())) {
                units.add(unit);
            }
        }

        return units;
    }

    public static final Map<String, FUnitinfo> getAllUnitMapByParaent(
            String sParentUnit) {
        Map<String, FUnitinfo> units = new HashMap<String, FUnitinfo>();

        for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                .entrySet()) {
            FUnitinfo value = ent.getValue();
            if (sParentUnit.equals(value.getParentunit()))
                units.put(ent.getKey(), value);
        }
        return units;
    }

    public static final Map<String, FUnitinfo> getUnitMapBuyParaentRecurse(
            String sParentUnit) {
        Map<String, FUnitinfo> units = new HashMap<String, FUnitinfo>();
        List<String> sParentUnits = new ArrayList<String>();
        List<String> sNewUnits = new ArrayList<String>();
        sParentUnits.add(sParentUnit);

        while (sParentUnits.size() > 0) {
            sNewUnits.clear();
            for (int i = 0; i < sParentUnits.size(); i++) {
                String sPNC = sParentUnits.get(i);
                for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                        .entrySet()) {
                    FUnitinfo value = ent.getValue();
                    if (value.getIsvalid().equals("T")
                            && sPNC.equals(value.getParentunit())) {
                        units.put(ent.getKey(), value);
                        sNewUnits.add(ent.getKey());
                    }
                }
            }
            List<String> tempList = sParentUnits;
            sParentUnits = sNewUnits;
            sNewUnits = tempList;
        }

        return units;
    }

    public static final List<FDatadictionary> getDictionary(String sCatalog) {
        return CodeRepositoryManager.REPOSITORIES.get(sCatalog);
    }

    public static final List<LabelValueBean> getDataCatalog() {
        return CodeRepositoryManager.DATACATALOG;
    }

    public static final List<FDatadictionary> getDictionaryIgnoreD(
            String sCatalog) {
        List<FDatadictionary> dcRetMap = new ArrayList<FDatadictionary>();
        List<FDatadictionary> dcMap = CodeRepositoryManager.REPOSITORIES
                .get(sCatalog);
        if (dcMap != null) {
            for (FDatadictionary value : dcMap) {
                if (value.getDatatag() == null
                        || !value.getDatatag().equals("D"))// getDatatag
                    dcRetMap.add(value);
            }
        }
        return dcRetMap;
    }

    public static final List<LabelValueBean> getLabelValueBeans(String sCatalog) {
        List<LabelValueBean> lbvs = new ArrayList<LabelValueBean>();

        if (sCatalog.equalsIgnoreCase("usercode")) {
            for (Map.Entry<String, FUserinfo> ent : CodeRepositoryManager.USERREPO
                    .entrySet()) {
                FUserinfo value = ent.getValue();
                if (value.getIsvalid().equals("T"))
                    lbvs.add(new LabelValueBean(value.getUsername(), ent
                            .getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("unitcode")) {
            for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                    .entrySet()) {
                FUnitinfo value = ent.getValue();
                if (value.getIsvalid().equals("T"))
                    lbvs.add(new LabelValueBean(value.getUnitname(), ent
                            .getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("depno")) {
            for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.DEPNO
                    .entrySet()) {
                FUnitinfo value = ent.getValue();
                if (value.getIsvalid().equals("T"))
                    lbvs.add(new LabelValueBean(value.getUnitname(), ent
                            .getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("suppowerId")) {
            for (Map.Entry<String, Suppower> ent : CodeRepositoryManager.SUPPOWERREPO
                    .entrySet()) {
                Suppower value = ent.getValue();
                lbvs.add(new LabelValueBean(value.getItemName(), ent.getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("zf_powerid")) {
            for (Entry<String, Zf_power> ent : CodeRepositoryManager.ZFPOWERREPO
                    .entrySet()) {
                Zf_power value = ent.getValue();
                lbvs.add(new LabelValueBean(value.getItemName(), ent.getKey()));
            }
            return lbvs;
        }
        if (sCatalog.equalsIgnoreCase("rolecode")) {
            for (Map.Entry<String, FRoleinfo> ent : CodeRepositoryManager.ROLEREPO
                    .entrySet()) {
                FRoleinfo value = ent.getValue();
                if ("T".equals(value.getIsvalid()))
                    lbvs.add(new LabelValueBean(value.getRolename(), ent
                            .getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("optid")) {
            for (Map.Entry<String, FOptinfo> ent : CodeRepositoryManager.OPTREPO
                    .entrySet()) {
                FOptinfo value = ent.getValue();
                lbvs.add(new LabelValueBean(value.getOptname(), ent.getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("optcode")) {
            for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                    .entrySet()) {
                FOptdef value = ent.getValue();
                lbvs.add(new LabelValueBean(value.getOptname(), ent.getKey()));
            }
            return lbvs;
        }

        if (sCatalog.equalsIgnoreCase("optdesc")) {
            for (Map.Entry<String, FOptdef> ent : CodeRepositoryManager.POWERREPO
                    .entrySet()) {
                FOptdef optdef = ent.getValue();
                FOptinfo value = CodeRepositoryManager.OPTREPO.get(optdef
                        .getOptid());
                lbvs.add(new LabelValueBean(value.getOptname() + "-"
                        + optdef.getOptname(), ent.getKey()));
            }
            return lbvs;
        }

        List<FDatadictionary> dcMap = CodeRepositoryManager.REPOSITORIES
                .get(sCatalog);
        if (dcMap != null) {
            for (FDatadictionary value : dcMap) {
                if (value.getDatatag() != null
                        && !value.getDatatag().equals("D"))
                    lbvs.add(new LabelValueBean(value.getDatavalue(), value
                            .getDatacode()));
            }

        }
        return lbvs;
    }

    public static final FDatadictionary getDataPiece(String sCatalog,
            String sKey) {
        List<FDatadictionary> dcList = CodeRepositoryManager.REPOSITORIES
                .get(sCatalog);
        if (dcList == null)
            return null;

        for (FDatadictionary fd : dcList)
            if (fd.getDatacode().equals(sKey))
                return fd;
        return null;
    }

    public static final FDatadictionary getDataPieceByValue(String sCatalog,
            String sValue) {
        List<FDatadictionary> dcList = CodeRepositoryManager.REPOSITORIES
                .get(sCatalog);
        if (dcList == null)
            return null;

        for (FDatadictionary fd : dcList)
            if (fd.getDatavalue().equals(sValue))
                return fd;
        return null;
    }

    public static final String getPrimaryUnit(String usercode) {
        FUserinfo userinfo = CodeRepositoryManager.USERREPO.get(usercode);
        return userinfo.getPrimaryUnit();
    }

    public static final String getUnitName(String usercode) {
        FUnitinfo userinfo = CodeRepositoryManager.DEPNO.get(usercode);
        if (userinfo == null) {
            return "";
        }
        return userinfo.getUnitname();
    }

    public static final String getUnitListJSON() {
        JSONArray array = new JSONArray();

        for (Entry<String, FUnitinfo> entry : CodeRepositoryManager.UNITREPO
                .entrySet()) {
            FUnitinfo unit = entry.getValue();

            if ("T".equals(unit.getIsvalid())) {
                JSONObject obj = new JSONObject();
                obj.accumulate("unitcode", unit.getUnitcode());
                obj.accumulate("parentunit", unit.getParentunit());
                obj.accumulate("unitshortname", unit.getUnitshortname());
                obj.accumulate("depno", unit.getDepno());

                array.add(obj);
            }
        }

        return array.toString();
    }

    private static List<FUnitinfo> getSubUnits(FUnitinfo unit) {
        List<FUnitinfo> units = new ArrayList<FUnitinfo>();

        if (null == unit) {
            return units;
        }

        units.add(unit);
        Set<String> subUnitsCode = unit.getSubUnits();

        if (null != subUnitsCode && subUnitsCode.size() != 0) {
            for (String uc : subUnitsCode) {
                FUnitinfo temp = CodeRepositoryManager.UNITREPO.get(uc);
                if (temp != null) {
                    if ("T".equals(temp.getIsvalid())) {
                        units.addAll(getSubUnits(temp));
                    }
                }
            }

        }

        return units;
    }

    public static final List<FUnitinfo> getUnitList(String unitcode) {
        List<FUnitinfo> units = new ArrayList<FUnitinfo>();

        if (!StringUtils.isBlank(unitcode)) {
            FUnitinfo ui = CodeRepositoryManager.UNITREPO.get(unitcode);
            if (null != ui) {
                units.addAll(getSubUnits(ui));
            }
        } else {
            for (Entry<String, FUnitinfo> entry : CodeRepositoryManager.UNITREPO
                    .entrySet()) {
                FUnitinfo unit = entry.getValue();

                if ("T".equals(unit.getIsvalid())) {
                    units.add(unit);
                }
            }
        }

        ParentChild<FUnitinfo> c = new Algorithm.ParentChild<FUnitinfo>() {
            public boolean parentAndChild(FUnitinfo p, FUnitinfo c) {
                return p.getUnitcode().equals(c.getParentunit());
            }
        };

        Algorithm.sortAsTree(units, c);

        return units;
    }

    // public static final List<FUnitinfo> getUnitList() {
    // List<FUnitinfo> units = new ArrayList<FUnitinfo>();
    //
    // for (Entry<String, FUnitinfo> entry :
    // CodeRepositoryManager.UNITREPO.entrySet()) {
    // FUnitinfo unit = entry.getValue();
    //
    // if ("T".equals(unit.getIsvalid())) {
    // units.add(unit);
    // }
    // }
    //
    // ParentChild<FUnitinfo> c = new Algorithm.ParentChild<FUnitinfo>() {
    // public boolean parentAndChild(FUnitinfo p, FUnitinfo c) {
    // return p.getUnitcode().equals(c.getParentunit());
    // }
    // };
    //
    // Algorithm.sortAsTree(units, c);
    //
    // return units;
    // }
    public static final JSONObject getUnitsJson() {

        JSONObject result = new JSONObject();
        JSONArray city = new JSONArray();
        for (Map.Entry<String, FUnitinfo> ent : CodeRepositoryManager.UNITREPO
                .entrySet()) {
            FUnitinfo u = ent.getValue();
            JSONObject rs = new JSONObject();
            rs.put("MID", u.getUnitcode());
            rs.put("MText", u.getUnitname());
            rs.put("ParentID", u.getParentunit());
            city.add(rs);
        }
        result.put("menuList", city);
        return result;
    }

    /**
     * 验证当前用户是否有某个操作方法的权限
     * 
     * @param optId
     * @param optMethod
     * @return
     */
    public static final Boolean checkUserOptPower(String optId, String optMethod) {
        Map<String, String> userOptList =
        // (Map<String,String>)ServletActionContext.getRequest().getSession().getAttribute("userOptList");
        ((FUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getUserOptList();
        if (userOptList == null)
            return false;
        String s = userOptList.get(optId + "-" + optMethod);
        if (s == null)
            return false;
        return "T".equals(s);
    }

}
