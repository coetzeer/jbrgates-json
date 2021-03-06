/*
 * jBRGates http://jbrgates.brandao.org/
 * Copyright (C) 2006-2016 Afonso Brandao. (afonso.rbn@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.brandao.jbrgates;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/**
 * Defines the object that provides the necessary 
 * resources to encode and decode a Json objects.
 * 
 * <p>The method {@link #encode(Object)} convert a java object to json object.</p>
 * 
 * <pre>
 * Ex:
 *     double[] javaObject = new double[]{1.0,25.0};
 *     JsonContext context = new DefaultJsonContext();
 *     String jsonObject = context.encode(javaObject);
 *     
 * Output:
 * [1.0, 25.0]
 * </pre>
 *     
 * 
 * <pre>
 * Ex2:
 * 
 *     MyObject javaObject = new MyObject();
 *     javaObject.filed1 = 12L;
 *     javaObject.field2 = "Test";
 *     
 *     JsonContext context = new DefaultJsonContext();
 *     String jsonObject = context.encode(javaObject);
 *     
 * Output:
 * {"field1": 12, "field2": "Test"}
 * </pre>
 * 
 * <pre>
 * Ex3:
 * 
 *     MyObject javaObject = new MyObject();
 *     javaObject.filed1 = new Date();
 *     javaObject.filed2 = MyEnum.VALUE1;
 *     
 *     JsonContext context = new DefaultJsonContext();
 *     String jsonObject = context.encode(javaObject);
 *     
 * Output:
 * {"field1": "2016-08-06T12:30:00.000Z", "field2": "VALUE1"}
 * </pre>
 * 
 * <p>The method {@link #decode(String)} convert a json object to java object.</p>
 * 
 * <pre>
 * Ex:
 *     String jsonObject   = "[1.0, 25.0]";
 *     JsonContext context = new DefaultJsonContext();
 *     double[] javaObject = context.decode(jsonObject, double[].class);
 *     
 * </pre>
 * 
 * <pre>
 * Ex2:
 * 
 *     String jsonObject   = "{\"field1\": 12, \"field2\": \"Test\"};
 *     JsonContext context = new DefaultJsonContext();
 *     MyObject javaObject = context.decode(jsonObject, MyObject.class);
 *     
 * </pre>
 * 
 * @author Brandao
 * @version 1.1
 */
public interface JSONContext {

	/**
	 * Encodes an object into json.
	 * @param value Object.
	 * @return Json.
	 * @throws JSONException Thrown if a problem occurs when encoding.
	 */
    String encode(Object value) throws JSONException;

	/**
	 * Encodes an object into json.
	 * @param value Object.
	 * @param stream Stream.
	 * @throws JSONException Thrown if a problem occurs when encoding.
	 */
    void encode(Object value, OutputStream stream) throws JSONException;
    
    /**
     * Decodes a JSON object.
     * @param stream Stream.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(InputStream stream) throws JSONException;

    /**
     * Decode a JSON object to specific type.
	 * @param stream Stream.
     * @param type Type.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(InputStream stream, Class<?> type) throws JSONException;

    /**
     * Decode a JSON object to specific type.
	 * @param stream Stream.
     * @param type Type.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(InputStream stream, Type type) throws JSONException;
    
    /**
     * Decodes a JSON object in a specific collection type.
	 * @param stream Stream.
     * @param collectionType Collection type.
     * @param entityType Entity type.
     * @return Collection.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decodeCollection(InputStream stream, Type collectionType, Type entityType) throws JSONException;
    
    /**
     * Decodes a JSON object.
     * @param value Json object.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(String value) throws JSONException;

    /**
     * Decode a JSON object to specific type.
     * @param value Json object
     * @param type Type.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(String value, Class<?> type) throws JSONException;

    /**
     * Decode a JSON object to specific type.
     * @param value Json object
     * @param type Type.
     * @return Object.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decode(String value, Type type) throws JSONException;
    
    /**
     * Decodes a JSON object in a specific collection type.
     * @param collectionType Collection type.
     * @param entityType Entity type.
     * @return Collection.
     * @throws JSONException Thrown if a problem occurs when decoding.
     */
    Object decodeCollection( String value, Type collectionType,	Type entityType) throws JSONException;    
}
