call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean
call mvn clean mvn test -DsuiteXmlFile=src/test/resources/testSuites/bvtSG/bvtpeople_sg_employee.xml -Dtest_env=https://people-qa.deskera.xyz allure:serve -DtestRunId=1

