## Setup database connection

Instal MysQL Workbench https://dev.mysql.com/downloads/workbench/

### Connect to datbase using JDBC

```
public Connection establishConnection() throws SQLException {
            Connection connection = DriverManager.getConnection("DATABASE SERVER",
                    USERNAME", "PASSWORD");

            return connection;
        }
```
