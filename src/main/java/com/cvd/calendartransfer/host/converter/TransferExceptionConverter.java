package com.cvd.calendartransfer.host.converter;

public interface TransferExceptionConverter {
	
	public Exception convert(final Exception exception, final Exception defaultException);

}
