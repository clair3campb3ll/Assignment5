

JAVAC=/usr/bin/javac 
JAVA=/usr/bin/java

.SUFFIXES: .java .class

SRCDIR = SRCDIR
BINDER = bin

$(BINDER)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDER)/ -cp $(BINDER) -sourcepath $(SRCDIR)$<

CLASSES = Vertex.class Edge.class Path.class\
		GraphException.class Graph.class GraphExperiment.class\

CLASS_FILE = $(CLASSES:%.class=$(BINDER)/%.class)

default: $(CLASS_FILE)

run: $(CLASS_FILE)
	$(JAVA) -cp bin GraphExperiment