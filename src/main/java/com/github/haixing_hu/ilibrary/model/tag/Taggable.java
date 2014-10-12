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
package com.github.haixing_hu.ilibrary.model.tag;

import java.util.List;

import javax.annotation.Nullable;

import com.github.haixing_hu.ilibrary.model.Label;

/**
 * The base class for all objects with a tag list.
 *
 * @author Haixing Hu
 */
public class Taggable {

  protected List<Tag> tags;

  /**
   * Default constructs a {@link Taggable} object.
   */
  public Taggable() {
    tags = null;
  }

  /**
   * Gets the tags.
   *
   * @return the tags.
   */
  public final List<Tag> getTags() {
    return tags;
  }

  /**
   * Sets the tags.
   *
   * @param tags
   *          the new tags to set.
   */
  public final void setTags(@Nullable List<Tag> tags) {
    this.tags = tags;
  }

  /**
   * Gets the list of tags in the specified scope from the tag list of this
   * object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @return the list of tags in the specified scope, or {@code null} if no
   *         such tag.
   */
  public final List<Tag> getTagsInScope(String scope) {
    return TagUtils.getTagsInScope(scope, tags);
  }

  /**
   * Gets the first tag in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @return the first tag in the specified scope, or {@code null} if no
   *         such tag.
   */
  public final Tag getFirstTagInScope(String scope) {
    return TagUtils.getFirstTagInScope(scope, tags);
  }

  /**
   * Adds a tag in the specified scope to the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param name
   *          the name of new tag in the specified scope to be added to the tag
   *          list.
   */
  public final void addTagInScope(String scope, String name) {
    tags = TagUtils.addTagInScope(scope, tags, name);
  }

  /**
   * Adds the tags in the specified scope to the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param names
   *          the names of new tags in the specified scope to be added to the tag
   *          list.
   */
  public final void addTagsInScope(String scope, List<String> names) {
    tags = TagUtils.addTagsInScope(scope, tags, names);
  }

  /**
   * Updates a tag in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param newName
   *          the name of new tag in the specified scope to be added to the tag
   *          list.
   */
  public final void updateTagInScope(String scope, String newName) {
    tags = TagUtils.updateTagInScope(scope, tags, newName);
  }

  /**
   * Updates the tags in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param newNames
   *          the names of new tags in the specified scope to be added to the
   *          tag list.
   */
  public final void updateTagsInScope(String scope, List<String> newNames) {
    tags = TagUtils.updateTagsInScope(scope, tags, newNames);
  }

  /**
   * Removes a tag in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param name
   *          the name of tag in the specified scope to be removed from the tag
   *          list.
   */
  public final void removeTagInScope(String scope, String name) {
    TagUtils.removeTagInScope(scope, tags, name);
  }

  /**
   * Removes tags in the specified scope from the tag list of this object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   * @param names
   *          the names of tags in the specified scope to be removed from the tag
   *          list.
   */
  public final void removeTagsInScope(String scope, List<String> names) {
    TagUtils.removeTagsInScope(scope, tags, names);
  }

  /**
   * Removes all the tags in the specified scope from the tag list of this
   * object.
   *
   * @param scope
   *          the scope of tags, which cannot be {@code null} nor empty.
   */
  public final void removeTagsInScope(String scope) {
    TagUtils.removeTagsInScope(scope, tags);
  }

  /**
   * Gets the label of this object.
   * <p>
   * This function will check the tags of this object, and returns the name of
   * the first tag whose scope is {@link TagScope#LABEL}. If there is no such
   * tag, this function will return the name of {@link Label#NONE}.
   *
   * @return the enumeration of the label of this object.
   */
  public final Label getLabel() {
    return LabelTag.getLabel(tags);
  }

  /**
   * Sets the label to this object.
   * <p>
   * After calling this function, the old tag or tags representing a label will
   * be removed, and a new tag representing the specified label will be added to
   * the tag list.
   *
   * @param label
   *          the new label to be set to this object.
   */
  public final void setLabel(Label label) {
    tags = LabelTag.setLabel(tags, label);
  }

  /**
   * Gets the domain of this object.
   * <p>
   * This function will check the tags of this object, and returns the name of
   * the first tag whose scope is {@link TagScope#DOMAIN}. If there is no such
   * tag, this function will return {@code null}.
   *
   * @return the name of the domain of this object, or {@code null} if
   *         the domain is not set for this object.
   */
  public final String getDomain() {
    return DomainTag.getDomain(tags);
  }

  /**
   * Sets the domain to this object.
   * <p>
   * After calling this function, the old tag or tags representing an access
   * mode will be removed, and a new tag representing the specified domain
   * will be added to the tag list.
   *
   * @param domain
   *          the name of the new domain to be set to this object.
   */
  public final void setDomain(String domain) {
    tags = DomainTag.setDomain(tags, domain);
  }

  /**
   * Gets the keywords of this object.
   * <p>
   * This function will check the tags of the tag list, and returns the names of
   * the tags in the scope {@link TagScope#KEYWORD}. If there is no such tag,
   * this function will return {@code null}.
   *
   * @return the list of keywords of this object, or {@code null} if no
   *         keyword was set.
   */
  public final List<String> getKeywords() {
    return KeywordTag.getKeywords(tags);
  }

  /**
   * Sets the keywords of this object.
   *
   * @param keywords
   *          the list of keywords to be set, which cannot be {@code null},
   *          and every elements in the array cannot be {@code null} nor empty.
   */
  public final void setKeywords(List<String> keywords) {
    tags = KeywordTag.setKeywords(tags, keywords);
  }

  /**
   * Adds a keyword to this object.
   *
   * @param keyword
   *          the keywords to be added, which cannot be {@code null} nor empty.
   */
  public final void addKeyword(String keyword) {
    tags = KeywordTag.addKeyword(tags, keyword);
  }

  /**
   * Adds keywords to this object.
   *
   * @param keywords
   *          the list of keywords to be added, which cannot be {@code null},
   *          and every elements in the array cannot be {@code null} nor empty.
   */
  public final void addKeywords(List<String> keywords) {
    tags = KeywordTag.addKeywords(tags, keywords);
  }

  /**
   * Removes a keyword from this object.
   *
   * @param keyword
   *          the keywords to be removed, which cannot be {@code null} nor empty.
   */
  public final void removeKeyword(String keyword) {
    KeywordTag.removeKeyword(tags, keyword);
  }

  /**
   * Removes keywords from this object.
   *
   * @param keywords
   *          the keywords to be removed, which cannot be {@code null}, and
   *          every elements in the array cannot be {@code null} nor empty.
   */
  public final void removeKeywords(List<String> keywords) {
    KeywordTag.removeKeywords(tags, keywords);
  }

}
