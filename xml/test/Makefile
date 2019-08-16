# FILE. . . . . /home/hak/hlt/src/hlt/language/syntax/xml/test/Makefile
# EDIT BY . . . Hassan Ait-Kaci
# ON MACHINE. . Hp-Dv7
# STARTED ON. . Tue Jun 19 18:11:21 2012

# Last modified on Fri Oct 12 02:10:12 2012 by hak

# See http://dom4j.sourceforge.net/

HOME		= C:/cygwin/home/hak
CLASSROOT	= ${HOME}/hlt/classes
CLASSPATH	= .;${CLASSROOT};${CLASSROOT}/dom4j-1.6.1.jar
JC		= @javac -O -d . -classpath "$(CLASSPATH)" #-Xlint:unchecked
JV		= @java -classpath "$(CLASSPATH)"
SAY		= @echo "***"
TRASH		= ,* ,.* *~ @*@ .*~ core hlt.rcl.tar*
RM		= /bin/rm

all: test1

test1: ctest1 rtest1

ctest1: tidy
	$(SAY) compiling Test1.java
	$(JC) Test1.java

rtest1:
	$(SAY) running Test1...
	$(JV) Test1

tidy:
	$(SAY) Tidying up directory...
	@\rm -rf $(TRASH)
