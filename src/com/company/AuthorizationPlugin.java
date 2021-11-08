package com.company;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.security.AuthorizationBroker;
import org.apache.activemq.security.AuthorizationMap;

public class AuthorizationPlugin implements BrokerPlugin {
    private AuthorizationMap map;

    public AuthorizationPlugin() {
    }

    public AuthorizationPlugin(AuthorizationMap map) {
        this.map = map;
    }

    @Override
    public Broker installPlugin(Broker broker) {
        if (map == null) {
            throw new IllegalArgumentException("You must configure a 'map' property");
        }
        return new AuthorizationBroker(broker, map);
    }

    public AuthorizationMap getMap() {
        return map;
    }

    public void setMap(AuthorizationMap map) {
        this.map = map;
    }
}
