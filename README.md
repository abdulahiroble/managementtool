## Setup database connection

Instal MysQL Workbench https://dev.mysql.com/downloads/workbench/

### Setup remote database

Create a free gearhost account https://my.gearhost.com/account/signup

### Connect to datbase using JDBC

```
public Connection establishConnection() throws SQLException {
            Connection connection = DriverManager.getConnection("DATABASE SERVER",
                    USERNAME", "PASSWORD");

            return connection;
        }
```

## Run application

```
src -> main -> ManagementToolApplication.java
```

The admin login is:

```
email: abdulahi_2610@hotmail.com
Password: 123
```

The employee login is:

```
email:hans@gmail.com
Password: hans123
```
