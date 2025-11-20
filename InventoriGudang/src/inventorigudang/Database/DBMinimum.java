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
public interface DBMinimum<T> {
    T getById(int id);
    List<T> getAll();
}
