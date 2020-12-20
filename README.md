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

## Demo showing manager login in and assigning task to employeee

![ezgif com-gif-maker (6)](https://user-images.githubusercontent.com/43350898/102712461-c1a6fd80-42c1-11eb-87ac-4ed25a4e3730.gif)

