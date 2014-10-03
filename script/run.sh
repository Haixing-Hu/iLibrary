#!/bin/bash

# resolve links - $0 may be a softlink
THIS="$0"
while [ -h "$THIS" ]; do
  ls=`ls -ld "$THIS"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '.*/.*' > /dev/null; then
    THIS="$link"
  else
    THIS=`dirname "$THIS"`/"$link"
  fi
done


# get the directory of this script
THIS_DIR=`dirname "$THIS"`

TARGET_DIR="$THIS_DIR/../target"

CLASSPATH=
# add all depended libraries to classpath
if [ -d "$TARGET_DIR/lib" ]; then
    # add plugins to CLASSPATH
    for jar in $TARGET_DIR/lib/*.jar; do
        CLASSPATH=${CLASSPATH}:${jar}
    done
fi
CLASSPATH=${CLASSPATH}:${TARGET_DIR}/classes


#echo "Set CLASSPATH to: ${CLASSPATH}"

#echo "Executing the application ..."

APP_CLASS=com.github.haixing_hu.ilibrary.Application

java -cp ${CLASSPATH} ${APP_CLASS} "$@"
