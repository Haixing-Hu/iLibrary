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

import com.github.haixing_hu.csl.Type;
import com.github.haixing_hu.csl.Variable;

/**
 * This class provides test data for testing {@link DocumentTemplate} and
 * related classes.
 *
 * @author Haixing Hu
 */
public class JournalArticle {

  public static FieldTemplate getTitleField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("title")
           .setType(DataType.STRING)
           .setMultiple(false);
    return builder.build();
  }

  public static String getTitleFieldXml() {
    return "<field name='title' type='string' multiple='false'/>";
  }

  public static FieldTemplate getOriginalTitleField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("original-title")
        .setType(DataType.STRING)
        .setMultiple(false);
    return builder.build();
  }

  public static String getOriginalTitleFieldXml() {
    return "<field name='original-title' type='string' multiple='false'/>";
  }

  public static FieldTemplate getAuthorsField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("authors")
        .setType(DataType.RESPONSIBILITY)
        .setMultiple(true);
    return builder.build();
  }

  public static String getAuthorsFieldXml() {
    return "<field name='authors' type='responsibility' multiple='true'/>";
  }

  public static FieldTemplate getTranslatorsField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("translators")
        .setType(DataType.RESPONSIBILITY)
        .setMultiple(true);
    return builder.build();
  }

  public static String getTranslatorsFieldXml() {
    return "<field name='translators' type='responsibility' multiple='true'/>";
  }

  public static FieldTemplate getAbstractField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("abstract")
           .setType(DataType.STRING)
           .setMultiple(true);
    return builder.build();
  }

  public static String getAbstractFieldXml() {
    return "<field name='abstract' type='string' multiple='true'/>";
  }

  public static FieldTemplate getJournalField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("journal")
           .setType(DataType.PERIODICAL)
           .setMultiple(false);
    return builder.build();
  }

  public static String getJournalFieldXml() {
    return "<field name='journal' type='periodical' multiple='false'/>";
  }

  public static FieldTemplate getVolumeField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("volume")
          .setType(DataType.STRING)
          .setMultiple(false);
    return builder.build();
  }

  public static String getVolumeFieldXml() {
    return "<field name='volume' type='string' multiple='false'/>";
  }

  public static FieldTemplate getIssueField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("issue")
           .setType(DataType.STRING)
           .setMultiple(false);
    return builder.build();
  }

  public static String getIssueFieldXml() {
    return "<field name='issue' type='string' multiple='false'/>";
  }

  public static FieldTemplate getNumberField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("number")
           .setType(DataType.STRING)
           .setMultiple(false);
    return builder.build();
  }

  public static String getNumberFieldXml() {
    return "<field name='number' type='string' multiple='false'/>";
  }

  public static FieldTemplate getPagesField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("pages")
           .setType(DataType.STRING)
           .setMultiple(false);
    return builder.build();
  }

  public static String getPagesFieldXml() {
    return "<field name='pages' type='string' multiple='false'/>";
  }

  public static FieldTemplate getSubmittedDateField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("submitted-date")
           .setType(DataType.DATE)
           .setMultiple(false);
    return builder.build();
  }

  public static String getSubmittedDateFieldXml() {
    return "<field name='submitted-date' type='date' multiple='false'/>";
  }

  public static FieldTemplate getRevisedDateField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("revised-date").setType(DataType.DATE).setMultiple(false);
    return builder.build();
  }

  public static String getRevisedDateFieldXml() {
    return "<field name='revised-date' type='date' multiple='false'/>";
  }

  public static FieldTemplate getAcceptedDateField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("accepted-date").setType(DataType.DATE).setMultiple(false);
    return builder.build();
  }

  public static String getAcceptedDateFieldXml() {
    return "<field name='accepted-date' type='date' multiple='false'/>";
  }

  public static FieldTemplate getPublishedDateField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("published-date").setType(DataType.DATE).setMultiple(false);
    return builder.build();
  }

  public static String getPublishedDateFieldXml() {
    return "<field name='published-date' type='date' multiple='false'/>";
  }

  public static FieldTemplate getLanguageField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("language").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getLanguageFieldXml() {
    return "<field name='language' type='string' multiple='false'/>";
  }

  public static FieldTemplate getCopyrightField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("copyright").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getCopyrightFieldXml() {
    return "<field name='copyright' type='string' multiple='false'/>";
  }

  public static FieldTemplate getAccessModeField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder
        .setName("access-mode")
        .setType(DataType.ACCESS_MODE)
        .setMultiple(false);
    return builder.build();
  }

  public static String getAccessModeFieldXml() {
    return "<field name='access-mode' type='access-mode' multiple='false'/>";
  }

  public static FieldTemplate getUrlField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("url").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getUrlFieldXml() {
    return "<field name='url' type='string' multiple='false'/>";
  }

  public static FieldTemplate getPdfUrlField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("pdf-url").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getPdfUrlFieldXml() {
    return "<field name='pdf-url' type='string' multiple='false'/>";
  }

  public static FieldTemplate getDoiField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("doi").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getDoiFieldXml() {
    return "<field name='doi' type='string' multiple='false'/>";
  }

  public static FieldTemplate getPmcidField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("pmcid").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getPmcidFieldXml() {
    return "<field name='pmcid' type='string' multiple='false'/>";
  }

  public static FieldTemplate getPmidField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("pmid").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getPmidFieldXml() {
    return "<field name='pmid' type='string' multiple='false'/>";
  }

  public static FieldTemplate getStatusField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("status").setType(DataType.STRING).setMultiple(false);
    return builder.build();
  }

  public static String getStatusFieldXml() {
    return "<field name='status' type='string' multiple='false'/>";
  }

  public static FieldTemplate getReadField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder.setName("read").setType(DataType.READ_STATUS).setMultiple(false);
    return builder.build();
  }

  public static String getReadFieldXml() {
    return "<field name='read' type='read-status' multiple='false'/>";
  }

  public static FieldTemplate getPrintedField() {
    final FieldTemplateBuilder builder = new FieldTemplateBuilder();
    builder
        .setName("printed")
        .setType(DataType.PRINT_STATUS)
        .setMultiple(false);
    return builder.build();
  }

  public static String getPrintedFieldXml() {
    return "<field name='printed' type='print-status' multiple='false'/>";
  }

  public static FieldGroupTemplate getTitleGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.TITLE)
           .addField(getTitleField())
           .addField(getOriginalTitleField());
    return builder.build();
  }

  public static String getTitleGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='title'>")
           .append(getTitleFieldXml())
           .append(getOriginalTitleFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static FieldGroupTemplate getResponsibilityGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.RESPONSIBILITY)
           .addField(getAuthorsField())
           .addField(getTranslatorsField());
    return builder.build();
  }

  public static String getResponsibilityGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='responsibility'>")
           .append(getAuthorsFieldXml())
           .append(getTranslatorsFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static FieldGroupTemplate getAbstractGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.ABSTRACT)
           .addField(getAbstractField());
    return builder.build();
  }

  public static String getAbstractGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='abstract'>")
           .append(getAbstractFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static FieldGroupTemplate getPublicationGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.PUBLICATION)
           .addField(getJournalField())
           .addField(getVolumeField())
           .addField(getIssueField())
           .addField(getNumberField())
           .addField(getPagesField())
           .addField(getSubmittedDateField())
           .addField(getRevisedDateField())
           .addField(getAcceptedDateField())
           .addField(getPublishedDateField())
           .addField(getLanguageField())
           .addField(getCopyrightField());
    return builder.build();
  }

  public static String getPublicationGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='publication'>")
           .append(getJournalFieldXml())
           .append(getVolumeFieldXml())
           .append(getIssueFieldXml())
           .append(getNumberFieldXml())
           .append(getPagesFieldXml())
           .append(getSubmittedDateFieldXml())
           .append(getRevisedDateFieldXml())
           .append(getAcceptedDateFieldXml())
           .append(getPublishedDateFieldXml())
           .append(getLanguageFieldXml())
           .append(getCopyrightFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static FieldGroupTemplate getAccessGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.ACCESS)
           .addField(getAccessModeField())
           .addField(getUrlField())
           .addField(getPdfUrlField())
           .addField(getDoiField())
           .addField(getPmcidField())
           .addField(getPmidField());
    return builder.build();
  }

  public static String getAccessGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='access'>")
           .append(getAccessModeFieldXml())
           .append(getUrlFieldXml())
           .append(getPdfUrlFieldXml())
           .append(getDoiFieldXml())
           .append(getPmcidFieldXml())
           .append(getPmidFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static FieldGroupTemplate getStatusGroup() {
    final FieldGroupTemplateBuilder builder = new FieldGroupTemplateBuilder();
    builder.setGroup(FieldGroup.STATUS)
           .addField(getStatusField())
           .addField(getReadField())
           .addField(getPrintedField());
    return builder.build();
  }

  public static String getStatusGroupXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<group name='status'>")
           .append(getStatusFieldXml())
           .append(getReadFieldXml())
           .append(getPrintedFieldXml())
           .append("</group>");
    return builder.toString();
  }

  public static DocumentTemplate getDocumentTemplate() {
    final DocumentTemplateBuilder builder = new DocumentTemplateBuilder();
    builder.setName("journal-article")
            .setType(DocumentType.ARTICLE)
            .setCslType(Type.ARTICLE_JOURNAL)
            .setDefaultKind("article")
            .addKind("abstract")
            .addKind("article")
            .addKind("commentary")
            .addKind("editorial")
            .addKind("electronic-article")
            .addKind("extended-abstract")
            .addKind("letter")
            .addKind("news-and-views")
            .addKind("rebuttal")
            .addKind("review")
            .addKind("---")
            .addKind("erratum")
            .addKind("retraction")
            .addFieldGroup(getTitleGroup())
            .addFieldGroup(getResponsibilityGroup())
            .addFieldGroup(getAbstractGroup())
            .addFieldGroup(getPublicationGroup())
            .addFieldGroup(getAccessGroup())
            .addFieldGroup(getStatusGroup())
            .addVariableMapping(Variable.TITLE, "title")
            .addVariableMapping(Variable.ORIGINAL_TITLE, "original-title")
            .addVariableMapping(Variable.AUTHOR, "authors.name")
            .addVariableMapping(Variable.TRANSLATOR, "translators.name")
            .addVariableMapping(Variable.ABSTRACT, "abstract")
            .addVariableMapping(Variable.CONTAINER_TITLE, "journal.title")
            .addVariableMapping(Variable.CONTAINER_TITLE_SHORT, "journal.short-title")
            .addVariableMapping(Variable.VOLUME, "volume")
            .addVariableMapping(Variable.NUMBER, "number")
            .addVariableMapping(Variable.ISSUE, "issue")
            .addVariableMapping(Variable.PAGE, "pages")
            .addVariableMapping(Variable.SUBMITTED, "submitted-date")
            .addVariableMapping(Variable.ISSUED, "published-date")
            .addVariableMapping(Variable.STATUS, "status")
            .addVariableMapping(Variable.GENRE, "kind");
    return builder.build();
  }

  public static String getCslMappingXml(final Variable variable,
      final String field) {
    final StringBuilder builder = new StringBuilder();
    builder.append("<rule>")
           .append("<variable>")
           .append(variable.getName())
           .append("</variable>")
           .append("<field>")
           .append(field)
           .append("</field>")
           .append("</rule>");
    return builder.toString();
  }

  public static String getDocumentTemplateXml() {
    final StringBuilder builder = new StringBuilder();
    builder.append("<document>")
           .append("<name>journal-article</name>")
           .append("<type>article</type>")
           .append("<csl-type>article-journal</csl-type>")
           .append("<default-kind>article</default-kind>")
           .append("<kinds>")
           .append("<kind>abstract</kind>")
           .append("<kind>article</kind>")
           .append("<kind>commentary</kind>")
           .append("<kind>editorial</kind>")
           .append("<kind>electronic-article</kind>")
           .append("<kind>extended-abstract</kind>")
           .append("<kind>letter</kind>")
           .append("<kind>news-and-views</kind>")
           .append("<kind>rebuttal</kind>")
           .append("<kind>review</kind>")
           .append("<kind>---</kind>")
           .append("<kind>erratum</kind>")
           .append("<kind>retraction</kind>")
           .append("</kinds>")
           .append("<fields>")
           .append(getTitleGroupXml())
           .append(getResponsibilityGroupXml())
           .append(getAbstractGroupXml())
           .append(getPublicationGroupXml())
           .append(getAccessGroupXml())
           .append(getStatusGroupXml())
           .append("</fields>")
           .append("<variable-mapping>")
           .append(getCslMappingXml(Variable.TITLE, "title"))
           .append(getCslMappingXml(Variable.ORIGINAL_TITLE, "original-title"))
           .append(getCslMappingXml(Variable.AUTHOR, "authors.name"))
           .append(getCslMappingXml(Variable.TRANSLATOR, "translators.name"))
           .append(getCslMappingXml(Variable.ABSTRACT, "abstract"))
           .append(getCslMappingXml(Variable.CONTAINER_TITLE, "journal.title"))
           .append(getCslMappingXml(Variable.CONTAINER_TITLE_SHORT,
               "journal.short-title"))
           .append(getCslMappingXml(Variable.VOLUME, "volume"))
           .append(getCslMappingXml(Variable.NUMBER, "number"))
           .append(getCslMappingXml(Variable.ISSUE, "issue"))
           .append(getCslMappingXml(Variable.PAGE, "pages"))
           .append(getCslMappingXml(Variable.SUBMITTED, "submitted-date"))
           .append(getCslMappingXml(Variable.ISSUED, "published-date"))
           .append(getCslMappingXml(Variable.STATUS, "status"))
           .append(getCslMappingXml(Variable.GENRE, "kind"))
           .append("</variable-mapping>")
           .append("</document>");

    return builder.toString();
  }
}
