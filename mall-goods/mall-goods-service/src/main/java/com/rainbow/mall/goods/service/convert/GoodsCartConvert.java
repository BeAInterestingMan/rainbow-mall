package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.pojo.dto.base.GoodsCartBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;
import com.rainbow.mall.goods.service.pojo.request.GoodsCartAddRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsCartConvert {
    GoodsCartSaveDTO convertToGoodsCartAddDTO(GoodsCartAddRequest request);

    GoodsCartBaseDTO convertToGoodsCartBaseDTO(GoodsCartSaveDTO goodsCartAddDTO);
}
