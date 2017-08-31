package org.springboot.batch01.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springboot.batch01.model.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>
{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setEMail(rs.getString("email"));

        logger.debug("user information: id:{}, firstname:{}, lastname:{}, email:{}", user.getId(), user.getFirstName(), user.getLastName(), user.getEMail());
        
        return user;
    }

}
