package com.rainbow.mall.auth.convert;

import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.pojo.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberConvert {
    MemberBaseDTO convertToMemberBaseDTO(Member member);
}
