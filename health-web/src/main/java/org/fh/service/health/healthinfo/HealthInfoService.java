package org.fh.service.health.healthinfo;

import org.fh.entity.Page;
import org.fh.entity.PageData;

import java.util.List;

/** 
 * 说明： 健康数据接口
 * 作者：FH Admin QQ313596790
 * 时间：2020-03-12
 * 官网：www.fhadmin.org
 * @version
 */
public interface HealthInfoService{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;


	/**
	 * 获取echarts 数据
	 * @param pd
	 * @return
	 */
	public List<PageData> getEDataByType(PageData pd);
	
}

