call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/testSuites/bvtSG/bvt_sg_import.xml -Dtest_env=https://auth-qa.deskera.xyz/ allure:report -DtestRunId=1