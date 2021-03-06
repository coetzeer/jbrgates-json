/*
 * JBRGates http://jgates.sourceforge.net/
 * Copyright (C) 2010 Afonso Brandao. (afonso.rbn@gmail.com)
 *
 * This library is free software. You can redistribute it
 * and/or modify it under the terms of the GNU General Public
 * License (GPL) version 3.0 or (at your option) any later
 * version.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/gpl.html
 *
 * Distributed WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 *
 */


package org.brandao.jbrgates;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.Test;
import junit.framework.TestCase;

/**
 *
 * @author Afonso Brandao
 */
public class JSONDecoderDateTest extends TestCase implements Test{

    public JSONDecoderDateTest(){
        super();
    }

    public void testDate() throws IOException, ParseException{
        Date date = new Date();
        date = DateTestHelper.dateFormat.parse(DateTestHelper.dateFormat.format(date));
        JSONDecoder jse = new JSONDecoder( DateTestHelper.dateFormat.format(date) );
        Date result = jse.decode( Date.class );
        assertEquals( date.getTime(), result.getTime() );
    }

    public void testTime() throws IOException, ParseException{
        Time time = new Time(System.currentTimeMillis());
        time = new Time(DateTestHelper.dateFormat.parse(DateTestHelper.dateFormat.format(time)).getTime());
        JSONDecoder jse = new JSONDecoder(DateTestHelper.dateFormat.format(time));
        Time result = jse.decode( Time.class );
        assertEquals( time.getTime(), result.getTime() );
    }

    public void testTimestamp() throws IOException, ParseException{
        Timestamp time = new Timestamp(System.currentTimeMillis());
        time = new Timestamp(DateTestHelper.dateFormat.parse(DateTestHelper.dateFormat.format(time)).getTime());
        JSONDecoder jse = new JSONDecoder(DateTestHelper.dateFormat.format(time));
        Timestamp result = jse.decode( Timestamp.class );
        assertEquals( time.getTime(), result.getTime() );
    }

    public void testCalendar() throws IOException, ParseException{
        Calendar time = new GregorianCalendar();
        time.setTime(
        		DateTestHelper.dateFormat.parse(
        				DateTestHelper.dateFormat.format(time.getTime())
				)
		);
        JSONDecoder jse = new JSONDecoder(DateTestHelper.dateFormat.format(time.getTime()) );
        Calendar result = jse.decode( Calendar.class );
        assertEquals( time.getTime(), result.getTime() );
    }

}
