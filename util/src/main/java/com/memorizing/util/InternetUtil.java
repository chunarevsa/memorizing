package com.memorizing.util;

import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class InternetUtil {

    private final String apiGatewayServiceName;

    private final String coreServiceName;
    private final String gatewayPort;
    private String serviceAddress = null;

    public InternetUtil() {
        this.gatewayPort = null;
        this.apiGatewayServiceName = null;
        this.coreServiceName = null;
    }

    public String getServiceAddress() {
        if (serviceAddress == null) {
            serviceAddress = findMyHostname() + "/" + findMyIpAddress() + ":" + gatewayPort;
        }
        return serviceAddress;
    }

    private String findMyHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown host name";
        }
    }

    private String findMyIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown IP address";
        }
    }

    public String getCoreServiceName() {
        return coreServiceName;
    }

    public String getGatewayHost() {
        return apiGatewayServiceName + ":" + gatewayPort;
    }

}
