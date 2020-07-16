call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/testSuites/bvtSG/bvt_base_setup_SG.xml -Dtest_env=https://auth-qa.deskera.xyz/ allure:report -DtestRunId=1

