package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.UserInfoDTO;
import poly.persistance.mapper.UserInfoMapper;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService{
	
	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name="UserInfoMapper")
	private UserInfoMapper userInfoMapper;
	
	@Override
	public int insertUserInfo(UserInfoDTO pDTO) throws Exception { 
		
		log.info(this.getClass().getName() + ".insertUserInfo service start ! ");
		int res = 0;
		
		if(pDTO == null) { 
			pDTO = new UserInfoDTO();
		}
		
		log.info("***********************************");
		log.info("getUserExists start ! ");
		UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);
		log.info("getUserExists end ! ");
		log.info("***********************************");
		
		if(rDTO==null) { 
			rDTO = new UserInfoDTO();
		}
		
		if(CmmUtil.nvl(rDTO.getExists_yn()).equals("Y")) { 
			res = 2;
			log.info("rDTO.getExists = Y /// res : " + res);
		} else { 
			
			
			log.info("***********************************");
			log.info("insertUserInfo start ! ");
			int success = userInfoMapper.insertUserInfo(pDTO);
			log.info("insertUserInfo end ! ");
			log.info("***********************************");
			
			if(success > 0) { 
				res = 1;
			} else { 
				res = 0;
			}
		}
		
		return res;
	}

}
