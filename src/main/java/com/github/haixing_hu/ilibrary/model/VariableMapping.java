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

import java.util.HashMap;

import com.github.haixing_hu.csl.Variable;

/**
 * A {@link VariableMapping} represents the mapping from CSL standard
 * variables to the property values of a document.
 *
 * @author Haixing Hu
 */
public final class VariableMapping extends HashMap<Variable, String> {

  private static final long serialVersionUID = -1256514089091829214L;

  public VariableMapping() {
    super();
  }

}
