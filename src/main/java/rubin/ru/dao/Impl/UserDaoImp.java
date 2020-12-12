package rubin.ru.dao.Impl;

import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rubin.ru.dao.UserDao;
import rubin.ru.dao.mapper.RoleMapper;
import rubin.ru.dao.mapper.UserDtoMapper;
import rubin.ru.dao.mapper.UserMapper;
import rubin.ru.dto.UserDto;
import rubin.ru.model.Role;
import rubin.ru.model.User;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImp implements UserDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        String query = "SELECT u.id, u.username, u.password, u.role_id, r.name, u.full_name, u.email, u.last_login " +
                "FROM users u " +
                "INNER JOIN role r ON (u.role_id = r.id)";

        return namedParameterJdbcTemplate.query(query, new UserDtoMapper());
    }

    @Override
    public Long addUser(UserDto user) throws IllegalArgumentException {
        String query = "INSERT INTO users (username, password, role_id, full_name, email, last_login) " +
                "VALUES (:username, :password, :role_id, :full_name, :email, :last_login)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValues(createMapSqlWithValue(user));

        namedParameterJdbcTemplate.update(query, mapSqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long updateUser(Long id, UserDto user) throws IllegalArgumentException {
        List<String> param = new ArrayList<>();

        param.add(user.getUsername() == null ? null : "username = :username");
        param.add(user.getPassword() == null ? null : "password = :password");
        param.add(user.getRole().getId() == null ? null : "role_id = :role_id");
        param.add(user.getUsername() == null ? null : "full_name = :full_name");
        param.add(user.getEmail() == null ? null : "email = :email");
        param.add(user.getLastLogin() == null ? null : "last_login = :last_login");

        String setParam = Joiner.on(", ").skipNulls().join(param);

        String query = "UPDATE users " +
                "SET " + setParam +
                "WHERE id = :id";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValues(createMapSqlWithValue(user))
                .addValue("id", id);

        namedParameterJdbcTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    @Override
    public Long removeUser(Long id) {
        String query = "DELETE FROM users WHERE id = :id";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        namedParameterJdbcTemplate.update(query, sqlParameterSource);

        return id;
    }

    @Override
    public User getUserByUsernameForAuth(String username) {
        String query = "SELECT u.id, u.username, u.password, u.role_id, r.name " +
                "FROM users u " +
                "INNER JOIN role r ON (u.role_id = r.id)" +
                "WHERE u.username = :username";

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("username", username);

        return (User) namedParameterJdbcTemplate.queryForObject(query, sqlParameterSource, new UserMapper());
    }

    @Override
    public UserDto getUser(Long id) {
        String query = "SELECT u.id, u.username, u.role_id, r.name, u.full_name, u.email, u.last_login " +
                "FROM users u " +
                "INNER JOIN role r ON (u.role_id = r.id) " +
                "WHERE u.id = :id";

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        return (UserDto) namedParameterJdbcTemplate.queryForObject(query, sqlParameterSource, new UserDtoMapper());

    }

    @Override
    public Long updateLastLogin(String username) {
        String query = "UPDATE users SET last_login = :last_login " +
                "WHERE username = :username";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("last_login", LocalDateTime.now(ZoneOffset.UTC))
                .addValue("username", username);

        namedParameterJdbcTemplate.update(query, sqlParameterSource, keyHolder);

        return (Long) keyHolder.getKeyList().get(0).get("id");
    }

    // TODO: Проверить, возможно что можно вообще убрать try - catch
    private Long checkExitsRole(Role role) throws IllegalArgumentException {
        String query = "SELECT * FROM role WHERE id = :id AND name = :name";

        Long id = role.getId();

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("name", role.getName().toString());

        try {
            namedParameterJdbcTemplate.queryForObject(query, sqlParameterSource, new RoleMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Role does not exists");
        }

        return id;
    }

    private Map<String, Object> createMapSqlWithValue(UserDto user) throws IllegalArgumentException {
        Map<String, Object> mapSql = new HashMap<>();

        mapSql.put("username", user.getUsername());
        mapSql.put("full_name", user.getFullName());
        mapSql.put("email", user.getEmail());
        mapSql.put("last_login", user.getLastLogin());
        mapSql.put("role_id", checkExitsRole(user.getRole()));

        String password = user.getPassword();
        mapSql.put("password", passwordEncoder.encode(password == null ? "" : password));

        return mapSql;
    }

}
