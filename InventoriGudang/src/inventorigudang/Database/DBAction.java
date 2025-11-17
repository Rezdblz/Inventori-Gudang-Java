/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package inventorigudang.Database;

import java.util.List;
/**
 *
 * @author ASUS
 * @param <T>
 */
public interface DBAction<T> {
    void insert(T item);
    void update(T item);
    void delete(int id);
    T getById(int id);
    List<T> getAll();
}
