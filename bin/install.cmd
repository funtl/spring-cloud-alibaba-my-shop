cd ..
cd myshop-dependencies
call mvn install

cd ..
cd myshop-external-skywalking
call mvn install

cd ..
cd myshop-commons
call mvn install

cd ..
cd myshop-commons-domain
call mvn install

cd ..
cd myshop-commons-mapper
call mvn install

cd ..
cd myshop-commons-service
call mvn install

cd ..
cd myshop-commons-consumer
call mvn clean

cd ..
cd myshop-service-reg
call mvn install

cd ..
cd myshop-service-email
call mvn install

cd ..
cd myshop-service-gateway
call mvn install

cd ..
cd myshop-service-provider-item
call mvn install

cd ..
cd myshop-service-consumer-item
call mvn install
