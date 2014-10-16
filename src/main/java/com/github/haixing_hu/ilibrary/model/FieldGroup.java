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
 * The enumeration of groups of fields.
 *
 * @author Haixing Hu
 */
public enum FieldGroup {

  /**
   * The fields in this group are related to the title of the document.
   */
  TITLE,

  /**
   * The fields in this group are related to the responsibilities of the
   * document.
   */
  RESPONSIBILITY,

  /**
   * The fields in this group are related to the chapters of the document.
   */
  CHAPTERS,

  /**
   * The fields in this group are related to the abstract of the document.
   */
  ABSTRACT,

  /**
   * The fields in this group are related to the publication information of the
   * document.
   */
  PUBLICATION,

  /**
   * The fields in this group are related to the access information of the
   * document.
   */
  ACCESS,

  /**
   * The fields in this group are related to the status of the document.
   */
  STATUS,
}
