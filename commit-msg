#!/bin/sh

# Run the script and get the return code if successful of if fails
./scripts/commit-filter-check.sh && rc=$? || rc=$?
echo return code : $rc
if $rc == 1
then
	echo "Script return code 1 so commit failed"
	exit 1
else
	echo "No error returned so commit successful"
fi