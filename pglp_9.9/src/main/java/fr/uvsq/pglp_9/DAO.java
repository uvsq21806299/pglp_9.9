 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uvsq.pglp_9;

/**
 *
 * @author andri
 * @param <T>
 */
public interface DAO<T> {
    
    public int insert(T obj);
    public boolean delete(T obj);
    public void update(T obj);
    public void findAll();
    public Formes find(String name);
    public void move(T obj, int a, int b);
    
}
