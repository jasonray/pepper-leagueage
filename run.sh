#!/usr/bin/env bash
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

printf "\n\n\n\n${RED}Building API${NC}\n\n\n\n"
mvn install
if [ $? -ne 0 ]
then
  echo "Build failed" >&2
  exit $?
fi

printf "\n\n\n\n${RED}Running API${NC}\n\n\n\n"
mvn spring-boot:run
