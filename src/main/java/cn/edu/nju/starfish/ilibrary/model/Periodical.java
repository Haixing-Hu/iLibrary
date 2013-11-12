/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import cn.edu.nju.starfish.ilibrary.model.tag.Taggable;

/**
 * The model of periodical, which store the information of an periodical.
 *
 * @author Haixing Hu
 */
public class Periodical extends Taggable {

  private int id;
  private String title;
  private String subtitle;
  private List<Responsibility> editors;
  private Publisher publisher;
  private String synopsis;
  private String abbreviation;
  private City city;
  private long circulation;
  private double factor;
  private Date startDate;
  private Date endDate;
  private PublishFrequency frequency;
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
  public void setId(int id) {
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
  public void setTitle(@Nullable String title) {
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
  public void setSubtitle(@Nullable String subtitle) {
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
  public void setEditors(@Nullable List<Responsibility> editors) {
    this.editors = editors;
  }

  /**
   * Gets the publisher.
   *
   * @return the publisher.
   */
  public Publisher getPublisher() {
    return publisher;
  }

  /**
   * Sets the publisher.
   *
   * @param publisher
   *          the new publisher to set.
   */
  public void setPublisher(@Nullable Publisher publisher) {
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
  public void setSynopsis(@Nullable String synopsis) {
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
  public void setAbbreviation(@Nullable String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Gets the city.
   *
   * @return the city.
   */
  public City getCity() {
    return city;
  }

  /**
   * Sets the city.
   *
   * @param city
   *          the new city to set.
   */
  public void setCity(@Nullable City city) {
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
  public void setCirculation(long circulation) {
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
  public void setFactor(double factor) {
    this.factor = factor;
  }

  /**
   * Gets the startDate.
   *
   * @return the startDate.
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * Sets the startDate.
   *
   * @param startDate
   *          the new startDate to set.
   */
  public void setStartDate(@Nullable Date startDate) {
    this.startDate = startDate;
  }

  /**
   * Gets the endDate.
   *
   * @return the endDate.
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * Sets the endDate.
   *
   * @param endDate
   *          the new endDate to set.
   */
  public void setEndDate(@Nullable Date endDate) {
    this.endDate = endDate;
  }

  /**
   * Gets the frequency.
   *
   * @return the frequency.
   */
  public PublishFrequency getFrequency() {
    return frequency;
  }

  /**
   * Sets the frequency.
   *
   * @param frequency
   *          the new frequency to set.
   */
  public void setFrequency(@Nullable PublishFrequency frequency) {
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
  public void setUrl(@Nullable String url) {
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
  public void setRss(@Nullable String rss) {
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
  public void setDoi(@Nullable String doi) {
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
  public void setIssn(@Nullable String issn) {
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
  public void setCiteKey(@Nullable String citeKey) {
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
  public void setLanguage(@Nullable Language language) {
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
  public void setSubscribed(boolean subscribed) {
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
  public void setCopyright(@Nullable String copyright) {
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
  public void setDocumentCount(int documentCount) {
    this.documentCount = documentCount;
  }

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
  public boolean equals(Object obj) {
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
