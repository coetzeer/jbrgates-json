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
import junit.framework.Test;
import junit.framework.TestCase;

/**
 *
 * @author Afonso Brandao
 */
public class JSONEncoderCharTest extends TestCase implements Test{

    public JSONEncoderCharTest(){
        super();
    }

    public void testCharUnicode() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( 'A' );
        assertEquals( "\"A\"", jse.toString() );
    }

    public void testChar() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\uffff' );
        assertEquals( "\"\\uffff\"", jse.toString() );
    }

    public void testCharSpace() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( ' ' );
        assertEquals( "\" \"", jse.toString() );
    }

    public void testQuantationMark() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\"' );
        assertEquals( "\"\\\"\"", jse.toString() );
    }

    public void testReverseSolidus() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\\' );
        assertEquals( "\"\\\\\"", jse.toString() );
    }

    public void testSolidus() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '/' );
        assertEquals( "\"\\/\"", jse.toString() );
    }

    public void testBackspace() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\b' );
        assertEquals( "\"\\b\"", jse.toString() );
    }

    public void testFormfeed() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\f' );
        assertEquals( "\"\\f\"", jse.toString() );
    }

    public void testNewLine() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\n' );
        assertEquals( "\"\\n\"", jse.toString() );
    }

    public void testCarriageReturn() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\r' );
        assertEquals( "\"\\r\"", jse.toString() );
    }

    public void testHorizontalTab() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\t' );
        assertEquals( "\"\\t\"", jse.toString() );
    }

    public void testHex() throws IOException{
        JSONEncoder jse = new JSONEncoder();
        jse.encode( '\u0fff' );
        assertEquals( "\"\\u0fff\"", jse.toString() );
    }

}
