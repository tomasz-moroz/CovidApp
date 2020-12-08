package pl.covidapp.dao;

import java.util.List;

public interface AddressDaoInterface<T> {

    T get(Integer id);

    T save(T t);

    List<T> getByState(String state);

    List<T> getByCity(String city);

    List<T> getByZip(String zip);

    T update(Integer id, T t);

    void delete(Integer id);

    List<T> getAll();
}
