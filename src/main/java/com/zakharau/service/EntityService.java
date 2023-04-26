package com.zakharau.service;

public interface EntityService<T> {

  String add(T t);

  String delete(T t);

  T update(T t);

}
