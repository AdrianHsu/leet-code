#!/bin/sh

FILE=$1

if [[ $FILE = "" ]] ; then
    echo "please enter the java file"
    exit 3
fi

javac $FILE
RESULT=$(echo $FILE | cut -d '.' -f 1)
java $RESULT 
