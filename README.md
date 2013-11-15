iLibrary
========

iLibrary is a multi-platform personal digit library software.

# Introduction

This project is intended to be an open source clone of the [Papers for Mac](http://www.papersapp.com/mac/). Papers is a beautiful and useful reference management software on the Mac OS X, but it's too expensive (cost $79) and does not fulfill my requirements to manage electronic documents. Moreover, Papers 2 is buggy on the newest Mac OS X 10.9, and Papers 3 is still in the alpha version. Therefore, I decided to make a knockoff of Papers.

At the first thought, I plan to write the program in Object-C, which is only supported by the
Mac OS X and the iOS. But after a seriously estimation, I decided to write it in Java, which supports multi-platforms. The big challenge is to mimic the UI of Mac OS X using Java. Fortunately, I found that the SWT and JFace could save me a lot of work, although there are still many obstacles.

Of course there are may other corss-platform application frameworks, such as GTK+, Qt, wxWidgets, XPFE (Mozilla application framework), and so on. The reasons to choose Java plus SWT are as follows: 

1. There are many useful open source components developed in Java, such as [iText](http://itextpdf.com/) (an open source API for PDF documents), [POI](http://poi.apache.org/) (an open source API for Microsoft Office documents), [Lucene](http://lucene.apache.org/core/) (an open source fulltext search engine), etc;
2. It's easy to port a Java program to mobile platform, such as Andriod;
3. I'm familiar with Java development. Although I'm also familiar with and like C++, I have no experience in development using the above cross-platform C++ frameworks.
4. Althrough JavaFX is said to be the next generation of GUI framework for Java, it is still unstable and lack of useful widgets, and it is only supported by JDK 7, which has not been widely supported by popular open source components.

# Intending Features

* A beautiful UI, similar to the [Papers for Mac](http://www.papersapp.com/mac/);
* Supports multiple reference types, including journal articles, conference articles, books, reports, dissertations, manuscripts, lecture notes, presentations, web pages, and so on.
* Users can customize new types of references;
* Supports importing/exporting the reference from/to many formats, especially the BibTeX format.
* Supports formatting the references in many predefined citation styles, and supports customizing the citation style using the [Citation Style Language (CSL)](http://citationstyles.org/);
* Supports automatically management of the storage (i.e., the directories and filenames) of the electronic documents (like the iTunes);
* Supports viewing electronic documents (PDF, CHM, RTF, Word, etc) in the applicaiton, and supports making annotations to the electronic documents;
* Supports importing references and downloading documents from popular academic search engine;
* Supports adding tags to documents;
* Supports adding relation between documents;
* Supports creating collection or smart collection (dynamic colleciton based on predefined search criteria) for documents;

# Reference Resources

The following resources may be helpful to the design and implementation of this project:

* [Papers for Mac](http://www.papersapp.com/mac/)
* [Zotero](http://www.zotero.org)
* [Sente](http://www.thirdstreetsoftware.com/site/SenteForMac.html)
* [Endnote](http://endnote.com/)
* [Bookends](http://www.sonnysoftware.com/)
* [BibDesk](http://bibdesk.sourceforge.net/)
* [Citation Style Language (CSL)](http://citationstyles.org/)
* [Zotero Style Repository](http://www.zotero.org/styles)