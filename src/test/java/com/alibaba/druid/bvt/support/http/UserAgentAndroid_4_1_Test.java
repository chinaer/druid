/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.support.http;

import org.junit.Assert;
import junit.framework.TestCase;

import com.alibaba.druid.support.http.stat.WebAppStat;

public class UserAgentAndroid_4_1_Test extends TestCase {

    public void test_mac_firefox() throws Exception {
        WebAppStat stat = new WebAppStat("");
        stat.computeUserAgent("Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        Assert.assertEquals(1, stat.getBrowserChromeCount());
        Assert.assertEquals(0, stat.getBrowserFirefoxCount());
        Assert.assertEquals(0, stat.getBrowserOperaCount());
        Assert.assertEquals(0, stat.getBrowserSafariCount());
        Assert.assertEquals(0, stat.getBrowserIECount());
        Assert.assertEquals(0, stat.getBrowserIE10Count());

        Assert.assertEquals(1, stat.getDeviceAndroidCount());
        Assert.assertEquals(0, stat.getDeviceIphoneCount());
        Assert.assertEquals(0, stat.getDeviceWindowsPhoneCount());

        Assert.assertEquals(1, stat.getOSLinuxCount());
        Assert.assertEquals(1, stat.getOSAndroidCount());
        Assert.assertEquals(1, stat.getOSAndroid41Count());
        Assert.assertEquals(0, stat.getOSLinuxUbuntuCount());
        Assert.assertEquals(0, stat.getOSMacOSXCount());
        Assert.assertEquals(0, stat.getOSWindowsCount());
        Assert.assertEquals(0, stat.getOSWindows8Count());
        Assert.assertEquals(0, stat.getOSSymbianCount());
        Assert.assertEquals(0, stat.getOSFreeBSDCount());
        Assert.assertEquals(0, stat.getOSOpenBSDCount());
    }
}
