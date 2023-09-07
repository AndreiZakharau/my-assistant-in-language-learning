package com.zakharau.service;

public interface EntityService<T, K> {

  T add(K k);

  String delete(String string);

  T update(T t);

}
