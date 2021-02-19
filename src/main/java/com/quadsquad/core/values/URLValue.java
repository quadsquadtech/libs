package com.quadsquad.core.values;

import java.net.URL;

public class URLValue extends StringValue {

    public static final URLValue INVALID = new URLValue("") ;
    private StringValue protocol;
    private StringValue authority;
    private StringValue host;
    private IntegerValue port;
    private StringValue path;
    private UrlQueryParamsValue query;
    private StringValue file;
    private StringValue ref;

    private URLValue(String value) {
        super(value);
    }

    public static URLValue of(String value) {

        try {

            final URL url = new URL(value);
            final URLValue urlValue = new URLValue(value) ;

            urlValue.protocol = StringValue.of(url.getProtocol()) ;
            urlValue.authority = StringValue.of(url.getAuthority()) ;
            urlValue.host = StringValue.of(url.getHost()) ;
            urlValue.port = IntegerValue.of(url.getPort()) ;
            urlValue.path = StringValue.of(url.getPath()) ;
            urlValue.query = UrlQueryParamsValue.of(url.getQuery()) ;
            urlValue.file = StringValue.of(url.getFile()) ;
            urlValue.ref = StringValue.of(url.getRef()) ;

            return urlValue ;
        } catch (Exception e) {

            return INVALID ;
        }
    }

    public StringValue getProtocol() {
        return protocol;
    }

    public StringValue getAuthority() {
        return authority;
    }

    public StringValue getHost() {
        return host;
    }

    public IntegerValue getPort() {
        return port;
    }

    public StringValue getPath() {
        return path;
    }

    public UrlQueryParamsValue getQuery() {
        return query;
    }

    public StringValue getFile() {
        return file;
    }

    public StringValue getRef() {
        return ref;
    }


}
