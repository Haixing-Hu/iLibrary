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

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.github.haixing_hu.csl.Variable;

import static com.github.haixing_hu.lang.Argument.requireNonNull;

/**
 * A {@link CslMappingRule} represents a mapping from a CSL standard variable to
 * a property expression.
 * <p>
 * A property expression is a rule specifies how to consists a string using the
 * properties of a document. Currently it supports the following syntax:
 *
 * <pre>
 * <code>
 * expression           ::= (property | string | choose )+;
 * property             ::= (field | field '.' property);
 * field                ::= [a-z-]+;
 * string               ::= '"' (escaped_backslash | escaped_double_quote | non_line_break)*? '"';
 * escaped_backslash    ::= '\\';
 * escaped_double_quote ::= '\"';
 * non_line_break       ::= ~('\r' | '\n');
 * choose               ::= '(' property '?' expression (':' expression)? ')';
 * </code>
 * </pre>
 *
 * where:
 * <ul>
 * <li>{@code expression} denotes a property expression.</li>
 * <li>{@code property} denotes a property, which is either a field of a
 * document, or the property of a field of a document.</li>
 * <li>{@code field} denotes a field of a document.</li>
 * <li>{@code string} denotes a string literal, quoted with double quotation
 * marks, and may contains the escaped backslash and the escaped double
 * quotation mark, but cannot contain line breaks.</li>
 * <li>{@code choose} denotes a choose expression, which consists of a testing
 * property, a positive expression, and an optional negative expression. The
 * choose expression is similar to the "? :" operator in Java, say
 * {@code max = (a > b ? a : b)}. When evaluating a choose expression, first
 * test the existence of the testing property, if it exists, returns the
 * positive expression; otherwise, returns the negative expression. If there is
 * no negative expression, returns an empty string when the testing property
 * does not exist.</li>
 * </ul>
 *
 * <h2>Examples:</h2>
 *
 * <ul>
 * <li>{@code title} - evaluated to the string representation of the
 * {@code title} field of the document.</li>
 * <li>{@code authors editors} - evaluated to the string concatenated from the
 * string representation of the {@code authors} field and the {@code editors}
 * field of the document.</li>
 * <li>{@code journal.title} - suppose the {@code journal} field of the document
 * is an object, say, {@code obj1}, this expression is evaluated to the string
 * representation of the {@code title} field of {@code obj1}.</li>
 * <li>{@code title (subtitle ? ": " subtitle)} - if the {@code subtitle} field
 * of the document is not {@code null}, this expression is evaluated to the
 * string concatenated from the string representation of the {@code title} field
 * of the document, a string literal {@code ": "}, and the string representation
 * of the {@code subtitle} field of the document; otherwise, this expression is
 * evaluated to the string representation of the {@code title} field of the
 * document.</li>
 * <li>{@code (authors ? authors : editors)} - if the {@code authors} field of
 * the document is not {@code null}, this expression is evaluated to the string
 * representation of the {@code authors} field of the document; otherwise, this
 * expression is evaluated to the string representation of the {@code editors}
 * field of the document. Of course, if the {@code editors} field of the
 * document is still {@code null}, this expression evaluated to {@code null}
 * (instead of an empty string).</li>
 * </ul>
 *
 * @author Haixing Hu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "expression")
@Immutable
public class CslMappingRule {

  @XmlElement(required = true)
  private final Variable variable;

  @XmlElement(required = true)
  private final String expression;

  /**
   * Default constructor.
   * <p>
   * This default constructor is presented for the JAXB.
   */
  CslMappingRule() {
    variable = null;
    expression = null;
  }

  /**
   * Constructs a {@link CslMappingRule}.
   *
   * @param variable
   *          a CSL standard variable.
   * @param expression
   *          the expression corresponds to the CSL standard variable.
   */
  public CslMappingRule(final Variable variable, final String expression) {
    this.variable = requireNonNull("variable", variable);
    this.expression = requireNonNull("expression", expression);
  }

  /**
   * Gets the CSL standard variable.
   *
   * @return the CSL standard variable.
   */
  public Variable getVariable() {
    return variable;
  }

  /**
   * Gets the expression corresponds to the CSL standard variable.
   *
   * @return the expression corresponds to the CSL standard variable.
   */
  public String getExpression() {
    return expression;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(final Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
