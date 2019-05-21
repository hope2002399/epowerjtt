package com.centit.indicator.service.impl;

import java.util.List;

import com.centit.core.service.BaseEntityManagerImpl;
import com.centit.indicator.po.PmIndicator;
import com.centit.indicator.dao.PmIndicatorDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.indicator.service.PmIndicatorManager;

public class PmIndicatorManagerImpl extends BaseEntityManagerImpl<PmIndicator> implements PmIndicatorManager {
	private static final long serialVersionUID = 1L;
	public static final Log log = LogFactory.getLog(PmIndicatorManager.class);

	// private static final SysOptLog sysOptLog = SysOptLogFactoryImpl.getSysOptLog();

	private PmIndicatorDao pmIndicatorDao;

	public void setPmIndicatorDao(PmIndicatorDao baseDao) {
		this.pmIndicatorDao = baseDao;
		setBaseDao(this.pmIndicatorDao);
	}

	@Override
	public String indicatorList() {
		List<PmIndicator> objList = pmIndicatorDao.listObjects();
		StringBuffer buffer = new StringBuffer("[");
		if (objList != null && objList.size() > 0) {
			for (PmIndicator pi : objList) {
				if (buffer.length() > 1) {
					buffer.append(",");
				}
				// { id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true}-----------zTree必须字段
				buffer.append("{id:'").append(pi.getIndicatorId()).append("',pId:'").append(pi.getFatherId())
						.append("',name:'").append(pi.getIndicatorName()).append("'");
				//对象所有字段 方便日后获取
				buffer.append("indicatorNickName:'").append(pi.getIndicatorNickName()).append("',");
				buffer.append("ifDictionary:'").append(pi.getIfDictionary()).append("',");
				buffer.append("dictionaryId:'").append(pi.getDictionaryId()).append("',");
				buffer.append("dictionaryKey:'").append(pi.getDictionaryKey()).append("',");
				buffer.append("inputType:'").append(pi.getInputType()).append("',");
				buffer.append("ifCascade:'").append(pi.getIfCascade()).append("',");
				buffer.append("cascadeId:'").append(pi.getCascadeId()).append("',");
				buffer.append("valueType:'").append(pi.getValueType()).append("',");
				buffer.append("hasLower:'").append(pi.getHasLower()).append("'");
				if (!pi.getHasLower().isEmpty() && pi.getHasLower().equals("T")) {
					buffer.append(",isParent:true");
				}
				buffer.append("}");
			}
			buffer.append("]");
		}
		return buffer.toString();
	}

}
