call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/TestSuites/bvtSG/bvt_sg_contacts.xml -Dtest_env=xyz allure:serve -DtestRunId=1
