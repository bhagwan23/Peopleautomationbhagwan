call mvn clean
call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/TestSuites/bvtSG/bvt_sg_buy.xml -Dtest_env=https://auth-qa.deskera.xyz/ allure:serve -DtestRunId=1