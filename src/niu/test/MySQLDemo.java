package niu.test;

/**
 * Created by Tom on 2017/1/13.
 * step 1: 修改mysql配置文件，重启数据库服务
 [client] default-character-set = utf8mb4

 [mysql] default-character-set = utf8mb4

 [mysqld]
 character-set-client-handshake = FALSE
 character-set-server = utf8mb4
 collation-server = utf8mb4_unicode_ci
 init_connect='SET NAMES utf8mb4'

 step2: 检查修改是否生效
 SHOW VARIABLES WHERE Variable_name LIKE 'character_set_%' OR Variable_name LIKE 'collation%';

 setp3:
 -- 对新的数据库对象生效
 ALTER DATABASE test CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;
 -- 以下脚本一一转化以后的数据库对象、注意先备份数据
 ALTER TABLE t_utf8 CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
 ALTER TABLE t_utf8 MODIFY c_content VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

 备注测试脚本:
 DROP TABLE t_utf8;

 CREATE TABLE `t_utf8`(
 `c_content` VARCHAR(100)
 ) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_unicode_ci;

 DROP TABLE t_utf8mb4;

 CREATE TABLE `t_utf8mb4`(
 `c_content` VARCHAR(100)
 ) ENGINE=INNODB CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


 INSERT INTO t_utf8 VALUES('中国');

 INSERT INTO t_utf8 VALUES("test𪚲");

 SELECT * FROM t_utf8;


 INSERT INTO t_utf8mb4 VALUES('中国');

 INSERT INTO t_utf8mb4 VALUES("test𪚲");

 SELECT * FROM t_utf8mb4;
 */

import java.sql.*;

public class MySQLDemo {

    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String tableName = "t_utf8";
        //String tableName = "t_utf8mb4";
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // insert statement
            String query = " insert into " + tableName + " (c_content)"
                    + " values (?)";

            // preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString (1, "测试\uD869\uDEB2");

            // execute the preparedstatement
            preparedStmt.execute();

            // 执行查询
            System.out.println(" 实例化Statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT c_content FROM " + tableName;
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String c_content = rs.getString("c_content");

                // 输出数据
                System.out.print("内容: " + c_content);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}