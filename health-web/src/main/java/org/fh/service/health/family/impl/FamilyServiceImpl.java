package org.fh.service.health.family.impl;

import org.fh.entity.Page;
import org.fh.entity.PageData;
import org.fh.mapper.dsno1.health.family.FamilyMapper;
import org.fh.mapper.dsno1.health.familyuser.FamilyUserMapper;
import org.fh.service.health.family.FamilyService;
import org.fh.util.Jurisdiction;
import org.fh.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** 
 * 说明： 家人群组管理接口实现类
 * 作者：FH Admin Q313596790
 * 时间：2020-03-11
 * 官网：www.fhadmin.org
 * @version
 */
@Service
@Transactional //开启事物
public class FamilyServiceImpl implements FamilyService{

	@Autowired
	private FamilyMapper familyMapper;

	@Autowired
	private FamilyUserMapper familyUserMapper;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		familyMapper.save(pd);
		//在添加成功后将自己加入到该家庭中
		String FAMILY_ID=pd.getString("FAMILY_ID");
		PageData familyUser=new PageData();
		familyUser.put("FAMILYUSER_ID",UuidUtil.get32UUID());
		familyUser.put("FAMILY_ID",FAMILY_ID);
		familyUser.put("USER_ID",Jurisdiction.getUserId());
		familyUserMapper.save(familyUser);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		familyMapper.delete(pd);
		//将该组中的成员全部删除
		PageData delP=new PageData();
		delP.put("FAMILY_ID",pd.getString("FAMILY_ID"));
		familyUserMapper.deleteByFamilyId(delP);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		familyMapper.edit(pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception{
		return familyMapper.datalistPage(page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception{
		return familyMapper.listAll(pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return familyMapper.findById(pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		familyMapper.deleteAll(ArrayDATA_IDS);
	}

	@Override
	public PageData getInfo(PageData pd) {
		return familyMapper.getInfo(pd);
	}

}

