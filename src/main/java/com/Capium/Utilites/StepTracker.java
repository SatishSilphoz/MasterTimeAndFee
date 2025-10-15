package com.Capium.Utilites;

public class StepTracker {
	
	 private static ThreadLocal<String> currentStep = new ThreadLocal<>();
		public static void setCurrentStep(String step) {
	        currentStep.set(step);
	    }

	    public static String getCurrentStep() {
	        return currentStep.get();
	    }

	    public static void clear() {
	        currentStep.remove();
	    }

}
