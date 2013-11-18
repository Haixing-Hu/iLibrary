/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import cn.edu.nju.starfish.ilibrary.model.tag.Taggable;

import static cn.edu.nju.starfish.ilibrary.utils.Argument.requireNonNull;

/**
 * The model of documents.
 *
 * @author Haixing Hu
 */
public class Document extends Taggable {

  protected int id;
  protected Classification classification;
  protected String type;
  protected String kind;
  protected String category;
  protected String subCategory;
  protected List<Field> fields;
  protected String url;
  protected Map<DigitIdentifier, String> digitIds;
  protected Language language;
  protected String copyright;
  protected String citeKey;
  protected Date importDate;
  protected Date lastReadDate;
  protected Date lastPrintDate;
  protected List<String> files;
  protected byte rating;
  protected ReadStatus readStatus;

  /**
   * Construct a {@link Document}.
   */
  public Document() {
    id = - 1;
    classification = Classification.ARTICLE;
    type = null;
    fields = null;
    category = null;
    subCategory = null;
    url = null;
    digitIds = null;
    language = null;
    copyright = null;
    citeKey = null;
    rating = - 1;
    importDate = null;
    lastReadDate = null;
    lastPrintDate = null;
    files = null;
    readStatus = ReadStatus.UNREAD;
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
   * Gets the classification of the document.
   *
   * @return the classification of the document, which will never be
   *         <code>null</code>.
   */
  public Classification getClassification() {
    return classification;
  }

  /**
   * Sets the classification of the document.
   *
   * @param classification
   *          the new classification to set, which cannot be <code>null</code>.
   */
  public void setClassification(Classification classification) {
    this.classification = requireNonNull("classification", classification);
  }

  /**
   * Gets the type of the document.
   *
   * @return the type of the document.
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type of the document.
   *
   * @param type
   *          the new type to set.
   */
  public void setType(@Nullable String type) {
    this.type = type;
  }

  /**
   * Gets the kind of the document.
   *
   * @return the kind of the document.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Sets the kind of the document.
   *
   * @param kind
   *          the new kind to set.
   */
  public void setKind(@Nullable String kind) {
    this.kind = kind;
  }

  /**
   * Gets the category of the document.
   *
   * @return the category of the document.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category of the document.
   *
   * @param category
   *          the new category to set.
   */
  public void setCategory(@Nullable String category) {
    this.category = category;
  }

  /**
   * Gets the sub-category of the document.
   *
   * @return the sub-category of the document.
   */
  public String getSubCategory() {
    return subCategory;
  }

  /**
   * Sets the sub-category of the document.
   *
   * @param subCategory
   *          the new sub-category to set.
   */
  public void setSubCategory(@Nullable String subCategory) {
    this.subCategory = subCategory;
  }

  /**
   * Gets the fields of the document.
   *
   * @return the fields of the document.
   */
  public List<Field> getFields() {
    return fields;
  }

  /**
   * Sets the fields of the document.
   *
   * @param fields
   *          the new fields to set.
   */
  public void setFields(@Nullable List<Field> fields) {
    this.fields = fields;
  }

  /**
   * Gets the URL of the document.
   *
   * @return the URL of the document.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the URL of the document.
   *
   * @param url
   *          the new URL to set.
   */
  public void setUrl(@Nullable String url) {
    this.url = url;
  }

  /**
   * Gets the digit identifiers of this document.
   *
   * @return the digit identifiers of this document, represented as a map for
   *         the digit identifier types to their values.
   */
  public Map<DigitIdentifier, String> getDigitIds() {
    return digitIds;
  }

  /**
   * Sets the digit identifiers of this document.
   *
   * @param digitIds
   *          the new digit identifiers of this document, represented as a map
   *          for the digit identifier types to their values.
   */
  public void setDigitIds(@Nullable Map<DigitIdentifier, String> digitIds) {
    this.digitIds = digitIds;
  }

  /**
   * Gets the language of this document.
   *
   * @return the language of this document.
   */
  public Language getLanguage() {
    return language;
  }

  /**
   * Sets the language of this document.
   *
   * @param language
   *          the new language to set.
   */
  public void setLanguage(@Nullable Language language) {
    this.language = language;
  }

  /**
   * Gets the copyright of this document.
   *
   * @return the copyright of this document.
   */
  public String getCopyright() {
    return copyright;
  }

  /**
   * Sets the copyright of this document.
   *
   * @param copyright
   *          the new copyright to set.
   */
  public void setCopyright(@Nullable String copyright) {
    this.copyright = copyright;
  }

  /**
   * Gets the citation key of this document.
   *
   * @return the citation key of this document.
   */
  public String getCiteKey() {
    return citeKey;
  }

  /**
   * Sets the citation key of this document.
   *
   * @param citeKey
   *          the new citation key to set.
   */
  public void setCiteKey(@Nullable String citeKey) {
    this.citeKey = citeKey;
  }

  /**
   * Gets the importing date of this document.
   *
   * @return the importing date of this document.
   */
  public Date getImportDate() {
    return importDate;
  }

  /**
   * Sets the importing date of this document.
   *
   * @param importDate
   *          the new importing date to set.
   */
  public void setImportDate(@Nullable Date importDate) {
    this.importDate = importDate;
  }

  /**
   * Gets the last read date of this document.
   *
   * @return the last read date of this document.
   */
  public Date getLastReadDate() {
    return lastReadDate;
  }

  /**
   * Sets the last read date of this document.
   *
   * @param lastReadDate
   *          the new last read date to set.
   */
  public void setLastReadDate(@Nullable Date lastReadDate) {
    this.lastReadDate = lastReadDate;
  }

  /**
   * Gets the last print date of this document.
   *
   * @return the last print date of this document, or <code>null</code> if this
   *         document has not been printed.
   */
  public Date getLastPrintDate() {
    return lastPrintDate;
  }

  /**
   * Sets the last read print of this document.
   *
   * @param lastPrintDate
   *          the new last print date to set, or <code>null</code> if this
   *          document has not been printed.
   */
  public void setLastPrintDate(@Nullable Date lastPrintDate) {
    this.lastPrintDate = lastPrintDate;
  }

  /**
   * Gets the list of paths of files of this document.
   *
   * @return the list of paths of files of this document, or <code>null</code>
   *         if this document has no file.
   */
  public List<String> getFiles() {
    return files;
  }

  /**
   * Sets the list of paths of files of this document.
   *
   * @return the new list of paths of files of this document, or
   *         <code>null</code> if this document has no file.
   */
  public void setFiles(List<String> files) {
    this.files = files;
  }

  /**
   * Gets the rating of this document.
   * <p>
   * A value of -1 indicates that this document has not been rated.
   *
   * @return the rating of this document.
   */
  public byte getRating() {
    return rating;
  }

  /**
   * Sets the rating of this document.
   * <p>
   * A value of -1 indicates that this document has not been rated.
   *
   * @param rating
   *          the new rating to set.
   */
  public void setRating(byte rating) {
    this.rating = rating;
  }

  /**
   * Gets the readStatus.
   *
   * @return the readStatus.
   */
  public ReadStatus getReadStatus() {
    return readStatus;
  }

  /**
   * Sets the readStatus.
   *
   * @param readStatus
   *          the new readStatus to set.
   */
  public void setReadStatus(ReadStatus readStatus) {
    this.readStatus = readStatus;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
