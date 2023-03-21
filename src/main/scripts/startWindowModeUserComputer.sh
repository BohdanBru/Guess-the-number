#!/usr/bin/env sh
#
# Copyright 2023 Bohdan Brukhovets
#
#    Licensed under the Apache License, Version 2.0 (the "License");
#    you may not use this file except in compliance with the License.
#    You may obtain a copy of the License at
#
#        http://www.apache.org/licenses/LICENSE-2.0
#
#    Unless required by applicable law or agreed to in writing, software
#    distributed under the License is distributed on an "AS IS" BASIS,
#    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#    See the License for the specific language governing permissions and
#    limitations under the License.
#
#

# The cmd script to start tic-tac-toe game for Unix system
# author Bohdan Brukhovets
# emaul: mattewgreenman@gmail.com
# linkdin: https://www.linkedin.com/in/bohdan-brukhovets/
###################################################################################
#----------------------------------------------------------------------------------
# Try to use the java from '$JAVA_HOME' if this environment variable set cerrectly:
# Fix current dir issue for MacOS
    cd "$(dirname "$0")" || exit
    #--------------------------------------------
    ./start.sh  user compute