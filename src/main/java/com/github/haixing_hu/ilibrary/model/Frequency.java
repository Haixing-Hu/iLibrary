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

/**
 * The enumeration of publishing frequency.
 *
 * @author Haixing Hu
 */
public enum Frequency {

  /**
   * Indicates the periodical is published once per year.
   */
  ANNUALLY,

  /**
   * Indicates the periodical is published every four month.
   */
  QUARTERLY,

  /**
   * Indicates the periodical is published every two month.
   */
  BIMONTHLY,

  /**
   * Indicates the periodical is published every month.
   */
  MONTHLY,

  /**
   * Indicates the periodical is published every two week.
   */
  BIWEEKLY,

  /**
   * Indicates the periodical is published every week.
   */
  WEEKLY,

  /**
   * Indicates the periodical is published every day.
   */
  DAILY,

  /**
   * Indicates the periodical is published aperiodically.
   */
  APERIODICALLY,
}
