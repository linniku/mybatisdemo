package com.yht.mapper;


import com.yht.domain.UserAccount;
import io.github.tianshouzhi.routing.Routing;

/**
 * Created by kingdee on 2018/9/4.
 */
@Routing("ds2")
public interface UserAccountMapper {

    public UserAccount selectById(int id);

    public void insert(UserAccount userAcount);
}
