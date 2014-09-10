/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

@XmlJavaTypeAdapters({
  @XmlJavaTypeAdapter(type=Date.class, value=DateXmlAdaptor.class),
  @XmlJavaTypeAdapter(type=FieldDataType.class, value=FieldDataTypeXmlAdapter.class),
  @XmlJavaTypeAdapter(type=DocumentType.class, value=DocumentTypeXmlAdapter.class),
})
package com.github.haixing_hu.ilibrary.model;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.github.haixing_hu.util.jaxb.DateXmlAdaptor;

