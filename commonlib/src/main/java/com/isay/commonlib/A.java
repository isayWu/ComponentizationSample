package com.isay.commonlib;

import android.app.Application;
import android.os.Build;

import com.isay.commonlib.app.IApplicationDelegate;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Desc:
 * <p>
 * Author: WuCongYi
 * Date: 2020/4/29
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public abstract class A  {

    List<IApplicationDelegate> mAppDelegateList = new ArrayList();


    private void test() {




        IApplicationDelegate d = new IApplicationDelegate() {
            @Override
            public void onLowMemory() {

            }

            @Override
            public void onTrimMemory(int level) {

            }

            @Override
            public void onTerminate() {

            }

            @Override
            public void onCreate(@Nullable Application application) {

            }
        };
        mAppDelegateList.add(d);

    }

}
