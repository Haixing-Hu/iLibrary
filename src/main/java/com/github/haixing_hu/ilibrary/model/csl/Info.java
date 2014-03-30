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

package com.github.haixing_hu.ilibrary.model.csl;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * The model of meta information of a CSL.
 *
 * @author Haixing Hu
 */
@Root
public class Info {

  @Element
  private String id;

  @Element
  private String title;

  @ElementList(inline = true, required = false)
  private List<Author> authors;

  @ElementList(inline = true, required = false)
  private List<Author> contributors;

  @ElementList(inline = true, required = false)
  private List<Category> categories;

  @ElementList(inline = true, required = false)
  private List<String> ISSNs;

  @ElementList(inline = true, required = false)
  private List<String> EISSNs;

  @ElementList(inline = true, required = false)
  private List<String> ISSNLs;

  @Element(required = false)
  private Date published;
}
