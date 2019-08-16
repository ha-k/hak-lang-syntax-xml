# FILE. . . . . /home/hak/hlt/src/hlt/language/syntax/xml/Makefile
# EDIT BY . . . Hassan Ait-Kaci
# ON MACHINE. . Hp-Dv7
# STARTED ON. . Fri Oct 12 01:02:28 2012

# Last modified on Mon Mar 26 08:55:02 2018 by hak

########################################################################
HOME		= D:/hak
HLT_HOME	= ${HOME}/hlt
CLASSPATH	= ${HLT_HOME}/classes
PACKAGE		= hlt.language.syntax.xml
CLASSDIR	= ${HLT_HOME}/classes
SRCDIR		= .
DOCDIR		= XmlAnnotationDoc
#SAVEDIR	= ${HLT_HOME}/save/language/syntax/xml 
JACC		= @java -classpath "${CLASSPATH}" hlt.language.syntax.Jacc
DOC		= ${JACC} -doc -s /
HL		= hl -! -d ${DOCDIR}
CHECK		= ${JACC} -n
LOG		= ${JACC} -n -v 4 -o XmlAnnotation.log
JC		= @javac -classpath "${CLASSPATH}" -O -d "${CLASSDIR}"
SAY		= @echo "***"
NL		= @echo
RM		= /usr/bin/rm
TRASH		= ,* ,.* *~ @*@ .*~ core 
NOW		= ${shell date +%Y_%m_%d-%I_%M_%S_%p}
########################################################################
all: parser code
########################################################################
full: parser code doc
########################################################################
parser: tidy
	${SAY} Generating the parser ...
	${JACC} -p XmlAnnotationParser XmlAnnotation
########################################################################
code:
	${SAY} Compiling Java files and deploying class files ...
	${JC} *.java
	${NL}
	${SAY} The XmlAnnotationParser classes have been deployed!
	${NL}
########################################################################
check: tidy
	${SAY} Checking the grammar XmlAnnotation.grm...
	${CHECK} XmlAnnotation.grm
########################################################################
doc: tidy
	${SAY} Generating Javadoc documentation ...
	${SAY} Deleting the old documentation ...
	${RM} -rf ${DOCDIR}
	@mkdir ${DOCDIR}
	${HL} *.grm *.java
	@mv ${DOCDIR}/index.html ${DOCDIR}/JavaSources.html
	${SAY} See hilited source files in ${DOCDIR}/JavaSources.html
	${DOC} XmlAnnotation.grm
	@mv ${DOCDIR}/index.html ${DOCDIR}/000StartHere.html
	@cp -r ${HLT_HOME}/src/images ${DOCDIR}/
	${SAY} Grammar hyperdocumentation in ${DOCDIR}/000StartHere.html
	${NL}
########################################################################
log: tidy
	${LOG} XmlAnnotation
	${SAY} Wrote XmlAnnotation.log
	@grep 'conflict:' XmlAnnotation.log | grep "\*\*\*" || echo "***" This grammar has no confict
########################################################################
tidy:
	${SAY} Tidying up directory ${HLT_HOME}/syntax/xml
	${RM} -rf ${TRASH}
########################################################################

