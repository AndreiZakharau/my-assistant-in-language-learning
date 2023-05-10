package com.zakharau.service;

public interface EntityService<T> {

  T add(T t);

  String delete(T t);

  T update(T t);

}
