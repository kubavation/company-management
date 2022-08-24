package com.durys.jakub.companymanagement.shared.sqlmappers;

import com.durys.jakub.companymanagement.shared.model.KeyValue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KeyValueMapper implements RowMapper<KeyValue> {

    @Override
    public KeyValue<?> mapRow(ResultSet rs, int rowNum) throws SQLException {
        return KeyValue.of(rs.getLong(1), rs.getString(2));
    }
}
