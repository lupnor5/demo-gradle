package com.example.demo;

import java.lang.annotation.*; 

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Conditionals {
	Conditional [] value(); 
}
