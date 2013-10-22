package org.neo4j.driver;

import java.util.Map;

import org.neo4j.driver.exceptions.ClientException;
import org.neo4j.driver.exceptions.DriverExceptionType;

import static java.lang.String.format;

public abstract class Type<JAVA_TYPE>
{
    public static final Type<Boolean> BOOLEAN = new Type<Boolean>()
    {
        @Override
        Boolean cast( Object raw )
        {
            return (Boolean)raw;
        }
    };
    public static final Type<Integer> INTEGER = new Type<Integer>()
    {
        @Override
        Integer cast( Object raw )
        {
            if ( raw instanceof Number )
            {
                return ( (Number) raw ).intValue();
            }
            else
            {
                throw new ClientException( DriverExceptionType.CLIENT_TYPE_CONVERSION,
                        format( "Cannot convert %s to %s.", describe( raw ), "integer" ));
            }
        }
    };
    public static final Type<Long> LONG = new Type<Long>()
    {
        @Override
        Long cast( Object raw )
        {
            if ( raw instanceof Number )
            {
                return ( (Number) raw ).longValue();
            }
            else
            {
                throw new ClientException( DriverExceptionType.CLIENT_TYPE_CONVERSION,
                        format( "Cannot convert %s to %s.", describe( raw ), "long" ));
            }
        }
    };
    public static final Type<Double> DOUBLE = new Type<Double>()
    {
        @Override
        Double cast( Object raw )
        {
            if ( raw instanceof Number )
            {
                return ( (Number) raw ).doubleValue();
            }
            else
            {
                throw new ClientException( DriverExceptionType.CLIENT_TYPE_CONVERSION,
                        format( "Cannot convert %s to %s.", describe( raw ), "double" ));
            }
        }
    };
    public static final Type<String> STRING = new Type<String>()
    {
        @Override
        String cast( Object raw )
        {
            return (String) raw;
        }
    };
    public static final Type<Map<String, Object>> MAP = new Type<Map<String, Object>>()
    {
        @Override
        Map<String, Object> cast( Object raw )
        {
            if ( raw instanceof Number )
            {
                return (Map<String, Object>) raw;
            }
            else
            {
                throw new ClientException( DriverExceptionType.CLIENT_TYPE_CONVERSION,
                        format( "Cannot convert %s to %s.", describe( raw ), "map" ));
            }
        }
    };

    abstract JAVA_TYPE cast( Object raw );

    private static String describe( Object object )
    {
        return object.getClass().getSimpleName();
    }
}