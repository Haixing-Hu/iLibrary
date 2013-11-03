# The design of iLibrary

## Introduction

The iLibrary is a desktop software used to manage the information of personal books, documents, or papers, as well as the electronic version of them. It could be used as a personal digit library software or as a reference management software. It could automatically manage the storage of eletronic documents, in the way like iTunes. 

This document describes the design of the functions and the architecture of the software.

## Goal

The intended functions of the iLibrary are as follows:

* Could manage the information of books, reports, papers, newspapers, magazines, web pages, documents, etc.
* Could manage the information of authors, publishers, periodicals, websites, etc.
* Could automatically manage the storage of electronic documents. The electonic documents could be stored under a specified directory, while the sturcture of the sub-directories and file names of the electronic documents are automatically managed by the iLibrary.
* Could have multiple libraries, and each library could has a specific configuration.
* Could define new type of documents, and customize the fields of the information of each document type.
* Could mark documents with customized tags.
* The tags could have hierarchical structures.
* Could search the documents in the library by their fields.
* Could search the documents on the web.
* Could download documents from the web, and automatically import the information of the documents.
* Could create smart create manual or smart collections of documents.
* Could open the electronic documents with external application.
* Could read the PDF documents inside the application, and could make notes while reading the PDF documents.
* Could import or export the references in many formats.
* Could manage the citation styles.
* Could copy the references of specified documents with the specified citation styles.

## Development Tools

In order to make the application cross platform, we decide to choose the Java programming language and the SWT/JFace framework to implement the iLibrary.

## User Interface

We refer to the user inferface of congeneric products, especially the "Papers for Mac".

### Wireframe

The main window of the iLibrary is designed as follows:

![Main Window][main-window]

[main-window]: ui/main_window.png "Main Window"

### Menu

The menu items of the iLibrary are designed as follows:

* File: the file related actions
  * New Entry: create a new entry for a document
  * New Library: create a new library
  * Open Library: open an existing library
  * Close Library: close the current library  
  * Import: import reference information of entries
  * Export: export reference information of entries
  * Page Setup: setup the page for printing
  * Print: print the selected electronic documents
  * Quit: quit the application
* Edit: the editing related actions
  * Undo: undo the last operation
  * Redo: redo the last operation
  * Cut: cut the selected text
  * Copy: copy the selected text  
  * Copy Reference: Copy the reference of the selected document
  * Paste: paster the text on the clipboard
  * Delete: delete the sepected document
  * Select All: select all the text or select all the items in the current list
  * Font: sets the font for displaying
  * Style: select the bibliograph style to use when copying the reference
  * Find: find a document in the current library or find a text in the current document
  * Find Next: find the next match
  * Find Previous: find the previous match
* View
  * As Cover Flow: view the list of documents as cover flow  
  * As Preview: view the list of documents as preview
  * As Thumbnails: viSew the documents as thumbnails
  * Columns: select the columns of the fields to be displayed in the table grid of documents
  * Sort By: select the fields to sort the list of documents displayed in the table grid
  * Hide/Show Preview: hide/show the preview panel of the documents
  * Hide/Show Inspector: hide/show the inspector panel of the documents
  * Previous Document: select the previous document and display its information
  * Next Document: select the next document and display its information
  * Show Duplicates/Show All Documents: show duplicated/all documents
  * Read Full Screen: read the current selected electronic document in the full screen mode
  * Actual Size: zoom the current opened document to its actual size
  * Zoom to Fit: zoom the current opened document to fit the size of the window
  * Zoom In: zoom in the current opened document
  * Zoom Out: zoom out the current opened document  
  * Table of Contents: jump to the table of contents of the current opened document
  * Previous Page: jump to the previous page of the current opened document
  * Next Page: jump to the next page of the current opened document
  * Goto Page: jump to the specified page of the current opened document
  * Back: returns to the last location of the current opened document or web site
  * Forward: returns to the next location of the current opened document or web site
* Library 
  * Mark as Flagged/Unflagged:
  * Mark as Read/Unread:
  * Mark as Printed/Unprinted:
  * Move to Trash / Restore from Trash:
  * Show Keywords:
  * Show Notes:
  * Add Review:
  * Open File With:
  * Reveal File Position:
  * Attach File:b
  * Open URL in Browser:
  * Add to Collection:  
  * Edit Information: 
  * Merge Documents:
  * Merge Authors:
  * Merge Publishers:
  * Merge Conferences:
  * Merge Periodicals:
  * Merge Websites:
* Share
  * Twitter:
  * Facebook:
  * Google+:
  * Sina Weibo:
  * Tencent Weibo:
  * Send via Email
  * Export:
* Window
  * Minimize: minimize the current window
  * Minimize All: minimize all windows
  * Maximize: mIaximize the current window
  * Library: switch to the library tab
  * Info: display the information of the selected document
  * Notes: display the notes of the selected document
  * Reviews: display the reviews of the selected document
  * Files: display the files of the selected document
  * Cycle Tabs: cycle between tabs
  * Previous Tab: switch to the previous tab
  * Next Tab: switch to the next tab
  * Close Tab: close the current tab
  * Close All Tabs: Close all tabs  fic
* Help
  * Manul: the user manual of the application
  * FAQ: the FAQ of the application
  * Send Feedback: send a feedback to the developer of the application
  * Visit Website: visit the website of the application
  * About: display the information (version number, author, copyrights, etc) of the applicaiton
  
  
  

