package com.centit.indicator.service;

import java.util.List;
import java.util.Map;

import com.centit.core.service.BaseEntityManager;
import com.centit.core.utils.PageDesc;
import com.centit.indicator.po.PmNode;
import com.centit.indicator.po.PmTemplet;
import com.centit.indicator.po.PmTempletIndicator;
import com.centit.sys.po.FDatadictionary;

public interface PmTempletManager extends BaseEntityManager<PmTemplet> 
{
	/**
	 * 生成模板填报页面文件
	 * @param dataJson 模板指标的json字符串
	 * @param templetPath 模板文件夹路径
	 * @param fileName JSP名称
	 * @param ftlPath FreeMarker模板路径
	 */
	public void generateTempletFile(String dataJson, String templetPath, String fileName, String formName);
	/**
	 * 获取已经生成的指标模版中有哪些指标
	 * @param templetId 模版id
	 * @return
	 */
	public List<PmNode> getIndicators(String templetId);
	public List<PmNode> getEvlIndicators(String templetId);
	public int compileClass(List<PmNode> nowIndicators, FDatadictionary fd);
	public void saveObject(PmTemplet templet,List<PmTempletIndicator> indicatorList);
	public int getTempletVersion(String templetType);
	public String getJspFileName(PmTemplet templet);
	
	/**
	 * 检查模板对应的jsp页面文件是否存在，不存在则再生成一遍
	 * @param templet
	 * @param basePath
	 * @return
	 */
	public boolean checkJspFile(PmTemplet templet, String basePath);
	public PmTemplet getVersionTemplet(String templetType);
    public List<PmTemplet> listObjectsPmtem(Map<String, Object> filterMap,
            PageDesc pageDesc);
    
    public String getTemplateXml(Map<Object,Object> paramMap,String templetId);
    
    public void paseTemplateXml(Map<String,Object> obj,String xmlString);
	
}
