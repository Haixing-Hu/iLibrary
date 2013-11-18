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
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import cn.edu.nju.starfish.ilibrary.model.tag.Taggable;

/**
 * The model of conferences, which store the information of a conference.
 *
 * @author Haixing Hu
 */
public class Conference extends Taggable {

  private int id;
  private String title;
  private String subtitle;
  private String description;
  private List<Responsibility> organizers;
  private List<Person> keySpeakers;
  private List<Responsibility> sponsors;
  private Edition edition;
  private Publisher publisher;
  private String synopsis;
  private String abbreviation;
  private City city;
  private int attendees;
  private Day announcedDate;
  private Day deadlineDate;
  private Day startDate;
  private Day endDate;
  private String url;
  private String rss;
  private String isbn;
  private String citeKey;
  private Language language;
  private boolean attended;
  private boolean presented;
  private String copyright;

  /**
   * Default constructs a {@link Conference}.
   */
  public Conference() {
    id = -1;
    title = null;
    subtitle = null;
    description = null;
    organizers = null;
    keySpeakers = null;
    sponsors = null;
    edition = null;
    publisher = null;
    synopsis = null;
    abbreviation = null;
    city = null;
    attendees = 0;
    announcedDate = null;
    deadlineDate = null;
    startDate = null;
    endDate = null;
    url = null;
    rss = null;
    isbn = null;
    citeKey = null;
    language = null;
    attended = false;
    presented = false;
    copyright = null;
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
   * Gets the description.
   *
   * @return the description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description.
   *
   * @param description the new description to set.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the organizers.
   *
   * @return the organizers.
   */
  public List<Responsibility> getOrganizers() {
    return organizers;
  }

  /**
   * Sets the organizers.
   *
   * @param organizers
   *          the new organizers to set.
   */
  public void setOrganizers(@Nullable List<Responsibility> organizers) {
    this.organizers = organizers;
  }

  /**
   * Gets the keySpeakers.
   *
   * @return the keySpeakers.
   */
  public List<Person> getKeySpeakers() {
    return keySpeakers;
  }

  /**
   * Sets the keySpeakers.
   *
   * @param keySpeakers
   *          the new keySpeakers to set.
   */
  public void setKeySpeakers(@Nullable List<Person> keySpeakers) {
    this.keySpeakers = keySpeakers;
  }

  /**
   * Gets the sponsors.
   *
   * @return the sponsors.
   */
  public List<Responsibility> getSponsors() {
    return sponsors;
  }

  /**
   * Sets the sponsors.
   *
   * @param sponsors
   *          the new sponsors to set.
   */
  public void setSponsors(@Nullable List<Responsibility> sponsors) {
    this.sponsors = sponsors;
  }

  /**
   * Gets the edition.
   *
   * @return the edition.
   */
  public Edition getEdition() {
    return edition;
  }

  /**
   * Sets the edition.
   *
   * @param edition
   *          the new edition to set.
   */
  public void setEdition(@Nullable Edition edition) {
    this.edition = edition;
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
   * Gets the attendees.
   *
   * @return the attendees.
   */
  public int getAttendees() {
    return attendees;
  }

  /**
   * Sets the attendees.
   *
   * @param attendees
   *          the new attendees to set.
   */
  public void setAttendees(int attendees) {
    this.attendees = attendees;
  }

  /**
   * Gets the announcedDate.
   *
   * @return the announcedDate.
   */
  public Day getAnnouncedDate() {
    return announcedDate;
  }

  /**
   * Sets the announcedDate.
   *
   * @param announcedDate
   *          the new announcedDate to set.
   */
  public void setAnnouncedDate(@Nullable Day announcedDate) {
    this.announcedDate = announcedDate;
  }

  /**
   * Gets the deadlineDate.
   *
   * @return the deadlineDate.
   */
  public Day getDeadlineDate() {
    return deadlineDate;
  }

  /**
   * Sets the deadlineDate.
   *
   * @param deadlineDate
   *          the new deadlineDate to set.
   */
  public void setDeadlineDate(@Nullable Day deadlineDate) {
    this.deadlineDate = deadlineDate;
  }

  /**
   * Gets the startDate.
   *
   * @return the startDate.
   */
  public Day getStartDate() {
    return startDate;
  }

  /**
   * Sets the startDate.
   *
   * @param startDate
   *          the new startDate to set.
   */
  public void setStartDate(@Nullable Day startDate) {
    this.startDate = startDate;
  }

  /**
   * Gets the endDate.
   *
   * @return the endDate.
   */
  public Day getEndDate() {
    return endDate;
  }

  /**
   * Sets the endDate.
   *
   * @param endDate
   *          the new endDate to set.
   */
  public void setEndDate(@Nullable Day endDate) {
    this.endDate = endDate;
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
   * Gets the isbn.
   *
   * @return the isbn.
   */
  public String getIsbn() {
    return isbn;
  }

  /**
   * Sets the isbn.
   *
   * @param isbn
   *          the new isbn to set.
   */
  public void setIsbn(@Nullable String isbn) {
    this.isbn = isbn;
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
   * Gets the attended.
   *
   * @return the attended.
   */
  public boolean isAttended() {
    return attended;
  }

  /**
   * Sets the attended.
   *
   * @param attended
   *          the new attended to set.
   */
  public void setAttended(boolean attended) {
    this.attended = attended;
  }

  /**
   * Gets the presented.
   *
   * @return the presented.
   */
  public boolean isPresented() {
    return presented;
  }

  /**
   * Sets the presented.
   *
   * @param presented
   *          the new presented to set.
   */
  public void setPresented(boolean presented) {
    this.presented = presented;
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
    return ReflectionToStringBuilder.toString(this);
  }

}
