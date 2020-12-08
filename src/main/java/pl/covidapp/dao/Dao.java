package pl.covidapp.dao;

import pl.covidapp.dto.PersonDto;

import java.util.List;

public interface Dao<T> {

    T get(Integer id);

    List<T> getByName(String name);

    T save(T t);

    T update(Integer id, T t);

    void delete(Integer id);

    List<T> getAll();
}
