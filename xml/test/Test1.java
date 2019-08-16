// FILE. . . . . /home/hak/hlt/src/hlt/language/syntax/xml/test/Test1.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . 4j4zn71.Hlt.Biz
// STARTED ON. . Sun Sep 10 18:28:55 2006

// Last modified on Fri Oct 12 02:27:57 2012 by hak

import java.net.URL;
import java.io.OutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.io.OutputFormat;

public class Test1
{
  static Document read (URL url) throws DocumentException
    {
      SAXReader reader = new SAXReader();
      Document document = reader.read(url);
      return document;
    }

  static void write (Document document, OutputStream out) throws Exception
    {
      OutputFormat outformat = OutputFormat.createPrettyPrint();
//       outformat.setEncoding("UTF-8");
      XMLWriter writer = new XMLWriter(out, outformat);
      writer.write(document);
      writer.flush();
    }

  static public void main (String[] args)
    {
      try
        {
          String url;
	  url = "file:///C:/cygwin/home/hak/hlt/src/hlt/language/syntax/xml/test/test.xml";
	  // url = "file:///C:/cygwin/home/hak/hlt/src/hlt/language/syntax/xml/test/test1.xml";
          // url = "http://www.w3schools.com/xml/simple.xml";

          URL test = new URL(url);
          write(read(test),System.out);
        }
      catch (Exception e)
        {
          e.printStackTrace();
        }
    }
}
