package com.ecommerce.mapper;

import com.ecommerce.entity.RegChannel;
import java.util.List;

public interface RegChannelMapper {
    List<RegChannel> selectAll();
    RegChannel selectById(Integer channelId);
}