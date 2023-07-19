package org.example.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;
import org.example.services.LoginClientService;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    public static final Logger LOG= Logger.getLogger(DataSource.class.getName());
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;
    static {
        Properties properties = getProperties();
        config.setJdbcUrl(properties.getProperty(ConstantsDS.CONNECTION_URL));
        config.setUsername(properties.getProperty(ConstantsDS.USER_NAME));
        config.setPassword(properties.getProperty(ConstantsDS.USER_PASSWORD));
        config.setDriverClassName(properties.getProperty(ConstantsDS.DRIVER_CLASS_NAME));
        config.setMaximumPoolSize(ConstantsDS.MAXIMUM_POOL_SIZE);
        config.addDataSourceProperty("cachePrepStmts", properties.getProperty(ConstantsDS.CACHE_PREP_STMTS));
        config.addDataSourceProperty("prepStmtCacheSize", properties.getProperty(ConstantsDS.PREP_STMT_CACHE_SIZE));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", properties.getProperty(ConstantsDS.PREP_STMT_CACHE_SQL_LIMIT));
        dataSource = new HikariDataSource(config);
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    private static Properties getProperties(){
        Properties properties = new Properties();
        try ( InputStream inputStream = DataSource.class
                    .getClassLoader()
                    .getResourceAsStream(ConstantsDS.DB_SETTINGS)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOG.info("Problem with reading db.properties file");
            e.printStackTrace();
        }
        return properties;
    }
}
