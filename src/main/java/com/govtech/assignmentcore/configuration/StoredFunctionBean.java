package com.govtech.assignmentcore.configuration;

import com.govtech.assignmentcore.common.StoredFunctionName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class StoredFunctionBean {

  @Bean
  public Map<StoredFunctionName, SimpleJdbcCall> simpleJdbcCalls(JdbcTemplate jdbcTemplate) {
    Map<StoredFunctionName, SimpleJdbcCall> result = new HashMap<>();
    for (StoredFunctionName storedFunctionName : StoredFunctionName.values()) {
      result.put(storedFunctionName, new SimpleJdbcCall(jdbcTemplate).withSchemaName("product_api_v1")
          .withFunctionName(storedFunctionName.getFunctionName())
          .withoutProcedureColumnMetaDataAccess());
    }
    return result;
  }
}
