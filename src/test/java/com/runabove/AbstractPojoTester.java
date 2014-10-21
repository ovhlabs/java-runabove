package com.runabove;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;

/*
 * Copyright (c) 2014, OVH

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.

 * Except as contained in this notice, the name of OVH and or its trademarks
 * (and among others RunAbove) shall not be used in advertising or otherwise to
 * promote the sale, use or other dealings in this Software without prior
 * written authorization from OVH.
 * Unit test for run above api
 * 
 * 
 */
/**
 * The Class AbstractPojoTester.
 */
public abstract class AbstractPojoTester {

	/** The test values. */
	private Map testValues = new HashMap();

	/**
	 * Adds the test value.
	 * 
	 * @param propertyType
	 *            the property type
	 * @param testValue
	 *            the test value
	 */
	protected void addTestValue(Class propertyType, Object testValue) {
		testValues.put(propertyType, testValue);
	}

	/**
	 * Sets the up test values.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUpTestValues() throws Exception {
		addTestValue(String.class, "foo");
		addTestValue(int.class, 123);
		addTestValue(Integer.class, 123);
		addTestValue(double.class, 123.0);
		addTestValue(Double.class, 123.0);
		addTestValue(boolean.class, true);
		addTestValue(Boolean.class, true);
		addTestValue(java.util.Date.class, new java.util.Date(100, 3, 4, 11, 45));
	}

	/**
	 * Call from subclass.
	 * 
	 * @param pojoClass
	 *            the pojo class
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws IntrospectionException 
	 * @throws InstantiationException 
	 */
	protected void testPojo(Class pojoClass) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, InstantiationException {
			Object pojo = pojoClass.newInstance();
			BeanInfo pojoInfo = Introspector.getBeanInfo(pojoClass);
			for (PropertyDescriptor propertyDescriptor : pojoInfo.getPropertyDescriptors()) {
				testProperty(pojo, propertyDescriptor);
			}
	}

	/**
	 * Test property.
	 * 
	 * @param pojo
	 *            the pojo
	 * @param propertyDescriptor
	 *            the property descriptor
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void testProperty(Object pojo, PropertyDescriptor propertyDescriptor) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Class propertyType = propertyDescriptor.getPropertyType();
			Object testValue = testValues.get(propertyType);
			if (testValue == null) {
				return;
			}
			Method writeMethod = propertyDescriptor.getWriteMethod();
			Method readMethod = propertyDescriptor.getReadMethod();
			if (readMethod != null && writeMethod != null) {
				writeMethod.invoke(pojo, testValue);
				Assert.assertEquals(readMethod.invoke(pojo), testValue);
			}
	}
}
