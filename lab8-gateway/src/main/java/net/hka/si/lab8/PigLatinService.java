package net.hka.si.lab8;

import java.util.concurrent.Future;

public interface PigLatinService {
	//String translate(String english);
	
	// make the gateway asynchronous
	Future<String> translate(String english);
}
