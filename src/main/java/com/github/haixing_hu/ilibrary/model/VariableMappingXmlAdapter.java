/*
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
 */
package com.github.haixing_hu.ilibrary.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.github.haixing_hu.csl.Variable;

/**
 * An {@link XmlAdapter} for the {@link VariableMapping} class.
 *
 * @author Haixing Hu
 */
public class VariableMappingXmlAdapter extends
    XmlAdapter<VariableMappingXmlAdapter.AdaptedMap, VariableMapping> {

  public static class AdaptedMap {

    @XmlElement(name = "rule")
    public List<VariableMappingRule> rules = new ArrayList<>();
  }

  @Override
  public VariableMapping unmarshal(final AdaptedMap adaptedMap)
      throws Exception {
    final VariableMapping map = new VariableMapping();
    for (final VariableMappingRule rule : adaptedMap.rules) {
      map.put(rule.getVariable(), rule.getField());
    }
    return map;
  }

  @Override
  public AdaptedMap marshal(final VariableMapping map)
      throws Exception {
    final AdaptedMap result = new AdaptedMap();
    for (final Map.Entry<Variable, String> entry : map.entrySet()) {
      result.rules.add(new VariableMappingRule(entry.getKey(), entry.getValue()));
    }
    return result;
  }

}
