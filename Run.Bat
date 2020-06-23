call mvn clean
call mvn clean
call mvn clean test -DsuiteXmlFile=src/test/resources/TestSuites/bvtSG/bvt_sg_products.xml -Dtest_env=xyz allure:serve -DtestRunId=1
