/******************************************************************************
 *
 *    Copyright (c) 2013  Haixing Hu. All rights reserved.
 *
 ******************************************************************************/

package cn.edu.nju.starfish.ilibrary.model.csl;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * The model of meta information of a CSL.
 *
 * @author Haixing Hu
 */
@Root
public class Info {

  @Element
  private String id;

  @Element
  private String title;

  @ElementList(inline = true, required = false)
  private List<Author> authors;

  @ElementList(inline = true, required = false)
  private List<Author> contributors;

  @ElementList(inline = true, required = false)
  private List<Category> categories;

  @ElementList(inline = true, required = false)
  private List<String> ISSNs;

  @ElementList(inline = true, required = false)
  private List<String> EISSNs;

  @ElementList(inline = true, required = false)
  private List<String> ISSNLs;

}
