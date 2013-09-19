package org.neo4j.driver;

public class RemoteDriverTest extends DriverTest
{
    @Override
    public Driver initDb()
    {
        // TODO automate
        // run org.neo4j.driver.ServerStarter first
        return new RemoteDriver( "http://localhost:7474/" );
    }

    @Override
    public void cleanDb()
    {
    }
}