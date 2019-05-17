package cn.java.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.dao.OwnerDao;
import cn.java.dto.ResultDto;
import cn.java.entity.OwnerEntity;
import cn.java.service.OwnerService;
import cn.java.util.MD5;
import cn.java.util.ResultUtil;

@Service
public class OwnerImpl implements OwnerService {
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public ResultDto<String> registerOwner(OwnerEntity ownerEntity) {
		// TODO Auto-generated method stub
		
		// 将明码变成密码
		MD5 md5 = new MD5();
		//加密后的密码
		String psdMd5=md5.getMD5ofStr(ownerEntity.getPsd());
		String cpsdMd5=md5.getMD5ofStr(ownerEntity.getConfirmpsd());
		//将密码放到实体类中
		ownerEntity.setPsd(psdMd5);
		ownerEntity.setConfirmpsd(cpsdMd5);
		
		// 调用dao层	
		int result=ownerDao.registerOwner(ownerEntity);
		if (result==0) {
			return ResultUtil.fail("注册失败");
		}	
		return ResultUtil.success("注册成功");
	}

	@Override
	public List<OwnerEntity> selectByYz(String yz) {
		// TODO Auto-generated method stub
		return ownerDao.selectByYz(yz);
	}

}
