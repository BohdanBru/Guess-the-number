#!/usr/bin/env sh
# The cmd script to start tic-tac-toe game for Unix system
# author Bohdan Brukhovets
# emaul: mattewgreenman@gmail.com
# linkdin: https://www.linkedin.com/in/bohdan-brukhovets/
###################################################################################
#----------------------------------------------------------------------------------
# Try to use the java from '$JAVA_HOME' if this environment variable set cerrectly:
if [ -n "$JAVA_HOME" ] && [ -x "$JAVA_HOME/bin/java" ] ; then
  JAVA_CMD="$JAVA_HOME/bin/java"
  fi
#-----------------------------------------------------------------------------------

#Try to use the java using PATH environment variable:
WHITH_JAVA=$(which java)
if [ -x "$WHICH_JAVA" ]; then
  JAVA_CMD="java"
  unset WHICH_JAVA
  fi
# Fix current dir issue
    cd "$(dirname "$0")" || exit
# Try to use 'java' from JRE if 'jre/bin/java' exist and executable
if [ -x "jre/bin/java" ]; then
  JAVA_CMD="jre/bin/java"
  fi
#------------------------------------------------------------------------------------
if [ -z ${JAVA_CMD+x} ]; then
  #Throw error if java is not configured:
  echo "------------------------------------------------------------------------------"
  echo "\'java\' not defined! Install or configure JVM before using script!"
  echo "------------------------------------------------------------------------------"
  RETURN_CODE=1
  else

    #Run tic-tac-toe game:
    # shellcheck disable=SC2068
    $JAVA_CMD -jar ${project.build.finalName}.jar "$@"
    RETURN_CODE=0
    fi
    #----------------------------------------------------------------------------------
    # Wait for the enter key pressed:
  #  echo "Press enter to continue . . ."
  # read -r test
    #----------------------------------------------------------------------------------
    exit $RETURN_CODE

# cd "$(dirname "$0")" || exit
# java -jar ${project.build.finalName}-release.jar
# echo "Please, press ENTER to continue . . . "
# read -r test