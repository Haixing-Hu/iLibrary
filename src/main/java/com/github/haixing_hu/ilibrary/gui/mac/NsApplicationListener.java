package com.github.haixing_hu.ilibrary.gui.mac;

/*
 * Copyright 2007 Eirik Bjorsnos.
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

public interface NsApplicationListener {
    void handleAbout(NsApplicationEvent event);
    void handleOpenApplication(NsApplicationEvent event);
    void handleOpenFile(NsApplicationEvent event);
    void handlePreferences(NsApplicationEvent event);
    void handlePrintFile(NsApplicationEvent event);
    void handleQuit(NsApplicationEvent event);
    void handleReOpenApplication(NsApplicationEvent event);
}
