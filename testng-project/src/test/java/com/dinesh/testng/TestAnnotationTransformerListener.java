package com.dinesh.testng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestAnnotationTransformerListener implements IAnnotationTransformer {

	private final List<String> activeTestList;

	public TestAnnotationTransformerListener() {
		activeTestList = new ArrayList<String>();
		activeTestList.add("testCase1");
		activeTestList.add("testCase3");
		activeTestList.add("testCase5");
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		if (activeTestList.contains(testMethod.getName())) {
			annotation.setEnabled(true);
		} else {
			annotation.setEnabled(false);
		}
	}
}
