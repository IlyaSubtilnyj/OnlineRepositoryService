#!/bin/zsh

# Update new javadocs.

JAVADOC_PATH="../../javadoc"
PACKAGE=org.example.onlinestoreservice

rm -rf $JAVADOC_PATH/*

javadoc -d $JAVADOC_PATH $PACKAGE