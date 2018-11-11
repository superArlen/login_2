package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Images;

import dao.ImagesDao;
@Service
public class ImagesService {
	@Autowired
	private ImagesDao imagesDao;
	
	/*
	 * 所有管理员头像信息
	 */
	public List<Images> selectAdminImages(){
		return imagesDao.selectAdminImages();
	}
	
	
	
	/*
	 * 更新数据库图片地址
	 */
	public int updateWeiz(Images images){
		return imagesDao.uptateWeiz(images);
	}
	
	
	/*
	 * 显示所有信息
	 */
	public List<Images> selectAllImages(){
		//System.out.println("service");
		return imagesDao.selectAllImages();
	}
	
	
	
	
	
	
	/*
	 * up_lx
	 */
//	@Resource
//    StoreMapper storeMapper;
//    
//    @Override
//    public ServerResponse<String> addStore(Store store) {
//        int insert = storeMapper.insert(store);
//        if (insert == 0) {
//            return ServerResponse.createByErrorMessage("添加失败");
//        }
//        return ServerResponse.createBySuccessMessage("添加成功");
//    }
	
	
	
	
	
}
