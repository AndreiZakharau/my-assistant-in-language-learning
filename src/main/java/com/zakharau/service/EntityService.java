package com.zakharau.service;

public interface EntityService<T> {

  T add(T t);

  String delete(String string);

  T update(T t);

}
