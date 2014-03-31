/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.utils.jaxb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * The XML adaptor for the display names.
 *
 * @author Haixing Hu
 */
public final class DisplayNamesAdaptor extends
    XmlAdapter<ArrayList<DisplayName>, Map<String, String>> {

  @Override
  public Map<String, String> unmarshal(ArrayList<DisplayName> list) throws Exception {
    final Map<String, String> result = new HashMap<String, String>(list.size());
    for (final DisplayName d : list) {
      result.put(d.getLocale(), d.getName());
    }
    return result;
  }

  @Override
  public ArrayList<DisplayName> marshal(Map<String, String> map) throws Exception {
    final ArrayList<DisplayName> result = new ArrayList<DisplayName>(map.size());
    for (final Map.Entry<String, String> entry : map.entrySet()) {
      result.add(new DisplayName(entry.getKey(), entry.getValue()));
    }
    return result;
  }

}
