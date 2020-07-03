call mvn clean
call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/TestSuites/bvtSG/bvt_sg.xml -Dtest_env=https://auth-qa.deskera.xyz/ allure:report -DtestRunId=1