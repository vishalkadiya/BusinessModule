package com.multiVendor.commonUtils;

import java.util.logging.Logger;

public interface LoggerService {
	static final Logger INFO = Logger.getLogger("info");
	static final Logger ERROR = Logger.getLogger("error");
	static final Logger DEBUG = Logger.getLogger("debug");
	static final Logger EXCEPTION = Logger.getLogger("exception");
	static final Logger PERFORMANCE = Logger.getLogger("performance");
	static final Logger SCHEDULER = Logger.getLogger("scheduler");
	static final String NO_IDENTIFICATION = "No Identification";
}
