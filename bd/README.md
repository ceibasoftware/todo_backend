To execute the docker that mysql instantiates the file <run.bat>, before you must edit it to configure the path of the sql scripts to initialize the database, you can also execute the following manually in the command line:

1.  docker run -d -p 3306:3306 --name my-mysql -v <sql script Path>:/docker-entrypoint-initdb.d/ -e MYSQL_ROOT_PASSWORD=ceiba -e MYSQL_DATABASE=ceiba mysql

2.  docker exec -it my-mysql /bin/bash

3.  mysql -u root -p

Connection data:
- database <ceiba>
- user: root 
- password: ceiba