*****************************************
Below is the script to copy reporsitry
*****************************************
#!/bin/bash
PRJ_NAME=cns-portal-backend
GIT_USER=farhan23432
GIT_PASS=Farhan@23432
GIT_URL_FROM=http://13.235.248.157:3000/admin123/test1.git
GIT_URL_TO=http://13.235.248.157:3000/admin123/test2.git
docker build .
echo IMAGE_NAME=$GIT_URL_TO