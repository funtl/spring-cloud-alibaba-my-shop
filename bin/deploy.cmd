cd ..
cd myshop-dependencies
call mvn deploy

cd ..
cd myshop-external-skywalking
call mvn deploy

cd ..
cd myshop-commons
call mvn deploy

cd ..
cd myshop-commons-domain
call mvn deploy

cd ..
cd myshop-commons-mapper
call mvn deploy

cd ..
cd myshop-commons-service
call mvn deploy

cd ..
cd myshop-commons-consumer
call mvn deploy

cd ..
cd myshop-service-reg
call mvn deploy

cd ..
cd myshop-service-email
call mvn deploy

cd ..
cd myshop-service-gateway
call mvn deploy

cd ..
cd myshop-service-provider-item
call mvn deploy

cd ..
cd myshop-service-consumer-item
call mvn deploy
