/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import cn.edu.nju.starfish.ilibrary.model.tag.Taggable;

/**
 * The model of persons, which may be a person or an institute.
 *
 * @author Haixing Hu
 */
public class Person extends Taggable {

  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String suffix;
  private String title;
  private String displayName;
  private String nickname;
  private String email;
  private WebSite homepage;
  private Institute institute;
  private String description;
  private int documentCount;

  /**
   * Default constructs a {@link Person}.
   */
  public Person() {
    id = - 1;
    firstName = null;
    middleName = null;
    lastName = null;
    suffix = null;
    title = null;
    displayName = null;
    nickname = null;
    email = null;
    homepage = null;
    institute = null;
    description = null;
    documentCount = 0;
  }

  /**
   * Constructs a {@link Person}.
   *
   * @param firstName
   *          the first name of the new person.
   * @param lastName
   *          the last name of the new person.
   */
  public Person(@Nullable String firstName, @Nullable String lastName) {
    this.id = - 1;
    this.firstName = firstName;
    this.middleName = null;
    this.lastName = lastName;
    this.suffix = null;
    this.title = null;
    this.displayName = null;
    this.nickname = null;
    this.homepage = null;
    this.email = null;
    this.description = null;
    this.institute = null;
    this.documentCount = 0;
  }

  /**
   * Constructs a {@link Person}.
   *
   * @param firstName
   *          the first name of the new person.
   * @param middleName
   *          the middle name of the new person.
   * @param lastName
   *          the last name of the new person.
   */
  public Person(@Nullable String firstName, @Nullable String middleName,
      @Nullable String lastName) {
    this.id = - 1;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.suffix = null;
    this.title = null;
    this.displayName = null;
    this.nickname = null;
    this.homepage = null;
    this.email = null;
    this.description = null;
    this.institute = null;
    this.documentCount = 0;
  }

  /**
   * Gets the ID.
   *
   * @return the ID.
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the ID.
   *
   * @param id
   *          the new ID to set.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the first name.
   *
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   *
   * @param firstName
   *          the new first name to set.
   */
  public void setFirstName(@Nullable String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the middle name.
   *
   * @return the middle name.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Sets the middle name.
   *
   * @param middleName
   *          the new middle name to set.
   */
  public void setMiddleName(@Nullable String middleName) {
    this.middleName = middleName;
  }

  /**
   * Gets the last name.
   *
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   *
   * @param lastName
   *          the new last name to set.
   */
  public void setLastName(@Nullable String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the suffix.
   *
   * @return the suffix.
   */
  public String getSuffix() {
    return suffix;
  }

  /**
   * Sets the suffix.
   *
   * @param suffix
   *          the new suffix to set.
   */
  public void setSuffix(@Nullable String suffix) {
    this.suffix = suffix;
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
   * Gets the display name.
   *
   * @return the display name.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Sets the display name.
   *
   * @param displayName
   *          the new display name to set.
   */
  public void setDisplayName(@Nullable String displayName) {
    this.displayName = displayName;
  }

  /**
   * Gets the nickname.
   *
   * @return the nickname.
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * Sets the nickname.
   *
   * @param nickname
   *          the new nickname to set.
   */
  public void setNickname(@Nullable String nickname) {
    this.nickname = nickname;
  }

  /**
   * Gets the email.
   *
   * @return the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   *
   * @param email
   *          the new email to set.
   */
  public void setEmail(@Nullable String email) {
    this.email = email;
  }

  /**
   * Gets the home page.
   *
   * @return the home page.
   */
  public WebSite getHomepage() {
    return homepage;
  }

  /**
   * Sets the home page.
   *
   * @param homepage
   *          the new home page to set.
   */
  public void setHomepage(@Nullable WebSite homepage) {
    this.homepage = homepage;
  }

  /**
   * Gets the institute.
   *
   * @return the institute.
   */
  public Institute getInstitute() {
    return institute;
  }

  /**
   * Sets the institute.
   *
   * @param institute
   *          the new institute to set.
   */
  public void setInstitute(@Nullable Institute institute) {
    this.institute = institute;
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
  public void setDescription(@Nullable String description) {
    this.description = description;
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

  /**
   * Tests whether the name of this author equals the other author.
   *
   * @param other
   *          the other author.
   * @return <code>true</code> if the name of this author equals the other
   *         author; <code>false</code> otherwise.
   */
  public boolean isNameEquals(Person other) {
    return StringUtils.equalsIgnoreCase(this.firstName, other.firstName)
        && StringUtils.equalsIgnoreCase(this.middleName, other.middleName)
        && StringUtils.equalsIgnoreCase(this.lastName, other.lastName);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
