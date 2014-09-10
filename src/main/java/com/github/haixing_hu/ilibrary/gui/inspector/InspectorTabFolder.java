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

package com.github.haixing_hu.ilibrary.gui.inspector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.haixing_hu.ilibrary.Application;

/**
 * The tab folder in the inspector panel.
 *
 * @author Haixing Hu
 */
public final class InspectorTabFolder extends Composite {

  public static final String KEY = InspectorPanel.KEY + ".tab"; // "window.inspector.tab"

  private static final Logger LOGGER = LoggerFactory.getLogger(InspectorTabFolder.class);

  private final Application application;
  private StackLayout stackLayout;
  private InfoTab infoTab;
  private NotesTab notesTab;
  private ReviewsTab reviewsTab;
  private FilesTab filesTab;

  public InspectorTabFolder(Application application, Composite parent) {
    super(parent, SWT.NONE);
    this.application = application;
    createContents();
  }

  private void createContents() {
    stackLayout = new StackLayout();
    stackLayout.marginHeight = 0;
    stackLayout.marginWidth = 0;
    this.setLayout(stackLayout);

    infoTab = new InfoTab(application, this);
    notesTab = new NotesTab(application, this);
    reviewsTab = new ReviewsTab(application, this);
    filesTab = new FilesTab(application, this);

    stackLayout.topControl = infoTab;
    this.layout();
  }

  /**
   * Gets the stack layout.
   *
   * @return the stack layout.
   */
  public StackLayout getStackLayout() {
    return stackLayout;
  }

  /**
   * Gets the info tab.
   *
   * @return the info tab.
   */
  public InfoTab getInfoTab() {
    return infoTab;
  }

  /**
   * Gets the notes tab.
   *
   * @return the notes tab.
   */
  public NotesTab getNotesTab() {
    return notesTab;
  }

  /**
   * Gets the reviews tab.
   *
   * @return the reviews tab.
   */
  public ReviewsTab getReviewsTab() {
    return reviewsTab;
  }

  /**
   * Gets the files tab.
   *
   * @return the files tab.
   */
  public FilesTab getFilesTab() {
    return filesTab;
  }

}