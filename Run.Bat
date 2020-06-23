call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/TestSuites/erp/sg.xml -Dtest_env=xyz allure:serve -DtestRunId=1
