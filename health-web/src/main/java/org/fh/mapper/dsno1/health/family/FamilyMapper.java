package org.fh.mapper.dsno1.health.family;

import org.fh.entity.Page;
import org.fh.entity.PageData;

import java.util.List;

/** 
 * 说明： 家人群组管理Mapper
 * 作者：FH Admin QQ313596790
 * 时间：2020-03-11
 * 官网：www.fhadmin.org
 * @version
 */
public interface FamilyMapper{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	void save(PageData pd);
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	void delete(PageData pd);
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	void edit(PageData pd);
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	List<PageData> datalistPage(Page page);
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	List<PageData> listAll(PageData pd);
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	PageData findById(PageData pd);
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	void deleteAll(String[] ArrayDATA_IDS);

	PageData getInfo(PageData pd);
	
}

