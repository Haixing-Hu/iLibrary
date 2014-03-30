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

package com.github.haixing_hu.ilibrary.model;

import static com.github.haixing_hu.ilibrary.utils.Argument.requireNonNull;

/**
 * A generic class whose element is of either of two types.
 *
 * @param First the first type.
 * @param Second the second type.
 * @author Haixing Hu
 */
public class  Either<First, Second> {

  private First first;
  private Second second;

  /**
   * Constructs an {@link Either} object represents a {@link First} object.
   *
   * @param first
   *          the first object, which cannot be null.
   */
  public Either(First first) {
    this.first = requireNonNull("first", first);
    this.second = null;
  }

  /**
   * Constructs an {@link Either} object represents a {@link Second} object.
   *
   * @param second
   *          the second object, which cannot be null.
   * @param dummy
   *          a dummy argument presented only for distinct this constructor
   *          from the other one. Usually passing a <code>null</code> to this
   *          argument is enough.
   */
  public Either(Second second, Object dummy) {
    this.first = null;
    this.second = requireNonNull("second", second);
  }

  /**
   * Gets the first.
   *
   * @return the first.
   */
  public First getFirst() {
    return first;
  }

  /**
   * Sets the first.
   *
   * @param first the new first to set.
   */
  public void setFirst(First first) {
    this.first = requireNonNull("first", first);
    this.second = null;
  }

  /**
   * Gets the second.
   *
   * @return the second.
   */
  public Second getSecond() {
    return second;
  }

  /**
   * Sets the second.
   *
   * @param second the new second to set.
   */
  public void setSecond(Second second) {
    this.first = null;
    this.second = requireNonNull("second", second);
  }

  @Override
  public int hashCode() {
    if (first != null) {
      return first.hashCode();
    } else {
      assert second != null;
      return second.hashCode();
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Either<?, ?> other = (Either<?,?>) obj;
    if (this.first != null) {
      return (other.second == null)
          && this.first.equals(other.first);
    } else {
      assert second != null;
      return (other.first == null)
          && this.second.equals(other.second);
    }
  }

  @Override
  public String toString() {
    if (first != null) {
      return first.toString();
    } else {
      assert second != null;
      return second.toString();
    }
  }
}
