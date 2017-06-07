package com.seven.designbox.designpatterns.patterns.proxy.bean; /*
 * Copyright 2016 Seven_Tang <yihongyuelan@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class UserBean {
    private boolean isVip;
    private String userName;

    public final boolean isVip() {
        return isVip;
    }

    public final void setVip(boolean vip) {
        isVip = vip;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String userName) {
        this.userName = userName;
    }
}