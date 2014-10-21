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

import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.data.model.common.Organization;

/**
 * The model of periodical, which store the information of an periodical.
 *
 * @author Haixing Hu
 */
public final class Periodical {

  private int id;
  private String title;
  private String subtitle;
  private List<Responsibility> editors;
  private Organization publisher;
  private String synopsis;
  private String abbreviation;
  private String city;
  private long circulation;
  private double factor;
  private DatePoint startDate;
  private DatePoint endDate;
  private Frequency frequency;
  private String url;
  private String rss;
  private String doi;
  private String issn;
  private String citeKey;
  private Language language;
  private boolean subscribed;
  private String copyright;
  private int documentCount;

  /**
   * Default constructs a {@link Periodical}.
   */
  public Periodical() {
    id = -1;
    title = null;
    subtitle = null;
    editors = null;
    publisher = null;
    synopsis = null;
    abbreviation = null;
    city = null;
    circulation = 0;
    factor = 0.0;
    startDate = null;
    endDate = null;
    frequency = null;
    url = null;
    rss = null;
    doi = null;
    issn = null;
    citeKey = null;
    language = null;
    subscribed = false;
    copyright = null;
    documentCount = 0;
  }

  /**
   * Gets the id.
   *
   * @return the id.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id to set.
   */
  public void setId(final int id) {
    this.id = id;
  }

  /**
   * Gets the title.
   *
   * @return the title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title.
   *
   * @param title
   *          the new title to set.
   */
  public void setTitle(@Nullable final String title) {
    this.title = title;
  }

  /**
   * Gets the subtitle.
   *
   * @return the subtitle.
   */
  public String getSubtitle() {
    return subtitle;
  }

  /**
   * Sets the subtitle.
   *
   * @param subtitle
   *          the new subtitle to set.
   */
  public void setSubtitle(@Nullable final String subtitle) {
    this.subtitle = subtitle;
  }

  /**
   * Gets the editors.
   *
   * @return the editors.
   */
  public List<Responsibility> getEditors() {
    return editors;
  }

  /**
   * Sets the editors.
   *
   * @param editors
   *          the new editors to set.
   */
  public void setEditors(@Nullable final List<Responsibility> editors) {
    this.editors = editors;
  }

  /**
   * Gets the publisher.
   *
   * @return the publisher.
   */
  public Organization getPublisher() {
    return publisher;
  }

  /**
   * Sets the publisher.
   *
   * @param publisher
   *          the new publisher to set.
   */
  public void setPublisher(@Nullable final Organization publisher) {
    this.publisher = publisher;
  }

  /**
   * Gets the synopsis.
   *
   * @return the synopsis.
   */
  public String getSynopsis() {
    return synopsis;
  }

  /**
   * Sets the synopsis.
   *
   * @param synopsis
   *          the new synopsis to set.
   */
  public void setSynopsis(@Nullable final String synopsis) {
    this.synopsis = synopsis;
  }

  /**
   * Gets the abbreviation.
   *
   * @return the abbreviation.
   */
  public String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets the abbreviation.
   *
   * @param abbreviation
   *          the new abbreviation to set.
   */
  public void setAbbreviation(@Nullable final String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the city.
   *
   * @return the city.
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets the city.
   *
   * @param city
   *          the new city to set.
   */
  public void setCity(@Nullable final String city) {
    this.city = city;
  }

  /**
   * Gets the circulation.
   *
   * @return the circulation.
   */
  public long getCirculation() {
    return circulation;
  }

  /**
   * Sets the circulation.
   *
   * @param circulation
   *          the new circulation to set.
   */
  public void setCirculation(final long circulation) {
    this.circulation = circulation;
  }

  /**
   * Gets the factor.
   *
   * @return the factor.
   */
  public double getFactor() {
    return factor;
  }

  /**
   * Sets the factor.
   *
   * @param factor
   *          the new factor to set.
   */
  public void setFactor(final double factor) {
    this.factor = factor;
  }

  /**
   * Gets the startDate.
   *
   * @return the startDate.
   */
  public DatePoint getStartDate() {
    return startDate;
  }

  /**
   * Sets the startDate.
   *
   * @param startDate
   *          the new startDate to set.
   */
  public void setStartDate(@Nullable final DatePoint startDate) {
    this.startDate = startDate;
  }

  /**
   * Gets the endDate.
   *
   * @return the endDate.
   */
  public DatePoint getEndDate() {
    return endDate;
  }

  /**
   * Sets the endDate.
   *
   * @param endDate
   *          the new endDate to set.
   */
  public void setEndDate(@Nullable final DatePoint endDate) {
    this.endDate = endDate;
  }

  /**
   * Gets the frequency.
   *
   * @return the frequency.
   */
  public Frequency getFrequency() {
    return frequency;
  }

  /**
   * Sets the frequency.
   *
   * @param frequency
   *          the new frequency to set.
   */
  public void setFrequency(@Nullable final Frequency frequency) {
    this.frequency = frequency;
  }

  /**
   * Gets the url.
   *
   * @return the url.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url
   *          the new url to set.
   */
  public void setUrl(@Nullable final String url) {
    this.url = url;
  }

  /**
   * Gets the rss.
   *
   * @return the rss.
   */
  public String getRss() {
    return rss;
  }

  /**
   * Sets the rss.
   *
   * @param rss
   *          the new rss to set.
   */
  public void setRss(@Nullable final String rss) {
    this.rss = rss;
  }

  /**
   * Gets the doi.
   *
   * @return the doi.
   */
  public String getDoi() {
    return doi;
  }

  /**
   * Sets the doi.
   *
   * @param doi
   *          the new doi to set.
   */
  public void setDoi(@Nullable final String doi) {
    this.doi = doi;
  }

  /**
   * Gets the issn.
   *
   * @return the issn.
   */
  public String getIssn() {
    return issn;
  }

  /**
   * Sets the issn.
   *
   * @param issn
   *          the new issn to set.
   */
  public void setIssn(@Nullable final String issn) {
    this.issn = issn;
  }

  /**
   * Gets the citeKey.
   *
   * @return the citeKey.
   */
  public String getCiteKey() {
    return citeKey;
  }

  /**
   * Sets the citeKey.
   *
   * @param citeKey
   *          the new citeKey to set.
   */
  public void setCiteKey(@Nullable final String citeKey) {
    this.citeKey = citeKey;
  }

  /**
   * Gets the language.
   *
   * @return the language.
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Sets the language.
   *
   * @param language
   *          the new language to set.
   */
  public void setLanguage(@Nullable final Language language) {
    this.language = language;
  }

  /**
   * Gets the subscribed.
   *
   * @return the subscribed.
   */
  public boolean isSubscribed() {
    return subscribed;
  }

  /**
   * Sets the subscribed.
   *
   * @param subscribed
   *          the new subscribed to set.
   */
  public void setSubscribed(final boolean subscribed) {
    this.subscribed = subscribed;
  }

  /**
   * Gets the copyright.
   *
   * @return the copyright.
   */
  public String getCopyright() {
    return copyright;
  }

  /**
   * Sets the copyright.
   *
   * @param copyright
   *          the new copyright to set.
   */
  public void setCopyright(@Nullable final String copyright) {
    this.copyright = copyright;
  }

  /**
   * Gets the document count.
   *
   * @return the document count.
   */
  public int getDocumentCount() {
    return documentCount;
  }

  /**
   * Sets the document count.
   *
   * @param documentCount
   *          the new document count to set.
   */
  public void setDocumentCount(final int documentCount) {
    this.documentCount = documentCount;
  }

//  /**
//   * Gets the access mode of this periodical.
//   * <p>
//   * This function will check the tags of this object, and returns the name of
//   * the first tag whose scope is {@link TagScope#ACCESS_MODE}. If there is no
//   * such tag, this function will return the name of {@link AccessMode#NONE}.
//   *
//   * @return the name of the access mode of this periodical.
//   */
//  public String getAccessMode() {
//    return AccessModeTag.getAccessMode(tags);
//  }
//
//  /**
//   * Sets the access mode to this periodical.
//   * <p>
//   * After calling this function, the old tag or tags representing an access
//   * mode will be removed, and a new tag representing the specified access mode
//   * will be added to the tag list.
//   *
//   * @param accessMode
//   *          the name of the new access mode to be set to this periodical.
//   */
//  public void setAccessMode(final String accessMode) {
//    tags = AccessModeTag.setAccessMode(tags, accessMode);
//  }
//
//  /**
//   * Gets the type of this periodical.
//   * <p>
//   * This function will check the tags of this object, and returns the name of
//   * the first tag whose scope is {@link TagScope#PERIODICAL_TYPE}. If there is
//   * no such tag, this function will return {@code null}.
//   *
//   * @return the name of the type of this periodical.
//   */
//  public String getType() {
//    return PeriodicalTypeTag.getPeriodicalType(tags);
//  }
//
//  /**
//   * Sets the type of this periodical.
//   * <p>
//   * After calling this function, the old tag or tags representing a periodical
//   * will be removed, and a new tag representing the specified periodical type
//   * will be added to the tag list.
//   *
//   * @param type
//   *          the name of the new periodical type to be set to this periodical.
//   */
//  public void setType(final String type) {
//    tags = PeriodicalTypeTag.setPeriodicalType(tags, type);
//  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
