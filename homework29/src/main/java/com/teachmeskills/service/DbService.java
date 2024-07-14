package com.teachmeskills.service;

import com.teachmeskills.dto.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class DbService {
    private static volatile DbService instance;
    private List<Movie> movies;

    private DbService() {
    }

    public static DbService getInstance() {
        DbService localInstance = instance;
        if (localInstance == null) {
            synchronized (DbService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DbService();
                }
            }
        }
        return localInstance;
    }

    public List<Movie> getMovies() {
        movies = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("""
                    select * from movies;
                    """);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                UUID id = resultSet.getObject("id", UUID.class);
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int releaseYear = resultSet.getShort("release_year");
                boolean isView = resultSet.getBoolean("is_view");
                movies.add(new Movie(id, name, description, releaseYear, isView));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public void addMovie(String name,String description,Integer releaseYear,
                         Boolean isView) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    insert into movies(name,description,release_year,is_view)
                    values(?,?,?,?);
                    """);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setShort(3, releaseYear.shortValue());
            preparedStatement.setBoolean(4, isView);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Movie findByIdMovie(UUID id) {
        Movie movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst().orElseThrow();
        return movie;
    }

    public void deleteByIdMovie(UUID id) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from movies where id " +
                            "= ?");
            preparedStatement.setObject(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMovie(Movie movie) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update movies set name=?,description=?,release_year=?,is_view=? where id=?;");
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setShort(3, movie.getReleaseYear().shortValue());
            preparedStatement.setBoolean(4, movie.getIsView());
            preparedStatement.setObject(5, movie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost" +
                    "/movie?user=postgres&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
