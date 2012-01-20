#!/bin/bash
# javac -d bin src/xep/samples/*.java

# sourcepath: reference the other source files e.g. Core.java
# classpath: reference the class files and libraries e.g. class and jar extensions
# javac -d bin -sourcepath src -classpath bin:$CLASSPATH src/xep/test/Basic.java
javac -d bin -sourcepath src -classpath bin:$CLASSPATH src/BindingExamples.java