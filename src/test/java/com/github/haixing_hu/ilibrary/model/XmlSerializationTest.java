/******************************************************************************
 *
 * Copyright (c) 2013  Haixing Hu
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

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.ElementNameAndTextQualifier;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * The base class for testing the XML serialization of a CSL domain object.
 *
 * @param T
 *          the class under test.
 * @author Haixing Hu
 */
public abstract class XmlSerializationTest<T> {

  protected final Class<T> cls;
  protected Map<T, String> marshalTestData;
  protected Map<String, T> unmarshalTestData;
  protected Logger logger;

  protected XmlSerializationTest(final Class<T> cls) {
    this.cls = cls;
    this.marshalTestData = new HashMap<T, String>();
    this.unmarshalTestData = new HashMap<String, T>();
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  protected XmlSerializationTest(final Class<T> cls,
      final Map<T, String> marshalTestData,
      final Map<String, T> unmarshalTestData) {
    this.cls = cls;
    this.marshalTestData = marshalTestData;
    this.unmarshalTestData = unmarshalTestData;
    this.logger = LoggerFactory.getLogger(this.getClass());
  }

  @Test
  public void testXmlMarshal() throws Exception {
    final JAXBContext context = JAXBContext.newInstance(cls);
    final Marshaller mr = context.createMarshaller();
    mr.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    mr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    XMLUnit.setIgnoreWhitespace(true);
    for (final Map.Entry<T, String> entry : marshalTestData.entrySet()) {
      final T obj = entry.getKey();
      final String xml = entry.getValue();
      final StringWriter writer = new StringWriter();
      mr.marshal(obj, writer);
      final String actual = writer.toString();
      logger.info("Object is:\n{}", obj);
      logger.info("Expected XML is:\n{}", xml);
      logger.info("Actual XML is:\n{}\n", actual);
      final Diff diff = new Diff(xml, actual);
      // we don't care about ordering
      diff.overrideElementQualifier(new ElementNameAndTextQualifier());
      XMLAssert.assertXMLEqual(diff, true);
    }
  }

  @Test
  public void testXmlUnmarshal() throws Exception {
    final JAXBContext context = JAXBContext.newInstance(cls);
    final Unmarshaller umr = context.createUnmarshaller();
    for (final Map.Entry<String, T> entry : unmarshalTestData.entrySet()) {
      final String xml = entry.getKey();
      final T obj = entry.getValue();
      final StringReader reader = new StringReader(xml);
      @SuppressWarnings("unchecked")
      final T actual = (T) umr.unmarshal(reader);
      logger.info("XML is:\n{}", xml);
      logger.info("Expecte object is:\n{}", obj);
      logger.info("Actual object is:\n{}\n", actual);
      assertEquals(obj, actual);
    }
  }
}
