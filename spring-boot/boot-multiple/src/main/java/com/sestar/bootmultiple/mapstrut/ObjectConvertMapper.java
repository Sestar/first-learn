package com.sestar.bootmultiple.mapstrut;

import com.sestar.bootmultiple.convert.BaseConvertor;
import com.sestar.bootmultiple.dao.UserDAO;
import com.sestar.bootmultiple.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @description 对象转化 Mapper 接口
 * @author zhangxinxin
 * @date 2019/5/6 20:14
 **/
@Mapper(uses = {BaseConvertor.class })
public interface ObjectConvertMapper {

    ObjectConvertMapper INSTANCE = Mappers.getMapper(ObjectConvertMapper.class);

    UserVO toVo(UserDAO userDAO);

    UserDAO toDao(UserVO userVO);

}
