// *******************************************************************
// This file has been automatically generated from the grammar in file
// XmlAnnotation.grm by hlt.language.syntax.ParserGenerator on
// Sun Nov 25 09:00:32 PST 2018 --- !!! PLEASE DO NO EDIT !!!
// *******************************************************************

package hlt.language.syntax.xml;

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import hlt.language.syntax.*;
import java.util.Iterator;
import hlt.language.tools.Misc;
import hlt.language.util.ArrayList;
import hlt.language.util.IntArrayList;
import hlt.language.syntax.XmlWrapper;


/* ************ */
/* PARSER CLASS */
/* ************ */

public class XmlAnnotationParser extends StaticParser
{
  /* ************************ */
  /* PARSER CLASS CONSTRUCTOR */
  /* ************************ */

  public XmlAnnotationParser (Tokenizer t)
    {
      input = t;
      xmlroot = "XmlAnnotation";
    }

  /* ************************* */
  /* PARSER CLASS DECLARATIONS */
  /* ************************* */


  /**
   * This is the XML namespace prefix for this XML element. It is equal
   * to <tt>""</tt> by default.
   */
  String nsPrefix = "";
  /**
   * This the local name of this XML element; <i>i.e.</i>, <i>sans</i>
   * <tt>nsPrefix</tt>.
   */
  String localName = null;
  /**
   * The list of attributes/value pairs. It is a list of
   * <a href="../../XmlAttributeInfo.html"><tt>XmlAttributeInfo</tt></a>'s.
   */
  ArrayList attributes = new ArrayList();
  /**
   * The list of children. It is a list of <tt>int</tt>'s.
   */
  IntArrayList children = new IntArrayList();
  /**
   * When <tt>children[i]</tt> has an <tt>xmlPath</tt> specified for it,
   * it is stored in <tt>xmlPaths[i]</tt> as an <tt>IntArrayList</tt>.
   * Otherwise, <tt>xmlPaths[i]</tt> is set to null.
   */
  ArrayList xmlPaths = new ArrayList();
  /**
   * When <tt>children[i]</tt> has a <tt>wrapperPath</tt> specified for it,
   * it is stored in <tt>wrapperPaths[i]</tt> as an <tt>ArrayList</tt>.
   * Otherwise, <tt>wrapperPaths[i]</tt> is set to null.
   */
  ArrayList wrapperPaths = new ArrayList();

  /**
   * A reference into a child's XML structure may be that of the string
   * value of an attribute. The collection of these (possibly
   * <tt>null</tt>) strings is then stored in an <tt>ArrayList</tt>
   * called <tt>attributeNames</tt>.
   */
  ArrayList attributeNames = new ArrayList();

  /**
   * A child's XML structure may be that of the string value of a leaf
   * node (<i>i.e.</i>, of a terminal). Whenever this is the case, then
   * the number of XML children is always 1 (since there are no possible
   * siblings). This situation is signalled whenever the flag
   * <tt>terminalValueFlag</tt> is <tt>true<tt>.
   */
  boolean terminalValueFlag = false;

  /**
   * Where a child specifier is expected, one may use the special form
   * <tt>&#36;text</tt> to build text content from its arguments which
   * are either literal (possibly quoted) strings or expressions of the
   * form <tt>position/attribute</tt> where <tt>position</tt> is an RHS
   * position and <tt>attribute</tt> is one of its XML element
   * attribute's name. This information is recorded as an
   * <tt>ArrayList</tt> of (possibly <tt>null</tt>) <tt>ArrayList</tt>s
   * of <tt>XmlTextInfo</tt> objects.
   */
  ArrayList textInfos = new ArrayList();

  /**
   * Resets the generated XML annotation parser to its initial state;
   * <i>i.e.</i>, one in which it is ready to parse a new complete XML
   * annotation.
   */
  private void reset ()
    {
      resetParser();
      nsPrefix = "";
      localName = null;
      attributes = new ArrayList();
      children = new IntArrayList();
      xmlPaths = new ArrayList();
      wrapperPaths = new ArrayList();
      attributeNames = new ArrayList();
      textInfos = new ArrayList();
      terminalValueFlag = false;
    }

  /**
   * Resets the generated XML annotation parser to its initial state;
   * <i>i.e.</i>, one in which it is ready to parse the complete XML
   * annotation given as the specified string, and returns the parser.
   */
  public final XmlAnnotationParser reset (String annotation)
    {
      reset();
      ((XmlAnnotationTokenizer)input).setInput(annotation);
      return this;
    }

  /**
   * This returns the <tt>XmlInfo</tt> successfully parsed off the XML
   * annotation that was fed to this parser.
   */  
  public final XmlInfo xmlInfo ()
    {
      return new XmlInfo(localName,
			 nsPrefix,
			 toAttributeInfoArray(attributes),
			 children.toArray(),
			 toIntArrays(xmlPaths),
			 toWrapperArrays(wrapperPaths),
			 toStringArray(attributeNames),
			 terminalValueFlag,
			 toTextInfoArrays(textInfos));
    }

  /**
   * This returns an array of <tt>XmlAttributeInfo</tt> form of the list
   * of <tt>XmlAttributeInfo</tt>.
   */  
  private XmlAttributeInfo[] toAttributeInfoArray (ArrayList list)
    {
      int i = 0;
      XmlAttributeInfo[] a = new XmlAttributeInfo[list.size()];

      for (Iterator it=list.iterator(); it.hasNext();)
	a[i++] = (XmlAttributeInfo)it.next();

      return a;
    }

  private int[][] toIntArrays (ArrayList list)
    {
      int i = 0;
      int[][] a = new int[list.size()][];

      for (Iterator it=list.iterator(); it.hasNext();)
	{
	  IntArrayList sublist = (IntArrayList)it.next();
	  a[i++] = (sublist == null ? null : sublist.toArray());
	}

      return a;
    }

  private XmlWrapper[][] toWrapperArrays (ArrayList list)
    {
      int i = 0;
      XmlWrapper[][] a = new XmlWrapper[list.size()][];

      for (Iterator it=list.iterator(); it.hasNext();)
	{
	  ArrayList sublist = (ArrayList)it.next();
	  a[i++] = (sublist == null ? null : toWrapperArray(sublist));
	}

      return a;
    }

  private String[] toStringArray (ArrayList list)
    {
      int i = 0;
      String[] a = new String[list.size()];

      for (Iterator it=list.iterator(); it.hasNext();)
	a[i++] = (String)it.next();

      return a;
    }      

  private XmlWrapper[] toWrapperArray (ArrayList list)
    {
      int i = 0;
      XmlWrapper[] a = new XmlWrapper[list.size()];

      for (Iterator it=list.iterator(); it.hasNext();)
	a[i++] = (XmlWrapper)it.next();

      return a;
    }      
      
  private XmlTextInfo[][] toTextInfoArrays (ArrayList list)
    {
      int i = 0;
      XmlTextInfo[][] a = new XmlTextInfo[list.size()][];

      for (Iterator it=list.iterator(); it.hasNext();)
	{
	  ArrayList sublist = (ArrayList)it.next();
	  a[i++] = toTextInfoArray(sublist);
	}

      return a;
    }

  private XmlTextInfo[] toTextInfoArray (ArrayList list)
    {
      if (list == null)
	return null;
      
      int i = 0;
      XmlTextInfo[] a = new XmlTextInfo[list.size()];

      for (Iterator it=list.iterator(); it.hasNext();)
	a[i++] = (XmlTextInfo)it.next();

      return a;
    }



  /* ********************** */
  /* STATIC INITIALIZATIONS */
  /* ********************** */

  static
    {
      initializeTerminals();
      initializeNonTerminals();
      initializeRules();
      initializeParserActions();
      initializeParserStates();
      initializeActionTables();
      initializeGotoTables();
      initializeStateTables();
    }

  /* ********************* */
  /* PARTIAL PARSE METHODS */
  /* ********************* */

  final static ParseNode $XMLANNOTATION_SWITCH$ = new ParseNode(terminals[3]);

  public final void parseXmlAnnotation (String s) throws IOException
    {
      parseXmlAnnotation(new StringReader(s));
    }

  public final void parseXmlAnnotation (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($XMLANNOTATION_SWITCH$);
      parse();
    }

  /* **************** */
  /* SEMANTIC ACTIONS */
  /* **************** */

  protected ParseNode semanticAction(ParserRule $rule$) throws IOException
    {
      ParseNode $head$ = new ParseNode($rule$.head);

      switch($rule$.index())
        {
          case 2:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 12:
            {
            nsPrefix = node($rule$,1).svalue();
            break;
            }
          case 15:
            {
            localName = node($rule$,1).svalue();
            break;
            }
          case 21:
            {
            $AttributeValue$ $node3$;
                if (node($rule$,3) instanceof $AttributeValue$)
                   $node3$ = ($AttributeValue$)node($rule$,3);
                 else
                 {
                     $node3$ = new $AttributeValue$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

      XmlAttributeInfo info = null;
      String key = node($rule$,1).svalue();
      
      if ($node3$.hasLiteralValueContent)
        info = XmlAttributeInfo.literalXmlAttributeInfo(key,$node3$.value);
      else
        if ($node3$.hasTerminalValueContent)
  	  info = new XmlAttributeInfo(key);
        else
  	  if ($node3$.textInfo != null)
  	    info = new XmlAttributeInfo(key,
  	  	  	  	        new XmlSpecialForm($node3$.textInfo));
  	  else
  	    info = new XmlAttributeInfo(key,
  	  	  	  	        $node3$.cstChildPosition,
  	  	  	  	        $node3$.xmlPath,
  	  	  	  	        $node3$.attributeName);
      
      attributes.add(info);
            break;
            }
          case 22:
            {
            $AttributeValue$ $node0$ = new $AttributeValue$($head$);
                 $head$ = ($AttributeValue$)$node0$;
    $SpecialForm$ $node1$;
                if (node($rule$,1) instanceof $SpecialForm$)
                   $node1$ = ($SpecialForm$)node($rule$,1);
                 else
                 {
                     $node1$ = new $SpecialForm$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      $node0$.hasTerminalValueContent = $node1$.hasTerminalValueContent;
      $node0$.textInfo = $node1$.textInfo;
            break;
            }
          case 23:
            {
            $AttributeValue$ $node0$ = new $AttributeValue$($head$);
                 $head$ = ($AttributeValue$)$node0$;

      $node0$.value = node($rule$,1).svalue();
      $node0$.hasLiteralValueContent = true;
            break;
            }
          case 24:
            {
            $AttributeValue$ $node0$ = new $AttributeValue$($head$);
                 $head$ = ($AttributeValue$)$node0$;
    $XmlPath_opt$ $node2$;
                if (node($rule$,2) instanceof $XmlPath_opt$)
                   $node2$ = ($XmlPath_opt$)node($rule$,2);
                 else
                 {
                     $node2$ = new $XmlPath_opt$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }
    $AttributeName_opt$ $node3$;
                if (node($rule$,3) instanceof $AttributeName_opt$)
                   $node3$ = ($AttributeName_opt$)node($rule$,3);
                 else
                 {
                     $node3$ = new $AttributeName_opt$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

      $node0$.cstChildPosition = (int)node($rule$,1).nvalue();
      $node0$.xmlPath = $node2$.xmlPath;
      $node0$.attributeName = $node3$.attributeName;
            break;
            }
          case 25:
            {
            $SpecialForm$ $node0$ = new $SpecialForm$($head$);
                 $head$ = ($SpecialForm$)$node0$;

      $node0$.hasTerminalValueContent = true;
            break;
            }
          case 26:
            {
            $SpecialForm$ $node0$ = new $SpecialForm$($head$);
                 $head$ = ($SpecialForm$)$node0$;
    $TextArguments$ $node3$;
                if (node($rule$,3) instanceof $TextArguments$)
                   $node3$ = ($TextArguments$)node($rule$,3);
                 else
                 {
                     $node3$ = new $TextArguments$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

      $node0$.textInfo = $node3$.textInfo;
            break;
            }
          case 27:
            {
            $TextArguments$ $node0$ = new $TextArguments$($head$);
                 $head$ = ($TextArguments$)$node0$;
    $TextArgument$ $node1$;
                if (node($rule$,1) instanceof $TextArgument$)
                   $node1$ = ($TextArgument$)node($rule$,1);
                 else
                 {
                     $node1$ = new $TextArgument$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      ($node0$.textInfo = new ArrayList()).add($node1$.info);
            break;
            }
          case 28:
            {
            $TextArguments$ $node0$ = new $TextArguments$($head$);
                 $head$ = ($TextArguments$)$node0$;
    $TextArguments$ $node1$;
                if (node($rule$,1) instanceof $TextArguments$)
                   $node1$ = ($TextArguments$)node($rule$,1);
                 else
                 {
                     $node1$ = new $TextArguments$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    $TextArgument$ $node3$;
                if (node($rule$,3) instanceof $TextArgument$)
                   $node3$ = ($TextArgument$)node($rule$,3);
                 else
                 {
                     $node3$ = new $TextArgument$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

      ($node0$.textInfo = $node1$.textInfo).add($node3$.info);
            break;
            }
          case 29:
            {
            $TextArgument$ $node0$ = new $TextArgument$($head$);
                 $head$ = ($TextArgument$)$node0$;

      ($node0$.info = new XmlTextInfoArg()).setText(node($rule$,1).svalue());
            break;
            }
          case 30:
            {
            $TextArgument$ $node0$ = new $TextArgument$($head$);
                 $head$ = ($TextArgument$)$node0$;
    $TextRef$ $node1$;
                if (node($rule$,1) instanceof $TextRef$)
                   $node1$ = ($TextRef$)node($rule$,1);
                 else
                 {
                     $node1$ = new $TextRef$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      $node0$.info = $node1$.info;
            break;
            }
          case 31:
            {
            $TextRef$ $node0$ = new $TextRef$($head$);
                 $head$ = ($TextRef$)$node0$;
    $ChildXmlTree$ $node1$;
                if (node($rule$,1) instanceof $ChildXmlTree$)
                   $node1$ = ($ChildXmlTree$)node($rule$,1);
                 else
                 {
                     $node1$ = new $ChildXmlTree$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    $AttributeName_opt$ $node2$;
                if (node($rule$,2) instanceof $AttributeName_opt$)
                   $node2$ = ($AttributeName_opt$)node($rule$,2);
                 else
                 {
                     $node2$ = new $AttributeName_opt$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }

      $node0$.info = new XmlTextInfoArg($node1$.cstChildPosition,
  	  	  	  	   $node1$.xmlPath,
  	  	  	  	   $node2$.attributeName);
            break;
            }
          case 32:
            {
            $AttributeName$ $node0$ = new $AttributeName$($head$);
                 $head$ = ($AttributeName$)$node0$;

      $node0$.attributeName = node($rule$,2).svalue();
            break;
            }
          case 33:
            {
            $XmlChildSpec$ $node0$ = new $XmlChildSpec$($head$);
                 $head$ = ($XmlChildSpec$)$node0$;
    $WrapperPath_opt$ $node1$;
                if (node($rule$,1) instanceof $WrapperPath_opt$)
                   $node1$ = ($WrapperPath_opt$)node($rule$,1);
                 else
                 {
                     $node1$ = new $WrapperPath_opt$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    $ChildXmlTree$ $node2$;
                if (node($rule$,2) instanceof $ChildXmlTree$)
                   $node2$ = ($ChildXmlTree$)node($rule$,2);
                 else
                 {
                     $node2$ = new $ChildXmlTree$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }

      $node0$.wrapperPath = $node1$.wrapperPath;    
      $node0$.cstChildPosition = $node2$.cstChildPosition;
      $node0$.xmlPath = $node2$.xmlPath;
      $node0$.hasTerminalValueContent = $node2$.hasTerminalValueContent;
      $node0$.textInfo = $node2$.textInfo;
            break;
            }
          case 34:
            {
            $ChildXmlTree$ $node0$ = new $ChildXmlTree$($head$);
                 $head$ = ($ChildXmlTree$)$node0$;
    $SpecialForm$ $node1$;
                if (node($rule$,1) instanceof $SpecialForm$)
                   $node1$ = ($SpecialForm$)node($rule$,1);
                 else
                 {
                     $node1$ = new $SpecialForm$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      $node0$.hasTerminalValueContent = $node1$.hasTerminalValueContent;
      $node0$.textInfo = $node1$.textInfo;
            break;
            }
          case 35:
            {
            $ChildXmlTree$ $node0$ = new $ChildXmlTree$($head$);
                 $head$ = ($ChildXmlTree$)$node0$;
    $XmlPath_opt$ $node2$;
                if (node($rule$,2) instanceof $XmlPath_opt$)
                   $node2$ = ($XmlPath_opt$)node($rule$,2);
                 else
                 {
                     $node2$ = new $XmlPath_opt$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }

      $node0$.cstChildPosition = (int)node($rule$,1).nvalue();
      $node0$.xmlPath = $node2$.xmlPath;
            break;
            }
          case 37:
            {
            $WrapperPath_opt$ $node0$ = new $WrapperPath_opt$($head$);
                 $head$ = ($WrapperPath_opt$)$node0$;
    $WrapperPath$ $node1$;
                if (node($rule$,1) instanceof $WrapperPath$)
                   $node1$ = ($WrapperPath$)node($rule$,1);
                 else
                 {
                     $node1$ = new $WrapperPath$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      $node0$.wrapperPath = $node1$.wrapperPath;
            break;
            }
          case 38:
            {
            $WrapperPath$ $node0$ = new $WrapperPath$($head$);
                 $head$ = ($WrapperPath$)$node0$;
    $DotOrStar$ $node2$;
                if (node($rule$,2) instanceof $DotOrStar$)
                   $node2$ = ($DotOrStar$)node($rule$,2);
                 else
                 {
                     $node2$ = new $DotOrStar$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }
 $node0$.add(node($rule$,1).svalue(),$node2$.isStarred);
            break;
            }
          case 39:
            {
            $WrapperPath$ $node0$ = new $WrapperPath$($head$);
                 $head$ = ($WrapperPath$)$node0$;
    $WrapperPath$ $node1$;
                if (node($rule$,1) instanceof $WrapperPath$)
                   $node1$ = ($WrapperPath$)node($rule$,1);
                 else
                 {
                     $node1$ = new $WrapperPath$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    $DotOrStar$ $node3$;
                if (node($rule$,3) instanceof $DotOrStar$)
                   $node3$ = ($DotOrStar$)node($rule$,3);
                 else
                 {
                     $node3$ = new $DotOrStar$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }
 $node0$.addTo($node1$.wrapperPath,node($rule$,2).svalue(),$node3$.isStarred);
            break;
            }
          case 41:
            {
            $DotOrStar$ $node0$ = new $DotOrStar$($head$);
                 $head$ = ($DotOrStar$)$node0$;
 $node0$.isStarred = true;
            break;
            }
          case 43:
            {
            $XmlPath_opt$ $node0$ = new $XmlPath_opt$($head$);
                 $head$ = ($XmlPath_opt$)$node0$;
    $XmlPath$ $node2$;
                if (node($rule$,2) instanceof $XmlPath$)
                   $node2$ = ($XmlPath$)node($rule$,2);
                 else
                 {
                     $node2$ = new $XmlPath$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }
 $node0$.xmlPath = $node2$.xmlPath;
            break;
            }
          case 44:
            {
            $XmlPath$ $node0$ = new $XmlPath$($head$);
                 $head$ = ($XmlPath$)$node0$;
 $node0$.add((int)node($rule$,1).nvalue());
            break;
            }
          case 45:
            {
            $XmlPath$ $node0$ = new $XmlPath$($head$);
                 $head$ = ($XmlPath$)$node0$;
    $XmlPath$ $node1$;
                if (node($rule$,1) instanceof $XmlPath$)
                   $node1$ = ($XmlPath$)node($rule$,1);
                 else
                 {
                     $node1$ = new $XmlPath$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
 $node0$.addTo($node1$.xmlPath,(int)node($rule$,3).nvalue());
            break;
            }
          case 49:
            {
            $XmlTreeRef$ $node1$;
                if (node($rule$,1) instanceof $XmlTreeRef$)
                   $node1$ = ($XmlTreeRef$)node($rule$,1);
                 else
                 {
                     $node1$ = new $XmlTreeRef$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      children.add($node1$.cstChildPosition);
      xmlPaths.add($node1$.xmlPath);
      wrapperPaths.add($node1$.wrapperPath);
      attributeNames.add($node1$.attributeName);
      terminalValueFlag = $node1$.hasTerminalValueContent;
      textInfos.add($node1$.textInfo);
            break;
            }
          case 50:
            {
            $XmlTreeRef$ $node3$;
                if (node($rule$,3) instanceof $XmlTreeRef$)
                   $node3$ = ($XmlTreeRef$)node($rule$,3);
                 else
                 {
                     $node3$ = new $XmlTreeRef$(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

      children.add($node3$.cstChildPosition);
      xmlPaths.add($node3$.xmlPath);
      wrapperPaths.add($node3$.wrapperPath);
      attributeNames.add($node3$.attributeName);
      terminalValueFlag = $node3$.hasTerminalValueContent;
      textInfos.add($node3$.textInfo);
            break;
            }
          case 51:
            {
            $XmlTreeRef$ $node0$ = new $XmlTreeRef$($head$);
                 $head$ = ($XmlTreeRef$)$node0$;
    $XmlChildSpec$ $node1$;
                if (node($rule$,1) instanceof $XmlChildSpec$)
                   $node1$ = ($XmlChildSpec$)node($rule$,1);
                 else
                 {
                     $node1$ = new $XmlChildSpec$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    $AttributeName_opt$ $node2$;
                if (node($rule$,2) instanceof $AttributeName_opt$)
                   $node2$ = ($AttributeName_opt$)node($rule$,2);
                 else
                 {
                     $node2$ = new $AttributeName_opt$(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }

      $node0$.cstChildPosition = $node1$.cstChildPosition;
      $node0$.xmlPath = $node1$.xmlPath;
      $node0$.wrapperPath = $node1$.wrapperPath;
      $node0$.attributeName = $node2$.attributeName;
      $node0$.hasTerminalValueContent = $node1$.hasTerminalValueContent;
      $node0$.textInfo = $node1$.textInfo;
            break;
            }
          case 53:
            {
            $AttributeName_opt$ $node0$ = new $AttributeName_opt$($head$);
                 $head$ = ($AttributeName_opt$)$node0$;
    $AttributeName$ $node1$;
                if (node($rule$,1) instanceof $AttributeName$)
                   $node1$ = ($AttributeName$)node($rule$,1);
                 else
                 {
                     $node1$ = new $AttributeName$(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

      $node0$.attributeName = $node1$.attributeName;
            break;
            }
          case 0: case 1: case 4: case 36: case 42: case 52: case 54: case 56: 
            break;
          default:
            $head$ = $head$.copy(node($rule$,1));
            break;
        }
      return $head$;
    }

  /* **************** */
  /* TERMINAL SYMBOLS */
  /* **************** */

  static void initializeTerminals ()
    {
      terminals = new ParserTerminal[23];

      newTerminal(0,"$EMPTY$",1,2);
      newTerminal(1,"$E_O_I$",1,2);
      newTerminal(2,"error",1,2);
      newTerminal(3,"$XmlAnnotation_switch$",1,2);
      newTerminal(4,"DOT",1,2);
      newTerminal(5,"STAR",1,2);
      newTerminal(6,"SLASH",1,2);
      newTerminal(7,"POSITION",11,2);
      newTerminal(8,"SYMBOL",11,2);
      newTerminal(9,"TEXT",11,2);
      newTerminal(10,"VALUE",11,2);
      newTerminal(11,"NSPREFIX",11,2);
      newTerminal(12,"LOCALNAME",11,2);
      newTerminal(13,"ATTRIBUTES",11,2);
      newTerminal(14,"CHILDREN",11,2);
      newTerminal(15,"LISTSEP",11,2);
      newTerminal(16,"KEYVALSEP",11,2);
      newTerminal(17,"{",1,2);
      newTerminal(18,"}",1,2);
      newTerminal(19,"(",1,2);
      newTerminal(20,")",1,2);
      newTerminal(21,"[",1,2);
      newTerminal(22,"]",1,2);
    }

  /* ******************** */
  /* NON-TERMINAL SYMBOLS */
  /* ******************** */

  static void initializeNonTerminals ()
    {
      nonterminals = new ParserNonTerminal[37];

      newNonTerminal(0,"$START$");
      newNonTerminal(1,"$ROOTS$");
      newNonTerminal(2,"WrapperPath_opt");
      newNonTerminal(3,"WrapperPath");
      newNonTerminal(4,"ChildXmlTree");
      newNonTerminal(5,"XmlChildSpec");
      newNonTerminal(6,"XmlTreeRef");
      newNonTerminal(7,"AttributeName_opt");
      newNonTerminal(8,"AttributeName");
      newNonTerminal(9,"AttributeValue");
      newNonTerminal(10,"XmlPath_opt");
      newNonTerminal(11,"XmlPath");
      newNonTerminal(12,"DotOrStar");
      newNonTerminal(13,"TextArgument");
      newNonTerminal(14,"TextRef");
      newNonTerminal(15,"TextArguments");
      newNonTerminal(16,"SpecialForm");
      newNonTerminal(17,"XmlAnnotation");
      newNonTerminal(18,"AnnotationPairs");
      newNonTerminal(19,"AnnotationPair");
      newNonTerminal(20,"NSPrefixPair");
      newNonTerminal(21,"LocalNamePair");
      newNonTerminal(22,"AttributesPair");
      newNonTerminal(23,"ChildrenPair");
      newNonTerminal(24,"NSPrefixKey");
      newNonTerminal(25,"NSPrefixValue");
      newNonTerminal(26,"KeyValSep_opt");
      newNonTerminal(27,"LocalNameKey");
      newNonTerminal(28,"LocalNameValue");
      newNonTerminal(29,"AttributesKey");
      newNonTerminal(30,"AttributesValue");
      newNonTerminal(31,"Attributes");
      newNonTerminal(32,"Attribute");
      newNonTerminal(33,"ListSep_opt");
      newNonTerminal(34,"ChildrenKey");
      newNonTerminal(35,"ChildrenValue");
      newNonTerminal(36,"XmlTreeRefs");
    }

  /* **************** */
  /* PRODUCTION RULES */
  /* **************** */

  static void initializeRules ()
    {
      rules = new ParserRule[58];

      rules[0] = new ParserRule(0,1,0,1,2);
      rules[1] = new ParserRule(1,1,1,1,2);
      rules[2] = new ParserRule(1,2,2,1,2);
      rules[3] = new ParserRule(17,1,3,1,2);
      rules[4] = new ParserRule(18,0,4,1,2);
      rules[5] = new ParserRule(18,2,5,1,2);
      rules[6] = new ParserRule(19,1,6,1,2);
      rules[7] = new ParserRule(19,1,7,1,2);
      rules[8] = new ParserRule(19,1,8,1,2);
      rules[9] = new ParserRule(19,1,9,1,2);
      rules[10] = new ParserRule(20,2,10,1,2);
      rules[11] = new ParserRule(24,2,11,11,2);
      rules[12] = new ParserRule(25,1,12,11,2);
      rules[13] = new ParserRule(21,2,13,1,2);
      rules[14] = new ParserRule(27,2,14,11,2);
      rules[15] = new ParserRule(28,1,15,11,2);
      rules[16] = new ParserRule(22,2,16,1,2);
      rules[17] = new ParserRule(29,2,17,11,2);
      rules[18] = new ParserRule(30,3,18,1,2);
      rules[19] = new ParserRule(31,1,19,1,2);
      rules[20] = new ParserRule(31,3,20,1,2);
      rules[21] = new ParserRule(32,3,21,11,2);
      rules[22] = new ParserRule(9,1,22,1,2);
      rules[23] = new ParserRule(9,1,23,11,2);
      rules[24] = new ParserRule(9,3,24,11,2);
      rules[25] = new ParserRule(16,1,25,11,2);
      rules[26] = new ParserRule(16,4,26,1,2);
      rules[27] = new ParserRule(15,1,27,1,2);
      rules[28] = new ParserRule(15,3,28,1,2);
      rules[29] = new ParserRule(13,1,29,11,2);
      rules[30] = new ParserRule(13,1,30,1,2);
      rules[31] = new ParserRule(14,2,31,1,2);
      rules[32] = new ParserRule(8,2,32,11,2);
      rules[33] = new ParserRule(5,2,33,1,2);
      rules[34] = new ParserRule(4,1,34,1,2);
      rules[35] = new ParserRule(4,2,35,11,2);
      rules[36] = new ParserRule(2,0,36,1,2);
      rules[37] = new ParserRule(2,1,37,1,2);
      rules[38] = new ParserRule(3,2,38,11,2);
      rules[39] = new ParserRule(3,3,39,11,2);
      rules[40] = new ParserRule(12,1,40,1,2);
      rules[41] = new ParserRule(12,1,41,1,2);
      rules[42] = new ParserRule(10,0,42,1,2);
      rules[43] = new ParserRule(10,3,43,1,2);
      rules[44] = new ParserRule(11,1,44,11,2);
      rules[45] = new ParserRule(11,3,45,11,2);
      rules[46] = new ParserRule(23,2,46,1,2);
      rules[47] = new ParserRule(34,2,47,11,2);
      rules[48] = new ParserRule(35,3,48,1,2);
      rules[49] = new ParserRule(36,1,49,1,2);
      rules[50] = new ParserRule(36,3,50,1,2);
      rules[51] = new ParserRule(6,2,51,1,2);
      rules[52] = new ParserRule(7,0,52,1,2);
      rules[53] = new ParserRule(7,1,53,1,2);
      rules[54] = new ParserRule(26,0,54,1,2);
      rules[55] = new ParserRule(26,1,55,11,2);
      rules[56] = new ParserRule(33,0,56,1,2);
      rules[57] = new ParserRule(33,1,57,11,2);
    }

  /* ************** */
  /* PARSER ACTIONS */
  /* ************** */

  static void initializeParserActions ()
    {
      actions = new ParserAction[346];

      newAction(0,5,0);
      newAction(1,2,0);
      newAction(2,0,3);
      newAction(3,1,4);
      newAction(4,1,4);
      newAction(5,1,4);
      newAction(6,1,4);
      newAction(7,1,4);
      newAction(8,1,1);
      newAction(9,1,4);
      newAction(10,1,4);
      newAction(11,1,4);
      newAction(12,1,4);
      newAction(13,1,4);
      newAction(14,1,3);
      newAction(15,0,14);
      newAction(16,0,15);
      newAction(17,0,16);
      newAction(18,0,17);
      newAction(19,1,5);
      newAction(20,1,5);
      newAction(21,1,5);
      newAction(22,1,5);
      newAction(23,1,5);
      newAction(24,1,6);
      newAction(25,1,6);
      newAction(26,1,6);
      newAction(27,1,6);
      newAction(28,1,6);
      newAction(29,1,7);
      newAction(30,1,7);
      newAction(31,1,7);
      newAction(32,1,7);
      newAction(33,1,7);
      newAction(34,1,8);
      newAction(35,1,8);
      newAction(36,1,8);
      newAction(37,1,8);
      newAction(38,1,8);
      newAction(39,1,9);
      newAction(40,1,9);
      newAction(41,1,9);
      newAction(42,1,9);
      newAction(43,1,9);
      newAction(44,0,84);
      newAction(45,0,82);
      newAction(46,0,67);
      newAction(47,0,24);
      newAction(48,1,54);
      newAction(49,0,19);
      newAction(50,1,54);
      newAction(51,0,19);
      newAction(52,1,54);
      newAction(53,0,19);
      newAction(54,1,54);
      newAction(55,0,19);
      newAction(56,1,47);
      newAction(57,1,55);
      newAction(58,1,55);
      newAction(59,1,55);
      newAction(60,1,55);
      newAction(61,1,55);
      newAction(62,1,55);
      newAction(63,1,17);
      newAction(64,1,14);
      newAction(65,1,11);
      newAction(66,1,46);
      newAction(67,1,46);
      newAction(68,1,46);
      newAction(69,1,46);
      newAction(70,1,46);
      newAction(71,1,36);
      newAction(72,1,36);
      newAction(73,1,36);
      newAction(74,0,27);
      newAction(75,0,63);
      newAction(76,1,56);
      newAction(77,1,56);
      newAction(78,1,56);
      newAction(79,1,56);
      newAction(80,0,49);
      newAction(81,1,37);
      newAction(82,1,37);
      newAction(83,1,37);
      newAction(84,0,61);
      newAction(85,0,59);
      newAction(86,0,60);
      newAction(87,0,37);
      newAction(88,0,38);
      newAction(89,0,39);
      newAction(90,1,52);
      newAction(91,1,52);
      newAction(92,1,52);
      newAction(93,1,52);
      newAction(94,1,52);
      newAction(95,1,52);
      newAction(96,0,33);
      newAction(97,1,49);
      newAction(98,1,49);
      newAction(99,1,49);
      newAction(100,1,49);
      newAction(101,1,49);
      newAction(102,1,49);
      newAction(103,1,51);
      newAction(104,1,51);
      newAction(105,1,51);
      newAction(106,1,51);
      newAction(107,1,51);
      newAction(108,1,51);
      newAction(109,1,53);
      newAction(110,1,53);
      newAction(111,1,53);
      newAction(112,1,53);
      newAction(113,1,53);
      newAction(114,1,53);
      newAction(115,1,53);
      newAction(116,0,34);
      newAction(117,1,32);
      newAction(118,1,32);
      newAction(119,1,32);
      newAction(120,1,32);
      newAction(121,1,32);
      newAction(122,1,32);
      newAction(123,1,32);
      newAction(124,1,33);
      newAction(125,1,33);
      newAction(126,1,33);
      newAction(127,1,33);
      newAction(128,1,33);
      newAction(129,1,33);
      newAction(130,1,33);
      newAction(131,1,34);
      newAction(132,1,34);
      newAction(133,1,34);
      newAction(134,1,34);
      newAction(135,1,34);
      newAction(136,1,34);
      newAction(137,1,34);
      newAction(138,1,42);
      newAction(139,1,42);
      newAction(140,1,42);
      newAction(141,1,42);
      newAction(142,1,42);
      newAction(143,1,42);
      newAction(144,1,42);
      newAction(145,0,52);
      newAction(146,1,25);
      newAction(147,1,25);
      newAction(148,1,25);
      newAction(149,1,25);
      newAction(150,1,25);
      newAction(151,1,25);
      newAction(152,1,25);
      newAction(153,1,25);
      newAction(154,0,40);
      newAction(155,0,37);
      newAction(156,0,42);
      newAction(157,0,38);
      newAction(158,0,39);
      newAction(159,0,47);
      newAction(160,1,56);
      newAction(161,1,56);
      newAction(162,1,56);
      newAction(163,1,56);
      newAction(164,0,49);
      newAction(165,1,29);
      newAction(166,1,29);
      newAction(167,1,29);
      newAction(168,1,29);
      newAction(169,1,29);
      newAction(170,1,29);
      newAction(171,1,30);
      newAction(172,1,30);
      newAction(173,1,30);
      newAction(174,1,30);
      newAction(175,1,30);
      newAction(176,1,30);
      newAction(177,1,52);
      newAction(178,1,52);
      newAction(179,1,52);
      newAction(180,1,52);
      newAction(181,1,52);
      newAction(182,1,52);
      newAction(183,0,33);
      newAction(184,1,27);
      newAction(185,1,27);
      newAction(186,1,27);
      newAction(187,1,27);
      newAction(188,1,27);
      newAction(189,1,27);
      newAction(190,1,31);
      newAction(191,1,31);
      newAction(192,1,31);
      newAction(193,1,31);
      newAction(194,1,31);
      newAction(195,1,31);
      newAction(196,1,26);
      newAction(197,1,26);
      newAction(198,1,26);
      newAction(199,1,26);
      newAction(200,1,26);
      newAction(201,1,26);
      newAction(202,1,26);
      newAction(203,1,26);
      newAction(204,0,37);
      newAction(205,0,42);
      newAction(206,0,38);
      newAction(207,0,39);
      newAction(208,1,57);
      newAction(209,1,57);
      newAction(210,1,57);
      newAction(211,1,57);
      newAction(212,1,28);
      newAction(213,1,28);
      newAction(214,1,28);
      newAction(215,1,28);
      newAction(216,1,28);
      newAction(217,1,28);
      newAction(218,1,35);
      newAction(219,1,35);
      newAction(220,1,35);
      newAction(221,1,35);
      newAction(222,1,35);
      newAction(223,1,35);
      newAction(224,1,35);
      newAction(225,0,54);
      newAction(226,0,55);
      newAction(227,0,56);
      newAction(228,1,44);
      newAction(229,1,44);
      newAction(230,1,43);
      newAction(231,1,43);
      newAction(232,1,43);
      newAction(233,1,43);
      newAction(234,1,43);
      newAction(235,1,43);
      newAction(236,1,43);
      newAction(237,1,43);
      newAction(238,0,57);
      newAction(239,1,45);
      newAction(240,1,45);
      newAction(241,1,38);
      newAction(242,1,38);
      newAction(243,1,38);
      newAction(244,1,38);
      newAction(245,1,40);
      newAction(246,1,40);
      newAction(247,1,40);
      newAction(248,1,40);
      newAction(249,1,41);
      newAction(250,1,41);
      newAction(251,1,41);
      newAction(252,1,41);
      newAction(253,0,59);
      newAction(254,0,60);
      newAction(255,1,39);
      newAction(256,1,39);
      newAction(257,1,39);
      newAction(258,1,39);
      newAction(259,1,48);
      newAction(260,1,48);
      newAction(261,1,48);
      newAction(262,1,48);
      newAction(263,1,48);
      newAction(264,1,36);
      newAction(265,1,36);
      newAction(266,1,36);
      newAction(267,0,27);
      newAction(268,1,50);
      newAction(269,1,50);
      newAction(270,1,50);
      newAction(271,1,50);
      newAction(272,1,50);
      newAction(273,1,50);
      newAction(274,1,16);
      newAction(275,1,16);
      newAction(276,1,16);
      newAction(277,1,16);
      newAction(278,1,16);
      newAction(279,0,70);
      newAction(280,0,78);
      newAction(281,1,56);
      newAction(282,0,49);
      newAction(283,1,19);
      newAction(284,1,19);
      newAction(285,1,19);
      newAction(286,1,54);
      newAction(287,1,54);
      newAction(288,1,54);
      newAction(289,1,54);
      newAction(290,0,19);
      newAction(291,0,74);
      newAction(292,0,75);
      newAction(293,0,38);
      newAction(294,0,39);
      newAction(295,1,21);
      newAction(296,1,21);
      newAction(297,1,21);
      newAction(298,1,22);
      newAction(299,1,22);
      newAction(300,1,22);
      newAction(301,1,23);
      newAction(302,1,23);
      newAction(303,1,23);
      newAction(304,1,42);
      newAction(305,1,42);
      newAction(306,1,42);
      newAction(307,1,42);
      newAction(308,0,52);
      newAction(309,1,52);
      newAction(310,1,52);
      newAction(311,1,52);
      newAction(312,0,33);
      newAction(313,1,24);
      newAction(314,1,24);
      newAction(315,1,24);
      newAction(316,1,18);
      newAction(317,1,18);
      newAction(318,1,18);
      newAction(319,1,18);
      newAction(320,1,18);
      newAction(321,0,70);
      newAction(322,1,20);
      newAction(323,1,20);
      newAction(324,1,20);
      newAction(325,1,13);
      newAction(326,1,13);
      newAction(327,1,13);
      newAction(328,1,13);
      newAction(329,1,13);
      newAction(330,1,15);
      newAction(331,1,15);
      newAction(332,1,15);
      newAction(333,1,15);
      newAction(334,1,15);
      newAction(335,1,10);
      newAction(336,1,10);
      newAction(337,1,10);
      newAction(338,1,10);
      newAction(339,1,10);
      newAction(340,1,12);
      newAction(341,1,12);
      newAction(342,1,12);
      newAction(343,1,12);
      newAction(344,1,12);
      newAction(345,1,2);
    }

  /* ************* */
  /* PARSER STATES */
  /* ************* */

  static void initializeParserStates ()
    {
      states = new ParserState[86];

      for (int i=0; i<86; i++) newState(i);
    }

  /* ************* */
  /* ACTION TABLES */
  /* ************* */

  static void initializeActionTables ()
    {
      newActionTables(80);

      newActionTable(0,6);
	setAction(0,1,3);
	setAction(0,3,2);
	setAction(0,11,4);
	setAction(0,12,5);
	setAction(0,13,6);
	setAction(0,14,7);

      newActionTable(1,1);
	setAction(1,1,1);

      newActionTable(2,1);
	setAction(2,1,8);

      newActionTable(3,5);
	setAction(3,1,9);
	setAction(3,11,10);
	setAction(3,12,11);
	setAction(3,13,12);
	setAction(3,14,13);

      newActionTable(4,5);
	setAction(4,1,14);
	setAction(4,11,15);
	setAction(4,12,16);
	setAction(4,13,17);
	setAction(4,14,18);

      newActionTable(5,5);
	setAction(5,1,19);
	setAction(5,11,20);
	setAction(5,12,21);
	setAction(5,13,22);
	setAction(5,14,23);

      newActionTable(6,5);
	setAction(6,1,24);
	setAction(6,11,25);
	setAction(6,12,26);
	setAction(6,13,27);
	setAction(6,14,28);

      newActionTable(7,5);
	setAction(7,1,29);
	setAction(7,11,30);
	setAction(7,12,31);
	setAction(7,13,32);
	setAction(7,14,33);

      newActionTable(8,5);
	setAction(8,1,34);
	setAction(8,11,35);
	setAction(8,12,36);
	setAction(8,13,37);
	setAction(8,14,38);

      newActionTable(9,5);
	setAction(9,1,39);
	setAction(9,11,40);
	setAction(9,12,41);
	setAction(9,13,42);
	setAction(9,14,43);

      newActionTable(10,1);
	setAction(10,8,44);

      newActionTable(11,1);
	setAction(11,8,45);

      newActionTable(12,1);
	setAction(12,17,46);

      newActionTable(13,1);
	setAction(13,19,47);

      newActionTable(14,2);
	setAction(14,16,49);
	setAction(14,8,48);

      newActionTable(15,2);
	setAction(15,16,53);
	setAction(15,17,52);

      newActionTable(16,2);
	setAction(16,16,55);
	setAction(16,19,54);

      newActionTable(17,1);
	setAction(17,19,56);

      newActionTable(18,6);
	setAction(18,17,61);
	setAction(18,19,62);
	setAction(18,7,57);
	setAction(18,8,58);
	setAction(18,9,59);
	setAction(18,10,60);

      newActionTable(19,1);
	setAction(19,17,63);

      newActionTable(20,1);
	setAction(20,8,64);

      newActionTable(21,1);
	setAction(21,8,65);

      newActionTable(22,5);
	setAction(22,1,66);
	setAction(22,11,67);
	setAction(22,12,68);
	setAction(22,13,69);
	setAction(22,14,70);

      newActionTable(23,4);
	setAction(23,7,71);
	setAction(23,8,74);
	setAction(23,9,72);
	setAction(23,10,73);

      newActionTable(24,6);
	setAction(24,20,75);
	setAction(24,7,76);
	setAction(24,8,77);
	setAction(24,9,78);
	setAction(24,10,79);
	setAction(24,15,80);

      newActionTable(25,4);
	setAction(25,7,81);
	setAction(25,8,84);
	setAction(25,9,82);
	setAction(25,10,83);

      newActionTable(26,2);
	setAction(26,4,85);
	setAction(26,5,86);

      newActionTable(27,3);
	setAction(27,7,87);
	setAction(27,9,89);
	setAction(27,10,88);

      newActionTable(28,7);
	setAction(28,20,95);
	setAction(28,6,96);
	setAction(28,7,90);
	setAction(28,8,91);
	setAction(28,9,92);
	setAction(28,10,93);
	setAction(28,15,94);

      newActionTable(29,6);
	setAction(29,20,102);
	setAction(29,7,97);
	setAction(29,8,98);
	setAction(29,9,99);
	setAction(29,10,100);
	setAction(29,15,101);

      newActionTable(30,6);
	setAction(30,20,108);
	setAction(30,7,103);
	setAction(30,8,104);
	setAction(30,9,105);
	setAction(30,10,106);
	setAction(30,15,107);

      newActionTable(31,7);
	setAction(31,18,114);
	setAction(31,20,115);
	setAction(31,7,109);
	setAction(31,8,110);
	setAction(31,9,111);
	setAction(31,10,112);
	setAction(31,15,113);

      newActionTable(32,1);
	setAction(32,8,116);

      newActionTable(33,7);
	setAction(33,18,122);
	setAction(33,20,123);
	setAction(33,7,117);
	setAction(33,8,118);
	setAction(33,9,119);
	setAction(33,10,120);
	setAction(33,15,121);

      newActionTable(34,7);
	setAction(34,20,130);
	setAction(34,6,124);
	setAction(34,7,125);
	setAction(34,8,126);
	setAction(34,9,127);
	setAction(34,10,128);
	setAction(34,15,129);

      newActionTable(35,7);
	setAction(35,20,137);
	setAction(35,6,131);
	setAction(35,7,132);
	setAction(35,8,133);
	setAction(35,9,134);
	setAction(35,10,135);
	setAction(35,15,136);

      newActionTable(36,8);
	setAction(36,20,144);
	setAction(36,21,145);
	setAction(36,6,138);
	setAction(36,7,139);
	setAction(36,8,140);
	setAction(36,9,141);
	setAction(36,10,142);
	setAction(36,15,143);

      newActionTable(37,8);
	setAction(37,18,152);
	setAction(37,20,153);
	setAction(37,6,146);
	setAction(37,7,147);
	setAction(37,8,148);
	setAction(37,9,149);
	setAction(37,10,150);
	setAction(37,15,151);

      newActionTable(38,1);
	setAction(38,19,154);

      newActionTable(39,4);
	setAction(39,7,155);
	setAction(39,8,156);
	setAction(39,9,158);
	setAction(39,10,157);

      newActionTable(40,6);
	setAction(40,20,159);
	setAction(40,7,160);
	setAction(40,8,161);
	setAction(40,9,162);
	setAction(40,10,163);
	setAction(40,15,164);

      newActionTable(41,6);
	setAction(41,20,170);
	setAction(41,7,165);
	setAction(41,8,166);
	setAction(41,9,167);
	setAction(41,10,168);
	setAction(41,15,169);

      newActionTable(42,6);
	setAction(42,20,176);
	setAction(42,7,171);
	setAction(42,8,172);
	setAction(42,9,173);
	setAction(42,10,174);
	setAction(42,15,175);

      newActionTable(43,6);
	setAction(43,20,189);
	setAction(43,7,184);
	setAction(43,8,185);
	setAction(43,9,186);
	setAction(43,10,187);
	setAction(43,15,188);

      newActionTable(44,6);
	setAction(44,20,195);
	setAction(44,7,190);
	setAction(44,8,191);
	setAction(44,9,192);
	setAction(44,10,193);
	setAction(44,15,194);

      newActionTable(45,8);
	setAction(45,18,202);
	setAction(45,20,203);
	setAction(45,6,196);
	setAction(45,7,197);
	setAction(45,8,198);
	setAction(45,9,199);
	setAction(45,10,200);
	setAction(45,15,201);

      newActionTable(46,4);
	setAction(46,7,208);
	setAction(46,8,209);
	setAction(46,9,210);
	setAction(46,10,211);

      newActionTable(47,6);
	setAction(47,20,217);
	setAction(47,7,212);
	setAction(47,8,213);
	setAction(47,9,214);
	setAction(47,10,215);
	setAction(47,15,216);

      newActionTable(48,7);
	setAction(48,20,224);
	setAction(48,6,218);
	setAction(48,7,219);
	setAction(48,8,220);
	setAction(48,9,221);
	setAction(48,10,222);
	setAction(48,15,223);

      newActionTable(49,1);
	setAction(49,7,225);

      newActionTable(50,2);
	setAction(50,4,227);
	setAction(50,22,226);

      newActionTable(51,2);
	setAction(51,4,228);
	setAction(51,22,229);

      newActionTable(52,8);
	setAction(52,18,236);
	setAction(52,20,237);
	setAction(52,6,230);
	setAction(52,7,231);
	setAction(52,8,232);
	setAction(52,9,233);
	setAction(52,10,234);
	setAction(52,15,235);

      newActionTable(53,1);
	setAction(53,7,238);

      newActionTable(54,2);
	setAction(54,4,239);
	setAction(54,22,240);

      newActionTable(55,4);
	setAction(55,7,241);
	setAction(55,8,242);
	setAction(55,9,243);
	setAction(55,10,244);

      newActionTable(56,4);
	setAction(56,7,245);
	setAction(56,8,246);
	setAction(56,9,247);
	setAction(56,10,248);

      newActionTable(57,4);
	setAction(57,7,249);
	setAction(57,8,250);
	setAction(57,9,251);
	setAction(57,10,252);

      newActionTable(58,4);
	setAction(58,7,255);
	setAction(58,8,256);
	setAction(58,9,257);
	setAction(58,10,258);

      newActionTable(59,5);
	setAction(59,1,259);
	setAction(59,11,260);
	setAction(59,12,261);
	setAction(59,13,262);
	setAction(59,14,263);

      newActionTable(60,6);
	setAction(60,20,273);
	setAction(60,7,268);
	setAction(60,8,269);
	setAction(60,9,270);
	setAction(60,10,271);
	setAction(60,15,272);

      newActionTable(61,5);
	setAction(61,1,274);
	setAction(61,11,275);
	setAction(61,12,276);
	setAction(61,13,277);
	setAction(61,14,278);

      newActionTable(62,1);
	setAction(62,8,279);

      newActionTable(63,3);
	setAction(63,18,280);
	setAction(63,8,281);
	setAction(63,15,282);

      newActionTable(64,3);
	setAction(64,18,285);
	setAction(64,8,283);
	setAction(64,15,284);

      newActionTable(65,5);
	setAction(65,16,290);
	setAction(65,7,286);
	setAction(65,8,287);
	setAction(65,9,288);
	setAction(65,10,289);

      newActionTable(66,4);
	setAction(66,7,292);
	setAction(66,8,291);
	setAction(66,9,294);
	setAction(66,10,293);

      newActionTable(67,3);
	setAction(67,18,297);
	setAction(67,8,295);
	setAction(67,15,296);

      newActionTable(68,3);
	setAction(68,18,300);
	setAction(68,8,298);
	setAction(68,15,299);

      newActionTable(69,3);
	setAction(69,18,303);
	setAction(69,8,301);
	setAction(69,15,302);

      newActionTable(70,5);
	setAction(70,18,307);
	setAction(70,21,308);
	setAction(70,6,304);
	setAction(70,8,305);
	setAction(70,15,306);

      newActionTable(71,4);
	setAction(71,18,311);
	setAction(71,6,312);
	setAction(71,8,309);
	setAction(71,15,310);

      newActionTable(72,3);
	setAction(72,18,315);
	setAction(72,8,313);
	setAction(72,15,314);

      newActionTable(73,5);
	setAction(73,1,316);
	setAction(73,11,317);
	setAction(73,12,318);
	setAction(73,13,319);
	setAction(73,14,320);

      newActionTable(74,3);
	setAction(74,18,324);
	setAction(74,8,322);
	setAction(74,15,323);

      newActionTable(75,5);
	setAction(75,1,325);
	setAction(75,11,326);
	setAction(75,12,327);
	setAction(75,13,328);
	setAction(75,14,329);

      newActionTable(76,5);
	setAction(76,1,330);
	setAction(76,11,331);
	setAction(76,12,332);
	setAction(76,13,333);
	setAction(76,14,334);

      newActionTable(77,5);
	setAction(77,1,335);
	setAction(77,11,336);
	setAction(77,12,337);
	setAction(77,13,338);
	setAction(77,14,339);

      newActionTable(78,5);
	setAction(78,1,340);
	setAction(78,11,341);
	setAction(78,12,342);
	setAction(78,13,343);
	setAction(78,14,344);

      newActionTable(79,1);
	setAction(79,1,345);

    }

  /* *********** */
  /* GOTO TABLES */
  /* *********** */

  static void initializeGotoTables ()
    {
      newGotoTables(32);

      newGotoTable(0,3);
	setGoto(0,1,1);
	setGoto(0,17,2);
	setGoto(0,18,4);

      newGotoTable(1,0);

      newGotoTable(2,2);
	setGoto(2,17,85);
	setGoto(2,18,4);

      newGotoTable(3,9);
	setGoto(3,34,13);
	setGoto(3,19,5);
	setGoto(3,20,6);
	setGoto(3,21,7);
	setGoto(3,22,8);
	setGoto(3,23,9);
	setGoto(3,24,10);
	setGoto(3,27,11);
	setGoto(3,29,12);

      newGotoTable(4,1);
	setGoto(4,25,83);

      newGotoTable(5,1);
	setGoto(5,28,81);

      newGotoTable(6,1);
	setGoto(6,30,66);

      newGotoTable(7,1);
	setGoto(7,35,23);

      newGotoTable(8,1);
	setGoto(8,26,22);

      newGotoTable(9,1);
	setGoto(9,26,21);

      newGotoTable(10,1);
	setGoto(10,26,20);

      newGotoTable(11,1);
	setGoto(11,26,18);

      newGotoTable(12,5);
	setGoto(12,2,28);
	setGoto(12,3,26);
	setGoto(12,36,25);
	setGoto(12,5,29);
	setGoto(12,6,30);

      newGotoTable(13,1);
	setGoto(13,33,64);

      newGotoTable(14,1);
	setGoto(14,12,58);

      newGotoTable(15,2);
	setGoto(15,16,36);
	setGoto(15,4,35);

      newGotoTable(16,2);
	setGoto(16,7,31);
	setGoto(16,8,32);

      newGotoTable(17,1);
	setGoto(17,10,51);

      newGotoTable(18,5);
	setGoto(18,16,36);
	setGoto(18,4,44);
	setGoto(18,13,45);
	setGoto(18,14,43);
	setGoto(18,15,41);

      newGotoTable(19,1);
	setGoto(19,33,48);

      newGotoTable(20,2);
	setGoto(20,7,46);
	setGoto(20,8,32);

      newGotoTable(21,4);
	setGoto(21,16,36);
	setGoto(21,4,44);
	setGoto(21,13,50);
	setGoto(21,14,43);

      newGotoTable(22,1);
	setGoto(22,11,53);

      newGotoTable(23,1);
	setGoto(23,12,62);

      newGotoTable(24,4);
	setGoto(24,2,28);
	setGoto(24,3,26);
	setGoto(24,5,29);
	setGoto(24,6,65);

      newGotoTable(25,2);
	setGoto(25,32,69);
	setGoto(25,31,68);

      newGotoTable(26,1);
	setGoto(26,33,79);

      newGotoTable(27,1);
	setGoto(27,26,71);

      newGotoTable(28,2);
	setGoto(28,16,73);
	setGoto(28,9,72);

      newGotoTable(29,1);
	setGoto(29,10,76);

      newGotoTable(30,2);
	setGoto(30,7,77);
	setGoto(30,8,32);

      newGotoTable(31,1);
	setGoto(31,32,80);

    }

  /* ************ */
  /* STATE TABLES */
  /* ************ */

  static void initializeStateTables ()
    {
      setTables(0,0,0);
      setTables(1,1,1);
      setTables(2,2,1);
      setTables(3,3,2);
      setTables(4,4,3);
      setTables(5,5,1);
      setTables(6,6,1);
      setTables(7,7,1);
      setTables(8,8,1);
      setTables(9,9,1);
      setTables(10,10,4);
      setTables(11,11,5);
      setTables(12,12,6);
      setTables(13,13,7);
      setTables(14,14,8);
      setTables(15,14,9);
      setTables(16,15,10);
      setTables(17,16,11);
      setTables(18,17,1);
      setTables(19,18,1);
      setTables(20,19,1);
      setTables(21,20,1);
      setTables(22,21,1);
      setTables(23,22,1);
      setTables(24,23,12);
      setTables(25,24,13);
      setTables(26,25,1);
      setTables(27,26,14);
      setTables(28,27,15);
      setTables(29,28,16);
      setTables(30,29,1);
      setTables(31,30,1);
      setTables(32,31,1);
      setTables(33,32,1);
      setTables(34,33,1);
      setTables(35,34,1);
      setTables(36,35,1);
      setTables(37,36,17);
      setTables(38,37,1);
      setTables(39,38,1);
      setTables(40,39,18);
      setTables(41,40,19);
      setTables(42,41,1);
      setTables(43,42,1);
      setTables(44,28,20);
      setTables(45,43,1);
      setTables(46,44,1);
      setTables(47,45,1);
      setTables(48,39,21);
      setTables(49,46,1);
      setTables(50,47,1);
      setTables(51,48,1);
      setTables(52,49,22);
      setTables(53,50,1);
      setTables(54,51,1);
      setTables(55,52,1);
      setTables(56,53,1);
      setTables(57,54,1);
      setTables(58,55,1);
      setTables(59,56,1);
      setTables(60,57,1);
      setTables(61,26,23);
      setTables(62,58,1);
      setTables(63,59,1);
      setTables(64,23,24);
      setTables(65,60,1);
      setTables(66,61,1);
      setTables(67,62,25);
      setTables(68,63,26);
      setTables(69,64,1);
      setTables(70,65,27);
      setTables(71,66,28);
      setTables(72,67,1);
      setTables(73,68,1);
      setTables(74,69,1);
      setTables(75,70,29);
      setTables(76,71,30);
      setTables(77,72,1);
      setTables(78,73,1);
      setTables(79,62,31);
      setTables(80,74,1);
      setTables(81,75,1);
      setTables(82,76,1);
      setTables(83,77,1);
      setTables(84,78,1);
      setTables(85,79,1);
    }
}

/* ***************** */
/* ANCILLARY CLASSES */
/* ***************** */

class $WrapperPath_opt$ extends ParseNode 
{
  $WrapperPath_opt$ (ParseNode node)
    {
      super(node);
    }

  ArrayList wrapperPath = null;
}

class $WrapperPath$ extends $WrapperPath_opt$ 
{
  $WrapperPath$ (ParseNode node)
    {
      super(node);
    }

  // Set wrapperPath to a new list and add to it the XML wrapper
    // (the symbol and its distribution switch):
    void add (String s, boolean b)
      {
	(wrapperPath = new ArrayList()).add(new XmlWrapper(s,b));
      }

    // Set wrapperPath to the specified path, and add to it the XML
    // wrapper (the symbol and its distribution switch):
    void addTo (ArrayList path, String s, boolean b)
      {
	(wrapperPath = path).add(new XmlWrapper(s,b));
      }
}

class $ChildXmlTree$ extends ParseNode 
{
  $ChildXmlTree$ (ParseNode node)
    {
      super(node);
    }

  int cstChildPosition;
    IntArrayList xmlPath = null;    
    boolean hasTerminalValueContent = false;
    ArrayList textInfo = null;
}

class $XmlChildSpec$ extends $ChildXmlTree$ 
{
  $XmlChildSpec$ (ParseNode node)
    {
      super(node);
    }

  ArrayList wrapperPath = null;
}

class $XmlTreeRef$ extends $XmlChildSpec$ 
{
  $XmlTreeRef$ (ParseNode node)
    {
      super(node);
    }

  String attributeName = null;
}

class $AttributeName_opt$ extends ParseNode 
{
  $AttributeName_opt$ (ParseNode node)
    {
      super(node);
    }

  String attributeName = null;
}

class $AttributeName$ extends $AttributeName_opt$ 
{
  $AttributeName$ (ParseNode node)
    {
      super(node);
    }

  
}

class $AttributeValue$ extends $XmlTreeRef$ 
{
  $AttributeValue$ (ParseNode node)
    {
      super(node);
    }

  boolean hasLiteralValueContent = false;
    String value = null;
    ArrayList textInfo = null;
}

class $XmlPath_opt$ extends ParseNode 
{
  $XmlPath_opt$ (ParseNode node)
    {
      super(node);
    }

  IntArrayList xmlPath = null;
}

class $XmlPath$ extends $XmlPath_opt$ 
{
  $XmlPath$ (ParseNode node)
    {
      super(node);
    }

  // Set xmlPath to a new list and add to it the specififed number.
    void add (int n)
      {
	(xmlPath = new IntArrayList()).add(n);
      }

    // Set xmlPath to the specified path, and add to it the specififed
    // number.
    void addTo (IntArrayList path, int n)
      {
	(xmlPath = path).add(n);
      }
}

class $DotOrStar$ extends ParseNode 
{
  $DotOrStar$ (ParseNode node)
    {
      super(node);
    }

  boolean isStarred = false;
}

class $TextArgument$ extends ParseNode 
{
  $TextArgument$ (ParseNode node)
    {
      super(node);
    }

  XmlTextInfoArg info = null;
}

class $TextRef$ extends $TextArgument$ 
{
  $TextRef$ (ParseNode node)
    {
      super(node);
    }

  
}

class $TextArguments$ extends ParseNode 
{
  $TextArguments$ (ParseNode node)
    {
      super(node);
    }

  ArrayList textInfo = null;
}

class $SpecialForm$ extends $TextArguments$ 
{
  $SpecialForm$ (ParseNode node)
    {
      super(node);
    }

  boolean hasTerminalValueContent = false;
}

