package com.company;

import java.io.*;
import java.util.List;

public class ReportRenderer
{
  public static final int FORMAT_CSV = 1;
  public static final int FORMAT_XML = 2;
  public static final int FORMAT_HTML = 3;

  private int format;
  private boolean removeLineEndings;
  private boolean writeBom;
  private String reportName;

  private OutputStream tempFile;


  public ReportRenderer(int format, boolean removeLineEndings, boolean writeBom, String title, String reportName)
  {
    this.format = format;
    this.removeLineEndings = removeLineEndings;
    this.writeBom = writeBom;
    this.reportName = reportName;
    begin();
  }


  private void begin()
  {
    try {
      tempFile = new FileOutputStream(File.createTempFile("temp-file-name", ".tmp"));
      if (writeBom) {
        //todo: write BOM to beginning of file
      }
      writeTitle();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void writeTitle()
  {
    switch (format) {
      case FORMAT_CSV:
        //todo: write title
      case FORMAT_XML:
        //todo: write title
      case FORMAT_HTML:
        //todo: write title
    }
  }


  public void writeHeader(List<String> rowValues)
  {
    if (removeLineEndings) {
      //todo remove line endings from rowValues
    }
    switch (format) {
      case FORMAT_CSV:
        //todo
      case FORMAT_XML:
        //todo
      case FORMAT_HTML:
        //todo
    }
  }


  public void writeRow(List<String> rowValues)
  {
    if (removeLineEndings) {
      //todo remove line endings from rowValues
    }
    switch (format) {
      case FORMAT_CSV:
        //todo
      case FORMAT_XML:
        //todo
      case FORMAT_HTML:
        //todo
    }
  }


  public String getExtension()
  {
    switch (format) {
      case FORMAT_CSV:
        return "csv";
      case FORMAT_XML:
        return "xml";
      case FORMAT_HTML:
        return "html";
    }
    return null;
  }
  

  public void finish()
  {
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(new File("report-storage", reportName + '.' + getExtension()));

      //todo: copy tempFile inputStream to output stream
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    finally {
      if (outputStream != null) {
        try {
          outputStream.close();
        }
        catch (IOException e) {
        }
      }

      try {
        tempFile.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
