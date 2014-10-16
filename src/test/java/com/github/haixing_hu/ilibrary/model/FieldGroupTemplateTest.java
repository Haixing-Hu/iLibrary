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

import static com.github.haixing_hu.ilibrary.model.JournalArticle.getAccessGroup;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getAccessGroupXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getPublicationGroup;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getPublicationGroupXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getResponsibilityGroup;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getResponsibilityGroupXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getStatusGroup;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getStatusGroupXml;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getTitleGroup;
import static com.github.haixing_hu.ilibrary.model.JournalArticle.getTitleGroupXml;

/**
 * Unit test of the {@link FieldGroupTemplate} class.
 *
 * @author Haixing Hu
 */
public class FieldGroupTemplateTest
    extends XmlSerializationTest<FieldGroupTemplate> {

  public FieldGroupTemplateTest() {
    super(FieldGroupTemplate.class);

    final FieldGroupTemplate title = getTitleGroup();
    final String titleXml = getTitleGroupXml();
    marshalTestData.put(title, titleXml);
    unmarshalTestData.put(titleXml, title);

    final FieldGroupTemplate responsibility = getResponsibilityGroup();
    final String responsibilityXml = getResponsibilityGroupXml();
    marshalTestData.put(responsibility, responsibilityXml);
    unmarshalTestData.put(responsibilityXml, responsibility);

    final FieldGroupTemplate publication = getPublicationGroup();
    final String publicationXml = getPublicationGroupXml();
    marshalTestData.put(publication, publicationXml);
    unmarshalTestData.put(publicationXml, publication);

    final FieldGroupTemplate access = getAccessGroup();
    final String accessXml = getAccessGroupXml();
    marshalTestData.put(access, accessXml);
    unmarshalTestData.put(accessXml, access);

    final FieldGroupTemplate status = getStatusGroup();
    final String statusXml = getStatusGroupXml();
    marshalTestData.put(status, statusXml);
    unmarshalTestData.put(statusXml, status);

  }
}
