#!/bin/bash
# This script is necessary for the maven-release-plugin since it does not handle git submodules
git submodule update --init
git submodule foreach git submodule update --init