#!/usr/bin/env bash
RED='\033[0;31m'
### GREEN='\033[0;32m'
NC='\033[0m' # No Color
printf "\n\n\n\n${RED}Running API Integration Tests${NC}\n\n\n\n"
mvn test -Dcucumber.plugin="pretty, html:target/integration-test/integration-test-results.html" -Dcucumber.features="src/test/resources/features/" -Dcucumber.filter.tags="not @ignored" -Dcucumber.publish.quiet=true
