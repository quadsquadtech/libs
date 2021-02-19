package com.quadsquad.core.patterns;


import com.quadsquad.core.utils.ConstructorUtil;

public interface AbstractNullObject<T extends AbstractNullObject<T>> {

   default T ofNull() {

      try {
         return (T) ConstructorUtil.newInstanceOf( Class.forName(this.getClass().getName())) ;
      } catch (Exception e) {
         return null ;
      }
   }

   default boolean isNull() {
      return true ;
   }
}
