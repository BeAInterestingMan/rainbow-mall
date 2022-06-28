package com.rainbow.mall.goods.service.service.impl;

import com.rainbow.mall.goods.service.enums.GoodsAuthEnum;
import com.rainbow.mall.goods.service.enums.GoodsStatusEnum;
import com.rainbow.mall.goods.service.enums.ResultCode;
import com.rainbow.mall.goods.service.exception.GoodsServiceException;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsCartBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;
import com.rainbow.mall.goods.service.repository.GoodsCartRepository;
import com.rainbow.mall.goods.service.service.GoodsCartService;
import com.rainbow.mall.goods.service.service.GoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *  @Description 商品购物车服务
 *  @author liuhu
 *  @Date 2022/6/12 17:17
 */
@Service
@Slf4j
public class GoodsCartServiceImpl implements GoodsCartService {

    @Autowired
    private GoodsCartRepository goodsCartRepository;

    @Autowired
    private GoodsSkuService goodsSkuService;

    @Override
    public void add(GoodsCartSaveDTO goodsCartAddDTO) {
        //1.校验商品有效性
        GoodsSkuBaseDTO goodsSkuBaseDTO = checkGoodStatus(goodsCartAddDTO);
        //2.TODO 校验库存
        //3.保存购物车数据
        saveGoodsCart(goodsCartAddDTO,goodsSkuBaseDTO);
    }

    @Override
    public void clean() {
        goodsCartRepository.clean();
    }

    @Override
    public void delete(String[] skuIds) {
        if(ArrayUtils.isEmpty(skuIds)){
               return;
        }
        for (String skuId : skuIds) {
            goodsCartRepository.delete(skuId);
        }
    }

    @Override
    public Integer getCartNum() {
        List<GoodsCartBaseDTO> userCartInfoList = goodsCartRepository.getUserCartInfo();
        return CollectionUtils.isEmpty(userCartInfoList)?0:userCartInfoList.size();
    }

    private void saveGoodsCart(GoodsCartSaveDTO goodsCartAddDTO,GoodsSkuBaseDTO goodsSkuBaseDTO) {
        GoodsCartBaseDTO baseDTO = buildGoodsCartBaseDTO(goodsCartAddDTO, goodsSkuBaseDTO);
        List<GoodsCartBaseDTO> userCartInfoList = goodsCartRepository.getUserCartInfo();
        // 购物车不存在 新增
        if(CollectionUtils.isEmpty(userCartInfoList)){
            goodsCartRepository.save(baseDTO);
            return;
        }
        // 购物车不包含当天前添加得商品
        List<GoodsCartBaseDTO> existCartBaseDTOS = userCartInfoList.stream().filter(userCartInfo -> Objects.equals(userCartInfo.getSkuId(), goodsCartAddDTO.getSkuId())).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(existCartBaseDTOS)){
            goodsCartRepository.save(baseDTO);
            return;
        }
        // 包含 则 更新数量
        int oldCount = existCartBaseDTOS.stream().mapToInt(GoodsCartBaseDTO::getNum).sum();
        baseDTO.setNum(oldCount+ baseDTO.getNum());
        goodsCartRepository.save(baseDTO);
    }

    private GoodsCartBaseDTO buildGoodsCartBaseDTO(GoodsCartSaveDTO goodsCartAddDTO, GoodsSkuBaseDTO goodsSkuBaseDTO) {
        GoodsCartBaseDTO baseDTO = new GoodsCartBaseDTO();
        baseDTO.setGoodsId(String.valueOf(goodsSkuBaseDTO.getGoodsId()));
        baseDTO.setNum(goodsCartAddDTO.getNum());
        baseDTO.setPrice(goodsSkuBaseDTO.getPrice());
        baseDTO.setName(goodsSkuBaseDTO.getGoodsName());
        baseDTO.setSkuId(goodsCartAddDTO.getSkuId());
        return baseDTO;
    }

    private GoodsSkuBaseDTO checkGoodStatus(GoodsCartSaveDTO  goodsCartSaveDTO) {
        GoodsSkuBaseDTO skuBaseDTO = goodsSkuService.getBySkuId(goodsCartSaveDTO.getSkuId());
        if (Objects.isNull(skuBaseDTO)) {
            throw new GoodsServiceException(ResultCode.GOODS_NOT_EXIST.message());
        }
        if (!GoodsAuthEnum.PASS.name().equals(skuBaseDTO.getAuthFlag()) || !GoodsStatusEnum.UPPER.name().equals(skuBaseDTO.getMarketEnable())) {
            throw new GoodsServiceException(ResultCode.GOODS_NOT_EXIST.message());
        }
        return skuBaseDTO;
    }
}
