// FILE. . . . . /home/hak/hlt/src/hlt/language/syntax/XmlAnnotationTokenizer.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . 4j4zn71
// STARTED ON. . Fri Mar 16 18:09:23 2007

package hlt.language.syntax.xml;

/**
 * This is a tokenizer for the XML annotation parser from the Jacc
 * grammar in <a
 * href="XmlAnnotation.html"><tt>XmlAnnotation.grm</tt></a>. It is
 * rather self-explanatory: simply read the comments and the code below.
 *
 * @version     Last modified on Wed Jun 20 13:51:44 2012 by hak
 * @author      <a href="mailto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;

import hlt.language.io.IO;
import hlt.language.io.StreamTokenizer;
import hlt.language.syntax.*;

public class XmlAnnotationTokenizer implements Tokenizer
{
  /**
   * A constant label used for designating the keyword for the XML <font
   * color="green"><i>namespace prefix</i></font> used by the annotation
   * language.
   *
   * <p>
   *
   * <font size="-1"color="red"><i><b>WARNING</b>: Changing this value will
   * change the syntax of the annotation language, which will then take
   * the new given string value as the new corresponding keyword. As a
   * result, old annotations using the previous keyword will be
   * unprocessable by any XML annotation parser generated from a Jacc
   * grammar for the <a href="XmlAnnotationSpecification.html">XML annotation
   * notation</a> using this tokenizer.<i></font>
   */
  public static final String nsPrefixKey = "nsprefix";
  /**
   * A constant label used for designating the keyword for the XML <font
   * color="green"><i>local name</i></font> used by the annotation
   * language.
   *
   * <p>
   *
   * <font size="-1"color="red"><i><b>WARNING</b>: Changing this value will
   * change the syntax of the annotation language, which will then take
   * the new given string value as the new corresponding keyword. As a
   * result, old annotations using the previous keyword will be
   * unprocessable by any XML annotation parser generated from a Jacc
   * grammar for the <a href="XmlAnnotationSpecification.html">XML annotation
   * notation</a> using this tokenizer.<i></font>
   */
  public static final String localNameKey = "localname";
  /**
   * A constant label used for designating the keyword for the XML <font
   * color="green"><i>attributes name</i></font> used by the annotation
   * language.
   *
   * <p>
   *
   * <font size="-1"color="red"><i><b>WARNING</b>: Changing this value will
   * change the syntax of the annotation language, which will then take
   * the new given string value as the new corresponding keyword. As a
   * result, old annotations using the previous keyword will be
   * unprocessable by any XML annotation parser generated from a Jacc
   * grammar for the <a href="XmlAnnotationSpecification.html">XML annotation
   * notation</a> using this tokenizer.<i></font>
   */
  public static final String attributesKey = "attributes";
  /**
   * A constant label used for designating the keyword for the XML <font
   * color="green"><i>children</i></font> used by the annotation
   * language.
   *
   * <p>
   *
   * <font size="-1"color="red"><i><b>WARNING</b>: Changing this value will
   * change the syntax of the annotation language, which will then take
   * the new given string value as the new corresponding keyword. As a
   * result, old annotations using the previous keyword will be
   * unprocessable by any XML annotation parser generated from a Jacc
   * grammar for the <a href="XmlAnnotationSpecification.html">XML annotation
   * notation</a> using this tokenizer.<i></font>
   */
  public static final String childrenKey = "children";

  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

  /**
   * An <tt>int</tt> to store the line number. This is not actually used
   * for now, but will be needed eventually. (See comment for this
   * class' <tt>locate</tt> method.)
   */
  int lineno;
  /**
   * The <tt>Reader</tt> to read from.
   */
  Reader reader;
  /**
   * The <tt>StreamTokenizer</tt> reading off the reader.
   */
  StreamTokenizer st;

  /**
   * Constructs an <tt>XmlAnnotationTokenizer</tt> with the
   * specified annotation string.
   */
  public XmlAnnotationTokenizer (String annotation)
    {
      setInput(annotation);
    }

  /**
   * Sets the input reader to read from the specified annotation string.
   */
  public final void setInput (String annotation)
    {
      setReader(new StringReader(annotation));
    }

  /**
   * Sets up the reader and the stream tokenizer, and configures the
   * stream tokenizer as follow:
   * <ul>
   * <li> it considers all the following characters ordinary:<br>
   *      <font color="blue"><b><tt>
   *      ? $ + - . ( ) { } [ ] &lt; &gt; : ; , = ! &amp; | \* % /
   *      </tt></b></font>
   * <li> it recognizes quoted strings using either single or double
   *      quotes;
   * <li> it considers the characters: <font
   *      color="blue"><b><tt>_@</tt></b></font> as part of word identifiers
   *      (<i>i.e.</i>, as letters);
   * <li> it recognizes  unsigned whole numbers (but no floating
   *      points).
   * </ul>
   */
  public final void setReader (Reader rd)
    {
      reader = rd;
      st = new StreamTokenizer(reader);
      // parse unsigned whole numbers only:
      st.parseDigitsOnly();
      // make the specified characters ordinary:
      st.ordinaryChars("?$+-.(){}[]<>:;,=!&|*%/");
      // make the single quote a string quote character:
      st.quoteChar('\'');
      // make the double quote a string quote character:
      st.quoteChar('"');
      // make the specified characters letter word characters:
      st.wordChars("_@");
    }

  public final Reader getReader ()
    {
      return reader;
    }

  /**
   * This method is required for this class. It returns <tt>lineno</tt>.
   * It is not actually used for now, but will be needed
   * eventually. (See comment for this class' <tt>locate</tt> method.)
   */
  public final int lineNumber()
    {
      return lineno;
    }

  /**
   * This is the identity function: for now, we can't really locate
   * any node without the contextual information coming from the
   * <tt>hlt.language.syntax.Grammar</tt> class. Todo for later.
   */
  final ParseNode locate (ParseNode node)
    {
      return node;
    }

  final ParseNode position ()
    {
      return locate(XmlAnnotationParser.numberToken("POSITION",(int)st.nval));
    }

  final ParseNode symbol (String symbol)
    {
      return locate(XmlAnnotationParser.symbolToken("SYMBOL",symbol));
    }

  final ParseNode keyValSep ()
    {
      return locate(XmlAnnotationParser.literalToken("KEYVALSEP"));
    }

  final ParseNode listSep ()
    {
      return locate(XmlAnnotationParser.literalToken("LISTSEP"));
    }

  final ParseNode dot ()
    {
      return locate(XmlAnnotationParser.literalToken("DOT"));
    }

  final ParseNode star ()
    {
      return locate(XmlAnnotationParser.literalToken("STAR"));
    }

  final ParseNode slash ()
    {
      return locate(XmlAnnotationParser.literalToken("SLASH"));
    }

  final ParseNode value ()
    {
      return locate(XmlAnnotationParser.literalToken("VALUE"));
    }

  final ParseNode text ()
    {
      return locate(XmlAnnotationParser.literalToken("TEXT"));
    }

  boolean hasNsPrefix = false;
  boolean hasLocalName = false;
  boolean hasAttributes = false;
  boolean hasChildren = false;

  final ParseNode keywordOrSymbol (String symbol)
    {
      if (!hasNsPrefix && isPrefixOf(symbol,nsPrefixKey))
	{
	  hasNsPrefix = true;
	  return literal("NSPREFIX");
	}

      if (!hasLocalName && isPrefixOf(symbol,localNameKey))
	{
	  hasLocalName = true;
	  return literal("LOCALNAME");
	}

      if (!hasAttributes && isPrefixOf(symbol,attributesKey))
	{
	  hasAttributes = true;
	  return literal("ATTRIBUTES");
	}

      if (!hasChildren && isPrefixOf(symbol,childrenKey))
	{
	  hasChildren = true;
	  return literal("CHILDREN");
	}

      return symbol(symbol);
    }

  final boolean isPrefixOf (String prefix, String word)
    {
      return prefix == word
	  || prefix.length() != 0
	     && word.toLowerCase().startsWith(prefix.toLowerCase());
    }
  
  final ParseNode literal (int c)
    {
      return locate(XmlAnnotationParser.literalToken(String.valueOf((char)c)));
    }

  final ParseNode literal (String s)
    {
      return locate(XmlAnnotationParser.literalToken(s));
    }

  public final ParseNode nextToken () throws IOException
    {
      ParseNode t = null;
      int tk = st.nextToken();
      int nextChar = st.peek();
      lineno = st.lineno();

      switch (tk)
        {
        case StreamTokenizer.TT_SPECIAL:
          return nextToken();
        case StreamTokenizer.TT_EOF:
          t = locate(XmlAnnotationParser.eoi());
          break;
        case StreamTokenizer.TT_NUMBER:
          t = position();
          break;
        case StreamTokenizer.TT_WORD:
	  t = keywordOrSymbol(st.sval);
	  break;
        case IO.SQT: case IO.DQT:
	  t = symbol(st.sval);
          break;
	case '$':
	  if (st.nextToken() == StreamTokenizer.TT_WORD)
	    if (st.sval == "value" || st.sval == "VALUE")
	      t = value();
	    else
	      if (st.sval == "text" || st.sval == "TEXT")
		t = text();
	  else
	    {
	      st.pushBack();
	      t = literal(tk);
	    }
	  break;
        case ':':
	  t = keyValSep();
	  break;	  
        case '=':
	  if (st.peek() == '>')
	    {
	      t = keyValSep();
	      st.nextToken();
	    }
	  else
	    t = keyValSep();
	  break;	  
        case '-':
	  if (st.peek() == '>')
	    {
	      t = keyValSep();
	      st.nextToken();
	      break;
	    }
        case '.':
	  t = dot();
	  break;
        case '*':
	  t = star();
	  break;
        case '/':
	  t = slash();
	  break;
        case ',': case ';':
	  t = listSep();
	  break;
        default:
	  t = literal(tk);
        }
//       System.out.println("Reading token: "+t);
      return t;
    }
}

