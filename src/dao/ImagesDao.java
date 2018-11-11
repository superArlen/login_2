package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Images;

@Repository("imagesDao")
public class ImagesDao extends SqlSessionDaoSupport {

	/*
	 * 为dao注入sqlsessionfactory组件
	 */
	@Autowired
	public void setSessionFactiory(SqlSessionFactory ssf){
		super.setSqlSessionFactory(ssf);
	}
	
	
	/*
	 * 查询管理员所有数据	
	 */
		public List<Images> selectAdminImages(){
			//System.out.println("dao");
			return getSqlSession().selectList("nsImages.showAdminImages");
		}
		
	
	
	
	
	
/*
 * 查询所有数据	
 */
	public List<Images> selectAllImages(){
		//System.out.println("dao");
		return getSqlSession().selectList("nsImages.showImages");
	}
	
	/*
	 * 更改数据库位置
	 */
	public int uptateWeiz(Images images){
		return getSqlSession().update("nsImages.updateWeiz",images);
	}
	
	
	
}
