/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model;

import static cn.edu.nju.starfish.ilibrary.utils.Argument.requireNonNull;

/**
 * A generic class whose element is of thrin of three types.
 *
 * @param First the first type.
 * @param Second the second type.
 * @param Third the third type.
 * @author Haixing Hu
 */
public class  Thrin<First, Second, Third> {

  private First first;
  private Second second;
  private Third third;

  /**
   * Constructs an {@link Thrin} object represents a {@link First} object.
   *
   * @param first
   *          the first object, which cannot be null.
   */
  public Thrin(First first) {
    this.first = requireNonNull("first", first);
    this.second = null;
    this.third = null;
  }

  /**
   * Constructs an {@link Thrin} object represents a {@link Second} object.
   *
   * @param second
   *          the second object, which cannot be null.
   * @param dummy
   *          a dummy argument presented only for distinct this constructor
   *          from the other two. Usually passing a <code>null</code> to this
   *          argument is enough.
   */
  public Thrin(Second second, Object dummy) {
    this.first = null;
    this.second = requireNonNull("second", second);
    this.third = null;
  }

  /**
   * Constructs an {@link Thrin} object represents a {@link Second} object.
   *
   * @param second
   *          the second object, which cannot be null.
   * @param dummy1
   *          a dummy argument presented only for distinct this constructor
   *          from the other two. Usually passing a <code>null</code> to this
   *          argument is enough.
   * @param dummy2
   *          a dummy argument presented only for distinct this constructor
   *          from the other two. Usually passing a <code>null</code> to this
   *          argument is enough.
   */
  public Thrin(Second second, Object dummy1, Object dummy2) {
    this.first = null;
    this.second = null;
    this.third = requireNonNull("third", third);
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
    this.third = null;
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
    this.second = requireNonNull("second", second);
    this.first = null;
    this.third = null;
  }

  /**
   * Gets the third.
   *
   * @return the third.
   */
  public Third getThird() {
    return third;
  }

  /**
   * Sets the third.
   *
   * @param third the new third to set.
   */
  public void setThird(Third third) {
    this.third = third;
    this.first = null;
    this.second = null;
  }

  @Override
  public int hashCode() {
    if (first != null) {
      return first.hashCode();
    } else if (second != null) {
      return second.hashCode();
    } else {
      assert (third != null);
      return third.hashCode();
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
    final Thrin<?, ?, ?> other = (Thrin<?,?, ?>) obj;
    if (this.first != null) {
      return (other.second == null)
          && (other.third == null)
          && this.first.equals(other.first);
    } else if (this.second != null) {
      return (other.first == null)
          && (other.third == null)
          && this.second.equals(other.second);
    } else {
      assert third != null;
      return (other.first == null)
          && (other.second == null)
          && this.third.equals(other.third);
    }
  }

  @Override
  public String toString() {
    if (first != null) {
      return first.toString();
    } else if (second != null) {
      return second.toString();
    } else {
      assert third != null;
      return third.toString();
    }
  }
}
