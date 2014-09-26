/******************************************************************************
 *
 * Copyright (c) 2014  Haixing Hu
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Haixing Hu (https://github.com/Haixing-Hu/) - Initial implementation and API.
 *
 ******************************************************************************/

package com.github.haixing_hu.ilibrary.model;

/**
 * The enumeration of types of fields.
 *
 * @author Haixing Hu
 */
public enum FieldType {

  /**
 * The flag status of the document.
 */FLAG_STATUS, /**
 * Indicates whether the document has attached files.
 */FILE_STATUS, /**
   * The print status of the document.
   */PRINT_STATUS, /**
 * The reading status of the document.
 */READ_STATUS, /**
   * The authors of the document, which could be one or more persons or
   * institutes.
   */
  AUTHORS,

  /**
   * The editors of the document, which could be one or more persons or
   * institutes.
   */
  EDITORS,

  /**
   * The year in which the document was published.
   */
  YEAR,

  /**
   * The title of the document.
   */
  TITLE,

  /**
   * The subtitle of the document.
   */
  SUBTITLE,

  /**
   * The source of the document. For journal papers, this is the journal where
   * the paper was published; For conference papers, this is the conference
   * where the paper was published; For books, this is the publisher of the
   * book; For degree thesis, this is the institute where the author graduated
   * from.
   */
  SOURCE,

  /**
   * The publisher of the document. For journal papers, this is the publisher
   * where the journal was published; For conference papers, this is the
   * publisher where the proceedings of the conference was published; For books,
   * this is the publisher of the book; For degree thesis,this is the institute
   * where the author graduated from.
   */
  PUBLISHER,

  /**
   * The city of whether the document was published. For journal papers, this is
   * the city of the publisher of the journal; For conference papers, this is
   * the cite of the publisher of the proceedings of the conference; For books,
   * this is the cite of the publisher of the book; For degree thesis,this is
   * the city of the institute where the author graduated from.
   */
  CITY,

  /**
   * ??
   */PUBLICATION, /**
   * The date when the document was published.
   */PUBLISHED_DATE, /**
   * The version of the document. For books, this is the edition of the book.
   * Note that the version may be a number or a string.
   */
  VERSION,

  /**
   * The volume of the document. For journal papers, this is the volume of the
   * journal in which the document was published; for book, this is the volume
   * of the book. Note that the volume may be a number or a string.
   */VOLUME, /**
   * The issue of the document. For journal papers, this is the issue of the
   * journal in which the document was published; for book chapters, this is the
   * chapter in which the document occurs. Note that the volume may be a number
   * or a string.
   */ISSUE, /**
   * The number of the document. For journal papers, this is the number of
   * journal where the paper was published. For technical reporters, this is the
   * number of the report. For preprinted articles, this is the number of the
   * article in the preprint website.
   */NUMBER, /**
   * The pages of the document. For journal papers or conference papers, this is
   * the range of pages where the document appeared in the journal or
   * proceedings. For books, this is the number of pages of the book.
   */PAGES, /**
   * The ISBN of the document. For journal papers, this is the ISBN of the
   * journal where the paper was published; for conference papers, this is the
   * ISBN of the proceedings where the paper was published. For books, this is
   * the ISBN of the book.
   */ISBN, /**
   * The language of the document.
   */LANGUAGE, /**
   * The kind of the document.
   */KIND, /**
   * The URL of the document.
   */URL, /**
   * The path of the file of the document.
   */PATH, /**
   * The citation key of the document.
   */CITE_KEY, /**
   * The status of the document.
   */STATUS, /**
   * The rating of the document.
   */
  RATING,

  /**
   * The last time when the document was read.
   */
  LAST_READ_TIME,

  /**
   * The last time when the document was printed.
   */
  PRINTED_TIME,

  /**
   * The time when the document was imported.
   */
  IMPORTED_TIME,

  /**
   * The number of times the document was cited (in this application).
   */CITED_COUNT, /**
   * The number of times the document was read (in this application).
   */READ_COUNT, /**
   * The keywords of the document.
   */
  KEYWORDS,

  /**
   * The collections the document belongs to.
   */
  COLLECTIONS,

  /**
   * The notes for the document.
   */
  NOTES,

}
