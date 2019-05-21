package com.centit.poweritem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.security.core.context.SecurityContextHolder;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.core.utils.PageDesc;
import com.centit.powerbase.dao.PcfreeumpiredegreeDao;
import com.centit.powerbase.dao.PcfreeumpiretypeDao;
import com.centit.powerbase.dao.PcpunishStandardDao;
import com.centit.powerbase.po.Pcfreeumpiredegree;
import com.centit.powerbase.po.Pcfreeumpiretype;
import com.centit.powerbase.po.PcpunishStandard;
import com.centit.powerbase.service.SuppowerManager;
import com.centit.poweritem.dao.BpowerItemServiceDao;
import com.centit.poweritem.dao.VpowerItemServiceChangeDao;
import com.centit.poweritem.dao.VpoweritemservicewithoutlobDao;
import com.centit.poweritem.po.BpowerItemService;
import com.centit.poweritem.po.VpowerItemServiceChange;
import com.centit.poweritem.po.Vpoweritemservicewithoutlob;
import com.centit.poweritem.service.BpowerItemServiceManager;
import com.centit.support.utils.StringBaseOpt;
import com.centit.sys.security.FUserDetail;

public class BpowerItemServiceManagerImpl extends
        BaseEntityManagerImpl<BpowerItemService> implements
        BpowerItemServiceManager {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(SuppowerManager.class);
    private BpowerItemServiceDao suppowerDao;
    private PcpunishStandardDao pcpunishStandardDao;
    private PcfreeumpiredegreeDao pcfreeumpiredegreeDao;
    private PcfreeumpiretypeDao pcfreeumpiretypeDao;

    public void setPcfreeumpiretypeDao(PcfreeumpiretypeDao baseDao) {
        this.pcfreeumpiretypeDao = baseDao;

    }

    public void setPcfreeumpiredegreeDao(PcfreeumpiredegreeDao baseDao) {
        this.pcfreeumpiredegreeDao = baseDao;
    }

    public void setPcpunishStandardDao(PcpunishStandardDao baseDao) {
        this.pcpunishStandardDao = baseDao;
    }

    private VpoweritemservicewithoutlobDao vSupPowerDao;
    private VpoweritemservicewithoutlobDao vsuppowerwithoutlobDao;
    private VpowerItemServiceChangeDao suppowerqlbgsqDao;

    public void setSuppowerqlbgsqDao(
            VpowerItemServiceChangeDao suppowerqlbgsqDao) {
        this.suppowerqlbgsqDao = suppowerqlbgsqDao;
    }

    public void setSuppowerDao(BpowerItemServiceDao baseDao) {
        this.suppowerDao = baseDao;
        setBaseDao(this.suppowerDao);
    }

    public void setVsuppowerwithoutlobDao(
            VpoweritemservicewithoutlobDao vsuppowerwithoutlobDao) {
        this.vsuppowerwithoutlobDao = vsuppowerwithoutlobDao;
    }

    public List<Vpoweritemservicewithoutlob> listSupPowerWithoutLob(
            Map<String, Object> filterMap, PageDesc pageDesc) {
        return vSupPowerDao.listObjects(filterMap, pageDesc);
    }

    public void setvSupPowerDao(VpoweritemservicewithoutlobDao vSupPowerDao) {
        this.vSupPowerDao = vSupPowerDao;
    }

    /*
     * public void setvOrgSupPowerDao(VOrgSupPowerDao vOrgSupPowerDao) {
     * this.vOrgSupPowerDao = vOrgSupPowerDao; }
     */
    @Override
    public List<BpowerItemService> getlistSuppowerOld(String itemId,
            Long version) {
        return suppowerDao.getlistSuppowerOld(itemId, version);
    }

    @Override@SuppressWarnings("rawtypes")
    public List getVersionList(String itemId) {

        return suppowerDao.getVersionList(itemId);
    }

    @Override
    public List<BpowerItemService> getPicListByState(
            Map<String, Object> filterMap, PageDesc pageDesc, String qlState,
            String ItemType) {

        return suppowerDao.getPicListByState(filterMap, pageDesc, qlState,
                ItemType);
    }

    @Override
    public List<Vpoweritemservicewithoutlob> listSupPowerOnlyList(
            Map<String, Object> filterMap, PageDesc pageDesc) {

        return vSupPowerDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public BpowerItemService getObjectById(String itemId, Long version) {

        return suppowerDao.getBpowerItemService(itemId, version);
    }

    public BpowerItemService getSuppowerLastVersion(String itemId, Date date) {

        return suppowerDao.getSuppowerLastVersion(itemId, date);
    }

    public void saveSuppower(BpowerItemService suppower1,
            BpowerItemService suppower2) {
        suppowerDao.saveObject(suppower1);
        suppowerDao.saveObject(suppower2);
        if ("CF".equals(suppower1.getItemType())) {
            this.saveDISCRETION(suppower1.getDis_detail(),
                    suppower1.getDis_standard(), suppower1.getItemId(),
                    suppower1.getVersion());
        }
        if ("CF".equals(suppower2.getItemType())) {
            this.saveDISCRETION(suppower2.getDis_detail(),
                    suppower2.getDis_standard(), suppower2.getItemId(),
                    suppower2.getVersion());
        }
    }

    public void saveSuppower(BpowerItemService suppower) {
        suppowerDao.saveObject(suppower);
        if ("CF".equals(suppower.getItemType())) {
            this.saveDISCRETION(suppower.getDis_detail(),
                    suppower.getDis_standard(), suppower.getItemId(),
                    suppower.getVersion());
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
    @Override
    public List xmlDISCRETIONList(String dis_detail, String update_type,
            String item_id) {
        boolean flag = false;
        List<Pcfreeumpiredegree> retList = new ArrayList();
        if (dis_detail == null || dis_detail.equals(""))
            return retList;
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(dis_detail);
            Element root = doc.getRootElement();
            Iterator iter = root.elementIterator("CONTENT");
            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                String stand_id = ele.elementTextTrim("STAND_ID");
                String stand_code = ele.elementTextTrim("STAND_CODE");
                Pcfreeumpiredegree info = new Pcfreeumpiredegree();
                info.setStandardNo(stand_id);
                info.setPunishfactgrade(stand_code);
                retList.add(info);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    @Override
    public List xmlStandardList(String dis_standard, String update_type,
            String item_id) {
        boolean flag = false;
        List retList = new ArrayList();
        if (dis_standard == null || dis_standard.equals(""))
            return retList;
        Document doc = null;
        try {
            // doc.setXMLEncoding("GBK");
            doc = DocumentHelper.parseText(dis_standard);
            Element root = doc.getRootElement();
            Iterator iter = root.elementIterator("CONTENT");
            while (iter.hasNext()) {

                Element ele = (Element) iter.next();
                String stand_id = ele.elementTextTrim("STAND_ID");
                String stand_code = ele.elementTextTrim("STAND_CODE");
                Iterator iter2 = ele.elementIterator("STAND_SEQ");

                boolean next = iter2.hasNext();
                while (iter2.hasNext()) {
                    Element ele2 = (Element) iter2.next();
                    Pcfreeumpiretype bean = new Pcfreeumpiretype();
                    bean.setStandardNo(stand_id);
                    bean.setPunishfactgrade(stand_code);
                    bean.setPunishtypeid(ele2.elementText("SEQ_ID"));
                    String seq_typei = ele2.elementText("SEQ_TYPE");
                    if (!StringBaseOpt.isNvl(seq_typei)) {
                        seq_typei = seq_typei.trim();
                    }
                    if ("null".equals(seq_typei)) {
                        seq_typei = null;
                    }
                    bean.setPunishtype(StringBaseOpt.isNvl(seq_typei) ? null
                            : Long.parseLong(seq_typei));
                    bean.setToplimit(ele2.elementText("SEQ_TOPLIMIT"));
                    bean.setToplimitUnit(ele2.elementText("SEQ_TOPLIMIT_UNIT"));
                    bean.setLowlimit(ele2.elementText("SEQ_LOWLIMIT"));
                    bean.setLowlimitUnit(ele2.elementText("SEQ_LOWLIMIT_UNIT"));
                    bean.setBaseName(ele2.elementText("SEQ_BASE_NAME"));
                    bean.setBaseToplimit(ele2.elementText("SEQ_BASE_TOPMUL"));
                    bean.setBaseLowlimit(ele2.elementText("SEQ_BASE_LOWMUL"));
                    bean.setBaseUnit(ele2.elementText("SEQ_BASE_UNIT"));
                    bean.setRemark(ele2.elementText("SEQ_REMARK"));
                    retList.add(bean);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return retList;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getzycvie(String Linagesize) {

        return suppowerDao.getzycviewnew(Linagesize);
    }

    public List<Vpoweritemservicewithoutlob> listSuppowerWithoutLob(
            String hsql, Map<String, Object> filterMap, PageDesc pageDesc) {

        return vsuppowerwithoutlobDao.listSuppowerWithoutLob(hsql, filterMap,
                pageDesc);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List getseqtype(String Linagesize) {

        return new ArrayList();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List getseqlowlimitunit(String Linagesize) {

        return new ArrayList();
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
    public List genxmlStandardList(String dis_standard, String update_type,
            String item_id) {
        System.out.println(dis_standard);
        System.out.println(item_id);
        boolean flag = false;
        List insertList = new ArrayList();
        Document doc = null;
        if (dis_standard == null || dis_standard.equals(""))
            return insertList;
        try {
            doc = DocumentHelper.parseText(dis_standard); // 为Docunment对象doc加载CLOB数据
            // doc.setXMLEncoding("GBK");
            Element root = doc.getRootElement(); // 获得XML根节点
            Iterator iter = root.elementIterator("STAND_SEQ");// 获取根节点的子节点STAND_SEQ放入迭代器中
            while (iter.hasNext()) { // 遍历STAND_SEQ
                // String no = genId("NO", "suppower_standard") == null ? "1"
                // : genId("NO", "suppower_standard");// 生成NO号
                Element recordEle = (Element) iter.next(); // 在迭代器中获取当前STAND_SEQ
                String ret[] = new String[11];// 装数据
                Map map = new HashMap();
                PcpunishStandard info = new PcpunishStandard();

                info.setPunishtypeid(recordEle.elementTextTrim("SEQ_ID"));
                String seq_typei = recordEle.elementTextTrim("SEQ_TYPE");
                if (!StringBaseOpt.isNvl(seq_typei)) {
                    seq_typei = seq_typei.trim();
                }
                if ("null".equals(seq_typei)) {
                    seq_typei = null;
                }
                info.setPunishtype(StringBaseOpt.isNvl(seq_typei) ? null : Long
                        .parseLong(seq_typei));
                info.setToplimit(recordEle.elementTextTrim("SEQ_TOPLIMIT"));
                info.setToplimitUnit(recordEle
                        .elementTextTrim("SEQ_TOPLIMIT_UNIT"));
                info.setLowlimit(recordEle.elementTextTrim("SEQ_LOWLIMIT"));
                info.setLowlimitUnit(recordEle
                        .elementTextTrim("SEQ_LOWLIMIT_UNIT"));
                info.setBaseName(recordEle.elementTextTrim("SEQ_BASE_NAME"));
                info.setBaseToplimit(recordEle
                        .elementTextTrim("SEQ_BASE_TOPMUL"));
                info.setBaseLowlimit(recordEle
                        .elementTextTrim("SEQ_BASE_LOWMUL"));
                info.setBaseUnit(recordEle.elementTextTrim("SEQ_BASE_UNIT"));
                info.setRemark(recordEle.elementTextTrim("SEQ_REMARK"));

                insertList.add(info);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return insertList;
    }

    public BpowerItemService getSuppowerQlfb(String itemId) {
        return suppowerDao.getSuppowerQlfb(itemId);
    }
    @SuppressWarnings("rawtypes")
    public boolean saveDISCRETION(String Dis_detail, String Dis_standard,
            String item_id, Long version) {
        boolean flag = true;
        // SupPowerManager spMg=new SupPowerManager();

        List disstandardxmlList = this.genxmlStandardList(Dis_standard, "", "");
        this.delStandardItemID(item_id, version);
        for (int i = 0; i < disstandardxmlList.size(); i++) {
            PcpunishStandard info = (PcpunishStandard) disstandardxmlList
                    .get(i);
            try {
                info.setItemId(item_id);
                info.setVersion(version + "");
                info.setIsinuse(1l);
                System.out.println(info.getPunishtypeid() + info.getItemId()
                        + info.getVersion() + info.getIsinuse());
                pcpunishStandardDao.saveObject(info);

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        if (flag) {
            this.delDiscretionItemID(item_id, version);
        }
        if (flag) {
            flag = this.xmlDISCRETION(Dis_detail, "", item_id, version);
        }
        return flag;
    }

    public void delStandardItemID(String item_id, Long version) {
        suppowerDao.delStandardItemID(item_id, String.valueOf(version));
    }

    public void updateSuppower(BpowerItemService suppower) {
        suppowerDao.updateSuppower(suppower);
    }

    public void delDiscretionItemID(String item_id, Long version) {
        boolean flag = true;
        suppowerDao.delDiscretionValueByItemID(item_id, version);
        if (flag) {
            suppowerDao.delDiscretionItemID(item_id, version);
        }

    }

    @SuppressWarnings({ "rawtypes", "unused" })
    public boolean xmlDISCRETION(String dis_detail, String update_type,
            String item_id, Long version) {
        boolean flag = false;
        if (StringBaseOpt.isNvl(dis_detail)) {
            return flag;
        }
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(dis_detail);
            Element root = doc.getRootElement();
            Iterator iter = root.elementIterator("CONTENT");
            while (iter.hasNext()) {
                // String
                // no=ConDateTime.currentDateYYYYMMDD()+StringUtil.genRandomNum(6);
                Element ele = (Element) iter.next();
                String stand_id = ele.elementTextTrim("STAND_ID");
                String stand_code = ele.elementTextTrim("STAND_CODE");
                Iterator iter2 = ele.elementIterator("STAND_SEQ");
                // String degreeno =
                // pcfreeumpiredegreeDao.getNextKeyMax("degreeno",
                // "Pcfreeumpiredegree");
                Long degreeno = pcfreeumpiredegreeDao
                        .getNextLongSequence("S_DGREENO");
                Pcfreeumpiredegree reeInfo = new Pcfreeumpiredegree();
                reeInfo.setIsinuse(1L);
                reeInfo.setItemId(item_id);
                reeInfo.setPunishfactgrade(stand_code);
                reeInfo.setStandardNo(stand_id);
                reeInfo.setVersion(version);
                reeInfo.setDegreeno(degreeno);
                pcfreeumpiredegreeDao.saveObject(reeInfo);
                boolean next = iter2.hasNext();
                while (iter2.hasNext()) {
                    Element ele2 = (Element) iter2.next();
                    Pcfreeumpiretype typeInfo = new Pcfreeumpiretype();
                    typeInfo.setDegreeno(degreeno);
                    typeInfo.setPunishtypeid(ele2.elementTextTrim("SEQ_ID"));
                    String seq_typei = ele2.elementTextTrim("SEQ_TYPE");
                    if (!StringBaseOpt.isNvl(seq_typei)) {
                        seq_typei = seq_typei.trim();
                    }
                    if ("null".equals(seq_typei)) {
                        seq_typei = null;
                    }
                    typeInfo.setPunishtype(StringBaseOpt.isNvl(seq_typei) ? null
                            : Long.parseLong(seq_typei));
                    typeInfo.setToplimit(ele2.elementText("SEQ_TOPLIMIT"));
                    typeInfo.setToplimitUnit(ele2
                            .elementText("SEQ_TOPLIMIT_UNIT"));
                    typeInfo.setLowlimit(ele2.elementText("SEQ_LOWLIMIT"));
                    typeInfo.setLowlimitUnit(ele2
                            .elementText("SEQ_LOWLIMIT_UNIT"));
                    typeInfo.setBaseName(ele2.elementText("SEQ_BASE_NAME"));
                    typeInfo.setBaseToplimit(ele2
                            .elementText("SEQ_BASE_TOPMUL"));
                    typeInfo.setBaseLowlimit(ele2
                            .elementText("SEQ_BASE_LOWMUL"));
                    typeInfo.setBaseUnit(ele2.elementText("SEQ_BASE_UNIT"));
                    typeInfo.setRemark(ele2.elementText("SEQ_REMARK"));
                    typeInfo.setStandardNo(stand_id);
                    typeInfo.setIsinuse(1l);
                    pcfreeumpiretypeDao.saveObject(typeInfo);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<BpowerItemService> getlistSuppower(String item_type) {
        return suppowerDao.getlistSuppower(item_type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.centit.powerbase.service.SuppowerManager#listSuppower4Select(java
     * .lang.String)
     */
    public List<BpowerItemService> listSuppower4Select(String item_type) {
        return suppowerDao.listSuppower4Select(item_type);
    }

    @Override
    public List<Vpoweritemservicewithoutlob> listPowerWithoutLob(
            Map<String, Object> filterMap, PageDesc pageDesc) {

        return vsuppowerwithoutlobDao.listObjects(filterMap, pageDesc);
    }

    @Override
    public boolean isPowerExist(String itemId) {
        return suppowerDao.isPowerExist(itemId);
    }

    @Override@SuppressWarnings("rawtypes")
    public List getxzlist(String begintime, String endtime) {

        return suppowerDao.getxzlist(begintime, endtime);
    }

    @Override
    public List<BpowerItemService> getSuppowernum(String item_type) {

        return suppowerDao.getSuppowernum(item_type);
    }

    @Override@SuppressWarnings("rawtypes")
    public List getdeplist(String string) {

        return suppowerDao.getdeplist(string);
    }

    @SuppressWarnings("unused")
    @Override
    public void QlfbAll(List<BpowerItemService> suppowerList) {
        try {
            BpowerItemService sp;
            boolean isNew;
            String oldValue;
            Long version;
            Date curTime;

            BpowerItemService suppower;
            BpowerItemService suppower_0;
            BpowerItemService suppower_old;

            FUserDetail fUserDetail = (FUserDetail) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();

            for (int i = 0; i < suppowerList.size(); i++) {
                BpowerItemService suppower_new = new BpowerItemService();

                sp = (BpowerItemService) suppowerList.get(i);
                curTime = new Date(System.currentTimeMillis());
                sp.setBeginTime(curTime);

                isNew = true;
                oldValue = null;
                suppower = this.getSuppowerQlfb(sp.getItemId());// 获取需要设置结束时间的版本号,这里面取的是非0版本
                suppower_0 = this
                        .getObjectById(sp.getItemId(), sp.getVersion());// 获取0版本内容
                version = 0l;// 默认是0版本号

                if (suppower == null
                        || StringBaseOpt.isNvl(suppower.getItemId())) {
                    isNew = false;
                    suppower_0.setLastmodifytime(curTime);
                    suppower_0.setQlState("A");// 20130521全部只修改0版本的信息
                    suppower_0.setBeginTime(curTime);
                    copyObjectNotNullProperty(suppower_new, suppower_0);
                    suppower_new.setVersion(version + 1);// 将最大版本号加一
                    saveSuppower(suppower_0, suppower_new);
                } else {
                    version = suppower.getVersion();
                    isNew = false;
                    oldValue = suppower.display();// 监察操纵日志
                    suppower_0.setLastmodifytime(curTime);
                    suppower_0.setQlState("A");// 20130521全部只修改0版本的信息
                    suppower_0.setBeginTime(curTime);
                    copyObjectNotNullProperty(suppower_new, suppower_0);
                    suppower_new.setVersion(version + 1);// 将最大版本号加一
                    saveSuppower(suppower_0, suppower_new);
                    suppower.setQlState("U");// 设置为已升级版本
                    suppower.setEndTime(curTime);// 设置结束时间
                    suppower.setLastmodifytime(curTime);// 设置最后修改时间
                    updateSuppower(suppower);// 将最大版本号的修改为历史版本
                }
            }
        } finally {

        }

    }

    @Override
    public String getFlowCodeByOrgItem(String itemId, String Org_id) {

        return null;
    }

    @Override
    public VpowerItemServiceChange getVpowerItemServiceChangeInfo(
            String itemId, Long version) {
        return suppowerqlbgsqDao.getSuppowerqlbgsqInfo(itemId, version);
    }

}
