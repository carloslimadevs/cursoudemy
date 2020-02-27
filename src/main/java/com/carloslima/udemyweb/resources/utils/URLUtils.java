package com.carloslima.udemyweb.resources.utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class URLUtils {

	public static Set<String> stringsToCustomerContacts(String contacts){
		Set<String> collect = (Set<String>) Stream.of(contacts.split(","))
			      .map (elem -> new String(elem))
			      .collect(Collectors.toList());
		return collect;
		
		//return new HashSet<String>(Arrays.asList(contacts.split(",")));
	}


	public static void main(String[]args) {
	
		System.out.println(URLUtils.stringsToCustomerContacts("1232345,111111111,111111111"));
	}

}

