package cn.it.shop.dao;

import java.util.List;

public interface BaseDao<T> {
	public void save(T t);

	public void update(T t);
	
	public void delete(int id);
	
	public T get(int id);
	
	public List<T> query();

}
